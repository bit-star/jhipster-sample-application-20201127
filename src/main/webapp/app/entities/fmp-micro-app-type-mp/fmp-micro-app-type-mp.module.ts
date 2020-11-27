import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplication20201127SharedModule } from 'app/shared/shared.module';
import { FmpMicroAppTypeMpComponent } from './fmp-micro-app-type-mp.component';
import { FmpMicroAppTypeMpDetailComponent } from './fmp-micro-app-type-mp-detail.component';
import { FmpMicroAppTypeMpUpdateComponent } from './fmp-micro-app-type-mp-update.component';
import { FmpMicroAppTypeMpDeleteDialogComponent } from './fmp-micro-app-type-mp-delete-dialog.component';
import { fmpMicroAppTypeRoute } from './fmp-micro-app-type-mp.route';

@NgModule({
  imports: [JhipsterSampleApplication20201127SharedModule, RouterModule.forChild(fmpMicroAppTypeRoute)],
  declarations: [
    FmpMicroAppTypeMpComponent,
    FmpMicroAppTypeMpDetailComponent,
    FmpMicroAppTypeMpUpdateComponent,
    FmpMicroAppTypeMpDeleteDialogComponent,
  ],
  entryComponents: [FmpMicroAppTypeMpDeleteDialogComponent],
})
export class JhipsterSampleApplication20201127FmpMicroAppTypeMpModule {}
