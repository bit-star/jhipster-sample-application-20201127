import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IDdUserPortalRoutingMp, DdUserPortalRoutingMp } from 'app/shared/model/dd-user-portal-routing-mp.model';
import { DdUserPortalRoutingMpService } from './dd-user-portal-routing-mp.service';

@Component({
  selector: 'jhi-dd-user-portal-routing-mp-update',
  templateUrl: './dd-user-portal-routing-mp-update.component.html',
})
export class DdUserPortalRoutingMpUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    jobCode: [],
    mobile: [],
    microappUrl: [],
    injectionFlag: [],
    injectionApiUri: [],
    mucAppId: [],
  });

  constructor(
    protected ddUserPortalRoutingService: DdUserPortalRoutingMpService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ ddUserPortalRouting }) => {
      this.updateForm(ddUserPortalRouting);
    });
  }

  updateForm(ddUserPortalRouting: IDdUserPortalRoutingMp): void {
    this.editForm.patchValue({
      id: ddUserPortalRouting.id,
      jobCode: ddUserPortalRouting.jobCode,
      mobile: ddUserPortalRouting.mobile,
      microappUrl: ddUserPortalRouting.microappUrl,
      injectionFlag: ddUserPortalRouting.injectionFlag,
      injectionApiUri: ddUserPortalRouting.injectionApiUri,
      mucAppId: ddUserPortalRouting.mucAppId,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const ddUserPortalRouting = this.createFromForm();
    if (ddUserPortalRouting.id !== undefined) {
      this.subscribeToSaveResponse(this.ddUserPortalRoutingService.update(ddUserPortalRouting));
    } else {
      this.subscribeToSaveResponse(this.ddUserPortalRoutingService.create(ddUserPortalRouting));
    }
  }

  private createFromForm(): IDdUserPortalRoutingMp {
    return {
      ...new DdUserPortalRoutingMp(),
      id: this.editForm.get(['id'])!.value,
      jobCode: this.editForm.get(['jobCode'])!.value,
      mobile: this.editForm.get(['mobile'])!.value,
      microappUrl: this.editForm.get(['microappUrl'])!.value,
      injectionFlag: this.editForm.get(['injectionFlag'])!.value,
      injectionApiUri: this.editForm.get(['injectionApiUri'])!.value,
      mucAppId: this.editForm.get(['mucAppId'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IDdUserPortalRoutingMp>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
