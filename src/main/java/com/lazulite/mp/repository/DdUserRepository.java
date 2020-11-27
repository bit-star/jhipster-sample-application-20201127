package com.lazulite.mp.repository;

import com.lazulite.mp.domain.DdUser;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DdUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DdUserRepository extends JpaRepository<DdUser, Long> {
}
