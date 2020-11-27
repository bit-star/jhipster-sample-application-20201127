import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplication20201127SharedModule } from 'app/shared/shared.module';
import { PortalRoutingMpComponent } from './portal-routing-mp.component';
import { PortalRoutingMpDetailComponent } from './portal-routing-mp-detail.component';
import { PortalRoutingMpUpdateComponent } from './portal-routing-mp-update.component';
import { PortalRoutingMpDeleteDialogComponent } from './portal-routing-mp-delete-dialog.component';
import { portalRoutingRoute } from './portal-routing-mp.route';

@NgModule({
  imports: [JhipsterSampleApplication20201127SharedModule, RouterModule.forChild(portalRoutingRoute)],
  declarations: [
    PortalRoutingMpComponent,
    PortalRoutingMpDetailComponent,
    PortalRoutingMpUpdateComponent,
    PortalRoutingMpDeleteDialogComponent,
  ],
  entryComponents: [PortalRoutingMpDeleteDialogComponent],
})
export class JhipsterSampleApplication20201127PortalRoutingMpModule {}
