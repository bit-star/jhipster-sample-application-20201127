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
 * Criteria class for the {@link com.lazulite.mp.domain.UucUserBaseinfo} entity. This class is used
 * in {@link com.lazulite.mp.web.rest.UucUserBaseinfoResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /uuc-user-baseinfos?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class UucUserBaseinfoCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter jobCode;

    private StringFilter type;

    private StringFilter fullname;

    private StringFilter namePy;

    private StringFilter sex;

    private StringFilter birthday;

    private StringFilter email;

    private StringFilter tel;

    private StringFilter telExt;

    private StringFilter stateCode1;

    private StringFilter mobile1;

    private StringFilter stateCode2;

    private StringFilter mobile2;

    private StringFilter stateCode3;

    private StringFilter mobile3;

    private StringFilter stateCode4;

    private StringFilter mobile4;

    private StringFilter stateCode5;

    private StringFilter mobile5;

    private StringFilter titleDesc;

    private StringFilter titleEn;

    private StringFilter checkNum;

    private IntegerFilter disporder;

    private StringFilter workPlace;

    private StringFilter userLevel;

    private InstantFilter hiredate;

    private StringFilter nickname;

    private StringFilter memo;

    private StringFilter isHidden;

    private StringFilter aliveFlag;

    private InstantFilter recCreateTime;

    private StringFilter recCreator;

    private InstantFilter recReviseTime;

    private StringFilter recRevisor;

    private StringFilter isActivated;

    private InstantFilter activationTime;

    private StringFilter appVersion;

    private StringFilter isOnlyAdminTitle;

    private StringFilter jobnumber;

    private StringFilter avatar;

    private StringFilter enName;

    private StringFilter enWorkplace;

    private StringFilter enTitleDesc;

    private StringFilter onlyCode;

    private StringFilter hrCardId;

    private StringFilter employeeType;

    private LongFilter collectionFmpMicroAppId;

    private LongFilter usableFmpMicroAppId;

    private LongFilter microAppGroupId;

    public UucUserBaseinfoCriteria() {
    }

    public UucUserBaseinfoCriteria(UucUserBaseinfoCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.jobCode = other.jobCode == null ? null : other.jobCode.copy();
        this.type = other.type == null ? null : other.type.copy();
        this.fullname = other.fullname == null ? null : other.fullname.copy();
        this.namePy = other.namePy == null ? null : other.namePy.copy();
        this.sex = other.sex == null ? null : other.sex.copy();
        this.birthday = other.birthday == null ? null : other.birthday.copy();
        this.email = other.email == null ? null : other.email.copy();
        this.tel = other.tel == null ? null : other.tel.copy();
        this.telExt = other.telExt == null ? null : other.telExt.copy();
        this.stateCode1 = other.stateCode1 == null ? null : other.stateCode1.copy();
        this.mobile1 = other.mobile1 == null ? null : other.mobile1.copy();
        this.stateCode2 = other.stateCode2 == null ? null : other.stateCode2.copy();
        this.mobile2 = other.mobile2 == null ? null : other.mobile2.copy();
        this.stateCode3 = other.stateCode3 == null ? null : other.stateCode3.copy();
        this.mobile3 = other.mobile3 == null ? null : other.mobile3.copy();
        this.stateCode4 = other.stateCode4 == null ? null : other.stateCode4.copy();
        this.mobile4 = other.mobile4 == null ? null : other.mobile4.copy();
        this.stateCode5 = other.stateCode5 == null ? null : other.stateCode5.copy();
        this.mobile5 = other.mobile5 == null ? null : other.mobile5.copy();
        this.titleDesc = other.titleDesc == null ? null : other.titleDesc.copy();
        this.titleEn = other.titleEn == null ? null : other.titleEn.copy();
        this.checkNum = other.checkNum == null ? null : other.checkNum.copy();
        this.disporder = other.disporder == null ? null : other.disporder.copy();
        this.workPlace = other.workPlace == null ? null : other.workPlace.copy();
        this.userLevel = other.userLevel == null ? null : other.userLevel.copy();
        this.hiredate = other.hiredate == null ? null : other.hiredate.copy();
        this.nickname = other.nickname == null ? null : other.nickname.copy();
        this.memo = other.memo == null ? null : other.memo.copy();
        this.isHidden = other.isHidden == null ? null : other.isHidden.copy();
        this.aliveFlag = other.aliveFlag == null ? null : other.aliveFlag.copy();
        this.recCreateTime = other.recCreateTime == null ? null : other.recCreateTime.copy();
        this.recCreator = other.recCreator == null ? null : other.recCreator.copy();
        this.recReviseTime = other.recReviseTime == null ? null : other.recReviseTime.copy();
        this.recRevisor = other.recRevisor == null ? null : other.recRevisor.copy();
        this.isActivated = other.isActivated == null ? null : other.isActivated.copy();
        this.activationTime = other.activationTime == null ? null : other.activationTime.copy();
        this.appVersion = other.appVersion == null ? null : other.appVersion.copy();
        this.isOnlyAdminTitle = other.isOnlyAdminTitle == null ? null : other.isOnlyAdminTitle.copy();
        this.jobnumber = other.jobnumber == null ? null : other.jobnumber.copy();
        this.avatar = other.avatar == null ? null : other.avatar.copy();
        this.enName = other.enName == null ? null : other.enName.copy();
        this.enWorkplace = other.enWorkplace == null ? null : other.enWorkplace.copy();
        this.enTitleDesc = other.enTitleDesc == null ? null : other.enTitleDesc.copy();
        this.onlyCode = other.onlyCode == null ? null : other.onlyCode.copy();
        this.hrCardId = other.hrCardId == null ? null : other.hrCardId.copy();
        this.employeeType = other.employeeType == null ? null : other.employeeType.copy();
        this.collectionFmpMicroAppId = other.collectionFmpMicroAppId == null ? null : other.collectionFmpMicroAppId.copy();
        this.usableFmpMicroAppId = other.usableFmpMicroAppId == null ? null : other.usableFmpMicroAppId.copy();
        this.microAppGroupId = other.microAppGroupId == null ? null : other.microAppGroupId.copy();
    }

    @Override
    public UucUserBaseinfoCriteria copy() {
        return new UucUserBaseinfoCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getJobCode() {
        return jobCode;
    }

    public void setJobCode(StringFilter jobCode) {
        this.jobCode = jobCode;
    }

    public StringFilter getType() {
        return type;
    }

    public void setType(StringFilter type) {
        this.type = type;
    }

    public StringFilter getFullname() {
        return fullname;
    }

    public void setFullname(StringFilter fullname) {
        this.fullname = fullname;
    }

    public StringFilter getNamePy() {
        return namePy;
    }

    public void setNamePy(StringFilter namePy) {
        this.namePy = namePy;
    }

    public StringFilter getSex() {
        return sex;
    }

    public void setSex(StringFilter sex) {
        this.sex = sex;
    }

    public StringFilter getBirthday() {
        return birthday;
    }

    public void setBirthday(StringFilter birthday) {
        this.birthday = birthday;
    }

    public StringFilter getEmail() {
        return email;
    }

    public void setEmail(StringFilter email) {
        this.email = email;
    }

    public StringFilter getTel() {
        return tel;
    }

    public void setTel(StringFilter tel) {
        this.tel = tel;
    }

    public StringFilter getTelExt() {
        return telExt;
    }

    public void setTelExt(StringFilter telExt) {
        this.telExt = telExt;
    }

    public StringFilter getStateCode1() {
        return stateCode1;
    }

    public void setStateCode1(StringFilter stateCode1) {
        this.stateCode1 = stateCode1;
    }

    public StringFilter getMobile1() {
        return mobile1;
    }

    public void setMobile1(StringFilter mobile1) {
        this.mobile1 = mobile1;
    }

    public StringFilter getStateCode2() {
        return stateCode2;
    }

    public void setStateCode2(StringFilter stateCode2) {
        this.stateCode2 = stateCode2;
    }

    public StringFilter getMobile2() {
        return mobile2;
    }

    public void setMobile2(StringFilter mobile2) {
        this.mobile2 = mobile2;
    }

    public StringFilter getStateCode3() {
        return stateCode3;
    }

    public void setStateCode3(StringFilter stateCode3) {
        this.stateCode3 = stateCode3;
    }

    public StringFilter getMobile3() {
        return mobile3;
    }

    public void setMobile3(StringFilter mobile3) {
        this.mobile3 = mobile3;
    }

    public StringFilter getStateCode4() {
        return stateCode4;
    }

    public void setStateCode4(StringFilter stateCode4) {
        this.stateCode4 = stateCode4;
    }

    public StringFilter getMobile4() {
        return mobile4;
    }

    public void setMobile4(StringFilter mobile4) {
        this.mobile4 = mobile4;
    }

    public StringFilter getStateCode5() {
        return stateCode5;
    }

    public void setStateCode5(StringFilter stateCode5) {
        this.stateCode5 = stateCode5;
    }

    public StringFilter getMobile5() {
        return mobile5;
    }

    public void setMobile5(StringFilter mobile5) {
        this.mobile5 = mobile5;
    }

    public StringFilter getTitleDesc() {
        return titleDesc;
    }

    public void setTitleDesc(StringFilter titleDesc) {
        this.titleDesc = titleDesc;
    }

    public StringFilter getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(StringFilter titleEn) {
        this.titleEn = titleEn;
    }

    public StringFilter getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(StringFilter checkNum) {
        this.checkNum = checkNum;
    }

    public IntegerFilter getDisporder() {
        return disporder;
    }

    public void setDisporder(IntegerFilter disporder) {
        this.disporder = disporder;
    }

    public StringFilter getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(StringFilter workPlace) {
        this.workPlace = workPlace;
    }

    public StringFilter getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(StringFilter userLevel) {
        this.userLevel = userLevel;
    }

    public InstantFilter getHiredate() {
        return hiredate;
    }

    public void setHiredate(InstantFilter hiredate) {
        this.hiredate = hiredate;
    }

    public StringFilter getNickname() {
        return nickname;
    }

    public void setNickname(StringFilter nickname) {
        this.nickname = nickname;
    }

    public StringFilter getMemo() {
        return memo;
    }

    public void setMemo(StringFilter memo) {
        this.memo = memo;
    }

    public StringFilter getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(StringFilter isHidden) {
        this.isHidden = isHidden;
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

    public StringFilter getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(StringFilter isActivated) {
        this.isActivated = isActivated;
    }

    public InstantFilter getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(InstantFilter activationTime) {
        this.activationTime = activationTime;
    }

    public StringFilter getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(StringFilter appVersion) {
        this.appVersion = appVersion;
    }

    public StringFilter getIsOnlyAdminTitle() {
        return isOnlyAdminTitle;
    }

    public void setIsOnlyAdminTitle(StringFilter isOnlyAdminTitle) {
        this.isOnlyAdminTitle = isOnlyAdminTitle;
    }

    public StringFilter getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(StringFilter jobnumber) {
        this.jobnumber = jobnumber;
    }

    public StringFilter getAvatar() {
        return avatar;
    }

    public void setAvatar(StringFilter avatar) {
        this.avatar = avatar;
    }

    public StringFilter getEnName() {
        return enName;
    }

    public void setEnName(StringFilter enName) {
        this.enName = enName;
    }

    public StringFilter getEnWorkplace() {
        return enWorkplace;
    }

    public void setEnWorkplace(StringFilter enWorkplace) {
        this.enWorkplace = enWorkplace;
    }

    public StringFilter getEnTitleDesc() {
        return enTitleDesc;
    }

    public void setEnTitleDesc(StringFilter enTitleDesc) {
        this.enTitleDesc = enTitleDesc;
    }

    public StringFilter getOnlyCode() {
        return onlyCode;
    }

    public void setOnlyCode(StringFilter onlyCode) {
        this.onlyCode = onlyCode;
    }

    public StringFilter getHrCardId() {
        return hrCardId;
    }

    public void setHrCardId(StringFilter hrCardId) {
        this.hrCardId = hrCardId;
    }

    public StringFilter getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(StringFilter employeeType) {
        this.employeeType = employeeType;
    }

    public LongFilter getCollectionFmpMicroAppId() {
        return collectionFmpMicroAppId;
    }

    public void setCollectionFmpMicroAppId(LongFilter collectionFmpMicroAppId) {
        this.collectionFmpMicroAppId = collectionFmpMicroAppId;
    }

    public LongFilter getUsableFmpMicroAppId() {
        return usableFmpMicroAppId;
    }

    public void setUsableFmpMicroAppId(LongFilter usableFmpMicroAppId) {
        this.usableFmpMicroAppId = usableFmpMicroAppId;
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
        final UucUserBaseinfoCriteria that = (UucUserBaseinfoCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(jobCode, that.jobCode) &&
            Objects.equals(type, that.type) &&
            Objects.equals(fullname, that.fullname) &&
            Objects.equals(namePy, that.namePy) &&
            Objects.equals(sex, that.sex) &&
            Objects.equals(birthday, that.birthday) &&
            Objects.equals(email, that.email) &&
            Objects.equals(tel, that.tel) &&
            Objects.equals(telExt, that.telExt) &&
            Objects.equals(stateCode1, that.stateCode1) &&
            Objects.equals(mobile1, that.mobile1) &&
            Objects.equals(stateCode2, that.stateCode2) &&
            Objects.equals(mobile2, that.mobile2) &&
            Objects.equals(stateCode3, that.stateCode3) &&
            Objects.equals(mobile3, that.mobile3) &&
            Objects.equals(stateCode4, that.stateCode4) &&
            Objects.equals(mobile4, that.mobile4) &&
            Objects.equals(stateCode5, that.stateCode5) &&
            Objects.equals(mobile5, that.mobile5) &&
            Objects.equals(titleDesc, that.titleDesc) &&
            Objects.equals(titleEn, that.titleEn) &&
            Objects.equals(checkNum, that.checkNum) &&
            Objects.equals(disporder, that.disporder) &&
            Objects.equals(workPlace, that.workPlace) &&
            Objects.equals(userLevel, that.userLevel) &&
            Objects.equals(hiredate, that.hiredate) &&
            Objects.equals(nickname, that.nickname) &&
            Objects.equals(memo, that.memo) &&
            Objects.equals(isHidden, that.isHidden) &&
            Objects.equals(aliveFlag, that.aliveFlag) &&
            Objects.equals(recCreateTime, that.recCreateTime) &&
            Objects.equals(recCreator, that.recCreator) &&
            Objects.equals(recReviseTime, that.recReviseTime) &&
            Objects.equals(recRevisor, that.recRevisor) &&
            Objects.equals(isActivated, that.isActivated) &&
            Objects.equals(activationTime, that.activationTime) &&
            Objects.equals(appVersion, that.appVersion) &&
            Objects.equals(isOnlyAdminTitle, that.isOnlyAdminTitle) &&
            Objects.equals(jobnumber, that.jobnumber) &&
            Objects.equals(avatar, that.avatar) &&
            Objects.equals(enName, that.enName) &&
            Objects.equals(enWorkplace, that.enWorkplace) &&
            Objects.equals(enTitleDesc, that.enTitleDesc) &&
            Objects.equals(onlyCode, that.onlyCode) &&
            Objects.equals(hrCardId, that.hrCardId) &&
            Objects.equals(employeeType, that.employeeType) &&
            Objects.equals(collectionFmpMicroAppId, that.collectionFmpMicroAppId) &&
            Objects.equals(usableFmpMicroAppId, that.usableFmpMicroAppId) &&
            Objects.equals(microAppGroupId, that.microAppGroupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        jobCode,
        type,
        fullname,
        namePy,
        sex,
        birthday,
        email,
        tel,
        telExt,
        stateCode1,
        mobile1,
        stateCode2,
        mobile2,
        stateCode3,
        mobile3,
        stateCode4,
        mobile4,
        stateCode5,
        mobile5,
        titleDesc,
        titleEn,
        checkNum,
        disporder,
        workPlace,
        userLevel,
        hiredate,
        nickname,
        memo,
        isHidden,
        aliveFlag,
        recCreateTime,
        recCreator,
        recReviseTime,
        recRevisor,
        isActivated,
        activationTime,
        appVersion,
        isOnlyAdminTitle,
        jobnumber,
        avatar,
        enName,
        enWorkplace,
        enTitleDesc,
        onlyCode,
        hrCardId,
        employeeType,
        collectionFmpMicroAppId,
        usableFmpMicroAppId,
        microAppGroupId
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UucUserBaseinfoCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (jobCode != null ? "jobCode=" + jobCode + ", " : "") +
                (type != null ? "type=" + type + ", " : "") +
                (fullname != null ? "fullname=" + fullname + ", " : "") +
                (namePy != null ? "namePy=" + namePy + ", " : "") +
                (sex != null ? "sex=" + sex + ", " : "") +
                (birthday != null ? "birthday=" + birthday + ", " : "") +
                (email != null ? "email=" + email + ", " : "") +
                (tel != null ? "tel=" + tel + ", " : "") +
                (telExt != null ? "telExt=" + telExt + ", " : "") +
                (stateCode1 != null ? "stateCode1=" + stateCode1 + ", " : "") +
                (mobile1 != null ? "mobile1=" + mobile1 + ", " : "") +
                (stateCode2 != null ? "stateCode2=" + stateCode2 + ", " : "") +
                (mobile2 != null ? "mobile2=" + mobile2 + ", " : "") +
                (stateCode3 != null ? "stateCode3=" + stateCode3 + ", " : "") +
                (mobile3 != null ? "mobile3=" + mobile3 + ", " : "") +
                (stateCode4 != null ? "stateCode4=" + stateCode4 + ", " : "") +
                (mobile4 != null ? "mobile4=" + mobile4 + ", " : "") +
                (stateCode5 != null ? "stateCode5=" + stateCode5 + ", " : "") +
                (mobile5 != null ? "mobile5=" + mobile5 + ", " : "") +
                (titleDesc != null ? "titleDesc=" + titleDesc + ", " : "") +
                (titleEn != null ? "titleEn=" + titleEn + ", " : "") +
                (checkNum != null ? "checkNum=" + checkNum + ", " : "") +
                (disporder != null ? "disporder=" + disporder + ", " : "") +
                (workPlace != null ? "workPlace=" + workPlace + ", " : "") +
                (userLevel != null ? "userLevel=" + userLevel + ", " : "") +
                (hiredate != null ? "hiredate=" + hiredate + ", " : "") +
                (nickname != null ? "nickname=" + nickname + ", " : "") +
                (memo != null ? "memo=" + memo + ", " : "") +
                (isHidden != null ? "isHidden=" + isHidden + ", " : "") +
                (aliveFlag != null ? "aliveFlag=" + aliveFlag + ", " : "") +
                (recCreateTime != null ? "recCreateTime=" + recCreateTime + ", " : "") +
                (recCreator != null ? "recCreator=" + recCreator + ", " : "") +
                (recReviseTime != null ? "recReviseTime=" + recReviseTime + ", " : "") +
                (recRevisor != null ? "recRevisor=" + recRevisor + ", " : "") +
                (isActivated != null ? "isActivated=" + isActivated + ", " : "") +
                (activationTime != null ? "activationTime=" + activationTime + ", " : "") +
                (appVersion != null ? "appVersion=" + appVersion + ", " : "") +
                (isOnlyAdminTitle != null ? "isOnlyAdminTitle=" + isOnlyAdminTitle + ", " : "") +
                (jobnumber != null ? "jobnumber=" + jobnumber + ", " : "") +
                (avatar != null ? "avatar=" + avatar + ", " : "") +
                (enName != null ? "enName=" + enName + ", " : "") +
                (enWorkplace != null ? "enWorkplace=" + enWorkplace + ", " : "") +
                (enTitleDesc != null ? "enTitleDesc=" + enTitleDesc + ", " : "") +
                (onlyCode != null ? "onlyCode=" + onlyCode + ", " : "") +
                (hrCardId != null ? "hrCardId=" + hrCardId + ", " : "") +
                (employeeType != null ? "employeeType=" + employeeType + ", " : "") +
                (collectionFmpMicroAppId != null ? "collectionFmpMicroAppId=" + collectionFmpMicroAppId + ", " : "") +
                (usableFmpMicroAppId != null ? "usableFmpMicroAppId=" + usableFmpMicroAppId + ", " : "") +
                (microAppGroupId != null ? "microAppGroupId=" + microAppGroupId + ", " : "") +
            "}";
    }

}
