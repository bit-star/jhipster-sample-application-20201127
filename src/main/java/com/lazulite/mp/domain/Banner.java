package com.lazulite.mp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

import com.lazulite.mp.domain.enumeration.BannerType;

import com.lazulite.mp.domain.enumeration.Status;

/**
 * A Banner.
 */
@Entity
@Table(name = "banner")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Banner implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jhi_rank")
    private Long rank;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private BannerType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "path_url")
    private String pathUrl;

    @Column(name = "banner_url")
    private String bannerUrl;

    @Column(name = "remark")
    private String remark;

    @ManyToOne
    @JsonIgnoreProperties(value = "banners", allowSetters = true)
    private FmpSubCompany fmpSubCompany;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRank() {
        return rank;
    }

    public Banner rank(Long rank) {
        this.rank = rank;
        return this;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public BannerType getType() {
        return type;
    }

    public Banner type(BannerType type) {
        this.type = type;
        return this;
    }

    public void setType(BannerType type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public Banner status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPathUrl() {
        return pathUrl;
    }

    public Banner pathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
        return this;
    }

    public void setPathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public Banner bannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
        return this;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getRemark() {
        return remark;
    }

    public Banner remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public FmpSubCompany getFmpSubCompany() {
        return fmpSubCompany;
    }

    public Banner fmpSubCompany(FmpSubCompany fmpSubCompany) {
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
        if (!(o instanceof Banner)) {
            return false;
        }
        return id != null && id.equals(((Banner) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Banner{" +
            "id=" + getId() +
            ", rank=" + getRank() +
            ", type='" + getType() + "'" +
            ", status='" + getStatus() + "'" +
            ", pathUrl='" + getPathUrl() + "'" +
            ", bannerUrl='" + getBannerUrl() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}
