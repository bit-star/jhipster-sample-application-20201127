import { Moment } from 'moment';
import { IFmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';
import { IMicroAppGroupMp } from 'app/shared/model/micro-app-group-mp.model';

export interface IUucUserBaseinfoMp {
  id?: number;
  jobCode?: string;
  type?: string;
  fullname?: string;
  namePy?: string;
  sex?: string;
  birthday?: string;
  email?: string;
  tel?: string;
  telExt?: string;
  stateCode1?: string;
  mobile1?: string;
  stateCode2?: string;
  mobile2?: string;
  stateCode3?: string;
  mobile3?: string;
  stateCode4?: string;
  mobile4?: string;
  stateCode5?: string;
  mobile5?: string;
  titleDesc?: string;
  titleEn?: string;
  checkNum?: string;
  disporder?: number;
  workPlace?: string;
  userLevel?: string;
  hiredate?: Moment;
  nickname?: string;
  memo?: string;
  isHidden?: string;
  aliveFlag?: string;
  recCreateTime?: Moment;
  recCreator?: string;
  recReviseTime?: Moment;
  recRevisor?: string;
  isActivated?: string;
  activationTime?: Moment;
  appVersion?: string;
  isOnlyAdminTitle?: string;
  jobnumber?: string;
  avatar?: string;
  enName?: string;
  enWorkplace?: string;
  enTitleDesc?: string;
  onlyCode?: string;
  hrCardId?: string;
  employeeType?: string;
  collectionFmpMicroApps?: IFmpMicroAppMp[];
  microAppGroup?: IMicroAppGroupMp;
  usableFmpMicroApps?: IFmpMicroAppMp[];
}

export class UucUserBaseinfoMp implements IUucUserBaseinfoMp {
  constructor(
    public id?: number,
    public jobCode?: string,
    public type?: string,
    public fullname?: string,
    public namePy?: string,
    public sex?: string,
    public birthday?: string,
    public email?: string,
    public tel?: string,
    public telExt?: string,
    public stateCode1?: string,
    public mobile1?: string,
    public stateCode2?: string,
    public mobile2?: string,
    public stateCode3?: string,
    public mobile3?: string,
    public stateCode4?: string,
    public mobile4?: string,
    public stateCode5?: string,
    public mobile5?: string,
    public titleDesc?: string,
    public titleEn?: string,
    public checkNum?: string,
    public disporder?: number,
    public workPlace?: string,
    public userLevel?: string,
    public hiredate?: Moment,
    public nickname?: string,
    public memo?: string,
    public isHidden?: string,
    public aliveFlag?: string,
    public recCreateTime?: Moment,
    public recCreator?: string,
    public recReviseTime?: Moment,
    public recRevisor?: string,
    public isActivated?: string,
    public activationTime?: Moment,
    public appVersion?: string,
    public isOnlyAdminTitle?: string,
    public jobnumber?: string,
    public avatar?: string,
    public enName?: string,
    public enWorkplace?: string,
    public enTitleDesc?: string,
    public onlyCode?: string,
    public hrCardId?: string,
    public employeeType?: string,
    public collectionFmpMicroApps?: IFmpMicroAppMp[],
    public microAppGroup?: IMicroAppGroupMp,
    public usableFmpMicroApps?: IFmpMicroAppMp[]
  ) {}
}
