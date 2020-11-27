package com.lazulite.mp.web.rest;

import com.lazulite.mp.JhipsterSampleApplication20201127App;
import com.lazulite.mp.domain.UucDepartmentTree;
import com.lazulite.mp.domain.MicroAppGroup;
import com.lazulite.mp.domain.FmpMicroApp;
import com.lazulite.mp.domain.ManagerUser;
import com.lazulite.mp.domain.FmpSubCompany;
import com.lazulite.mp.repository.UucDepartmentTreeRepository;
import com.lazulite.mp.service.UucDepartmentTreeService;
import com.lazulite.mp.service.dto.UucDepartmentTreeCriteria;
import com.lazulite.mp.service.UucDepartmentTreeQueryService;

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
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link UucDepartmentTreeResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplication20201127App.class)
@AutoConfigureMockMvc
@WithMockUser
public class UucDepartmentTreeResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_PY = "AAAAAAAAAA";
    private static final String UPDATED_NAME_PY = "BBBBBBBBBB";

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PARENT_DEP_ID = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_DEP_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PARENT_DEP_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_DEP_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_DISPORDER = "AAAAAAAAAA";
    private static final String UPDATED_DISPORDER = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_PATH = "AAAAAAAAAA";
    private static final String UPDATED_NAME_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_PATH = "AAAAAAAAAA";
    private static final String UPDATED_CODE_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_DEP_ID_PATH = "AAAAAAAAAA";
    private static final String UPDATED_DEP_ID_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_DEP_LEVEL = "AAAAAAAAAA";
    private static final String UPDATED_DEP_LEVEL = "BBBBBBBBBB";

    private static final String DEFAULT_ALIVE_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_ALIVE_FLAG = "BBBBBBBBBB";

    private static final Instant DEFAULT_REC_CREATE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_REC_CREATE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_REC_CREATOR = "AAAAAAAAAA";
    private static final String UPDATED_REC_CREATOR = "BBBBBBBBBB";

    private static final Instant DEFAULT_REC_REVISE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_REC_REVISE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_REC_REVISOR = "AAAAAAAAAA";
    private static final String UPDATED_REC_REVISOR = "BBBBBBBBBB";

    private static final String DEFAULT_DEPT_USER_COUNT = "AAAAAAAAAA";
    private static final String UPDATED_DEPT_USER_COUNT = "BBBBBBBBBB";

    private static final String DEFAULT_MICROAPP_ID = "AAAAAAAAAA";
    private static final String UPDATED_MICROAPP_ID = "BBBBBBBBBB";

    private static final String DEFAULT_EN_NAME = "AAAAAAAAAA";
    private static final String UPDATED_EN_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ONLY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ONLY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SRC_DEPT_ID = "AAAAAAAAAA";
    private static final String UPDATED_SRC_DEPT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_SRC_DEPT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_SRC_DEPT_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SRC_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_SRC_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SRC_DEPT_UCODE = "AAAAAAAAAA";
    private static final String UPDATED_SRC_DEPT_UCODE = "BBBBBBBBBB";

    @Autowired
    private UucDepartmentTreeRepository uucDepartmentTreeRepository;

    @Autowired
    private UucDepartmentTreeService uucDepartmentTreeService;

    @Autowired
    private UucDepartmentTreeQueryService uucDepartmentTreeQueryService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restUucDepartmentTreeMockMvc;

    private UucDepartmentTree uucDepartmentTree;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UucDepartmentTree createEntity(EntityManager em) {
        UucDepartmentTree uucDepartmentTree = new UucDepartmentTree()
            .name(DEFAULT_NAME)
            .namePy(DEFAULT_NAME_PY)
            .code(DEFAULT_CODE)
            .parentDepId(DEFAULT_PARENT_DEP_ID)
            .parentDepName(DEFAULT_PARENT_DEP_NAME)
            .status(DEFAULT_STATUS)
            .disporder(DEFAULT_DISPORDER)
            .namePath(DEFAULT_NAME_PATH)
            .codePath(DEFAULT_CODE_PATH)
            .depIdPath(DEFAULT_DEP_ID_PATH)
            .depLevel(DEFAULT_DEP_LEVEL)
            .aliveFlag(DEFAULT_ALIVE_FLAG)
            .recCreateTime(DEFAULT_REC_CREATE_TIME)
            .recCreator(DEFAULT_REC_CREATOR)
            .recReviseTime(DEFAULT_REC_REVISE_TIME)
            .recRevisor(DEFAULT_REC_REVISOR)
            .deptUserCount(DEFAULT_DEPT_USER_COUNT)
            .microappId(DEFAULT_MICROAPP_ID)
            .enName(DEFAULT_EN_NAME)
            .onlyCode(DEFAULT_ONLY_CODE)
            .srcDeptId(DEFAULT_SRC_DEPT_ID)
            .srcDeptType(DEFAULT_SRC_DEPT_TYPE)
            .srcType(DEFAULT_SRC_TYPE)
            .srcDeptUcode(DEFAULT_SRC_DEPT_UCODE);
        return uucDepartmentTree;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UucDepartmentTree createUpdatedEntity(EntityManager em) {
        UucDepartmentTree uucDepartmentTree = new UucDepartmentTree()
            .name(UPDATED_NAME)
            .namePy(UPDATED_NAME_PY)
            .code(UPDATED_CODE)
            .parentDepId(UPDATED_PARENT_DEP_ID)
            .parentDepName(UPDATED_PARENT_DEP_NAME)
            .status(UPDATED_STATUS)
            .disporder(UPDATED_DISPORDER)
            .namePath(UPDATED_NAME_PATH)
            .codePath(UPDATED_CODE_PATH)
            .depIdPath(UPDATED_DEP_ID_PATH)
            .depLevel(UPDATED_DEP_LEVEL)
            .aliveFlag(UPDATED_ALIVE_FLAG)
            .recCreateTime(UPDATED_REC_CREATE_TIME)
            .recCreator(UPDATED_REC_CREATOR)
            .recReviseTime(UPDATED_REC_REVISE_TIME)
            .recRevisor(UPDATED_REC_REVISOR)
            .deptUserCount(UPDATED_DEPT_USER_COUNT)
            .microappId(UPDATED_MICROAPP_ID)
            .enName(UPDATED_EN_NAME)
            .onlyCode(UPDATED_ONLY_CODE)
            .srcDeptId(UPDATED_SRC_DEPT_ID)
            .srcDeptType(UPDATED_SRC_DEPT_TYPE)
            .srcType(UPDATED_SRC_TYPE)
            .srcDeptUcode(UPDATED_SRC_DEPT_UCODE);
        return uucDepartmentTree;
    }

    @BeforeEach
    public void initTest() {
        uucDepartmentTree = createEntity(em);
    }

    @Test
    @Transactional
    public void createUucDepartmentTree() throws Exception {
        int databaseSizeBeforeCreate = uucDepartmentTreeRepository.findAll().size();
        // Create the UucDepartmentTree
        restUucDepartmentTreeMockMvc.perform(post("/api/uuc-department-trees")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(uucDepartmentTree)))
            .andExpect(status().isCreated());

        // Validate the UucDepartmentTree in the database
        List<UucDepartmentTree> uucDepartmentTreeList = uucDepartmentTreeRepository.findAll();
        assertThat(uucDepartmentTreeList).hasSize(databaseSizeBeforeCreate + 1);
        UucDepartmentTree testUucDepartmentTree = uucDepartmentTreeList.get(uucDepartmentTreeList.size() - 1);
        assertThat(testUucDepartmentTree.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testUucDepartmentTree.getNamePy()).isEqualTo(DEFAULT_NAME_PY);
        assertThat(testUucDepartmentTree.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testUucDepartmentTree.getParentDepId()).isEqualTo(DEFAULT_PARENT_DEP_ID);
        assertThat(testUucDepartmentTree.getParentDepName()).isEqualTo(DEFAULT_PARENT_DEP_NAME);
        assertThat(testUucDepartmentTree.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testUucDepartmentTree.getDisporder()).isEqualTo(DEFAULT_DISPORDER);
        assertThat(testUucDepartmentTree.getNamePath()).isEqualTo(DEFAULT_NAME_PATH);
        assertThat(testUucDepartmentTree.getCodePath()).isEqualTo(DEFAULT_CODE_PATH);
        assertThat(testUucDepartmentTree.getDepIdPath()).isEqualTo(DEFAULT_DEP_ID_PATH);
        assertThat(testUucDepartmentTree.getDepLevel()).isEqualTo(DEFAULT_DEP_LEVEL);
        assertThat(testUucDepartmentTree.getAliveFlag()).isEqualTo(DEFAULT_ALIVE_FLAG);
        assertThat(testUucDepartmentTree.getRecCreateTime()).isEqualTo(DEFAULT_REC_CREATE_TIME);
        assertThat(testUucDepartmentTree.getRecCreator()).isEqualTo(DEFAULT_REC_CREATOR);
        assertThat(testUucDepartmentTree.getRecReviseTime()).isEqualTo(DEFAULT_REC_REVISE_TIME);
        assertThat(testUucDepartmentTree.getRecRevisor()).isEqualTo(DEFAULT_REC_REVISOR);
        assertThat(testUucDepartmentTree.getDeptUserCount()).isEqualTo(DEFAULT_DEPT_USER_COUNT);
        assertThat(testUucDepartmentTree.getMicroappId()).isEqualTo(DEFAULT_MICROAPP_ID);
        assertThat(testUucDepartmentTree.getEnName()).isEqualTo(DEFAULT_EN_NAME);
        assertThat(testUucDepartmentTree.getOnlyCode()).isEqualTo(DEFAULT_ONLY_CODE);
        assertThat(testUucDepartmentTree.getSrcDeptId()).isEqualTo(DEFAULT_SRC_DEPT_ID);
        assertThat(testUucDepartmentTree.getSrcDeptType()).isEqualTo(DEFAULT_SRC_DEPT_TYPE);
        assertThat(testUucDepartmentTree.getSrcType()).isEqualTo(DEFAULT_SRC_TYPE);
        assertThat(testUucDepartmentTree.getSrcDeptUcode()).isEqualTo(DEFAULT_SRC_DEPT_UCODE);
    }

    @Test
    @Transactional
    public void createUucDepartmentTreeWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = uucDepartmentTreeRepository.findAll().size();

        // Create the UucDepartmentTree with an existing ID
        uucDepartmentTree.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restUucDepartmentTreeMockMvc.perform(post("/api/uuc-department-trees")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(uucDepartmentTree)))
            .andExpect(status().isBadRequest());

        // Validate the UucDepartmentTree in the database
        List<UucDepartmentTree> uucDepartmentTreeList = uucDepartmentTreeRepository.findAll();
        assertThat(uucDepartmentTreeList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTrees() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList
        restUucDepartmentTreeMockMvc.perform(get("/api/uuc-department-trees?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(uucDepartmentTree.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].namePy").value(hasItem(DEFAULT_NAME_PY)))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].parentDepId").value(hasItem(DEFAULT_PARENT_DEP_ID)))
            .andExpect(jsonPath("$.[*].parentDepName").value(hasItem(DEFAULT_PARENT_DEP_NAME)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].disporder").value(hasItem(DEFAULT_DISPORDER)))
            .andExpect(jsonPath("$.[*].namePath").value(hasItem(DEFAULT_NAME_PATH)))
            .andExpect(jsonPath("$.[*].codePath").value(hasItem(DEFAULT_CODE_PATH)))
            .andExpect(jsonPath("$.[*].depIdPath").value(hasItem(DEFAULT_DEP_ID_PATH)))
            .andExpect(jsonPath("$.[*].depLevel").value(hasItem(DEFAULT_DEP_LEVEL)))
            .andExpect(jsonPath("$.[*].aliveFlag").value(hasItem(DEFAULT_ALIVE_FLAG)))
            .andExpect(jsonPath("$.[*].recCreateTime").value(hasItem(DEFAULT_REC_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].recCreator").value(hasItem(DEFAULT_REC_CREATOR)))
            .andExpect(jsonPath("$.[*].recReviseTime").value(hasItem(DEFAULT_REC_REVISE_TIME.toString())))
            .andExpect(jsonPath("$.[*].recRevisor").value(hasItem(DEFAULT_REC_REVISOR)))
            .andExpect(jsonPath("$.[*].deptUserCount").value(hasItem(DEFAULT_DEPT_USER_COUNT)))
            .andExpect(jsonPath("$.[*].microappId").value(hasItem(DEFAULT_MICROAPP_ID)))
            .andExpect(jsonPath("$.[*].enName").value(hasItem(DEFAULT_EN_NAME)))
            .andExpect(jsonPath("$.[*].onlyCode").value(hasItem(DEFAULT_ONLY_CODE)))
            .andExpect(jsonPath("$.[*].srcDeptId").value(hasItem(DEFAULT_SRC_DEPT_ID)))
            .andExpect(jsonPath("$.[*].srcDeptType").value(hasItem(DEFAULT_SRC_DEPT_TYPE)))
            .andExpect(jsonPath("$.[*].srcType").value(hasItem(DEFAULT_SRC_TYPE)))
            .andExpect(jsonPath("$.[*].srcDeptUcode").value(hasItem(DEFAULT_SRC_DEPT_UCODE)));
    }
    
    @Test
    @Transactional
    public void getUucDepartmentTree() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get the uucDepartmentTree
        restUucDepartmentTreeMockMvc.perform(get("/api/uuc-department-trees/{id}", uucDepartmentTree.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(uucDepartmentTree.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.namePy").value(DEFAULT_NAME_PY))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.parentDepId").value(DEFAULT_PARENT_DEP_ID))
            .andExpect(jsonPath("$.parentDepName").value(DEFAULT_PARENT_DEP_NAME))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.disporder").value(DEFAULT_DISPORDER))
            .andExpect(jsonPath("$.namePath").value(DEFAULT_NAME_PATH))
            .andExpect(jsonPath("$.codePath").value(DEFAULT_CODE_PATH))
            .andExpect(jsonPath("$.depIdPath").value(DEFAULT_DEP_ID_PATH))
            .andExpect(jsonPath("$.depLevel").value(DEFAULT_DEP_LEVEL))
            .andExpect(jsonPath("$.aliveFlag").value(DEFAULT_ALIVE_FLAG))
            .andExpect(jsonPath("$.recCreateTime").value(DEFAULT_REC_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.recCreator").value(DEFAULT_REC_CREATOR))
            .andExpect(jsonPath("$.recReviseTime").value(DEFAULT_REC_REVISE_TIME.toString()))
            .andExpect(jsonPath("$.recRevisor").value(DEFAULT_REC_REVISOR))
            .andExpect(jsonPath("$.deptUserCount").value(DEFAULT_DEPT_USER_COUNT))
            .andExpect(jsonPath("$.microappId").value(DEFAULT_MICROAPP_ID))
            .andExpect(jsonPath("$.enName").value(DEFAULT_EN_NAME))
            .andExpect(jsonPath("$.onlyCode").value(DEFAULT_ONLY_CODE))
            .andExpect(jsonPath("$.srcDeptId").value(DEFAULT_SRC_DEPT_ID))
            .andExpect(jsonPath("$.srcDeptType").value(DEFAULT_SRC_DEPT_TYPE))
            .andExpect(jsonPath("$.srcType").value(DEFAULT_SRC_TYPE))
            .andExpect(jsonPath("$.srcDeptUcode").value(DEFAULT_SRC_DEPT_UCODE));
    }


    @Test
    @Transactional
    public void getUucDepartmentTreesByIdFiltering() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        Long id = uucDepartmentTree.getId();

        defaultUucDepartmentTreeShouldBeFound("id.equals=" + id);
        defaultUucDepartmentTreeShouldNotBeFound("id.notEquals=" + id);

        defaultUucDepartmentTreeShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultUucDepartmentTreeShouldNotBeFound("id.greaterThan=" + id);

        defaultUucDepartmentTreeShouldBeFound("id.lessThanOrEqual=" + id);
        defaultUucDepartmentTreeShouldNotBeFound("id.lessThan=" + id);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNameIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where name equals to DEFAULT_NAME
        defaultUucDepartmentTreeShouldBeFound("name.equals=" + DEFAULT_NAME);

        // Get all the uucDepartmentTreeList where name equals to UPDATED_NAME
        defaultUucDepartmentTreeShouldNotBeFound("name.equals=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNameIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where name not equals to DEFAULT_NAME
        defaultUucDepartmentTreeShouldNotBeFound("name.notEquals=" + DEFAULT_NAME);

        // Get all the uucDepartmentTreeList where name not equals to UPDATED_NAME
        defaultUucDepartmentTreeShouldBeFound("name.notEquals=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNameIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where name in DEFAULT_NAME or UPDATED_NAME
        defaultUucDepartmentTreeShouldBeFound("name.in=" + DEFAULT_NAME + "," + UPDATED_NAME);

        // Get all the uucDepartmentTreeList where name equals to UPDATED_NAME
        defaultUucDepartmentTreeShouldNotBeFound("name.in=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where name is not null
        defaultUucDepartmentTreeShouldBeFound("name.specified=true");

        // Get all the uucDepartmentTreeList where name is null
        defaultUucDepartmentTreeShouldNotBeFound("name.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByNameContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where name contains DEFAULT_NAME
        defaultUucDepartmentTreeShouldBeFound("name.contains=" + DEFAULT_NAME);

        // Get all the uucDepartmentTreeList where name contains UPDATED_NAME
        defaultUucDepartmentTreeShouldNotBeFound("name.contains=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNameNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where name does not contain DEFAULT_NAME
        defaultUucDepartmentTreeShouldNotBeFound("name.doesNotContain=" + DEFAULT_NAME);

        // Get all the uucDepartmentTreeList where name does not contain UPDATED_NAME
        defaultUucDepartmentTreeShouldBeFound("name.doesNotContain=" + UPDATED_NAME);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNamePyIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where namePy equals to DEFAULT_NAME_PY
        defaultUucDepartmentTreeShouldBeFound("namePy.equals=" + DEFAULT_NAME_PY);

        // Get all the uucDepartmentTreeList where namePy equals to UPDATED_NAME_PY
        defaultUucDepartmentTreeShouldNotBeFound("namePy.equals=" + UPDATED_NAME_PY);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNamePyIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where namePy not equals to DEFAULT_NAME_PY
        defaultUucDepartmentTreeShouldNotBeFound("namePy.notEquals=" + DEFAULT_NAME_PY);

        // Get all the uucDepartmentTreeList where namePy not equals to UPDATED_NAME_PY
        defaultUucDepartmentTreeShouldBeFound("namePy.notEquals=" + UPDATED_NAME_PY);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNamePyIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where namePy in DEFAULT_NAME_PY or UPDATED_NAME_PY
        defaultUucDepartmentTreeShouldBeFound("namePy.in=" + DEFAULT_NAME_PY + "," + UPDATED_NAME_PY);

        // Get all the uucDepartmentTreeList where namePy equals to UPDATED_NAME_PY
        defaultUucDepartmentTreeShouldNotBeFound("namePy.in=" + UPDATED_NAME_PY);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNamePyIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where namePy is not null
        defaultUucDepartmentTreeShouldBeFound("namePy.specified=true");

        // Get all the uucDepartmentTreeList where namePy is null
        defaultUucDepartmentTreeShouldNotBeFound("namePy.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByNamePyContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where namePy contains DEFAULT_NAME_PY
        defaultUucDepartmentTreeShouldBeFound("namePy.contains=" + DEFAULT_NAME_PY);

        // Get all the uucDepartmentTreeList where namePy contains UPDATED_NAME_PY
        defaultUucDepartmentTreeShouldNotBeFound("namePy.contains=" + UPDATED_NAME_PY);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNamePyNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where namePy does not contain DEFAULT_NAME_PY
        defaultUucDepartmentTreeShouldNotBeFound("namePy.doesNotContain=" + DEFAULT_NAME_PY);

        // Get all the uucDepartmentTreeList where namePy does not contain UPDATED_NAME_PY
        defaultUucDepartmentTreeShouldBeFound("namePy.doesNotContain=" + UPDATED_NAME_PY);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where code equals to DEFAULT_CODE
        defaultUucDepartmentTreeShouldBeFound("code.equals=" + DEFAULT_CODE);

        // Get all the uucDepartmentTreeList where code equals to UPDATED_CODE
        defaultUucDepartmentTreeShouldNotBeFound("code.equals=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByCodeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where code not equals to DEFAULT_CODE
        defaultUucDepartmentTreeShouldNotBeFound("code.notEquals=" + DEFAULT_CODE);

        // Get all the uucDepartmentTreeList where code not equals to UPDATED_CODE
        defaultUucDepartmentTreeShouldBeFound("code.notEquals=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByCodeIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where code in DEFAULT_CODE or UPDATED_CODE
        defaultUucDepartmentTreeShouldBeFound("code.in=" + DEFAULT_CODE + "," + UPDATED_CODE);

        // Get all the uucDepartmentTreeList where code equals to UPDATED_CODE
        defaultUucDepartmentTreeShouldNotBeFound("code.in=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where code is not null
        defaultUucDepartmentTreeShouldBeFound("code.specified=true");

        // Get all the uucDepartmentTreeList where code is null
        defaultUucDepartmentTreeShouldNotBeFound("code.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByCodeContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where code contains DEFAULT_CODE
        defaultUucDepartmentTreeShouldBeFound("code.contains=" + DEFAULT_CODE);

        // Get all the uucDepartmentTreeList where code contains UPDATED_CODE
        defaultUucDepartmentTreeShouldNotBeFound("code.contains=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByCodeNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where code does not contain DEFAULT_CODE
        defaultUucDepartmentTreeShouldNotBeFound("code.doesNotContain=" + DEFAULT_CODE);

        // Get all the uucDepartmentTreeList where code does not contain UPDATED_CODE
        defaultUucDepartmentTreeShouldBeFound("code.doesNotContain=" + UPDATED_CODE);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByParentDepIdIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where parentDepId equals to DEFAULT_PARENT_DEP_ID
        defaultUucDepartmentTreeShouldBeFound("parentDepId.equals=" + DEFAULT_PARENT_DEP_ID);

        // Get all the uucDepartmentTreeList where parentDepId equals to UPDATED_PARENT_DEP_ID
        defaultUucDepartmentTreeShouldNotBeFound("parentDepId.equals=" + UPDATED_PARENT_DEP_ID);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByParentDepIdIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where parentDepId not equals to DEFAULT_PARENT_DEP_ID
        defaultUucDepartmentTreeShouldNotBeFound("parentDepId.notEquals=" + DEFAULT_PARENT_DEP_ID);

        // Get all the uucDepartmentTreeList where parentDepId not equals to UPDATED_PARENT_DEP_ID
        defaultUucDepartmentTreeShouldBeFound("parentDepId.notEquals=" + UPDATED_PARENT_DEP_ID);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByParentDepIdIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where parentDepId in DEFAULT_PARENT_DEP_ID or UPDATED_PARENT_DEP_ID
        defaultUucDepartmentTreeShouldBeFound("parentDepId.in=" + DEFAULT_PARENT_DEP_ID + "," + UPDATED_PARENT_DEP_ID);

        // Get all the uucDepartmentTreeList where parentDepId equals to UPDATED_PARENT_DEP_ID
        defaultUucDepartmentTreeShouldNotBeFound("parentDepId.in=" + UPDATED_PARENT_DEP_ID);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByParentDepIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where parentDepId is not null
        defaultUucDepartmentTreeShouldBeFound("parentDepId.specified=true");

        // Get all the uucDepartmentTreeList where parentDepId is null
        defaultUucDepartmentTreeShouldNotBeFound("parentDepId.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByParentDepIdContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where parentDepId contains DEFAULT_PARENT_DEP_ID
        defaultUucDepartmentTreeShouldBeFound("parentDepId.contains=" + DEFAULT_PARENT_DEP_ID);

        // Get all the uucDepartmentTreeList where parentDepId contains UPDATED_PARENT_DEP_ID
        defaultUucDepartmentTreeShouldNotBeFound("parentDepId.contains=" + UPDATED_PARENT_DEP_ID);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByParentDepIdNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where parentDepId does not contain DEFAULT_PARENT_DEP_ID
        defaultUucDepartmentTreeShouldNotBeFound("parentDepId.doesNotContain=" + DEFAULT_PARENT_DEP_ID);

        // Get all the uucDepartmentTreeList where parentDepId does not contain UPDATED_PARENT_DEP_ID
        defaultUucDepartmentTreeShouldBeFound("parentDepId.doesNotContain=" + UPDATED_PARENT_DEP_ID);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByParentDepNameIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where parentDepName equals to DEFAULT_PARENT_DEP_NAME
        defaultUucDepartmentTreeShouldBeFound("parentDepName.equals=" + DEFAULT_PARENT_DEP_NAME);

        // Get all the uucDepartmentTreeList where parentDepName equals to UPDATED_PARENT_DEP_NAME
        defaultUucDepartmentTreeShouldNotBeFound("parentDepName.equals=" + UPDATED_PARENT_DEP_NAME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByParentDepNameIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where parentDepName not equals to DEFAULT_PARENT_DEP_NAME
        defaultUucDepartmentTreeShouldNotBeFound("parentDepName.notEquals=" + DEFAULT_PARENT_DEP_NAME);

        // Get all the uucDepartmentTreeList where parentDepName not equals to UPDATED_PARENT_DEP_NAME
        defaultUucDepartmentTreeShouldBeFound("parentDepName.notEquals=" + UPDATED_PARENT_DEP_NAME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByParentDepNameIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where parentDepName in DEFAULT_PARENT_DEP_NAME or UPDATED_PARENT_DEP_NAME
        defaultUucDepartmentTreeShouldBeFound("parentDepName.in=" + DEFAULT_PARENT_DEP_NAME + "," + UPDATED_PARENT_DEP_NAME);

        // Get all the uucDepartmentTreeList where parentDepName equals to UPDATED_PARENT_DEP_NAME
        defaultUucDepartmentTreeShouldNotBeFound("parentDepName.in=" + UPDATED_PARENT_DEP_NAME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByParentDepNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where parentDepName is not null
        defaultUucDepartmentTreeShouldBeFound("parentDepName.specified=true");

        // Get all the uucDepartmentTreeList where parentDepName is null
        defaultUucDepartmentTreeShouldNotBeFound("parentDepName.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByParentDepNameContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where parentDepName contains DEFAULT_PARENT_DEP_NAME
        defaultUucDepartmentTreeShouldBeFound("parentDepName.contains=" + DEFAULT_PARENT_DEP_NAME);

        // Get all the uucDepartmentTreeList where parentDepName contains UPDATED_PARENT_DEP_NAME
        defaultUucDepartmentTreeShouldNotBeFound("parentDepName.contains=" + UPDATED_PARENT_DEP_NAME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByParentDepNameNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where parentDepName does not contain DEFAULT_PARENT_DEP_NAME
        defaultUucDepartmentTreeShouldNotBeFound("parentDepName.doesNotContain=" + DEFAULT_PARENT_DEP_NAME);

        // Get all the uucDepartmentTreeList where parentDepName does not contain UPDATED_PARENT_DEP_NAME
        defaultUucDepartmentTreeShouldBeFound("parentDepName.doesNotContain=" + UPDATED_PARENT_DEP_NAME);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByStatusIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where status equals to DEFAULT_STATUS
        defaultUucDepartmentTreeShouldBeFound("status.equals=" + DEFAULT_STATUS);

        // Get all the uucDepartmentTreeList where status equals to UPDATED_STATUS
        defaultUucDepartmentTreeShouldNotBeFound("status.equals=" + UPDATED_STATUS);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByStatusIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where status not equals to DEFAULT_STATUS
        defaultUucDepartmentTreeShouldNotBeFound("status.notEquals=" + DEFAULT_STATUS);

        // Get all the uucDepartmentTreeList where status not equals to UPDATED_STATUS
        defaultUucDepartmentTreeShouldBeFound("status.notEquals=" + UPDATED_STATUS);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByStatusIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where status in DEFAULT_STATUS or UPDATED_STATUS
        defaultUucDepartmentTreeShouldBeFound("status.in=" + DEFAULT_STATUS + "," + UPDATED_STATUS);

        // Get all the uucDepartmentTreeList where status equals to UPDATED_STATUS
        defaultUucDepartmentTreeShouldNotBeFound("status.in=" + UPDATED_STATUS);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByStatusIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where status is not null
        defaultUucDepartmentTreeShouldBeFound("status.specified=true");

        // Get all the uucDepartmentTreeList where status is null
        defaultUucDepartmentTreeShouldNotBeFound("status.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByStatusContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where status contains DEFAULT_STATUS
        defaultUucDepartmentTreeShouldBeFound("status.contains=" + DEFAULT_STATUS);

        // Get all the uucDepartmentTreeList where status contains UPDATED_STATUS
        defaultUucDepartmentTreeShouldNotBeFound("status.contains=" + UPDATED_STATUS);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByStatusNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where status does not contain DEFAULT_STATUS
        defaultUucDepartmentTreeShouldNotBeFound("status.doesNotContain=" + DEFAULT_STATUS);

        // Get all the uucDepartmentTreeList where status does not contain UPDATED_STATUS
        defaultUucDepartmentTreeShouldBeFound("status.doesNotContain=" + UPDATED_STATUS);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDisporderIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where disporder equals to DEFAULT_DISPORDER
        defaultUucDepartmentTreeShouldBeFound("disporder.equals=" + DEFAULT_DISPORDER);

        // Get all the uucDepartmentTreeList where disporder equals to UPDATED_DISPORDER
        defaultUucDepartmentTreeShouldNotBeFound("disporder.equals=" + UPDATED_DISPORDER);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDisporderIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where disporder not equals to DEFAULT_DISPORDER
        defaultUucDepartmentTreeShouldNotBeFound("disporder.notEquals=" + DEFAULT_DISPORDER);

        // Get all the uucDepartmentTreeList where disporder not equals to UPDATED_DISPORDER
        defaultUucDepartmentTreeShouldBeFound("disporder.notEquals=" + UPDATED_DISPORDER);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDisporderIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where disporder in DEFAULT_DISPORDER or UPDATED_DISPORDER
        defaultUucDepartmentTreeShouldBeFound("disporder.in=" + DEFAULT_DISPORDER + "," + UPDATED_DISPORDER);

        // Get all the uucDepartmentTreeList where disporder equals to UPDATED_DISPORDER
        defaultUucDepartmentTreeShouldNotBeFound("disporder.in=" + UPDATED_DISPORDER);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDisporderIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where disporder is not null
        defaultUucDepartmentTreeShouldBeFound("disporder.specified=true");

        // Get all the uucDepartmentTreeList where disporder is null
        defaultUucDepartmentTreeShouldNotBeFound("disporder.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByDisporderContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where disporder contains DEFAULT_DISPORDER
        defaultUucDepartmentTreeShouldBeFound("disporder.contains=" + DEFAULT_DISPORDER);

        // Get all the uucDepartmentTreeList where disporder contains UPDATED_DISPORDER
        defaultUucDepartmentTreeShouldNotBeFound("disporder.contains=" + UPDATED_DISPORDER);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDisporderNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where disporder does not contain DEFAULT_DISPORDER
        defaultUucDepartmentTreeShouldNotBeFound("disporder.doesNotContain=" + DEFAULT_DISPORDER);

        // Get all the uucDepartmentTreeList where disporder does not contain UPDATED_DISPORDER
        defaultUucDepartmentTreeShouldBeFound("disporder.doesNotContain=" + UPDATED_DISPORDER);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNamePathIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where namePath equals to DEFAULT_NAME_PATH
        defaultUucDepartmentTreeShouldBeFound("namePath.equals=" + DEFAULT_NAME_PATH);

        // Get all the uucDepartmentTreeList where namePath equals to UPDATED_NAME_PATH
        defaultUucDepartmentTreeShouldNotBeFound("namePath.equals=" + UPDATED_NAME_PATH);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNamePathIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where namePath not equals to DEFAULT_NAME_PATH
        defaultUucDepartmentTreeShouldNotBeFound("namePath.notEquals=" + DEFAULT_NAME_PATH);

        // Get all the uucDepartmentTreeList where namePath not equals to UPDATED_NAME_PATH
        defaultUucDepartmentTreeShouldBeFound("namePath.notEquals=" + UPDATED_NAME_PATH);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNamePathIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where namePath in DEFAULT_NAME_PATH or UPDATED_NAME_PATH
        defaultUucDepartmentTreeShouldBeFound("namePath.in=" + DEFAULT_NAME_PATH + "," + UPDATED_NAME_PATH);

        // Get all the uucDepartmentTreeList where namePath equals to UPDATED_NAME_PATH
        defaultUucDepartmentTreeShouldNotBeFound("namePath.in=" + UPDATED_NAME_PATH);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNamePathIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where namePath is not null
        defaultUucDepartmentTreeShouldBeFound("namePath.specified=true");

        // Get all the uucDepartmentTreeList where namePath is null
        defaultUucDepartmentTreeShouldNotBeFound("namePath.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByNamePathContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where namePath contains DEFAULT_NAME_PATH
        defaultUucDepartmentTreeShouldBeFound("namePath.contains=" + DEFAULT_NAME_PATH);

        // Get all the uucDepartmentTreeList where namePath contains UPDATED_NAME_PATH
        defaultUucDepartmentTreeShouldNotBeFound("namePath.contains=" + UPDATED_NAME_PATH);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByNamePathNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where namePath does not contain DEFAULT_NAME_PATH
        defaultUucDepartmentTreeShouldNotBeFound("namePath.doesNotContain=" + DEFAULT_NAME_PATH);

        // Get all the uucDepartmentTreeList where namePath does not contain UPDATED_NAME_PATH
        defaultUucDepartmentTreeShouldBeFound("namePath.doesNotContain=" + UPDATED_NAME_PATH);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByCodePathIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where codePath equals to DEFAULT_CODE_PATH
        defaultUucDepartmentTreeShouldBeFound("codePath.equals=" + DEFAULT_CODE_PATH);

        // Get all the uucDepartmentTreeList where codePath equals to UPDATED_CODE_PATH
        defaultUucDepartmentTreeShouldNotBeFound("codePath.equals=" + UPDATED_CODE_PATH);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByCodePathIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where codePath not equals to DEFAULT_CODE_PATH
        defaultUucDepartmentTreeShouldNotBeFound("codePath.notEquals=" + DEFAULT_CODE_PATH);

        // Get all the uucDepartmentTreeList where codePath not equals to UPDATED_CODE_PATH
        defaultUucDepartmentTreeShouldBeFound("codePath.notEquals=" + UPDATED_CODE_PATH);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByCodePathIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where codePath in DEFAULT_CODE_PATH or UPDATED_CODE_PATH
        defaultUucDepartmentTreeShouldBeFound("codePath.in=" + DEFAULT_CODE_PATH + "," + UPDATED_CODE_PATH);

        // Get all the uucDepartmentTreeList where codePath equals to UPDATED_CODE_PATH
        defaultUucDepartmentTreeShouldNotBeFound("codePath.in=" + UPDATED_CODE_PATH);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByCodePathIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where codePath is not null
        defaultUucDepartmentTreeShouldBeFound("codePath.specified=true");

        // Get all the uucDepartmentTreeList where codePath is null
        defaultUucDepartmentTreeShouldNotBeFound("codePath.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByCodePathContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where codePath contains DEFAULT_CODE_PATH
        defaultUucDepartmentTreeShouldBeFound("codePath.contains=" + DEFAULT_CODE_PATH);

        // Get all the uucDepartmentTreeList where codePath contains UPDATED_CODE_PATH
        defaultUucDepartmentTreeShouldNotBeFound("codePath.contains=" + UPDATED_CODE_PATH);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByCodePathNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where codePath does not contain DEFAULT_CODE_PATH
        defaultUucDepartmentTreeShouldNotBeFound("codePath.doesNotContain=" + DEFAULT_CODE_PATH);

        // Get all the uucDepartmentTreeList where codePath does not contain UPDATED_CODE_PATH
        defaultUucDepartmentTreeShouldBeFound("codePath.doesNotContain=" + UPDATED_CODE_PATH);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDepIdPathIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where depIdPath equals to DEFAULT_DEP_ID_PATH
        defaultUucDepartmentTreeShouldBeFound("depIdPath.equals=" + DEFAULT_DEP_ID_PATH);

        // Get all the uucDepartmentTreeList where depIdPath equals to UPDATED_DEP_ID_PATH
        defaultUucDepartmentTreeShouldNotBeFound("depIdPath.equals=" + UPDATED_DEP_ID_PATH);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDepIdPathIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where depIdPath not equals to DEFAULT_DEP_ID_PATH
        defaultUucDepartmentTreeShouldNotBeFound("depIdPath.notEquals=" + DEFAULT_DEP_ID_PATH);

        // Get all the uucDepartmentTreeList where depIdPath not equals to UPDATED_DEP_ID_PATH
        defaultUucDepartmentTreeShouldBeFound("depIdPath.notEquals=" + UPDATED_DEP_ID_PATH);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDepIdPathIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where depIdPath in DEFAULT_DEP_ID_PATH or UPDATED_DEP_ID_PATH
        defaultUucDepartmentTreeShouldBeFound("depIdPath.in=" + DEFAULT_DEP_ID_PATH + "," + UPDATED_DEP_ID_PATH);

        // Get all the uucDepartmentTreeList where depIdPath equals to UPDATED_DEP_ID_PATH
        defaultUucDepartmentTreeShouldNotBeFound("depIdPath.in=" + UPDATED_DEP_ID_PATH);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDepIdPathIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where depIdPath is not null
        defaultUucDepartmentTreeShouldBeFound("depIdPath.specified=true");

        // Get all the uucDepartmentTreeList where depIdPath is null
        defaultUucDepartmentTreeShouldNotBeFound("depIdPath.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByDepIdPathContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where depIdPath contains DEFAULT_DEP_ID_PATH
        defaultUucDepartmentTreeShouldBeFound("depIdPath.contains=" + DEFAULT_DEP_ID_PATH);

        // Get all the uucDepartmentTreeList where depIdPath contains UPDATED_DEP_ID_PATH
        defaultUucDepartmentTreeShouldNotBeFound("depIdPath.contains=" + UPDATED_DEP_ID_PATH);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDepIdPathNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where depIdPath does not contain DEFAULT_DEP_ID_PATH
        defaultUucDepartmentTreeShouldNotBeFound("depIdPath.doesNotContain=" + DEFAULT_DEP_ID_PATH);

        // Get all the uucDepartmentTreeList where depIdPath does not contain UPDATED_DEP_ID_PATH
        defaultUucDepartmentTreeShouldBeFound("depIdPath.doesNotContain=" + UPDATED_DEP_ID_PATH);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDepLevelIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where depLevel equals to DEFAULT_DEP_LEVEL
        defaultUucDepartmentTreeShouldBeFound("depLevel.equals=" + DEFAULT_DEP_LEVEL);

        // Get all the uucDepartmentTreeList where depLevel equals to UPDATED_DEP_LEVEL
        defaultUucDepartmentTreeShouldNotBeFound("depLevel.equals=" + UPDATED_DEP_LEVEL);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDepLevelIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where depLevel not equals to DEFAULT_DEP_LEVEL
        defaultUucDepartmentTreeShouldNotBeFound("depLevel.notEquals=" + DEFAULT_DEP_LEVEL);

        // Get all the uucDepartmentTreeList where depLevel not equals to UPDATED_DEP_LEVEL
        defaultUucDepartmentTreeShouldBeFound("depLevel.notEquals=" + UPDATED_DEP_LEVEL);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDepLevelIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where depLevel in DEFAULT_DEP_LEVEL or UPDATED_DEP_LEVEL
        defaultUucDepartmentTreeShouldBeFound("depLevel.in=" + DEFAULT_DEP_LEVEL + "," + UPDATED_DEP_LEVEL);

        // Get all the uucDepartmentTreeList where depLevel equals to UPDATED_DEP_LEVEL
        defaultUucDepartmentTreeShouldNotBeFound("depLevel.in=" + UPDATED_DEP_LEVEL);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDepLevelIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where depLevel is not null
        defaultUucDepartmentTreeShouldBeFound("depLevel.specified=true");

        // Get all the uucDepartmentTreeList where depLevel is null
        defaultUucDepartmentTreeShouldNotBeFound("depLevel.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByDepLevelContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where depLevel contains DEFAULT_DEP_LEVEL
        defaultUucDepartmentTreeShouldBeFound("depLevel.contains=" + DEFAULT_DEP_LEVEL);

        // Get all the uucDepartmentTreeList where depLevel contains UPDATED_DEP_LEVEL
        defaultUucDepartmentTreeShouldNotBeFound("depLevel.contains=" + UPDATED_DEP_LEVEL);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDepLevelNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where depLevel does not contain DEFAULT_DEP_LEVEL
        defaultUucDepartmentTreeShouldNotBeFound("depLevel.doesNotContain=" + DEFAULT_DEP_LEVEL);

        // Get all the uucDepartmentTreeList where depLevel does not contain UPDATED_DEP_LEVEL
        defaultUucDepartmentTreeShouldBeFound("depLevel.doesNotContain=" + UPDATED_DEP_LEVEL);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByAliveFlagIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where aliveFlag equals to DEFAULT_ALIVE_FLAG
        defaultUucDepartmentTreeShouldBeFound("aliveFlag.equals=" + DEFAULT_ALIVE_FLAG);

        // Get all the uucDepartmentTreeList where aliveFlag equals to UPDATED_ALIVE_FLAG
        defaultUucDepartmentTreeShouldNotBeFound("aliveFlag.equals=" + UPDATED_ALIVE_FLAG);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByAliveFlagIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where aliveFlag not equals to DEFAULT_ALIVE_FLAG
        defaultUucDepartmentTreeShouldNotBeFound("aliveFlag.notEquals=" + DEFAULT_ALIVE_FLAG);

        // Get all the uucDepartmentTreeList where aliveFlag not equals to UPDATED_ALIVE_FLAG
        defaultUucDepartmentTreeShouldBeFound("aliveFlag.notEquals=" + UPDATED_ALIVE_FLAG);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByAliveFlagIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where aliveFlag in DEFAULT_ALIVE_FLAG or UPDATED_ALIVE_FLAG
        defaultUucDepartmentTreeShouldBeFound("aliveFlag.in=" + DEFAULT_ALIVE_FLAG + "," + UPDATED_ALIVE_FLAG);

        // Get all the uucDepartmentTreeList where aliveFlag equals to UPDATED_ALIVE_FLAG
        defaultUucDepartmentTreeShouldNotBeFound("aliveFlag.in=" + UPDATED_ALIVE_FLAG);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByAliveFlagIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where aliveFlag is not null
        defaultUucDepartmentTreeShouldBeFound("aliveFlag.specified=true");

        // Get all the uucDepartmentTreeList where aliveFlag is null
        defaultUucDepartmentTreeShouldNotBeFound("aliveFlag.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByAliveFlagContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where aliveFlag contains DEFAULT_ALIVE_FLAG
        defaultUucDepartmentTreeShouldBeFound("aliveFlag.contains=" + DEFAULT_ALIVE_FLAG);

        // Get all the uucDepartmentTreeList where aliveFlag contains UPDATED_ALIVE_FLAG
        defaultUucDepartmentTreeShouldNotBeFound("aliveFlag.contains=" + UPDATED_ALIVE_FLAG);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByAliveFlagNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where aliveFlag does not contain DEFAULT_ALIVE_FLAG
        defaultUucDepartmentTreeShouldNotBeFound("aliveFlag.doesNotContain=" + DEFAULT_ALIVE_FLAG);

        // Get all the uucDepartmentTreeList where aliveFlag does not contain UPDATED_ALIVE_FLAG
        defaultUucDepartmentTreeShouldBeFound("aliveFlag.doesNotContain=" + UPDATED_ALIVE_FLAG);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecCreateTimeIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recCreateTime equals to DEFAULT_REC_CREATE_TIME
        defaultUucDepartmentTreeShouldBeFound("recCreateTime.equals=" + DEFAULT_REC_CREATE_TIME);

        // Get all the uucDepartmentTreeList where recCreateTime equals to UPDATED_REC_CREATE_TIME
        defaultUucDepartmentTreeShouldNotBeFound("recCreateTime.equals=" + UPDATED_REC_CREATE_TIME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecCreateTimeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recCreateTime not equals to DEFAULT_REC_CREATE_TIME
        defaultUucDepartmentTreeShouldNotBeFound("recCreateTime.notEquals=" + DEFAULT_REC_CREATE_TIME);

        // Get all the uucDepartmentTreeList where recCreateTime not equals to UPDATED_REC_CREATE_TIME
        defaultUucDepartmentTreeShouldBeFound("recCreateTime.notEquals=" + UPDATED_REC_CREATE_TIME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecCreateTimeIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recCreateTime in DEFAULT_REC_CREATE_TIME or UPDATED_REC_CREATE_TIME
        defaultUucDepartmentTreeShouldBeFound("recCreateTime.in=" + DEFAULT_REC_CREATE_TIME + "," + UPDATED_REC_CREATE_TIME);

        // Get all the uucDepartmentTreeList where recCreateTime equals to UPDATED_REC_CREATE_TIME
        defaultUucDepartmentTreeShouldNotBeFound("recCreateTime.in=" + UPDATED_REC_CREATE_TIME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecCreateTimeIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recCreateTime is not null
        defaultUucDepartmentTreeShouldBeFound("recCreateTime.specified=true");

        // Get all the uucDepartmentTreeList where recCreateTime is null
        defaultUucDepartmentTreeShouldNotBeFound("recCreateTime.specified=false");
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecCreatorIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recCreator equals to DEFAULT_REC_CREATOR
        defaultUucDepartmentTreeShouldBeFound("recCreator.equals=" + DEFAULT_REC_CREATOR);

        // Get all the uucDepartmentTreeList where recCreator equals to UPDATED_REC_CREATOR
        defaultUucDepartmentTreeShouldNotBeFound("recCreator.equals=" + UPDATED_REC_CREATOR);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecCreatorIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recCreator not equals to DEFAULT_REC_CREATOR
        defaultUucDepartmentTreeShouldNotBeFound("recCreator.notEquals=" + DEFAULT_REC_CREATOR);

        // Get all the uucDepartmentTreeList where recCreator not equals to UPDATED_REC_CREATOR
        defaultUucDepartmentTreeShouldBeFound("recCreator.notEquals=" + UPDATED_REC_CREATOR);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecCreatorIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recCreator in DEFAULT_REC_CREATOR or UPDATED_REC_CREATOR
        defaultUucDepartmentTreeShouldBeFound("recCreator.in=" + DEFAULT_REC_CREATOR + "," + UPDATED_REC_CREATOR);

        // Get all the uucDepartmentTreeList where recCreator equals to UPDATED_REC_CREATOR
        defaultUucDepartmentTreeShouldNotBeFound("recCreator.in=" + UPDATED_REC_CREATOR);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecCreatorIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recCreator is not null
        defaultUucDepartmentTreeShouldBeFound("recCreator.specified=true");

        // Get all the uucDepartmentTreeList where recCreator is null
        defaultUucDepartmentTreeShouldNotBeFound("recCreator.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecCreatorContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recCreator contains DEFAULT_REC_CREATOR
        defaultUucDepartmentTreeShouldBeFound("recCreator.contains=" + DEFAULT_REC_CREATOR);

        // Get all the uucDepartmentTreeList where recCreator contains UPDATED_REC_CREATOR
        defaultUucDepartmentTreeShouldNotBeFound("recCreator.contains=" + UPDATED_REC_CREATOR);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecCreatorNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recCreator does not contain DEFAULT_REC_CREATOR
        defaultUucDepartmentTreeShouldNotBeFound("recCreator.doesNotContain=" + DEFAULT_REC_CREATOR);

        // Get all the uucDepartmentTreeList where recCreator does not contain UPDATED_REC_CREATOR
        defaultUucDepartmentTreeShouldBeFound("recCreator.doesNotContain=" + UPDATED_REC_CREATOR);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecReviseTimeIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recReviseTime equals to DEFAULT_REC_REVISE_TIME
        defaultUucDepartmentTreeShouldBeFound("recReviseTime.equals=" + DEFAULT_REC_REVISE_TIME);

        // Get all the uucDepartmentTreeList where recReviseTime equals to UPDATED_REC_REVISE_TIME
        defaultUucDepartmentTreeShouldNotBeFound("recReviseTime.equals=" + UPDATED_REC_REVISE_TIME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecReviseTimeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recReviseTime not equals to DEFAULT_REC_REVISE_TIME
        defaultUucDepartmentTreeShouldNotBeFound("recReviseTime.notEquals=" + DEFAULT_REC_REVISE_TIME);

        // Get all the uucDepartmentTreeList where recReviseTime not equals to UPDATED_REC_REVISE_TIME
        defaultUucDepartmentTreeShouldBeFound("recReviseTime.notEquals=" + UPDATED_REC_REVISE_TIME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecReviseTimeIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recReviseTime in DEFAULT_REC_REVISE_TIME or UPDATED_REC_REVISE_TIME
        defaultUucDepartmentTreeShouldBeFound("recReviseTime.in=" + DEFAULT_REC_REVISE_TIME + "," + UPDATED_REC_REVISE_TIME);

        // Get all the uucDepartmentTreeList where recReviseTime equals to UPDATED_REC_REVISE_TIME
        defaultUucDepartmentTreeShouldNotBeFound("recReviseTime.in=" + UPDATED_REC_REVISE_TIME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecReviseTimeIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recReviseTime is not null
        defaultUucDepartmentTreeShouldBeFound("recReviseTime.specified=true");

        // Get all the uucDepartmentTreeList where recReviseTime is null
        defaultUucDepartmentTreeShouldNotBeFound("recReviseTime.specified=false");
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecRevisorIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recRevisor equals to DEFAULT_REC_REVISOR
        defaultUucDepartmentTreeShouldBeFound("recRevisor.equals=" + DEFAULT_REC_REVISOR);

        // Get all the uucDepartmentTreeList where recRevisor equals to UPDATED_REC_REVISOR
        defaultUucDepartmentTreeShouldNotBeFound("recRevisor.equals=" + UPDATED_REC_REVISOR);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecRevisorIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recRevisor not equals to DEFAULT_REC_REVISOR
        defaultUucDepartmentTreeShouldNotBeFound("recRevisor.notEquals=" + DEFAULT_REC_REVISOR);

        // Get all the uucDepartmentTreeList where recRevisor not equals to UPDATED_REC_REVISOR
        defaultUucDepartmentTreeShouldBeFound("recRevisor.notEquals=" + UPDATED_REC_REVISOR);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecRevisorIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recRevisor in DEFAULT_REC_REVISOR or UPDATED_REC_REVISOR
        defaultUucDepartmentTreeShouldBeFound("recRevisor.in=" + DEFAULT_REC_REVISOR + "," + UPDATED_REC_REVISOR);

        // Get all the uucDepartmentTreeList where recRevisor equals to UPDATED_REC_REVISOR
        defaultUucDepartmentTreeShouldNotBeFound("recRevisor.in=" + UPDATED_REC_REVISOR);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecRevisorIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recRevisor is not null
        defaultUucDepartmentTreeShouldBeFound("recRevisor.specified=true");

        // Get all the uucDepartmentTreeList where recRevisor is null
        defaultUucDepartmentTreeShouldNotBeFound("recRevisor.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecRevisorContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recRevisor contains DEFAULT_REC_REVISOR
        defaultUucDepartmentTreeShouldBeFound("recRevisor.contains=" + DEFAULT_REC_REVISOR);

        // Get all the uucDepartmentTreeList where recRevisor contains UPDATED_REC_REVISOR
        defaultUucDepartmentTreeShouldNotBeFound("recRevisor.contains=" + UPDATED_REC_REVISOR);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByRecRevisorNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where recRevisor does not contain DEFAULT_REC_REVISOR
        defaultUucDepartmentTreeShouldNotBeFound("recRevisor.doesNotContain=" + DEFAULT_REC_REVISOR);

        // Get all the uucDepartmentTreeList where recRevisor does not contain UPDATED_REC_REVISOR
        defaultUucDepartmentTreeShouldBeFound("recRevisor.doesNotContain=" + UPDATED_REC_REVISOR);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDeptUserCountIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where deptUserCount equals to DEFAULT_DEPT_USER_COUNT
        defaultUucDepartmentTreeShouldBeFound("deptUserCount.equals=" + DEFAULT_DEPT_USER_COUNT);

        // Get all the uucDepartmentTreeList where deptUserCount equals to UPDATED_DEPT_USER_COUNT
        defaultUucDepartmentTreeShouldNotBeFound("deptUserCount.equals=" + UPDATED_DEPT_USER_COUNT);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDeptUserCountIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where deptUserCount not equals to DEFAULT_DEPT_USER_COUNT
        defaultUucDepartmentTreeShouldNotBeFound("deptUserCount.notEquals=" + DEFAULT_DEPT_USER_COUNT);

        // Get all the uucDepartmentTreeList where deptUserCount not equals to UPDATED_DEPT_USER_COUNT
        defaultUucDepartmentTreeShouldBeFound("deptUserCount.notEquals=" + UPDATED_DEPT_USER_COUNT);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDeptUserCountIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where deptUserCount in DEFAULT_DEPT_USER_COUNT or UPDATED_DEPT_USER_COUNT
        defaultUucDepartmentTreeShouldBeFound("deptUserCount.in=" + DEFAULT_DEPT_USER_COUNT + "," + UPDATED_DEPT_USER_COUNT);

        // Get all the uucDepartmentTreeList where deptUserCount equals to UPDATED_DEPT_USER_COUNT
        defaultUucDepartmentTreeShouldNotBeFound("deptUserCount.in=" + UPDATED_DEPT_USER_COUNT);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDeptUserCountIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where deptUserCount is not null
        defaultUucDepartmentTreeShouldBeFound("deptUserCount.specified=true");

        // Get all the uucDepartmentTreeList where deptUserCount is null
        defaultUucDepartmentTreeShouldNotBeFound("deptUserCount.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByDeptUserCountContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where deptUserCount contains DEFAULT_DEPT_USER_COUNT
        defaultUucDepartmentTreeShouldBeFound("deptUserCount.contains=" + DEFAULT_DEPT_USER_COUNT);

        // Get all the uucDepartmentTreeList where deptUserCount contains UPDATED_DEPT_USER_COUNT
        defaultUucDepartmentTreeShouldNotBeFound("deptUserCount.contains=" + UPDATED_DEPT_USER_COUNT);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByDeptUserCountNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where deptUserCount does not contain DEFAULT_DEPT_USER_COUNT
        defaultUucDepartmentTreeShouldNotBeFound("deptUserCount.doesNotContain=" + DEFAULT_DEPT_USER_COUNT);

        // Get all the uucDepartmentTreeList where deptUserCount does not contain UPDATED_DEPT_USER_COUNT
        defaultUucDepartmentTreeShouldBeFound("deptUserCount.doesNotContain=" + UPDATED_DEPT_USER_COUNT);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByMicroappIdIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where microappId equals to DEFAULT_MICROAPP_ID
        defaultUucDepartmentTreeShouldBeFound("microappId.equals=" + DEFAULT_MICROAPP_ID);

        // Get all the uucDepartmentTreeList where microappId equals to UPDATED_MICROAPP_ID
        defaultUucDepartmentTreeShouldNotBeFound("microappId.equals=" + UPDATED_MICROAPP_ID);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByMicroappIdIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where microappId not equals to DEFAULT_MICROAPP_ID
        defaultUucDepartmentTreeShouldNotBeFound("microappId.notEquals=" + DEFAULT_MICROAPP_ID);

        // Get all the uucDepartmentTreeList where microappId not equals to UPDATED_MICROAPP_ID
        defaultUucDepartmentTreeShouldBeFound("microappId.notEquals=" + UPDATED_MICROAPP_ID);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByMicroappIdIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where microappId in DEFAULT_MICROAPP_ID or UPDATED_MICROAPP_ID
        defaultUucDepartmentTreeShouldBeFound("microappId.in=" + DEFAULT_MICROAPP_ID + "," + UPDATED_MICROAPP_ID);

        // Get all the uucDepartmentTreeList where microappId equals to UPDATED_MICROAPP_ID
        defaultUucDepartmentTreeShouldNotBeFound("microappId.in=" + UPDATED_MICROAPP_ID);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByMicroappIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where microappId is not null
        defaultUucDepartmentTreeShouldBeFound("microappId.specified=true");

        // Get all the uucDepartmentTreeList where microappId is null
        defaultUucDepartmentTreeShouldNotBeFound("microappId.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByMicroappIdContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where microappId contains DEFAULT_MICROAPP_ID
        defaultUucDepartmentTreeShouldBeFound("microappId.contains=" + DEFAULT_MICROAPP_ID);

        // Get all the uucDepartmentTreeList where microappId contains UPDATED_MICROAPP_ID
        defaultUucDepartmentTreeShouldNotBeFound("microappId.contains=" + UPDATED_MICROAPP_ID);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByMicroappIdNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where microappId does not contain DEFAULT_MICROAPP_ID
        defaultUucDepartmentTreeShouldNotBeFound("microappId.doesNotContain=" + DEFAULT_MICROAPP_ID);

        // Get all the uucDepartmentTreeList where microappId does not contain UPDATED_MICROAPP_ID
        defaultUucDepartmentTreeShouldBeFound("microappId.doesNotContain=" + UPDATED_MICROAPP_ID);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByEnNameIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where enName equals to DEFAULT_EN_NAME
        defaultUucDepartmentTreeShouldBeFound("enName.equals=" + DEFAULT_EN_NAME);

        // Get all the uucDepartmentTreeList where enName equals to UPDATED_EN_NAME
        defaultUucDepartmentTreeShouldNotBeFound("enName.equals=" + UPDATED_EN_NAME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByEnNameIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where enName not equals to DEFAULT_EN_NAME
        defaultUucDepartmentTreeShouldNotBeFound("enName.notEquals=" + DEFAULT_EN_NAME);

        // Get all the uucDepartmentTreeList where enName not equals to UPDATED_EN_NAME
        defaultUucDepartmentTreeShouldBeFound("enName.notEquals=" + UPDATED_EN_NAME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByEnNameIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where enName in DEFAULT_EN_NAME or UPDATED_EN_NAME
        defaultUucDepartmentTreeShouldBeFound("enName.in=" + DEFAULT_EN_NAME + "," + UPDATED_EN_NAME);

        // Get all the uucDepartmentTreeList where enName equals to UPDATED_EN_NAME
        defaultUucDepartmentTreeShouldNotBeFound("enName.in=" + UPDATED_EN_NAME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByEnNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where enName is not null
        defaultUucDepartmentTreeShouldBeFound("enName.specified=true");

        // Get all the uucDepartmentTreeList where enName is null
        defaultUucDepartmentTreeShouldNotBeFound("enName.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByEnNameContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where enName contains DEFAULT_EN_NAME
        defaultUucDepartmentTreeShouldBeFound("enName.contains=" + DEFAULT_EN_NAME);

        // Get all the uucDepartmentTreeList where enName contains UPDATED_EN_NAME
        defaultUucDepartmentTreeShouldNotBeFound("enName.contains=" + UPDATED_EN_NAME);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByEnNameNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where enName does not contain DEFAULT_EN_NAME
        defaultUucDepartmentTreeShouldNotBeFound("enName.doesNotContain=" + DEFAULT_EN_NAME);

        // Get all the uucDepartmentTreeList where enName does not contain UPDATED_EN_NAME
        defaultUucDepartmentTreeShouldBeFound("enName.doesNotContain=" + UPDATED_EN_NAME);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByOnlyCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where onlyCode equals to DEFAULT_ONLY_CODE
        defaultUucDepartmentTreeShouldBeFound("onlyCode.equals=" + DEFAULT_ONLY_CODE);

        // Get all the uucDepartmentTreeList where onlyCode equals to UPDATED_ONLY_CODE
        defaultUucDepartmentTreeShouldNotBeFound("onlyCode.equals=" + UPDATED_ONLY_CODE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByOnlyCodeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where onlyCode not equals to DEFAULT_ONLY_CODE
        defaultUucDepartmentTreeShouldNotBeFound("onlyCode.notEquals=" + DEFAULT_ONLY_CODE);

        // Get all the uucDepartmentTreeList where onlyCode not equals to UPDATED_ONLY_CODE
        defaultUucDepartmentTreeShouldBeFound("onlyCode.notEquals=" + UPDATED_ONLY_CODE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByOnlyCodeIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where onlyCode in DEFAULT_ONLY_CODE or UPDATED_ONLY_CODE
        defaultUucDepartmentTreeShouldBeFound("onlyCode.in=" + DEFAULT_ONLY_CODE + "," + UPDATED_ONLY_CODE);

        // Get all the uucDepartmentTreeList where onlyCode equals to UPDATED_ONLY_CODE
        defaultUucDepartmentTreeShouldNotBeFound("onlyCode.in=" + UPDATED_ONLY_CODE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByOnlyCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where onlyCode is not null
        defaultUucDepartmentTreeShouldBeFound("onlyCode.specified=true");

        // Get all the uucDepartmentTreeList where onlyCode is null
        defaultUucDepartmentTreeShouldNotBeFound("onlyCode.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesByOnlyCodeContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where onlyCode contains DEFAULT_ONLY_CODE
        defaultUucDepartmentTreeShouldBeFound("onlyCode.contains=" + DEFAULT_ONLY_CODE);

        // Get all the uucDepartmentTreeList where onlyCode contains UPDATED_ONLY_CODE
        defaultUucDepartmentTreeShouldNotBeFound("onlyCode.contains=" + UPDATED_ONLY_CODE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesByOnlyCodeNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where onlyCode does not contain DEFAULT_ONLY_CODE
        defaultUucDepartmentTreeShouldNotBeFound("onlyCode.doesNotContain=" + DEFAULT_ONLY_CODE);

        // Get all the uucDepartmentTreeList where onlyCode does not contain UPDATED_ONLY_CODE
        defaultUucDepartmentTreeShouldBeFound("onlyCode.doesNotContain=" + UPDATED_ONLY_CODE);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptIdIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptId equals to DEFAULT_SRC_DEPT_ID
        defaultUucDepartmentTreeShouldBeFound("srcDeptId.equals=" + DEFAULT_SRC_DEPT_ID);

        // Get all the uucDepartmentTreeList where srcDeptId equals to UPDATED_SRC_DEPT_ID
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptId.equals=" + UPDATED_SRC_DEPT_ID);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptIdIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptId not equals to DEFAULT_SRC_DEPT_ID
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptId.notEquals=" + DEFAULT_SRC_DEPT_ID);

        // Get all the uucDepartmentTreeList where srcDeptId not equals to UPDATED_SRC_DEPT_ID
        defaultUucDepartmentTreeShouldBeFound("srcDeptId.notEquals=" + UPDATED_SRC_DEPT_ID);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptIdIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptId in DEFAULT_SRC_DEPT_ID or UPDATED_SRC_DEPT_ID
        defaultUucDepartmentTreeShouldBeFound("srcDeptId.in=" + DEFAULT_SRC_DEPT_ID + "," + UPDATED_SRC_DEPT_ID);

        // Get all the uucDepartmentTreeList where srcDeptId equals to UPDATED_SRC_DEPT_ID
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptId.in=" + UPDATED_SRC_DEPT_ID);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptId is not null
        defaultUucDepartmentTreeShouldBeFound("srcDeptId.specified=true");

        // Get all the uucDepartmentTreeList where srcDeptId is null
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptId.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptIdContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptId contains DEFAULT_SRC_DEPT_ID
        defaultUucDepartmentTreeShouldBeFound("srcDeptId.contains=" + DEFAULT_SRC_DEPT_ID);

        // Get all the uucDepartmentTreeList where srcDeptId contains UPDATED_SRC_DEPT_ID
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptId.contains=" + UPDATED_SRC_DEPT_ID);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptIdNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptId does not contain DEFAULT_SRC_DEPT_ID
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptId.doesNotContain=" + DEFAULT_SRC_DEPT_ID);

        // Get all the uucDepartmentTreeList where srcDeptId does not contain UPDATED_SRC_DEPT_ID
        defaultUucDepartmentTreeShouldBeFound("srcDeptId.doesNotContain=" + UPDATED_SRC_DEPT_ID);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptTypeIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptType equals to DEFAULT_SRC_DEPT_TYPE
        defaultUucDepartmentTreeShouldBeFound("srcDeptType.equals=" + DEFAULT_SRC_DEPT_TYPE);

        // Get all the uucDepartmentTreeList where srcDeptType equals to UPDATED_SRC_DEPT_TYPE
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptType.equals=" + UPDATED_SRC_DEPT_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptTypeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptType not equals to DEFAULT_SRC_DEPT_TYPE
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptType.notEquals=" + DEFAULT_SRC_DEPT_TYPE);

        // Get all the uucDepartmentTreeList where srcDeptType not equals to UPDATED_SRC_DEPT_TYPE
        defaultUucDepartmentTreeShouldBeFound("srcDeptType.notEquals=" + UPDATED_SRC_DEPT_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptTypeIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptType in DEFAULT_SRC_DEPT_TYPE or UPDATED_SRC_DEPT_TYPE
        defaultUucDepartmentTreeShouldBeFound("srcDeptType.in=" + DEFAULT_SRC_DEPT_TYPE + "," + UPDATED_SRC_DEPT_TYPE);

        // Get all the uucDepartmentTreeList where srcDeptType equals to UPDATED_SRC_DEPT_TYPE
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptType.in=" + UPDATED_SRC_DEPT_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptTypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptType is not null
        defaultUucDepartmentTreeShouldBeFound("srcDeptType.specified=true");

        // Get all the uucDepartmentTreeList where srcDeptType is null
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptType.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptTypeContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptType contains DEFAULT_SRC_DEPT_TYPE
        defaultUucDepartmentTreeShouldBeFound("srcDeptType.contains=" + DEFAULT_SRC_DEPT_TYPE);

        // Get all the uucDepartmentTreeList where srcDeptType contains UPDATED_SRC_DEPT_TYPE
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptType.contains=" + UPDATED_SRC_DEPT_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptTypeNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptType does not contain DEFAULT_SRC_DEPT_TYPE
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptType.doesNotContain=" + DEFAULT_SRC_DEPT_TYPE);

        // Get all the uucDepartmentTreeList where srcDeptType does not contain UPDATED_SRC_DEPT_TYPE
        defaultUucDepartmentTreeShouldBeFound("srcDeptType.doesNotContain=" + UPDATED_SRC_DEPT_TYPE);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcTypeIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcType equals to DEFAULT_SRC_TYPE
        defaultUucDepartmentTreeShouldBeFound("srcType.equals=" + DEFAULT_SRC_TYPE);

        // Get all the uucDepartmentTreeList where srcType equals to UPDATED_SRC_TYPE
        defaultUucDepartmentTreeShouldNotBeFound("srcType.equals=" + UPDATED_SRC_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcTypeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcType not equals to DEFAULT_SRC_TYPE
        defaultUucDepartmentTreeShouldNotBeFound("srcType.notEquals=" + DEFAULT_SRC_TYPE);

        // Get all the uucDepartmentTreeList where srcType not equals to UPDATED_SRC_TYPE
        defaultUucDepartmentTreeShouldBeFound("srcType.notEquals=" + UPDATED_SRC_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcTypeIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcType in DEFAULT_SRC_TYPE or UPDATED_SRC_TYPE
        defaultUucDepartmentTreeShouldBeFound("srcType.in=" + DEFAULT_SRC_TYPE + "," + UPDATED_SRC_TYPE);

        // Get all the uucDepartmentTreeList where srcType equals to UPDATED_SRC_TYPE
        defaultUucDepartmentTreeShouldNotBeFound("srcType.in=" + UPDATED_SRC_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcTypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcType is not null
        defaultUucDepartmentTreeShouldBeFound("srcType.specified=true");

        // Get all the uucDepartmentTreeList where srcType is null
        defaultUucDepartmentTreeShouldNotBeFound("srcType.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcTypeContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcType contains DEFAULT_SRC_TYPE
        defaultUucDepartmentTreeShouldBeFound("srcType.contains=" + DEFAULT_SRC_TYPE);

        // Get all the uucDepartmentTreeList where srcType contains UPDATED_SRC_TYPE
        defaultUucDepartmentTreeShouldNotBeFound("srcType.contains=" + UPDATED_SRC_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcTypeNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcType does not contain DEFAULT_SRC_TYPE
        defaultUucDepartmentTreeShouldNotBeFound("srcType.doesNotContain=" + DEFAULT_SRC_TYPE);

        // Get all the uucDepartmentTreeList where srcType does not contain UPDATED_SRC_TYPE
        defaultUucDepartmentTreeShouldBeFound("srcType.doesNotContain=" + UPDATED_SRC_TYPE);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptUcodeIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptUcode equals to DEFAULT_SRC_DEPT_UCODE
        defaultUucDepartmentTreeShouldBeFound("srcDeptUcode.equals=" + DEFAULT_SRC_DEPT_UCODE);

        // Get all the uucDepartmentTreeList where srcDeptUcode equals to UPDATED_SRC_DEPT_UCODE
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptUcode.equals=" + UPDATED_SRC_DEPT_UCODE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptUcodeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptUcode not equals to DEFAULT_SRC_DEPT_UCODE
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptUcode.notEquals=" + DEFAULT_SRC_DEPT_UCODE);

        // Get all the uucDepartmentTreeList where srcDeptUcode not equals to UPDATED_SRC_DEPT_UCODE
        defaultUucDepartmentTreeShouldBeFound("srcDeptUcode.notEquals=" + UPDATED_SRC_DEPT_UCODE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptUcodeIsInShouldWork() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptUcode in DEFAULT_SRC_DEPT_UCODE or UPDATED_SRC_DEPT_UCODE
        defaultUucDepartmentTreeShouldBeFound("srcDeptUcode.in=" + DEFAULT_SRC_DEPT_UCODE + "," + UPDATED_SRC_DEPT_UCODE);

        // Get all the uucDepartmentTreeList where srcDeptUcode equals to UPDATED_SRC_DEPT_UCODE
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptUcode.in=" + UPDATED_SRC_DEPT_UCODE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptUcodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptUcode is not null
        defaultUucDepartmentTreeShouldBeFound("srcDeptUcode.specified=true");

        // Get all the uucDepartmentTreeList where srcDeptUcode is null
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptUcode.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptUcodeContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptUcode contains DEFAULT_SRC_DEPT_UCODE
        defaultUucDepartmentTreeShouldBeFound("srcDeptUcode.contains=" + DEFAULT_SRC_DEPT_UCODE);

        // Get all the uucDepartmentTreeList where srcDeptUcode contains UPDATED_SRC_DEPT_UCODE
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptUcode.contains=" + UPDATED_SRC_DEPT_UCODE);
    }

    @Test
    @Transactional
    public void getAllUucDepartmentTreesBySrcDeptUcodeNotContainsSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);

        // Get all the uucDepartmentTreeList where srcDeptUcode does not contain DEFAULT_SRC_DEPT_UCODE
        defaultUucDepartmentTreeShouldNotBeFound("srcDeptUcode.doesNotContain=" + DEFAULT_SRC_DEPT_UCODE);

        // Get all the uucDepartmentTreeList where srcDeptUcode does not contain UPDATED_SRC_DEPT_UCODE
        defaultUucDepartmentTreeShouldBeFound("srcDeptUcode.doesNotContain=" + UPDATED_SRC_DEPT_UCODE);
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByMicroAppGroupIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);
        MicroAppGroup microAppGroup = MicroAppGroupResourceIT.createEntity(em);
        em.persist(microAppGroup);
        em.flush();
        uucDepartmentTree.setMicroAppGroup(microAppGroup);
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);
        Long microAppGroupId = microAppGroup.getId();

        // Get all the uucDepartmentTreeList where microAppGroup equals to microAppGroupId
        defaultUucDepartmentTreeShouldBeFound("microAppGroupId.equals=" + microAppGroupId);

        // Get all the uucDepartmentTreeList where microAppGroup equals to microAppGroupId + 1
        defaultUucDepartmentTreeShouldNotBeFound("microAppGroupId.equals=" + (microAppGroupId + 1));
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByUsableIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);
        FmpMicroApp usable = FmpMicroAppResourceIT.createEntity(em);
        em.persist(usable);
        em.flush();
        uucDepartmentTree.addUsable(usable);
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);
        Long usableId = usable.getId();

        // Get all the uucDepartmentTreeList where usable equals to usableId
        defaultUucDepartmentTreeShouldBeFound("usableId.equals=" + usableId);

        // Get all the uucDepartmentTreeList where usable equals to usableId + 1
        defaultUucDepartmentTreeShouldNotBeFound("usableId.equals=" + (usableId + 1));
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByManagerIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);
        ManagerUser manager = ManagerUserResourceIT.createEntity(em);
        em.persist(manager);
        em.flush();
        uucDepartmentTree.addManager(manager);
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);
        Long managerId = manager.getId();

        // Get all the uucDepartmentTreeList where manager equals to managerId
        defaultUucDepartmentTreeShouldBeFound("managerId.equals=" + managerId);

        // Get all the uucDepartmentTreeList where manager equals to managerId + 1
        defaultUucDepartmentTreeShouldNotBeFound("managerId.equals=" + (managerId + 1));
    }


    @Test
    @Transactional
    public void getAllUucDepartmentTreesByFmpSubCompanyIsEqualToSomething() throws Exception {
        // Initialize the database
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);
        FmpSubCompany fmpSubCompany = FmpSubCompanyResourceIT.createEntity(em);
        em.persist(fmpSubCompany);
        em.flush();
        uucDepartmentTree.addFmpSubCompany(fmpSubCompany);
        uucDepartmentTreeRepository.saveAndFlush(uucDepartmentTree);
        Long fmpSubCompanyId = fmpSubCompany.getId();

        // Get all the uucDepartmentTreeList where fmpSubCompany equals to fmpSubCompanyId
        defaultUucDepartmentTreeShouldBeFound("fmpSubCompanyId.equals=" + fmpSubCompanyId);

        // Get all the uucDepartmentTreeList where fmpSubCompany equals to fmpSubCompanyId + 1
        defaultUucDepartmentTreeShouldNotBeFound("fmpSubCompanyId.equals=" + (fmpSubCompanyId + 1));
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultUucDepartmentTreeShouldBeFound(String filter) throws Exception {
        restUucDepartmentTreeMockMvc.perform(get("/api/uuc-department-trees?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(uucDepartmentTree.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].namePy").value(hasItem(DEFAULT_NAME_PY)))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].parentDepId").value(hasItem(DEFAULT_PARENT_DEP_ID)))
            .andExpect(jsonPath("$.[*].parentDepName").value(hasItem(DEFAULT_PARENT_DEP_NAME)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].disporder").value(hasItem(DEFAULT_DISPORDER)))
            .andExpect(jsonPath("$.[*].namePath").value(hasItem(DEFAULT_NAME_PATH)))
            .andExpect(jsonPath("$.[*].codePath").value(hasItem(DEFAULT_CODE_PATH)))
            .andExpect(jsonPath("$.[*].depIdPath").value(hasItem(DEFAULT_DEP_ID_PATH)))
            .andExpect(jsonPath("$.[*].depLevel").value(hasItem(DEFAULT_DEP_LEVEL)))
            .andExpect(jsonPath("$.[*].aliveFlag").value(hasItem(DEFAULT_ALIVE_FLAG)))
            .andExpect(jsonPath("$.[*].recCreateTime").value(hasItem(DEFAULT_REC_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].recCreator").value(hasItem(DEFAULT_REC_CREATOR)))
            .andExpect(jsonPath("$.[*].recReviseTime").value(hasItem(DEFAULT_REC_REVISE_TIME.toString())))
            .andExpect(jsonPath("$.[*].recRevisor").value(hasItem(DEFAULT_REC_REVISOR)))
            .andExpect(jsonPath("$.[*].deptUserCount").value(hasItem(DEFAULT_DEPT_USER_COUNT)))
            .andExpect(jsonPath("$.[*].microappId").value(hasItem(DEFAULT_MICROAPP_ID)))
            .andExpect(jsonPath("$.[*].enName").value(hasItem(DEFAULT_EN_NAME)))
            .andExpect(jsonPath("$.[*].onlyCode").value(hasItem(DEFAULT_ONLY_CODE)))
            .andExpect(jsonPath("$.[*].srcDeptId").value(hasItem(DEFAULT_SRC_DEPT_ID)))
            .andExpect(jsonPath("$.[*].srcDeptType").value(hasItem(DEFAULT_SRC_DEPT_TYPE)))
            .andExpect(jsonPath("$.[*].srcType").value(hasItem(DEFAULT_SRC_TYPE)))
            .andExpect(jsonPath("$.[*].srcDeptUcode").value(hasItem(DEFAULT_SRC_DEPT_UCODE)));

        // Check, that the count call also returns 1
        restUucDepartmentTreeMockMvc.perform(get("/api/uuc-department-trees/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultUucDepartmentTreeShouldNotBeFound(String filter) throws Exception {
        restUucDepartmentTreeMockMvc.perform(get("/api/uuc-department-trees?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restUucDepartmentTreeMockMvc.perform(get("/api/uuc-department-trees/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    public void getNonExistingUucDepartmentTree() throws Exception {
        // Get the uucDepartmentTree
        restUucDepartmentTreeMockMvc.perform(get("/api/uuc-department-trees/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateUucDepartmentTree() throws Exception {
        // Initialize the database
        uucDepartmentTreeService.save(uucDepartmentTree);

        int databaseSizeBeforeUpdate = uucDepartmentTreeRepository.findAll().size();

        // Update the uucDepartmentTree
        UucDepartmentTree updatedUucDepartmentTree = uucDepartmentTreeRepository.findById(uucDepartmentTree.getId()).get();
        // Disconnect from session so that the updates on updatedUucDepartmentTree are not directly saved in db
        em.detach(updatedUucDepartmentTree);
        updatedUucDepartmentTree
            .name(UPDATED_NAME)
            .namePy(UPDATED_NAME_PY)
            .code(UPDATED_CODE)
            .parentDepId(UPDATED_PARENT_DEP_ID)
            .parentDepName(UPDATED_PARENT_DEP_NAME)
            .status(UPDATED_STATUS)
            .disporder(UPDATED_DISPORDER)
            .namePath(UPDATED_NAME_PATH)
            .codePath(UPDATED_CODE_PATH)
            .depIdPath(UPDATED_DEP_ID_PATH)
            .depLevel(UPDATED_DEP_LEVEL)
            .aliveFlag(UPDATED_ALIVE_FLAG)
            .recCreateTime(UPDATED_REC_CREATE_TIME)
            .recCreator(UPDATED_REC_CREATOR)
            .recReviseTime(UPDATED_REC_REVISE_TIME)
            .recRevisor(UPDATED_REC_REVISOR)
            .deptUserCount(UPDATED_DEPT_USER_COUNT)
            .microappId(UPDATED_MICROAPP_ID)
            .enName(UPDATED_EN_NAME)
            .onlyCode(UPDATED_ONLY_CODE)
            .srcDeptId(UPDATED_SRC_DEPT_ID)
            .srcDeptType(UPDATED_SRC_DEPT_TYPE)
            .srcType(UPDATED_SRC_TYPE)
            .srcDeptUcode(UPDATED_SRC_DEPT_UCODE);

        restUucDepartmentTreeMockMvc.perform(put("/api/uuc-department-trees")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedUucDepartmentTree)))
            .andExpect(status().isOk());

        // Validate the UucDepartmentTree in the database
        List<UucDepartmentTree> uucDepartmentTreeList = uucDepartmentTreeRepository.findAll();
        assertThat(uucDepartmentTreeList).hasSize(databaseSizeBeforeUpdate);
        UucDepartmentTree testUucDepartmentTree = uucDepartmentTreeList.get(uucDepartmentTreeList.size() - 1);
        assertThat(testUucDepartmentTree.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testUucDepartmentTree.getNamePy()).isEqualTo(UPDATED_NAME_PY);
        assertThat(testUucDepartmentTree.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testUucDepartmentTree.getParentDepId()).isEqualTo(UPDATED_PARENT_DEP_ID);
        assertThat(testUucDepartmentTree.getParentDepName()).isEqualTo(UPDATED_PARENT_DEP_NAME);
        assertThat(testUucDepartmentTree.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testUucDepartmentTree.getDisporder()).isEqualTo(UPDATED_DISPORDER);
        assertThat(testUucDepartmentTree.getNamePath()).isEqualTo(UPDATED_NAME_PATH);
        assertThat(testUucDepartmentTree.getCodePath()).isEqualTo(UPDATED_CODE_PATH);
        assertThat(testUucDepartmentTree.getDepIdPath()).isEqualTo(UPDATED_DEP_ID_PATH);
        assertThat(testUucDepartmentTree.getDepLevel()).isEqualTo(UPDATED_DEP_LEVEL);
        assertThat(testUucDepartmentTree.getAliveFlag()).isEqualTo(UPDATED_ALIVE_FLAG);
        assertThat(testUucDepartmentTree.getRecCreateTime()).isEqualTo(UPDATED_REC_CREATE_TIME);
        assertThat(testUucDepartmentTree.getRecCreator()).isEqualTo(UPDATED_REC_CREATOR);
        assertThat(testUucDepartmentTree.getRecReviseTime()).isEqualTo(UPDATED_REC_REVISE_TIME);
        assertThat(testUucDepartmentTree.getRecRevisor()).isEqualTo(UPDATED_REC_REVISOR);
        assertThat(testUucDepartmentTree.getDeptUserCount()).isEqualTo(UPDATED_DEPT_USER_COUNT);
        assertThat(testUucDepartmentTree.getMicroappId()).isEqualTo(UPDATED_MICROAPP_ID);
        assertThat(testUucDepartmentTree.getEnName()).isEqualTo(UPDATED_EN_NAME);
        assertThat(testUucDepartmentTree.getOnlyCode()).isEqualTo(UPDATED_ONLY_CODE);
        assertThat(testUucDepartmentTree.getSrcDeptId()).isEqualTo(UPDATED_SRC_DEPT_ID);
        assertThat(testUucDepartmentTree.getSrcDeptType()).isEqualTo(UPDATED_SRC_DEPT_TYPE);
        assertThat(testUucDepartmentTree.getSrcType()).isEqualTo(UPDATED_SRC_TYPE);
        assertThat(testUucDepartmentTree.getSrcDeptUcode()).isEqualTo(UPDATED_SRC_DEPT_UCODE);
    }

    @Test
    @Transactional
    public void updateNonExistingUucDepartmentTree() throws Exception {
        int databaseSizeBeforeUpdate = uucDepartmentTreeRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restUucDepartmentTreeMockMvc.perform(put("/api/uuc-department-trees")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(uucDepartmentTree)))
            .andExpect(status().isBadRequest());

        // Validate the UucDepartmentTree in the database
        List<UucDepartmentTree> uucDepartmentTreeList = uucDepartmentTreeRepository.findAll();
        assertThat(uucDepartmentTreeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteUucDepartmentTree() throws Exception {
        // Initialize the database
        uucDepartmentTreeService.save(uucDepartmentTree);

        int databaseSizeBeforeDelete = uucDepartmentTreeRepository.findAll().size();

        // Delete the uucDepartmentTree
        restUucDepartmentTreeMockMvc.perform(delete("/api/uuc-department-trees/{id}", uucDepartmentTree.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<UucDepartmentTree> uucDepartmentTreeList = uucDepartmentTreeRepository.findAll();
        assertThat(uucDepartmentTreeList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
