import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'micro-app-group-mp',
        loadChildren: () =>
          import('./micro-app-group-mp/micro-app-group-mp.module').then(m => m.JhipsterSampleApplication20201127MicroAppGroupMpModule),
      },
      {
        path: 'fmp-micro-app-mp',
        loadChildren: () =>
          import('./fmp-micro-app-mp/fmp-micro-app-mp.module').then(m => m.JhipsterSampleApplication20201127FmpMicroAppMpModule),
      },
      {
        path: 'uuc-department-tree-mp',
        loadChildren: () =>
          import('./uuc-department-tree-mp/uuc-department-tree-mp.module').then(
            m => m.JhipsterSampleApplication20201127UucDepartmentTreeMpModule
          ),
      },
      {
        path: 'uuc-user-baseinfo-mp',
        loadChildren: () =>
          import('./uuc-user-baseinfo-mp/uuc-user-baseinfo-mp.module').then(
            m => m.JhipsterSampleApplication20201127UucUserBaseinfoMpModule
          ),
      },
      {
        path: 'fmp-sub-company-mp',
        loadChildren: () =>
          import('./fmp-sub-company-mp/fmp-sub-company-mp.module').then(m => m.JhipsterSampleApplication20201127FmpSubCompanyMpModule),
      },
      {
        path: 'fmp-micro-app-type-mp',
        loadChildren: () =>
          import('./fmp-micro-app-type-mp/fmp-micro-app-type-mp.module').then(
            m => m.JhipsterSampleApplication20201127FmpMicroAppTypeMpModule
          ),
      },
      {
        path: 'fmp-widget-info-mp',
        loadChildren: () =>
          import('./fmp-widget-info-mp/fmp-widget-info-mp.module').then(m => m.JhipsterSampleApplication20201127FmpWidgetInfoMpModule),
      },
      {
        path: 'banner-mp',
        loadChildren: () => import('./banner-mp/banner-mp.module').then(m => m.JhipsterSampleApplication20201127BannerMpModule),
      },
      {
        path: 'dd-user-mp',
        loadChildren: () => import('./dd-user-mp/dd-user-mp.module').then(m => m.JhipsterSampleApplication20201127DdUserMpModule),
      },
      {
        path: 'manager-user-mp',
        loadChildren: () =>
          import('./manager-user-mp/manager-user-mp.module').then(m => m.JhipsterSampleApplication20201127ManagerUserMpModule),
      },
      {
        path: 'portal-routing-mp',
        loadChildren: () =>
          import('./portal-routing-mp/portal-routing-mp.module').then(m => m.JhipsterSampleApplication20201127PortalRoutingMpModule),
      },
      {
        path: 'dd-user-portal-routing-mp',
        loadChildren: () =>
          import('./dd-user-portal-routing-mp/dd-user-portal-routing-mp.module').then(
            m => m.JhipsterSampleApplication20201127DdUserPortalRoutingMpModule
          ),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class JhipsterSampleApplication20201127EntityModule {}
