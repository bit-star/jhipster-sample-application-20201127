package com.lazulite.mp.web.rest;

import com.lazulite.mp.domain.ManagerUser;
import com.lazulite.mp.service.ManagerUserService;
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
 * REST controller for managing {@link com.lazulite.mp.domain.ManagerUser}.
 */
@RestController
@RequestMapping("/api")
public class ManagerUserResource {

    private final Logger log = LoggerFactory.getLogger(ManagerUserResource.class);

    private static final String ENTITY_NAME = "managerUser";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ManagerUserService managerUserService;

    public ManagerUserResource(ManagerUserService managerUserService) {
        this.managerUserService = managerUserService;
    }

    /**
     * {@code POST  /manager-users} : Create a new managerUser.
     *
     * @param managerUser the managerUser to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new managerUser, or with status {@code 400 (Bad Request)} if the managerUser has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/manager-users")
    public ResponseEntity<ManagerUser> createManagerUser(@RequestBody ManagerUser managerUser) throws URISyntaxException {
        log.debug("REST request to save ManagerUser : {}", managerUser);
        if (managerUser.getId() != null) {
            throw new BadRequestAlertException("A new managerUser cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ManagerUser result = managerUserService.save(managerUser);
        return ResponseEntity.created(new URI("/api/manager-users/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /manager-users} : Updates an existing managerUser.
     *
     * @param managerUser the managerUser to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated managerUser,
     * or with status {@code 400 (Bad Request)} if the managerUser is not valid,
     * or with status {@code 500 (Internal Server Error)} if the managerUser couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/manager-users")
    public ResponseEntity<ManagerUser> updateManagerUser(@RequestBody ManagerUser managerUser) throws URISyntaxException {
        log.debug("REST request to update ManagerUser : {}", managerUser);
        if (managerUser.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ManagerUser result = managerUserService.save(managerUser);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, managerUser.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /manager-users} : get all the managerUsers.
     *
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of managerUsers in body.
     */
    @GetMapping("/manager-users")
    public List<ManagerUser> getAllManagerUsers(@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get all ManagerUsers");
        return managerUserService.findAll();
    }

    /**
     * {@code GET  /manager-users/:id} : get the "id" managerUser.
     *
     * @param id the id of the managerUser to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the managerUser, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/manager-users/{id}")
    public ResponseEntity<ManagerUser> getManagerUser(@PathVariable Long id) {
        log.debug("REST request to get ManagerUser : {}", id);
        Optional<ManagerUser> managerUser = managerUserService.findOne(id);
        return ResponseUtil.wrapOrNotFound(managerUser);
    }

    /**
     * {@code DELETE  /manager-users/:id} : delete the "id" managerUser.
     *
     * @param id the id of the managerUser to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/manager-users/{id}")
    public ResponseEntity<Void> deleteManagerUser(@PathVariable Long id) {
        log.debug("REST request to delete ManagerUser : {}", id);
        managerUserService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
