import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IBannerMp } from 'app/shared/model/banner-mp.model';

type EntityResponseType = HttpResponse<IBannerMp>;
type EntityArrayResponseType = HttpResponse<IBannerMp[]>;

@Injectable({ providedIn: 'root' })
export class BannerMpService {
  public resourceUrl = SERVER_API_URL + 'api/banners';

  constructor(protected http: HttpClient) {}

  create(banner: IBannerMp): Observable<EntityResponseType> {
    return this.http.post<IBannerMp>(this.resourceUrl, banner, { observe: 'response' });
  }

  update(banner: IBannerMp): Observable<EntityResponseType> {
    return this.http.put<IBannerMp>(this.resourceUrl, banner, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IBannerMp>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IBannerMp[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
