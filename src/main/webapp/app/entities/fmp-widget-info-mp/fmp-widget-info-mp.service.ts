import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IFmpWidgetInfoMp } from 'app/shared/model/fmp-widget-info-mp.model';

type EntityResponseType = HttpResponse<IFmpWidgetInfoMp>;
type EntityArrayResponseType = HttpResponse<IFmpWidgetInfoMp[]>;

@Injectable({ providedIn: 'root' })
export class FmpWidgetInfoMpService {
  public resourceUrl = SERVER_API_URL + 'api/fmp-widget-infos';

  constructor(protected http: HttpClient) {}

  create(fmpWidgetInfo: IFmpWidgetInfoMp): Observable<EntityResponseType> {
    return this.http.post<IFmpWidgetInfoMp>(this.resourceUrl, fmpWidgetInfo, { observe: 'response' });
  }

  update(fmpWidgetInfo: IFmpWidgetInfoMp): Observable<EntityResponseType> {
    return this.http.put<IFmpWidgetInfoMp>(this.resourceUrl, fmpWidgetInfo, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IFmpWidgetInfoMp>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IFmpWidgetInfoMp[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
