import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IBannerMp } from 'app/shared/model/banner-mp.model';
import { BannerMpService } from './banner-mp.service';

@Component({
  templateUrl: './banner-mp-delete-dialog.component.html',
})
export class BannerMpDeleteDialogComponent {
  banner?: IBannerMp;

  constructor(protected bannerService: BannerMpService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.bannerService.delete(id).subscribe(() => {
      this.eventManager.broadcast('bannerListModification');
      this.activeModal.close();
    });
  }
}
