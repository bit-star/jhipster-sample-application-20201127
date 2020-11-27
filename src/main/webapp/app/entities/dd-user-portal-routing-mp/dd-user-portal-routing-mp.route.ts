import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IDdUserPortalRoutingMp, DdUserPortalRoutingMp } from 'app/shared/model/dd-user-portal-routing-mp.model';
import { DdUserPortalRoutingMpService } from './dd-user-portal-routing-mp.service';
import { DdUserPortalRoutingMpComponent } from './dd-user-portal-routing-mp.component';
import { DdUserPortalRoutingMpDetailComponent } from './dd-user-portal-routing-mp-detail.component';
import { DdUserPortalRoutingMpUpdateComponent } from './dd-user-portal-routing-mp-update.component';

@Injectable({ providedIn: 'root' })
export class DdUserPortalRoutingMpResolve implements Resolve<IDdUserPortalRoutingMp> {
  constructor(private service: DdUserPortalRoutingMpService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IDdUserPortalRoutingMp> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((ddUserPortalRouting: HttpResponse<DdUserPortalRoutingMp>) => {
          if (ddUserPortalRouting.body) {
            return of(ddUserPortalRouting.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new DdUserPortalRoutingMp());
  }
}

export const ddUserPortalRoutingRoute: Routes = [
  {
    path: '',
    component: DdUserPortalRoutingMpComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.ddUserPortalRouting.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: DdUserPortalRoutingMpDetailComponent,
    resolve: {
      ddUserPortalRouting: DdUserPortalRoutingMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.ddUserPortalRouting.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: DdUserPortalRoutingMpUpdateComponent,
    resolve: {
      ddUserPortalRouting: DdUserPortalRoutingMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.ddUserPortalRouting.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: DdUserPortalRoutingMpUpdateComponent,
    resolve: {
      ddUserPortalRouting: DdUserPortalRoutingMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.ddUserPortalRouting.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
