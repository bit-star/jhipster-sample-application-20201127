package com.lazulite.mp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A UucUserBaseinfo.
 */
@Entity
@Table(name = "uuc_user_baseinfo")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UucUserBaseinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_code")
    private String jobCode;

    @Column(name = "type")
    private String type;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "name_py")
    private String namePy;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "email")
    private String email;

    @Column(name = "tel")
    private String tel;

    @Column(name = "tel_ext")
    private String telExt;

    @Column(name = "state_code_1")
    private String stateCode1;

    @Column(name = "mobile_1")
    private String mobile1;

    @Column(name = "state_code_2")
    private String stateCode2;

    @Column(name = "mobile_2")
    private String mobile2;

    @Column(name = "state_code_3")
    private String stateCode3;

    @Column(name = "mobile_3")
    private String mobile3;

    @Column(name = "state_code_4")
    private String stateCode4;

    @Column(name = "mobile_4")
    private String mobile4;

    @Column(name = "state_code_5")
    private String stateCode5;

    @Column(name = "mobile_5")
    private String mobile5;

    @Column(name = "title_desc")
    private String titleDesc;

    @Column(name = "title_en")
    private String titleEn;

    @Column(name = "check_num")
    private String checkNum;

    @Column(name = "disporder")
    private Integer disporder;

    @Column(name = "work_place")
    private String workPlace;

    @Column(name = "user_level")
    private String userLevel;

    @Column(name = "hiredate")
    private Instant hiredate;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "memo")
    private String memo;

    @Column(name = "is_hidden")
    private String isHidden;

    @Column(name = "alive_flag")
    private String aliveFlag;

    @Column(name = "rec_create_time")
    private Instant recCreateTime;

    @Column(name = "rec_creator")
    private String recCreator;

    @Column(name = "rec_revise_time")
    private Instant recReviseTime;

    @Column(name = "rec_revisor")
    private String recRevisor;

    @Column(name = "is_activated")
    private String isActivated;

    @Column(name = "activation_time")
    private Instant activationTime;

    @Column(name = "app_version")
    private String appVersion;

    @Column(name = "is_only_admin_title")
    private String isOnlyAdminTitle;

    @Column(name = "jobnumber")
    private String jobnumber;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "en_name")
    private String enName;

    @Column(name = "en_workplace")
    private String enWorkplace;

    @Column(name = "en_title_desc")
    private String enTitleDesc;

    @Column(name = "only_code")
    private String onlyCode;

    @Column(name = "hr_card_id")
    private String hrCardId;

    @Column(name = "employee_type")
    private String employeeType;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "uuc_user_baseinfo_collection_fmp_micro_app",
               joinColumns = @JoinColumn(name = "uuc_user_baseinfo_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "collection_fmp_micro_app_id", referencedColumnName = "id"))
    private Set<FmpMicroApp> collectionFmpMicroApps = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "uucUserBaseinfos", allowSetters = true)
    private MicroAppGroup microAppGroup;

    @ManyToMany(mappedBy = "usableUsers")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<FmpMicroApp> usableFmpMicroApps = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobCode() {
        return jobCode;
    }

    public UucUserBaseinfo jobCode(String jobCode) {
        this.jobCode = jobCode;
        return this;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getType() {
        return type;
    }

    public UucUserBaseinfo type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFullname() {
        return fullname;
    }

    public UucUserBaseinfo fullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNamePy() {
        return namePy;
    }

    public UucUserBaseinfo namePy(String namePy) {
        this.namePy = namePy;
        return this;
    }

    public void setNamePy(String namePy) {
        this.namePy = namePy;
    }

    public String getSex() {
        return sex;
    }

    public UucUserBaseinfo sex(String sex) {
        this.sex = sex;
        return this;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public UucUserBaseinfo birthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public UucUserBaseinfo email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public UucUserBaseinfo tel(String tel) {
        this.tel = tel;
        return this;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTelExt() {
        return telExt;
    }

    public UucUserBaseinfo telExt(String telExt) {
        this.telExt = telExt;
        return this;
    }

    public void setTelExt(String telExt) {
        this.telExt = telExt;
    }

    public String getStateCode1() {
        return stateCode1;
    }

    public UucUserBaseinfo stateCode1(String stateCode1) {
        this.stateCode1 = stateCode1;
        return this;
    }

    public void setStateCode1(String stateCode1) {
        this.stateCode1 = stateCode1;
    }

    public String getMobile1() {
        return mobile1;
    }

    public UucUserBaseinfo mobile1(String mobile1) {
        this.mobile1 = mobile1;
        return this;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getStateCode2() {
        return stateCode2;
    }

    public UucUserBaseinfo stateCode2(String stateCode2) {
        this.stateCode2 = stateCode2;
        return this;
    }

    public void setStateCode2(String stateCode2) {
        this.stateCode2 = stateCode2;
    }

    public String getMobile2() {
        return mobile2;
    }

    public UucUserBaseinfo mobile2(String mobile2) {
        this.mobile2 = mobile2;
        return this;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getStateCode3() {
        return stateCode3;
    }

    public UucUserBaseinfo stateCode3(String stateCode3) {
        this.stateCode3 = stateCode3;
        return this;
    }

    public void setStateCode3(String stateCode3) {
        this.stateCode3 = stateCode3;
    }

    public String getMobile3() {
        return mobile3;
    }

    public UucUserBaseinfo mobile3(String mobile3) {
        this.mobile3 = mobile3;
        return this;
    }

    public void setMobile3(String mobile3) {
        this.mobile3 = mobile3;
    }

    public String getStateCode4() {
        return stateCode4;
    }

    public UucUserBaseinfo stateCode4(String stateCode4) {
        this.stateCode4 = stateCode4;
        return this;
    }

    public void setStateCode4(String stateCode4) {
        this.stateCode4 = stateCode4;
    }

    public String getMobile4() {
        return mobile4;
    }

    public UucUserBaseinfo mobile4(String mobile4) {
        this.mobile4 = mobile4;
        return this;
    }

    public void setMobile4(String mobile4) {
        this.mobile4 = mobile4;
    }

    public String getStateCode5() {
        return stateCode5;
    }

    public UucUserBaseinfo stateCode5(String stateCode5) {
        this.stateCode5 = stateCode5;
        return this;
    }

    public void setStateCode5(String stateCode5) {
        this.stateCode5 = stateCode5;
    }

    public String getMobile5() {
        return mobile5;
    }

    public UucUserBaseinfo mobile5(String mobile5) {
        this.mobile5 = mobile5;
        return this;
    }

    public void setMobile5(String mobile5) {
        this.mobile5 = mobile5;
    }

    public String getTitleDesc() {
        return titleDesc;
    }

    public UucUserBaseinfo titleDesc(String titleDesc) {
        this.titleDesc = titleDesc;
        return this;
    }

    public void setTitleDesc(String titleDesc) {
        this.titleDesc = titleDesc;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public UucUserBaseinfo titleEn(String titleEn) {
        this.titleEn = titleEn;
        return this;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getCheckNum() {
        return checkNum;
    }

    public UucUserBaseinfo checkNum(String checkNum) {
        this.checkNum = checkNum;
        return this;
    }

    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum;
    }

    public Integer getDisporder() {
        return disporder;
    }

    public UucUserBaseinfo disporder(Integer disporder) {
        this.disporder = disporder;
        return this;
    }

    public void setDisporder(Integer disporder) {
        this.disporder = disporder;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public UucUserBaseinfo workPlace(String workPlace) {
        this.workPlace = workPlace;
        return this;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public UucUserBaseinfo userLevel(String userLevel) {
        this.userLevel = userLevel;
        return this;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public Instant getHiredate() {
        return hiredate;
    }

    public UucUserBaseinfo hiredate(Instant hiredate) {
        this.hiredate = hiredate;
        return this;
    }

    public void setHiredate(Instant hiredate) {
        this.hiredate = hiredate;
    }

    public String getNickname() {
        return nickname;
    }

    public UucUserBaseinfo nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMemo() {
        return memo;
    }

    public UucUserBaseinfo memo(String memo) {
        this.memo = memo;
        return this;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getIsHidden() {
        return isHidden;
    }

    public UucUserBaseinfo isHidden(String isHidden) {
        this.isHidden = isHidden;
        return this;
    }

    public void setIsHidden(String isHidden) {
        this.isHidden = isHidden;
    }

    public String getAliveFlag() {
        return aliveFlag;
    }

    public UucUserBaseinfo aliveFlag(String aliveFlag) {
        this.aliveFlag = aliveFlag;
        return this;
    }

    public void setAliveFlag(String aliveFlag) {
        this.aliveFlag = aliveFlag;
    }

    public Instant getRecCreateTime() {
        return recCreateTime;
    }

    public UucUserBaseinfo recCreateTime(Instant recCreateTime) {
        this.recCreateTime = recCreateTime;
        return this;
    }

    public void setRecCreateTime(Instant recCreateTime) {
        this.recCreateTime = recCreateTime;
    }

    public String getRecCreator() {
        return recCreator;
    }

    public UucUserBaseinfo recCreator(String recCreator) {
        this.recCreator = recCreator;
        return this;
    }

    public void setRecCreator(String recCreator) {
        this.recCreator = recCreator;
    }

    public Instant getRecReviseTime() {
        return recReviseTime;
    }

    public UucUserBaseinfo recReviseTime(Instant recReviseTime) {
        this.recReviseTime = recReviseTime;
        return this;
    }

    public void setRecReviseTime(Instant recReviseTime) {
        this.recReviseTime = recReviseTime;
    }

    public String getRecRevisor() {
        return recRevisor;
    }

    public UucUserBaseinfo recRevisor(String recRevisor) {
        this.recRevisor = recRevisor;
        return this;
    }

    public void setRecRevisor(String recRevisor) {
        this.recRevisor = recRevisor;
    }

    public String getIsActivated() {
        return isActivated;
    }

    public UucUserBaseinfo isActivated(String isActivated) {
        this.isActivated = isActivated;
        return this;
    }

    public void setIsActivated(String isActivated) {
        this.isActivated = isActivated;
    }

    public Instant getActivationTime() {
        return activationTime;
    }

    public UucUserBaseinfo activationTime(Instant activationTime) {
        this.activationTime = activationTime;
        return this;
    }

    public void setActivationTime(Instant activationTime) {
        this.activationTime = activationTime;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public UucUserBaseinfo appVersion(String appVersion) {
        this.appVersion = appVersion;
        return this;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getIsOnlyAdminTitle() {
        return isOnlyAdminTitle;
    }

    public UucUserBaseinfo isOnlyAdminTitle(String isOnlyAdminTitle) {
        this.isOnlyAdminTitle = isOnlyAdminTitle;
        return this;
    }

    public void setIsOnlyAdminTitle(String isOnlyAdminTitle) {
        this.isOnlyAdminTitle = isOnlyAdminTitle;
    }

    public String getJobnumber() {
        return jobnumber;
    }

    public UucUserBaseinfo jobnumber(String jobnumber) {
        this.jobnumber = jobnumber;
        return this;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public UucUserBaseinfo avatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEnName() {
        return enName;
    }

    public UucUserBaseinfo enName(String enName) {
        this.enName = enName;
        return this;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getEnWorkplace() {
        return enWorkplace;
    }

    public UucUserBaseinfo enWorkplace(String enWorkplace) {
        this.enWorkplace = enWorkplace;
        return this;
    }

    public void setEnWorkplace(String enWorkplace) {
        this.enWorkplace = enWorkplace;
    }

    public String getEnTitleDesc() {
        return enTitleDesc;
    }

    public UucUserBaseinfo enTitleDesc(String enTitleDesc) {
        this.enTitleDesc = enTitleDesc;
        return this;
    }

    public void setEnTitleDesc(String enTitleDesc) {
        this.enTitleDesc = enTitleDesc;
    }

    public String getOnlyCode() {
        return onlyCode;
    }

    public UucUserBaseinfo onlyCode(String onlyCode) {
        this.onlyCode = onlyCode;
        return this;
    }

    public void setOnlyCode(String onlyCode) {
        this.onlyCode = onlyCode;
    }

    public String getHrCardId() {
        return hrCardId;
    }

    public UucUserBaseinfo hrCardId(String hrCardId) {
        this.hrCardId = hrCardId;
        return this;
    }

    public void setHrCardId(String hrCardId) {
        this.hrCardId = hrCardId;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public UucUserBaseinfo employeeType(String employeeType) {
        this.employeeType = employeeType;
        return this;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public Set<FmpMicroApp> getCollectionFmpMicroApps() {
        return collectionFmpMicroApps;
    }

    public UucUserBaseinfo collectionFmpMicroApps(Set<FmpMicroApp> fmpMicroApps) {
        this.collectionFmpMicroApps = fmpMicroApps;
        return this;
    }

    public UucUserBaseinfo addCollectionFmpMicroApp(FmpMicroApp fmpMicroApp) {
        this.collectionFmpMicroApps.add(fmpMicroApp);
        fmpMicroApp.getCollectionUsers().add(this);
        return this;
    }

    public UucUserBaseinfo removeCollectionFmpMicroApp(FmpMicroApp fmpMicroApp) {
        this.collectionFmpMicroApps.remove(fmpMicroApp);
        fmpMicroApp.getCollectionUsers().remove(this);
        return this;
    }

    public void setCollectionFmpMicroApps(Set<FmpMicroApp> fmpMicroApps) {
        this.collectionFmpMicroApps = fmpMicroApps;
    }

    public MicroAppGroup getMicroAppGroup() {
        return microAppGroup;
    }

    public UucUserBaseinfo microAppGroup(MicroAppGroup microAppGroup) {
        this.microAppGroup = microAppGroup;
        return this;
    }

    public void setMicroAppGroup(MicroAppGroup microAppGroup) {
        this.microAppGroup = microAppGroup;
    }

    public Set<FmpMicroApp> getUsableFmpMicroApps() {
        return usableFmpMicroApps;
    }

    public UucUserBaseinfo usableFmpMicroApps(Set<FmpMicroApp> fmpMicroApps) {
        this.usableFmpMicroApps = fmpMicroApps;
        return this;
    }

    public UucUserBaseinfo addUsableFmpMicroApp(FmpMicroApp fmpMicroApp) {
        this.usableFmpMicroApps.add(fmpMicroApp);
        fmpMicroApp.getUsableUsers().add(this);
        return this;
    }

    public UucUserBaseinfo removeUsableFmpMicroApp(FmpMicroApp fmpMicroApp) {
        this.usableFmpMicroApps.remove(fmpMicroApp);
        fmpMicroApp.getUsableUsers().remove(this);
        return this;
    }

    public void setUsableFmpMicroApps(Set<FmpMicroApp> fmpMicroApps) {
        this.usableFmpMicroApps = fmpMicroApps;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UucUserBaseinfo)) {
            return false;
        }
        return id != null && id.equals(((UucUserBaseinfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UucUserBaseinfo{" +
            "id=" + getId() +
            ", jobCode='" + getJobCode() + "'" +
            ", type='" + getType() + "'" +
            ", fullname='" + getFullname() + "'" +
            ", namePy='" + getNamePy() + "'" +
            ", sex='" + getSex() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", email='" + getEmail() + "'" +
            ", tel='" + getTel() + "'" +
            ", telExt='" + getTelExt() + "'" +
            ", stateCode1='" + getStateCode1() + "'" +
            ", mobile1='" + getMobile1() + "'" +
            ", stateCode2='" + getStateCode2() + "'" +
            ", mobile2='" + getMobile2() + "'" +
            ", stateCode3='" + getStateCode3() + "'" +
            ", mobile3='" + getMobile3() + "'" +
            ", stateCode4='" + getStateCode4() + "'" +
            ", mobile4='" + getMobile4() + "'" +
            ", stateCode5='" + getStateCode5() + "'" +
            ", mobile5='" + getMobile5() + "'" +
            ", titleDesc='" + getTitleDesc() + "'" +
            ", titleEn='" + getTitleEn() + "'" +
            ", checkNum='" + getCheckNum() + "'" +
            ", disporder=" + getDisporder() +
            ", workPlace='" + getWorkPlace() + "'" +
            ", userLevel='" + getUserLevel() + "'" +
            ", hiredate='" + getHiredate() + "'" +
            ", nickname='" + getNickname() + "'" +
            ", memo='" + getMemo() + "'" +
            ", isHidden='" + getIsHidden() + "'" +
            ", aliveFlag='" + getAliveFlag() + "'" +
            ", recCreateTime='" + getRecCreateTime() + "'" +
            ", recCreator='" + getRecCreator() + "'" +
            ", recReviseTime='" + getRecReviseTime() + "'" +
            ", recRevisor='" + getRecRevisor() + "'" +
            ", isActivated='" + getIsActivated() + "'" +
            ", activationTime='" + getActivationTime() + "'" +
            ", appVersion='" + getAppVersion() + "'" +
            ", isOnlyAdminTitle='" + getIsOnlyAdminTitle() + "'" +
            ", jobnumber='" + getJobnumber() + "'" +
            ", avatar='" + getAvatar() + "'" +
            ", enName='" + getEnName() + "'" +
            ", enWorkplace='" + getEnWorkplace() + "'" +
            ", enTitleDesc='" + getEnTitleDesc() + "'" +
            ", onlyCode='" + getOnlyCode() + "'" +
            ", hrCardId='" + getHrCardId() + "'" +
            ", employeeType='" + getEmployeeType() + "'" +
            "}";
    }
}
