import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplication20201127SharedModule } from 'app/shared/shared.module';
import { BannerMpComponent } from './banner-mp.component';
import { BannerMpDetailComponent } from './banner-mp-detail.component';
import { BannerMpUpdateComponent } from './banner-mp-update.component';
import { BannerMpDeleteDialogComponent } from './banner-mp-delete-dialog.component';
import { bannerRoute } from './banner-mp.route';

@NgModule({
  imports: [JhipsterSampleApplication20201127SharedModule, RouterModule.forChild(bannerRoute)],
  declarations: [BannerMpComponent, BannerMpDetailComponent, BannerMpUpdateComponent, BannerMpDeleteDialogComponent],
  entryComponents: [BannerMpDeleteDialogComponent],
})
export class JhipsterSampleApplication20201127BannerMpModule {}
