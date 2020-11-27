import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IFmpMicroAppMp, FmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';
import { FmpMicroAppMpService } from './fmp-micro-app-mp.service';
import { IUucDepartmentTreeMp } from 'app/shared/model/uuc-department-tree-mp.model';
import { UucDepartmentTreeMpService } from 'app/entities/uuc-department-tree-mp/uuc-department-tree-mp.service';
import { IUucUserBaseinfoMp } from 'app/shared/model/uuc-user-baseinfo-mp.model';
import { UucUserBaseinfoMpService } from 'app/entities/uuc-user-baseinfo-mp/uuc-user-baseinfo-mp.service';
import { IFmpMicroAppTypeMp } from 'app/shared/model/fmp-micro-app-type-mp.model';
import { FmpMicroAppTypeMpService } from 'app/entities/fmp-micro-app-type-mp/fmp-micro-app-type-mp.service';
import { IFmpSubCompanyMp } from 'app/shared/model/fmp-sub-company-mp.model';
import { FmpSubCompanyMpService } from 'app/entities/fmp-sub-company-mp/fmp-sub-company-mp.service';

type SelectableEntity = IUucDepartmentTreeMp | IUucUserBaseinfoMp | IFmpMicroAppTypeMp | IFmpSubCompanyMp;

type SelectableManyToManyEntity = IUucDepartmentTreeMp | IUucUserBaseinfoMp;

@Component({
  selector: 'jhi-fmp-micro-app-mp-update',
  templateUrl: './fmp-micro-app-mp-update.component.html',
})
export class FmpMicroAppMpUpdateComponent implements OnInit {
  isSaving = false;
  uucdepartmenttrees: IUucDepartmentTreeMp[] = [];
  uucuserbaseinfos: IUucUserBaseinfoMp[] = [];
  fmpmicroapptypes: IFmpMicroAppTypeMp[] = [];
  fmpsubcompanies: IFmpSubCompanyMp[] = [];

  editForm = this.fb.group({
    id: [],
    catCode: [],
    parentCatId: [],
    levelNumber: [],
    isLeaf: [],
    businessCode: [],
    endpointUrl: [],
    iconImg: [],
    bannerImg: [],
    thumbnail: [],
    sortCode: [],
    systemType: [],
    contentOwnerCode: [],
    lable: [],
    isNew: [],
    status: [],
    openMethod: [],
    language: [],
    isFixed: [],
    tagKey01: [],
    tagVal01: [],
    tagKey02: [],
    tagVal02: [],
    tagKey03: [],
    tagVal03: [],
    catName: [],
    filterSql: [],
    sharingFlag: [],
    category: [],
    imgClass: [],
    isInternal: [],
    customFlag: [],
    portal: [],
    description: [],
    businessUnit: [],
    businessOwners: [],
    businessOwnersMobile: [],
    uucDepartmentTrees: [],
    usableUsers: [],
    fmpMicroAppType: [],
    creatorCompany: [],
  });

