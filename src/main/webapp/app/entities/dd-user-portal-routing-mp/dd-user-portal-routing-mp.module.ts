import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplication20201127SharedModule } from 'app/shared/shared.module';
import { DdUserPortalRoutingMpComponent } from './dd-user-portal-routing-mp.component';
import { DdUserPortalRoutingMpDetailComponent } from './dd-user-portal-routing-mp-detail.component';
import { DdUserPortalRoutingMpUpdateComponent } from './dd-user-portal-routing-mp-update.component';
import { DdUserPortalRoutingMpDeleteDialogComponent } from './dd-user-portal-routing-mp-delete-dialog.component';
import { ddUserPortalRoutingRoute } from './dd-user-portal-routing-mp.route';

@NgModule({
  imports: [JhipsterSampleApplication20201127SharedModule, RouterModule.forChild(ddUserPortalRoutingRoute)],
  declarations: [
    DdUserPortalRoutingMpComponent,
    DdUserPortalRoutingMpDetailComponent,
    DdUserPortalRoutingMpUpdateComponent,
    DdUserPortalRoutingMpDeleteDialogComponent,
  ],
  entryComponents: [DdUserPortalRoutingMpDeleteDialogComponent],
})
export class JhipsterSampleApplication20201127DdUserPortalRoutingMpModule {}
