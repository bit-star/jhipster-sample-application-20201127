import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IFmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';
import { FmpMicroAppMpService } from './fmp-micro-app-mp.service';

@Component({
  templateUrl: './fmp-micro-app-mp-delete-dialog.component.html',
})
export class FmpMicroAppMpDeleteDialogComponent {
  fmpMicroApp?: IFmpMicroAppMp;

  constructor(
    protected fmpMicroAppService: FmpMicroAppMpService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.fmpMicroAppService.delete(id).subscribe(() => {
      this.eventManager.broadcast('fmpMicroAppListModification');
      this.activeModal.close();
    });
  }
}
