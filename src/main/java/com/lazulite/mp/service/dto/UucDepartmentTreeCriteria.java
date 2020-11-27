package com.lazulite.mp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.InstantFilter;

/**
 * Criteria class for the {@link com.lazulite.mp.domain.UucDepartmentTree} entity. This class is used
 * in {@link com.lazulite.mp.web.rest.UucDepartmentTreeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /uuc-department-trees?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class UucDepartmentTreeCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter name;

    private StringFilter namePy;

    private StringFilter code;

    private StringFilter parentDepId;

    private StringFilter parentDepName;

    private StringFilter status;

    private StringFilter disporder;

    private StringFilter namePath;

    private StringFilter codePath;

    private StringFilter depIdPath;

    private StringFilter depLevel;

    private StringFilter aliveFlag;

    private InstantFilter recCreateTime;

    private StringFilter recCreator;

    private InstantFilter recReviseTime;

    private StringFilter recRevisor;

    private StringFilter deptUserCount;

    private StringFilter microappId;

    private StringFilter enName;

    private StringFilter onlyCode;

    private StringFilter srcDeptId;

    private StringFilter srcDeptType;

    private StringFilter srcType;

    private StringFilter srcDeptUcode;

    private LongFilter usableId;

    private LongFilter managerId;

    private LongFilter fmpSubCompanyId;

    private LongFilter microAppGroupId;

    public UucDepartmentTreeCriteria() {
    }

    public UucDepartmentTreeCriteria(UucDepartmentTreeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.name = other.name == null ? null : other.name.copy();
        this.namePy = other.namePy == null ? null : other.namePy.copy();
        this.code = other.code == null ? null : other.code.copy();
        this.parentDepId = other.parentDepId == null ? null : other.parentDepId.copy();
        this.parentDepName = other.parentDepName == null ? null : other.parentDepName.copy();
        this.status = other.status == null ? null : other.status.copy();
        this.disporder = other.disporder == null ? null : other.disporder.copy();
        this.namePath = other.namePath == null ? null : other.namePath.copy();
        this.codePath = other.codePath == null ? null : other.codePath.copy();
        this.depIdPath = other.depIdPath == null ? null : other.depIdPath.copy();
        this.depLevel = other.depLevel == null ? null : other.depLevel.copy();
        this.aliveFlag = other.aliveFlag == null ? null : other.aliveFlag.copy();
        this.recCreateTime = other.recCreateTime == null ? null : other.recCreateTime.copy();
        this.recCreator = other.recCreator == null ? null : other.recCreator.copy();
        this.recReviseTime = other.recReviseTime == null ? null : other.recReviseTime.copy();
        this.recRevisor = other.recRevisor == null ? null : other.recRevisor.copy();
        this.deptUserCount = other.deptUserCount == null ? null : other.deptUserCount.copy();
        this.microappId = other.microappId == null ? null : other.microappId.copy();
        this.enName = other.enName == null ? null : other.enName.copy();
        this.onlyCode = other.onlyCode == null ? null : other.onlyCode.copy();
        this.srcDeptId = other.srcDeptId == null ? null : other.srcDeptId.copy();
        this.srcDeptType = other.srcDeptType == null ? null : other.srcDeptType.copy();
        this.srcType = other.srcType == null ? null : other.srcType.copy();
        this.srcDeptUcode = other.srcDeptUcode == null ? null : other.srcDeptUcode.copy();
        this.usableId = other.usableId == null ? null : other.usableId.copy();
        this.managerId = other.managerId == null ? null : other.managerId.copy();
        this.fmpSubCompanyId = other.fmpSubCompanyId == null ? null : other.fmpSubCompanyId.copy();
        this.microAppGroupId = other.microAppGroupId == null ? null : other.microAppGroupId.copy();
    }

    @Override
    public UucDepartmentTreeCriteria copy() {
        return new UucDepartmentTreeCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public StringFilter getNamePy() {
        return namePy;
    }

    public void setNamePy(StringFilter namePy) {
        this.namePy = namePy;
    }

    public StringFilter getCode() {
        return code;
    }

    public void setCode(StringFilter code) {
        this.code = code;
    }

    public StringFilter getParentDepId() {
        return parentDepId;
    }

    public void setParentDepId(StringFilter parentDepId) {
        this.parentDepId = parentDepId;
    }

    public StringFilter getParentDepName() {
        return parentDepName;
    }

    public void setParentDepName(StringFilter parentDepName) {
        this.parentDepName = parentDepName;
    }

    public StringFilter getStatus() {
        return status;
    }

    public void setStatus(StringFilter status) {
        this.status = status;
    }

    public StringFilter getDisporder() {
        return disporder;
    }

    public void setDisporder(StringFilter disporder) {
        this.disporder = disporder;
    }

    public StringFilter getNamePath() {
        return namePath;
    }

    public void setNamePath(StringFilter namePath) {
        this.namePath = namePath;
    }

    public StringFilter getCodePath() {
        return codePath;
    }

    public void setCodePath(StringFilter codePath) {
        this.codePath = codePath;
    }

    public StringFilter getDepIdPath() {
        return depIdPath;
    }

    public void setDepIdPath(StringFilter depIdPath) {
        this.depIdPath = depIdPath;
    }

    public StringFilter getDepLevel() {
        return depLevel;
    }

    public void setDepLevel(StringFilter depLevel) {
        this.depLevel = depLevel;
    }

    public StringFilter getAliveFlag() {
        return aliveFlag;
    }

    public void setAliveFlag(StringFilter aliveFlag) {
        this.aliveFlag = aliveFlag;
    }

    public InstantFilter getRecCreateTime() {
        return recCreateTime;
    }

    public void setRecCreateTime(InstantFilter recCreateTime) {
        this.recCreateTime = recCreateTime;
    }

    public StringFilter getRecCreator() {
        return recCreator;
    }

    public void setRecCreator(StringFilter recCreator) {
        this.recCreator = recCreator;
    }

    public InstantFilter getRecReviseTime() {
        return recReviseTime;
    }

    public void setRecReviseTime(InstantFilter recReviseTime) {
        this.recReviseTime = recReviseTime;
    }

    public StringFilter getRecRevisor() {
        return recRevisor;
    }

    public void setRecRevisor(StringFilter recRevisor) {
        this.recRevisor = recRevisor;
    }

    public StringFilter getDeptUserCount() {
        return deptUserCount;
    }

    public void setDeptUserCount(StringFilter deptUserCount) {
        this.deptUserCount = deptUserCount;
    }

    public StringFilter getMicroappId() {
        return microappId;
    }

    public void setMicroappId(StringFilter microappId) {
        this.microappId = microappId;
    }

    public StringFilter getEnName() {
        return enName;
    }

    public void setEnName(StringFilter enName) {
        this.enName = enName;
    }

    public StringFilter getOnlyCode() {
        return onlyCode;
    }

    public void setOnlyCode(StringFilter onlyCode) {
        this.onlyCode = onlyCode;
    }

    public StringFilter getSrcDeptId() {
        return srcDeptId;
    }

    public void setSrcDeptId(StringFilter srcDeptId) {
        this.srcDeptId = srcDeptId;
    }

    public StringFilter getSrcDeptType() {
        return srcDeptType;
    }

    public void setSrcDeptType(StringFilter srcDeptType) {
        this.srcDeptType = srcDeptType;
    }

    public StringFilter getSrcType() {
        return srcType;
    }

    public void setSrcType(StringFilter srcType) {
        this.srcType = srcType;
    }

    public StringFilter getSrcDeptUcode() {
        return srcDeptUcode;
    }

    public void setSrcDeptUcode(StringFilter srcDeptUcode) {
        this.srcDeptUcode = srcDeptUcode;
    }

    public LongFilter getUsableId() {
        return usableId;
    }

    public void setUsableId(LongFilter usableId) {
        this.usableId = usableId;
    }

    public LongFilter getManagerId() {
        return managerId;
    }

    public void setManagerId(LongFilter managerId) {
        this.managerId = managerId;
    }

    public LongFilter getFmpSubCompanyId() {
        return fmpSubCompanyId;
    }

    public void setFmpSubCompanyId(LongFilter fmpSubCompanyId) {
        this.fmpSubCompanyId = fmpSubCompanyId;
    }

    public LongFilter getMicroAppGroupId() {
        return microAppGroupId;
    }

    public void setMicroAppGroupId(LongFilter microAppGroupId) {
        this.microAppGroupId = microAppGroupId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UucDepartmentTreeCriteria that = (UucDepartmentTreeCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(namePy, that.namePy) &&
            Objects.equals(code, that.code) &&
            Objects.equals(parentDepId, that.parentDepId) &&
            Objects.equals(parentDepName, that.parentDepName) &&
            Objects.equals(status, that.status) &&
            Objects.equals(disporder, that.disporder) &&
            Objects.equals(namePath, that.namePath) &&
            Objects.equals(codePath, that.codePath) &&
            Objects.equals(depIdPath, that.depIdPath) &&
            Objects.equals(depLevel, that.depLevel) &&
            Objects.equals(aliveFlag, that.aliveFlag) &&
            Objects.equals(recCreateTime, that.recCreateTime) &&
            Objects.equals(recCreator, that.recCreator) &&
            Objects.equals(recReviseTime, that.recReviseTime) &&
            Objects.equals(recRevisor, that.recRevisor) &&
            Objects.equals(deptUserCount, that.deptUserCount) &&
            Objects.equals(microappId, that.microappId) &&
            Objects.equals(enName, that.enName) &&
            Objects.equals(onlyCode, that.onlyCode) &&
            Objects.equals(srcDeptId, that.srcDeptId) &&
            Objects.equals(srcDeptType, that.srcDeptType) &&
            Objects.equals(srcType, that.srcType) &&
            Objects.equals(srcDeptUcode, that.srcDeptUcode) &&
            Objects.equals(usableId, that.usableId) &&
            Objects.equals(managerId, that.managerId) &&
            Objects.equals(fmpSubCompanyId, that.fmpSubCompanyId) &&
            Objects.equals(microAppGroupId, that.microAppGroupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        name,
        namePy,
        code,
        parentDepId,
        parentDepName,
        status,
        disporder,
        namePath,
        codePath,
        depIdPath,
        depLevel,
        aliveFlag,
        recCreateTime,
        recCreator,
        recReviseTime,
        recRevisor,
        deptUserCount,
        microappId,
        enName,
        onlyCode,
        srcDeptId,
        srcDeptType,
        srcType,
        srcDeptUcode,
        usableId,
        managerId,
        fmpSubCompanyId,
        microAppGroupId
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UucDepartmentTreeCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (name != null ? "name=" + name + ", " : "") +
                (namePy != null ? "namePy=" + namePy + ", " : "") +
                (code != null ? "code=" + code + ", " : "") +
                (parentDepId != null ? "parentDepId=" + parentDepId + ", " : "") +
                (parentDepName != null ? "parentDepName=" + parentDepName + ", " : "") +
                (status != null ? "status=" + status + ", " : "") +
                (disporder != null ? "disporder=" + disporder + ", " : "") +
                (namePath != null ? "namePath=" + namePath + ", " : "") +
                (codePath != null ? "codePath=" + codePath + ", " : "") +
                (depIdPath != null ? "depIdPath=" + depIdPath + ", " : "") +
                (depLevel != null ? "depLevel=" + depLevel + ", " : "") +
                (aliveFlag != null ? "aliveFlag=" + aliveFlag + ", " : "") +
                (recCreateTime != null ? "recCreateTime=" + recCreateTime + ", " : "") +
                (recCreator != null ? "recCreator=" + recCreator + ", " : "") +
                (recReviseTime != null ? "recReviseTime=" + recReviseTime + ", " : "") +
                (recRevisor != null ? "recRevisor=" + recRevisor + ", " : "") +
                (deptUserCount != null ? "deptUserCount=" + deptUserCount + ", " : "") +
                (microappId != null ? "microappId=" + microappId + ", " : "") +
                (enName != null ? "enName=" + enName + ", " : "") +
                (onlyCode != null ? "onlyCode=" + onlyCode + ", " : "") +
                (srcDeptId != null ? "srcDeptId=" + srcDeptId + ", " : "") +
                (srcDeptType != null ? "srcDeptType=" + srcDeptType + ", " : "") +
                (srcType != null ? "srcType=" + srcType + ", " : "") +
                (srcDeptUcode != null ? "srcDeptUcode=" + srcDeptUcode + ", " : "") +
                (usableId != null ? "usableId=" + usableId + ", " : "") +
                (managerId != null ? "managerId=" + managerId + ", " : "") +
                (fmpSubCompanyId != null ? "fmpSubCompanyId=" + fmpSubCompanyId + ", " : "") +
                (microAppGroupId != null ? "microAppGroupId=" + microAppGroupId + ", " : "") +
            "}";
    }

}
