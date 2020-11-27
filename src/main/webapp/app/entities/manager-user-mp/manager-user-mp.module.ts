import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplication20201127SharedModule } from 'app/shared/shared.module';
import { ManagerUserMpComponent } from './manager-user-mp.component';
import { ManagerUserMpDetailComponent } from './manager-user-mp-detail.component';
import { ManagerUserMpUpdateComponent } from './manager-user-mp-update.component';
import { ManagerUserMpDeleteDialogComponent } from './manager-user-mp-delete-dialog.component';
import { managerUserRoute } from './manager-user-mp.route';

@NgModule({
  imports: [JhipsterSampleApplication20201127SharedModule, RouterModule.forChild(managerUserRoute)],
  declarations: [ManagerUserMpComponent, ManagerUserMpDetailComponent, ManagerUserMpUpdateComponent, ManagerUserMpDeleteDialogComponent],
  entryComponents: [ManagerUserMpDeleteDialogComponent],
})
export class JhipsterSampleApplication20201127ManagerUserMpModule {}
