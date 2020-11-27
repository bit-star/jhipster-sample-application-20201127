import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IFmpWidgetInfoMp, FmpWidgetInfoMp } from 'app/shared/model/fmp-widget-info-mp.model';
import { FmpWidgetInfoMpService } from './fmp-widget-info-mp.service';
import { IFmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';
import { FmpMicroAppMpService } from 'app/entities/fmp-micro-app-mp/fmp-micro-app-mp.service';

@Component({
  selector: 'jhi-fmp-widget-info-mp-update',
  templateUrl: './fmp-widget-info-mp-update.component.html',
})
export class FmpWidgetInfoMpUpdateComponent implements OnInit {
  isSaving = false;
  fmpmicroapps: IFmpMicroAppMp[] = [];

  editForm = this.fb.group({
    id: [],
    code: [],
    portalId: [],
    title: [],
    catId: [],
    dataUrl: [],
    sort: [],
    dataUrlParam: [],
    isTop: [],
    contentType: [],
    type: [],
    isDeleted: [],
    fmpMicroApp: [],
  });

  constructor(
    protected fmpWidgetInfoService: FmpWidgetInfoMpService,
    protected fmpMicroAppService: FmpMicroAppMpService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ fmpWidgetInfo }) => {
      this.updateForm(fmpWidgetInfo);

      this.fmpMicroAppService.query().subscribe((res: HttpResponse<IFmpMicroAppMp[]>) => (this.fmpmicroapps = res.body || []));
    });
  }

  updateForm(fmpWidgetInfo: IFmpWidgetInfoMp): void {
    this.editForm.patchValue({
      id: fmpWidgetInfo.id,
      code: fmpWidgetInfo.code,
      portalId: fmpWidgetInfo.portalId,
      title: fmpWidgetInfo.title,
      catId: fmpWidgetInfo.catId,
      dataUrl: fmpWidgetInfo.dataUrl,
      sort: fmpWidgetInfo.sort,
      dataUrlParam: fmpWidgetInfo.dataUrlParam,
      isTop: fmpWidgetInfo.isTop,
      contentType: fmpWidgetInfo.contentType,
      type: fmpWidgetInfo.type,
      isDeleted: fmpWidgetInfo.isDeleted,
      fmpMicroApp: fmpWidgetInfo.fmpMicroApp,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const fmpWidgetInfo = this.createFromForm();
    if (fmpWidgetInfo.id !== undefined) {
      this.subscribeToSaveResponse(this.fmpWidgetInfoService.update(fmpWidgetInfo));
    } else {
      this.subscribeToSaveResponse(this.fmpWidgetInfoService.create(fmpWidgetInfo));
    }
  }

  private createFromForm(): IFmpWidgetInfoMp {
    return {
      ...new FmpWidgetInfoMp(),
      id: this.editForm.get(['id'])!.value,
      code: this.editForm.get(['code'])!.value,
      portalId: this.editForm.get(['portalId'])!.value,
      title: this.editForm.get(['title'])!.value,
      catId: this.editForm.get(['catId'])!.value,
      dataUrl: this.editForm.get(['dataUrl'])!.value,
      sort: this.editForm.get(['sort'])!.value,
      dataUrlParam: this.editForm.get(['dataUrlParam'])!.value,
      isTop: this.editForm.get(['isTop'])!.value,
      contentType: this.editForm.get(['contentType'])!.value,
      type: this.editForm.get(['type'])!.value,
      isDeleted: this.editForm.get(['isDeleted'])!.value,
      fmpMicroApp: this.editForm.get(['fmpMicroApp'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IFmpWidgetInfoMp>>): void {
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

  trackById(index: number, item: IFmpMicroAppMp): any {
    return item.id;
  }
}
