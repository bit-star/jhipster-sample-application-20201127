import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IFmpMicroAppTypeMp } from 'app/shared/model/fmp-micro-app-type-mp.model';
import { FmpMicroAppTypeMpService } from './fmp-micro-app-type-mp.service';
import { FmpMicroAppTypeMpDeleteDialogComponent } from './fmp-micro-app-type-mp-delete-dialog.component';

@Component({
  selector: 'jhi-fmp-micro-app-type-mp',
  templateUrl: './fmp-micro-app-type-mp.component.html',
})
export class FmpMicroAppTypeMpComponent implements OnInit, OnDestroy {
  fmpMicroAppTypes?: IFmpMicroAppTypeMp[];
  eventSubscriber?: Subscription;

  constructor(
    protected fmpMicroAppTypeService: FmpMicroAppTypeMpService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.fmpMicroAppTypeService.query().subscribe((res: HttpResponse<IFmpMicroAppTypeMp[]>) => (this.fmpMicroAppTypes = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInFmpMicroAppTypes();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IFmpMicroAppTypeMp): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInFmpMicroAppTypes(): void {
    this.eventSubscriber = this.eventManager.subscribe('fmpMicroAppTypeListModification', () => this.loadAll());
  }

  delete(fmpMicroAppType: IFmpMicroAppTypeMp): void {
    const modalRef = this.modalService.open(FmpMicroAppTypeMpDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.fmpMicroAppType = fmpMicroAppType;
  }
}
