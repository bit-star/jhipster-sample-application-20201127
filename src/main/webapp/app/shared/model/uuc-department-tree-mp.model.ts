import { Moment } from 'moment';
import { IFmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';
import { IManagerUserMp } from 'app/shared/model/manager-user-mp.model';
import { IFmpSubCompanyMp } from 'app/shared/model/fmp-sub-company-mp.model';
import { IMicroAppGroupMp } from 'app/shared/model/micro-app-group-mp.model';

export interface IUucDepartmentTreeMp {
  id?: number;
  name?: string;
  namePy?: string;
  code?: string;
  parentDepId?: string;
  parentDepName?: string;
  status?: string;
  disporder?: string;
  namePath?: string;
  codePath?: string;
  depIdPath?: string;
  depLevel?: string;
  aliveFlag?: string;
  recCreateTime?: Moment;
  recCreator?: string;
  recReviseTime?: Moment;
  recRevisor?: string;
  deptUserCount?: string;
  microappId?: string;
  enName?: string;
  onlyCode?: string;
  srcDeptId?: string;
  srcDeptType?: string;
  srcType?: string;
  srcDeptUcode?: string;
  usables?: IFmpMicroAppMp[];
  managers?: IManagerUserMp[];
  fmpSubCompanies?: IFmpSubCompanyMp[];
  microAppGroups?: IMicroAppGroupMp[];
}

export class UucDepartmentTreeMp implements IUucDepartmentTreeMp {
  constructor(
    public id?: number,
    public name?: string,
    public namePy?: string,
    public code?: string,
    public parentDepId?: string,
    public parentDepName?: string,
    public status?: string,
    public disporder?: string,
    public namePath?: string,
    public codePath?: string,
    public depIdPath?: string,
    public depLevel?: string,
    public aliveFlag?: string,
    public recCreateTime?: Moment,
    public recCreator?: string,
    public recReviseTime?: Moment,
    public recRevisor?: string,
    public deptUserCount?: string,
    public microappId?: string,
    public enName?: string,
    public onlyCode?: string,
    public srcDeptId?: string,
    public srcDeptType?: string,
    public srcType?: string,
    public srcDeptUcode?: string,
    public usables?: IFmpMicroAppMp[],
    public managers?: IManagerUserMp[],
    public fmpSubCompanies?: IFmpSubCompanyMp[],
    public microAppGroups?: IMicroAppGroupMp[]
  ) {}
}
