package com.lazulite.mp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A FmpSubCompany.
 */
@Entity
@Table(name = "fmp_sub_company")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class FmpSubCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "admin_group_id")
    private String adminGroupId;

    @Column(name = "if_public")
    private String ifPublic;

    @Column(name = "style_id")
    private String styleId;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "fmpSubCompany")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<ManagerUser> managerUsers = new HashSet<>();

    @OneToMany(mappedBy = "fmpSubCompany")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Banner> banners = new HashSet<>();

    @OneToMany(mappedBy = "fmpSubCompany")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<FmpMicroAppType> fmpMicroAppTypes = new HashSet<>();

    @OneToMany(mappedBy = "creatorCompany")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<FmpMicroApp> createdApps = new HashSet<>();

    @OneToMany(mappedBy = "fmpSubCompany")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<MicroAppGroup> microAppGroups = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "fmp_sub_company_fmp_micro_app",
               joinColumns = @JoinColumn(name = "fmp_sub_company_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "fmp_micro_app_id", referencedColumnName = "id"))
    private Set<FmpMicroApp> fmpMicroApps = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "fmp_sub_company_uuc_department_tree",
               joinColumns = @JoinColumn(name = "fmp_sub_company_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "uuc_department_tree_id", referencedColumnName = "id"))
    private Set<UucDepartmentTree> uucDepartmentTrees = new HashSet<>();

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

    public FmpSubCompany name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public FmpSubCompany code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAdminGroupId() {
        return adminGroupId;
    }

    public FmpSubCompany adminGroupId(String adminGroupId) {
        this.adminGroupId = adminGroupId;
        return this;
    }

    public void setAdminGroupId(String adminGroupId) {
        this.adminGroupId = adminGroupId;
    }

    public String getIfPublic() {
        return ifPublic;
    }

    public FmpSubCompany ifPublic(String ifPublic) {
        this.ifPublic = ifPublic;
        return this;
    }

    public void setIfPublic(String ifPublic) {
        this.ifPublic = ifPublic;
    }

    public String getStyleId() {
        return styleId;
    }

    public FmpSubCompany styleId(String styleId) {
        this.styleId = styleId;
        return this;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public Boolean isIsDeleted() {
        return isDeleted;
    }

    public FmpSubCompany isDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Set<ManagerUser> getManagerUsers() {
        return managerUsers;
    }

    public FmpSubCompany managerUsers(Set<ManagerUser> managerUsers) {
        this.managerUsers = managerUsers;
        return this;
    }

    public FmpSubCompany addManagerUser(ManagerUser managerUser) {
        this.managerUsers.add(managerUser);
        managerUser.setFmpSubCompany(this);
        return this;
    }

    public FmpSubCompany removeManagerUser(ManagerUser managerUser) {
        this.managerUsers.remove(managerUser);
        managerUser.setFmpSubCompany(null);
        return this;
    }

    public void setManagerUsers(Set<ManagerUser> managerUsers) {
        this.managerUsers = managerUsers;
    }

    public Set<Banner> getBanners() {
        return banners;
    }

    public FmpSubCompany banners(Set<Banner> banners) {
        this.banners = banners;
        return this;
    }

    public FmpSubCompany addBanner(Banner banner) {
        this.banners.add(banner);
        banner.setFmpSubCompany(this);
        return this;
    }

    public FmpSubCompany removeBanner(Banner banner) {
        this.banners.remove(banner);
        banner.setFmpSubCompany(null);
        return this;
    }

    public void setBanners(Set<Banner> banners) {
        this.banners = banners;
    }

    public Set<FmpMicroAppType> getFmpMicroAppTypes() {
        return fmpMicroAppTypes;
    }

    public FmpSubCompany fmpMicroAppTypes(Set<FmpMicroAppType> fmpMicroAppTypes) {
        this.fmpMicroAppTypes = fmpMicroAppTypes;
        return this;
    }

    public FmpSubCompany addFmpMicroAppType(FmpMicroAppType fmpMicroAppType) {
        this.fmpMicroAppTypes.add(fmpMicroAppType);
        fmpMicroAppType.setFmpSubCompany(this);
        return this;
    }

    public FmpSubCompany removeFmpMicroAppType(FmpMicroAppType fmpMicroAppType) {
        this.fmpMicroAppTypes.remove(fmpMicroAppType);
        fmpMicroAppType.setFmpSubCompany(null);
        return this;
    }

    public void setFmpMicroAppTypes(Set<FmpMicroAppType> fmpMicroAppTypes) {
        this.fmpMicroAppTypes = fmpMicroAppTypes;
    }

    public Set<FmpMicroApp> getCreatedApps() {
        return createdApps;
    }

    public FmpSubCompany createdApps(Set<FmpMicroApp> fmpMicroApps) {
        this.createdApps = fmpMicroApps;
        return this;
    }

    public FmpSubCompany addCreatedApp(FmpMicroApp fmpMicroApp) {
        this.createdApps.add(fmpMicroApp);
        fmpMicroApp.setCreatorCompany(this);
        return this;
    }

    public FmpSubCompany removeCreatedApp(FmpMicroApp fmpMicroApp) {
        this.createdApps.remove(fmpMicroApp);
        fmpMicroApp.setCreatorCompany(null);
        return this;
    }

    public void setCreatedApps(Set<FmpMicroApp> fmpMicroApps) {
        this.createdApps = fmpMicroApps;
    }

    public Set<MicroAppGroup> getMicroAppGroups() {
        return microAppGroups;
    }

    public FmpSubCompany microAppGroups(Set<MicroAppGroup> microAppGroups) {
        this.microAppGroups = microAppGroups;
        return this;
    }

    public FmpSubCompany addMicroAppGroup(MicroAppGroup microAppGroup) {
        this.microAppGroups.add(microAppGroup);
        microAppGroup.setFmpSubCompany(this);
        return this;
    }

    public FmpSubCompany removeMicroAppGroup(MicroAppGroup microAppGroup) {
        this.microAppGroups.remove(microAppGroup);
        microAppGroup.setFmpSubCompany(null);
        return this;
    }

    public void setMicroAppGroups(Set<MicroAppGroup> microAppGroups) {
        this.microAppGroups = microAppGroups;
    }

    public Set<FmpMicroApp> getFmpMicroApps() {
        return fmpMicroApps;
    }

    public FmpSubCompany fmpMicroApps(Set<FmpMicroApp> fmpMicroApps) {
        this.fmpMicroApps = fmpMicroApps;
        return this;
    }

    public FmpSubCompany addFmpMicroApp(FmpMicroApp fmpMicroApp) {
        this.fmpMicroApps.add(fmpMicroApp);
        fmpMicroApp.getFmpSubCompanies().add(this);
        return this;
    }

    public FmpSubCompany removeFmpMicroApp(FmpMicroApp fmpMicroApp) {
        this.fmpMicroApps.remove(fmpMicroApp);
        fmpMicroApp.getFmpSubCompanies().remove(this);
        return this;
    }

    public void setFmpMicroApps(Set<FmpMicroApp> fmpMicroApps) {
        this.fmpMicroApps = fmpMicroApps;
    }

    public Set<UucDepartmentTree> getUucDepartmentTrees() {
        return uucDepartmentTrees;
    }

    public FmpSubCompany uucDepartmentTrees(Set<UucDepartmentTree> uucDepartmentTrees) {
        this.uucDepartmentTrees = uucDepartmentTrees;
        return this;
    }

    public FmpSubCompany addUucDepartmentTree(UucDepartmentTree uucDepartmentTree) {
        this.uucDepartmentTrees.add(uucDepartmentTree);
        uucDepartmentTree.getFmpSubCompanies().add(this);
        return this;
    }

    public FmpSubCompany removeUucDepartmentTree(UucDepartmentTree uucDepartmentTree) {
        this.uucDepartmentTrees.remove(uucDepartmentTree);
        uucDepartmentTree.getFmpSubCompanies().remove(this);
        return this;
    }

    public void setUucDepartmentTrees(Set<UucDepartmentTree> uucDepartmentTrees) {
        this.uucDepartmentTrees = uucDepartmentTrees;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FmpSubCompany)) {
            return false;
        }
        return id != null && id.equals(((FmpSubCompany) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FmpSubCompany{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", adminGroupId='" + getAdminGroupId() + "'" +
            ", ifPublic='" + getIfPublic() + "'" +
            ", styleId='" + getStyleId() + "'" +
            ", isDeleted='" + isIsDeleted() + "'" +
            "}";
    }
}
