import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IFmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';
import { FmpMicroAppMpService } from './fmp-micro-app-mp.service';
import { FmpMicroAppMpDeleteDialogComponent } from './fmp-micro-app-mp-delete-dialog.component';

@Component({
  selector: 'jhi-fmp-micro-app-mp',
  templateUrl: './fmp-micro-app-mp.component.html',
})
export class FmpMicroAppMpComponent implements OnInit, OnDestroy {
  fmpMicroApps?: IFmpMicroAppMp[];
  eventSubscriber?: Subscription;

  constructor(
    protected fmpMicroAppService: FmpMicroAppMpService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.fmpMicroAppService.query().subscribe((res: HttpResponse<IFmpMicroAppMp[]>) => (this.fmpMicroApps = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInFmpMicroApps();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IFmpMicroAppMp): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInFmpMicroApps(): void {
    this.eventSubscriber = this.eventManager.subscribe('fmpMicroAppListModification', () => this.loadAll());
  }

  delete(fmpMicroApp: IFmpMicroAppMp): void {
    const modalRef = this.modalService.open(FmpMicroAppMpDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.fmpMicroApp = fmpMicroApp;
  }
}
