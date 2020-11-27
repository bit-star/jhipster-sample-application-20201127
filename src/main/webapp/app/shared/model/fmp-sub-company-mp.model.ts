import { IManagerUserMp } from 'app/shared/model/manager-user-mp.model';
import { IBannerMp } from 'app/shared/model/banner-mp.model';
import { IFmpMicroAppTypeMp } from 'app/shared/model/fmp-micro-app-type-mp.model';
import { IFmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';
import { IMicroAppGroupMp } from 'app/shared/model/micro-app-group-mp.model';
import { IUucDepartmentTreeMp } from 'app/shared/model/uuc-department-tree-mp.model';

export interface IFmpSubCompanyMp {
  id?: number;
  name?: string;
  code?: string;
  adminGroupId?: string;
  ifPublic?: string;
  styleId?: string;
  isDeleted?: boolean;
  managerUsers?: IManagerUserMp[];
  banners?: IBannerMp[];
  fmpMicroAppTypes?: IFmpMicroAppTypeMp[];
  createdApps?: IFmpMicroAppMp[];
  microAppGroups?: IMicroAppGroupMp[];
  fmpMicroApps?: IFmpMicroAppMp[];
  uucDepartmentTrees?: IUucDepartmentTreeMp[];
}

export class FmpSubCompanyMp implements IFmpSubCompanyMp {
  constructor(
    public id?: number,
    public name?: string,
    public code?: string,
    public adminGroupId?: string,
    public ifPublic?: string,
    public styleId?: string,
    public isDeleted?: boolean,
    public managerUsers?: IManagerUserMp[],
    public banners?: IBannerMp[],
    public fmpMicroAppTypes?: IFmpMicroAppTypeMp[],
    public createdApps?: IFmpMicroAppMp[],
    public microAppGroups?: IMicroAppGroupMp[],
    public fmpMicroApps?: IFmpMicroAppMp[],
    public uucDepartmentTrees?: IUucDepartmentTreeMp[]
  ) {
    this.isDeleted = this.isDeleted || false;
  }
}
