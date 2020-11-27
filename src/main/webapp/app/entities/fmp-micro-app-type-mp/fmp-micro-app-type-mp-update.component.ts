import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IFmpMicroAppTypeMp, FmpMicroAppTypeMp } from 'app/shared/model/fmp-micro-app-type-mp.model';
import { FmpMicroAppTypeMpService } from './fmp-micro-app-type-mp.service';
import { IFmpSubCompanyMp } from 'app/shared/model/fmp-sub-company-mp.model';
import { FmpSubCompanyMpService } from 'app/entities/fmp-sub-company-mp/fmp-sub-company-mp.service';

@Component({
  selector: 'jhi-fmp-micro-app-type-mp-update',
  templateUrl: './fmp-micro-app-type-mp-update.component.html',
})
export class FmpMicroAppTypeMpUpdateComponent implements OnInit {
  isSaving = false;
  fmpsubcompanies: IFmpSubCompanyMp[] = [];

  editForm = this.fb.group({
    id: [],
    code: [],
    name: [],
    language: [],
    portalId: [],
    isDeleted: [],
    fmpSubCompany: [],
  });

  constructor(
    protected fmpMicroAppTypeService: FmpMicroAppTypeMpService,
    protected fmpSubCompanyService: FmpSubCompanyMpService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ fmpMicroAppType }) => {
      this.updateForm(fmpMicroAppType);

      this.fmpSubCompanyService.query().subscribe((res: HttpResponse<IFmpSubCompanyMp[]>) => (this.fmpsubcompanies = res.body || []));
    });
  }

  updateForm(fmpMicroAppType: IFmpMicroAppTypeMp): void {
    this.editForm.patchValue({
      id: fmpMicroAppType.id,
      code: fmpMicroAppType.code,
      name: fmpMicroAppType.name,
      language: fmpMicroAppType.language,
      portalId: fmpMicroAppType.portalId,
      isDeleted: fmpMicroAppType.isDeleted,
      fmpSubCompany: fmpMicroAppType.fmpSubCompany,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const fmpMicroAppType = this.createFromForm();
    if (fmpMicroAppType.id !== undefined) {
      this.subscribeToSaveResponse(this.fmpMicroAppTypeService.update(fmpMicroAppType));
    } else {
      this.subscribeToSaveResponse(this.fmpMicroAppTypeService.create(fmpMicroAppType));
    }
  }

  private createFromForm(): IFmpMicroAppTypeMp {
    return {
      ...new FmpMicroAppTypeMp(),
      id: this.editForm.get(['id'])!.value,
      code: this.editForm.get(['code'])!.value,
      name: this.editForm.get(['name'])!.value,
      language: this.editForm.get(['language'])!.value,
      portalId: this.editForm.get(['portalId'])!.value,
      isDeleted: this.editForm.get(['isDeleted'])!.value,
      fmpSubCompany: this.editForm.get(['fmpSubCompany'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IFmpMicroAppTypeMp>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: IFmpSubCompanyMp): any {
    return item.id;
  }
}
