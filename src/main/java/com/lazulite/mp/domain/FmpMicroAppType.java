package com.lazulite.mp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A FmpMicroAppType.
 */
@Entity
@Table(name = "fmp_micro_app_type")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class FmpMicroAppType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "language")
    private String language;

    @Column(name = "portal_id")
    private String portalId;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "fmpMicroAppType")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<FmpMicroApp> fmpMicroApps = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "fmpMicroAppTypes", allowSetters = true)
    private FmpSubCompany fmpSubCompany;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public FmpMicroAppType code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public FmpMicroAppType name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public FmpMicroAppType language(String language) {
        this.language = language;
        return this;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPortalId() {
        return portalId;
    }

    public FmpMicroAppType portalId(String portalId) {
        this.portalId = portalId;
        return this;
    }

    public void setPortalId(String portalId) {
        this.portalId = portalId;
    }

    public Boolean isIsDeleted() {
        return isDeleted;
    }

    public FmpMicroAppType isDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Set<FmpMicroApp> getFmpMicroApps() {
        return fmpMicroApps;
    }

    public FmpMicroAppType fmpMicroApps(Set<FmpMicroApp> fmpMicroApps) {
        this.fmpMicroApps = fmpMicroApps;
        return this;
    }

    public FmpMicroAppType addFmpMicroApp(FmpMicroApp fmpMicroApp) {
        this.fmpMicroApps.add(fmpMicroApp);
        fmpMicroApp.setFmpMicroAppType(this);
        return this;
    }

    public FmpMicroAppType removeFmpMicroApp(FmpMicroApp fmpMicroApp) {
        this.fmpMicroApps.remove(fmpMicroApp);
        fmpMicroApp.setFmpMicroAppType(null);
        return this;
    }

    public void setFmpMicroApps(Set<FmpMicroApp> fmpMicroApps) {
        this.fmpMicroApps = fmpMicroApps;
    }

    public FmpSubCompany getFmpSubCompany() {
        return fmpSubCompany;
    }

    public FmpMicroAppType fmpSubCompany(FmpSubCompany fmpSubCompany) {
        this.fmpSubCompany = fmpSubCompany;
        return this;
    }

    public void setFmpSubCompany(FmpSubCompany fmpSubCompany) {
        this.fmpSubCompany = fmpSubCompany;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FmpMicroAppType)) {
            return false;
        }
        return id != null && id.equals(((FmpMicroAppType) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FmpMicroAppType{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", language='" + getLanguage() + "'" +
            ", portalId='" + getPortalId() + "'" +
            ", isDeleted='" + isIsDeleted() + "'" +
            "}";
    }
}
