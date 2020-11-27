package com.lazulite.mp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.lazulite.mp.domain.enumeration.ManagerUserType;

/**
 * A ManagerUser.
 */
@Entity
@Table(name = "manager_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ManagerUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ManagerUserType type;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "manager_user_uuc_department_trees",
               joinColumns = @JoinColumn(name = "manager_user_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "uuc_department_trees_id", referencedColumnName = "id"))
    private Set<UucDepartmentTree> uucDepartmentTrees = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "managerUsers", allowSetters = true)
    private FmpSubCompany fmpSubCompany;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public ManagerUser parentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public ManagerUserType getType() {
        return type;
    }

    public ManagerUser type(ManagerUserType type) {
        this.type = type;
        return this;
    }

    public void setType(ManagerUserType type) {
        this.type = type;
    }

    public Set<UucDepartmentTree> getUucDepartmentTrees() {
        return uucDepartmentTrees;
    }

    public ManagerUser uucDepartmentTrees(Set<UucDepartmentTree> uucDepartmentTrees) {
        this.uucDepartmentTrees = uucDepartmentTrees;
        return this;
    }

    public ManagerUser addUucDepartmentTrees(UucDepartmentTree uucDepartmentTree) {
        this.uucDepartmentTrees.add(uucDepartmentTree);
        uucDepartmentTree.getManagers().add(this);
        return this;
    }

    public ManagerUser removeUucDepartmentTrees(UucDepartmentTree uucDepartmentTree) {
        this.uucDepartmentTrees.remove(uucDepartmentTree);
        uucDepartmentTree.getManagers().remove(this);
        return this;
    }

    public void setUucDepartmentTrees(Set<UucDepartmentTree> uucDepartmentTrees) {
        this.uucDepartmentTrees = uucDepartmentTrees;
    }

    public FmpSubCompany getFmpSubCompany() {
        return fmpSubCompany;
    }

    public ManagerUser fmpSubCompany(FmpSubCompany fmpSubCompany) {
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
        if (!(o instanceof ManagerUser)) {
            return false;
        }
        return id != null && id.equals(((ManagerUser) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ManagerUser{" +
            "id=" + getId() +
            ", parentId=" + getParentId() +
            ", type='" + getType() + "'" +
            "}";
    }
}
