package com.lazulite.mp.repository;

import com.lazulite.mp.domain.DdUserPortalRouting;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DdUserPortalRouting entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DdUserPortalRoutingRepository extends JpaRepository<DdUserPortalRouting, Long> {
}
