package com.lazulite.mp.web.rest;

import com.lazulite.mp.domain.PortalRouting;
import com.lazulite.mp.service.PortalRoutingService;
import com.lazulite.mp.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.lazulite.mp.domain.PortalRouting}.
 */
@RestController
@RequestMapping("/api")
public class PortalRoutingResource {

    private final Logger log = LoggerFactory.getLogger(PortalRoutingResource.class);

    private static final String ENTITY_NAME = "portalRouting";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PortalRoutingService portalRoutingService;

    public PortalRoutingResource(PortalRoutingService portalRoutingService) {
        this.portalRoutingService = portalRoutingService;
    }

    /**
     * {@code POST  /portal-routings} : Create a new portalRouting.
     *
     * @param portalRouting the portalRouting to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new portalRouting, or with status {@code 400 (Bad Request)} if the portalRouting has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/portal-routings")
    public ResponseEntity<PortalRouting> createPortalRouting(@RequestBody PortalRouting portalRouting) throws URISyntaxException {
        log.debug("REST request to save PortalRouting : {}", portalRouting);
        if (portalRouting.getId() != null) {
            throw new BadRequestAlertException("A new portalRouting cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PortalRouting result = portalRoutingService.save(portalRouting);
        return ResponseEntity.created(new URI("/api/portal-routings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /portal-routings} : Updates an existing portalRouting.
     *
     * @param portalRouting the portalRouting to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated portalRouting,
     * or with status {@code 400 (Bad Request)} if the portalRouting is not valid,
     * or with status {@code 500 (Internal Server Error)} if the portalRouting couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/portal-routings")
    public ResponseEntity<PortalRouting> updatePortalRouting(@RequestBody PortalRouting portalRouting) throws URISyntaxException {
        log.debug("REST request to update PortalRouting : {}", portalRouting);
        if (portalRouting.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PortalRouting result = portalRoutingService.save(portalRouting);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, portalRouting.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /portal-routings} : get all the portalRoutings.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of portalRoutings in body.
     */
    @GetMapping("/portal-routings")
    public List<PortalRouting> getAllPortalRoutings() {
        log.debug("REST request to get all PortalRoutings");
        return portalRoutingService.findAll();
    }

    /**
     * {@code GET  /portal-routings/:id} : get the "id" portalRouting.
     *
     * @param id the id of the portalRouting to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the portalRouting, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/portal-routings/{id}")
    public ResponseEntity<PortalRouting> getPortalRouting(@PathVariable Long id) {
        log.debug("REST request to get PortalRouting : {}", id);
        Optional<PortalRouting> portalRouting = portalRoutingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(portalRouting);
    }

    /**
     * {@code DELETE  /portal-routings/:id} : delete the "id" portalRouting.
     *
     * @param id the id of the portalRouting to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/portal-routings/{id}")
    public ResponseEntity<Void> deletePortalRouting(@PathVariable Long id) {
        log.debug("REST request to delete PortalRouting : {}", id);
        portalRoutingService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
