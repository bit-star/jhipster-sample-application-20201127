package com.lazulite.mp.service;

import com.lazulite.mp.domain.DdUser;
import com.lazulite.mp.repository.DdUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link DdUser}.
 */
@Service
@Transactional
public class DdUserService {

    private final Logger log = LoggerFactory.getLogger(DdUserService.class);

    private final DdUserRepository ddUserRepository;

    public DdUserService(DdUserRepository ddUserRepository) {
        this.ddUserRepository = ddUserRepository;
    }

    /**
     * Save a ddUser.
     *
     * @param ddUser the entity to save.
     * @return the persisted entity.
     */
    public DdUser save(DdUser ddUser) {
        log.debug("Request to save DdUser : {}", ddUser);
        return ddUserRepository.save(ddUser);
    }

    /**
     * Get all the ddUsers.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<DdUser> findAll() {
        log.debug("Request to get all DdUsers");
        return ddUserRepository.findAll();
    }


    /**
     * Get one ddUser by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DdUser> findOne(Long id) {
        log.debug("Request to get DdUser : {}", id);
        return ddUserRepository.findById(id);
    }

    /**
     * Delete the ddUser by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete DdUser : {}", id);
        ddUserRepository.deleteById(id);
    }
}
