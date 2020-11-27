import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplication20201127SharedModule } from 'app/shared/shared.module';
import { FmpWidgetInfoMpComponent } from './fmp-widget-info-mp.component';
import { FmpWidgetInfoMpDetailComponent } from './fmp-widget-info-mp-detail.component';
import { FmpWidgetInfoMpUpdateComponent } from './fmp-widget-info-mp-update.component';
import { FmpWidgetInfoMpDeleteDialogComponent } from './fmp-widget-info-mp-delete-dialog.component';
import { fmpWidgetInfoRoute } from './fmp-widget-info-mp.route';

@NgModule({
  imports: [JhipsterSampleApplication20201127SharedModule, RouterModule.forChild(fmpWidgetInfoRoute)],
  declarations: [
    FmpWidgetInfoMpComponent,
    FmpWidgetInfoMpDetailComponent,
    FmpWidgetInfoMpUpdateComponent,
    FmpWidgetInfoMpDeleteDialogComponent,
  ],
  entryComponents: [FmpWidgetInfoMpDeleteDialogComponent],
})
export class JhipsterSampleApplication20201127FmpWidgetInfoMpModule {}
