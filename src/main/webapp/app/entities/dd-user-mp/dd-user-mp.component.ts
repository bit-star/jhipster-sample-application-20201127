import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IDdUserMp } from 'app/shared/model/dd-user-mp.model';
import { DdUserMpService } from './dd-user-mp.service';
import { DdUserMpDeleteDialogComponent } from './dd-user-mp-delete-dialog.component';

@Component({
  selector: 'jhi-dd-user-mp',
  templateUrl: './dd-user-mp.component.html',
})
export class DdUserMpComponent implements OnInit, OnDestroy {
  ddUsers?: IDdUserMp[];
  eventSubscriber?: Subscription;

  constructor(protected ddUserService: DdUserMpService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.ddUserService.query().subscribe((res: HttpResponse<IDdUserMp[]>) => (this.ddUsers = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInDdUsers();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IDdUserMp): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInDdUsers(): void {
    this.eventSubscriber = this.eventManager.subscribe('ddUserListModification', () => this.loadAll());
  }

  delete(ddUser: IDdUserMp): void {
    const modalRef = this.modalService.open(DdUserMpDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.ddUser = ddUser;
  }
}
