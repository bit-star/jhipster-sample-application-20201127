package com.lazulite.mp.web.rest;

import com.lazulite.mp.JhipsterSampleApplication20201127App;
import com.lazulite.mp.domain.FmpWidgetInfo;
import com.lazulite.mp.repository.FmpWidgetInfoRepository;
import com.lazulite.mp.service.FmpWidgetInfoService;

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

import com.lazulite.mp.domain.enumeration.PassingForm;
import com.lazulite.mp.domain.enumeration.TopOption;
import com.lazulite.mp.domain.enumeration.WidgetContentType;
import com.lazulite.mp.domain.enumeration.WidgeType;
/**
 * Integration tests for the {@link FmpWidgetInfoResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplication20201127App.class)
@AutoConfigureMockMvc
@WithMockUser
public class FmpWidgetInfoResourceIT {

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PORTAL_ID = "AAAAAAAAAA";
    private static final String UPDATED_PORTAL_ID = "BBBBBBBBBB";

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_CAT_ID = "AAAAAAAAAA";
    private static final String UPDATED_CAT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_DATA_URL = "AAAAAAAAAA";
    private static final String UPDATED_DATA_URL = "BBBBBBBBBB";

    private static final String DEFAULT_SORT = "AAAAAAAAAA";
    private static final String UPDATED_SORT = "BBBBBBBBBB";

    private static final PassingForm DEFAULT_DATA_URL_PARAM = PassingForm.JobCode;
    private static final PassingForm UPDATED_DATA_URL_PARAM = PassingForm.Email;

    private static final TopOption DEFAULT_IS_TOP = TopOption.Top;
    private static final TopOption UPDATED_IS_TOP = TopOption.NotTop;

    private static final WidgetContentType DEFAULT_CONTENT_TYPE = WidgetContentType.List;
    private static final WidgetContentType UPDATED_CONTENT_TYPE = WidgetContentType.Image;

    private static final WidgeType DEFAULT_TYPE = WidgeType.OA;
    private static final WidgeType UPDATED_TYPE = WidgeType.Personal;

    private static final Boolean DEFAULT_IS_DELETED = false;
    private static final Boolean UPDATED_IS_DELETED = true;

    @Autowired
    private FmpWidgetInfoRepository fmpWidgetInfoRepository;

    @Autowired
    private FmpWidgetInfoService fmpWidgetInfoService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFmpWidgetInfoMockMvc;

    private FmpWidgetInfo fmpWidgetInfo;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FmpWidgetInfo createEntity(EntityManager em) {
        FmpWidgetInfo fmpWidgetInfo = new FmpWidgetInfo()
            .code(DEFAULT_CODE)
            .portalId(DEFAULT_PORTAL_ID)
            .title(DEFAULT_TITLE)
            .catId(DEFAULT_CAT_ID)
            .dataUrl(DEFAULT_DATA_URL)
            .sort(DEFAULT_SORT)
            .dataUrlParam(DEFAULT_DATA_URL_PARAM)
            .isTop(DEFAULT_IS_TOP)
            .contentType(DEFAULT_CONTENT_TYPE)
            .type(DEFAULT_TYPE)
            .isDeleted(DEFAULT_IS_DELETED);
        return fmpWidgetInfo;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FmpWidgetInfo createUpdatedEntity(EntityManager em) {
        FmpWidgetInfo fmpWidgetInfo = new FmpWidgetInfo()
            .code(UPDATED_CODE)
            .portalId(UPDATED_PORTAL_ID)
            .title(UPDATED_TITLE)
            .catId(UPDATED_CAT_ID)
            .dataUrl(UPDATED_DATA_URL)
            .sort(UPDATED_SORT)
            .dataUrlParam(UPDATED_DATA_URL_PARAM)
            .isTop(UPDATED_IS_TOP)
            .contentType(UPDATED_CONTENT_TYPE)
            .type(UPDATED_TYPE)
            .isDeleted(UPDATED_IS_DELETED);
        return fmpWidgetInfo;
    }

    @BeforeEach
    public void initTest() {
        fmpWidgetInfo = createEntity(em);
    }

    @Test
    @Transactional
    public void createFmpWidgetInfo() throws Exception {
        int databaseSizeBeforeCreate = fmpWidgetInfoRepository.findAll().size();
        // Create the FmpWidgetInfo
        restFmpWidgetInfoMockMvc.perform(post("/api/fmp-widget-infos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fmpWidgetInfo)))
            .andExpect(status().isCreated());

        // Validate the FmpWidgetInfo in the database
        List<FmpWidgetInfo> fmpWidgetInfoList = fmpWidgetInfoRepository.findAll();
        assertThat(fmpWidgetInfoList).hasSize(databaseSizeBeforeCreate + 1);
        FmpWidgetInfo testFmpWidgetInfo = fmpWidgetInfoList.get(fmpWidgetInfoList.size() - 1);
        assertThat(testFmpWidgetInfo.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testFmpWidgetInfo.getPortalId()).isEqualTo(DEFAULT_PORTAL_ID);
        assertThat(testFmpWidgetInfo.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testFmpWidgetInfo.getCatId()).isEqualTo(DEFAULT_CAT_ID);
        assertThat(testFmpWidgetInfo.getDataUrl()).isEqualTo(DEFAULT_DATA_URL);
        assertThat(testFmpWidgetInfo.getSort()).isEqualTo(DEFAULT_SORT);
        assertThat(testFmpWidgetInfo.getDataUrlParam()).isEqualTo(DEFAULT_DATA_URL_PARAM);
        assertThat(testFmpWidgetInfo.getIsTop()).isEqualTo(DEFAULT_IS_TOP);
        assertThat(testFmpWidgetInfo.getContentType()).isEqualTo(DEFAULT_CONTENT_TYPE);
        assertThat(testFmpWidgetInfo.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testFmpWidgetInfo.isIsDeleted()).isEqualTo(DEFAULT_IS_DELETED);
    }

    @Test
    @Transactional
    public void createFmpWidgetInfoWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = fmpWidgetInfoRepository.findAll().size();

        // Create the FmpWidgetInfo with an existing ID
        fmpWidgetInfo.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFmpWidgetInfoMockMvc.perform(post("/api/fmp-widget-infos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fmpWidgetInfo)))
            .andExpect(status().isBadRequest());

        // Validate the FmpWidgetInfo in the database
        List<FmpWidgetInfo> fmpWidgetInfoList = fmpWidgetInfoRepository.findAll();
        assertThat(fmpWidgetInfoList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllFmpWidgetInfos() throws Exception {
        // Initialize the database
        fmpWidgetInfoRepository.saveAndFlush(fmpWidgetInfo);

        // Get all the fmpWidgetInfoList
        restFmpWidgetInfoMockMvc.perform(get("/api/fmp-widget-infos?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(fmpWidgetInfo.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].portalId").value(hasItem(DEFAULT_PORTAL_ID)))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].catId").value(hasItem(DEFAULT_CAT_ID)))
            .andExpect(jsonPath("$.[*].dataUrl").value(hasItem(DEFAULT_DATA_URL)))
            .andExpect(jsonPath("$.[*].sort").value(hasItem(DEFAULT_SORT)))
            .andExpect(jsonPath("$.[*].dataUrlParam").value(hasItem(DEFAULT_DATA_URL_PARAM.toString())))
            .andExpect(jsonPath("$.[*].isTop").value(hasItem(DEFAULT_IS_TOP.toString())))
            .andExpect(jsonPath("$.[*].contentType").value(hasItem(DEFAULT_CONTENT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED.booleanValue())));
    }
    
    @Test
    @Transactional
    public void getFmpWidgetInfo() throws Exception {
        // Initialize the database
        fmpWidgetInfoRepository.saveAndFlush(fmpWidgetInfo);

        // Get the fmpWidgetInfo
        restFmpWidgetInfoMockMvc.perform(get("/api/fmp-widget-infos/{id}", fmpWidgetInfo.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(fmpWidgetInfo.getId().intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.portalId").value(DEFAULT_PORTAL_ID))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.catId").value(DEFAULT_CAT_ID))
            .andExpect(jsonPath("$.dataUrl").value(DEFAULT_DATA_URL))
            .andExpect(jsonPath("$.sort").value(DEFAULT_SORT))
            .andExpect(jsonPath("$.dataUrlParam").value(DEFAULT_DATA_URL_PARAM.toString()))
            .andExpect(jsonPath("$.isTop").value(DEFAULT_IS_TOP.toString()))
            .andExpect(jsonPath("$.contentType").value(DEFAULT_CONTENT_TYPE.toString()))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED.booleanValue()));
    }
    @Test
    @Transactional
    public void getNonExistingFmpWidgetInfo() throws Exception {
        // Get the fmpWidgetInfo
        restFmpWidgetInfoMockMvc.perform(get("/api/fmp-widget-infos/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFmpWidgetInfo() throws Exception {
        // Initialize the database
        fmpWidgetInfoService.save(fmpWidgetInfo);

        int databaseSizeBeforeUpdate = fmpWidgetInfoRepository.findAll().size();

        // Update the fmpWidgetInfo
        FmpWidgetInfo updatedFmpWidgetInfo = fmpWidgetInfoRepository.findById(fmpWidgetInfo.getId()).get();
        // Disconnect from session so that the updates on updatedFmpWidgetInfo are not directly saved in db
        em.detach(updatedFmpWidgetInfo);
        updatedFmpWidgetInfo
            .code(UPDATED_CODE)
            .portalId(UPDATED_PORTAL_ID)
            .title(UPDATED_TITLE)
            .catId(UPDATED_CAT_ID)
            .dataUrl(UPDATED_DATA_URL)
            .sort(UPDATED_SORT)
            .dataUrlParam(UPDATED_DATA_URL_PARAM)
            .isTop(UPDATED_IS_TOP)
            .contentType(UPDATED_CONTENT_TYPE)
            .type(UPDATED_TYPE)
            .isDeleted(UPDATED_IS_DELETED);

        restFmpWidgetInfoMockMvc.perform(put("/api/fmp-widget-infos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedFmpWidgetInfo)))
            .andExpect(status().isOk());

        // Validate the FmpWidgetInfo in the database
        List<FmpWidgetInfo> fmpWidgetInfoList = fmpWidgetInfoRepository.findAll();
        assertThat(fmpWidgetInfoList).hasSize(databaseSizeBeforeUpdate);
        FmpWidgetInfo testFmpWidgetInfo = fmpWidgetInfoList.get(fmpWidgetInfoList.size() - 1);
        assertThat(testFmpWidgetInfo.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testFmpWidgetInfo.getPortalId()).isEqualTo(UPDATED_PORTAL_ID);
        assertThat(testFmpWidgetInfo.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testFmpWidgetInfo.getCatId()).isEqualTo(UPDATED_CAT_ID);
        assertThat(testFmpWidgetInfo.getDataUrl()).isEqualTo(UPDATED_DATA_URL);
        assertThat(testFmpWidgetInfo.getSort()).isEqualTo(UPDATED_SORT);
        assertThat(testFmpWidgetInfo.getDataUrlParam()).isEqualTo(UPDATED_DATA_URL_PARAM);
        assertThat(testFmpWidgetInfo.getIsTop()).isEqualTo(UPDATED_IS_TOP);
        assertThat(testFmpWidgetInfo.getContentType()).isEqualTo(UPDATED_CONTENT_TYPE);
        assertThat(testFmpWidgetInfo.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testFmpWidgetInfo.isIsDeleted()).isEqualTo(UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    public void updateNonExistingFmpWidgetInfo() throws Exception {
        int databaseSizeBeforeUpdate = fmpWidgetInfoRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFmpWidgetInfoMockMvc.perform(put("/api/fmp-widget-infos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fmpWidgetInfo)))
            .andExpect(status().isBadRequest());

        // Validate the FmpWidgetInfo in the database
        List<FmpWidgetInfo> fmpWidgetInfoList = fmpWidgetInfoRepository.findAll();
        assertThat(fmpWidgetInfoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteFmpWidgetInfo() throws Exception {
        // Initialize the database
        fmpWidgetInfoService.save(fmpWidgetInfo);

        int databaseSizeBeforeDelete = fmpWidgetInfoRepository.findAll().size();

        // Delete the fmpWidgetInfo
        restFmpWidgetInfoMockMvc.perform(delete("/api/fmp-widget-infos/{id}", fmpWidgetInfo.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<FmpWidgetInfo> fmpWidgetInfoList = fmpWidgetInfoRepository.findAll();
        assertThat(fmpWidgetInfoList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
