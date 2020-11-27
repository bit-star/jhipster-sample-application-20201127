import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IBannerMp, BannerMp } from 'app/shared/model/banner-mp.model';
import { BannerMpService } from './banner-mp.service';
import { BannerMpComponent } from './banner-mp.component';
import { BannerMpDetailComponent } from './banner-mp-detail.component';
import { BannerMpUpdateComponent } from './banner-mp-update.component';

@Injectable({ providedIn: 'root' })
export class BannerMpResolve implements Resolve<IBannerMp> {
  constructor(private service: BannerMpService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IBannerMp> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((banner: HttpResponse<BannerMp>) => {
          if (banner.body) {
            return of(banner.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new BannerMp());
  }
}

export const bannerRoute: Routes = [
  {
    path: '',
    component: BannerMpComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.banner.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: BannerMpDetailComponent,
    resolve: {
      banner: BannerMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.banner.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: BannerMpUpdateComponent,
    resolve: {
      banner: BannerMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.banner.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: BannerMpUpdateComponent,
    resolve: {
      banner: BannerMpResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'jhipsterSampleApplication20201127App.banner.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
