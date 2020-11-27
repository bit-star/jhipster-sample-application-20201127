package com.lazulite.mp.service;

import com.lazulite.mp.domain.FmpMicroAppType;
import com.lazulite.mp.repository.FmpMicroAppTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link FmpMicroAppType}.
 */
@Service
@Transactional
public class FmpMicroAppTypeService {

    private final Logger log = LoggerFactory.getLogger(FmpMicroAppTypeService.class);

    private final FmpMicroAppTypeRepository fmpMicroAppTypeRepository;

    public FmpMicroAppTypeService(FmpMicroAppTypeRepository fmpMicroAppTypeRepository) {
        this.fmpMicroAppTypeRepository = fmpMicroAppTypeRepository;
    }

    /**
     * Save a fmpMicroAppType.
     *
     * @param fmpMicroAppType the entity to save.
     * @return the persisted entity.
     */
    public FmpMicroAppType save(FmpMicroAppType fmpMicroAppType) {
        log.debug("Request to save FmpMicroAppType : {}", fmpMicroAppType);
        return fmpMicroAppTypeRepository.save(fmpMicroAppType);
    }

    /**
     * Get all the fmpMicroAppTypes.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<FmpMicroAppType> findAll() {
        log.debug("Request to get all FmpMicroAppTypes");
        return fmpMicroAppTypeRepository.findAll();
    }


    /**
     * Get one fmpMicroAppType by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<FmpMicroAppType> findOne(Long id) {
        log.debug("Request to get FmpMicroAppType : {}", id);
        return fmpMicroAppTypeRepository.findById(id);
    }

    /**
     * Delete the fmpMicroAppType by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete FmpMicroAppType : {}", id);
        fmpMicroAppTypeRepository.deleteById(id);
    }
}
