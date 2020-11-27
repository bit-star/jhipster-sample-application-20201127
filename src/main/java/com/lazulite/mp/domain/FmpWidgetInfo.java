package com.lazulite.mp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

import com.lazulite.mp.domain.enumeration.PassingForm;

import com.lazulite.mp.domain.enumeration.TopOption;

import com.lazulite.mp.domain.enumeration.WidgetContentType;

import com.lazulite.mp.domain.enumeration.WidgeType;

/**
 * A FmpWidgetInfo.
 */
@Entity
@Table(name = "fmp_widget_info")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class FmpWidgetInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "portal_id")
    private String portalId;

    @Column(name = "title")
    private String title;

    @Column(name = "cat_id")
    private String catId;

    @Column(name = "data_url")
    private String dataUrl;

    @Column(name = "sort")
    private String sort;

    @Enumerated(EnumType.STRING)
    @Column(name = "data_url_param")
    private PassingForm dataUrlParam;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_top")
    private TopOption isTop;

    @Enumerated(EnumType.STRING)
    @Column(name = "content_type")
    private WidgetContentType contentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private WidgeType type;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @ManyToOne
    @JsonIgnoreProperties(value = "fmpWidgetInfos", allowSetters = true)
    private FmpMicroApp fmpMicroApp;

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

    public FmpWidgetInfo code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPortalId() {
        return portalId;
    }

    public FmpWidgetInfo portalId(String portalId) {
        this.portalId = portalId;
        return this;
    }

    public void setPortalId(String portalId) {
        this.portalId = portalId;
    }

    public String getTitle() {
        return title;
    }

    public FmpWidgetInfo title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCatId() {
        return catId;
    }

    public FmpWidgetInfo catId(String catId) {
        this.catId = catId;
        return this;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public FmpWidgetInfo dataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
        return this;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public String getSort() {
        return sort;
    }

    public FmpWidgetInfo sort(String sort) {
        this.sort = sort;
        return this;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public PassingForm getDataUrlParam() {
        return dataUrlParam;
    }

    public FmpWidgetInfo dataUrlParam(PassingForm dataUrlParam) {
        this.dataUrlParam = dataUrlParam;
        return this;
    }

    public void setDataUrlParam(PassingForm dataUrlParam) {
        this.dataUrlParam = dataUrlParam;
    }

    public TopOption getIsTop() {
        return isTop;
    }

    public FmpWidgetInfo isTop(TopOption isTop) {
        this.isTop = isTop;
        return this;
    }

    public void setIsTop(TopOption isTop) {
        this.isTop = isTop;
    }

    public WidgetContentType getContentType() {
        return contentType;
    }

    public FmpWidgetInfo contentType(WidgetContentType contentType) {
        this.contentType = contentType;
        return this;
    }

    public void setContentType(WidgetContentType contentType) {
        this.contentType = contentType;
    }

    public WidgeType getType() {
        return type;
    }

    public FmpWidgetInfo type(WidgeType type) {
        this.type = type;
        return this;
    }

    public void setType(WidgeType type) {
        this.type = type;
    }

    public Boolean isIsDeleted() {
        return isDeleted;
    }

    public FmpWidgetInfo isDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public FmpMicroApp getFmpMicroApp() {
        return fmpMicroApp;
    }

    public FmpWidgetInfo fmpMicroApp(FmpMicroApp fmpMicroApp) {
        this.fmpMicroApp = fmpMicroApp;
        return this;
    }

    public void setFmpMicroApp(FmpMicroApp fmpMicroApp) {
        this.fmpMicroApp = fmpMicroApp;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FmpWidgetInfo)) {
            return false;
        }
        return id != null && id.equals(((FmpWidgetInfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FmpWidgetInfo{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", portalId='" + getPortalId() + "'" +
            ", title='" + getTitle() + "'" +
            ", catId='" + getCatId() + "'" +
            ", dataUrl='" + getDataUrl() + "'" +
            ", sort='" + getSort() + "'" +
            ", dataUrlParam='" + getDataUrlParam() + "'" +
            ", isTop='" + getIsTop() + "'" +
            ", contentType='" + getContentType() + "'" +
            ", type='" + getType() + "'" +
            ", isDeleted='" + isIsDeleted() + "'" +
            "}";
    }
}
