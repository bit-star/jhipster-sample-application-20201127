import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IDdUserPortalRoutingMp } from 'app/shared/model/dd-user-portal-routing-mp.model';

@Component({
  selector: 'jhi-dd-user-portal-routing-mp-detail',
  templateUrl: './dd-user-portal-routing-mp-detail.component.html',
})
export class DdUserPortalRoutingMpDetailComponent implements OnInit {
  ddUserPortalRouting: IDdUserPortalRoutingMp | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ ddUserPortalRouting }) => (this.ddUserPortalRouting = ddUserPortalRouting));
  }

  previousState(): void {
    window.history.back();
  }
}
