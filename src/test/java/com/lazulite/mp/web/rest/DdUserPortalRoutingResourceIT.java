package com.lazulite.mp.web.rest;

import com.lazulite.mp.JhipsterSampleApplication20201127App;
import com.lazulite.mp.domain.DdUserPortalRouting;
import com.lazulite.mp.repository.DdUserPortalRoutingRepository;
import com.lazulite.mp.service.DdUserPortalRoutingService;

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
 * Integration tests for the {@link DdUserPortalRoutingResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplication20201127App.class)
@AutoConfigureMockMvc
@WithMockUser
public class DdUserPortalRoutingResourceIT {

    private static final String DEFAULT_JOB_CODE = "AAAAAAAAAA";
    private static final String UPDATED_JOB_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE = "BBBBBBBBBB";

    private static final String DEFAULT_MICROAPP_URL = "AAAAAAAAAA";
    private static final String UPDATED_MICROAPP_URL = "BBBBBBBBBB";

    private static final String DEFAULT_INJECTION_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_INJECTION_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_INJECTION_API_URI = "AAAAAAAAAA";
    private static final String UPDATED_INJECTION_API_URI = "BBBBBBBBBB";

    private static final String DEFAULT_MUC_APP_ID = "AAAAAAAAAA";
    private static final String UPDATED_MUC_APP_ID = "BBBBBBBBBB";

    @Autowired
    private DdUserPortalRoutingRepository ddUserPortalRoutingRepository;

    @Autowired
    private DdUserPortalRoutingService ddUserPortalRoutingService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDdUserPortalRoutingMockMvc;

