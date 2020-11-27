import { IFmpSubCompanyMp } from 'app/shared/model/fmp-sub-company-mp.model';
import { BannerType } from 'app/shared/model/enumerations/banner-type.model';
import { Status } from 'app/shared/model/enumerations/status.model';

export interface IBannerMp {
  id?: number;
  rank?: number;
  type?: BannerType;
  status?: Status;
  pathUrl?: string;
  bannerUrl?: string;
  remark?: string;
  fmpSubCompany?: IFmpSubCompanyMp;
}

export class BannerMp implements IBannerMp {
  constructor(
    public id?: number,
    public rank?: number,
    public type?: BannerType,
    public status?: Status,
    public pathUrl?: string,
    public bannerUrl?: string,
    public remark?: string,
    public fmpSubCompany?: IFmpSubCompanyMp
  ) {}
}
