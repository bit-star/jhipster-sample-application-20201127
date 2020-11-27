package com.lazulite.mp.repository;

import com.lazulite.mp.domain.UucDepartmentTree;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UucDepartmentTree entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UucDepartmentTreeRepository extends JpaRepository<UucDepartmentTree, Long>, JpaSpecificationExecutor<UucDepartmentTree> {
}
