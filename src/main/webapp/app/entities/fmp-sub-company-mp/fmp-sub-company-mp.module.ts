import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplication20201127SharedModule } from 'app/shared/shared.module';
import { FmpSubCompanyMpComponent } from './fmp-sub-company-mp.component';
import { FmpSubCompanyMpDetailComponent } from './fmp-sub-company-mp-detail.component';
import { FmpSubCompanyMpUpdateComponent } from './fmp-sub-company-mp-update.component';
import { FmpSubCompanyMpDeleteDialogComponent } from './fmp-sub-company-mp-delete-dialog.component';
import { fmpSubCompanyRoute } from './fmp-sub-company-mp.route';

@NgModule({
  imports: [JhipsterSampleApplication20201127SharedModule, RouterModule.forChild(fmpSubCompanyRoute)],
  declarations: [
    FmpSubCompanyMpComponent,
    FmpSubCompanyMpDetailComponent,
    FmpSubCompanyMpUpdateComponent,
    FmpSubCompanyMpDeleteDialogComponent,
  ],
  entryComponents: [FmpSubCompanyMpDeleteDialogComponent],
})
export class JhipsterSampleApplication20201127FmpSubCompanyMpModule {}
