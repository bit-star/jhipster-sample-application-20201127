package com.lazulite.mp.web.rest;

import com.lazulite.mp.domain.FmpMicroAppType;
import com.lazulite.mp.service.FmpMicroAppTypeService;
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
 * REST controller for managing {@link com.lazulite.mp.domain.FmpMicroAppType}.
 */
@RestController
@RequestMapping("/api")
public class FmpMicroAppTypeResource {

    private final Logger log = LoggerFactory.getLogger(FmpMicroAppTypeResource.class);

    private static final String ENTITY_NAME = "fmpMicroAppType";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FmpMicroAppTypeService fmpMicroAppTypeService;

    public FmpMicroAppTypeResource(FmpMicroAppTypeService fmpMicroAppTypeService) {
        this.fmpMicroAppTypeService = fmpMicroAppTypeService;
    }

    /**
     * {@code POST  /fmp-micro-app-types} : Create a new fmpMicroAppType.
     *
     * @param fmpMicroAppType the fmpMicroAppType to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new fmpMicroAppType, or with status {@code 400 (Bad Request)} if the fmpMicroAppType has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/fmp-micro-app-types")
    public ResponseEntity<FmpMicroAppType> createFmpMicroAppType(@RequestBody FmpMicroAppType fmpMicroAppType) throws URISyntaxException {
        log.debug("REST request to save FmpMicroAppType : {}", fmpMicroAppType);
        if (fmpMicroAppType.getId() != null) {
            throw new BadRequestAlertException("A new fmpMicroAppType cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FmpMicroAppType result = fmpMicroAppTypeService.save(fmpMicroAppType);
        return ResponseEntity.created(new URI("/api/fmp-micro-app-types/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /fmp-micro-app-types} : Updates an existing fmpMicroAppType.
     *
     * @param fmpMicroAppType the fmpMicroAppType to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated fmpMicroAppType,
     * or with status {@code 400 (Bad Request)} if the fmpMicroAppType is not valid,
     * or with status {@code 500 (Internal Server Error)} if the fmpMicroAppType couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/fmp-micro-app-types")
    public ResponseEntity<FmpMicroAppType> updateFmpMicroAppType(@RequestBody FmpMicroAppType fmpMicroAppType) throws URISyntaxException {
        log.debug("REST request to update FmpMicroAppType : {}", fmpMicroAppType);
        if (fmpMicroAppType.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        FmpMicroAppType result = fmpMicroAppTypeService.save(fmpMicroAppType);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, fmpMicroAppType.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /fmp-micro-app-types} : get all the fmpMicroAppTypes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of fmpMicroAppTypes in body.
     */
    @GetMapping("/fmp-micro-app-types")
    public List<FmpMicroAppType> getAllFmpMicroAppTypes() {
        log.debug("REST request to get all FmpMicroAppTypes");
        return fmpMicroAppTypeService.findAll();
    }

    /**
     * {@code GET  /fmp-micro-app-types/:id} : get the "id" fmpMicroAppType.
     *
     * @param id the id of the fmpMicroAppType to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the fmpMicroAppType, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/fmp-micro-app-types/{id}")
    public ResponseEntity<FmpMicroAppType> getFmpMicroAppType(@PathVariable Long id) {
        log.debug("REST request to get FmpMicroAppType : {}", id);
        Optional<FmpMicroAppType> fmpMicroAppType = fmpMicroAppTypeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(fmpMicroAppType);
    }

    /**
     * {@code DELETE  /fmp-micro-app-types/:id} : delete the "id" fmpMicroAppType.
     *
     * @param id the id of the fmpMicroAppType to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/fmp-micro-app-types/{id}")
    public ResponseEntity<Void> deleteFmpMicroAppType(@PathVariable Long id) {
        log.debug("REST request to delete FmpMicroAppType : {}", id);
        fmpMicroAppTypeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
