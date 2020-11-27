import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IManagerUserMp, ManagerUserMp } from 'app/shared/model/manager-user-mp.model';
import { ManagerUserMpService } from './manager-user-mp.service';
import { ManagerUserMpComponent } from './manager-user-mp.component';
import { ManagerUserMpDetailComponent } from './manager-user-mp-detail.component';
import { ManagerUserMpUpdateComponent } from './manager-user-mp-update.component';

@Injectable({ providedIn: 'root' })
export class ManagerUserMpResolve implements Resolve<IManagerUserMp> {
  constructor(private service: ManagerUserMpService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IManagerUserMp> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((managerUser: HttpResponse<ManagerUserMp>) => {
          if (managerUser.body) {
            return of(managerUser.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new ManagerUserMp());
  }
}

export const managerUserRoute: Routes = [
  {
    path: '',
    component: ManagerUserMpComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.managerUser.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: ManagerUserMpDetailComponent,
    resolve: {
      managerUser: ManagerUserMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.managerUser.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: ManagerUserMpUpdateComponent,
    resolve: {
      managerUser: ManagerUserMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.managerUser.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: ManagerUserMpUpdateComponent,
    resolve: {
      managerUser: ManagerUserMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.managerUser.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
