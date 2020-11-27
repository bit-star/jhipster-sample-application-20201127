export interface IPortalRoutingMp {
  id?: number;
  mucAppOwner?: string;
  mucAppId?: string;
  mucAppUrl?: string;
  mucAppName?: string;
  mucAppNameEn?: string;
}

export class PortalRoutingMp implements IPortalRoutingMp {
  constructor(
    public id?: number,
    public mucAppOwner?: string,
    public mucAppId?: string,
    public mucAppUrl?: string,
    public mucAppName?: string,
    public mucAppNameEn?: string
  ) {}
}
