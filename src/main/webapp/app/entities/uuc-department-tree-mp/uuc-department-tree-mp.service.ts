import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IUucDepartmentTreeMp } from 'app/shared/model/uuc-department-tree-mp.model';

type EntityResponseType = HttpResponse<IUucDepartmentTreeMp>;
type EntityArrayResponseType = HttpResponse<IUucDepartmentTreeMp[]>;

@Injectable({ providedIn: 'root' })
export class UucDepartmentTreeMpService {
  public resourceUrl = SERVER_API_URL + 'api/uuc-department-trees';

  constructor(protected http: HttpClient) {}

  create(uucDepartmentTree: IUucDepartmentTreeMp): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(uucDepartmentTree);
    return this.http
      .post<IUucDepartmentTreeMp>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(uucDepartmentTree: IUucDepartmentTreeMp): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(uucDepartmentTree);
    return this.http
      .put<IUucDepartmentTreeMp>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IUucDepartmentTreeMp>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IUucDepartmentTreeMp[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(uucDepartmentTree: IUucDepartmentTreeMp): IUucDepartmentTreeMp {
    const copy: IUucDepartmentTreeMp = Object.assign({}, uucDepartmentTree, {
      recCreateTime:
        uucDepartmentTree.recCreateTime && uucDepartmentTree.recCreateTime.isValid() ? uucDepartmentTree.recCreateTime.toJSON() : undefined,
      recReviseTime:
        uucDepartmentTree.recReviseTime && uucDepartmentTree.recReviseTime.isValid() ? uucDepartmentTree.recReviseTime.toJSON() : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.recCreateTime = res.body.recCreateTime ? moment(res.body.recCreateTime) : undefined;
      res.body.recReviseTime = res.body.recReviseTime ? moment(res.body.recReviseTime) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((uucDepartmentTree: IUucDepartmentTreeMp) => {
        uucDepartmentTree.recCreateTime = uucDepartmentTree.recCreateTime ? moment(uucDepartmentTree.recCreateTime) : undefined;
        uucDepartmentTree.recReviseTime = uucDepartmentTree.recReviseTime ? moment(uucDepartmentTree.recReviseTime) : undefined;
      });
    }
    return res;
  }
}
