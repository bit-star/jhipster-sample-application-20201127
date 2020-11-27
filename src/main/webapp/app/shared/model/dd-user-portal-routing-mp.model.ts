export interface IDdUserPortalRoutingMp {
  id?: number;
  jobCode?: string;
  mobile?: string;
  microappUrl?: string;
  injectionFlag?: string;
  injectionApiUri?: string;
  mucAppId?: string;
}

export class DdUserPortalRoutingMp implements IDdUserPortalRoutingMp {
  constructor(
    public id?: number,
    public jobCode?: string,
    public mobile?: string,
    public microappUrl?: string,
    public injectionFlag?: string,
    public injectionApiUri?: string,
    public mucAppId?: string
  ) {}
}
