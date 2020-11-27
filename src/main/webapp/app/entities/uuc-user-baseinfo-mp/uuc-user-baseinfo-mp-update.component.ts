import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IUucUserBaseinfoMp, UucUserBaseinfoMp } from 'app/shared/model/uuc-user-baseinfo-mp.model';
import { UucUserBaseinfoMpService } from './uuc-user-baseinfo-mp.service';
import { IFmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';
import { FmpMicroAppMpService } from 'app/entities/fmp-micro-app-mp/fmp-micro-app-mp.service';

@Component({
  selector: 'jhi-uuc-user-baseinfo-mp-update',
  templateUrl: './uuc-user-baseinfo-mp-update.component.html',
})
export class UucUserBaseinfoMpUpdateComponent implements OnInit {
  isSaving = false;
  fmpmicroapps: IFmpMicroAppMp[] = [];

  editForm = this.fb.group({
    id: [],
    jobCode: [],
    type: [],
    fullname: [],
    namePy: [],
    sex: [],
    birthday: [],
    email: [],
    tel: [],
    telExt: [],
    stateCode1: [],
    mobile1: [],
    stateCode2: [],
    mobile2: [],
    stateCode3: [],
    mobile3: [],
    stateCode4: [],
    mobile4: [],
    stateCode5: [],
    mobile5: [],
    titleDesc: [],
    titleEn: [],
    checkNum: [],
    disporder: [],
    workPlace: [],
    userLevel: [],
    hiredate: [],
    nickname: [],
    memo: [],
    isHidden: [],
    aliveFlag: [],
    recCreateTime: [],
    recCreator: [],
    recReviseTime: [],
    recRevisor: [],
    isActivated: [],
    activationTime: [],
    appVersion: [],
    isOnlyAdminTitle: [],
    jobnumber: [],
    avatar: [],
    enName: [],
    enWorkplace: [],
    enTitleDesc: [],
    onlyCode: [],
    hrCardId: [],
    employeeType: [],
    collectionFmpMicroApps: [],
  });

  constructor(
    protected uucUserBaseinfoService: UucUserBaseinfoMpService,
    protected fmpMicroAppService: FmpMicroAppMpService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ uucUserBaseinfo }) => {
      if (!uucUserBaseinfo.id) {
        const today = moment().startOf('day');
        uucUserBaseinfo.hiredate = today;
        uucUserBaseinfo.recCreateTime = today;
        uucUserBaseinfo.recReviseTime = today;
        uucUserBaseinfo.activationTime = today;
      }

      this.updateForm(uucUserBaseinfo);

      this.fmpMicroAppService.query().subscribe((res: HttpResponse<IFmpMicroAppMp[]>) => (this.fmpmicroapps = res.body || []));
    });
  }

  updateForm(uucUserBaseinfo: IUucUserBaseinfoMp): void {
    this.editForm.patchValue({
      id: uucUserBaseinfo.id,
      jobCode: uucUserBaseinfo.jobCode,
      type: uucUserBaseinfo.type,
      fullname: uucUserBaseinfo.fullname,
      namePy: uucUserBaseinfo.namePy,
      sex: uucUserBaseinfo.sex,
      birthday: uucUserBaseinfo.birthday,
      email: uucUserBaseinfo.email,
      tel: uucUserBaseinfo.tel,
      telExt: uucUserBaseinfo.telExt,
      stateCode1: uucUserBaseinfo.stateCode1,
      mobile1: uucUserBaseinfo.mobile1,
      stateCode2: uucUserBaseinfo.stateCode2,
      mobile2: uucUserBaseinfo.mobile2,
      stateCode3: uucUserBaseinfo.stateCode3,
      mobile3: uucUserBaseinfo.mobile3,
      stateCode4: uucUserBaseinfo.stateCode4,
      mobile4: uucUserBaseinfo.mobile4,
      stateCode5: uucUserBaseinfo.stateCode5,
      mobile5: uucUserBaseinfo.mobile5,
      titleDesc: uucUserBaseinfo.titleDesc,
      titleEn: uucUserBaseinfo.titleEn,
      checkNum: uucUserBaseinfo.checkNum,
      disporder: uucUserBaseinfo.disporder,
      workPlace: uucUserBaseinfo.workPlace,
      userLevel: uucUserBaseinfo.userLevel,
      hiredate: uucUserBaseinfo.hiredate ? uucUserBaseinfo.hiredate.format(DATE_TIME_FORMAT) : null,
      nickname: uucUserBaseinfo.nickname,
      memo: uucUserBaseinfo.memo,
      isHidden: uucUserBaseinfo.isHidden,
      aliveFlag: uucUserBaseinfo.aliveFlag,
      recCreateTime: uucUserBaseinfo.recCreateTime ? uucUserBaseinfo.recCreateTime.format(DATE_TIME_FORMAT) : null,
      recCreator: uucUserBaseinfo.recCreator,
      recReviseTime: uucUserBaseinfo.recReviseTime ? uucUserBaseinfo.recReviseTime.format(DATE_TIME_FORMAT) : null,
      recRevisor: uucUserBaseinfo.recRevisor,
      isActivated: uucUserBaseinfo.isActivated,
      activationTime: uucUserBaseinfo.activationTime ? uucUserBaseinfo.activationTime.format(DATE_TIME_FORMAT) : null,
      appVersion: uucUserBaseinfo.appVersion,
      isOnlyAdminTitle: uucUserBaseinfo.isOnlyAdminTitle,
      jobnumber: uucUserBaseinfo.jobnumber,
      avatar: uucUserBaseinfo.avatar,
      enName: uucUserBaseinfo.enName,
      enWorkplace: uucUserBaseinfo.enWorkplace,
      enTitleDesc: uucUserBaseinfo.enTitleDesc,
      onlyCode: uucUserBaseinfo.onlyCode,
      hrCardId: uucUserBaseinfo.hrCardId,
      employeeType: uucUserBaseinfo.employeeType,
      collectionFmpMicroApps: uucUserBaseinfo.collectionFmpMicroApps,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const uucUserBaseinfo = this.createFromForm();
    if (uucUserBaseinfo.id !== undefined) {
      this.subscribeToSaveResponse(this.uucUserBaseinfoService.update(uucUserBaseinfo));
    } else {
      this.subscribeToSaveResponse(this.uucUserBaseinfoService.create(uucUserBaseinfo));
    }
  }

  private createFromForm(): IUucUserBaseinfoMp {
    return {
      ...new UucUserBaseinfoMp(),
      id: this.editForm.get(['id'])!.value,
      jobCode: this.editForm.get(['jobCode'])!.value,
      type: this.editForm.get(['type'])!.value,
      fullname: this.editForm.get(['fullname'])!.value,
      namePy: this.editForm.get(['namePy'])!.value,
      sex: this.editForm.get(['sex'])!.value,
      birthday: this.editForm.get(['birthday'])!.value,
      email: this.editForm.get(['email'])!.value,
      tel: this.editForm.get(['tel'])!.value,
      telExt: this.editForm.get(['telExt'])!.value,
      stateCode1: this.editForm.get(['stateCode1'])!.value,
      mobile1: this.editForm.get(['mobile1'])!.value,
      stateCode2: this.editForm.get(['stateCode2'])!.value,
      mobile2: this.editForm.get(['mobile2'])!.value,
      stateCode3: this.editForm.get(['stateCode3'])!.value,
      mobile3: this.editForm.get(['mobile3'])!.value,
      stateCode4: this.editForm.get(['stateCode4'])!.value,
      mobile4: this.editForm.get(['mobile4'])!.value,
      stateCode5: this.editForm.get(['stateCode5'])!.value,
      mobile5: this.editForm.get(['mobile5'])!.value,
      titleDesc: this.editForm.get(['titleDesc'])!.value,
      titleEn: this.editForm.get(['titleEn'])!.value,
      checkNum: this.editForm.get(['checkNum'])!.value,
      disporder: this.editForm.get(['disporder'])!.value,
      workPlace: this.editForm.get(['workPlace'])!.value,
      userLevel: this.editForm.get(['userLevel'])!.value,
      hiredate: this.editForm.get(['hiredate'])!.value ? moment(this.editForm.get(['hiredate'])!.value, DATE_TIME_FORMAT) : undefined,
      nickname: this.editForm.get(['nickname'])!.value,
      memo: this.editForm.get(['memo'])!.value,
      isHidden: this.editForm.get(['isHidden'])!.value,
      aliveFlag: this.editForm.get(['aliveFlag'])!.value,
      recCreateTime: this.editForm.get(['recCreateTime'])!.value
        ? moment(this.editForm.get(['recCreateTime'])!.value, DATE_TIME_FORMAT)
        : undefined,
      recCreator: this.editForm.get(['recCreator'])!.value,
      recReviseTime: this.editForm.get(['recReviseTime'])!.value
        ? moment(this.editForm.get(['recReviseTime'])!.value, DATE_TIME_FORMAT)
        : undefined,
      recRevisor: this.editForm.get(['recRevisor'])!.value,
      isActivated: this.editForm.get(['isActivated'])!.value,
      activationTime: this.editForm.get(['activationTime'])!.value
        ? moment(this.editForm.get(['activationTime'])!.value, DATE_TIME_FORMAT)
        : undefined,
      appVersion: this.editForm.get(['appVersion'])!.value,
      isOnlyAdminTitle: this.editForm.get(['isOnlyAdminTitle'])!.value,
      jobnumber: this.editForm.get(['jobnumber'])!.value,
      avatar: this.editForm.get(['avatar'])!.value,
      enName: this.editForm.get(['enName'])!.value,
      enWorkplace: this.editForm.get(['enWorkplace'])!.value,
      enTitleDesc: this.editForm.get(['enTitleDesc'])!.value,
      onlyCode: this.editForm.get(['onlyCode'])!.value,
      hrCardId: this.editForm.get(['hrCardId'])!.value,
      employeeType: this.editForm.get(['employeeType'])!.value,
      collectionFmpMicroApps: this.editForm.get(['collectionFmpMicroApps'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IUucUserBaseinfoMp>>): void {
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

  trackById(index: number, item: IFmpMicroAppMp): any {
    return item.id;
  }

  getSelected(selectedVals: IFmpMicroAppMp[], option: IFmpMicroAppMp): IFmpMicroAppMp {
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
