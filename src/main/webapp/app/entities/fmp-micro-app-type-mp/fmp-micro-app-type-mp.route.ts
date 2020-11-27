import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IFmpMicroAppTypeMp, FmpMicroAppTypeMp } from 'app/shared/model/fmp-micro-app-type-mp.model';
import { FmpMicroAppTypeMpService } from './fmp-micro-app-type-mp.service';
import { FmpMicroAppTypeMpComponent } from './fmp-micro-app-type-mp.component';
import { FmpMicroAppTypeMpDetailComponent } from './fmp-micro-app-type-mp-detail.component';
import { FmpMicroAppTypeMpUpdateComponent } from './fmp-micro-app-type-mp-update.component';

@Injectable({ providedIn: 'root' })
export class FmpMicroAppTypeMpResolve implements Resolve<IFmpMicroAppTypeMp> {
  constructor(private service: FmpMicroAppTypeMpService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IFmpMicroAppTypeMp> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((fmpMicroAppType: HttpResponse<FmpMicroAppTypeMp>) => {
          if (fmpMicroAppType.body) {
            return of(fmpMicroAppType.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new FmpMicroAppTypeMp());
  }
}

export const fmpMicroAppTypeRoute: Routes = [
  {
    path: '',
    component: FmpMicroAppTypeMpComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.fmpMicroAppType.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: FmpMicroAppTypeMpDetailComponent,
    resolve: {
      fmpMicroAppType: FmpMicroAppTypeMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.fmpMicroAppType.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: FmpMicroAppTypeMpUpdateComponent,
    resolve: {
      fmpMicroAppType: FmpMicroAppTypeMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.fmpMicroAppType.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: FmpMicroAppTypeMpUpdateComponent,
    resolve: {
      fmpMicroAppType: FmpMicroAppTypeMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.fmpMicroAppType.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