    private DdUserPortalRouting ddUserPortalRouting;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DdUserPortalRouting createEntity(EntityManager em) {
        DdUserPortalRouting ddUserPortalRouting = new DdUserPortalRouting()
            .jobCode(DEFAULT_JOB_CODE)
            .mobile(DEFAULT_MOBILE)
            .microappUrl(DEFAULT_MICROAPP_URL)
            .injectionFlag(DEFAULT_INJECTION_FLAG)
            .injectionApiUri(DEFAULT_INJECTION_API_URI)
            .mucAppId(DEFAULT_MUC_APP_ID);
        return ddUserPortalRouting;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DdUserPortalRouting createUpdatedEntity(EntityManager em) {
        DdUserPortalRouting ddUserPortalRouting = new DdUserPortalRouting()
            .jobCode(UPDATED_JOB_CODE)
            .mobile(UPDATED_MOBILE)
            .microappUrl(UPDATED_MICROAPP_URL)
            .injectionFlag(UPDATED_INJECTION_FLAG)
            .injectionApiUri(UPDATED_INJECTION_API_URI)
            .mucAppId(UPDATED_MUC_APP_ID);
        return ddUserPortalRouting;
    }

    @BeforeEach
    public void initTest() {
        ddUserPortalRouting = createEntity(em);
    }

    @Test
    @Transactional
    public void createDdUserPortalRouting() throws Exception {
        int databaseSizeBeforeCreate = ddUserPortalRoutingRepository.findAll().size();
        // Create the DdUserPortalRouting
        restDdUserPortalRoutingMockMvc.perform(post("/api/dd-user-portal-routings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(ddUserPortalRouting)))
            .andExpect(status().isCreated());

        // Validate the DdUserPortalRouting in the database
        List<DdUserPortalRouting> ddUserPortalRoutingList = ddUserPortalRoutingRepository.findAll();
        assertThat(ddUserPortalRoutingList).hasSize(databaseSizeBeforeCreate + 1);
        DdUserPortalRouting testDdUserPortalRouting = ddUserPortalRoutingList.get(ddUserPortalRoutingList.size() - 1);
        assertThat(testDdUserPortalRouting.getJobCode()).isEqualTo(DEFAULT_JOB_CODE);
        assertThat(testDdUserPortalRouting.getMobile()).isEqualTo(DEFAULT_MOBILE);
        assertThat(testDdUserPortalRouting.getMicroappUrl()).isEqualTo(DEFAULT_MICROAPP_URL);
        assertThat(testDdUserPortalRouting.getInjectionFlag()).isEqualTo(DEFAULT_INJECTION_FLAG);
        assertThat(testDdUserPortalRouting.getInjectionApiUri()).isEqualTo(DEFAULT_INJECTION_API_URI);
        assertThat(testDdUserPortalRouting.getMucAppId()).isEqualTo(DEFAULT_MUC_APP_ID);
    }

    @Test
    @Transactional
    public void createDdUserPortalRoutingWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = ddUserPortalRoutingRepository.findAll().size();

        // Create the DdUserPortalRouting with an existing ID
        ddUserPortalRouting.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDdUserPortalRoutingMockMvc.perform(post("/api/dd-user-portal-routings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(ddUserPortalRouting)))
            .andExpect(status().isBadRequest());

        // Validate the DdUserPortalRouting in the database
        List<DdUserPortalRouting> ddUserPortalRoutingList = ddUserPortalRoutingRepository.findAll();
        assertThat(ddUserPortalRoutingList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllDdUserPortalRoutings() throws Exception {
        // Initialize the database
        ddUserPortalRoutingRepository.saveAndFlush(ddUserPortalRouting);

        // Get all the ddUserPortalRoutingList
        restDdUserPortalRoutingMockMvc.perform(get("/api/dd-user-portal-routings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(ddUserPortalRouting.getId().intValue())))
            .andExpect(jsonPath("$.[*].jobCode").value(hasItem(DEFAULT_JOB_CODE)))
            .andExpect(jsonPath("$.[*].mobile").value(hasItem(DEFAULT_MOBILE)))
            .andExpect(jsonPath("$.[*].microappUrl").value(hasItem(DEFAULT_MICROAPP_URL)))
            .andExpect(jsonPath("$.[*].injectionFlag").value(hasItem(DEFAULT_INJECTION_FLAG)))
            .andExpect(jsonPath("$.[*].injectionApiUri").value(hasItem(DEFAULT_INJECTION_API_URI)))
            .andExpect(jsonPath("$.[*].mucAppId").value(hasItem(DEFAULT_MUC_APP_ID)));
    }
    
    @Test
    @Transactional
    public void getDdUserPortalRouting() throws Exception {
        // Initialize the database
        ddUserPortalRoutingRepository.saveAndFlush(ddUserPortalRouting);

        // Get the ddUserPortalRouting
        restDdUserPortalRoutingMockMvc.perform(get("/api/dd-user-portal-routings/{id}", ddUserPortalRouting.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(ddUserPortalRouting.getId().intValue()))
            .andExpect(jsonPath("$.jobCode").value(DEFAULT_JOB_CODE))
            .andExpect(jsonPath("$.mobile").value(DEFAULT_MOBILE))
            .andExpect(jsonPath("$.microappUrl").value(DEFAULT_MICROAPP_URL))
            .andExpect(jsonPath("$.injectionFlag").value(DEFAULT_INJECTION_FLAG))
            .andExpect(jsonPath("$.injectionApiUri").value(DEFAULT_INJECTION_API_URI))
            .andExpect(jsonPath("$.mucAppId").value(DEFAULT_MUC_APP_ID));
    }
    @Test
    @Transactional
    public void getNonExistingDdUserPortalRouting() throws Exception {
        // Get the ddUserPortalRouting
        restDdUserPortalRoutingMockMvc.perform(get("/api/dd-user-portal-routings/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDdUserPortalRouting() throws Exception {
        // Initialize the database
        ddUserPortalRoutingService.save(ddUserPortalRouting);

        int databaseSizeBeforeUpdate = ddUserPortalRoutingRepository.findAll().size();

        // Update the ddUserPortalRouting
        DdUserPortalRouting updatedDdUserPortalRouting = ddUserPortalRoutingRepository.findById(ddUserPortalRouting.getId()).get();
        // Disconnect from session so that the updates on updatedDdUserPortalRouting are not directly saved in db
        em.detach(updatedDdUserPortalRouting);
        updatedDdUserPortalRouting
            .jobCode(UPDATED_JOB_CODE)
            .mobile(UPDATED_MOBILE)
            .microappUrl(UPDATED_MICROAPP_URL)
            .injectionFlag(UPDATED_INJECTION_FLAG)
            .injectionApiUri(UPDATED_INJECTION_API_URI)
            .mucAppId(UPDATED_MUC_APP_ID);

        restDdUserPortalRoutingMockMvc.perform(put("/api/dd-user-portal-routings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedDdUserPortalRouting)))
            .andExpect(status().isOk());

        // Validate the DdUserPortalRouting in the database
        List<DdUserPortalRouting> ddUserPortalRoutingList = ddUserPortalRoutingRepository.findAll();
        assertThat(ddUserPortalRoutingList).hasSize(databaseSizeBeforeUpdate);
        DdUserPortalRouting testDdUserPortalRouting = ddUserPortalRoutingList.get(ddUserPortalRoutingList.size() - 1);
        assertThat(testDdUserPortalRouting.getJobCode()).isEqualTo(UPDATED_JOB_CODE);
        assertThat(testDdUserPortalRouting.getMobile()).isEqualTo(UPDATED_MOBILE);
        assertThat(testDdUserPortalRouting.getMicroappUrl()).isEqualTo(UPDATED_MICROAPP_URL);
        assertThat(testDdUserPortalRouting.getInjectionFlag()).isEqualTo(UPDATED_INJECTION_FLAG);
        assertThat(testDdUserPortalRouting.getInjectionApiUri()).isEqualTo(UPDATED_INJECTION_API_URI);
        assertThat(testDdUserPortalRouting.getMucAppId()).isEqualTo(UPDATED_MUC_APP_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingDdUserPortalRouting() throws Exception {
        int databaseSizeBeforeUpdate = ddUserPortalRoutingRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDdUserPortalRoutingMockMvc.perform(put("/api/dd-user-portal-routings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(ddUserPortalRouting)))
            .andExpect(status().isBadRequest());

        // Validate the DdUserPortalRouting in the database
        List<DdUserPortalRouting> ddUserPortalRoutingList = ddUserPortalRoutingRepository.findAll();
        assertThat(ddUserPortalRoutingList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDdUserPortalRouting() throws Exception {
        // Initialize the database
        ddUserPortalRoutingService.save(ddUserPortalRouting);

        int databaseSizeBeforeDelete = ddUserPortalRoutingRepository.findAll().size();

        // Delete the ddUserPortalRouting
        restDdUserPortalRoutingMockMvc.perform(delete("/api/dd-user-portal-routings/{id}", ddUserPortalRouting.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DdUserPortalRouting> ddUserPortalRoutingList = ddUserPortalRoutingRepository.findAll();
        assertThat(ddUserPortalRoutingList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
