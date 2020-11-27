import { IFmpWidgetInfoMp } from 'app/shared/model/fmp-widget-info-mp.model';
import { IUucDepartmentTreeMp } from 'app/shared/model/uuc-department-tree-mp.model';
import { IUucUserBaseinfoMp } from 'app/shared/model/uuc-user-baseinfo-mp.model';
import { IFmpMicroAppTypeMp } from 'app/shared/model/fmp-micro-app-type-mp.model';
import { IFmpSubCompanyMp } from 'app/shared/model/fmp-sub-company-mp.model';
import { IMicroAppGroupMp } from 'app/shared/model/micro-app-group-mp.model';
import { IsNew } from 'app/shared/model/enumerations/is-new.model';
import { MicroAppStatus } from 'app/shared/model/enumerations/micro-app-status.model';
import { OpenMethod } from 'app/shared/model/enumerations/open-method.model';
import { Language } from 'app/shared/model/enumerations/language.model';
import { IsFixed } from 'app/shared/model/enumerations/is-fixed.model';

export interface IFmpMicroAppMp {
  id?: number;
  catCode?: string;
  parentCatId?: string;
  levelNumber?: number;
  isLeaf?: string;
  businessCode?: string;
  endpointUrl?: string;
  iconImg?: string;
  bannerImg?: string;
  thumbnail?: string;
  sortCode?: string;
  systemType?: string;
  contentOwnerCode?: string;
  lable?: string;
  isNew?: IsNew;
  status?: MicroAppStatus;
  openMethod?: OpenMethod;
  language?: Language;
  isFixed?: IsFixed;
  tagKey01?: string;
  tagVal01?: string;
  tagKey02?: string;
  tagVal02?: string;
  tagKey03?: string;
  tagVal03?: string;
  catName?: string;
  filterSql?: string;
  sharingFlag?: string;
  category?: string;
  imgClass?: string;
  isInternal?: string;
  customFlag?: string;
  portal?: string;
  description?: string;
  businessUnit?: string;
  businessOwners?: string;
  businessOwnersMobile?: string;
  fmpWidgetInfos?: IFmpWidgetInfoMp[];
  uucDepartmentTrees?: IUucDepartmentTreeMp[];
  usableUsers?: IUucUserBaseinfoMp[];
  fmpMicroAppType?: IFmpMicroAppTypeMp;
  creatorCompany?: IFmpSubCompanyMp;
  fmpSubCompanies?: IFmpSubCompanyMp[];
  collectionUsers?: IUucUserBaseinfoMp[];
  microAppGroups?: IMicroAppGroupMp[];
}

export class FmpMicroAppMp implements IFmpMicroAppMp {
  constructor(
    public id?: number,
    public catCode?: string,
    public parentCatId?: string,
    public levelNumber?: number,
    public isLeaf?: string,
    public businessCode?: string,
    public endpointUrl?: string,
    public iconImg?: string,
    public bannerImg?: string,
    public thumbnail?: string,
    public sortCode?: string,
    public systemType?: string,
    public contentOwnerCode?: string,
    public lable?: string,
    public isNew?: IsNew,
    public status?: MicroAppStatus,
    public openMethod?: OpenMethod,
    public language?: Language,
    public isFixed?: IsFixed,
    public tagKey01?: string,
    public tagVal01?: string,
    public tagKey02?: string,
    public tagVal02?: string,
    public tagKey03?: string,
    public tagVal03?: string,
    public catName?: string,
    public filterSql?: string,
    public sharingFlag?: string,
    public category?: string,
    public imgClass?: string,
    public isInternal?: string,
    public customFlag?: string,
    public portal?: string,
    public description?: string,
    public businessUnit?: string,
    public businessOwners?: string,
    public businessOwnersMobile?: string,
    public fmpWidgetInfos?: IFmpWidgetInfoMp[],
    public uucDepartmentTrees?: IUucDepartmentTreeMp[],
    public usableUsers?: IUucUserBaseinfoMp[],
    public fmpMicroAppType?: IFmpMicroAppTypeMp,
    public creatorCompany?: IFmpSubCompanyMp,
    public fmpSubCompanies?: IFmpSubCompanyMp[],
    public collectionUsers?: IUucUserBaseinfoMp[],
    public microAppGroups?: IMicroAppGroupMp[]
  ) {}
}
