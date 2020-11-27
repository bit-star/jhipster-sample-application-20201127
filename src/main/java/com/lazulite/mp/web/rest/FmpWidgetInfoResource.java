package com.lazulite.mp.web.rest;

import com.lazulite.mp.domain.FmpWidgetInfo;
import com.lazulite.mp.service.FmpWidgetInfoService;
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
 * REST controller for managing {@link com.lazulite.mp.domain.FmpWidgetInfo}.
 */
@RestController
@RequestMapping("/api")
public class FmpWidgetInfoResource {

    private final Logger log = LoggerFactory.getLogger(FmpWidgetInfoResource.class);

    private static final String ENTITY_NAME = "fmpWidgetInfo";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FmpWidgetInfoService fmpWidgetInfoService;

    public FmpWidgetInfoResource(FmpWidgetInfoService fmpWidgetInfoService) {
        this.fmpWidgetInfoService = fmpWidgetInfoService;
    }

    /**
     * {@code POST  /fmp-widget-infos} : Create a new fmpWidgetInfo.
     *
     * @param fmpWidgetInfo the fmpWidgetInfo to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new fmpWidgetInfo, or with status {@code 400 (Bad Request)} if the fmpWidgetInfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/fmp-widget-infos")
    public ResponseEntity<FmpWidgetInfo> createFmpWidgetInfo(@RequestBody FmpWidgetInfo fmpWidgetInfo) throws URISyntaxException {
        log.debug("REST request to save FmpWidgetInfo : {}", fmpWidgetInfo);
        if (fmpWidgetInfo.getId() != null) {
            throw new BadRequestAlertException("A new fmpWidgetInfo cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FmpWidgetInfo result = fmpWidgetInfoService.save(fmpWidgetInfo);
        return ResponseEntity.created(new URI("/api/fmp-widget-infos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /fmp-widget-infos} : Updates an existing fmpWidgetInfo.
     *
     * @param fmpWidgetInfo the fmpWidgetInfo to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated fmpWidgetInfo,
     * or with status {@code 400 (Bad Request)} if the fmpWidgetInfo is not valid,
     * or with status {@code 500 (Internal Server Error)} if the fmpWidgetInfo couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/fmp-widget-infos")
    public ResponseEntity<FmpWidgetInfo> updateFmpWidgetInfo(@RequestBody FmpWidgetInfo fmpWidgetInfo) throws URISyntaxException {
        log.debug("REST request to update FmpWidgetInfo : {}", fmpWidgetInfo);
        if (fmpWidgetInfo.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        FmpWidgetInfo result = fmpWidgetInfoService.save(fmpWidgetInfo);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, fmpWidgetInfo.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /fmp-widget-infos} : get all the fmpWidgetInfos.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of fmpWidgetInfos in body.
     */
    @GetMapping("/fmp-widget-infos")
    public List<FmpWidgetInfo> getAllFmpWidgetInfos() {
        log.debug("REST request to get all FmpWidgetInfos");
        return fmpWidgetInfoService.findAll();
    }

    /**
     * {@code GET  /fmp-widget-infos/:id} : get the "id" fmpWidgetInfo.
     *
     * @param id the id of the fmpWidgetInfo to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the fmpWidgetInfo, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/fmp-widget-infos/{id}")
    public ResponseEntity<FmpWidgetInfo> getFmpWidgetInfo(@PathVariable Long id) {
        log.debug("REST request to get FmpWidgetInfo : {}", id);
        Optional<FmpWidgetInfo> fmpWidgetInfo = fmpWidgetInfoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(fmpWidgetInfo);
    }

    /**
     * {@code DELETE  /fmp-widget-infos/:id} : delete the "id" fmpWidgetInfo.
     *
     * @param id the id of the fmpWidgetInfo to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/fmp-widget-infos/{id}")
    public ResponseEntity<Void> deleteFmpWidgetInfo(@PathVariable Long id) {
        log.debug("REST request to delete FmpWidgetInfo : {}", id);
        fmpWidgetInfoService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
