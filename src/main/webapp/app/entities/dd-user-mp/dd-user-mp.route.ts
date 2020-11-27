import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IDdUserMp, DdUserMp } from 'app/shared/model/dd-user-mp.model';
import { DdUserMpService } from './dd-user-mp.service';
import { DdUserMpComponent } from './dd-user-mp.component';
import { DdUserMpDetailComponent } from './dd-user-mp-detail.component';
import { DdUserMpUpdateComponent } from './dd-user-mp-update.component';

@Injectable({ providedIn: 'root' })
export class DdUserMpResolve implements Resolve<IDdUserMp> {
  constructor(private service: DdUserMpService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IDdUserMp> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((ddUser: HttpResponse<DdUserMp>) => {
          if (ddUser.body) {
            return of(ddUser.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new DdUserMp());
  }
}

export const ddUserRoute: Routes = [
  {
    path: '',
    component: DdUserMpComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.ddUser.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: DdUserMpDetailComponent,
    resolve: {
      ddUser: DdUserMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.ddUser.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: DdUserMpUpdateComponent,
    resolve: {
      ddUser: DdUserMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.ddUser.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: DdUserMpUpdateComponent,
    resolve: {
      ddUser: DdUserMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.ddUser.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
