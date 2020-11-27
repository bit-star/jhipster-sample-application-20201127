import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IPortalRoutingMp } from 'app/shared/model/portal-routing-mp.model';
import { PortalRoutingMpService } from './portal-routing-mp.service';

@Component({
  templateUrl: './portal-routing-mp-delete-dialog.component.html',
})
export class PortalRoutingMpDeleteDialogComponent {
  portalRouting?: IPortalRoutingMp;

  constructor(
    protected portalRoutingService: PortalRoutingMpService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.portalRoutingService.delete(id).subscribe(() => {
      this.eventManager.broadcast('portalRoutingListModification');
      this.activeModal.close();
    });
  }
}
