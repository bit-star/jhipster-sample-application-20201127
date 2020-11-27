package com.lazulite.mp.web.rest;

import com.lazulite.mp.JhipsterSampleApplication20201127App;
import com.lazulite.mp.domain.Banner;
import com.lazulite.mp.repository.BannerRepository;
import com.lazulite.mp.service.BannerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.lazulite.mp.domain.enumeration.BannerType;
import com.lazulite.mp.domain.enumeration.Status;
/**
 * Integration tests for the {@link BannerResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplication20201127App.class)
@AutoConfigureMockMvc
@WithMockUser
public class BannerResourceIT {

    private static final Long DEFAULT_RANK = 1L;
    private static final Long UPDATED_RANK = 2L;

    private static final BannerType DEFAULT_TYPE = BannerType.Global;
    private static final BannerType UPDATED_TYPE = BannerType.General;

    private static final Status DEFAULT_STATUS = Status.Available;
    private static final Status UPDATED_STATUS = Status.Unavailable;

    private static final String DEFAULT_PATH_URL = "AAAAAAAAAA";
    private static final String UPDATED_PATH_URL = "BBBBBBBBBB";

    private static final String DEFAULT_BANNER_URL = "AAAAAAAAAA";
    private static final String UPDATED_BANNER_URL = "BBBBBBBBBB";

    private static final String DEFAULT_REMARK = "AAAAAAAAAA";
    private static final String UPDATED_REMARK = "BBBBBBBBBB";

    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restBannerMockMvc;

    private Banner banner;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Banner createEntity(EntityManager em) {
        Banner banner = new Banner()
            .rank(DEFAULT_RANK)
            .type(DEFAULT_TYPE)
            .status(DEFAULT_STATUS)
            .pathUrl(DEFAULT_PATH_URL)
            .bannerUrl(DEFAULT_BANNER_URL)
            .remark(DEFAULT_REMARK);
        return banner;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Banner createUpdatedEntity(EntityManager em) {
        Banner banner = new Banner()
            .rank(UPDATED_RANK)
            .type(UPDATED_TYPE)
            .status(UPDATED_STATUS)
            .pathUrl(UPDATED_PATH_URL)
            .bannerUrl(UPDATED_BANNER_URL)
            .remark(UPDATED_REMARK);
        return banner;
    }

    @BeforeEach
    public void initTest() {
        banner = createEntity(em);
    }

    @Test
    @Transactional
    public void createBanner() throws Exception {
        int databaseSizeBeforeCreate = bannerRepository.findAll().size();
        // Create the Banner
        restBannerMockMvc.perform(post("/api/banners")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(banner)))
            .andExpect(status().isCreated());

        // Validate the Banner in the database
        List<Banner> bannerList = bannerRepository.findAll();
        assertThat(bannerList).hasSize(databaseSizeBeforeCreate + 1);
        Banner testBanner = bannerList.get(bannerList.size() - 1);
        assertThat(testBanner.getRank()).isEqualTo(DEFAULT_RANK);
        assertThat(testBanner.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testBanner.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testBanner.getPathUrl()).isEqualTo(DEFAULT_PATH_URL);
        assertThat(testBanner.getBannerUrl()).isEqualTo(DEFAULT_BANNER_URL);
        assertThat(testBanner.getRemark()).isEqualTo(DEFAULT_REMARK);
    }

    @Test
    @Transactional
    public void createBannerWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bannerRepository.findAll().size();

        // Create the Banner with an existing ID
        banner.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBannerMockMvc.perform(post("/api/banners")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(banner)))
            .andExpect(status().isBadRequest());

        // Validate the Banner in the database
        List<Banner> bannerList = bannerRepository.findAll();
        assertThat(bannerList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllBanners() throws Exception {
        // Initialize the database
        bannerRepository.saveAndFlush(banner);

        // Get all the bannerList
        restBannerMockMvc.perform(get("/api/banners?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(banner.getId().intValue())))
            .andExpect(jsonPath("$.[*].rank").value(hasItem(DEFAULT_RANK.intValue())))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].pathUrl").value(hasItem(DEFAULT_PATH_URL)))
            .andExpect(jsonPath("$.[*].bannerUrl").value(hasItem(DEFAULT_BANNER_URL)))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK)));
    }
    
    @Test
    @Transactional
    public void getBanner() throws Exception {
        // Initialize the database
        bannerRepository.saveAndFlush(banner);

        // Get the banner
        restBannerMockMvc.perform(get("/api/banners/{id}", banner.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(banner.getId().intValue()))
            .andExpect(jsonPath("$.rank").value(DEFAULT_RANK.intValue()))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.pathUrl").value(DEFAULT_PATH_URL))
            .andExpect(jsonPath("$.bannerUrl").value(DEFAULT_BANNER_URL))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK));
    }
    @Test
    @Transactional
    public void getNonExistingBanner() throws Exception {
        // Get the banner
        restBannerMockMvc.perform(get("/api/banners/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBanner() throws Exception {
        // Initialize the database
        bannerService.save(banner);

        int databaseSizeBeforeUpdate = bannerRepository.findAll().size();

        // Update the banner
        Banner updatedBanner = bannerRepository.findById(banner.getId()).get();
        // Disconnect from session so that the updates on updatedBanner are not directly saved in db
        em.detach(updatedBanner);
        updatedBanner
            .rank(UPDATED_RANK)
            .type(UPDATED_TYPE)
            .status(UPDATED_STATUS)
            .pathUrl(UPDATED_PATH_URL)
            .bannerUrl(UPDATED_BANNER_URL)
            .remark(UPDATED_REMARK);

        restBannerMockMvc.perform(put("/api/banners")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedBanner)))
            .andExpect(status().isOk());

        // Validate the Banner in the database
        List<Banner> bannerList = bannerRepository.findAll();
        assertThat(bannerList).hasSize(databaseSizeBeforeUpdate);
        Banner testBanner = bannerList.get(bannerList.size() - 1);
        assertThat(testBanner.getRank()).isEqualTo(UPDATED_RANK);
        assertThat(testBanner.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testBanner.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testBanner.getPathUrl()).isEqualTo(UPDATED_PATH_URL);
        assertThat(testBanner.getBannerUrl()).isEqualTo(UPDATED_BANNER_URL);
        assertThat(testBanner.getRemark()).isEqualTo(UPDATED_REMARK);
    }

    @Test
    @Transactional
    public void updateNonExistingBanner() throws Exception {
        int databaseSizeBeforeUpdate = bannerRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBannerMockMvc.perform(put("/api/banners")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(banner)))
            .andExpect(status().isBadRequest());

        // Validate the Banner in the database
        List<Banner> bannerList = bannerRepository.findAll();
        assertThat(bannerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBanner() throws Exception {
        // Initialize the database
        bannerService.save(banner);

        int databaseSizeBeforeDelete = bannerRepository.findAll().size();

        // Delete the banner
        restBannerMockMvc.perform(delete("/api/banners/{id}", banner.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Banner> bannerList = bannerRepository.findAll();
        assertThat(bannerList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
