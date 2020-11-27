import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplication20201127SharedModule } from 'app/shared/shared.module';
import { FmpMicroAppMpComponent } from './fmp-micro-app-mp.component';
import { FmpMicroAppMpDetailComponent } from './fmp-micro-app-mp-detail.component';
import { FmpMicroAppMpUpdateComponent } from './fmp-micro-app-mp-update.component';
import { FmpMicroAppMpDeleteDialogComponent } from './fmp-micro-app-mp-delete-dialog.component';
import { fmpMicroAppRoute } from './fmp-micro-app-mp.route';

@NgModule({
  imports: [JhipsterSampleApplication20201127SharedModule, RouterModule.forChild(fmpMicroAppRoute)],
  declarations: [FmpMicroAppMpComponent, FmpMicroAppMpDetailComponent, FmpMicroAppMpUpdateComponent, FmpMicroAppMpDeleteDialogComponent],
  entryComponents: [FmpMicroAppMpDeleteDialogComponent],
})
export class JhipsterSampleApplication20201127FmpMicroAppMpModule {}
