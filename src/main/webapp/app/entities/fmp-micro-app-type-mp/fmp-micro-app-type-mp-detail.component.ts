import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IFmpMicroAppTypeMp } from 'app/shared/model/fmp-micro-app-type-mp.model';

@Component({
  selector: 'jhi-fmp-micro-app-type-mp-detail',
  templateUrl: './fmp-micro-app-type-mp-detail.component.html',
})
export class FmpMicroAppTypeMpDetailComponent implements OnInit {
  fmpMicroAppType: IFmpMicroAppTypeMp | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ fmpMicroAppType }) => (this.fmpMicroAppType = fmpMicroAppType));
  }

  previousState(): void {
    window.history.back();
  }
}
