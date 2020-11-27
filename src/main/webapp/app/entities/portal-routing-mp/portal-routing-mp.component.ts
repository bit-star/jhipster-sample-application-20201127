import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IPortalRoutingMp } from 'app/shared/model/portal-routing-mp.model';
import { PortalRoutingMpService } from './portal-routing-mp.service';
import { PortalRoutingMpDeleteDialogComponent } from './portal-routing-mp-delete-dialog.component';

@Component({
  selector: 'jhi-portal-routing-mp',
  templateUrl: './portal-routing-mp.component.html',
})
export class PortalRoutingMpComponent implements OnInit, OnDestroy {
  portalRoutings?: IPortalRoutingMp[];
  eventSubscriber?: Subscription;

  constructor(
    protected portalRoutingService: PortalRoutingMpService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.portalRoutingService.query().subscribe((res: HttpResponse<IPortalRoutingMp[]>) => (this.portalRoutings = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInPortalRoutings();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IPortalRoutingMp): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInPortalRoutings(): void {
    this.eventSubscriber = this.eventManager.subscribe('portalRoutingListModification', () => this.loadAll());
  }

  delete(portalRouting: IPortalRoutingMp): void {
    const modalRef = this.modalService.open(PortalRoutingMpDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.portalRouting = portalRouting;
  }
}
