package com.lazulite.mp.web.rest;

import com.lazulite.mp.domain.DdUserPortalRouting;
import com.lazulite.mp.service.DdUserPortalRoutingService;
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
 * REST controller for managing {@link com.lazulite.mp.domain.DdUserPortalRouting}.
 */
@RestController
@RequestMapping("/api")
public class DdUserPortalRoutingResource {

    private final Logger log = LoggerFactory.getLogger(DdUserPortalRoutingResource.class);

    private static final String ENTITY_NAME = "ddUserPortalRouting";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DdUserPortalRoutingService ddUserPortalRoutingService;

    public DdUserPortalRoutingResource(DdUserPortalRoutingService ddUserPortalRoutingService) {
        this.ddUserPortalRoutingService = ddUserPortalRoutingService;
    }

    /**
     * {@code POST  /dd-user-portal-routings} : Create a new ddUserPortalRouting.
     *
     * @param ddUserPortalRouting the ddUserPortalRouting to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new ddUserPortalRouting, or with status {@code 400 (Bad Request)} if the ddUserPortalRouting has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dd-user-portal-routings")
    public ResponseEntity<DdUserPortalRouting> createDdUserPortalRouting(@RequestBody DdUserPortalRouting ddUserPortalRouting) throws URISyntaxException {
        log.debug("REST request to save DdUserPortalRouting : {}", ddUserPortalRouting);
        if (ddUserPortalRouting.getId() != null) {
            throw new BadRequestAlertException("A new ddUserPortalRouting cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DdUserPortalRouting result = ddUserPortalRoutingService.save(ddUserPortalRouting);
        return ResponseEntity.created(new URI("/api/dd-user-portal-routings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dd-user-portal-routings} : Updates an existing ddUserPortalRouting.
     *
     * @param ddUserPortalRouting the ddUserPortalRouting to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ddUserPortalRouting,
     * or with status {@code 400 (Bad Request)} if the ddUserPortalRouting is not valid,
     * or with status {@code 500 (Internal Server Error)} if the ddUserPortalRouting couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dd-user-portal-routings")
    public ResponseEntity<DdUserPortalRouting> updateDdUserPortalRouting(@RequestBody DdUserPortalRouting ddUserPortalRouting) throws URISyntaxException {
        log.debug("REST request to update DdUserPortalRouting : {}", ddUserPortalRouting);
        if (ddUserPortalRouting.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DdUserPortalRouting result = ddUserPortalRoutingService.save(ddUserPortalRouting);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, ddUserPortalRouting.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /dd-user-portal-routings} : get all the ddUserPortalRoutings.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ddUserPortalRoutings in body.
     */
    @GetMapping("/dd-user-portal-routings")
    public List<DdUserPortalRouting> getAllDdUserPortalRoutings() {
        log.debug("REST request to get all DdUserPortalRoutings");
        return ddUserPortalRoutingService.findAll();
    }

    /**
     * {@code GET  /dd-user-portal-routings/:id} : get the "id" ddUserPortalRouting.
     *
     * @param id the id of the ddUserPortalRouting to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ddUserPortalRouting, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dd-user-portal-routings/{id}")
    public ResponseEntity<DdUserPortalRouting> getDdUserPortalRouting(@PathVariable Long id) {
        log.debug("REST request to get DdUserPortalRouting : {}", id);
        Optional<DdUserPortalRouting> ddUserPortalRouting = ddUserPortalRoutingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(ddUserPortalRouting);
    }

    /**
     * {@code DELETE  /dd-user-portal-routings/:id} : delete the "id" ddUserPortalRouting.
     *
     * @param id the id of the ddUserPortalRouting to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dd-user-portal-routings/{id}")
    public ResponseEntity<Void> deleteDdUserPortalRouting(@PathVariable Long id) {
        log.debug("REST request to delete DdUserPortalRouting : {}", id);
        ddUserPortalRoutingService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
