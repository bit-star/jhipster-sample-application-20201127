package com.lazulite.mp.web.rest;

import com.lazulite.mp.domain.UucUserBaseinfo;
import com.lazulite.mp.service.UucUserBaseinfoService;
import com.lazulite.mp.web.rest.errors.BadRequestAlertException;
import com.lazulite.mp.service.dto.UucUserBaseinfoCriteria;
import com.lazulite.mp.service.UucUserBaseinfoQueryService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.lazulite.mp.domain.UucUserBaseinfo}.
 */
@RestController
@RequestMapping("/api")
public class UucUserBaseinfoResource {

    private final Logger log = LoggerFactory.getLogger(UucUserBaseinfoResource.class);

    private static final String ENTITY_NAME = "uucUserBaseinfo";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UucUserBaseinfoService uucUserBaseinfoService;

    private final UucUserBaseinfoQueryService uucUserBaseinfoQueryService;

    public UucUserBaseinfoResource(UucUserBaseinfoService uucUserBaseinfoService, UucUserBaseinfoQueryService uucUserBaseinfoQueryService) {
        this.uucUserBaseinfoService = uucUserBaseinfoService;
        this.uucUserBaseinfoQueryService = uucUserBaseinfoQueryService;
    }

    /**
     * {@code POST  /uuc-user-baseinfos} : Create a new uucUserBaseinfo.
     *
     * @param uucUserBaseinfo the uucUserBaseinfo to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new uucUserBaseinfo, or with status {@code 400 (Bad Request)} if the uucUserBaseinfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/uuc-user-baseinfos")
    public ResponseEntity<UucUserBaseinfo> createUucUserBaseinfo(@RequestBody UucUserBaseinfo uucUserBaseinfo) throws URISyntaxException {
        log.debug("REST request to save UucUserBaseinfo : {}", uucUserBaseinfo);
        if (uucUserBaseinfo.getId() != null) {
            throw new BadRequestAlertException("A new uucUserBaseinfo cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UucUserBaseinfo result = uucUserBaseinfoService.save(uucUserBaseinfo);
        return ResponseEntity.created(new URI("/api/uuc-user-baseinfos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /uuc-user-baseinfos} : Updates an existing uucUserBaseinfo.
     *
     * @param uucUserBaseinfo the uucUserBaseinfo to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated uucUserBaseinfo,
     * or with status {@code 400 (Bad Request)} if the uucUserBaseinfo is not valid,
     * or with status {@code 500 (Internal Server Error)} if the uucUserBaseinfo couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/uuc-user-baseinfos")
    public ResponseEntity<UucUserBaseinfo> updateUucUserBaseinfo(@RequestBody UucUserBaseinfo uucUserBaseinfo) throws URISyntaxException {
        log.debug("REST request to update UucUserBaseinfo : {}", uucUserBaseinfo);
        if (uucUserBaseinfo.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UucUserBaseinfo result = uucUserBaseinfoService.save(uucUserBaseinfo);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, uucUserBaseinfo.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /uuc-user-baseinfos} : get all the uucUserBaseinfos.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of uucUserBaseinfos in body.
     */
    @GetMapping("/uuc-user-baseinfos")
    public ResponseEntity<List<UucUserBaseinfo>> getAllUucUserBaseinfos(UucUserBaseinfoCriteria criteria, Pageable pageable) {
        log.debug("REST request to get UucUserBaseinfos by criteria: {}", criteria);
        Page<UucUserBaseinfo> page = uucUserBaseinfoQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /uuc-user-baseinfos/count} : count all the uucUserBaseinfos.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/uuc-user-baseinfos/count")
    public ResponseEntity<Long> countUucUserBaseinfos(UucUserBaseinfoCriteria criteria) {
        log.debug("REST request to count UucUserBaseinfos by criteria: {}", criteria);
        return ResponseEntity.ok().body(uucUserBaseinfoQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /uuc-user-baseinfos/:id} : get the "id" uucUserBaseinfo.
     *
     * @param id the id of the uucUserBaseinfo to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the uucUserBaseinfo, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/uuc-user-baseinfos/{id}")
    public ResponseEntity<UucUserBaseinfo> getUucUserBaseinfo(@PathVariable Long id) {
        log.debug("REST request to get UucUserBaseinfo : {}", id);
        Optional<UucUserBaseinfo> uucUserBaseinfo = uucUserBaseinfoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(uucUserBaseinfo);
    }

    /**
     * {@code DELETE  /uuc-user-baseinfos/:id} : delete the "id" uucUserBaseinfo.
     *
     * @param id the id of the uucUserBaseinfo to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/uuc-user-baseinfos/{id}")
    public ResponseEntity<Void> deleteUucUserBaseinfo(@PathVariable Long id) {
        log.debug("REST request to delete UucUserBaseinfo : {}", id);
        uucUserBaseinfoService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
