package com.lazulite.mp.web.rest;

import com.lazulite.mp.JhipsterSampleApplication20201127App;
import com.lazulite.mp.domain.FmpSubCompany;
import com.lazulite.mp.repository.FmpSubCompanyRepository;
import com.lazulite.mp.service.FmpSubCompanyService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link FmpSubCompanyResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplication20201127App.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
public class FmpSubCompanyResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ADMIN_GROUP_ID = "AAAAAAAAAA";
    private static final String UPDATED_ADMIN_GROUP_ID = "BBBBBBBBBB";

    private static final String DEFAULT_IF_PUBLIC = "AAAAAAAAAA";
    private static final String UPDATED_IF_PUBLIC = "BBBBBBBBBB";

    private static final String DEFAULT_STYLE_ID = "AAAAAAAAAA";
    private static final String UPDATED_STYLE_ID = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_DELETED = false;
    private static final Boolean UPDATED_IS_DELETED = true;

    @Autowired
    private FmpSubCompanyRepository fmpSubCompanyRepository;

    @Mock
    private FmpSubCompanyRepository fmpSubCompanyRepositoryMock;

    @Mock
    private FmpSubCompanyService fmpSubCompanyServiceMock;

    @Autowired
    private FmpSubCompanyService fmpSubCompanyService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFmpSubCompanyMockMvc;

    private FmpSubCompany fmpSubCompany;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FmpSubCompany createEntity(EntityManager em) {
        FmpSubCompany fmpSubCompany = new FmpSubCompany()
            .name(DEFAULT_NAME)
            .code(DEFAULT_CODE)
            .adminGroupId(DEFAULT_ADMIN_GROUP_ID)
            .ifPublic(DEFAULT_IF_PUBLIC)
            .styleId(DEFAULT_STYLE_ID)
            .isDeleted(DEFAULT_IS_DELETED);
        return fmpSubCompany;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FmpSubCompany createUpdatedEntity(EntityManager em) {
        FmpSubCompany fmpSubCompany = new FmpSubCompany()
            .name(UPDATED_NAME)
            .code(UPDATED_CODE)
            .adminGroupId(UPDATED_ADMIN_GROUP_ID)
            .ifPublic(UPDATED_IF_PUBLIC)
            .styleId(UPDATED_STYLE_ID)
            .isDeleted(UPDATED_IS_DELETED);
        return fmpSubCompany;
    }

    @BeforeEach
    public void initTest() {
        fmpSubCompany = createEntity(em);
    }

    @Test
    @Transactional
    public void createFmpSubCompany() throws Exception {
        int databaseSizeBeforeCreate = fmpSubCompanyRepository.findAll().size();
        // Create the FmpSubCompany
        restFmpSubCompanyMockMvc.perform(post("/api/fmp-sub-companies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fmpSubCompany)))
            .andExpect(status().isCreated());

        // Validate the FmpSubCompany in the database
        List<FmpSubCompany> fmpSubCompanyList = fmpSubCompanyRepository.findAll();
        assertThat(fmpSubCompanyList).hasSize(databaseSizeBeforeCreate + 1);
        FmpSubCompany testFmpSubCompany = fmpSubCompanyList.get(fmpSubCompanyList.size() - 1);
        assertThat(testFmpSubCompany.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testFmpSubCompany.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testFmpSubCompany.getAdminGroupId()).isEqualTo(DEFAULT_ADMIN_GROUP_ID);
        assertThat(testFmpSubCompany.getIfPublic()).isEqualTo(DEFAULT_IF_PUBLIC);
        assertThat(testFmpSubCompany.getStyleId()).isEqualTo(DEFAULT_STYLE_ID);
        assertThat(testFmpSubCompany.isIsDeleted()).isEqualTo(DEFAULT_IS_DELETED);
    }

    @Test
    @Transactional
    public void createFmpSubCompanyWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = fmpSubCompanyRepository.findAll().size();

        // Create the FmpSubCompany with an existing ID
        fmpSubCompany.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFmpSubCompanyMockMvc.perform(post("/api/fmp-sub-companies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fmpSubCompany)))
            .andExpect(status().isBadRequest());

        // Validate the FmpSubCompany in the database
        List<FmpSubCompany> fmpSubCompanyList = fmpSubCompanyRepository.findAll();
        assertThat(fmpSubCompanyList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllFmpSubCompanies() throws Exception {
        // Initialize the database
        fmpSubCompanyRepository.saveAndFlush(fmpSubCompany);

        // Get all the fmpSubCompanyList
        restFmpSubCompanyMockMvc.perform(get("/api/fmp-sub-companies?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(fmpSubCompany.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].adminGroupId").value(hasItem(DEFAULT_ADMIN_GROUP_ID)))
            .andExpect(jsonPath("$.[*].ifPublic").value(hasItem(DEFAULT_IF_PUBLIC)))
            .andExpect(jsonPath("$.[*].styleId").value(hasItem(DEFAULT_STYLE_ID)))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED.booleanValue())));
    }
    
    @SuppressWarnings({"unchecked"})
    public void getAllFmpSubCompaniesWithEagerRelationshipsIsEnabled() throws Exception {
        when(fmpSubCompanyServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restFmpSubCompanyMockMvc.perform(get("/api/fmp-sub-companies?eagerload=true"))
            .andExpect(status().isOk());

        verify(fmpSubCompanyServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    @SuppressWarnings({"unchecked"})
    public void getAllFmpSubCompaniesWithEagerRelationshipsIsNotEnabled() throws Exception {
        when(fmpSubCompanyServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restFmpSubCompanyMockMvc.perform(get("/api/fmp-sub-companies?eagerload=true"))
            .andExpect(status().isOk());

        verify(fmpSubCompanyServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    @Test
    @Transactional
    public void getFmpSubCompany() throws Exception {
        // Initialize the database
        fmpSubCompanyRepository.saveAndFlush(fmpSubCompany);

        // Get the fmpSubCompany
        restFmpSubCompanyMockMvc.perform(get("/api/fmp-sub-companies/{id}", fmpSubCompany.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(fmpSubCompany.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.adminGroupId").value(DEFAULT_ADMIN_GROUP_ID))
            .andExpect(jsonPath("$.ifPublic").value(DEFAULT_IF_PUBLIC))
            .andExpect(jsonPath("$.styleId").value(DEFAULT_STYLE_ID))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED.booleanValue()));
    }
    @Test
    @Transactional
    public void getNonExistingFmpSubCompany() throws Exception {
        // Get the fmpSubCompany
        restFmpSubCompanyMockMvc.perform(get("/api/fmp-sub-companies/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFmpSubCompany() throws Exception {
        // Initialize the database
        fmpSubCompanyService.save(fmpSubCompany);

        int databaseSizeBeforeUpdate = fmpSubCompanyRepository.findAll().size();

        // Update the fmpSubCompany
        FmpSubCompany updatedFmpSubCompany = fmpSubCompanyRepository.findById(fmpSubCompany.getId()).get();
        // Disconnect from session so that the updates on updatedFmpSubCompany are not directly saved in db
        em.detach(updatedFmpSubCompany);
        updatedFmpSubCompany
            .name(UPDATED_NAME)
            .code(UPDATED_CODE)
            .adminGroupId(UPDATED_ADMIN_GROUP_ID)
            .ifPublic(UPDATED_IF_PUBLIC)
            .styleId(UPDATED_STYLE_ID)
            .isDeleted(UPDATED_IS_DELETED);

        restFmpSubCompanyMockMvc.perform(put("/api/fmp-sub-companies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedFmpSubCompany)))
            .andExpect(status().isOk());

        // Validate the FmpSubCompany in the database
        List<FmpSubCompany> fmpSubCompanyList = fmpSubCompanyRepository.findAll();
        assertThat(fmpSubCompanyList).hasSize(databaseSizeBeforeUpdate);
        FmpSubCompany testFmpSubCompany = fmpSubCompanyList.get(fmpSubCompanyList.size() - 1);
        assertThat(testFmpSubCompany.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testFmpSubCompany.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testFmpSubCompany.getAdminGroupId()).isEqualTo(UPDATED_ADMIN_GROUP_ID);
        assertThat(testFmpSubCompany.getIfPublic()).isEqualTo(UPDATED_IF_PUBLIC);
        assertThat(testFmpSubCompany.getStyleId()).isEqualTo(UPDATED_STYLE_ID);
        assertThat(testFmpSubCompany.isIsDeleted()).isEqualTo(UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    public void updateNonExistingFmpSubCompany() throws Exception {
        int databaseSizeBeforeUpdate = fmpSubCompanyRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFmpSubCompanyMockMvc.perform(put("/api/fmp-sub-companies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fmpSubCompany)))
            .andExpect(status().isBadRequest());

        // Validate the FmpSubCompany in the database
        List<FmpSubCompany> fmpSubCompanyList = fmpSubCompanyRepository.findAll();
        assertThat(fmpSubCompanyList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteFmpSubCompany() throws Exception {
        // Initialize the database
        fmpSubCompanyService.save(fmpSubCompany);

        int databaseSizeBeforeDelete = fmpSubCompanyRepository.findAll().size();

        // Delete the fmpSubCompany
        restFmpSubCompanyMockMvc.perform(delete("/api/fmp-sub-companies/{id}", fmpSubCompany.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<FmpSubCompany> fmpSubCompanyList = fmpSubCompanyRepository.findAll();
        assertThat(fmpSubCompanyList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
