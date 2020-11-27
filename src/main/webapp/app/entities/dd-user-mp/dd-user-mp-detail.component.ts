import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IDdUserMp } from 'app/shared/model/dd-user-mp.model';

@Component({
  selector: 'jhi-dd-user-mp-detail',
  templateUrl: './dd-user-mp-detail.component.html',
})
export class DdUserMpDetailComponent implements OnInit {
  ddUser: IDdUserMp | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ ddUser }) => (this.ddUser = ddUser));
  }

  previousState(): void {
    window.history.back();
  }
}
