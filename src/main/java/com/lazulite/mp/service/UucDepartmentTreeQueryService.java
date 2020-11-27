package com.lazulite.mp.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.lazulite.mp.domain.UucDepartmentTree;
import com.lazulite.mp.domain.*; // for static metamodels
import com.lazulite.mp.repository.UucDepartmentTreeRepository;
import com.lazulite.mp.service.dto.UucDepartmentTreeCriteria;

/**
 * Service for executing complex queries for {@link UucDepartmentTree} entities in the database.
 * The main input is a {@link UucDepartmentTreeCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link UucDepartmentTree} or a {@link Page} of {@link UucDepartmentTree} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class UucDepartmentTreeQueryService extends QueryService<UucDepartmentTree> {

    private final Logger log = LoggerFactory.getLogger(UucDepartmentTreeQueryService.class);

    private final UucDepartmentTreeRepository uucDepartmentTreeRepository;

    public UucDepartmentTreeQueryService(UucDepartmentTreeRepository uucDepartmentTreeRepository) {
        this.uucDepartmentTreeRepository = uucDepartmentTreeRepository;
    }

    /**
     * Return a {@link List} of {@link UucDepartmentTree} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<UucDepartmentTree> findByCriteria(UucDepartmentTreeCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<UucDepartmentTree> specification = createSpecification(criteria);
        return uucDepartmentTreeRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link UucDepartmentTree} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<UucDepartmentTree> findByCriteria(UucDepartmentTreeCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<UucDepartmentTree> specification = createSpecification(criteria);
        return uucDepartmentTreeRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(UucDepartmentTreeCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<UucDepartmentTree> specification = createSpecification(criteria);
        return uucDepartmentTreeRepository.count(specification);
    }

    /**
     * Function to convert {@link UucDepartmentTreeCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<UucDepartmentTree> createSpecification(UucDepartmentTreeCriteria criteria) {
        Specification<UucDepartmentTree> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), UucDepartmentTree_.id));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), UucDepartmentTree_.name));
            }
            if (criteria.getNamePy() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNamePy(), UucDepartmentTree_.namePy));
            }
            if (criteria.getCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCode(), UucDepartmentTree_.code));
            }
            if (criteria.getParentDepId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getParentDepId(), UucDepartmentTree_.parentDepId));
            }
            if (criteria.getParentDepName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getParentDepName(), UucDepartmentTree_.parentDepName));
            }
            if (criteria.getStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStatus(), UucDepartmentTree_.status));
            }
            if (criteria.getDisporder() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDisporder(), UucDepartmentTree_.disporder));
            }
            if (criteria.getNamePath() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNamePath(), UucDepartmentTree_.namePath));
            }
            if (criteria.getCodePath() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCodePath(), UucDepartmentTree_.codePath));
            }
            if (criteria.getDepIdPath() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDepIdPath(), UucDepartmentTree_.depIdPath));
            }
            if (criteria.getDepLevel() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDepLevel(), UucDepartmentTree_.depLevel));
            }
            if (criteria.getAliveFlag() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAliveFlag(), UucDepartmentTree_.aliveFlag));
            }
            if (criteria.getRecCreateTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getRecCreateTime(), UucDepartmentTree_.recCreateTime));
            }
            if (criteria.getRecCreator() != null) {
                specification = specification.and(buildStringSpecification(criteria.getRecCreator(), UucDepartmentTree_.recCreator));
            }
            if (criteria.getRecReviseTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getRecReviseTime(), UucDepartmentTree_.recReviseTime));
            }
            if (criteria.getRecRevisor() != null) {
                specification = specification.and(buildStringSpecification(criteria.getRecRevisor(), UucDepartmentTree_.recRevisor));
            }
            if (criteria.getDeptUserCount() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDeptUserCount(), UucDepartmentTree_.deptUserCount));
            }
            if (criteria.getMicroappId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMicroappId(), UucDepartmentTree_.microappId));
            }
            if (criteria.getEnName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEnName(), UucDepartmentTree_.enName));
            }
            if (criteria.getOnlyCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOnlyCode(), UucDepartmentTree_.onlyCode));
            }
            if (criteria.getSrcDeptId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSrcDeptId(), UucDepartmentTree_.srcDeptId));
            }
            if (criteria.getSrcDeptType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSrcDeptType(), UucDepartmentTree_.srcDeptType));
            }
            if (criteria.getSrcType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSrcType(), UucDepartmentTree_.srcType));
            }
            if (criteria.getSrcDeptUcode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSrcDeptUcode(), UucDepartmentTree_.srcDeptUcode));
            }
            if (criteria.getMicroAppGroupId() != null) {
                specification = specification.and(buildSpecification(criteria.getMicroAppGroupId(),
                    root -> root.join(UucDepartmentTree_.microAppGroup, JoinType.LEFT).get(MicroAppGroup_.id)));
            }
            if (criteria.getUsableId() != null) {
                specification = specification.and(buildSpecification(criteria.getUsableId(),
                    root -> root.join(UucDepartmentTree_.usables, JoinType.LEFT).get(FmpMicroApp_.id)));
            }
            if (criteria.getManagerId() != null) {
                specification = specification.and(buildSpecification(criteria.getManagerId(),
                    root -> root.join(UucDepartmentTree_.managers, JoinType.LEFT).get(ManagerUser_.id)));
            }
            if (criteria.getFmpSubCompanyId() != null) {
                specification = specification.and(buildSpecification(criteria.getFmpSubCompanyId(),
                    root -> root.join(UucDepartmentTree_.fmpSubCompanies, JoinType.LEFT).get(FmpSubCompany_.id)));
            }
        }
        return specification;
    }
}
