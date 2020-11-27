import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IManagerUserMp } from 'app/shared/model/manager-user-mp.model';

@Component({
  selector: 'jhi-manager-user-mp-detail',
  templateUrl: './manager-user-mp-detail.component.html',
})
export class ManagerUserMpDetailComponent implements OnInit {
  managerUser: IManagerUserMp | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ managerUser }) => (this.managerUser = managerUser));
  }

  previousState(): void {
    window.history.back();
  }
}
