import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IFmpWidgetInfoMp } from 'app/shared/model/fmp-widget-info-mp.model';
import { FmpWidgetInfoMpService } from './fmp-widget-info-mp.service';

@Component({
  templateUrl: './fmp-widget-info-mp-delete-dialog.component.html',
})
export class FmpWidgetInfoMpDeleteDialogComponent {
  fmpWidgetInfo?: IFmpWidgetInfoMp;

  constructor(
    protected fmpWidgetInfoService: FmpWidgetInfoMpService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.fmpWidgetInfoService.delete(id).subscribe(() => {
      this.eventManager.broadcast('fmpWidgetInfoListModification');
      this.activeModal.close();
    });
  }
}
