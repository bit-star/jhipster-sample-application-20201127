import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IBannerMp, BannerMp } from 'app/shared/model/banner-mp.model';
import { BannerMpService } from './banner-mp.service';
import { IFmpSubCompanyMp } from 'app/shared/model/fmp-sub-company-mp.model';
import { FmpSubCompanyMpService } from 'app/entities/fmp-sub-company-mp/fmp-sub-company-mp.service';

@Component({
  selector: 'jhi-banner-mp-update',
  templateUrl: './banner-mp-update.component.html',
})
export class BannerMpUpdateComponent implements OnInit {
  isSaving = false;
  fmpsubcompanies: IFmpSubCompanyMp[] = [];

  editForm = this.fb.group({
    id: [],
    rank: [],
    type: [],
    status: [],
    pathUrl: [],
    bannerUrl: [],
    remark: [],
    fmpSubCompany: [],
  });

  constructor(
    protected bannerService: BannerMpService,
    protected fmpSubCompanyService: FmpSubCompanyMpService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ banner }) => {
      this.updateForm(banner);

      this.fmpSubCompanyService.query().subscribe((res: HttpResponse<IFmpSubCompanyMp[]>) => (this.fmpsubcompanies = res.body || []));
    });
  }

  updateForm(banner: IBannerMp): void {
    this.editForm.patchValue({
      id: banner.id,
      rank: banner.rank,
      type: banner.type,
      status: banner.status,
      pathUrl: banner.pathUrl,
      bannerUrl: banner.bannerUrl,
      remark: banner.remark,
      fmpSubCompany: banner.fmpSubCompany,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const banner = this.createFromForm();
    if (banner.id !== undefined) {
      this.subscribeToSaveResponse(this.bannerService.update(banner));
    } else {
      this.subscribeToSaveResponse(this.bannerService.create(banner));
    }
  }

  private createFromForm(): IBannerMp {
    return {
      ...new BannerMp(),
      id: this.editForm.get(['id'])!.value,
      rank: this.editForm.get(['rank'])!.value,
      type: this.editForm.get(['type'])!.value,
      status: this.editForm.get(['status'])!.value,
      pathUrl: this.editForm.get(['pathUrl'])!.value,
      bannerUrl: this.editForm.get(['bannerUrl'])!.value,
      remark: this.editForm.get(['remark'])!.value,
      fmpSubCompany: this.editForm.get(['fmpSubCompany'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IBannerMp>>): void {
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
