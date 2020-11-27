package com.lazulite.mp.service;

import com.lazulite.mp.domain.UucDepartmentTree;
import com.lazulite.mp.repository.UucDepartmentTreeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link UucDepartmentTree}.
 */
@Service
@Transactional
public class UucDepartmentTreeService {

    private final Logger log = LoggerFactory.getLogger(UucDepartmentTreeService.class);

    private final UucDepartmentTreeRepository uucDepartmentTreeRepository;

    public UucDepartmentTreeService(UucDepartmentTreeRepository uucDepartmentTreeRepository) {
        this.uucDepartmentTreeRepository = uucDepartmentTreeRepository;
    }

    /**
     * Save a uucDepartmentTree.
     *
     * @param uucDepartmentTree the entity to save.
     * @return the persisted entity.
     */
    public UucDepartmentTree save(UucDepartmentTree uucDepartmentTree) {
        log.debug("Request to save UucDepartmentTree : {}", uucDepartmentTree);
        return uucDepartmentTreeRepository.save(uucDepartmentTree);
    }

    /**
     * Get all the uucDepartmentTrees.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<UucDepartmentTree> findAll(Pageable pageable) {
        log.debug("Request to get all UucDepartmentTrees");
        return uucDepartmentTreeRepository.findAll(pageable);
    }


    /**
     * Get one uucDepartmentTree by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UucDepartmentTree> findOne(Long id) {
        log.debug("Request to get UucDepartmentTree : {}", id);
        return uucDepartmentTreeRepository.findById(id);
    }

    /**
     * Delete the uucDepartmentTree by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete UucDepartmentTree : {}", id);
        uucDepartmentTreeRepository.deleteById(id);
    }
}
