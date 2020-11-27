package com.lazulite.mp.repository;

import com.lazulite.mp.domain.FmpSubCompany;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the FmpSubCompany entity.
 */
@Repository
public interface FmpSubCompanyRepository extends JpaRepository<FmpSubCompany, Long> {

    @Query(value = "select distinct fmpSubCompany from FmpSubCompany fmpSubCompany left join fetch fmpSubCompany.fmpMicroApps left join fetch fmpSubCompany.uucDepartmentTrees",
        countQuery = "select count(distinct fmpSubCompany) from FmpSubCompany fmpSubCompany")
    Page<FmpSubCompany> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct fmpSubCompany from FmpSubCompany fmpSubCompany left join fetch fmpSubCompany.fmpMicroApps left join fetch fmpSubCompany.uucDepartmentTrees")
    List<FmpSubCompany> findAllWithEagerRelationships();

    @Query("select fmpSubCompany from FmpSubCompany fmpSubCompany left join fetch fmpSubCompany.fmpMicroApps left join fetch fmpSubCompany.uucDepartmentTrees where fmpSubCompany.id =:id")
    Optional<FmpSubCompany> findOneWithEagerRelationships(@Param("id") Long id);
}
