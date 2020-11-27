package com.lazulite.mp.repository;

import com.lazulite.mp.domain.UucUserBaseinfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the UucUserBaseinfo entity.
 */
@Repository
public interface UucUserBaseinfoRepository extends JpaRepository<UucUserBaseinfo, Long>, JpaSpecificationExecutor<UucUserBaseinfo> {

    @Query(value = "select distinct uucUserBaseinfo from UucUserBaseinfo uucUserBaseinfo left join fetch uucUserBaseinfo.collectionFmpMicroApps",
        countQuery = "select count(distinct uucUserBaseinfo) from UucUserBaseinfo uucUserBaseinfo")
    Page<UucUserBaseinfo> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct uucUserBaseinfo from UucUserBaseinfo uucUserBaseinfo left join fetch uucUserBaseinfo.collectionFmpMicroApps")
    List<UucUserBaseinfo> findAllWithEagerRelationships();

    @Query("select uucUserBaseinfo from UucUserBaseinfo uucUserBaseinfo left join fetch uucUserBaseinfo.collectionFmpMicroApps where uucUserBaseinfo.id =:id")
    Optional<UucUserBaseinfo> findOneWithEagerRelationships(@Param("id") Long id);
}
