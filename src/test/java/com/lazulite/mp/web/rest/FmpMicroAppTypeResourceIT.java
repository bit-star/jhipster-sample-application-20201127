package com.lazulite.mp.web.rest;

import com.lazulite.mp.JhipsterSampleApplication20201127App;
import com.lazulite.mp.domain.FmpMicroAppType;
import com.lazulite.mp.repository.FmpMicroAppTypeRepository;
import com.lazulite.mp.service.FmpMicroAppTypeService;

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

/**
 * Integration tests for the {@link FmpMicroAppTypeResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplication20201127App.class)
@AutoConfigureMockMvc
@WithMockUser
public class FmpMicroAppTypeResourceIT {

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LANGUAGE = "AAAAAAAAAA";
    private static final String UPDATED_LANGUAGE = "BBBBBBBBBB";

    private static final String DEFAULT_PORTAL_ID = "AAAAAAAAAA";
    private static final String UPDATED_PORTAL_ID = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_DELETED = false;
    private static final Boolean UPDATED_IS_DELETED = true;

    @Autowired
    private FmpMicroAppTypeRepository fmpMicroAppTypeRepository;

    @Autowired
    private FmpMicroAppTypeService fmpMicroAppTypeService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFmpMicroAppTypeMockMvc;

    private FmpMicroAppType fmpMicroAppType;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FmpMicroAppType createEntity(EntityManager em) {
        FmpMicroAppType fmpMicroAppType = new FmpMicroAppType()
            .code(DEFAULT_CODE)
            .name(DEFAULT_NAME)
            .language(DEFAULT_LANGUAGE)
            .portalId(DEFAULT_PORTAL_ID)
            .isDeleted(DEFAULT_IS_DELETED);
        return fmpMicroAppType;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FmpMicroAppType createUpdatedEntity(EntityManager em) {
        FmpMicroAppType fmpMicroAppType = new FmpMicroAppType()
            .code(UPDATED_CODE)
            .name(UPDATED_NAME)
            .language(UPDATED_LANGUAGE)
            .portalId(UPDATED_PORTAL_ID)
            .isDeleted(UPDATED_IS_DELETED);
        return fmpMicroAppType;
    }

    @BeforeEach
    public void initTest() {
        fmpMicroAppType = createEntity(em);
    }

    @Test
    @Transactional
    public void createFmpMicroAppType() throws Exception {
        int databaseSizeBeforeCreate = fmpMicroAppTypeRepository.findAll().size();
        // Create the FmpMicroAppType
        restFmpMicroAppTypeMockMvc.perform(post("/api/fmp-micro-app-types")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fmpMicroAppType)))
            .andExpect(status().isCreated());

        // Validate the FmpMicroAppType in the database
        List<FmpMicroAppType> fmpMicroAppTypeList = fmpMicroAppTypeRepository.findAll();
        assertThat(fmpMicroAppTypeList).hasSize(databaseSizeBeforeCreate + 1);
        FmpMicroAppType testFmpMicroAppType = fmpMicroAppTypeList.get(fmpMicroAppTypeList.size() - 1);
        assertThat(testFmpMicroAppType.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testFmpMicroAppType.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testFmpMicroAppType.getLanguage()).isEqualTo(DEFAULT_LANGUAGE);
        assertThat(testFmpMicroAppType.getPortalId()).isEqualTo(DEFAULT_PORTAL_ID);
        assertThat(testFmpMicroAppType.isIsDeleted()).isEqualTo(DEFAULT_IS_DELETED);
    }

    @Test
    @Transactional
    public void createFmpMicroAppTypeWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = fmpMicroAppTypeRepository.findAll().size();

        // Create the FmpMicroAppType with an existing ID
        fmpMicroAppType.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFmpMicroAppTypeMockMvc.perform(post("/api/fmp-micro-app-types")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fmpMicroAppType)))
            .andExpect(status().isBadRequest());

        // Validate the FmpMicroAppType in the database
        List<FmpMicroAppType> fmpMicroAppTypeList = fmpMicroAppTypeRepository.findAll();
        assertThat(fmpMicroAppTypeList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllFmpMicroAppTypes() throws Exception {
        // Initialize the database
        fmpMicroAppTypeRepository.saveAndFlush(fmpMicroAppType);

        // Get all the fmpMicroAppTypeList
        restFmpMicroAppTypeMockMvc.perform(get("/api/fmp-micro-app-types?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(fmpMicroAppType.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].language").value(hasItem(DEFAULT_LANGUAGE)))
            .andExpect(jsonPath("$.[*].portalId").value(hasItem(DEFAULT_PORTAL_ID)))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED.booleanValue())));
    }
    
    @Test
    @Transactional
    public void getFmpMicroAppType() throws Exception {
        // Initialize the database
        fmpMicroAppTypeRepository.saveAndFlush(fmpMicroAppType);

        // Get the fmpMicroAppType
        restFmpMicroAppTypeMockMvc.perform(get("/api/fmp-micro-app-types/{id}", fmpMicroAppType.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(fmpMicroAppType.getId().intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.language").value(DEFAULT_LANGUAGE))
            .andExpect(jsonPath("$.portalId").value(DEFAULT_PORTAL_ID))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED.booleanValue()));
    }
    @Test
    @Transactional
    public void getNonExistingFmpMicroAppType() throws Exception {
        // Get the fmpMicroAppType
        restFmpMicroAppTypeMockMvc.perform(get("/api/fmp-micro-app-types/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFmpMicroAppType() throws Exception {
        // Initialize the database
        fmpMicroAppTypeService.save(fmpMicroAppType);

        int databaseSizeBeforeUpdate = fmpMicroAppTypeRepository.findAll().size();

        // Update the fmpMicroAppType
        FmpMicroAppType updatedFmpMicroAppType = fmpMicroAppTypeRepository.findById(fmpMicroAppType.getId()).get();
        // Disconnect from session so that the updates on updatedFmpMicroAppType are not directly saved in db
        em.detach(updatedFmpMicroAppType);
        updatedFmpMicroAppType
            .code(UPDATED_CODE)
            .name(UPDATED_NAME)
            .language(UPDATED_LANGUAGE)
            .portalId(UPDATED_PORTAL_ID)
            .isDeleted(UPDATED_IS_DELETED);

        restFmpMicroAppTypeMockMvc.perform(put("/api/fmp-micro-app-types")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedFmpMicroAppType)))
            .andExpect(status().isOk());

        // Validate the FmpMicroAppType in the database
        List<FmpMicroAppType> fmpMicroAppTypeList = fmpMicroAppTypeRepository.findAll();
        assertThat(fmpMicroAppTypeList).hasSize(databaseSizeBeforeUpdate);
        FmpMicroAppType testFmpMicroAppType = fmpMicroAppTypeList.get(fmpMicroAppTypeList.size() - 1);
        assertThat(testFmpMicroAppType.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testFmpMicroAppType.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testFmpMicroAppType.getLanguage()).isEqualTo(UPDATED_LANGUAGE);
        assertThat(testFmpMicroAppType.getPortalId()).isEqualTo(UPDATED_PORTAL_ID);
        assertThat(testFmpMicroAppType.isIsDeleted()).isEqualTo(UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    public void updateNonExistingFmpMicroAppType() throws Exception {
        int databaseSizeBeforeUpdate = fmpMicroAppTypeRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFmpMicroAppTypeMockMvc.perform(put("/api/fmp-micro-app-types")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fmpMicroAppType)))
            .andExpect(status().isBadRequest());

        // Validate the FmpMicroAppType in the database
        List<FmpMicroAppType> fmpMicroAppTypeList = fmpMicroAppTypeRepository.findAll();
        assertThat(fmpMicroAppTypeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteFmpMicroAppType() throws Exception {
        // Initialize the database
        fmpMicroAppTypeService.save(fmpMicroAppType);

        int databaseSizeBeforeDelete = fmpMicroAppTypeRepository.findAll().size();

        // Delete the fmpMicroAppType
        restFmpMicroAppTypeMockMvc.perform(delete("/api/fmp-micro-app-types/{id}", fmpMicroAppType.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<FmpMicroAppType> fmpMicroAppTypeList = fmpMicroAppTypeRepository.findAll();
        assertThat(fmpMicroAppTypeList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
