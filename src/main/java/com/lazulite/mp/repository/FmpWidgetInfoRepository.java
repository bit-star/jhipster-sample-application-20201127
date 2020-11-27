package com.lazulite.mp.repository;

import com.lazulite.mp.domain.FmpWidgetInfo;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the FmpWidgetInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FmpWidgetInfoRepository extends JpaRepository<FmpWidgetInfo, Long> {
}
