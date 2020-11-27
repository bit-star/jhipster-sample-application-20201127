package com.lazulite.mp.service;

import com.lazulite.mp.domain.PortalRouting;
import com.lazulite.mp.repository.PortalRoutingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link PortalRouting}.
 */
@Service
@Transactional
public class PortalRoutingService {

    private final Logger log = LoggerFactory.getLogger(PortalRoutingService.class);

    private final PortalRoutingRepository portalRoutingRepository;

    public PortalRoutingService(PortalRoutingRepository portalRoutingRepository) {
        this.portalRoutingRepository = portalRoutingRepository;
    }

    /**
     * Save a portalRouting.
     *
     * @param portalRouting the entity to save.
     * @return the persisted entity.
     */
    public PortalRouting save(PortalRouting portalRouting) {
        log.debug("Request to save PortalRouting : {}", portalRouting);
        return portalRoutingRepository.save(portalRouting);
    }

    /**
     * Get all the portalRoutings.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<PortalRouting> findAll() {
        log.debug("Request to get all PortalRoutings");
        return portalRoutingRepository.findAll();
    }


    /**
     * Get one portalRouting by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PortalRouting> findOne(Long id) {
        log.debug("Request to get PortalRouting : {}", id);
        return portalRoutingRepository.findById(id);
    }

    /**
     * Delete the portalRouting by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete PortalRouting : {}", id);
        portalRoutingRepository.deleteById(id);
    }
}