  constructor(
    protected fmpMicroAppService: FmpMicroAppMpService,
    protected uucDepartmentTreeService: UucDepartmentTreeMpService,
    protected uucUserBaseinfoService: UucUserBaseinfoMpService,
    protected fmpMicroAppTypeService: FmpMicroAppTypeMpService,
    protected fmpSubCompanyService: FmpSubCompanyMpService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ fmpMicroApp }) => {
      this.updateForm(fmpMicroApp);

      this.uucDepartmentTreeService
        .query()
        .subscribe((res: HttpResponse<IUucDepartmentTreeMp[]>) => (this.uucdepartmenttrees = res.body || []));

      this.uucUserBaseinfoService.query().subscribe((res: HttpResponse<IUucUserBaseinfoMp[]>) => (this.uucuserbaseinfos = res.body || []));

      this.fmpMicroAppTypeService.query().subscribe((res: HttpResponse<IFmpMicroAppTypeMp[]>) => (this.fmpmicroapptypes = res.body || []));

      this.fmpSubCompanyService.query().subscribe((res: HttpResponse<IFmpSubCompanyMp[]>) => (this.fmpsubcompanies = res.body || []));
    });
  }

  updateForm(fmpMicroApp: IFmpMicroAppMp): void {
    this.editForm.patchValue({
      id: fmpMicroApp.id,
      catCode: fmpMicroApp.catCode,
      parentCatId: fmpMicroApp.parentCatId,
      levelNumber: fmpMicroApp.levelNumber,
      isLeaf: fmpMicroApp.isLeaf,
      businessCode: fmpMicroApp.businessCode,
      endpointUrl: fmpMicroApp.endpointUrl,
      iconImg: fmpMicroApp.iconImg,
      bannerImg: fmpMicroApp.bannerImg,
      thumbnail: fmpMicroApp.thumbnail,
      sortCode: fmpMicroApp.sortCode,
      systemType: fmpMicroApp.systemType,
      contentOwnerCode: fmpMicroApp.contentOwnerCode,
      lable: fmpMicroApp.lable,
      isNew: fmpMicroApp.isNew,
      status: fmpMicroApp.status,
      openMethod: fmpMicroApp.openMethod,
      language: fmpMicroApp.language,
      isFixed: fmpMicroApp.isFixed,
      tagKey01: fmpMicroApp.tagKey01,
      tagVal01: fmpMicroApp.tagVal01,
      tagKey02: fmpMicroApp.tagKey02,
      tagVal02: fmpMicroApp.tagVal02,
      tagKey03: fmpMicroApp.tagKey03,
      tagVal03: fmpMicroApp.tagVal03,
      catName: fmpMicroApp.catName,
      filterSql: fmpMicroApp.filterSql,
      sharingFlag: fmpMicroApp.sharingFlag,
      category: fmpMicroApp.category,
      imgClass: fmpMicroApp.imgClass,
      isInternal: fmpMicroApp.isInternal,
      customFlag: fmpMicroApp.customFlag,
      portal: fmpMicroApp.portal,
      description: fmpMicroApp.description,
      businessUnit: fmpMicroApp.businessUnit,
      businessOwners: fmpMicroApp.businessOwners,
      businessOwnersMobile: fmpMicroApp.businessOwnersMobile,
      uucDepartmentTrees: fmpMicroApp.uucDepartmentTrees,
      usableUsers: fmpMicroApp.usableUsers,
      fmpMicroAppType: fmpMicroApp.fmpMicroAppType,
      creatorCompany: fmpMicroApp.creatorCompany,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const fmpMicroApp = this.createFromForm();
    if (fmpMicroApp.id !== undefined) {
      this.subscribeToSaveResponse(this.fmpMicroAppService.update(fmpMicroApp));
    } else {
      this.subscribeToSaveResponse(this.fmpMicroAppService.create(fmpMicroApp));
    }
  }

  private createFromForm(): IFmpMicroAppMp {
    return {
      ...new FmpMicroAppMp(),
      id: this.editForm.get(['id'])!.value,
      catCode: this.editForm.get(['catCode'])!.value,
      parentCatId: this.editForm.get(['parentCatId'])!.value,
      levelNumber: this.editForm.get(['levelNumber'])!.value,
      isLeaf: this.editForm.get(['isLeaf'])!.value,
      businessCode: this.editForm.get(['businessCode'])!.value,
      endpointUrl: this.editForm.get(['endpointUrl'])!.value,
      iconImg: this.editForm.get(['iconImg'])!.value,
      bannerImg: this.editForm.get(['bannerImg'])!.value,
      thumbnail: this.editForm.get(['thumbnail'])!.value,
      sortCode: this.editForm.get(['sortCode'])!.value,
      systemType: this.editForm.get(['systemType'])!.value,
      contentOwnerCode: this.editForm.get(['contentOwnerCode'])!.value,
      lable: this.editForm.get(['lable'])!.value,
      isNew: this.editForm.get(['isNew'])!.value,
      status: this.editForm.get(['status'])!.value,
      openMethod: this.editForm.get(['openMethod'])!.value,
      language: this.editForm.get(['language'])!.value,
      isFixed: this.editForm.get(['isFixed'])!.value,
      tagKey01: this.editForm.get(['tagKey01'])!.value,
      tagVal01: this.editForm.get(['tagVal01'])!.value,
      tagKey02: this.editForm.get(['tagKey02'])!.value,
      tagVal02: this.editForm.get(['tagVal02'])!.value,
      tagKey03: this.editForm.get(['tagKey03'])!.value,
      tagVal03: this.editForm.get(['tagVal03'])!.value,
      catName: this.editForm.get(['catName'])!.value,
      filterSql: this.editForm.get(['filterSql'])!.value,
      sharingFlag: this.editForm.get(['sharingFlag'])!.value,
      category: this.editForm.get(['category'])!.value,
      imgClass: this.editForm.get(['imgClass'])!.value,
      isInternal: this.editForm.get(['isInternal'])!.value,
      customFlag: this.editForm.get(['customFlag'])!.value,
      portal: this.editForm.get(['portal'])!.value,
      description: this.editForm.get(['description'])!.value,
      businessUnit: this.editForm.get(['businessUnit'])!.value,
      businessOwners: this.editForm.get(['businessOwners'])!.value,
      businessOwnersMobile: this.editForm.get(['businessOwnersMobile'])!.value,
      uucDepartmentTrees: this.editForm.get(['uucDepartmentTrees'])!.value,
      usableUsers: this.editForm.get(['usableUsers'])!.value,
      fmpMicroAppType: this.editForm.get(['fmpMicroAppType'])!.value,
      creatorCompany: this.editForm.get(['creatorCompany'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IFmpMicroAppMp>>): void {
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

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }

  getSelected(selectedVals: SelectableManyToManyEntity[], option: SelectableManyToManyEntity): SelectableManyToManyEntity {
    if (selectedVals) {
      for (let i = 0; i < selectedVals.length; i++) {
        if (option.id === selectedVals[i].id) {
          return selectedVals[i];
        }
      }
    }
    return option;
  }
}
