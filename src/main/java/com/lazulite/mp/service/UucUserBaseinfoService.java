package com.lazulite.mp.service;

import com.lazulite.mp.domain.UucUserBaseinfo;
import com.lazulite.mp.repository.UucUserBaseinfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link UucUserBaseinfo}.
 */
@Service
@Transactional
public class UucUserBaseinfoService {

    private final Logger log = LoggerFactory.getLogger(UucUserBaseinfoService.class);

    private final UucUserBaseinfoRepository uucUserBaseinfoRepository;

    public UucUserBaseinfoService(UucUserBaseinfoRepository uucUserBaseinfoRepository) {
        this.uucUserBaseinfoRepository = uucUserBaseinfoRepository;
    }

    /**
     * Save a uucUserBaseinfo.
     *
     * @param uucUserBaseinfo the entity to save.
     * @return the persisted entity.
     */
    public UucUserBaseinfo save(UucUserBaseinfo uucUserBaseinfo) {
        log.debug("Request to save UucUserBaseinfo : {}", uucUserBaseinfo);
        return uucUserBaseinfoRepository.save(uucUserBaseinfo);
    }

    /**
     * Get all the uucUserBaseinfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<UucUserBaseinfo> findAll(Pageable pageable) {
        log.debug("Request to get all UucUserBaseinfos");
        return uucUserBaseinfoRepository.findAll(pageable);
    }


    /**
     * Get all the uucUserBaseinfos with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<UucUserBaseinfo> findAllWithEagerRelationships(Pageable pageable) {
        return uucUserBaseinfoRepository.findAllWithEagerRelationships(pageable);
    }

    /**
     * Get one uucUserBaseinfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UucUserBaseinfo> findOne(Long id) {
        log.debug("Request to get UucUserBaseinfo : {}", id);
        return uucUserBaseinfoRepository.findOneWithEagerRelationships(id);
    }

    /**
     * Delete the uucUserBaseinfo by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete UucUserBaseinfo : {}", id);
        uucUserBaseinfoRepository.deleteById(id);
    }
}
