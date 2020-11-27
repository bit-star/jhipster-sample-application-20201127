import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IFmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';

@Component({
  selector: 'jhi-fmp-micro-app-mp-detail',
  templateUrl: './fmp-micro-app-mp-detail.component.html',
})
export class FmpMicroAppMpDetailComponent implements OnInit {
  fmpMicroApp: IFmpMicroAppMp | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ fmpMicroApp }) => (this.fmpMicroApp = fmpMicroApp));
  }

  previousState(): void {
    window.history.back();
  }
}
