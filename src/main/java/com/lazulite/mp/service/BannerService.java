package com.lazulite.mp.service;

import com.lazulite.mp.domain.Banner;
import com.lazulite.mp.repository.BannerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Banner}.
 */
@Service
@Transactional
public class BannerService {

    private final Logger log = LoggerFactory.getLogger(BannerService.class);

    private final BannerRepository bannerRepository;

    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    /**
     * Save a banner.
     *
     * @param banner the entity to save.
     * @return the persisted entity.
     */
    public Banner save(Banner banner) {
        log.debug("Request to save Banner : {}", banner);
        return bannerRepository.save(banner);
    }

    /**
     * Get all the banners.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<Banner> findAll() {
        log.debug("Request to get all Banners");
        return bannerRepository.findAll();
    }


    /**
     * Get one banner by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Banner> findOne(Long id) {
        log.debug("Request to get Banner : {}", id);
        return bannerRepository.findById(id);
    }

    /**
     * Delete the banner by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Banner : {}", id);
        bannerRepository.deleteById(id);
    }
}
