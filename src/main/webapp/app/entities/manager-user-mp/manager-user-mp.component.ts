import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IManagerUserMp } from 'app/shared/model/manager-user-mp.model';
import { ManagerUserMpService } from './manager-user-mp.service';
import { ManagerUserMpDeleteDialogComponent } from './manager-user-mp-delete-dialog.component';

@Component({
  selector: 'jhi-manager-user-mp',
  templateUrl: './manager-user-mp.component.html',
})
export class ManagerUserMpComponent implements OnInit, OnDestroy {
  managerUsers?: IManagerUserMp[];
  eventSubscriber?: Subscription;

  constructor(
    protected managerUserService: ManagerUserMpService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.managerUserService.query().subscribe((res: HttpResponse<IManagerUserMp[]>) => (this.managerUsers = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInManagerUsers();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IManagerUserMp): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInManagerUsers(): void {
    this.eventSubscriber = this.eventManager.subscribe('managerUserListModification', () => this.loadAll());
  }

  delete(managerUser: IManagerUserMp): void {
    const modalRef = this.modalService.open(ManagerUserMpDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.managerUser = managerUser;
  }
}
