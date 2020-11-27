import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IDdUserMp } from 'app/shared/model/dd-user-mp.model';
import { DdUserMpService } from './dd-user-mp.service';

@Component({
  templateUrl: './dd-user-mp-delete-dialog.component.html',
})
export class DdUserMpDeleteDialogComponent {
  ddUser?: IDdUserMp;

  constructor(protected ddUserService: DdUserMpService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.ddUserService.delete(id).subscribe(() => {
      this.eventManager.broadcast('ddUserListModification');
      this.activeModal.close();
    });
  }
}
