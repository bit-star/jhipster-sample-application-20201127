import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IPortalRoutingMp } from 'app/shared/model/portal-routing-mp.model';

type EntityResponseType = HttpResponse<IPortalRoutingMp>;
type EntityArrayResponseType = HttpResponse<IPortalRoutingMp[]>;

@Injectable({ providedIn: 'root' })
export class PortalRoutingMpService {
  public resourceUrl = SERVER_API_URL + 'api/portal-routings';

  constructor(protected http: HttpClient) {}

  create(portalRouting: IPortalRoutingMp): Observable<EntityResponseType> {
    return this.http.post<IPortalRoutingMp>(this.resourceUrl, portalRouting, { observe: 'response' });
  }

  update(portalRouting: IPortalRoutingMp): Observable<EntityResponseType> {
    return this.http.put<IPortalRoutingMp>(this.resourceUrl, portalRouting, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IPortalRoutingMp>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IPortalRoutingMp[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
