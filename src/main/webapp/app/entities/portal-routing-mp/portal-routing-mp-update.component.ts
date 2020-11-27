import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IPortalRoutingMp, PortalRoutingMp } from 'app/shared/model/portal-routing-mp.model';
import { PortalRoutingMpService } from './portal-routing-mp.service';

@Component({
  selector: 'jhi-portal-routing-mp-update',
  templateUrl: './portal-routing-mp-update.component.html',
})
export class PortalRoutingMpUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    mucAppOwner: [],
    mucAppId: [],
    mucAppUrl: [],
    mucAppName: [],
    mucAppNameEn: [],
  });

  constructor(protected portalRoutingService: PortalRoutingMpService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ portalRouting }) => {
      this.updateForm(portalRouting);
    });
  }

  updateForm(portalRouting: IPortalRoutingMp): void {
    this.editForm.patchValue({
      id: portalRouting.id,
      mucAppOwner: portalRouting.mucAppOwner,
      mucAppId: portalRouting.mucAppId,
      mucAppUrl: portalRouting.mucAppUrl,
      mucAppName: portalRouting.mucAppName,
      mucAppNameEn: portalRouting.mucAppNameEn,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const portalRouting = this.createFromForm();
    if (portalRouting.id !== undefined) {
      this.subscribeToSaveResponse(this.portalRoutingService.update(portalRouting));
    } else {
      this.subscribeToSaveResponse(this.portalRoutingService.create(portalRouting));
    }
  }

  private createFromForm(): IPortalRoutingMp {
    return {
      ...new PortalRoutingMp(),
      id: this.editForm.get(['id'])!.value,
      mucAppOwner: this.editForm.get(['mucAppOwner'])!.value,
      mucAppId: this.editForm.get(['mucAppId'])!.value,
      mucAppUrl: this.editForm.get(['mucAppUrl'])!.value,
      mucAppName: this.editForm.get(['mucAppName'])!.value,
      mucAppNameEn: this.editForm.get(['mucAppNameEn'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IPortalRoutingMp>>): void {
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
