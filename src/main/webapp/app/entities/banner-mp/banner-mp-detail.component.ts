import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IBannerMp } from 'app/shared/model/banner-mp.model';

@Component({
  selector: 'jhi-banner-mp-detail',
  templateUrl: './banner-mp-detail.component.html',
})
export class BannerMpDetailComponent implements OnInit {
  banner: IBannerMp | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ banner }) => (this.banner = banner));
  }

  previousState(): void {
    window.history.back();
  }
}
