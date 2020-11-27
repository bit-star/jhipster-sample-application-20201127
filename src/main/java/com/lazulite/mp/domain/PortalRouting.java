package com.lazulite.mp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A PortalRouting.
 */
@Entity
@Table(name = "portal_routing")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PortalRouting implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "muc_app_owner")
    private String mucAppOwner;

    @Column(name = "muc_app_id")
    private String mucAppId;

    @Column(name = "muc_app_url")
    private String mucAppUrl;

    @Column(name = "muc_app_name")
    private String mucAppName;

    @Column(name = "muc_app_name_en")
    private String mucAppNameEn;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMucAppOwner() {
        return mucAppOwner;
    }

    public PortalRouting mucAppOwner(String mucAppOwner) {
        this.mucAppOwner = mucAppOwner;
        return this;
    }

    public void setMucAppOwner(String mucAppOwner) {
        this.mucAppOwner = mucAppOwner;
    }

    public String getMucAppId() {
        return mucAppId;
    }

    public PortalRouting mucAppId(String mucAppId) {
        this.mucAppId = mucAppId;
        return this;
    }

    public void setMucAppId(String mucAppId) {
        this.mucAppId = mucAppId;
    }

    public String getMucAppUrl() {
        return mucAppUrl;
    }

    public PortalRouting mucAppUrl(String mucAppUrl) {
        this.mucAppUrl = mucAppUrl;
        return this;
    }

    public void setMucAppUrl(String mucAppUrl) {
        this.mucAppUrl = mucAppUrl;
    }

    public String getMucAppName() {
        return mucAppName;
    }

    public PortalRouting mucAppName(String mucAppName) {
        this.mucAppName = mucAppName;
        return this;
    }

    public void setMucAppName(String mucAppName) {
        this.mucAppName = mucAppName;
    }

    public String getMucAppNameEn() {
        return mucAppNameEn;
    }

    public PortalRouting mucAppNameEn(String mucAppNameEn) {
        this.mucAppNameEn = mucAppNameEn;
        return this;
    }

    public void setMucAppNameEn(String mucAppNameEn) {
        this.mucAppNameEn = mucAppNameEn;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PortalRouting)) {
            return false;
        }
        return id != null && id.equals(((PortalRouting) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PortalRouting{" +
            "id=" + getId() +
            ", mucAppOwner='" + getMucAppOwner() + "'" +
            ", mucAppId='" + getMucAppId() + "'" +
            ", mucAppUrl='" + getMucAppUrl() + "'" +
            ", mucAppName='" + getMucAppName() + "'" +
            ", mucAppNameEn='" + getMucAppNameEn() + "'" +
            "}";
    }
}
