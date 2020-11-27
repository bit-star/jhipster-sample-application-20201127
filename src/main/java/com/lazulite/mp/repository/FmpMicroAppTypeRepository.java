package com.lazulite.mp.repository;

import com.lazulite.mp.domain.FmpMicroAppType;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the FmpMicroAppType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FmpMicroAppTypeRepository extends JpaRepository<FmpMicroAppType, Long> {
}
