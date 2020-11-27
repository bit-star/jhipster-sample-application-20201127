import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IDdUserPortalRoutingMp } from 'app/shared/model/dd-user-portal-routing-mp.model';
import { DdUserPortalRoutingMpService } from './dd-user-portal-routing-mp.service';
import { DdUserPortalRoutingMpDeleteDialogComponent } from './dd-user-portal-routing-mp-delete-dialog.component';

@Component({
  selector: 'jhi-dd-user-portal-routing-mp',
  templateUrl: './dd-user-portal-routing-mp.component.html',
})
export class DdUserPortalRoutingMpComponent implements OnInit, OnDestroy {
  ddUserPortalRoutings?: IDdUserPortalRoutingMp[];
  eventSubscriber?: Subscription;

  constructor(
    protected ddUserPortalRoutingService: DdUserPortalRoutingMpService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.ddUserPortalRoutingService
      .query()
      .subscribe((res: HttpResponse<IDdUserPortalRoutingMp[]>) => (this.ddUserPortalRoutings = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInDdUserPortalRoutings();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IDdUserPortalRoutingMp): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInDdUserPortalRoutings(): void {
    this.eventSubscriber = this.eventManager.subscribe('ddUserPortalRoutingListModification', () => this.loadAll());
  }

  delete(ddUserPortalRouting: IDdUserPortalRoutingMp): void {
    const modalRef = this.modalService.open(DdUserPortalRoutingMpDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.ddUserPortalRouting = ddUserPortalRouting;
  }
}
