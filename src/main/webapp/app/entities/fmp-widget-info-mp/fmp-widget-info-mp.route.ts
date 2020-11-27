import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IFmpWidgetInfoMp, FmpWidgetInfoMp } from 'app/shared/model/fmp-widget-info-mp.model';
import { FmpWidgetInfoMpService } from './fmp-widget-info-mp.service';
import { FmpWidgetInfoMpComponent } from './fmp-widget-info-mp.component';
import { FmpWidgetInfoMpDetailComponent } from './fmp-widget-info-mp-detail.component';
import { FmpWidgetInfoMpUpdateComponent } from './fmp-widget-info-mp-update.component';

@Injectable({ providedIn: 'root' })
export class FmpWidgetInfoMpResolve implements Resolve<IFmpWidgetInfoMp> {
  constructor(private service: FmpWidgetInfoMpService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IFmpWidgetInfoMp> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((fmpWidgetInfo: HttpResponse<FmpWidgetInfoMp>) => {
          if (fmpWidgetInfo.body) {
            return of(fmpWidgetInfo.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new FmpWidgetInfoMp());
  }
}

export const fmpWidgetInfoRoute: Routes = [
  {
    path: '',
    component: FmpWidgetInfoMpComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.fmpWidgetInfo.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: FmpWidgetInfoMpDetailComponent,
    resolve: {
      fmpWidgetInfo: FmpWidgetInfoMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.fmpWidgetInfo.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: FmpWidgetInfoMpUpdateComponent,
    resolve: {
      fmpWidgetInfo: FmpWidgetInfoMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.fmpWidgetInfo.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: FmpWidgetInfoMpUpdateComponent,
    resolve: {
      fmpWidgetInfo: FmpWidgetInfoMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.fmpWidgetInfo.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
