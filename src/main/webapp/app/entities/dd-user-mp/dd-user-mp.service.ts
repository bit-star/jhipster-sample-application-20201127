import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IDdUserMp } from 'app/shared/model/dd-user-mp.model';

type EntityResponseType = HttpResponse<IDdUserMp>;
type EntityArrayResponseType = HttpResponse<IDdUserMp[]>;

@Injectable({ providedIn: 'root' })
export class DdUserMpService {
  public resourceUrl = SERVER_API_URL + 'api/dd-users';

  constructor(protected http: HttpClient) {}

  create(ddUser: IDdUserMp): Observable<EntityResponseType> {
    return this.http.post<IDdUserMp>(this.resourceUrl, ddUser, { observe: 'response' });
  }

  update(ddUser: IDdUserMp): Observable<EntityResponseType> {
    return this.http.put<IDdUserMp>(this.resourceUrl, ddUser, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IDdUserMp>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IDdUserMp[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
