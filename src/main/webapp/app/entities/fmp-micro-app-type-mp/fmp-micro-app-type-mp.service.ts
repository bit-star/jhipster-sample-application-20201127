import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IFmpMicroAppTypeMp } from 'app/shared/model/fmp-micro-app-type-mp.model';

type EntityResponseType = HttpResponse<IFmpMicroAppTypeMp>;
type EntityArrayResponseType = HttpResponse<IFmpMicroAppTypeMp[]>;

@Injectable({ providedIn: 'root' })
export class FmpMicroAppTypeMpService {
  public resourceUrl = SERVER_API_URL + 'api/fmp-micro-app-types';

  constructor(protected http: HttpClient) {}

  create(fmpMicroAppType: IFmpMicroAppTypeMp): Observable<EntityResponseType> {
    return this.http.post<IFmpMicroAppTypeMp>(this.resourceUrl, fmpMicroAppType, { observe: 'response' });
  }

  update(fmpMicroAppType: IFmpMicroAppTypeMp): Observable<EntityResponseType> {
    return this.http.put<IFmpMicroAppTypeMp>(this.resourceUrl, fmpMicroAppType, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IFmpMicroAppTypeMp>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IFmpMicroAppTypeMp[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
