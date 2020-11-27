package com.lazulite.mp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A DdUserPortalRouting.
 */
@Entity
@Table(name = "dd_user_portal_routing")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DdUserPortalRouting implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_code")
    private String jobCode;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "microapp_url")
    private String microappUrl;

    @Column(name = "injection_flag")
    private String injectionFlag;

    @Column(name = "injection_api_uri")
    private String injectionApiUri;

    @Column(name = "muc_app_id")
    private String mucAppId;

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

    public DdUserPortalRouting jobCode(String jobCode) {
        this.jobCode = jobCode;
        return this;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getMobile() {
        return mobile;
    }

    public DdUserPortalRouting mobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMicroappUrl() {
        return microappUrl;
    }

    public DdUserPortalRouting microappUrl(String microappUrl) {
        this.microappUrl = microappUrl;
        return this;
    }

    public void setMicroappUrl(String microappUrl) {
        this.microappUrl = microappUrl;
    }

    public String getInjectionFlag() {
        return injectionFlag;
    }

    public DdUserPortalRouting injectionFlag(String injectionFlag) {
        this.injectionFlag = injectionFlag;
        return this;
    }

    public void setInjectionFlag(String injectionFlag) {
        this.injectionFlag = injectionFlag;
    }

    public String getInjectionApiUri() {
        return injectionApiUri;
    }

    public DdUserPortalRouting injectionApiUri(String injectionApiUri) {
        this.injectionApiUri = injectionApiUri;
        return this;
    }

    public void setInjectionApiUri(String injectionApiUri) {
        this.injectionApiUri = injectionApiUri;
    }

    public String getMucAppId() {
        return mucAppId;
    }

    public DdUserPortalRouting mucAppId(String mucAppId) {
        this.mucAppId = mucAppId;
        return this;
    }

    public void setMucAppId(String mucAppId) {
        this.mucAppId = mucAppId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DdUserPortalRouting)) {
            return false;
        }
        return id != null && id.equals(((DdUserPortalRouting) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DdUserPortalRouting{" +
            "id=" + getId() +
            ", jobCode='" + getJobCode() + "'" +
            ", mobile='" + getMobile() + "'" +
            ", microappUrl='" + getMicroappUrl() + "'" +
            ", injectionFlag='" + getInjectionFlag() + "'" +
            ", injectionApiUri='" + getInjectionApiUri() + "'" +
            ", mucAppId='" + getMucAppId() + "'" +
            "}";
    }
}
