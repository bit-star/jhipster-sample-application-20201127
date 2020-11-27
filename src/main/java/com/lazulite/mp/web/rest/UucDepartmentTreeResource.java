package com.lazulite.mp.web.rest;

import com.lazulite.mp.domain.UucDepartmentTree;
import com.lazulite.mp.service.UucDepartmentTreeService;
import com.lazulite.mp.web.rest.errors.BadRequestAlertException;
import com.lazulite.mp.service.dto.UucDepartmentTreeCriteria;
import com.lazulite.mp.service.UucDepartmentTreeQueryService;

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
 * REST controller for managing {@link com.lazulite.mp.domain.UucDepartmentTree}.
 */
@RestController
@RequestMapping("/api")
public class UucDepartmentTreeResource {

    private final Logger log = LoggerFactory.getLogger(UucDepartmentTreeResource.class);

    private static final String ENTITY_NAME = "uucDepartmentTree";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UucDepartmentTreeService uucDepartmentTreeService;

    private final UucDepartmentTreeQueryService uucDepartmentTreeQueryService;

    public UucDepartmentTreeResource(UucDepartmentTreeService uucDepartmentTreeService, UucDepartmentTreeQueryService uucDepartmentTreeQueryService) {
        this.uucDepartmentTreeService = uucDepartmentTreeService;
        this.uucDepartmentTreeQueryService = uucDepartmentTreeQueryService;
    }

    /**
     * {@code POST  /uuc-department-trees} : Create a new uucDepartmentTree.
     *
     * @param uucDepartmentTree the uucDepartmentTree to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new uucDepartmentTree, or with status {@code 400 (Bad Request)} if the uucDepartmentTree has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/uuc-department-trees")
    public ResponseEntity<UucDepartmentTree> createUucDepartmentTree(@RequestBody UucDepartmentTree uucDepartmentTree) throws URISyntaxException {
        log.debug("REST request to save UucDepartmentTree : {}", uucDepartmentTree);
        if (uucDepartmentTree.getId() != null) {
            throw new BadRequestAlertException("A new uucDepartmentTree cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UucDepartmentTree result = uucDepartmentTreeService.save(uucDepartmentTree);
        return ResponseEntity.created(new URI("/api/uuc-department-trees/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /uuc-department-trees} : Updates an existing uucDepartmentTree.
     *
     * @param uucDepartmentTree the uucDepartmentTree to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated uucDepartmentTree,
     * or with status {@code 400 (Bad Request)} if the uucDepartmentTree is not valid,
     * or with status {@code 500 (Internal Server Error)} if the uucDepartmentTree couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/uuc-department-trees")
    public ResponseEntity<UucDepartmentTree> updateUucDepartmentTree(@RequestBody UucDepartmentTree uucDepartmentTree) throws URISyntaxException {
        log.debug("REST request to update UucDepartmentTree : {}", uucDepartmentTree);
        if (uucDepartmentTree.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UucDepartmentTree result = uucDepartmentTreeService.save(uucDepartmentTree);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, uucDepartmentTree.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /uuc-department-trees} : get all the uucDepartmentTrees.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of uucDepartmentTrees in body.
     */
    @GetMapping("/uuc-department-trees")
    public ResponseEntity<List<UucDepartmentTree>> getAllUucDepartmentTrees(UucDepartmentTreeCriteria criteria, Pageable pageable) {
        log.debug("REST request to get UucDepartmentTrees by criteria: {}", criteria);
        Page<UucDepartmentTree> page = uucDepartmentTreeQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /uuc-department-trees/count} : count all the uucDepartmentTrees.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/uuc-department-trees/count")
    public ResponseEntity<Long> countUucDepartmentTrees(UucDepartmentTreeCriteria criteria) {
        log.debug("REST request to count UucDepartmentTrees by criteria: {}", criteria);
        return ResponseEntity.ok().body(uucDepartmentTreeQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /uuc-department-trees/:id} : get the "id" uucDepartmentTree.
     *
     * @param id the id of the uucDepartmentTree to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the uucDepartmentTree, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/uuc-department-trees/{id}")
    public ResponseEntity<UucDepartmentTree> getUucDepartmentTree(@PathVariable Long id) {
        log.debug("REST request to get UucDepartmentTree : {}", id);
        Optional<UucDepartmentTree> uucDepartmentTree = uucDepartmentTreeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(uucDepartmentTree);
    }

    /**
     * {@code DELETE  /uuc-department-trees/:id} : delete the "id" uucDepartmentTree.
     *
     * @param id the id of the uucDepartmentTree to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/uuc-department-trees/{id}")
    public ResponseEntity<Void> deleteUucDepartmentTree(@PathVariable Long id) {
        log.debug("REST request to delete UucDepartmentTree : {}", id);
        uucDepartmentTreeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
