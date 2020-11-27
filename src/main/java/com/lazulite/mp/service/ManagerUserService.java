package com.lazulite.mp.service;

import com.lazulite.mp.domain.ManagerUser;
import com.lazulite.mp.repository.ManagerUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link ManagerUser}.
 */
@Service
@Transactional
public class ManagerUserService {

    private final Logger log = LoggerFactory.getLogger(ManagerUserService.class);

    private final ManagerUserRepository managerUserRepository;

    public ManagerUserService(ManagerUserRepository managerUserRepository) {
        this.managerUserRepository = managerUserRepository;
    }

    /**
     * Save a managerUser.
     *
     * @param managerUser the entity to save.
     * @return the persisted entity.
     */
    public ManagerUser save(ManagerUser managerUser) {
        log.debug("Request to save ManagerUser : {}", managerUser);
        return managerUserRepository.save(managerUser);
    }

    /**
     * Get all the managerUsers.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<ManagerUser> findAll() {
        log.debug("Request to get all ManagerUsers");
        return managerUserRepository.findAllWithEagerRelationships();
    }


    /**
     * Get all the managerUsers with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<ManagerUser> findAllWithEagerRelationships(Pageable pageable) {
        return managerUserRepository.findAllWithEagerRelationships(pageable);
    }

    /**
     * Get one managerUser by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ManagerUser> findOne(Long id) {
        log.debug("Request to get ManagerUser : {}", id);
        return managerUserRepository.findOneWithEagerRelationships(id);
    }

    /**
     * Delete the managerUser by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ManagerUser : {}", id);
        managerUserRepository.deleteById(id);
    }
}
