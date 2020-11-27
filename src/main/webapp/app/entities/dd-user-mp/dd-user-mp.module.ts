import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplication20201127SharedModule } from 'app/shared/shared.module';
import { DdUserMpComponent } from './dd-user-mp.component';
import { DdUserMpDetailComponent } from './dd-user-mp-detail.component';
import { DdUserMpUpdateComponent } from './dd-user-mp-update.component';
import { DdUserMpDeleteDialogComponent } from './dd-user-mp-delete-dialog.component';
import { ddUserRoute } from './dd-user-mp.route';

@NgModule({
  imports: [JhipsterSampleApplication20201127SharedModule, RouterModule.forChild(ddUserRoute)],
  declarations: [DdUserMpComponent, DdUserMpDetailComponent, DdUserMpUpdateComponent, DdUserMpDeleteDialogComponent],
  entryComponents: [DdUserMpDeleteDialogComponent],
})
export class JhipsterSampleApplication20201127DdUserMpModule {}
