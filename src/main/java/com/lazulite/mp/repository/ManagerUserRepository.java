package com.lazulite.mp.repository;

import com.lazulite.mp.domain.ManagerUser;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the ManagerUser entity.
 */
@Repository
public interface ManagerUserRepository extends JpaRepository<ManagerUser, Long> {

    @Query(value = "select distinct managerUser from ManagerUser managerUser left join fetch managerUser.uucDepartmentTrees",
        countQuery = "select count(distinct managerUser) from ManagerUser managerUser")
    Page<ManagerUser> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct managerUser from ManagerUser managerUser left join fetch managerUser.uucDepartmentTrees")
    List<ManagerUser> findAllWithEagerRelationships();

    @Query("select managerUser from ManagerUser managerUser left join fetch managerUser.uucDepartmentTrees where managerUser.id =:id")
    Optional<ManagerUser> findOneWithEagerRelationships(@Param("id") Long id);
}
