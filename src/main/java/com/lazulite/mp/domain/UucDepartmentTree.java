package com.lazulite.mp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A UucDepartmentTree.
 */
@Entity
@Table(name = "uuc_department_tree")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UucDepartmentTree implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "name_py")
    private String namePy;

    @Column(name = "code")
    private String code;

    @Column(name = "parent_dep_id")
    private String parentDepId;

    @Column(name = "parent_dep_name")
    private String parentDepName;

    @Column(name = "status")
    private String status;

    @Column(name = "disporder")
    private String disporder;

    @Column(name = "name_path")
    private String namePath;

    @Column(name = "code_path")
    private String codePath;

    @Column(name = "dep_id_path")
    private String depIdPath;

    @Column(name = "dep_level")
    private String depLevel;

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

    @Column(name = "dept_user_count")
    private String deptUserCount;

    @Column(name = "microapp_id")
    private String microappId;

    @Column(name = "en_name")
    private String enName;

    @Column(name = "only_code")
    private String onlyCode;

    @Column(name = "src_dept_id")
    private String srcDeptId;

    @Column(name = "src_dept_type")
    private String srcDeptType;

    @Column(name = "src_type")
    private String srcType;

    @Column(name = "src_dept_ucode")
    private String srcDeptUcode;

    @ManyToMany(mappedBy = "uucDepartmentTrees")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<FmpMicroApp> usables = new HashSet<>();

    @ManyToMany(mappedBy = "uucDepartmentTrees")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<ManagerUser> managers = new HashSet<>();

    @ManyToMany(mappedBy = "uucDepartmentTrees")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<FmpSubCompany> fmpSubCompanies = new HashSet<>();

    @ManyToMany(mappedBy = "uucDepartmentTrees")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<MicroAppGroup> microAppGroups = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public UucDepartmentTree name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePy() {
        return namePy;
    }

    public UucDepartmentTree namePy(String namePy) {
        this.namePy = namePy;
        return this;
    }

    public void setNamePy(String namePy) {
        this.namePy = namePy;
    }

    public String getCode() {
        return code;
    }

    public UucDepartmentTree code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentDepId() {
        return parentDepId;
    }

    public UucDepartmentTree parentDepId(String parentDepId) {
        this.parentDepId = parentDepId;
        return this;
    }

    public void setParentDepId(String parentDepId) {
        this.parentDepId = parentDepId;
    }

    public String getParentDepName() {
        return parentDepName;
    }

    public UucDepartmentTree parentDepName(String parentDepName) {
        this.parentDepName = parentDepName;
        return this;
    }

    public void setParentDepName(String parentDepName) {
        this.parentDepName = parentDepName;
    }

    public String getStatus() {
        return status;
    }

    public UucDepartmentTree status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDisporder() {
        return disporder;
    }

    public UucDepartmentTree disporder(String disporder) {
        this.disporder = disporder;
        return this;
    }

    public void setDisporder(String disporder) {
        this.disporder = disporder;
    }

    public String getNamePath() {
        return namePath;
    }

    public UucDepartmentTree namePath(String namePath) {
        this.namePath = namePath;
        return this;
    }

    public void setNamePath(String namePath) {
        this.namePath = namePath;
    }

    public String getCodePath() {
        return codePath;
    }

    public UucDepartmentTree codePath(String codePath) {
        this.codePath = codePath;
        return this;
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    public String getDepIdPath() {
        return depIdPath;
    }

    public UucDepartmentTree depIdPath(String depIdPath) {
        this.depIdPath = depIdPath;
        return this;
    }

    public void setDepIdPath(String depIdPath) {
        this.depIdPath = depIdPath;
    }

    public String getDepLevel() {
        return depLevel;
    }

    public UucDepartmentTree depLevel(String depLevel) {
        this.depLevel = depLevel;
        return this;
    }

    public void setDepLevel(String depLevel) {
        this.depLevel = depLevel;
    }

    public String getAliveFlag() {
        return aliveFlag;
    }

    public UucDepartmentTree aliveFlag(String aliveFlag) {
        this.aliveFlag = aliveFlag;
        return this;
    }

    public void setAliveFlag(String aliveFlag) {
        this.aliveFlag = aliveFlag;
    }

    public Instant getRecCreateTime() {
        return recCreateTime;
    }

    public UucDepartmentTree recCreateTime(Instant recCreateTime) {
        this.recCreateTime = recCreateTime;
        return this;
    }

    public void setRecCreateTime(Instant recCreateTime) {
        this.recCreateTime = recCreateTime;
    }

    public String getRecCreator() {
        return recCreator;
    }

    public UucDepartmentTree recCreator(String recCreator) {
        this.recCreator = recCreator;
        return this;
    }

    public void setRecCreator(String recCreator) {
        this.recCreator = recCreator;
    }

    public Instant getRecReviseTime() {
        return recReviseTime;
    }

    public UucDepartmentTree recReviseTime(Instant recReviseTime) {
        this.recReviseTime = recReviseTime;
        return this;
    }

    public void setRecReviseTime(Instant recReviseTime) {
        this.recReviseTime = recReviseTime;
    }

    public String getRecRevisor() {
        return recRevisor;
    }

    public UucDepartmentTree recRevisor(String recRevisor) {
        this.recRevisor = recRevisor;
        return this;
    }

    public void setRecRevisor(String recRevisor) {
        this.recRevisor = recRevisor;
    }

    public String getDeptUserCount() {
        return deptUserCount;
    }

    public UucDepartmentTree deptUserCount(String deptUserCount) {
        this.deptUserCount = deptUserCount;
        return this;
    }

    public void setDeptUserCount(String deptUserCount) {
        this.deptUserCount = deptUserCount;
    }

    public String getMicroappId() {
        return microappId;
    }

    public UucDepartmentTree microappId(String microappId) {
        this.microappId = microappId;
        return this;
    }

    public void setMicroappId(String microappId) {
        this.microappId = microappId;
    }

    public String getEnName() {
        return enName;
    }

    public UucDepartmentTree enName(String enName) {
        this.enName = enName;
        return this;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getOnlyCode() {
        return onlyCode;
    }

    public UucDepartmentTree onlyCode(String onlyCode) {
        this.onlyCode = onlyCode;
        return this;
    }

    public void setOnlyCode(String onlyCode) {
        this.onlyCode = onlyCode;
    }

    public String getSrcDeptId() {
        return srcDeptId;
    }

    public UucDepartmentTree srcDeptId(String srcDeptId) {
        this.srcDeptId = srcDeptId;
        return this;
    }

    public void setSrcDeptId(String srcDeptId) {
        this.srcDeptId = srcDeptId;
    }

    public String getSrcDeptType() {
        return srcDeptType;
    }

    public UucDepartmentTree srcDeptType(String srcDeptType) {
        this.srcDeptType = srcDeptType;
        return this;
    }

    public void setSrcDeptType(String srcDeptType) {
        this.srcDeptType = srcDeptType;
    }

    public String getSrcType() {
        return srcType;
    }

    public UucDepartmentTree srcType(String srcType) {
        this.srcType = srcType;
        return this;
    }

    public void setSrcType(String srcType) {
        this.srcType = srcType;
    }

    public String getSrcDeptUcode() {
        return srcDeptUcode;
    }

    public UucDepartmentTree srcDeptUcode(String srcDeptUcode) {
        this.srcDeptUcode = srcDeptUcode;
        return this;
    }

    public void setSrcDeptUcode(String srcDeptUcode) {
        this.srcDeptUcode = srcDeptUcode;
    }

    public Set<FmpMicroApp> getUsables() {
        return usables;
    }

    public UucDepartmentTree usables(Set<FmpMicroApp> fmpMicroApps) {
        this.usables = fmpMicroApps;
        return this;
    }

    public UucDepartmentTree addUsable(FmpMicroApp fmpMicroApp) {
        this.usables.add(fmpMicroApp);
        fmpMicroApp.getUucDepartmentTrees().add(this);
        return this;
    }

    public UucDepartmentTree removeUsable(FmpMicroApp fmpMicroApp) {
        this.usables.remove(fmpMicroApp);
        fmpMicroApp.getUucDepartmentTrees().remove(this);
        return this;
    }

    public void setUsables(Set<FmpMicroApp> fmpMicroApps) {
        this.usables = fmpMicroApps;
    }

    public Set<ManagerUser> getManagers() {
        return managers;
    }

    public UucDepartmentTree managers(Set<ManagerUser> managerUsers) {
        this.managers = managerUsers;
        return this;
    }

    public UucDepartmentTree addManager(ManagerUser managerUser) {
        this.managers.add(managerUser);
        managerUser.getUucDepartmentTrees().add(this);
        return this;
    }

    public UucDepartmentTree removeManager(ManagerUser managerUser) {
        this.managers.remove(managerUser);
        managerUser.getUucDepartmentTrees().remove(this);
        return this;
    }

    public void setManagers(Set<ManagerUser> managerUsers) {
        this.managers = managerUsers;
    }

    public Set<FmpSubCompany> getFmpSubCompanies() {
        return fmpSubCompanies;
    }

    public UucDepartmentTree fmpSubCompanies(Set<FmpSubCompany> fmpSubCompanies) {
        this.fmpSubCompanies = fmpSubCompanies;
        return this;
    }

    public UucDepartmentTree addFmpSubCompany(FmpSubCompany fmpSubCompany) {
        this.fmpSubCompanies.add(fmpSubCompany);
        fmpSubCompany.getUucDepartmentTrees().add(this);
        return this;
    }

    public UucDepartmentTree removeFmpSubCompany(FmpSubCompany fmpSubCompany) {
        this.fmpSubCompanies.remove(fmpSubCompany);
        fmpSubCompany.getUucDepartmentTrees().remove(this);
        return this;
    }

    public void setFmpSubCompanies(Set<FmpSubCompany> fmpSubCompanies) {
        this.fmpSubCompanies = fmpSubCompanies;
    }

    public Set<MicroAppGroup> getMicroAppGroups() {
        return microAppGroups;
    }

    public UucDepartmentTree microAppGroups(Set<MicroAppGroup> microAppGroups) {
        this.microAppGroups = microAppGroups;
        return this;
    }

    public UucDepartmentTree addMicroAppGroup(MicroAppGroup microAppGroup) {
        this.microAppGroups.add(microAppGroup);
        microAppGroup.getUucDepartmentTrees().add(this);
        return this;
    }

    public UucDepartmentTree removeMicroAppGroup(MicroAppGroup microAppGroup) {
        this.microAppGroups.remove(microAppGroup);
        microAppGroup.getUucDepartmentTrees().remove(this);
        return this;
    }

    public void setMicroAppGroups(Set<MicroAppGroup> microAppGroups) {
        this.microAppGroups = microAppGroups;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UucDepartmentTree)) {
            return false;
        }
        return id != null && id.equals(((UucDepartmentTree) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UucDepartmentTree{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", namePy='" + getNamePy() + "'" +
            ", code='" + getCode() + "'" +
            ", parentDepId='" + getParentDepId() + "'" +
            ", parentDepName='" + getParentDepName() + "'" +
            ", status='" + getStatus() + "'" +
            ", disporder='" + getDisporder() + "'" +
            ", namePath='" + getNamePath() + "'" +
            ", codePath='" + getCodePath() + "'" +
            ", depIdPath='" + getDepIdPath() + "'" +
            ", depLevel='" + getDepLevel() + "'" +
            ", aliveFlag='" + getAliveFlag() + "'" +
            ", recCreateTime='" + getRecCreateTime() + "'" +
            ", recCreator='" + getRecCreator() + "'" +
            ", recReviseTime='" + getRecReviseTime() + "'" +
            ", recRevisor='" + getRecRevisor() + "'" +
            ", deptUserCount='" + getDeptUserCount() + "'" +
            ", microappId='" + getMicroappId() + "'" +
            ", enName='" + getEnName() + "'" +
            ", onlyCode='" + getOnlyCode() + "'" +
            ", srcDeptId='" + getSrcDeptId() + "'" +
            ", srcDeptType='" + getSrcDeptType() + "'" +
            ", srcType='" + getSrcType() + "'" +
            ", srcDeptUcode='" + getSrcDeptUcode() + "'" +
            "}";
    }
}
