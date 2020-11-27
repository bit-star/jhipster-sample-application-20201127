import { IFmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';
import { IUucDepartmentTreeMp } from 'app/shared/model/uuc-department-tree-mp.model';
import { IUucUserBaseinfoMp } from 'app/shared/model/uuc-user-baseinfo-mp.model';
import { IFmpSubCompanyMp } from 'app/shared/model/fmp-sub-company-mp.model';

export interface IMicroAppGroupMp {
  id?: number;
  name?: string;
  fmpMicroApps?: IFmpMicroAppMp[];
  uucDepartmentTrees?: IUucDepartmentTreeMp[];
  uucUserBaseinfos?: IUucUserBaseinfoMp[];
  fmpSubCompany?: IFmpSubCompanyMp;
}

export class MicroAppGroupMp implements IMicroAppGroupMp {
  constructor(
    public id?: number,
    public name?: string,
    public fmpMicroApps?: IFmpMicroAppMp[],
    public uucDepartmentTrees?: IUucDepartmentTreeMp[],
    public uucUserBaseinfos?: IUucUserBaseinfoMp[],
    public fmpSubCompany?: IFmpSubCompanyMp
  ) {}
}
