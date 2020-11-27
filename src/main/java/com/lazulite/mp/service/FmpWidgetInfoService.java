package com.lazulite.mp.service;

import com.lazulite.mp.domain.FmpWidgetInfo;
import com.lazulite.mp.repository.FmpWidgetInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link FmpWidgetInfo}.
 */
@Service
@Transactional
public class FmpWidgetInfoService {

    private final Logger log = LoggerFactory.getLogger(FmpWidgetInfoService.class);

    private final FmpWidgetInfoRepository fmpWidgetInfoRepository;

    public FmpWidgetInfoService(FmpWidgetInfoRepository fmpWidgetInfoRepository) {
        this.fmpWidgetInfoRepository = fmpWidgetInfoRepository;
    }

    /**
     * Save a fmpWidgetInfo.
     *
     * @param fmpWidgetInfo the entity to save.
     * @return the persisted entity.
     */
    public FmpWidgetInfo save(FmpWidgetInfo fmpWidgetInfo) {
        log.debug("Request to save FmpWidgetInfo : {}", fmpWidgetInfo);
        return fmpWidgetInfoRepository.save(fmpWidgetInfo);
    }

    /**
     * Get all the fmpWidgetInfos.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<FmpWidgetInfo> findAll() {
        log.debug("Request to get all FmpWidgetInfos");
        return fmpWidgetInfoRepository.findAll();
    }


    /**
     * Get one fmpWidgetInfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<FmpWidgetInfo> findOne(Long id) {
        log.debug("Request to get FmpWidgetInfo : {}", id);
        return fmpWidgetInfoRepository.findById(id);
    }

    /**
     * Delete the fmpWidgetInfo by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete FmpWidgetInfo : {}", id);
        fmpWidgetInfoRepository.deleteById(id);
    }
}
