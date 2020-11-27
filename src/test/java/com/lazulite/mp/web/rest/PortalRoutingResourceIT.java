package com.lazulite.mp.web.rest;

import com.lazulite.mp.JhipsterSampleApplication20201127App;
import com.lazulite.mp.domain.PortalRouting;
import com.lazulite.mp.repository.PortalRoutingRepository;
import com.lazulite.mp.service.PortalRoutingService;

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
 * Integration tests for the {@link PortalRoutingResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplication20201127App.class)
@AutoConfigureMockMvc
@WithMockUser
public class PortalRoutingResourceIT {

    private static final String DEFAULT_MUC_APP_OWNER = "AAAAAAAAAA";
    private static final String UPDATED_MUC_APP_OWNER = "BBBBBBBBBB";

    private static final String DEFAULT_MUC_APP_ID = "AAAAAAAAAA";
    private static final String UPDATED_MUC_APP_ID = "BBBBBBBBBB";

    private static final String DEFAULT_MUC_APP_URL = "AAAAAAAAAA";
    private static final String UPDATED_MUC_APP_URL = "BBBBBBBBBB";

    private static final String DEFAULT_MUC_APP_NAME = "AAAAAAAAAA";
    private static final String UPDATED_MUC_APP_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_MUC_APP_NAME_EN = "AAAAAAAAAA";
    private static final String UPDATED_MUC_APP_NAME_EN = "BBBBBBBBBB";

    @Autowired
    private PortalRoutingRepository portalRoutingRepository;

    @Autowired
    private PortalRoutingService portalRoutingService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPortalRoutingMockMvc;

