import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IFmpWidgetInfoMp } from 'app/shared/model/fmp-widget-info-mp.model';
import { FmpWidgetInfoMpService } from './fmp-widget-info-mp.service';
import { FmpWidgetInfoMpDeleteDialogComponent } from './fmp-widget-info-mp-delete-dialog.component';

@Component({
  selector: 'jhi-fmp-widget-info-mp',
  templateUrl: './fmp-widget-info-mp.component.html',
})
export class FmpWidgetInfoMpComponent implements OnInit, OnDestroy {
  fmpWidgetInfos?: IFmpWidgetInfoMp[];
  eventSubscriber?: Subscription;

  constructor(
    protected fmpWidgetInfoService: FmpWidgetInfoMpService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.fmpWidgetInfoService.query().subscribe((res: HttpResponse<IFmpWidgetInfoMp[]>) => (this.fmpWidgetInfos = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInFmpWidgetInfos();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IFmpWidgetInfoMp): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInFmpWidgetInfos(): void {
    this.eventSubscriber = this.eventManager.subscribe('fmpWidgetInfoListModification', () => this.loadAll());
  }

  delete(fmpWidgetInfo: IFmpWidgetInfoMp): void {
    const modalRef = this.modalService.open(FmpWidgetInfoMpDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.fmpWidgetInfo = fmpWidgetInfo;
  }
}
