import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IBannerMp } from 'app/shared/model/banner-mp.model';
import { BannerMpService } from './banner-mp.service';
import { BannerMpDeleteDialogComponent } from './banner-mp-delete-dialog.component';

@Component({
  selector: 'jhi-banner-mp',
  templateUrl: './banner-mp.component.html',
})
export class BannerMpComponent implements OnInit, OnDestroy {
  banners?: IBannerMp[];
  eventSubscriber?: Subscription;

  constructor(protected bannerService: BannerMpService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.bannerService.query().subscribe((res: HttpResponse<IBannerMp[]>) => (this.banners = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInBanners();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IBannerMp): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInBanners(): void {
    this.eventSubscriber = this.eventManager.subscribe('bannerListModification', () => this.loadAll());
  }

  delete(banner: IBannerMp): void {
    const modalRef = this.modalService.open(BannerMpDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.banner = banner;
  }
}
