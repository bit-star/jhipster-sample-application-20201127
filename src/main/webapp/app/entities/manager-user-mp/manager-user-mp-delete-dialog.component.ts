import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IManagerUserMp } from 'app/shared/model/manager-user-mp.model';
import { ManagerUserMpService } from './manager-user-mp.service';

@Component({
  templateUrl: './manager-user-mp-delete-dialog.component.html',
})
export class ManagerUserMpDeleteDialogComponent {
  managerUser?: IManagerUserMp;

  constructor(
    protected managerUserService: ManagerUserMpService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.managerUserService.delete(id).subscribe(() => {
      this.eventManager.broadcast('managerUserListModification');
      this.activeModal.close();
    });
  }
}
