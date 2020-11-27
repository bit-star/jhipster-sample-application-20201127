import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IFmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';

type EntityResponseType = HttpResponse<IFmpMicroAppMp>;
type EntityArrayResponseType = HttpResponse<IFmpMicroAppMp[]>;

@Injectable({ providedIn: 'root' })
export class FmpMicroAppMpService {
  public resourceUrl = SERVER_API_URL + 'api/fmp-micro-apps';

  constructor(protected http: HttpClient) {}

  create(fmpMicroApp: IFmpMicroAppMp): Observable<EntityResponseType> {
    return this.http.post<IFmpMicroAppMp>(this.resourceUrl, fmpMicroApp, { observe: 'response' });
  }

  update(fmpMicroApp: IFmpMicroAppMp): Observable<EntityResponseType> {
    return this.http.put<IFmpMicroAppMp>(this.resourceUrl, fmpMicroApp, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IFmpMicroAppMp>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IFmpMicroAppMp[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
