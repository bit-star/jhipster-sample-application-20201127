import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IFmpMicroAppTypeMp } from 'app/shared/model/fmp-micro-app-type-mp.model';
import { FmpMicroAppTypeMpService } from './fmp-micro-app-type-mp.service';

@Component({
  templateUrl: './fmp-micro-app-type-mp-delete-dialog.component.html',
})
export class FmpMicroAppTypeMpDeleteDialogComponent {
  fmpMicroAppType?: IFmpMicroAppTypeMp;

  constructor(
    protected fmpMicroAppTypeService: FmpMicroAppTypeMpService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.fmpMicroAppTypeService.delete(id).subscribe(() => {
      this.eventManager.broadcast('fmpMicroAppTypeListModification');
      this.activeModal.close();
    });
  }
}
