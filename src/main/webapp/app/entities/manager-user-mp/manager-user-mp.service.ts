import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IManagerUserMp } from 'app/shared/model/manager-user-mp.model';

type EntityResponseType = HttpResponse<IManagerUserMp>;
type EntityArrayResponseType = HttpResponse<IManagerUserMp[]>;

@Injectable({ providedIn: 'root' })
export class ManagerUserMpService {
  public resourceUrl = SERVER_API_URL + 'api/manager-users';

  constructor(protected http: HttpClient) {}

  create(managerUser: IManagerUserMp): Observable<EntityResponseType> {
    return this.http.post<IManagerUserMp>(this.resourceUrl, managerUser, { observe: 'response' });
  }

  update(managerUser: IManagerUserMp): Observable<EntityResponseType> {
    return this.http.put<IManagerUserMp>(this.resourceUrl, managerUser, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IManagerUserMp>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IManagerUserMp[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
