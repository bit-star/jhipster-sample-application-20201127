import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IMicroAppGroupMp, MicroAppGroupMp } from 'app/shared/model/micro-app-group-mp.model';
import { MicroAppGroupMpService } from './micro-app-group-mp.service';
import { IFmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';
import { FmpMicroAppMpService } from 'app/entities/fmp-micro-app-mp/fmp-micro-app-mp.service';
import { IUucDepartmentTreeMp } from 'app/shared/model/uuc-department-tree-mp.model';
import { UucDepartmentTreeMpService } from 'app/entities/uuc-department-tree-mp/uuc-department-tree-mp.service';
import { IUucUserBaseinfoMp } from 'app/shared/model/uuc-user-baseinfo-mp.model';
import { UucUserBaseinfoMpService } from 'app/entities/uuc-user-baseinfo-mp/uuc-user-baseinfo-mp.service';
import { IFmpSubCompanyMp } from 'app/shared/model/fmp-sub-company-mp.model';
import { FmpSubCompanyMpService } from 'app/entities/fmp-sub-company-mp/fmp-sub-company-mp.service';

type SelectableEntity = IFmpMicroAppMp | IUucDepartmentTreeMp | IUucUserBaseinfoMp | IFmpSubCompanyMp;

type SelectableManyToManyEntity = IFmpMicroAppMp | IUucDepartmentTreeMp | IUucUserBaseinfoMp;

@Component({
  selector: 'jhi-micro-app-group-mp-update',
  templateUrl: './micro-app-group-mp-update.component.html',
})
export class MicroAppGroupMpUpdateComponent implements OnInit {
  isSaving = false;
  fmpmicroapps: IFmpMicroAppMp[] = [];
  uucdepartmenttrees: IUucDepartmentTreeMp[] = [];
  uucuserbaseinfos: IUucUserBaseinfoMp[] = [];
  fmpsubcompanies: IFmpSubCompanyMp[] = [];

  editForm = this.fb.group({
    id: [],
    name: [],
    fmpMicroApps: [],
    uucDepartmentTrees: [],
    uucUserBaseinfos: [],
    fmpSubCompany: [],
  });

  constructor(
    protected microAppGroupService: MicroAppGroupMpService,
    protected fmpMicroAppService: FmpMicroAppMpService,
    protected uucDepartmentTreeService: UucDepartmentTreeMpService,
    protected uucUserBaseinfoService: UucUserBaseinfoMpService,
    protected fmpSubCompanyService: FmpSubCompanyMpService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ microAppGroup }) => {
      this.updateForm(microAppGroup);

      this.fmpMicroAppService.query().subscribe((res: HttpResponse<IFmpMicroAppMp[]>) => (this.fmpmicroapps = res.body || []));

      this.uucDepartmentTreeService
        .query()
        .subscribe((res: HttpResponse<IUucDepartmentTreeMp[]>) => (this.uucdepartmenttrees = res.body || []));

      this.uucUserBaseinfoService.query().subscribe((res: HttpResponse<IUucUserBaseinfoMp[]>) => (this.uucuserbaseinfos = res.body || []));

      this.fmpSubCompanyService.query().subscribe((res: HttpResponse<IFmpSubCompanyMp[]>) => (this.fmpsubcompanies = res.body || []));
    });
  }

  updateForm(microAppGroup: IMicroAppGroupMp): void {
    this.editForm.patchValue({
      id: microAppGroup.id,
      name: microAppGroup.name,
      fmpMicroApps: microAppGroup.fmpMicroApps,
      uucDepartmentTrees: microAppGroup.uucDepartmentTrees,
      uucUserBaseinfos: microAppGroup.uucUserBaseinfos,
      fmpSubCompany: microAppGroup.fmpSubCompany,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const microAppGroup = this.createFromForm();
    if (microAppGroup.id !== undefined) {
      this.subscribeToSaveResponse(this.microAppGroupService.update(microAppGroup));
    } else {
      this.subscribeToSaveResponse(this.microAppGroupService.create(microAppGroup));
    }
  }

  private createFromForm(): IMicroAppGroupMp {
    return {
      ...new MicroAppGroupMp(),
      id: this.editForm.get(['id'])!.value,
      name: this.editForm.get(['name'])!.value,
      fmpMicroApps: this.editForm.get(['fmpMicroApps'])!.value,
      uucDepartmentTrees: this.editForm.get(['uucDepartmentTrees'])!.value,
      uucUserBaseinfos: this.editForm.get(['uucUserBaseinfos'])!.value,
      fmpSubCompany: this.editForm.get(['fmpSubCompany'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IMicroAppGroupMp>>): void {
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

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }

  getSelected(selectedVals: SelectableManyToManyEntity[], option: SelectableManyToManyEntity): SelectableManyToManyEntity {
    if (selectedVals) {
      for (let i = 0; i < selectedVals.length; i++) {
        if (option.id === selectedVals[i].id) {
          return selectedVals[i];
        }
      }
    }
    return option;
  }
}
