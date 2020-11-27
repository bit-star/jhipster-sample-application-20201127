package com.lazulite.mp.service;

import com.lazulite.mp.domain.DdUserPortalRouting;
import com.lazulite.mp.repository.DdUserPortalRoutingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link DdUserPortalRouting}.
 */
@Service
@Transactional
public class DdUserPortalRoutingService {

    private final Logger log = LoggerFactory.getLogger(DdUserPortalRoutingService.class);

    private final DdUserPortalRoutingRepository ddUserPortalRoutingRepository;

    public DdUserPortalRoutingService(DdUserPortalRoutingRepository ddUserPortalRoutingRepository) {
        this.ddUserPortalRoutingRepository = ddUserPortalRoutingRepository;
    }

    /**
     * Save a ddUserPortalRouting.
     *
     * @param ddUserPortalRouting the entity to save.
     * @return the persisted entity.
     */
    public DdUserPortalRouting save(DdUserPortalRouting ddUserPortalRouting) {
        log.debug("Request to save DdUserPortalRouting : {}", ddUserPortalRouting);
        return ddUserPortalRoutingRepository.save(ddUserPortalRouting);
    }

    /**
     * Get all the ddUserPortalRoutings.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<DdUserPortalRouting> findAll() {
        log.debug("Request to get all DdUserPortalRoutings");
        return ddUserPortalRoutingRepository.findAll();
    }


    /**
     * Get one ddUserPortalRouting by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DdUserPortalRouting> findOne(Long id) {
        log.debug("Request to get DdUserPortalRouting : {}", id);
        return ddUserPortalRoutingRepository.findById(id);
    }

    /**
     * Delete the ddUserPortalRouting by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete DdUserPortalRouting : {}", id);
        ddUserPortalRoutingRepository.deleteById(id);
    }
}