    private PortalRouting portalRouting;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PortalRouting createEntity(EntityManager em) {
        PortalRouting portalRouting = new PortalRouting()
            .mucAppOwner(DEFAULT_MUC_APP_OWNER)
            .mucAppId(DEFAULT_MUC_APP_ID)
            .mucAppUrl(DEFAULT_MUC_APP_URL)
            .mucAppName(DEFAULT_MUC_APP_NAME)
            .mucAppNameEn(DEFAULT_MUC_APP_NAME_EN);
        return portalRouting;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PortalRouting createUpdatedEntity(EntityManager em) {
        PortalRouting portalRouting = new PortalRouting()
            .mucAppOwner(UPDATED_MUC_APP_OWNER)
            .mucAppId(UPDATED_MUC_APP_ID)
            .mucAppUrl(UPDATED_MUC_APP_URL)
            .mucAppName(UPDATED_MUC_APP_NAME)
            .mucAppNameEn(UPDATED_MUC_APP_NAME_EN);
        return portalRouting;
    }

    @BeforeEach
    public void initTest() {
        portalRouting = createEntity(em);
    }

    @Test
    @Transactional
    public void createPortalRouting() throws Exception {
        int databaseSizeBeforeCreate = portalRoutingRepository.findAll().size();
        // Create the PortalRouting
        restPortalRoutingMockMvc.perform(post("/api/portal-routings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(portalRouting)))
            .andExpect(status().isCreated());

        // Validate the PortalRouting in the database
        List<PortalRouting> portalRoutingList = portalRoutingRepository.findAll();
        assertThat(portalRoutingList).hasSize(databaseSizeBeforeCreate + 1);
        PortalRouting testPortalRouting = portalRoutingList.get(portalRoutingList.size() - 1);
        assertThat(testPortalRouting.getMucAppOwner()).isEqualTo(DEFAULT_MUC_APP_OWNER);
        assertThat(testPortalRouting.getMucAppId()).isEqualTo(DEFAULT_MUC_APP_ID);
        assertThat(testPortalRouting.getMucAppUrl()).isEqualTo(DEFAULT_MUC_APP_URL);
        assertThat(testPortalRouting.getMucAppName()).isEqualTo(DEFAULT_MUC_APP_NAME);
        assertThat(testPortalRouting.getMucAppNameEn()).isEqualTo(DEFAULT_MUC_APP_NAME_EN);
    }

    @Test
    @Transactional
    public void createPortalRoutingWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = portalRoutingRepository.findAll().size();

        // Create the PortalRouting with an existing ID
        portalRouting.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPortalRoutingMockMvc.perform(post("/api/portal-routings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(portalRouting)))
            .andExpect(status().isBadRequest());

        // Validate the PortalRouting in the database
        List<PortalRouting> portalRoutingList = portalRoutingRepository.findAll();
        assertThat(portalRoutingList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllPortalRoutings() throws Exception {
        // Initialize the database
        portalRoutingRepository.saveAndFlush(portalRouting);

        // Get all the portalRoutingList
        restPortalRoutingMockMvc.perform(get("/api/portal-routings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(portalRouting.getId().intValue())))
            .andExpect(jsonPath("$.[*].mucAppOwner").value(hasItem(DEFAULT_MUC_APP_OWNER)))
            .andExpect(jsonPath("$.[*].mucAppId").value(hasItem(DEFAULT_MUC_APP_ID)))
            .andExpect(jsonPath("$.[*].mucAppUrl").value(hasItem(DEFAULT_MUC_APP_URL)))
            .andExpect(jsonPath("$.[*].mucAppName").value(hasItem(DEFAULT_MUC_APP_NAME)))
            .andExpect(jsonPath("$.[*].mucAppNameEn").value(hasItem(DEFAULT_MUC_APP_NAME_EN)));
    }
    
    @Test
    @Transactional
    public void getPortalRouting() throws Exception {
        // Initialize the database
        portalRoutingRepository.saveAndFlush(portalRouting);

        // Get the portalRouting
        restPortalRoutingMockMvc.perform(get("/api/portal-routings/{id}", portalRouting.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(portalRouting.getId().intValue()))
            .andExpect(jsonPath("$.mucAppOwner").value(DEFAULT_MUC_APP_OWNER))
            .andExpect(jsonPath("$.mucAppId").value(DEFAULT_MUC_APP_ID))
            .andExpect(jsonPath("$.mucAppUrl").value(DEFAULT_MUC_APP_URL))
            .andExpect(jsonPath("$.mucAppName").value(DEFAULT_MUC_APP_NAME))
            .andExpect(jsonPath("$.mucAppNameEn").value(DEFAULT_MUC_APP_NAME_EN));
    }
    @Test
    @Transactional
    public void getNonExistingPortalRouting() throws Exception {
        // Get the portalRouting
        restPortalRoutingMockMvc.perform(get("/api/portal-routings/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePortalRouting() throws Exception {
        // Initialize the database
        portalRoutingService.save(portalRouting);

        int databaseSizeBeforeUpdate = portalRoutingRepository.findAll().size();

        // Update the portalRouting
        PortalRouting updatedPortalRouting = portalRoutingRepository.findById(portalRouting.getId()).get();
        // Disconnect from session so that the updates on updatedPortalRouting are not directly saved in db
        em.detach(updatedPortalRouting);
        updatedPortalRouting
            .mucAppOwner(UPDATED_MUC_APP_OWNER)
            .mucAppId(UPDATED_MUC_APP_ID)
            .mucAppUrl(UPDATED_MUC_APP_URL)
            .mucAppName(UPDATED_MUC_APP_NAME)
            .mucAppNameEn(UPDATED_MUC_APP_NAME_EN);

        restPortalRoutingMockMvc.perform(put("/api/portal-routings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedPortalRouting)))
            .andExpect(status().isOk());

        // Validate the PortalRouting in the database
        List<PortalRouting> portalRoutingList = portalRoutingRepository.findAll();
        assertThat(portalRoutingList).hasSize(databaseSizeBeforeUpdate);
        PortalRouting testPortalRouting = portalRoutingList.get(portalRoutingList.size() - 1);
        assertThat(testPortalRouting.getMucAppOwner()).isEqualTo(UPDATED_MUC_APP_OWNER);
        assertThat(testPortalRouting.getMucAppId()).isEqualTo(UPDATED_MUC_APP_ID);
        assertThat(testPortalRouting.getMucAppUrl()).isEqualTo(UPDATED_MUC_APP_URL);
        assertThat(testPortalRouting.getMucAppName()).isEqualTo(UPDATED_MUC_APP_NAME);
        assertThat(testPortalRouting.getMucAppNameEn()).isEqualTo(UPDATED_MUC_APP_NAME_EN);
    }

    @Test
    @Transactional
    public void updateNonExistingPortalRouting() throws Exception {
        int databaseSizeBeforeUpdate = portalRoutingRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPortalRoutingMockMvc.perform(put("/api/portal-routings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(portalRouting)))
            .andExpect(status().isBadRequest());

        // Validate the PortalRouting in the database
        List<PortalRouting> portalRoutingList = portalRoutingRepository.findAll();
        assertThat(portalRoutingList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePortalRouting() throws Exception {
        // Initialize the database
        portalRoutingService.save(portalRouting);

        int databaseSizeBeforeDelete = portalRoutingRepository.findAll().size();

        // Delete the portalRouting
        restPortalRoutingMockMvc.perform(delete("/api/portal-routings/{id}", portalRouting.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<PortalRouting> portalRoutingList = portalRoutingRepository.findAll();
        assertThat(portalRoutingList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
