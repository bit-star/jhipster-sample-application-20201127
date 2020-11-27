import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IPortalRoutingMp } from 'app/shared/model/portal-routing-mp.model';

@Component({
  selector: 'jhi-portal-routing-mp-detail',
  templateUrl: './portal-routing-mp-detail.component.html',
})
export class PortalRoutingMpDetailComponent implements OnInit {
  portalRouting: IPortalRoutingMp | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ portalRouting }) => (this.portalRouting = portalRouting));
  }

  previousState(): void {
    window.history.back();
  }
}
