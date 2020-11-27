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

import com.lazulite.mp.domain.UucUserBaseinfo;
import com.lazulite.mp.domain.*; // for static metamodels
import com.lazulite.mp.repository.UucUserBaseinfoRepository;
import com.lazulite.mp.service.dto.UucUserBaseinfoCriteria;

/**
 * Service for executing complex queries for {@link UucUserBaseinfo} entities in the database.
 * The main input is a {@link UucUserBaseinfoCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link UucUserBaseinfo} or a {@link Page} of {@link UucUserBaseinfo} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class UucUserBaseinfoQueryService extends QueryService<UucUserBaseinfo> {

    private final Logger log = LoggerFactory.getLogger(UucUserBaseinfoQueryService.class);

    private final UucUserBaseinfoRepository uucUserBaseinfoRepository;

    public UucUserBaseinfoQueryService(UucUserBaseinfoRepository uucUserBaseinfoRepository) {
        this.uucUserBaseinfoRepository = uucUserBaseinfoRepository;
    }

    /**
     * Return a {@link List} of {@link UucUserBaseinfo} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<UucUserBaseinfo> findByCriteria(UucUserBaseinfoCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<UucUserBaseinfo> specification = createSpecification(criteria);
        return uucUserBaseinfoRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link UucUserBaseinfo} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<UucUserBaseinfo> findByCriteria(UucUserBaseinfoCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<UucUserBaseinfo> specification = createSpecification(criteria);
        return uucUserBaseinfoRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(UucUserBaseinfoCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<UucUserBaseinfo> specification = createSpecification(criteria);
        return uucUserBaseinfoRepository.count(specification);
    }

    /**
     * Function to convert {@link UucUserBaseinfoCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<UucUserBaseinfo> createSpecification(UucUserBaseinfoCriteria criteria) {
        Specification<UucUserBaseinfo> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), UucUserBaseinfo_.id));
            }
            if (criteria.getJobCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getJobCode(), UucUserBaseinfo_.jobCode));
            }
            if (criteria.getType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getType(), UucUserBaseinfo_.type));
            }
            if (criteria.getFullname() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFullname(), UucUserBaseinfo_.fullname));
            }
            if (criteria.getNamePy() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNamePy(), UucUserBaseinfo_.namePy));
            }
            if (criteria.getSex() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSex(), UucUserBaseinfo_.sex));
            }
            if (criteria.getBirthday() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBirthday(), UucUserBaseinfo_.birthday));
            }
            if (criteria.getEmail() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEmail(), UucUserBaseinfo_.email));
            }
            if (criteria.getTel() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTel(), UucUserBaseinfo_.tel));
            }
            if (criteria.getTelExt() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTelExt(), UucUserBaseinfo_.telExt));
            }
            if (criteria.getStateCode1() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStateCode1(), UucUserBaseinfo_.stateCode1));
            }
            if (criteria.getMobile1() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMobile1(), UucUserBaseinfo_.mobile1));
            }
            if (criteria.getStateCode2() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStateCode2(), UucUserBaseinfo_.stateCode2));
            }
            if (criteria.getMobile2() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMobile2(), UucUserBaseinfo_.mobile2));
            }
            if (criteria.getStateCode3() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStateCode3(), UucUserBaseinfo_.stateCode3));
            }
            if (criteria.getMobile3() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMobile3(), UucUserBaseinfo_.mobile3));
            }
            if (criteria.getStateCode4() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStateCode4(), UucUserBaseinfo_.stateCode4));
            }
            if (criteria.getMobile4() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMobile4(), UucUserBaseinfo_.mobile4));
            }
            if (criteria.getStateCode5() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStateCode5(), UucUserBaseinfo_.stateCode5));
            }
            if (criteria.getMobile5() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMobile5(), UucUserBaseinfo_.mobile5));
            }
            if (criteria.getTitleDesc() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTitleDesc(), UucUserBaseinfo_.titleDesc));
            }
            if (criteria.getTitleEn() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTitleEn(), UucUserBaseinfo_.titleEn));
            }
            if (criteria.getCheckNum() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCheckNum(), UucUserBaseinfo_.checkNum));
            }
            if (criteria.getDisporder() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDisporder(), UucUserBaseinfo_.disporder));
            }
            if (criteria.getWorkPlace() != null) {
                specification = specification.and(buildStringSpecification(criteria.getWorkPlace(), UucUserBaseinfo_.workPlace));
            }
            if (criteria.getUserLevel() != null) {
                specification = specification.and(buildStringSpecification(criteria.getUserLevel(), UucUserBaseinfo_.userLevel));
            }
            if (criteria.getHiredate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHiredate(), UucUserBaseinfo_.hiredate));
            }
            if (criteria.getNickname() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNickname(), UucUserBaseinfo_.nickname));
            }
            if (criteria.getMemo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMemo(), UucUserBaseinfo_.memo));
            }
            if (criteria.getIsHidden() != null) {
                specification = specification.and(buildStringSpecification(criteria.getIsHidden(), UucUserBaseinfo_.isHidden));
            }
            if (criteria.getAliveFlag() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAliveFlag(), UucUserBaseinfo_.aliveFlag));
            }
            if (criteria.getRecCreateTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getRecCreateTime(), UucUserBaseinfo_.recCreateTime));
            }
            if (criteria.getRecCreator() != null) {
                specification = specification.and(buildStringSpecification(criteria.getRecCreator(), UucUserBaseinfo_.recCreator));
            }
            if (criteria.getRecReviseTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getRecReviseTime(), UucUserBaseinfo_.recReviseTime));
            }
            if (criteria.getRecRevisor() != null) {
                specification = specification.and(buildStringSpecification(criteria.getRecRevisor(), UucUserBaseinfo_.recRevisor));
            }
            if (criteria.getIsActivated() != null) {
                specification = specification.and(buildStringSpecification(criteria.getIsActivated(), UucUserBaseinfo_.isActivated));
            }
            if (criteria.getActivationTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getActivationTime(), UucUserBaseinfo_.activationTime));
            }
            if (criteria.getAppVersion() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAppVersion(), UucUserBaseinfo_.appVersion));
            }
            if (criteria.getIsOnlyAdminTitle() != null) {
                specification = specification.and(buildStringSpecification(criteria.getIsOnlyAdminTitle(), UucUserBaseinfo_.isOnlyAdminTitle));
            }
            if (criteria.getJobnumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getJobnumber(), UucUserBaseinfo_.jobnumber));
            }
            if (criteria.getAvatar() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAvatar(), UucUserBaseinfo_.avatar));
            }
            if (criteria.getEnName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEnName(), UucUserBaseinfo_.enName));
            }
            if (criteria.getEnWorkplace() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEnWorkplace(), UucUserBaseinfo_.enWorkplace));
            }
            if (criteria.getEnTitleDesc() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEnTitleDesc(), UucUserBaseinfo_.enTitleDesc));
            }
            if (criteria.getOnlyCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOnlyCode(), UucUserBaseinfo_.onlyCode));
            }
            if (criteria.getHrCardId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getHrCardId(), UucUserBaseinfo_.hrCardId));
            }
            if (criteria.getEmployeeType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEmployeeType(), UucUserBaseinfo_.employeeType));
            }
            if (criteria.getCollectionFmpMicroAppId() != null) {
                specification = specification.and(buildSpecification(criteria.getCollectionFmpMicroAppId(),
                    root -> root.join(UucUserBaseinfo_.collectionFmpMicroApps, JoinType.LEFT).get(FmpMicroApp_.id)));
            }
            if (criteria.getUsableFmpMicroAppId() != null) {
                specification = specification.and(buildSpecification(criteria.getUsableFmpMicroAppId(),
                    root -> root.join(UucUserBaseinfo_.usableFmpMicroApps, JoinType.LEFT).get(FmpMicroApp_.id)));
            }
            if (criteria.getMicroAppGroupId() != null) {
                specification = specification.and(buildSpecification(criteria.getMicroAppGroupId(),
                    root -> root.join(UucUserBaseinfo_.microAppGroups, JoinType.LEFT).get(MicroAppGroup_.id)));
            }
        }
        return specification;
    }
}
