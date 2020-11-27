import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IUucDepartmentTreeMp, UucDepartmentTreeMp } from 'app/shared/model/uuc-department-tree-mp.model';
import { UucDepartmentTreeMpService } from './uuc-department-tree-mp.service';

@Component({
  selector: 'jhi-uuc-department-tree-mp-update',
  templateUrl: './uuc-department-tree-mp-update.component.html',
})
export class UucDepartmentTreeMpUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    name: [],
    namePy: [],
    code: [],
    parentDepId: [],
    parentDepName: [],
    status: [],
    disporder: [],
    namePath: [],
    codePath: [],
    depIdPath: [],
    depLevel: [],
    aliveFlag: [],
    recCreateTime: [],
    recCreator: [],
    recReviseTime: [],
    recRevisor: [],
    deptUserCount: [],
    microappId: [],
    enName: [],
    onlyCode: [],
    srcDeptId: [],
    srcDeptType: [],
    srcType: [],
    srcDeptUcode: [],
  });

  constructor(
    protected uucDepartmentTreeService: UucDepartmentTreeMpService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ uucDepartmentTree }) => {
      if (!uucDepartmentTree.id) {
        const today = moment().startOf('day');
        uucDepartmentTree.recCreateTime = today;
        uucDepartmentTree.recReviseTime = today;
      }

      this.updateForm(uucDepartmentTree);
    });
  }

  updateForm(uucDepartmentTree: IUucDepartmentTreeMp): void {
    this.editForm.patchValue({
      id: uucDepartmentTree.id,
      name: uucDepartmentTree.name,
      namePy: uucDepartmentTree.namePy,
      code: uucDepartmentTree.code,
      parentDepId: uucDepartmentTree.parentDepId,
      parentDepName: uucDepartmentTree.parentDepName,
      status: uucDepartmentTree.status,
      disporder: uucDepartmentTree.disporder,
      namePath: uucDepartmentTree.namePath,
      codePath: uucDepartmentTree.codePath,
      depIdPath: uucDepartmentTree.depIdPath,
      depLevel: uucDepartmentTree.depLevel,
      aliveFlag: uucDepartmentTree.aliveFlag,
      recCreateTime: uucDepartmentTree.recCreateTime ? uucDepartmentTree.recCreateTime.format(DATE_TIME_FORMAT) : null,
      recCreator: uucDepartmentTree.recCreator,
      recReviseTime: uucDepartmentTree.recReviseTime ? uucDepartmentTree.recReviseTime.format(DATE_TIME_FORMAT) : null,
      recRevisor: uucDepartmentTree.recRevisor,
      deptUserCount: uucDepartmentTree.deptUserCount,
      microappId: uucDepartmentTree.microappId,
      enName: uucDepartmentTree.enName,
      onlyCode: uucDepartmentTree.onlyCode,
      srcDeptId: uucDepartmentTree.srcDeptId,
      srcDeptType: uucDepartmentTree.srcDeptType,
      srcType: uucDepartmentTree.srcType,
      srcDeptUcode: uucDepartmentTree.srcDeptUcode,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const uucDepartmentTree = this.createFromForm();
    if (uucDepartmentTree.id !== undefined) {
      this.subscribeToSaveResponse(this.uucDepartmentTreeService.update(uucDepartmentTree));
    } else {
      this.subscribeToSaveResponse(this.uucDepartmentTreeService.create(uucDepartmentTree));
    }
  }

  private createFromForm(): IUucDepartmentTreeMp {
    return {
      ...new UucDepartmentTreeMp(),
      id: this.editForm.get(['id'])!.value,
      name: this.editForm.get(['name'])!.value,
      namePy: this.editForm.get(['namePy'])!.value,
      code: this.editForm.get(['code'])!.value,
      parentDepId: this.editForm.get(['parentDepId'])!.value,
      parentDepName: this.editForm.get(['parentDepName'])!.value,
      status: this.editForm.get(['status'])!.value,
      disporder: this.editForm.get(['disporder'])!.value,
      namePath: this.editForm.get(['namePath'])!.value,
      codePath: this.editForm.get(['codePath'])!.value,
      depIdPath: this.editForm.get(['depIdPath'])!.value,
      depLevel: this.editForm.get(['depLevel'])!.value,
      aliveFlag: this.editForm.get(['aliveFlag'])!.value,
      recCreateTime: this.editForm.get(['recCreateTime'])!.value
        ? moment(this.editForm.get(['recCreateTime'])!.value, DATE_TIME_FORMAT)
        : undefined,
      recCreator: this.editForm.get(['recCreator'])!.value,
      recReviseTime: this.editForm.get(['recReviseTime'])!.value
        ? moment(this.editForm.get(['recReviseTime'])!.value, DATE_TIME_FORMAT)
        : undefined,
      recRevisor: this.editForm.get(['recRevisor'])!.value,
      deptUserCount: this.editForm.get(['deptUserCount'])!.value,
      microappId: this.editForm.get(['microappId'])!.value,
      enName: this.editForm.get(['enName'])!.value,
      onlyCode: this.editForm.get(['onlyCode'])!.value,
      srcDeptId: this.editForm.get(['srcDeptId'])!.value,
      srcDeptType: this.editForm.get(['srcDeptType'])!.value,
      srcType: this.editForm.get(['srcType'])!.value,
      srcDeptUcode: this.editForm.get(['srcDeptUcode'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IUucDepartmentTreeMp>>): void {
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
}
