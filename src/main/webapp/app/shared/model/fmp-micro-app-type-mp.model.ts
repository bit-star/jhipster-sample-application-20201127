import { IFmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';
import { IFmpSubCompanyMp } from 'app/shared/model/fmp-sub-company-mp.model';

export interface IFmpMicroAppTypeMp {
  id?: number;
  code?: string;
  name?: string;
  language?: string;
  portalId?: string;
  isDeleted?: boolean;
  fmpMicroApps?: IFmpMicroAppMp[];
  fmpSubCompany?: IFmpSubCompanyMp;
}

export class FmpMicroAppTypeMp implements IFmpMicroAppTypeMp {
  constructor(
    public id?: number,
    public code?: string,
    public name?: string,
    public language?: string,
    public portalId?: string,
    public isDeleted?: boolean,
    public fmpMicroApps?: IFmpMicroAppMp[],
    public fmpSubCompany?: IFmpSubCompanyMp
  ) {
    this.isDeleted = this.isDeleted || false;
  }
}
