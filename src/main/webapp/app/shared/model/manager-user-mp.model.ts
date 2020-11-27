import { IUucDepartmentTreeMp } from 'app/shared/model/uuc-department-tree-mp.model';
import { IFmpSubCompanyMp } from 'app/shared/model/fmp-sub-company-mp.model';
import { ManagerUserType } from 'app/shared/model/enumerations/manager-user-type.model';

export interface IManagerUserMp {
  id?: number;
  parentId?: number;
  type?: ManagerUserType;
  uucDepartmentTrees?: IUucDepartmentTreeMp[];
  fmpSubCompany?: IFmpSubCompanyMp;
}

export class ManagerUserMp implements IManagerUserMp {
  constructor(
    public id?: number,
    public parentId?: number,
    public type?: ManagerUserType,
    public uucDepartmentTrees?: IUucDepartmentTreeMp[],
    public fmpSubCompany?: IFmpSubCompanyMp
  ) {}
}
