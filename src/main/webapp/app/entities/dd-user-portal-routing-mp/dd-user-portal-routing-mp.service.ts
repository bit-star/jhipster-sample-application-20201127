import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IDdUserPortalRoutingMp } from 'app/shared/model/dd-user-portal-routing-mp.model';

type EntityResponseType = HttpResponse<IDdUserPortalRoutingMp>;
type EntityArrayResponseType = HttpResponse<IDdUserPortalRoutingMp[]>;

@Injectable({ providedIn: 'root' })
export class DdUserPortalRoutingMpService {
  public resourceUrl = SERVER_API_URL + 'api/dd-user-portal-routings';

  constructor(protected http: HttpClient) {}

  create(ddUserPortalRouting: IDdUserPortalRoutingMp): Observable<EntityResponseType> {
    return this.http.post<IDdUserPortalRoutingMp>(this.resourceUrl, ddUserPortalRouting, { observe: 'response' });
  }

  update(ddUserPortalRouting: IDdUserPortalRoutingMp): Observable<EntityResponseType> {
    return this.http.put<IDdUserPortalRoutingMp>(this.resourceUrl, ddUserPortalRouting, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IDdUserPortalRoutingMp>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IDdUserPortalRoutingMp[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
