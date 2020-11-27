package com.lazulite.mp.repository;

import com.lazulite.mp.domain.PortalRouting;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PortalRouting entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PortalRoutingRepository extends JpaRepository<PortalRouting, Long> {
}
