import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IManagerUserMp, ManagerUserMp } from 'app/shared/model/manager-user-mp.model';
import { ManagerUserMpService } from './manager-user-mp.service';
import { IUucDepartmentTreeMp } from 'app/shared/model/uuc-department-tree-mp.model';
import { UucDepartmentTreeMpService } from 'app/entities/uuc-department-tree-mp/uuc-department-tree-mp.service';
import { IFmpSubCompanyMp } from 'app/shared/model/fmp-sub-company-mp.model';
import { FmpSubCompanyMpService } from 'app/entities/fmp-sub-company-mp/fmp-sub-company-mp.service';

type SelectableEntity = IUucDepartmentTreeMp | IFmpSubCompanyMp;

@Component({
  selector: 'jhi-manager-user-mp-update',
  templateUrl: './manager-user-mp-update.component.html',
})
export class ManagerUserMpUpdateComponent implements OnInit {
  isSaving = false;
  uucdepartmenttrees: IUucDepartmentTreeMp[] = [];
  fmpsubcompanies: IFmpSubCompanyMp[] = [];

  editForm = this.fb.group({
    id: [],
    parentId: [],
    type: [],
    uucDepartmentTrees: [],
    fmpSubCompany: [],
  });

  constructor(
    protected managerUserService: ManagerUserMpService,
    protected uucDepartmentTreeService: UucDepartmentTreeMpService,
    protected fmpSubCompanyService: FmpSubCompanyMpService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ managerUser }) => {
      this.updateForm(managerUser);

      this.uucDepartmentTreeService
        .query()
        .subscribe((res: HttpResponse<IUucDepartmentTreeMp[]>) => (this.uucdepartmenttrees = res.body || []));

      this.fmpSubCompanyService.query().subscribe((res: HttpResponse<IFmpSubCompanyMp[]>) => (this.fmpsubcompanies = res.body || []));
    });
  }

  updateForm(managerUser: IManagerUserMp): void {
    this.editForm.patchValue({
      id: managerUser.id,
      parentId: managerUser.parentId,
      type: managerUser.type,
      uucDepartmentTrees: managerUser.uucDepartmentTrees,
      fmpSubCompany: managerUser.fmpSubCompany,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const managerUser = this.createFromForm();
    if (managerUser.id !== undefined) {
      this.subscribeToSaveResponse(this.managerUserService.update(managerUser));
    } else {
      this.subscribeToSaveResponse(this.managerUserService.create(managerUser));
    }
  }

  private createFromForm(): IManagerUserMp {
    return {
      ...new ManagerUserMp(),
      id: this.editForm.get(['id'])!.value,
      parentId: this.editForm.get(['parentId'])!.value,
      type: this.editForm.get(['type'])!.value,
      uucDepartmentTrees: this.editForm.get(['uucDepartmentTrees'])!.value,
      fmpSubCompany: this.editForm.get(['fmpSubCompany'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IManagerUserMp>>): void {
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

  getSelected(selectedVals: IUucDepartmentTreeMp[], option: IUucDepartmentTreeMp): IUucDepartmentTreeMp {
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
