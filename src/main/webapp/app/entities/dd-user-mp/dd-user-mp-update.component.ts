import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IDdUserMp, DdUserMp } from 'app/shared/model/dd-user-mp.model';
import { DdUserMpService } from './dd-user-mp.service';

@Component({
  selector: 'jhi-dd-user-mp-update',
  templateUrl: './dd-user-mp-update.component.html',
})
export class DdUserMpUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    unionid: [],
    remark: [],
    userid: [],
    isLeaderInDepts: [],
    isBoss: [],
    hiredDate: [],
    isSenior: [],
    tel: [],
    department: [],
    workPlace: [],
    orderInDepts: [],
    mobile: [],
    errmsg: [],
    active: [],
    avatar: [],
    isAdmin: [],
    isHide: [],
    jobnumber: [],
    name: [],
    extattr: [],
    stateCode: [],
    position: [],
    roles: [],
  });

  constructor(protected ddUserService: DdUserMpService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ ddUser }) => {
      this.updateForm(ddUser);
    });
  }

  updateForm(ddUser: IDdUserMp): void {
    this.editForm.patchValue({
      id: ddUser.id,
      unionid: ddUser.unionid,
      remark: ddUser.remark,
      userid: ddUser.userid,
      isLeaderInDepts: ddUser.isLeaderInDepts,
      isBoss: ddUser.isBoss,
      hiredDate: ddUser.hiredDate,
      isSenior: ddUser.isSenior,
      tel: ddUser.tel,
      department: ddUser.department,
      workPlace: ddUser.workPlace,
      orderInDepts: ddUser.orderInDepts,
      mobile: ddUser.mobile,
      errmsg: ddUser.errmsg,
      active: ddUser.active,
      avatar: ddUser.avatar,
      isAdmin: ddUser.isAdmin,
      isHide: ddUser.isHide,
      jobnumber: ddUser.jobnumber,
      name: ddUser.name,
      extattr: ddUser.extattr,
      stateCode: ddUser.stateCode,
      position: ddUser.position,
      roles: ddUser.roles,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const ddUser = this.createFromForm();
    if (ddUser.id !== undefined) {
      this.subscribeToSaveResponse(this.ddUserService.update(ddUser));
    } else {
      this.subscribeToSaveResponse(this.ddUserService.create(ddUser));
    }
  }

  private createFromForm(): IDdUserMp {
    return {
      ...new DdUserMp(),
      id: this.editForm.get(['id'])!.value,
      unionid: this.editForm.get(['unionid'])!.value,
      remark: this.editForm.get(['remark'])!.value,
      userid: this.editForm.get(['userid'])!.value,
      isLeaderInDepts: this.editForm.get(['isLeaderInDepts'])!.value,
      isBoss: this.editForm.get(['isBoss'])!.value,
      hiredDate: this.editForm.get(['hiredDate'])!.value,
      isSenior: this.editForm.get(['isSenior'])!.value,
      tel: this.editForm.get(['tel'])!.value,
      department: this.editForm.get(['department'])!.value,
      workPlace: this.editForm.get(['workPlace'])!.value,
      orderInDepts: this.editForm.get(['orderInDepts'])!.value,
      mobile: this.editForm.get(['mobile'])!.value,
      errmsg: this.editForm.get(['errmsg'])!.value,
      active: this.editForm.get(['active'])!.value,
      avatar: this.editForm.get(['avatar'])!.value,
      isAdmin: this.editForm.get(['isAdmin'])!.value,
      isHide: this.editForm.get(['isHide'])!.value,
      jobnumber: this.editForm.get(['jobnumber'])!.value,
      name: this.editForm.get(['name'])!.value,
      extattr: this.editForm.get(['extattr'])!.value,
      stateCode: this.editForm.get(['stateCode'])!.value,
      position: this.editForm.get(['position'])!.value,
      roles: this.editForm.get(['roles'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IDdUserMp>>): void {
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
