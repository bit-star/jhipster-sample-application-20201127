import { IFmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';
import { PassingForm } from 'app/shared/model/enumerations/passing-form.model';
import { TopOption } from 'app/shared/model/enumerations/top-option.model';
import { WidgetContentType } from 'app/shared/model/enumerations/widget-content-type.model';
import { WidgeType } from 'app/shared/model/enumerations/widge-type.model';

export interface IFmpWidgetInfoMp {
  id?: number;
  code?: string;
  portalId?: string;
  title?: string;
  catId?: string;
  dataUrl?: string;
  sort?: string;
  dataUrlParam?: PassingForm;
  isTop?: TopOption;
  contentType?: WidgetContentType;
  type?: WidgeType;
  isDeleted?: boolean;
  fmpMicroApp?: IFmpMicroAppMp;
}

export class FmpWidgetInfoMp implements IFmpWidgetInfoMp {
  constructor(
    public id?: number,
    public code?: string,
    public portalId?: string,
    public title?: string,
    public catId?: string,
    public dataUrl?: string,
    public sort?: string,
    public dataUrlParam?: PassingForm,
    public isTop?: TopOption,
    public contentType?: WidgetContentType,
    public type?: WidgeType,
    public isDeleted?: boolean,
    public fmpMicroApp?: IFmpMicroAppMp
  ) {
    this.isDeleted = this.isDeleted || false;
  }
}
