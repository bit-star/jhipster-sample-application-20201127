import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IDdUserPortalRoutingMp } from 'app/shared/model/dd-user-portal-routing-mp.model';
import { DdUserPortalRoutingMpService } from './dd-user-portal-routing-mp.service';

@Component({
  templateUrl: './dd-user-portal-routing-mp-delete-dialog.component.html',
})
export class DdUserPortalRoutingMpDeleteDialogComponent {
  ddUserPortalRouting?: IDdUserPortalRoutingMp;

  constructor(
    protected ddUserPortalRoutingService: DdUserPortalRoutingMpService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.ddUserPortalRoutingService.delete(id).subscribe(() => {
      this.eventManager.broadcast('ddUserPortalRoutingListModification');
      this.activeModal.close();
    });
  }
}
