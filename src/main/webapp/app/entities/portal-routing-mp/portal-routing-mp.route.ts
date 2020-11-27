import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IPortalRoutingMp, PortalRoutingMp } from 'app/shared/model/portal-routing-mp.model';
import { PortalRoutingMpService } from './portal-routing-mp.service';
import { PortalRoutingMpComponent } from './portal-routing-mp.component';
import { PortalRoutingMpDetailComponent } from './portal-routing-mp-detail.component';
import { PortalRoutingMpUpdateComponent } from './portal-routing-mp-update.component';

@Injectable({ providedIn: 'root' })
export class PortalRoutingMpResolve implements Resolve<IPortalRoutingMp> {
  constructor(private service: PortalRoutingMpService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IPortalRoutingMp> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((portalRouting: HttpResponse<PortalRoutingMp>) => {
          if (portalRouting.body) {
            return of(portalRouting.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new PortalRoutingMp());
  }
}

export const portalRoutingRoute: Routes = [
  {
    path: '',
    component: PortalRoutingMpComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.portalRouting.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: PortalRoutingMpDetailComponent,
    resolve: {
      portalRouting: PortalRoutingMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.portalRouting.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: PortalRoutingMpUpdateComponent,
    resolve: {
      portalRouting: PortalRoutingMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.portalRouting.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: PortalRoutingMpUpdateComponent,
    resolve: {
      portalRouting: PortalRoutingMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.portalRouting.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
