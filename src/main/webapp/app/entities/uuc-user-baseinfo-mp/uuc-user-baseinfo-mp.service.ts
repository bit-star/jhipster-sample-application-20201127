import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IUucUserBaseinfoMp } from 'app/shared/model/uuc-user-baseinfo-mp.model';

type EntityResponseType = HttpResponse<IUucUserBaseinfoMp>;
type EntityArrayResponseType = HttpResponse<IUucUserBaseinfoMp[]>;

@Injectable({ providedIn: 'root' })
export class UucUserBaseinfoMpService {
  public resourceUrl = SERVER_API_URL + 'api/uuc-user-baseinfos';

  constructor(protected http: HttpClient) {}

  create(uucUserBaseinfo: IUucUserBaseinfoMp): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(uucUserBaseinfo);
    return this.http
      .post<IUucUserBaseinfoMp>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(uucUserBaseinfo: IUucUserBaseinfoMp): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(uucUserBaseinfo);
    return this.http
      .put<IUucUserBaseinfoMp>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IUucUserBaseinfoMp>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IUucUserBaseinfoMp[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(uucUserBaseinfo: IUucUserBaseinfoMp): IUucUserBaseinfoMp {
    const copy: IUucUserBaseinfoMp = Object.assign({}, uucUserBaseinfo, {
      hiredate: uucUserBaseinfo.hiredate && uucUserBaseinfo.hiredate.isValid() ? uucUserBaseinfo.hiredate.toJSON() : undefined,
      recCreateTime:
        uucUserBaseinfo.recCreateTime && uucUserBaseinfo.recCreateTime.isValid() ? uucUserBaseinfo.recCreateTime.toJSON() : undefined,
      recReviseTime:
        uucUserBaseinfo.recReviseTime && uucUserBaseinfo.recReviseTime.isValid() ? uucUserBaseinfo.recReviseTime.toJSON() : undefined,
      activationTime:
        uucUserBaseinfo.activationTime && uucUserBaseinfo.activationTime.isValid() ? uucUserBaseinfo.activationTime.toJSON() : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.hiredate = res.body.hiredate ? moment(res.body.hiredate) : undefined;
      res.body.recCreateTime = res.body.recCreateTime ? moment(res.body.recCreateTime) : undefined;
      res.body.recReviseTime = res.body.recReviseTime ? moment(res.body.recReviseTime) : undefined;
      res.body.activationTime = res.body.activationTime ? moment(res.body.activationTime) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((uucUserBaseinfo: IUucUserBaseinfoMp) => {
        uucUserBaseinfo.hiredate = uucUserBaseinfo.hiredate ? moment(uucUserBaseinfo.hiredate) : undefined;
        uucUserBaseinfo.recCreateTime = uucUserBaseinfo.recCreateTime ? moment(uucUserBaseinfo.recCreateTime) : undefined;
        uucUserBaseinfo.recReviseTime = uucUserBaseinfo.recReviseTime ? moment(uucUserBaseinfo.recReviseTime) : undefined;
        uucUserBaseinfo.activationTime = uucUserBaseinfo.activationTime ? moment(uucUserBaseinfo.activationTime) : undefined;
      });
    }
    return res;
  }
}
