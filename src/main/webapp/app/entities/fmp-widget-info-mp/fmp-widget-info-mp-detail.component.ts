import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IFmpWidgetInfoMp } from 'app/shared/model/fmp-widget-info-mp.model';

@Component({
  selector: 'jhi-fmp-widget-info-mp-detail',
  templateUrl: './fmp-widget-info-mp-detail.component.html',
})
export class FmpWidgetInfoMpDetailComponent implements OnInit {
  fmpWidgetInfo: IFmpWidgetInfoMp | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ fmpWidgetInfo }) => (this.fmpWidgetInfo = fmpWidgetInfo));
  }

  previousState(): void {
    window.history.back();
  }
}
