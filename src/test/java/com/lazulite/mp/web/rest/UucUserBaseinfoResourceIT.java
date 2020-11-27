package com.lazulite.mp.web.rest;

import com.lazulite.mp.JhipsterSampleApplication20201127App;
import com.lazulite.mp.domain.UucUserBaseinfo;
import com.lazulite.mp.domain.FmpMicroApp;
import com.lazulite.mp.domain.MicroAppGroup;
import com.lazulite.mp.repository.UucUserBaseinfoRepository;
import com.lazulite.mp.service.UucUserBaseinfoService;
import com.lazulite.mp.service.dto.UucUserBaseinfoCriteria;
import com.lazulite.mp.service.UucUserBaseinfoQueryService;

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
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link UucUserBaseinfoResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplication20201127App.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
public class UucUserBaseinfoResourceIT {

    private static final String DEFAULT_JOB_CODE = "AAAAAAAAAA";
    private static final String UPDATED_JOB_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_FULLNAME = "AAAAAAAAAA";
    private static final String UPDATED_FULLNAME = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_PY = "AAAAAAAAAA";
    private static final String UPDATED_NAME_PY = "BBBBBBBBBB";

    private static final String DEFAULT_SEX = "AAAAAAAAAA";
    private static final String UPDATED_SEX = "BBBBBBBBBB";

    private static final String DEFAULT_BIRTHDAY = "AAAAAAAAAA";
    private static final String UPDATED_BIRTHDAY = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_TEL = "AAAAAAAAAA";
    private static final String UPDATED_TEL = "BBBBBBBBBB";

    private static final String DEFAULT_TEL_EXT = "AAAAAAAAAA";
    private static final String UPDATED_TEL_EXT = "BBBBBBBBBB";

    private static final String DEFAULT_STATE_CODE_1 = "AAAAAAAAAA";
    private static final String UPDATED_STATE_CODE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE_1 = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_STATE_CODE_2 = "AAAAAAAAAA";
    private static final String UPDATED_STATE_CODE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE_2 = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_STATE_CODE_3 = "AAAAAAAAAA";
    private static final String UPDATED_STATE_CODE_3 = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE_3 = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_3 = "BBBBBBBBBB";

    private static final String DEFAULT_STATE_CODE_4 = "AAAAAAAAAA";
    private static final String UPDATED_STATE_CODE_4 = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE_4 = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_4 = "BBBBBBBBBB";

    private static final String DEFAULT_STATE_CODE_5 = "AAAAAAAAAA";
    private static final String UPDATED_STATE_CODE_5 = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE_5 = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_5 = "BBBBBBBBBB";

    private static final String DEFAULT_TITLE_DESC = "AAAAAAAAAA";
    private static final String UPDATED_TITLE_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_TITLE_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITLE_EN = "BBBBBBBBBB";

    private static final String DEFAULT_CHECK_NUM = "AAAAAAAAAA";
    private static final String UPDATED_CHECK_NUM = "BBBBBBBBBB";

    private static final Integer DEFAULT_DISPORDER = 1;
    private static final Integer UPDATED_DISPORDER = 2;
    private static final Integer SMALLER_DISPORDER = 1 - 1;

    private static final String DEFAULT_WORK_PLACE = "AAAAAAAAAA";
    private static final String UPDATED_WORK_PLACE = "BBBBBBBBBB";

    private static final String DEFAULT_USER_LEVEL = "AAAAAAAAAA";
    private static final String UPDATED_USER_LEVEL = "BBBBBBBBBB";

    private static final Instant DEFAULT_HIREDATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_HIREDATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_NICKNAME = "AAAAAAAAAA";
    private static final String UPDATED_NICKNAME = "BBBBBBBBBB";

    private static final String DEFAULT_MEMO = "AAAAAAAAAA";
    private static final String UPDATED_MEMO = "BBBBBBBBBB";

    private static final String DEFAULT_IS_HIDDEN = "AAAAAAAAAA";
    private static final String UPDATED_IS_HIDDEN = "BBBBBBBBBB";

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

    private static final String DEFAULT_IS_ACTIVATED = "AAAAAAAAAA";
    private static final String UPDATED_IS_ACTIVATED = "BBBBBBBBBB";

    private static final Instant DEFAULT_ACTIVATION_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_ACTIVATION_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_APP_VERSION = "AAAAAAAAAA";
    private static final String UPDATED_APP_VERSION = "BBBBBBBBBB";

    private static final String DEFAULT_IS_ONLY_ADMIN_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_IS_ONLY_ADMIN_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_JOBNUMBER = "AAAAAAAAAA";
    private static final String UPDATED_JOBNUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_AVATAR = "AAAAAAAAAA";
    private static final String UPDATED_AVATAR = "BBBBBBBBBB";

    private static final String DEFAULT_EN_NAME = "AAAAAAAAAA";
    private static final String UPDATED_EN_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EN_WORKPLACE = "AAAAAAAAAA";
    private static final String UPDATED_EN_WORKPLACE = "BBBBBBBBBB";

    private static final String DEFAULT_EN_TITLE_DESC = "AAAAAAAAAA";
    private static final String UPDATED_EN_TITLE_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_ONLY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ONLY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_HR_CARD_ID = "AAAAAAAAAA";
    private static final String UPDATED_HR_CARD_ID = "BBBBBBBBBB";

    private static final String DEFAULT_EMPLOYEE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_TYPE = "BBBBBBBBBB";

    @Autowired
    private UucUserBaseinfoRepository uucUserBaseinfoRepository;

    @Mock
    private UucUserBaseinfoRepository uucUserBaseinfoRepositoryMock;

    @Mock
    private UucUserBaseinfoService uucUserBaseinfoServiceMock;

    @Autowired
    private UucUserBaseinfoService uucUserBaseinfoService;

    @Autowired
    private UucUserBaseinfoQueryService uucUserBaseinfoQueryService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restUucUserBaseinfoMockMvc;

    private UucUserBaseinfo uucUserBaseinfo;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UucUserBaseinfo createEntity(EntityManager em) {
        UucUserBaseinfo uucUserBaseinfo = new UucUserBaseinfo()
            .jobCode(DEFAULT_JOB_CODE)
            .type(DEFAULT_TYPE)
            .fullname(DEFAULT_FULLNAME)
            .namePy(DEFAULT_NAME_PY)
            .sex(DEFAULT_SEX)
            .birthday(DEFAULT_BIRTHDAY)
            .email(DEFAULT_EMAIL)
            .tel(DEFAULT_TEL)
            .telExt(DEFAULT_TEL_EXT)
            .stateCode1(DEFAULT_STATE_CODE_1)
            .mobile1(DEFAULT_MOBILE_1)
            .stateCode2(DEFAULT_STATE_CODE_2)
            .mobile2(DEFAULT_MOBILE_2)
            .stateCode3(DEFAULT_STATE_CODE_3)
            .mobile3(DEFAULT_MOBILE_3)
            .stateCode4(DEFAULT_STATE_CODE_4)
            .mobile4(DEFAULT_MOBILE_4)
            .stateCode5(DEFAULT_STATE_CODE_5)
            .mobile5(DEFAULT_MOBILE_5)
            .titleDesc(DEFAULT_TITLE_DESC)
            .titleEn(DEFAULT_TITLE_EN)
            .checkNum(DEFAULT_CHECK_NUM)
            .disporder(DEFAULT_DISPORDER)
            .workPlace(DEFAULT_WORK_PLACE)
            .userLevel(DEFAULT_USER_LEVEL)
            .hiredate(DEFAULT_HIREDATE)
            .nickname(DEFAULT_NICKNAME)
            .memo(DEFAULT_MEMO)
            .isHidden(DEFAULT_IS_HIDDEN)
            .aliveFlag(DEFAULT_ALIVE_FLAG)
            .recCreateTime(DEFAULT_REC_CREATE_TIME)
            .recCreator(DEFAULT_REC_CREATOR)
            .recReviseTime(DEFAULT_REC_REVISE_TIME)
            .recRevisor(DEFAULT_REC_REVISOR)
            .isActivated(DEFAULT_IS_ACTIVATED)
            .activationTime(DEFAULT_ACTIVATION_TIME)
            .appVersion(DEFAULT_APP_VERSION)
            .isOnlyAdminTitle(DEFAULT_IS_ONLY_ADMIN_TITLE)
            .jobnumber(DEFAULT_JOBNUMBER)
            .avatar(DEFAULT_AVATAR)
            .enName(DEFAULT_EN_NAME)
            .enWorkplace(DEFAULT_EN_WORKPLACE)
            .enTitleDesc(DEFAULT_EN_TITLE_DESC)
            .onlyCode(DEFAULT_ONLY_CODE)
            .hrCardId(DEFAULT_HR_CARD_ID)
            .employeeType(DEFAULT_EMPLOYEE_TYPE);
        return uucUserBaseinfo;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UucUserBaseinfo createUpdatedEntity(EntityManager em) {
        UucUserBaseinfo uucUserBaseinfo = new UucUserBaseinfo()
            .jobCode(UPDATED_JOB_CODE)
            .type(UPDATED_TYPE)
            .fullname(UPDATED_FULLNAME)
            .namePy(UPDATED_NAME_PY)
            .sex(UPDATED_SEX)
            .birthday(UPDATED_BIRTHDAY)
            .email(UPDATED_EMAIL)
            .tel(UPDATED_TEL)
            .telExt(UPDATED_TEL_EXT)
            .stateCode1(UPDATED_STATE_CODE_1)
            .mobile1(UPDATED_MOBILE_1)
            .stateCode2(UPDATED_STATE_CODE_2)
            .mobile2(UPDATED_MOBILE_2)
            .stateCode3(UPDATED_STATE_CODE_3)
            .mobile3(UPDATED_MOBILE_3)
            .stateCode4(UPDATED_STATE_CODE_4)
            .mobile4(UPDATED_MOBILE_4)
            .stateCode5(UPDATED_STATE_CODE_5)
            .mobile5(UPDATED_MOBILE_5)
            .titleDesc(UPDATED_TITLE_DESC)
            .titleEn(UPDATED_TITLE_EN)
            .checkNum(UPDATED_CHECK_NUM)
            .disporder(UPDATED_DISPORDER)
            .workPlace(UPDATED_WORK_PLACE)
            .userLevel(UPDATED_USER_LEVEL)
            .hiredate(UPDATED_HIREDATE)
            .nickname(UPDATED_NICKNAME)
            .memo(UPDATED_MEMO)
            .isHidden(UPDATED_IS_HIDDEN)
            .aliveFlag(UPDATED_ALIVE_FLAG)
            .recCreateTime(UPDATED_REC_CREATE_TIME)
            .recCreator(UPDATED_REC_CREATOR)
            .recReviseTime(UPDATED_REC_REVISE_TIME)
            .recRevisor(UPDATED_REC_REVISOR)
            .isActivated(UPDATED_IS_ACTIVATED)
            .activationTime(UPDATED_ACTIVATION_TIME)
            .appVersion(UPDATED_APP_VERSION)
            .isOnlyAdminTitle(UPDATED_IS_ONLY_ADMIN_TITLE)
            .jobnumber(UPDATED_JOBNUMBER)
            .avatar(UPDATED_AVATAR)
            .enName(UPDATED_EN_NAME)
            .enWorkplace(UPDATED_EN_WORKPLACE)
            .enTitleDesc(UPDATED_EN_TITLE_DESC)
            .onlyCode(UPDATED_ONLY_CODE)
            .hrCardId(UPDATED_HR_CARD_ID)
            .employeeType(UPDATED_EMPLOYEE_TYPE);
        return uucUserBaseinfo;
    }

    @BeforeEach
    public void initTest() {
        uucUserBaseinfo = createEntity(em);
    }

    @Test
    @Transactional
    public void createUucUserBaseinfo() throws Exception {
        int databaseSizeBeforeCreate = uucUserBaseinfoRepository.findAll().size();
        // Create the UucUserBaseinfo
        restUucUserBaseinfoMockMvc.perform(post("/api/uuc-user-baseinfos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(uucUserBaseinfo)))
            .andExpect(status().isCreated());

        // Validate the UucUserBaseinfo in the database
        List<UucUserBaseinfo> uucUserBaseinfoList = uucUserBaseinfoRepository.findAll();
        assertThat(uucUserBaseinfoList).hasSize(databaseSizeBeforeCreate + 1);
        UucUserBaseinfo testUucUserBaseinfo = uucUserBaseinfoList.get(uucUserBaseinfoList.size() - 1);
        assertThat(testUucUserBaseinfo.getJobCode()).isEqualTo(DEFAULT_JOB_CODE);
        assertThat(testUucUserBaseinfo.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testUucUserBaseinfo.getFullname()).isEqualTo(DEFAULT_FULLNAME);
        assertThat(testUucUserBaseinfo.getNamePy()).isEqualTo(DEFAULT_NAME_PY);
        assertThat(testUucUserBaseinfo.getSex()).isEqualTo(DEFAULT_SEX);
        assertThat(testUucUserBaseinfo.getBirthday()).isEqualTo(DEFAULT_BIRTHDAY);
        assertThat(testUucUserBaseinfo.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testUucUserBaseinfo.getTel()).isEqualTo(DEFAULT_TEL);
        assertThat(testUucUserBaseinfo.getTelExt()).isEqualTo(DEFAULT_TEL_EXT);
        assertThat(testUucUserBaseinfo.getStateCode1()).isEqualTo(DEFAULT_STATE_CODE_1);
        assertThat(testUucUserBaseinfo.getMobile1()).isEqualTo(DEFAULT_MOBILE_1);
        assertThat(testUucUserBaseinfo.getStateCode2()).isEqualTo(DEFAULT_STATE_CODE_2);
        assertThat(testUucUserBaseinfo.getMobile2()).isEqualTo(DEFAULT_MOBILE_2);
        assertThat(testUucUserBaseinfo.getStateCode3()).isEqualTo(DEFAULT_STATE_CODE_3);
        assertThat(testUucUserBaseinfo.getMobile3()).isEqualTo(DEFAULT_MOBILE_3);
        assertThat(testUucUserBaseinfo.getStateCode4()).isEqualTo(DEFAULT_STATE_CODE_4);
        assertThat(testUucUserBaseinfo.getMobile4()).isEqualTo(DEFAULT_MOBILE_4);
        assertThat(testUucUserBaseinfo.getStateCode5()).isEqualTo(DEFAULT_STATE_CODE_5);
        assertThat(testUucUserBaseinfo.getMobile5()).isEqualTo(DEFAULT_MOBILE_5);
        assertThat(testUucUserBaseinfo.getTitleDesc()).isEqualTo(DEFAULT_TITLE_DESC);
        assertThat(testUucUserBaseinfo.getTitleEn()).isEqualTo(DEFAULT_TITLE_EN);
        assertThat(testUucUserBaseinfo.getCheckNum()).isEqualTo(DEFAULT_CHECK_NUM);
        assertThat(testUucUserBaseinfo.getDisporder()).isEqualTo(DEFAULT_DISPORDER);
        assertThat(testUucUserBaseinfo.getWorkPlace()).isEqualTo(DEFAULT_WORK_PLACE);
        assertThat(testUucUserBaseinfo.getUserLevel()).isEqualTo(DEFAULT_USER_LEVEL);
        assertThat(testUucUserBaseinfo.getHiredate()).isEqualTo(DEFAULT_HIREDATE);
        assertThat(testUucUserBaseinfo.getNickname()).isEqualTo(DEFAULT_NICKNAME);
        assertThat(testUucUserBaseinfo.getMemo()).isEqualTo(DEFAULT_MEMO);
        assertThat(testUucUserBaseinfo.getIsHidden()).isEqualTo(DEFAULT_IS_HIDDEN);
        assertThat(testUucUserBaseinfo.getAliveFlag()).isEqualTo(DEFAULT_ALIVE_FLAG);
        assertThat(testUucUserBaseinfo.getRecCreateTime()).isEqualTo(DEFAULT_REC_CREATE_TIME);
        assertThat(testUucUserBaseinfo.getRecCreator()).isEqualTo(DEFAULT_REC_CREATOR);
        assertThat(testUucUserBaseinfo.getRecReviseTime()).isEqualTo(DEFAULT_REC_REVISE_TIME);
        assertThat(testUucUserBaseinfo.getRecRevisor()).isEqualTo(DEFAULT_REC_REVISOR);
        assertThat(testUucUserBaseinfo.getIsActivated()).isEqualTo(DEFAULT_IS_ACTIVATED);
        assertThat(testUucUserBaseinfo.getActivationTime()).isEqualTo(DEFAULT_ACTIVATION_TIME);
        assertThat(testUucUserBaseinfo.getAppVersion()).isEqualTo(DEFAULT_APP_VERSION);
        assertThat(testUucUserBaseinfo.getIsOnlyAdminTitle()).isEqualTo(DEFAULT_IS_ONLY_ADMIN_TITLE);
        assertThat(testUucUserBaseinfo.getJobnumber()).isEqualTo(DEFAULT_JOBNUMBER);
        assertThat(testUucUserBaseinfo.getAvatar()).isEqualTo(DEFAULT_AVATAR);
        assertThat(testUucUserBaseinfo.getEnName()).isEqualTo(DEFAULT_EN_NAME);
        assertThat(testUucUserBaseinfo.getEnWorkplace()).isEqualTo(DEFAULT_EN_WORKPLACE);
        assertThat(testUucUserBaseinfo.getEnTitleDesc()).isEqualTo(DEFAULT_EN_TITLE_DESC);
        assertThat(testUucUserBaseinfo.getOnlyCode()).isEqualTo(DEFAULT_ONLY_CODE);
        assertThat(testUucUserBaseinfo.getHrCardId()).isEqualTo(DEFAULT_HR_CARD_ID);
        assertThat(testUucUserBaseinfo.getEmployeeType()).isEqualTo(DEFAULT_EMPLOYEE_TYPE);
    }

    @Test
    @Transactional
    public void createUucUserBaseinfoWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = uucUserBaseinfoRepository.findAll().size();

        // Create the UucUserBaseinfo with an existing ID
        uucUserBaseinfo.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restUucUserBaseinfoMockMvc.perform(post("/api/uuc-user-baseinfos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(uucUserBaseinfo)))
            .andExpect(status().isBadRequest());

        // Validate the UucUserBaseinfo in the database
        List<UucUserBaseinfo> uucUserBaseinfoList = uucUserBaseinfoRepository.findAll();
        assertThat(uucUserBaseinfoList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfos() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList
        restUucUserBaseinfoMockMvc.perform(get("/api/uuc-user-baseinfos?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(uucUserBaseinfo.getId().intValue())))
            .andExpect(jsonPath("$.[*].jobCode").value(hasItem(DEFAULT_JOB_CODE)))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)))
            .andExpect(jsonPath("$.[*].fullname").value(hasItem(DEFAULT_FULLNAME)))
            .andExpect(jsonPath("$.[*].namePy").value(hasItem(DEFAULT_NAME_PY)))
            .andExpect(jsonPath("$.[*].sex").value(hasItem(DEFAULT_SEX)))
            .andExpect(jsonPath("$.[*].birthday").value(hasItem(DEFAULT_BIRTHDAY)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].tel").value(hasItem(DEFAULT_TEL)))
            .andExpect(jsonPath("$.[*].telExt").value(hasItem(DEFAULT_TEL_EXT)))
            .andExpect(jsonPath("$.[*].stateCode1").value(hasItem(DEFAULT_STATE_CODE_1)))
            .andExpect(jsonPath("$.[*].mobile1").value(hasItem(DEFAULT_MOBILE_1)))
            .andExpect(jsonPath("$.[*].stateCode2").value(hasItem(DEFAULT_STATE_CODE_2)))
            .andExpect(jsonPath("$.[*].mobile2").value(hasItem(DEFAULT_MOBILE_2)))
            .andExpect(jsonPath("$.[*].stateCode3").value(hasItem(DEFAULT_STATE_CODE_3)))
            .andExpect(jsonPath("$.[*].mobile3").value(hasItem(DEFAULT_MOBILE_3)))
            .andExpect(jsonPath("$.[*].stateCode4").value(hasItem(DEFAULT_STATE_CODE_4)))
            .andExpect(jsonPath("$.[*].mobile4").value(hasItem(DEFAULT_MOBILE_4)))
            .andExpect(jsonPath("$.[*].stateCode5").value(hasItem(DEFAULT_STATE_CODE_5)))
            .andExpect(jsonPath("$.[*].mobile5").value(hasItem(DEFAULT_MOBILE_5)))
            .andExpect(jsonPath("$.[*].titleDesc").value(hasItem(DEFAULT_TITLE_DESC)))
            .andExpect(jsonPath("$.[*].titleEn").value(hasItem(DEFAULT_TITLE_EN)))
            .andExpect(jsonPath("$.[*].checkNum").value(hasItem(DEFAULT_CHECK_NUM)))
            .andExpect(jsonPath("$.[*].disporder").value(hasItem(DEFAULT_DISPORDER)))
            .andExpect(jsonPath("$.[*].workPlace").value(hasItem(DEFAULT_WORK_PLACE)))
            .andExpect(jsonPath("$.[*].userLevel").value(hasItem(DEFAULT_USER_LEVEL)))
            .andExpect(jsonPath("$.[*].hiredate").value(hasItem(DEFAULT_HIREDATE.toString())))
            .andExpect(jsonPath("$.[*].nickname").value(hasItem(DEFAULT_NICKNAME)))
            .andExpect(jsonPath("$.[*].memo").value(hasItem(DEFAULT_MEMO)))
            .andExpect(jsonPath("$.[*].isHidden").value(hasItem(DEFAULT_IS_HIDDEN)))
            .andExpect(jsonPath("$.[*].aliveFlag").value(hasItem(DEFAULT_ALIVE_FLAG)))
            .andExpect(jsonPath("$.[*].recCreateTime").value(hasItem(DEFAULT_REC_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].recCreator").value(hasItem(DEFAULT_REC_CREATOR)))
            .andExpect(jsonPath("$.[*].recReviseTime").value(hasItem(DEFAULT_REC_REVISE_TIME.toString())))
            .andExpect(jsonPath("$.[*].recRevisor").value(hasItem(DEFAULT_REC_REVISOR)))
            .andExpect(jsonPath("$.[*].isActivated").value(hasItem(DEFAULT_IS_ACTIVATED)))
            .andExpect(jsonPath("$.[*].activationTime").value(hasItem(DEFAULT_ACTIVATION_TIME.toString())))
            .andExpect(jsonPath("$.[*].appVersion").value(hasItem(DEFAULT_APP_VERSION)))
            .andExpect(jsonPath("$.[*].isOnlyAdminTitle").value(hasItem(DEFAULT_IS_ONLY_ADMIN_TITLE)))
            .andExpect(jsonPath("$.[*].jobnumber").value(hasItem(DEFAULT_JOBNUMBER)))
            .andExpect(jsonPath("$.[*].avatar").value(hasItem(DEFAULT_AVATAR)))
            .andExpect(jsonPath("$.[*].enName").value(hasItem(DEFAULT_EN_NAME)))
            .andExpect(jsonPath("$.[*].enWorkplace").value(hasItem(DEFAULT_EN_WORKPLACE)))
            .andExpect(jsonPath("$.[*].enTitleDesc").value(hasItem(DEFAULT_EN_TITLE_DESC)))
            .andExpect(jsonPath("$.[*].onlyCode").value(hasItem(DEFAULT_ONLY_CODE)))
            .andExpect(jsonPath("$.[*].hrCardId").value(hasItem(DEFAULT_HR_CARD_ID)))
            .andExpect(jsonPath("$.[*].employeeType").value(hasItem(DEFAULT_EMPLOYEE_TYPE)));
    }
    
    @SuppressWarnings({"unchecked"})
    public void getAllUucUserBaseinfosWithEagerRelationshipsIsEnabled() throws Exception {
        when(uucUserBaseinfoServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restUucUserBaseinfoMockMvc.perform(get("/api/uuc-user-baseinfos?eagerload=true"))
            .andExpect(status().isOk());

        verify(uucUserBaseinfoServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    @SuppressWarnings({"unchecked"})
    public void getAllUucUserBaseinfosWithEagerRelationshipsIsNotEnabled() throws Exception {
        when(uucUserBaseinfoServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restUucUserBaseinfoMockMvc.perform(get("/api/uuc-user-baseinfos?eagerload=true"))
            .andExpect(status().isOk());

        verify(uucUserBaseinfoServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    @Test
    @Transactional
    public void getUucUserBaseinfo() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get the uucUserBaseinfo
        restUucUserBaseinfoMockMvc.perform(get("/api/uuc-user-baseinfos/{id}", uucUserBaseinfo.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(uucUserBaseinfo.getId().intValue()))
            .andExpect(jsonPath("$.jobCode").value(DEFAULT_JOB_CODE))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE))
            .andExpect(jsonPath("$.fullname").value(DEFAULT_FULLNAME))
            .andExpect(jsonPath("$.namePy").value(DEFAULT_NAME_PY))
            .andExpect(jsonPath("$.sex").value(DEFAULT_SEX))
            .andExpect(jsonPath("$.birthday").value(DEFAULT_BIRTHDAY))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.tel").value(DEFAULT_TEL))
            .andExpect(jsonPath("$.telExt").value(DEFAULT_TEL_EXT))
            .andExpect(jsonPath("$.stateCode1").value(DEFAULT_STATE_CODE_1))
            .andExpect(jsonPath("$.mobile1").value(DEFAULT_MOBILE_1))
            .andExpect(jsonPath("$.stateCode2").value(DEFAULT_STATE_CODE_2))
            .andExpect(jsonPath("$.mobile2").value(DEFAULT_MOBILE_2))
            .andExpect(jsonPath("$.stateCode3").value(DEFAULT_STATE_CODE_3))
            .andExpect(jsonPath("$.mobile3").value(DEFAULT_MOBILE_3))
            .andExpect(jsonPath("$.stateCode4").value(DEFAULT_STATE_CODE_4))
            .andExpect(jsonPath("$.mobile4").value(DEFAULT_MOBILE_4))
            .andExpect(jsonPath("$.stateCode5").value(DEFAULT_STATE_CODE_5))
            .andExpect(jsonPath("$.mobile5").value(DEFAULT_MOBILE_5))
            .andExpect(jsonPath("$.titleDesc").value(DEFAULT_TITLE_DESC))
            .andExpect(jsonPath("$.titleEn").value(DEFAULT_TITLE_EN))
            .andExpect(jsonPath("$.checkNum").value(DEFAULT_CHECK_NUM))
            .andExpect(jsonPath("$.disporder").value(DEFAULT_DISPORDER))
            .andExpect(jsonPath("$.workPlace").value(DEFAULT_WORK_PLACE))
            .andExpect(jsonPath("$.userLevel").value(DEFAULT_USER_LEVEL))
            .andExpect(jsonPath("$.hiredate").value(DEFAULT_HIREDATE.toString()))
            .andExpect(jsonPath("$.nickname").value(DEFAULT_NICKNAME))
            .andExpect(jsonPath("$.memo").value(DEFAULT_MEMO))
            .andExpect(jsonPath("$.isHidden").value(DEFAULT_IS_HIDDEN))
            .andExpect(jsonPath("$.aliveFlag").value(DEFAULT_ALIVE_FLAG))
            .andExpect(jsonPath("$.recCreateTime").value(DEFAULT_REC_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.recCreator").value(DEFAULT_REC_CREATOR))
            .andExpect(jsonPath("$.recReviseTime").value(DEFAULT_REC_REVISE_TIME.toString()))
            .andExpect(jsonPath("$.recRevisor").value(DEFAULT_REC_REVISOR))
            .andExpect(jsonPath("$.isActivated").value(DEFAULT_IS_ACTIVATED))
            .andExpect(jsonPath("$.activationTime").value(DEFAULT_ACTIVATION_TIME.toString()))
            .andExpect(jsonPath("$.appVersion").value(DEFAULT_APP_VERSION))
            .andExpect(jsonPath("$.isOnlyAdminTitle").value(DEFAULT_IS_ONLY_ADMIN_TITLE))
            .andExpect(jsonPath("$.jobnumber").value(DEFAULT_JOBNUMBER))
            .andExpect(jsonPath("$.avatar").value(DEFAULT_AVATAR))
            .andExpect(jsonPath("$.enName").value(DEFAULT_EN_NAME))
            .andExpect(jsonPath("$.enWorkplace").value(DEFAULT_EN_WORKPLACE))
            .andExpect(jsonPath("$.enTitleDesc").value(DEFAULT_EN_TITLE_DESC))
            .andExpect(jsonPath("$.onlyCode").value(DEFAULT_ONLY_CODE))
            .andExpect(jsonPath("$.hrCardId").value(DEFAULT_HR_CARD_ID))
            .andExpect(jsonPath("$.employeeType").value(DEFAULT_EMPLOYEE_TYPE));
    }


    @Test
    @Transactional
    public void getUucUserBaseinfosByIdFiltering() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        Long id = uucUserBaseinfo.getId();

        defaultUucUserBaseinfoShouldBeFound("id.equals=" + id);
        defaultUucUserBaseinfoShouldNotBeFound("id.notEquals=" + id);

        defaultUucUserBaseinfoShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultUucUserBaseinfoShouldNotBeFound("id.greaterThan=" + id);

        defaultUucUserBaseinfoShouldBeFound("id.lessThanOrEqual=" + id);
        defaultUucUserBaseinfoShouldNotBeFound("id.lessThan=" + id);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByJobCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where jobCode equals to DEFAULT_JOB_CODE
        defaultUucUserBaseinfoShouldBeFound("jobCode.equals=" + DEFAULT_JOB_CODE);

        // Get all the uucUserBaseinfoList where jobCode equals to UPDATED_JOB_CODE
        defaultUucUserBaseinfoShouldNotBeFound("jobCode.equals=" + UPDATED_JOB_CODE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByJobCodeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where jobCode not equals to DEFAULT_JOB_CODE
        defaultUucUserBaseinfoShouldNotBeFound("jobCode.notEquals=" + DEFAULT_JOB_CODE);

        // Get all the uucUserBaseinfoList where jobCode not equals to UPDATED_JOB_CODE
        defaultUucUserBaseinfoShouldBeFound("jobCode.notEquals=" + UPDATED_JOB_CODE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByJobCodeIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where jobCode in DEFAULT_JOB_CODE or UPDATED_JOB_CODE
        defaultUucUserBaseinfoShouldBeFound("jobCode.in=" + DEFAULT_JOB_CODE + "," + UPDATED_JOB_CODE);

        // Get all the uucUserBaseinfoList where jobCode equals to UPDATED_JOB_CODE
        defaultUucUserBaseinfoShouldNotBeFound("jobCode.in=" + UPDATED_JOB_CODE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByJobCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where jobCode is not null
        defaultUucUserBaseinfoShouldBeFound("jobCode.specified=true");

        // Get all the uucUserBaseinfoList where jobCode is null
        defaultUucUserBaseinfoShouldNotBeFound("jobCode.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByJobCodeContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where jobCode contains DEFAULT_JOB_CODE
        defaultUucUserBaseinfoShouldBeFound("jobCode.contains=" + DEFAULT_JOB_CODE);

        // Get all the uucUserBaseinfoList where jobCode contains UPDATED_JOB_CODE
        defaultUucUserBaseinfoShouldNotBeFound("jobCode.contains=" + UPDATED_JOB_CODE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByJobCodeNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where jobCode does not contain DEFAULT_JOB_CODE
        defaultUucUserBaseinfoShouldNotBeFound("jobCode.doesNotContain=" + DEFAULT_JOB_CODE);

        // Get all the uucUserBaseinfoList where jobCode does not contain UPDATED_JOB_CODE
        defaultUucUserBaseinfoShouldBeFound("jobCode.doesNotContain=" + UPDATED_JOB_CODE);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTypeIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where type equals to DEFAULT_TYPE
        defaultUucUserBaseinfoShouldBeFound("type.equals=" + DEFAULT_TYPE);

        // Get all the uucUserBaseinfoList where type equals to UPDATED_TYPE
        defaultUucUserBaseinfoShouldNotBeFound("type.equals=" + UPDATED_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTypeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where type not equals to DEFAULT_TYPE
        defaultUucUserBaseinfoShouldNotBeFound("type.notEquals=" + DEFAULT_TYPE);

        // Get all the uucUserBaseinfoList where type not equals to UPDATED_TYPE
        defaultUucUserBaseinfoShouldBeFound("type.notEquals=" + UPDATED_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTypeIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where type in DEFAULT_TYPE or UPDATED_TYPE
        defaultUucUserBaseinfoShouldBeFound("type.in=" + DEFAULT_TYPE + "," + UPDATED_TYPE);

        // Get all the uucUserBaseinfoList where type equals to UPDATED_TYPE
        defaultUucUserBaseinfoShouldNotBeFound("type.in=" + UPDATED_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where type is not null
        defaultUucUserBaseinfoShouldBeFound("type.specified=true");

        // Get all the uucUserBaseinfoList where type is null
        defaultUucUserBaseinfoShouldNotBeFound("type.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByTypeContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where type contains DEFAULT_TYPE
        defaultUucUserBaseinfoShouldBeFound("type.contains=" + DEFAULT_TYPE);

        // Get all the uucUserBaseinfoList where type contains UPDATED_TYPE
        defaultUucUserBaseinfoShouldNotBeFound("type.contains=" + UPDATED_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTypeNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where type does not contain DEFAULT_TYPE
        defaultUucUserBaseinfoShouldNotBeFound("type.doesNotContain=" + DEFAULT_TYPE);

        // Get all the uucUserBaseinfoList where type does not contain UPDATED_TYPE
        defaultUucUserBaseinfoShouldBeFound("type.doesNotContain=" + UPDATED_TYPE);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByFullnameIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where fullname equals to DEFAULT_FULLNAME
        defaultUucUserBaseinfoShouldBeFound("fullname.equals=" + DEFAULT_FULLNAME);

        // Get all the uucUserBaseinfoList where fullname equals to UPDATED_FULLNAME
        defaultUucUserBaseinfoShouldNotBeFound("fullname.equals=" + UPDATED_FULLNAME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByFullnameIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where fullname not equals to DEFAULT_FULLNAME
        defaultUucUserBaseinfoShouldNotBeFound("fullname.notEquals=" + DEFAULT_FULLNAME);

        // Get all the uucUserBaseinfoList where fullname not equals to UPDATED_FULLNAME
        defaultUucUserBaseinfoShouldBeFound("fullname.notEquals=" + UPDATED_FULLNAME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByFullnameIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where fullname in DEFAULT_FULLNAME or UPDATED_FULLNAME
        defaultUucUserBaseinfoShouldBeFound("fullname.in=" + DEFAULT_FULLNAME + "," + UPDATED_FULLNAME);

        // Get all the uucUserBaseinfoList where fullname equals to UPDATED_FULLNAME
        defaultUucUserBaseinfoShouldNotBeFound("fullname.in=" + UPDATED_FULLNAME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByFullnameIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where fullname is not null
        defaultUucUserBaseinfoShouldBeFound("fullname.specified=true");

        // Get all the uucUserBaseinfoList where fullname is null
        defaultUucUserBaseinfoShouldNotBeFound("fullname.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByFullnameContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where fullname contains DEFAULT_FULLNAME
        defaultUucUserBaseinfoShouldBeFound("fullname.contains=" + DEFAULT_FULLNAME);

        // Get all the uucUserBaseinfoList where fullname contains UPDATED_FULLNAME
        defaultUucUserBaseinfoShouldNotBeFound("fullname.contains=" + UPDATED_FULLNAME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByFullnameNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where fullname does not contain DEFAULT_FULLNAME
        defaultUucUserBaseinfoShouldNotBeFound("fullname.doesNotContain=" + DEFAULT_FULLNAME);

        // Get all the uucUserBaseinfoList where fullname does not contain UPDATED_FULLNAME
        defaultUucUserBaseinfoShouldBeFound("fullname.doesNotContain=" + UPDATED_FULLNAME);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByNamePyIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where namePy equals to DEFAULT_NAME_PY
        defaultUucUserBaseinfoShouldBeFound("namePy.equals=" + DEFAULT_NAME_PY);

        // Get all the uucUserBaseinfoList where namePy equals to UPDATED_NAME_PY
        defaultUucUserBaseinfoShouldNotBeFound("namePy.equals=" + UPDATED_NAME_PY);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByNamePyIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where namePy not equals to DEFAULT_NAME_PY
        defaultUucUserBaseinfoShouldNotBeFound("namePy.notEquals=" + DEFAULT_NAME_PY);

        // Get all the uucUserBaseinfoList where namePy not equals to UPDATED_NAME_PY
        defaultUucUserBaseinfoShouldBeFound("namePy.notEquals=" + UPDATED_NAME_PY);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByNamePyIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where namePy in DEFAULT_NAME_PY or UPDATED_NAME_PY
        defaultUucUserBaseinfoShouldBeFound("namePy.in=" + DEFAULT_NAME_PY + "," + UPDATED_NAME_PY);

        // Get all the uucUserBaseinfoList where namePy equals to UPDATED_NAME_PY
        defaultUucUserBaseinfoShouldNotBeFound("namePy.in=" + UPDATED_NAME_PY);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByNamePyIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where namePy is not null
        defaultUucUserBaseinfoShouldBeFound("namePy.specified=true");

        // Get all the uucUserBaseinfoList where namePy is null
        defaultUucUserBaseinfoShouldNotBeFound("namePy.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByNamePyContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where namePy contains DEFAULT_NAME_PY
        defaultUucUserBaseinfoShouldBeFound("namePy.contains=" + DEFAULT_NAME_PY);

        // Get all the uucUserBaseinfoList where namePy contains UPDATED_NAME_PY
        defaultUucUserBaseinfoShouldNotBeFound("namePy.contains=" + UPDATED_NAME_PY);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByNamePyNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where namePy does not contain DEFAULT_NAME_PY
        defaultUucUserBaseinfoShouldNotBeFound("namePy.doesNotContain=" + DEFAULT_NAME_PY);

        // Get all the uucUserBaseinfoList where namePy does not contain UPDATED_NAME_PY
        defaultUucUserBaseinfoShouldBeFound("namePy.doesNotContain=" + UPDATED_NAME_PY);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosBySexIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where sex equals to DEFAULT_SEX
        defaultUucUserBaseinfoShouldBeFound("sex.equals=" + DEFAULT_SEX);

        // Get all the uucUserBaseinfoList where sex equals to UPDATED_SEX
        defaultUucUserBaseinfoShouldNotBeFound("sex.equals=" + UPDATED_SEX);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosBySexIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where sex not equals to DEFAULT_SEX
        defaultUucUserBaseinfoShouldNotBeFound("sex.notEquals=" + DEFAULT_SEX);

        // Get all the uucUserBaseinfoList where sex not equals to UPDATED_SEX
        defaultUucUserBaseinfoShouldBeFound("sex.notEquals=" + UPDATED_SEX);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosBySexIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where sex in DEFAULT_SEX or UPDATED_SEX
        defaultUucUserBaseinfoShouldBeFound("sex.in=" + DEFAULT_SEX + "," + UPDATED_SEX);

        // Get all the uucUserBaseinfoList where sex equals to UPDATED_SEX
        defaultUucUserBaseinfoShouldNotBeFound("sex.in=" + UPDATED_SEX);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosBySexIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where sex is not null
        defaultUucUserBaseinfoShouldBeFound("sex.specified=true");

        // Get all the uucUserBaseinfoList where sex is null
        defaultUucUserBaseinfoShouldNotBeFound("sex.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosBySexContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where sex contains DEFAULT_SEX
        defaultUucUserBaseinfoShouldBeFound("sex.contains=" + DEFAULT_SEX);

        // Get all the uucUserBaseinfoList where sex contains UPDATED_SEX
        defaultUucUserBaseinfoShouldNotBeFound("sex.contains=" + UPDATED_SEX);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosBySexNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where sex does not contain DEFAULT_SEX
        defaultUucUserBaseinfoShouldNotBeFound("sex.doesNotContain=" + DEFAULT_SEX);

        // Get all the uucUserBaseinfoList where sex does not contain UPDATED_SEX
        defaultUucUserBaseinfoShouldBeFound("sex.doesNotContain=" + UPDATED_SEX);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByBirthdayIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where birthday equals to DEFAULT_BIRTHDAY
        defaultUucUserBaseinfoShouldBeFound("birthday.equals=" + DEFAULT_BIRTHDAY);

        // Get all the uucUserBaseinfoList where birthday equals to UPDATED_BIRTHDAY
        defaultUucUserBaseinfoShouldNotBeFound("birthday.equals=" + UPDATED_BIRTHDAY);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByBirthdayIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where birthday not equals to DEFAULT_BIRTHDAY
        defaultUucUserBaseinfoShouldNotBeFound("birthday.notEquals=" + DEFAULT_BIRTHDAY);

        // Get all the uucUserBaseinfoList where birthday not equals to UPDATED_BIRTHDAY
        defaultUucUserBaseinfoShouldBeFound("birthday.notEquals=" + UPDATED_BIRTHDAY);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByBirthdayIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where birthday in DEFAULT_BIRTHDAY or UPDATED_BIRTHDAY
        defaultUucUserBaseinfoShouldBeFound("birthday.in=" + DEFAULT_BIRTHDAY + "," + UPDATED_BIRTHDAY);

        // Get all the uucUserBaseinfoList where birthday equals to UPDATED_BIRTHDAY
        defaultUucUserBaseinfoShouldNotBeFound("birthday.in=" + UPDATED_BIRTHDAY);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByBirthdayIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where birthday is not null
        defaultUucUserBaseinfoShouldBeFound("birthday.specified=true");

        // Get all the uucUserBaseinfoList where birthday is null
        defaultUucUserBaseinfoShouldNotBeFound("birthday.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByBirthdayContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where birthday contains DEFAULT_BIRTHDAY
        defaultUucUserBaseinfoShouldBeFound("birthday.contains=" + DEFAULT_BIRTHDAY);

        // Get all the uucUserBaseinfoList where birthday contains UPDATED_BIRTHDAY
        defaultUucUserBaseinfoShouldNotBeFound("birthday.contains=" + UPDATED_BIRTHDAY);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByBirthdayNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where birthday does not contain DEFAULT_BIRTHDAY
        defaultUucUserBaseinfoShouldNotBeFound("birthday.doesNotContain=" + DEFAULT_BIRTHDAY);

        // Get all the uucUserBaseinfoList where birthday does not contain UPDATED_BIRTHDAY
        defaultUucUserBaseinfoShouldBeFound("birthday.doesNotContain=" + UPDATED_BIRTHDAY);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEmailIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where email equals to DEFAULT_EMAIL
        defaultUucUserBaseinfoShouldBeFound("email.equals=" + DEFAULT_EMAIL);

        // Get all the uucUserBaseinfoList where email equals to UPDATED_EMAIL
        defaultUucUserBaseinfoShouldNotBeFound("email.equals=" + UPDATED_EMAIL);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEmailIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where email not equals to DEFAULT_EMAIL
        defaultUucUserBaseinfoShouldNotBeFound("email.notEquals=" + DEFAULT_EMAIL);

        // Get all the uucUserBaseinfoList where email not equals to UPDATED_EMAIL
        defaultUucUserBaseinfoShouldBeFound("email.notEquals=" + UPDATED_EMAIL);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEmailIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where email in DEFAULT_EMAIL or UPDATED_EMAIL
        defaultUucUserBaseinfoShouldBeFound("email.in=" + DEFAULT_EMAIL + "," + UPDATED_EMAIL);

        // Get all the uucUserBaseinfoList where email equals to UPDATED_EMAIL
        defaultUucUserBaseinfoShouldNotBeFound("email.in=" + UPDATED_EMAIL);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEmailIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where email is not null
        defaultUucUserBaseinfoShouldBeFound("email.specified=true");

        // Get all the uucUserBaseinfoList where email is null
        defaultUucUserBaseinfoShouldNotBeFound("email.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByEmailContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where email contains DEFAULT_EMAIL
        defaultUucUserBaseinfoShouldBeFound("email.contains=" + DEFAULT_EMAIL);

        // Get all the uucUserBaseinfoList where email contains UPDATED_EMAIL
        defaultUucUserBaseinfoShouldNotBeFound("email.contains=" + UPDATED_EMAIL);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEmailNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where email does not contain DEFAULT_EMAIL
        defaultUucUserBaseinfoShouldNotBeFound("email.doesNotContain=" + DEFAULT_EMAIL);

        // Get all the uucUserBaseinfoList where email does not contain UPDATED_EMAIL
        defaultUucUserBaseinfoShouldBeFound("email.doesNotContain=" + UPDATED_EMAIL);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTelIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where tel equals to DEFAULT_TEL
        defaultUucUserBaseinfoShouldBeFound("tel.equals=" + DEFAULT_TEL);

        // Get all the uucUserBaseinfoList where tel equals to UPDATED_TEL
        defaultUucUserBaseinfoShouldNotBeFound("tel.equals=" + UPDATED_TEL);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTelIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where tel not equals to DEFAULT_TEL
        defaultUucUserBaseinfoShouldNotBeFound("tel.notEquals=" + DEFAULT_TEL);

        // Get all the uucUserBaseinfoList where tel not equals to UPDATED_TEL
        defaultUucUserBaseinfoShouldBeFound("tel.notEquals=" + UPDATED_TEL);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTelIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where tel in DEFAULT_TEL or UPDATED_TEL
        defaultUucUserBaseinfoShouldBeFound("tel.in=" + DEFAULT_TEL + "," + UPDATED_TEL);

        // Get all the uucUserBaseinfoList where tel equals to UPDATED_TEL
        defaultUucUserBaseinfoShouldNotBeFound("tel.in=" + UPDATED_TEL);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTelIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where tel is not null
        defaultUucUserBaseinfoShouldBeFound("tel.specified=true");

        // Get all the uucUserBaseinfoList where tel is null
        defaultUucUserBaseinfoShouldNotBeFound("tel.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByTelContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where tel contains DEFAULT_TEL
        defaultUucUserBaseinfoShouldBeFound("tel.contains=" + DEFAULT_TEL);

        // Get all the uucUserBaseinfoList where tel contains UPDATED_TEL
        defaultUucUserBaseinfoShouldNotBeFound("tel.contains=" + UPDATED_TEL);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTelNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where tel does not contain DEFAULT_TEL
        defaultUucUserBaseinfoShouldNotBeFound("tel.doesNotContain=" + DEFAULT_TEL);

        // Get all the uucUserBaseinfoList where tel does not contain UPDATED_TEL
        defaultUucUserBaseinfoShouldBeFound("tel.doesNotContain=" + UPDATED_TEL);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTelExtIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where telExt equals to DEFAULT_TEL_EXT
        defaultUucUserBaseinfoShouldBeFound("telExt.equals=" + DEFAULT_TEL_EXT);

        // Get all the uucUserBaseinfoList where telExt equals to UPDATED_TEL_EXT
        defaultUucUserBaseinfoShouldNotBeFound("telExt.equals=" + UPDATED_TEL_EXT);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTelExtIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where telExt not equals to DEFAULT_TEL_EXT
        defaultUucUserBaseinfoShouldNotBeFound("telExt.notEquals=" + DEFAULT_TEL_EXT);

        // Get all the uucUserBaseinfoList where telExt not equals to UPDATED_TEL_EXT
        defaultUucUserBaseinfoShouldBeFound("telExt.notEquals=" + UPDATED_TEL_EXT);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTelExtIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where telExt in DEFAULT_TEL_EXT or UPDATED_TEL_EXT
        defaultUucUserBaseinfoShouldBeFound("telExt.in=" + DEFAULT_TEL_EXT + "," + UPDATED_TEL_EXT);

        // Get all the uucUserBaseinfoList where telExt equals to UPDATED_TEL_EXT
        defaultUucUserBaseinfoShouldNotBeFound("telExt.in=" + UPDATED_TEL_EXT);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTelExtIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where telExt is not null
        defaultUucUserBaseinfoShouldBeFound("telExt.specified=true");

        // Get all the uucUserBaseinfoList where telExt is null
        defaultUucUserBaseinfoShouldNotBeFound("telExt.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByTelExtContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where telExt contains DEFAULT_TEL_EXT
        defaultUucUserBaseinfoShouldBeFound("telExt.contains=" + DEFAULT_TEL_EXT);

        // Get all the uucUserBaseinfoList where telExt contains UPDATED_TEL_EXT
        defaultUucUserBaseinfoShouldNotBeFound("telExt.contains=" + UPDATED_TEL_EXT);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTelExtNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where telExt does not contain DEFAULT_TEL_EXT
        defaultUucUserBaseinfoShouldNotBeFound("telExt.doesNotContain=" + DEFAULT_TEL_EXT);

        // Get all the uucUserBaseinfoList where telExt does not contain UPDATED_TEL_EXT
        defaultUucUserBaseinfoShouldBeFound("telExt.doesNotContain=" + UPDATED_TEL_EXT);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode1IsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode1 equals to DEFAULT_STATE_CODE_1
        defaultUucUserBaseinfoShouldBeFound("stateCode1.equals=" + DEFAULT_STATE_CODE_1);

        // Get all the uucUserBaseinfoList where stateCode1 equals to UPDATED_STATE_CODE_1
        defaultUucUserBaseinfoShouldNotBeFound("stateCode1.equals=" + UPDATED_STATE_CODE_1);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode1IsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode1 not equals to DEFAULT_STATE_CODE_1
        defaultUucUserBaseinfoShouldNotBeFound("stateCode1.notEquals=" + DEFAULT_STATE_CODE_1);

        // Get all the uucUserBaseinfoList where stateCode1 not equals to UPDATED_STATE_CODE_1
        defaultUucUserBaseinfoShouldBeFound("stateCode1.notEquals=" + UPDATED_STATE_CODE_1);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode1IsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode1 in DEFAULT_STATE_CODE_1 or UPDATED_STATE_CODE_1
        defaultUucUserBaseinfoShouldBeFound("stateCode1.in=" + DEFAULT_STATE_CODE_1 + "," + UPDATED_STATE_CODE_1);

        // Get all the uucUserBaseinfoList where stateCode1 equals to UPDATED_STATE_CODE_1
        defaultUucUserBaseinfoShouldNotBeFound("stateCode1.in=" + UPDATED_STATE_CODE_1);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode1IsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode1 is not null
        defaultUucUserBaseinfoShouldBeFound("stateCode1.specified=true");

        // Get all the uucUserBaseinfoList where stateCode1 is null
        defaultUucUserBaseinfoShouldNotBeFound("stateCode1.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode1ContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode1 contains DEFAULT_STATE_CODE_1
        defaultUucUserBaseinfoShouldBeFound("stateCode1.contains=" + DEFAULT_STATE_CODE_1);

        // Get all the uucUserBaseinfoList where stateCode1 contains UPDATED_STATE_CODE_1
        defaultUucUserBaseinfoShouldNotBeFound("stateCode1.contains=" + UPDATED_STATE_CODE_1);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode1NotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode1 does not contain DEFAULT_STATE_CODE_1
        defaultUucUserBaseinfoShouldNotBeFound("stateCode1.doesNotContain=" + DEFAULT_STATE_CODE_1);

        // Get all the uucUserBaseinfoList where stateCode1 does not contain UPDATED_STATE_CODE_1
        defaultUucUserBaseinfoShouldBeFound("stateCode1.doesNotContain=" + UPDATED_STATE_CODE_1);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile1IsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile1 equals to DEFAULT_MOBILE_1
        defaultUucUserBaseinfoShouldBeFound("mobile1.equals=" + DEFAULT_MOBILE_1);

        // Get all the uucUserBaseinfoList where mobile1 equals to UPDATED_MOBILE_1
        defaultUucUserBaseinfoShouldNotBeFound("mobile1.equals=" + UPDATED_MOBILE_1);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile1IsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile1 not equals to DEFAULT_MOBILE_1
        defaultUucUserBaseinfoShouldNotBeFound("mobile1.notEquals=" + DEFAULT_MOBILE_1);

        // Get all the uucUserBaseinfoList where mobile1 not equals to UPDATED_MOBILE_1
        defaultUucUserBaseinfoShouldBeFound("mobile1.notEquals=" + UPDATED_MOBILE_1);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile1IsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile1 in DEFAULT_MOBILE_1 or UPDATED_MOBILE_1
        defaultUucUserBaseinfoShouldBeFound("mobile1.in=" + DEFAULT_MOBILE_1 + "," + UPDATED_MOBILE_1);

        // Get all the uucUserBaseinfoList where mobile1 equals to UPDATED_MOBILE_1
        defaultUucUserBaseinfoShouldNotBeFound("mobile1.in=" + UPDATED_MOBILE_1);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile1IsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile1 is not null
        defaultUucUserBaseinfoShouldBeFound("mobile1.specified=true");

        // Get all the uucUserBaseinfoList where mobile1 is null
        defaultUucUserBaseinfoShouldNotBeFound("mobile1.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile1ContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile1 contains DEFAULT_MOBILE_1
        defaultUucUserBaseinfoShouldBeFound("mobile1.contains=" + DEFAULT_MOBILE_1);

        // Get all the uucUserBaseinfoList where mobile1 contains UPDATED_MOBILE_1
        defaultUucUserBaseinfoShouldNotBeFound("mobile1.contains=" + UPDATED_MOBILE_1);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile1NotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile1 does not contain DEFAULT_MOBILE_1
        defaultUucUserBaseinfoShouldNotBeFound("mobile1.doesNotContain=" + DEFAULT_MOBILE_1);

        // Get all the uucUserBaseinfoList where mobile1 does not contain UPDATED_MOBILE_1
        defaultUucUserBaseinfoShouldBeFound("mobile1.doesNotContain=" + UPDATED_MOBILE_1);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode2IsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode2 equals to DEFAULT_STATE_CODE_2
        defaultUucUserBaseinfoShouldBeFound("stateCode2.equals=" + DEFAULT_STATE_CODE_2);

        // Get all the uucUserBaseinfoList where stateCode2 equals to UPDATED_STATE_CODE_2
        defaultUucUserBaseinfoShouldNotBeFound("stateCode2.equals=" + UPDATED_STATE_CODE_2);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode2IsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode2 not equals to DEFAULT_STATE_CODE_2
        defaultUucUserBaseinfoShouldNotBeFound("stateCode2.notEquals=" + DEFAULT_STATE_CODE_2);

        // Get all the uucUserBaseinfoList where stateCode2 not equals to UPDATED_STATE_CODE_2
        defaultUucUserBaseinfoShouldBeFound("stateCode2.notEquals=" + UPDATED_STATE_CODE_2);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode2IsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode2 in DEFAULT_STATE_CODE_2 or UPDATED_STATE_CODE_2
        defaultUucUserBaseinfoShouldBeFound("stateCode2.in=" + DEFAULT_STATE_CODE_2 + "," + UPDATED_STATE_CODE_2);

        // Get all the uucUserBaseinfoList where stateCode2 equals to UPDATED_STATE_CODE_2
        defaultUucUserBaseinfoShouldNotBeFound("stateCode2.in=" + UPDATED_STATE_CODE_2);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode2IsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode2 is not null
        defaultUucUserBaseinfoShouldBeFound("stateCode2.specified=true");

        // Get all the uucUserBaseinfoList where stateCode2 is null
        defaultUucUserBaseinfoShouldNotBeFound("stateCode2.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode2ContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode2 contains DEFAULT_STATE_CODE_2
        defaultUucUserBaseinfoShouldBeFound("stateCode2.contains=" + DEFAULT_STATE_CODE_2);

        // Get all the uucUserBaseinfoList where stateCode2 contains UPDATED_STATE_CODE_2
        defaultUucUserBaseinfoShouldNotBeFound("stateCode2.contains=" + UPDATED_STATE_CODE_2);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode2NotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode2 does not contain DEFAULT_STATE_CODE_2
        defaultUucUserBaseinfoShouldNotBeFound("stateCode2.doesNotContain=" + DEFAULT_STATE_CODE_2);

        // Get all the uucUserBaseinfoList where stateCode2 does not contain UPDATED_STATE_CODE_2
        defaultUucUserBaseinfoShouldBeFound("stateCode2.doesNotContain=" + UPDATED_STATE_CODE_2);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile2IsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile2 equals to DEFAULT_MOBILE_2
        defaultUucUserBaseinfoShouldBeFound("mobile2.equals=" + DEFAULT_MOBILE_2);

        // Get all the uucUserBaseinfoList where mobile2 equals to UPDATED_MOBILE_2
        defaultUucUserBaseinfoShouldNotBeFound("mobile2.equals=" + UPDATED_MOBILE_2);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile2IsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile2 not equals to DEFAULT_MOBILE_2
        defaultUucUserBaseinfoShouldNotBeFound("mobile2.notEquals=" + DEFAULT_MOBILE_2);

        // Get all the uucUserBaseinfoList where mobile2 not equals to UPDATED_MOBILE_2
        defaultUucUserBaseinfoShouldBeFound("mobile2.notEquals=" + UPDATED_MOBILE_2);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile2IsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile2 in DEFAULT_MOBILE_2 or UPDATED_MOBILE_2
        defaultUucUserBaseinfoShouldBeFound("mobile2.in=" + DEFAULT_MOBILE_2 + "," + UPDATED_MOBILE_2);

        // Get all the uucUserBaseinfoList where mobile2 equals to UPDATED_MOBILE_2
        defaultUucUserBaseinfoShouldNotBeFound("mobile2.in=" + UPDATED_MOBILE_2);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile2IsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile2 is not null
        defaultUucUserBaseinfoShouldBeFound("mobile2.specified=true");

        // Get all the uucUserBaseinfoList where mobile2 is null
        defaultUucUserBaseinfoShouldNotBeFound("mobile2.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile2ContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile2 contains DEFAULT_MOBILE_2
        defaultUucUserBaseinfoShouldBeFound("mobile2.contains=" + DEFAULT_MOBILE_2);

        // Get all the uucUserBaseinfoList where mobile2 contains UPDATED_MOBILE_2
        defaultUucUserBaseinfoShouldNotBeFound("mobile2.contains=" + UPDATED_MOBILE_2);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile2NotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile2 does not contain DEFAULT_MOBILE_2
        defaultUucUserBaseinfoShouldNotBeFound("mobile2.doesNotContain=" + DEFAULT_MOBILE_2);

        // Get all the uucUserBaseinfoList where mobile2 does not contain UPDATED_MOBILE_2
        defaultUucUserBaseinfoShouldBeFound("mobile2.doesNotContain=" + UPDATED_MOBILE_2);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode3IsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode3 equals to DEFAULT_STATE_CODE_3
        defaultUucUserBaseinfoShouldBeFound("stateCode3.equals=" + DEFAULT_STATE_CODE_3);

        // Get all the uucUserBaseinfoList where stateCode3 equals to UPDATED_STATE_CODE_3
        defaultUucUserBaseinfoShouldNotBeFound("stateCode3.equals=" + UPDATED_STATE_CODE_3);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode3IsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode3 not equals to DEFAULT_STATE_CODE_3
        defaultUucUserBaseinfoShouldNotBeFound("stateCode3.notEquals=" + DEFAULT_STATE_CODE_3);

        // Get all the uucUserBaseinfoList where stateCode3 not equals to UPDATED_STATE_CODE_3
        defaultUucUserBaseinfoShouldBeFound("stateCode3.notEquals=" + UPDATED_STATE_CODE_3);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode3IsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode3 in DEFAULT_STATE_CODE_3 or UPDATED_STATE_CODE_3
        defaultUucUserBaseinfoShouldBeFound("stateCode3.in=" + DEFAULT_STATE_CODE_3 + "," + UPDATED_STATE_CODE_3);

        // Get all the uucUserBaseinfoList where stateCode3 equals to UPDATED_STATE_CODE_3
        defaultUucUserBaseinfoShouldNotBeFound("stateCode3.in=" + UPDATED_STATE_CODE_3);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode3IsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode3 is not null
        defaultUucUserBaseinfoShouldBeFound("stateCode3.specified=true");

        // Get all the uucUserBaseinfoList where stateCode3 is null
        defaultUucUserBaseinfoShouldNotBeFound("stateCode3.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode3ContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode3 contains DEFAULT_STATE_CODE_3
        defaultUucUserBaseinfoShouldBeFound("stateCode3.contains=" + DEFAULT_STATE_CODE_3);

        // Get all the uucUserBaseinfoList where stateCode3 contains UPDATED_STATE_CODE_3
        defaultUucUserBaseinfoShouldNotBeFound("stateCode3.contains=" + UPDATED_STATE_CODE_3);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode3NotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode3 does not contain DEFAULT_STATE_CODE_3
        defaultUucUserBaseinfoShouldNotBeFound("stateCode3.doesNotContain=" + DEFAULT_STATE_CODE_3);

        // Get all the uucUserBaseinfoList where stateCode3 does not contain UPDATED_STATE_CODE_3
        defaultUucUserBaseinfoShouldBeFound("stateCode3.doesNotContain=" + UPDATED_STATE_CODE_3);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile3IsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile3 equals to DEFAULT_MOBILE_3
        defaultUucUserBaseinfoShouldBeFound("mobile3.equals=" + DEFAULT_MOBILE_3);

        // Get all the uucUserBaseinfoList where mobile3 equals to UPDATED_MOBILE_3
        defaultUucUserBaseinfoShouldNotBeFound("mobile3.equals=" + UPDATED_MOBILE_3);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile3IsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile3 not equals to DEFAULT_MOBILE_3
        defaultUucUserBaseinfoShouldNotBeFound("mobile3.notEquals=" + DEFAULT_MOBILE_3);

        // Get all the uucUserBaseinfoList where mobile3 not equals to UPDATED_MOBILE_3
        defaultUucUserBaseinfoShouldBeFound("mobile3.notEquals=" + UPDATED_MOBILE_3);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile3IsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile3 in DEFAULT_MOBILE_3 or UPDATED_MOBILE_3
        defaultUucUserBaseinfoShouldBeFound("mobile3.in=" + DEFAULT_MOBILE_3 + "," + UPDATED_MOBILE_3);

        // Get all the uucUserBaseinfoList where mobile3 equals to UPDATED_MOBILE_3
        defaultUucUserBaseinfoShouldNotBeFound("mobile3.in=" + UPDATED_MOBILE_3);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile3IsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile3 is not null
        defaultUucUserBaseinfoShouldBeFound("mobile3.specified=true");

        // Get all the uucUserBaseinfoList where mobile3 is null
        defaultUucUserBaseinfoShouldNotBeFound("mobile3.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile3ContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile3 contains DEFAULT_MOBILE_3
        defaultUucUserBaseinfoShouldBeFound("mobile3.contains=" + DEFAULT_MOBILE_3);

        // Get all the uucUserBaseinfoList where mobile3 contains UPDATED_MOBILE_3
        defaultUucUserBaseinfoShouldNotBeFound("mobile3.contains=" + UPDATED_MOBILE_3);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile3NotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile3 does not contain DEFAULT_MOBILE_3
        defaultUucUserBaseinfoShouldNotBeFound("mobile3.doesNotContain=" + DEFAULT_MOBILE_3);

        // Get all the uucUserBaseinfoList where mobile3 does not contain UPDATED_MOBILE_3
        defaultUucUserBaseinfoShouldBeFound("mobile3.doesNotContain=" + UPDATED_MOBILE_3);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode4IsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode4 equals to DEFAULT_STATE_CODE_4
        defaultUucUserBaseinfoShouldBeFound("stateCode4.equals=" + DEFAULT_STATE_CODE_4);

        // Get all the uucUserBaseinfoList where stateCode4 equals to UPDATED_STATE_CODE_4
        defaultUucUserBaseinfoShouldNotBeFound("stateCode4.equals=" + UPDATED_STATE_CODE_4);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode4IsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode4 not equals to DEFAULT_STATE_CODE_4
        defaultUucUserBaseinfoShouldNotBeFound("stateCode4.notEquals=" + DEFAULT_STATE_CODE_4);

        // Get all the uucUserBaseinfoList where stateCode4 not equals to UPDATED_STATE_CODE_4
        defaultUucUserBaseinfoShouldBeFound("stateCode4.notEquals=" + UPDATED_STATE_CODE_4);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode4IsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode4 in DEFAULT_STATE_CODE_4 or UPDATED_STATE_CODE_4
        defaultUucUserBaseinfoShouldBeFound("stateCode4.in=" + DEFAULT_STATE_CODE_4 + "," + UPDATED_STATE_CODE_4);

        // Get all the uucUserBaseinfoList where stateCode4 equals to UPDATED_STATE_CODE_4
        defaultUucUserBaseinfoShouldNotBeFound("stateCode4.in=" + UPDATED_STATE_CODE_4);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode4IsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode4 is not null
        defaultUucUserBaseinfoShouldBeFound("stateCode4.specified=true");

        // Get all the uucUserBaseinfoList where stateCode4 is null
        defaultUucUserBaseinfoShouldNotBeFound("stateCode4.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode4ContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode4 contains DEFAULT_STATE_CODE_4
        defaultUucUserBaseinfoShouldBeFound("stateCode4.contains=" + DEFAULT_STATE_CODE_4);

        // Get all the uucUserBaseinfoList where stateCode4 contains UPDATED_STATE_CODE_4
        defaultUucUserBaseinfoShouldNotBeFound("stateCode4.contains=" + UPDATED_STATE_CODE_4);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode4NotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode4 does not contain DEFAULT_STATE_CODE_4
        defaultUucUserBaseinfoShouldNotBeFound("stateCode4.doesNotContain=" + DEFAULT_STATE_CODE_4);

        // Get all the uucUserBaseinfoList where stateCode4 does not contain UPDATED_STATE_CODE_4
        defaultUucUserBaseinfoShouldBeFound("stateCode4.doesNotContain=" + UPDATED_STATE_CODE_4);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile4IsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile4 equals to DEFAULT_MOBILE_4
        defaultUucUserBaseinfoShouldBeFound("mobile4.equals=" + DEFAULT_MOBILE_4);

        // Get all the uucUserBaseinfoList where mobile4 equals to UPDATED_MOBILE_4
        defaultUucUserBaseinfoShouldNotBeFound("mobile4.equals=" + UPDATED_MOBILE_4);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile4IsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile4 not equals to DEFAULT_MOBILE_4
        defaultUucUserBaseinfoShouldNotBeFound("mobile4.notEquals=" + DEFAULT_MOBILE_4);

        // Get all the uucUserBaseinfoList where mobile4 not equals to UPDATED_MOBILE_4
        defaultUucUserBaseinfoShouldBeFound("mobile4.notEquals=" + UPDATED_MOBILE_4);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile4IsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile4 in DEFAULT_MOBILE_4 or UPDATED_MOBILE_4
        defaultUucUserBaseinfoShouldBeFound("mobile4.in=" + DEFAULT_MOBILE_4 + "," + UPDATED_MOBILE_4);

        // Get all the uucUserBaseinfoList where mobile4 equals to UPDATED_MOBILE_4
        defaultUucUserBaseinfoShouldNotBeFound("mobile4.in=" + UPDATED_MOBILE_4);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile4IsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile4 is not null
        defaultUucUserBaseinfoShouldBeFound("mobile4.specified=true");

        // Get all the uucUserBaseinfoList where mobile4 is null
        defaultUucUserBaseinfoShouldNotBeFound("mobile4.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile4ContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile4 contains DEFAULT_MOBILE_4
        defaultUucUserBaseinfoShouldBeFound("mobile4.contains=" + DEFAULT_MOBILE_4);

        // Get all the uucUserBaseinfoList where mobile4 contains UPDATED_MOBILE_4
        defaultUucUserBaseinfoShouldNotBeFound("mobile4.contains=" + UPDATED_MOBILE_4);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile4NotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile4 does not contain DEFAULT_MOBILE_4
        defaultUucUserBaseinfoShouldNotBeFound("mobile4.doesNotContain=" + DEFAULT_MOBILE_4);

        // Get all the uucUserBaseinfoList where mobile4 does not contain UPDATED_MOBILE_4
        defaultUucUserBaseinfoShouldBeFound("mobile4.doesNotContain=" + UPDATED_MOBILE_4);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode5IsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode5 equals to DEFAULT_STATE_CODE_5
        defaultUucUserBaseinfoShouldBeFound("stateCode5.equals=" + DEFAULT_STATE_CODE_5);

        // Get all the uucUserBaseinfoList where stateCode5 equals to UPDATED_STATE_CODE_5
        defaultUucUserBaseinfoShouldNotBeFound("stateCode5.equals=" + UPDATED_STATE_CODE_5);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode5IsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode5 not equals to DEFAULT_STATE_CODE_5
        defaultUucUserBaseinfoShouldNotBeFound("stateCode5.notEquals=" + DEFAULT_STATE_CODE_5);

        // Get all the uucUserBaseinfoList where stateCode5 not equals to UPDATED_STATE_CODE_5
        defaultUucUserBaseinfoShouldBeFound("stateCode5.notEquals=" + UPDATED_STATE_CODE_5);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode5IsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode5 in DEFAULT_STATE_CODE_5 or UPDATED_STATE_CODE_5
        defaultUucUserBaseinfoShouldBeFound("stateCode5.in=" + DEFAULT_STATE_CODE_5 + "," + UPDATED_STATE_CODE_5);

        // Get all the uucUserBaseinfoList where stateCode5 equals to UPDATED_STATE_CODE_5
        defaultUucUserBaseinfoShouldNotBeFound("stateCode5.in=" + UPDATED_STATE_CODE_5);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode5IsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode5 is not null
        defaultUucUserBaseinfoShouldBeFound("stateCode5.specified=true");

        // Get all the uucUserBaseinfoList where stateCode5 is null
        defaultUucUserBaseinfoShouldNotBeFound("stateCode5.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode5ContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode5 contains DEFAULT_STATE_CODE_5
        defaultUucUserBaseinfoShouldBeFound("stateCode5.contains=" + DEFAULT_STATE_CODE_5);

        // Get all the uucUserBaseinfoList where stateCode5 contains UPDATED_STATE_CODE_5
        defaultUucUserBaseinfoShouldNotBeFound("stateCode5.contains=" + UPDATED_STATE_CODE_5);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByStateCode5NotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where stateCode5 does not contain DEFAULT_STATE_CODE_5
        defaultUucUserBaseinfoShouldNotBeFound("stateCode5.doesNotContain=" + DEFAULT_STATE_CODE_5);

        // Get all the uucUserBaseinfoList where stateCode5 does not contain UPDATED_STATE_CODE_5
        defaultUucUserBaseinfoShouldBeFound("stateCode5.doesNotContain=" + UPDATED_STATE_CODE_5);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile5IsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile5 equals to DEFAULT_MOBILE_5
        defaultUucUserBaseinfoShouldBeFound("mobile5.equals=" + DEFAULT_MOBILE_5);

        // Get all the uucUserBaseinfoList where mobile5 equals to UPDATED_MOBILE_5
        defaultUucUserBaseinfoShouldNotBeFound("mobile5.equals=" + UPDATED_MOBILE_5);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile5IsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile5 not equals to DEFAULT_MOBILE_5
        defaultUucUserBaseinfoShouldNotBeFound("mobile5.notEquals=" + DEFAULT_MOBILE_5);

        // Get all the uucUserBaseinfoList where mobile5 not equals to UPDATED_MOBILE_5
        defaultUucUserBaseinfoShouldBeFound("mobile5.notEquals=" + UPDATED_MOBILE_5);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile5IsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile5 in DEFAULT_MOBILE_5 or UPDATED_MOBILE_5
        defaultUucUserBaseinfoShouldBeFound("mobile5.in=" + DEFAULT_MOBILE_5 + "," + UPDATED_MOBILE_5);

        // Get all the uucUserBaseinfoList where mobile5 equals to UPDATED_MOBILE_5
        defaultUucUserBaseinfoShouldNotBeFound("mobile5.in=" + UPDATED_MOBILE_5);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile5IsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile5 is not null
        defaultUucUserBaseinfoShouldBeFound("mobile5.specified=true");

        // Get all the uucUserBaseinfoList where mobile5 is null
        defaultUucUserBaseinfoShouldNotBeFound("mobile5.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile5ContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile5 contains DEFAULT_MOBILE_5
        defaultUucUserBaseinfoShouldBeFound("mobile5.contains=" + DEFAULT_MOBILE_5);

        // Get all the uucUserBaseinfoList where mobile5 contains UPDATED_MOBILE_5
        defaultUucUserBaseinfoShouldNotBeFound("mobile5.contains=" + UPDATED_MOBILE_5);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMobile5NotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where mobile5 does not contain DEFAULT_MOBILE_5
        defaultUucUserBaseinfoShouldNotBeFound("mobile5.doesNotContain=" + DEFAULT_MOBILE_5);

        // Get all the uucUserBaseinfoList where mobile5 does not contain UPDATED_MOBILE_5
        defaultUucUserBaseinfoShouldBeFound("mobile5.doesNotContain=" + UPDATED_MOBILE_5);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTitleDescIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where titleDesc equals to DEFAULT_TITLE_DESC
        defaultUucUserBaseinfoShouldBeFound("titleDesc.equals=" + DEFAULT_TITLE_DESC);

        // Get all the uucUserBaseinfoList where titleDesc equals to UPDATED_TITLE_DESC
        defaultUucUserBaseinfoShouldNotBeFound("titleDesc.equals=" + UPDATED_TITLE_DESC);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTitleDescIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where titleDesc not equals to DEFAULT_TITLE_DESC
        defaultUucUserBaseinfoShouldNotBeFound("titleDesc.notEquals=" + DEFAULT_TITLE_DESC);

        // Get all the uucUserBaseinfoList where titleDesc not equals to UPDATED_TITLE_DESC
        defaultUucUserBaseinfoShouldBeFound("titleDesc.notEquals=" + UPDATED_TITLE_DESC);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTitleDescIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where titleDesc in DEFAULT_TITLE_DESC or UPDATED_TITLE_DESC
        defaultUucUserBaseinfoShouldBeFound("titleDesc.in=" + DEFAULT_TITLE_DESC + "," + UPDATED_TITLE_DESC);

        // Get all the uucUserBaseinfoList where titleDesc equals to UPDATED_TITLE_DESC
        defaultUucUserBaseinfoShouldNotBeFound("titleDesc.in=" + UPDATED_TITLE_DESC);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTitleDescIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where titleDesc is not null
        defaultUucUserBaseinfoShouldBeFound("titleDesc.specified=true");

        // Get all the uucUserBaseinfoList where titleDesc is null
        defaultUucUserBaseinfoShouldNotBeFound("titleDesc.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByTitleDescContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where titleDesc contains DEFAULT_TITLE_DESC
        defaultUucUserBaseinfoShouldBeFound("titleDesc.contains=" + DEFAULT_TITLE_DESC);

        // Get all the uucUserBaseinfoList where titleDesc contains UPDATED_TITLE_DESC
        defaultUucUserBaseinfoShouldNotBeFound("titleDesc.contains=" + UPDATED_TITLE_DESC);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTitleDescNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where titleDesc does not contain DEFAULT_TITLE_DESC
        defaultUucUserBaseinfoShouldNotBeFound("titleDesc.doesNotContain=" + DEFAULT_TITLE_DESC);

        // Get all the uucUserBaseinfoList where titleDesc does not contain UPDATED_TITLE_DESC
        defaultUucUserBaseinfoShouldBeFound("titleDesc.doesNotContain=" + UPDATED_TITLE_DESC);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTitleEnIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where titleEn equals to DEFAULT_TITLE_EN
        defaultUucUserBaseinfoShouldBeFound("titleEn.equals=" + DEFAULT_TITLE_EN);

        // Get all the uucUserBaseinfoList where titleEn equals to UPDATED_TITLE_EN
        defaultUucUserBaseinfoShouldNotBeFound("titleEn.equals=" + UPDATED_TITLE_EN);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTitleEnIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where titleEn not equals to DEFAULT_TITLE_EN
        defaultUucUserBaseinfoShouldNotBeFound("titleEn.notEquals=" + DEFAULT_TITLE_EN);

        // Get all the uucUserBaseinfoList where titleEn not equals to UPDATED_TITLE_EN
        defaultUucUserBaseinfoShouldBeFound("titleEn.notEquals=" + UPDATED_TITLE_EN);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTitleEnIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where titleEn in DEFAULT_TITLE_EN or UPDATED_TITLE_EN
        defaultUucUserBaseinfoShouldBeFound("titleEn.in=" + DEFAULT_TITLE_EN + "," + UPDATED_TITLE_EN);

        // Get all the uucUserBaseinfoList where titleEn equals to UPDATED_TITLE_EN
        defaultUucUserBaseinfoShouldNotBeFound("titleEn.in=" + UPDATED_TITLE_EN);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTitleEnIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where titleEn is not null
        defaultUucUserBaseinfoShouldBeFound("titleEn.specified=true");

        // Get all the uucUserBaseinfoList where titleEn is null
        defaultUucUserBaseinfoShouldNotBeFound("titleEn.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByTitleEnContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where titleEn contains DEFAULT_TITLE_EN
        defaultUucUserBaseinfoShouldBeFound("titleEn.contains=" + DEFAULT_TITLE_EN);

        // Get all the uucUserBaseinfoList where titleEn contains UPDATED_TITLE_EN
        defaultUucUserBaseinfoShouldNotBeFound("titleEn.contains=" + UPDATED_TITLE_EN);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByTitleEnNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where titleEn does not contain DEFAULT_TITLE_EN
        defaultUucUserBaseinfoShouldNotBeFound("titleEn.doesNotContain=" + DEFAULT_TITLE_EN);

        // Get all the uucUserBaseinfoList where titleEn does not contain UPDATED_TITLE_EN
        defaultUucUserBaseinfoShouldBeFound("titleEn.doesNotContain=" + UPDATED_TITLE_EN);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByCheckNumIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where checkNum equals to DEFAULT_CHECK_NUM
        defaultUucUserBaseinfoShouldBeFound("checkNum.equals=" + DEFAULT_CHECK_NUM);

        // Get all the uucUserBaseinfoList where checkNum equals to UPDATED_CHECK_NUM
        defaultUucUserBaseinfoShouldNotBeFound("checkNum.equals=" + UPDATED_CHECK_NUM);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByCheckNumIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where checkNum not equals to DEFAULT_CHECK_NUM
        defaultUucUserBaseinfoShouldNotBeFound("checkNum.notEquals=" + DEFAULT_CHECK_NUM);

        // Get all the uucUserBaseinfoList where checkNum not equals to UPDATED_CHECK_NUM
        defaultUucUserBaseinfoShouldBeFound("checkNum.notEquals=" + UPDATED_CHECK_NUM);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByCheckNumIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where checkNum in DEFAULT_CHECK_NUM or UPDATED_CHECK_NUM
        defaultUucUserBaseinfoShouldBeFound("checkNum.in=" + DEFAULT_CHECK_NUM + "," + UPDATED_CHECK_NUM);

        // Get all the uucUserBaseinfoList where checkNum equals to UPDATED_CHECK_NUM
        defaultUucUserBaseinfoShouldNotBeFound("checkNum.in=" + UPDATED_CHECK_NUM);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByCheckNumIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where checkNum is not null
        defaultUucUserBaseinfoShouldBeFound("checkNum.specified=true");

        // Get all the uucUserBaseinfoList where checkNum is null
        defaultUucUserBaseinfoShouldNotBeFound("checkNum.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByCheckNumContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where checkNum contains DEFAULT_CHECK_NUM
        defaultUucUserBaseinfoShouldBeFound("checkNum.contains=" + DEFAULT_CHECK_NUM);

        // Get all the uucUserBaseinfoList where checkNum contains UPDATED_CHECK_NUM
        defaultUucUserBaseinfoShouldNotBeFound("checkNum.contains=" + UPDATED_CHECK_NUM);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByCheckNumNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where checkNum does not contain DEFAULT_CHECK_NUM
        defaultUucUserBaseinfoShouldNotBeFound("checkNum.doesNotContain=" + DEFAULT_CHECK_NUM);

        // Get all the uucUserBaseinfoList where checkNum does not contain UPDATED_CHECK_NUM
        defaultUucUserBaseinfoShouldBeFound("checkNum.doesNotContain=" + UPDATED_CHECK_NUM);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByDisporderIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where disporder equals to DEFAULT_DISPORDER
        defaultUucUserBaseinfoShouldBeFound("disporder.equals=" + DEFAULT_DISPORDER);

        // Get all the uucUserBaseinfoList where disporder equals to UPDATED_DISPORDER
        defaultUucUserBaseinfoShouldNotBeFound("disporder.equals=" + UPDATED_DISPORDER);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByDisporderIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where disporder not equals to DEFAULT_DISPORDER
        defaultUucUserBaseinfoShouldNotBeFound("disporder.notEquals=" + DEFAULT_DISPORDER);

        // Get all the uucUserBaseinfoList where disporder not equals to UPDATED_DISPORDER
        defaultUucUserBaseinfoShouldBeFound("disporder.notEquals=" + UPDATED_DISPORDER);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByDisporderIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where disporder in DEFAULT_DISPORDER or UPDATED_DISPORDER
        defaultUucUserBaseinfoShouldBeFound("disporder.in=" + DEFAULT_DISPORDER + "," + UPDATED_DISPORDER);

        // Get all the uucUserBaseinfoList where disporder equals to UPDATED_DISPORDER
        defaultUucUserBaseinfoShouldNotBeFound("disporder.in=" + UPDATED_DISPORDER);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByDisporderIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where disporder is not null
        defaultUucUserBaseinfoShouldBeFound("disporder.specified=true");

        // Get all the uucUserBaseinfoList where disporder is null
        defaultUucUserBaseinfoShouldNotBeFound("disporder.specified=false");
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByDisporderIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where disporder is greater than or equal to DEFAULT_DISPORDER
        defaultUucUserBaseinfoShouldBeFound("disporder.greaterThanOrEqual=" + DEFAULT_DISPORDER);

        // Get all the uucUserBaseinfoList where disporder is greater than or equal to UPDATED_DISPORDER
        defaultUucUserBaseinfoShouldNotBeFound("disporder.greaterThanOrEqual=" + UPDATED_DISPORDER);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByDisporderIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where disporder is less than or equal to DEFAULT_DISPORDER
        defaultUucUserBaseinfoShouldBeFound("disporder.lessThanOrEqual=" + DEFAULT_DISPORDER);

        // Get all the uucUserBaseinfoList where disporder is less than or equal to SMALLER_DISPORDER
        defaultUucUserBaseinfoShouldNotBeFound("disporder.lessThanOrEqual=" + SMALLER_DISPORDER);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByDisporderIsLessThanSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where disporder is less than DEFAULT_DISPORDER
        defaultUucUserBaseinfoShouldNotBeFound("disporder.lessThan=" + DEFAULT_DISPORDER);

        // Get all the uucUserBaseinfoList where disporder is less than UPDATED_DISPORDER
        defaultUucUserBaseinfoShouldBeFound("disporder.lessThan=" + UPDATED_DISPORDER);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByDisporderIsGreaterThanSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where disporder is greater than DEFAULT_DISPORDER
        defaultUucUserBaseinfoShouldNotBeFound("disporder.greaterThan=" + DEFAULT_DISPORDER);

        // Get all the uucUserBaseinfoList where disporder is greater than SMALLER_DISPORDER
        defaultUucUserBaseinfoShouldBeFound("disporder.greaterThan=" + SMALLER_DISPORDER);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByWorkPlaceIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where workPlace equals to DEFAULT_WORK_PLACE
        defaultUucUserBaseinfoShouldBeFound("workPlace.equals=" + DEFAULT_WORK_PLACE);

        // Get all the uucUserBaseinfoList where workPlace equals to UPDATED_WORK_PLACE
        defaultUucUserBaseinfoShouldNotBeFound("workPlace.equals=" + UPDATED_WORK_PLACE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByWorkPlaceIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where workPlace not equals to DEFAULT_WORK_PLACE
        defaultUucUserBaseinfoShouldNotBeFound("workPlace.notEquals=" + DEFAULT_WORK_PLACE);

        // Get all the uucUserBaseinfoList where workPlace not equals to UPDATED_WORK_PLACE
        defaultUucUserBaseinfoShouldBeFound("workPlace.notEquals=" + UPDATED_WORK_PLACE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByWorkPlaceIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where workPlace in DEFAULT_WORK_PLACE or UPDATED_WORK_PLACE
        defaultUucUserBaseinfoShouldBeFound("workPlace.in=" + DEFAULT_WORK_PLACE + "," + UPDATED_WORK_PLACE);

        // Get all the uucUserBaseinfoList where workPlace equals to UPDATED_WORK_PLACE
        defaultUucUserBaseinfoShouldNotBeFound("workPlace.in=" + UPDATED_WORK_PLACE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByWorkPlaceIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where workPlace is not null
        defaultUucUserBaseinfoShouldBeFound("workPlace.specified=true");

        // Get all the uucUserBaseinfoList where workPlace is null
        defaultUucUserBaseinfoShouldNotBeFound("workPlace.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByWorkPlaceContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where workPlace contains DEFAULT_WORK_PLACE
        defaultUucUserBaseinfoShouldBeFound("workPlace.contains=" + DEFAULT_WORK_PLACE);

        // Get all the uucUserBaseinfoList where workPlace contains UPDATED_WORK_PLACE
        defaultUucUserBaseinfoShouldNotBeFound("workPlace.contains=" + UPDATED_WORK_PLACE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByWorkPlaceNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where workPlace does not contain DEFAULT_WORK_PLACE
        defaultUucUserBaseinfoShouldNotBeFound("workPlace.doesNotContain=" + DEFAULT_WORK_PLACE);

        // Get all the uucUserBaseinfoList where workPlace does not contain UPDATED_WORK_PLACE
        defaultUucUserBaseinfoShouldBeFound("workPlace.doesNotContain=" + UPDATED_WORK_PLACE);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByUserLevelIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where userLevel equals to DEFAULT_USER_LEVEL
        defaultUucUserBaseinfoShouldBeFound("userLevel.equals=" + DEFAULT_USER_LEVEL);

        // Get all the uucUserBaseinfoList where userLevel equals to UPDATED_USER_LEVEL
        defaultUucUserBaseinfoShouldNotBeFound("userLevel.equals=" + UPDATED_USER_LEVEL);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByUserLevelIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where userLevel not equals to DEFAULT_USER_LEVEL
        defaultUucUserBaseinfoShouldNotBeFound("userLevel.notEquals=" + DEFAULT_USER_LEVEL);

        // Get all the uucUserBaseinfoList where userLevel not equals to UPDATED_USER_LEVEL
        defaultUucUserBaseinfoShouldBeFound("userLevel.notEquals=" + UPDATED_USER_LEVEL);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByUserLevelIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where userLevel in DEFAULT_USER_LEVEL or UPDATED_USER_LEVEL
        defaultUucUserBaseinfoShouldBeFound("userLevel.in=" + DEFAULT_USER_LEVEL + "," + UPDATED_USER_LEVEL);

        // Get all the uucUserBaseinfoList where userLevel equals to UPDATED_USER_LEVEL
        defaultUucUserBaseinfoShouldNotBeFound("userLevel.in=" + UPDATED_USER_LEVEL);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByUserLevelIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where userLevel is not null
        defaultUucUserBaseinfoShouldBeFound("userLevel.specified=true");

        // Get all the uucUserBaseinfoList where userLevel is null
        defaultUucUserBaseinfoShouldNotBeFound("userLevel.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByUserLevelContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where userLevel contains DEFAULT_USER_LEVEL
        defaultUucUserBaseinfoShouldBeFound("userLevel.contains=" + DEFAULT_USER_LEVEL);

        // Get all the uucUserBaseinfoList where userLevel contains UPDATED_USER_LEVEL
        defaultUucUserBaseinfoShouldNotBeFound("userLevel.contains=" + UPDATED_USER_LEVEL);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByUserLevelNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where userLevel does not contain DEFAULT_USER_LEVEL
        defaultUucUserBaseinfoShouldNotBeFound("userLevel.doesNotContain=" + DEFAULT_USER_LEVEL);

        // Get all the uucUserBaseinfoList where userLevel does not contain UPDATED_USER_LEVEL
        defaultUucUserBaseinfoShouldBeFound("userLevel.doesNotContain=" + UPDATED_USER_LEVEL);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByHiredateIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where hiredate equals to DEFAULT_HIREDATE
        defaultUucUserBaseinfoShouldBeFound("hiredate.equals=" + DEFAULT_HIREDATE);

        // Get all the uucUserBaseinfoList where hiredate equals to UPDATED_HIREDATE
        defaultUucUserBaseinfoShouldNotBeFound("hiredate.equals=" + UPDATED_HIREDATE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByHiredateIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where hiredate not equals to DEFAULT_HIREDATE
        defaultUucUserBaseinfoShouldNotBeFound("hiredate.notEquals=" + DEFAULT_HIREDATE);

        // Get all the uucUserBaseinfoList where hiredate not equals to UPDATED_HIREDATE
        defaultUucUserBaseinfoShouldBeFound("hiredate.notEquals=" + UPDATED_HIREDATE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByHiredateIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where hiredate in DEFAULT_HIREDATE or UPDATED_HIREDATE
        defaultUucUserBaseinfoShouldBeFound("hiredate.in=" + DEFAULT_HIREDATE + "," + UPDATED_HIREDATE);

        // Get all the uucUserBaseinfoList where hiredate equals to UPDATED_HIREDATE
        defaultUucUserBaseinfoShouldNotBeFound("hiredate.in=" + UPDATED_HIREDATE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByHiredateIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where hiredate is not null
        defaultUucUserBaseinfoShouldBeFound("hiredate.specified=true");

        // Get all the uucUserBaseinfoList where hiredate is null
        defaultUucUserBaseinfoShouldNotBeFound("hiredate.specified=false");
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByNicknameIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where nickname equals to DEFAULT_NICKNAME
        defaultUucUserBaseinfoShouldBeFound("nickname.equals=" + DEFAULT_NICKNAME);

        // Get all the uucUserBaseinfoList where nickname equals to UPDATED_NICKNAME
        defaultUucUserBaseinfoShouldNotBeFound("nickname.equals=" + UPDATED_NICKNAME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByNicknameIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where nickname not equals to DEFAULT_NICKNAME
        defaultUucUserBaseinfoShouldNotBeFound("nickname.notEquals=" + DEFAULT_NICKNAME);

        // Get all the uucUserBaseinfoList where nickname not equals to UPDATED_NICKNAME
        defaultUucUserBaseinfoShouldBeFound("nickname.notEquals=" + UPDATED_NICKNAME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByNicknameIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where nickname in DEFAULT_NICKNAME or UPDATED_NICKNAME
        defaultUucUserBaseinfoShouldBeFound("nickname.in=" + DEFAULT_NICKNAME + "," + UPDATED_NICKNAME);

        // Get all the uucUserBaseinfoList where nickname equals to UPDATED_NICKNAME
        defaultUucUserBaseinfoShouldNotBeFound("nickname.in=" + UPDATED_NICKNAME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByNicknameIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where nickname is not null
        defaultUucUserBaseinfoShouldBeFound("nickname.specified=true");

        // Get all the uucUserBaseinfoList where nickname is null
        defaultUucUserBaseinfoShouldNotBeFound("nickname.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByNicknameContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where nickname contains DEFAULT_NICKNAME
        defaultUucUserBaseinfoShouldBeFound("nickname.contains=" + DEFAULT_NICKNAME);

        // Get all the uucUserBaseinfoList where nickname contains UPDATED_NICKNAME
        defaultUucUserBaseinfoShouldNotBeFound("nickname.contains=" + UPDATED_NICKNAME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByNicknameNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where nickname does not contain DEFAULT_NICKNAME
        defaultUucUserBaseinfoShouldNotBeFound("nickname.doesNotContain=" + DEFAULT_NICKNAME);

        // Get all the uucUserBaseinfoList where nickname does not contain UPDATED_NICKNAME
        defaultUucUserBaseinfoShouldBeFound("nickname.doesNotContain=" + UPDATED_NICKNAME);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMemoIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where memo equals to DEFAULT_MEMO
        defaultUucUserBaseinfoShouldBeFound("memo.equals=" + DEFAULT_MEMO);

        // Get all the uucUserBaseinfoList where memo equals to UPDATED_MEMO
        defaultUucUserBaseinfoShouldNotBeFound("memo.equals=" + UPDATED_MEMO);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMemoIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where memo not equals to DEFAULT_MEMO
        defaultUucUserBaseinfoShouldNotBeFound("memo.notEquals=" + DEFAULT_MEMO);

        // Get all the uucUserBaseinfoList where memo not equals to UPDATED_MEMO
        defaultUucUserBaseinfoShouldBeFound("memo.notEquals=" + UPDATED_MEMO);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMemoIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where memo in DEFAULT_MEMO or UPDATED_MEMO
        defaultUucUserBaseinfoShouldBeFound("memo.in=" + DEFAULT_MEMO + "," + UPDATED_MEMO);

        // Get all the uucUserBaseinfoList where memo equals to UPDATED_MEMO
        defaultUucUserBaseinfoShouldNotBeFound("memo.in=" + UPDATED_MEMO);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMemoIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where memo is not null
        defaultUucUserBaseinfoShouldBeFound("memo.specified=true");

        // Get all the uucUserBaseinfoList where memo is null
        defaultUucUserBaseinfoShouldNotBeFound("memo.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByMemoContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where memo contains DEFAULT_MEMO
        defaultUucUserBaseinfoShouldBeFound("memo.contains=" + DEFAULT_MEMO);

        // Get all the uucUserBaseinfoList where memo contains UPDATED_MEMO
        defaultUucUserBaseinfoShouldNotBeFound("memo.contains=" + UPDATED_MEMO);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMemoNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where memo does not contain DEFAULT_MEMO
        defaultUucUserBaseinfoShouldNotBeFound("memo.doesNotContain=" + DEFAULT_MEMO);

        // Get all the uucUserBaseinfoList where memo does not contain UPDATED_MEMO
        defaultUucUserBaseinfoShouldBeFound("memo.doesNotContain=" + UPDATED_MEMO);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsHiddenIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isHidden equals to DEFAULT_IS_HIDDEN
        defaultUucUserBaseinfoShouldBeFound("isHidden.equals=" + DEFAULT_IS_HIDDEN);

        // Get all the uucUserBaseinfoList where isHidden equals to UPDATED_IS_HIDDEN
        defaultUucUserBaseinfoShouldNotBeFound("isHidden.equals=" + UPDATED_IS_HIDDEN);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsHiddenIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isHidden not equals to DEFAULT_IS_HIDDEN
        defaultUucUserBaseinfoShouldNotBeFound("isHidden.notEquals=" + DEFAULT_IS_HIDDEN);

        // Get all the uucUserBaseinfoList where isHidden not equals to UPDATED_IS_HIDDEN
        defaultUucUserBaseinfoShouldBeFound("isHidden.notEquals=" + UPDATED_IS_HIDDEN);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsHiddenIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isHidden in DEFAULT_IS_HIDDEN or UPDATED_IS_HIDDEN
        defaultUucUserBaseinfoShouldBeFound("isHidden.in=" + DEFAULT_IS_HIDDEN + "," + UPDATED_IS_HIDDEN);

        // Get all the uucUserBaseinfoList where isHidden equals to UPDATED_IS_HIDDEN
        defaultUucUserBaseinfoShouldNotBeFound("isHidden.in=" + UPDATED_IS_HIDDEN);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsHiddenIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isHidden is not null
        defaultUucUserBaseinfoShouldBeFound("isHidden.specified=true");

        // Get all the uucUserBaseinfoList where isHidden is null
        defaultUucUserBaseinfoShouldNotBeFound("isHidden.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsHiddenContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isHidden contains DEFAULT_IS_HIDDEN
        defaultUucUserBaseinfoShouldBeFound("isHidden.contains=" + DEFAULT_IS_HIDDEN);

        // Get all the uucUserBaseinfoList where isHidden contains UPDATED_IS_HIDDEN
        defaultUucUserBaseinfoShouldNotBeFound("isHidden.contains=" + UPDATED_IS_HIDDEN);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsHiddenNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isHidden does not contain DEFAULT_IS_HIDDEN
        defaultUucUserBaseinfoShouldNotBeFound("isHidden.doesNotContain=" + DEFAULT_IS_HIDDEN);

        // Get all the uucUserBaseinfoList where isHidden does not contain UPDATED_IS_HIDDEN
        defaultUucUserBaseinfoShouldBeFound("isHidden.doesNotContain=" + UPDATED_IS_HIDDEN);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAliveFlagIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where aliveFlag equals to DEFAULT_ALIVE_FLAG
        defaultUucUserBaseinfoShouldBeFound("aliveFlag.equals=" + DEFAULT_ALIVE_FLAG);

        // Get all the uucUserBaseinfoList where aliveFlag equals to UPDATED_ALIVE_FLAG
        defaultUucUserBaseinfoShouldNotBeFound("aliveFlag.equals=" + UPDATED_ALIVE_FLAG);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAliveFlagIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where aliveFlag not equals to DEFAULT_ALIVE_FLAG
        defaultUucUserBaseinfoShouldNotBeFound("aliveFlag.notEquals=" + DEFAULT_ALIVE_FLAG);

        // Get all the uucUserBaseinfoList where aliveFlag not equals to UPDATED_ALIVE_FLAG
        defaultUucUserBaseinfoShouldBeFound("aliveFlag.notEquals=" + UPDATED_ALIVE_FLAG);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAliveFlagIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where aliveFlag in DEFAULT_ALIVE_FLAG or UPDATED_ALIVE_FLAG
        defaultUucUserBaseinfoShouldBeFound("aliveFlag.in=" + DEFAULT_ALIVE_FLAG + "," + UPDATED_ALIVE_FLAG);

        // Get all the uucUserBaseinfoList where aliveFlag equals to UPDATED_ALIVE_FLAG
        defaultUucUserBaseinfoShouldNotBeFound("aliveFlag.in=" + UPDATED_ALIVE_FLAG);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAliveFlagIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where aliveFlag is not null
        defaultUucUserBaseinfoShouldBeFound("aliveFlag.specified=true");

        // Get all the uucUserBaseinfoList where aliveFlag is null
        defaultUucUserBaseinfoShouldNotBeFound("aliveFlag.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByAliveFlagContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where aliveFlag contains DEFAULT_ALIVE_FLAG
        defaultUucUserBaseinfoShouldBeFound("aliveFlag.contains=" + DEFAULT_ALIVE_FLAG);

        // Get all the uucUserBaseinfoList where aliveFlag contains UPDATED_ALIVE_FLAG
        defaultUucUserBaseinfoShouldNotBeFound("aliveFlag.contains=" + UPDATED_ALIVE_FLAG);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAliveFlagNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where aliveFlag does not contain DEFAULT_ALIVE_FLAG
        defaultUucUserBaseinfoShouldNotBeFound("aliveFlag.doesNotContain=" + DEFAULT_ALIVE_FLAG);

        // Get all the uucUserBaseinfoList where aliveFlag does not contain UPDATED_ALIVE_FLAG
        defaultUucUserBaseinfoShouldBeFound("aliveFlag.doesNotContain=" + UPDATED_ALIVE_FLAG);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecCreateTimeIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recCreateTime equals to DEFAULT_REC_CREATE_TIME
        defaultUucUserBaseinfoShouldBeFound("recCreateTime.equals=" + DEFAULT_REC_CREATE_TIME);

        // Get all the uucUserBaseinfoList where recCreateTime equals to UPDATED_REC_CREATE_TIME
        defaultUucUserBaseinfoShouldNotBeFound("recCreateTime.equals=" + UPDATED_REC_CREATE_TIME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecCreateTimeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recCreateTime not equals to DEFAULT_REC_CREATE_TIME
        defaultUucUserBaseinfoShouldNotBeFound("recCreateTime.notEquals=" + DEFAULT_REC_CREATE_TIME);

        // Get all the uucUserBaseinfoList where recCreateTime not equals to UPDATED_REC_CREATE_TIME
        defaultUucUserBaseinfoShouldBeFound("recCreateTime.notEquals=" + UPDATED_REC_CREATE_TIME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecCreateTimeIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recCreateTime in DEFAULT_REC_CREATE_TIME or UPDATED_REC_CREATE_TIME
        defaultUucUserBaseinfoShouldBeFound("recCreateTime.in=" + DEFAULT_REC_CREATE_TIME + "," + UPDATED_REC_CREATE_TIME);

        // Get all the uucUserBaseinfoList where recCreateTime equals to UPDATED_REC_CREATE_TIME
        defaultUucUserBaseinfoShouldNotBeFound("recCreateTime.in=" + UPDATED_REC_CREATE_TIME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecCreateTimeIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recCreateTime is not null
        defaultUucUserBaseinfoShouldBeFound("recCreateTime.specified=true");

        // Get all the uucUserBaseinfoList where recCreateTime is null
        defaultUucUserBaseinfoShouldNotBeFound("recCreateTime.specified=false");
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecCreatorIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recCreator equals to DEFAULT_REC_CREATOR
        defaultUucUserBaseinfoShouldBeFound("recCreator.equals=" + DEFAULT_REC_CREATOR);

        // Get all the uucUserBaseinfoList where recCreator equals to UPDATED_REC_CREATOR
        defaultUucUserBaseinfoShouldNotBeFound("recCreator.equals=" + UPDATED_REC_CREATOR);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecCreatorIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recCreator not equals to DEFAULT_REC_CREATOR
        defaultUucUserBaseinfoShouldNotBeFound("recCreator.notEquals=" + DEFAULT_REC_CREATOR);

        // Get all the uucUserBaseinfoList where recCreator not equals to UPDATED_REC_CREATOR
        defaultUucUserBaseinfoShouldBeFound("recCreator.notEquals=" + UPDATED_REC_CREATOR);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecCreatorIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recCreator in DEFAULT_REC_CREATOR or UPDATED_REC_CREATOR
        defaultUucUserBaseinfoShouldBeFound("recCreator.in=" + DEFAULT_REC_CREATOR + "," + UPDATED_REC_CREATOR);

        // Get all the uucUserBaseinfoList where recCreator equals to UPDATED_REC_CREATOR
        defaultUucUserBaseinfoShouldNotBeFound("recCreator.in=" + UPDATED_REC_CREATOR);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecCreatorIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recCreator is not null
        defaultUucUserBaseinfoShouldBeFound("recCreator.specified=true");

        // Get all the uucUserBaseinfoList where recCreator is null
        defaultUucUserBaseinfoShouldNotBeFound("recCreator.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecCreatorContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recCreator contains DEFAULT_REC_CREATOR
        defaultUucUserBaseinfoShouldBeFound("recCreator.contains=" + DEFAULT_REC_CREATOR);

        // Get all the uucUserBaseinfoList where recCreator contains UPDATED_REC_CREATOR
        defaultUucUserBaseinfoShouldNotBeFound("recCreator.contains=" + UPDATED_REC_CREATOR);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecCreatorNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recCreator does not contain DEFAULT_REC_CREATOR
        defaultUucUserBaseinfoShouldNotBeFound("recCreator.doesNotContain=" + DEFAULT_REC_CREATOR);

        // Get all the uucUserBaseinfoList where recCreator does not contain UPDATED_REC_CREATOR
        defaultUucUserBaseinfoShouldBeFound("recCreator.doesNotContain=" + UPDATED_REC_CREATOR);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecReviseTimeIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recReviseTime equals to DEFAULT_REC_REVISE_TIME
        defaultUucUserBaseinfoShouldBeFound("recReviseTime.equals=" + DEFAULT_REC_REVISE_TIME);

        // Get all the uucUserBaseinfoList where recReviseTime equals to UPDATED_REC_REVISE_TIME
        defaultUucUserBaseinfoShouldNotBeFound("recReviseTime.equals=" + UPDATED_REC_REVISE_TIME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecReviseTimeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recReviseTime not equals to DEFAULT_REC_REVISE_TIME
        defaultUucUserBaseinfoShouldNotBeFound("recReviseTime.notEquals=" + DEFAULT_REC_REVISE_TIME);

        // Get all the uucUserBaseinfoList where recReviseTime not equals to UPDATED_REC_REVISE_TIME
        defaultUucUserBaseinfoShouldBeFound("recReviseTime.notEquals=" + UPDATED_REC_REVISE_TIME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecReviseTimeIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recReviseTime in DEFAULT_REC_REVISE_TIME or UPDATED_REC_REVISE_TIME
        defaultUucUserBaseinfoShouldBeFound("recReviseTime.in=" + DEFAULT_REC_REVISE_TIME + "," + UPDATED_REC_REVISE_TIME);

        // Get all the uucUserBaseinfoList where recReviseTime equals to UPDATED_REC_REVISE_TIME
        defaultUucUserBaseinfoShouldNotBeFound("recReviseTime.in=" + UPDATED_REC_REVISE_TIME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecReviseTimeIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recReviseTime is not null
        defaultUucUserBaseinfoShouldBeFound("recReviseTime.specified=true");

        // Get all the uucUserBaseinfoList where recReviseTime is null
        defaultUucUserBaseinfoShouldNotBeFound("recReviseTime.specified=false");
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecRevisorIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recRevisor equals to DEFAULT_REC_REVISOR
        defaultUucUserBaseinfoShouldBeFound("recRevisor.equals=" + DEFAULT_REC_REVISOR);

        // Get all the uucUserBaseinfoList where recRevisor equals to UPDATED_REC_REVISOR
        defaultUucUserBaseinfoShouldNotBeFound("recRevisor.equals=" + UPDATED_REC_REVISOR);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecRevisorIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recRevisor not equals to DEFAULT_REC_REVISOR
        defaultUucUserBaseinfoShouldNotBeFound("recRevisor.notEquals=" + DEFAULT_REC_REVISOR);

        // Get all the uucUserBaseinfoList where recRevisor not equals to UPDATED_REC_REVISOR
        defaultUucUserBaseinfoShouldBeFound("recRevisor.notEquals=" + UPDATED_REC_REVISOR);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecRevisorIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recRevisor in DEFAULT_REC_REVISOR or UPDATED_REC_REVISOR
        defaultUucUserBaseinfoShouldBeFound("recRevisor.in=" + DEFAULT_REC_REVISOR + "," + UPDATED_REC_REVISOR);

        // Get all the uucUserBaseinfoList where recRevisor equals to UPDATED_REC_REVISOR
        defaultUucUserBaseinfoShouldNotBeFound("recRevisor.in=" + UPDATED_REC_REVISOR);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecRevisorIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recRevisor is not null
        defaultUucUserBaseinfoShouldBeFound("recRevisor.specified=true");

        // Get all the uucUserBaseinfoList where recRevisor is null
        defaultUucUserBaseinfoShouldNotBeFound("recRevisor.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecRevisorContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recRevisor contains DEFAULT_REC_REVISOR
        defaultUucUserBaseinfoShouldBeFound("recRevisor.contains=" + DEFAULT_REC_REVISOR);

        // Get all the uucUserBaseinfoList where recRevisor contains UPDATED_REC_REVISOR
        defaultUucUserBaseinfoShouldNotBeFound("recRevisor.contains=" + UPDATED_REC_REVISOR);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByRecRevisorNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where recRevisor does not contain DEFAULT_REC_REVISOR
        defaultUucUserBaseinfoShouldNotBeFound("recRevisor.doesNotContain=" + DEFAULT_REC_REVISOR);

        // Get all the uucUserBaseinfoList where recRevisor does not contain UPDATED_REC_REVISOR
        defaultUucUserBaseinfoShouldBeFound("recRevisor.doesNotContain=" + UPDATED_REC_REVISOR);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsActivatedIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isActivated equals to DEFAULT_IS_ACTIVATED
        defaultUucUserBaseinfoShouldBeFound("isActivated.equals=" + DEFAULT_IS_ACTIVATED);

        // Get all the uucUserBaseinfoList where isActivated equals to UPDATED_IS_ACTIVATED
        defaultUucUserBaseinfoShouldNotBeFound("isActivated.equals=" + UPDATED_IS_ACTIVATED);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsActivatedIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isActivated not equals to DEFAULT_IS_ACTIVATED
        defaultUucUserBaseinfoShouldNotBeFound("isActivated.notEquals=" + DEFAULT_IS_ACTIVATED);

        // Get all the uucUserBaseinfoList where isActivated not equals to UPDATED_IS_ACTIVATED
        defaultUucUserBaseinfoShouldBeFound("isActivated.notEquals=" + UPDATED_IS_ACTIVATED);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsActivatedIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isActivated in DEFAULT_IS_ACTIVATED or UPDATED_IS_ACTIVATED
        defaultUucUserBaseinfoShouldBeFound("isActivated.in=" + DEFAULT_IS_ACTIVATED + "," + UPDATED_IS_ACTIVATED);

        // Get all the uucUserBaseinfoList where isActivated equals to UPDATED_IS_ACTIVATED
        defaultUucUserBaseinfoShouldNotBeFound("isActivated.in=" + UPDATED_IS_ACTIVATED);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsActivatedIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isActivated is not null
        defaultUucUserBaseinfoShouldBeFound("isActivated.specified=true");

        // Get all the uucUserBaseinfoList where isActivated is null
        defaultUucUserBaseinfoShouldNotBeFound("isActivated.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsActivatedContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isActivated contains DEFAULT_IS_ACTIVATED
        defaultUucUserBaseinfoShouldBeFound("isActivated.contains=" + DEFAULT_IS_ACTIVATED);

        // Get all the uucUserBaseinfoList where isActivated contains UPDATED_IS_ACTIVATED
        defaultUucUserBaseinfoShouldNotBeFound("isActivated.contains=" + UPDATED_IS_ACTIVATED);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsActivatedNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isActivated does not contain DEFAULT_IS_ACTIVATED
        defaultUucUserBaseinfoShouldNotBeFound("isActivated.doesNotContain=" + DEFAULT_IS_ACTIVATED);

        // Get all the uucUserBaseinfoList where isActivated does not contain UPDATED_IS_ACTIVATED
        defaultUucUserBaseinfoShouldBeFound("isActivated.doesNotContain=" + UPDATED_IS_ACTIVATED);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByActivationTimeIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where activationTime equals to DEFAULT_ACTIVATION_TIME
        defaultUucUserBaseinfoShouldBeFound("activationTime.equals=" + DEFAULT_ACTIVATION_TIME);

        // Get all the uucUserBaseinfoList where activationTime equals to UPDATED_ACTIVATION_TIME
        defaultUucUserBaseinfoShouldNotBeFound("activationTime.equals=" + UPDATED_ACTIVATION_TIME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByActivationTimeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where activationTime not equals to DEFAULT_ACTIVATION_TIME
        defaultUucUserBaseinfoShouldNotBeFound("activationTime.notEquals=" + DEFAULT_ACTIVATION_TIME);

        // Get all the uucUserBaseinfoList where activationTime not equals to UPDATED_ACTIVATION_TIME
        defaultUucUserBaseinfoShouldBeFound("activationTime.notEquals=" + UPDATED_ACTIVATION_TIME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByActivationTimeIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where activationTime in DEFAULT_ACTIVATION_TIME or UPDATED_ACTIVATION_TIME
        defaultUucUserBaseinfoShouldBeFound("activationTime.in=" + DEFAULT_ACTIVATION_TIME + "," + UPDATED_ACTIVATION_TIME);

        // Get all the uucUserBaseinfoList where activationTime equals to UPDATED_ACTIVATION_TIME
        defaultUucUserBaseinfoShouldNotBeFound("activationTime.in=" + UPDATED_ACTIVATION_TIME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByActivationTimeIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where activationTime is not null
        defaultUucUserBaseinfoShouldBeFound("activationTime.specified=true");

        // Get all the uucUserBaseinfoList where activationTime is null
        defaultUucUserBaseinfoShouldNotBeFound("activationTime.specified=false");
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAppVersionIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where appVersion equals to DEFAULT_APP_VERSION
        defaultUucUserBaseinfoShouldBeFound("appVersion.equals=" + DEFAULT_APP_VERSION);

        // Get all the uucUserBaseinfoList where appVersion equals to UPDATED_APP_VERSION
        defaultUucUserBaseinfoShouldNotBeFound("appVersion.equals=" + UPDATED_APP_VERSION);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAppVersionIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where appVersion not equals to DEFAULT_APP_VERSION
        defaultUucUserBaseinfoShouldNotBeFound("appVersion.notEquals=" + DEFAULT_APP_VERSION);

        // Get all the uucUserBaseinfoList where appVersion not equals to UPDATED_APP_VERSION
        defaultUucUserBaseinfoShouldBeFound("appVersion.notEquals=" + UPDATED_APP_VERSION);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAppVersionIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where appVersion in DEFAULT_APP_VERSION or UPDATED_APP_VERSION
        defaultUucUserBaseinfoShouldBeFound("appVersion.in=" + DEFAULT_APP_VERSION + "," + UPDATED_APP_VERSION);

        // Get all the uucUserBaseinfoList where appVersion equals to UPDATED_APP_VERSION
        defaultUucUserBaseinfoShouldNotBeFound("appVersion.in=" + UPDATED_APP_VERSION);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAppVersionIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where appVersion is not null
        defaultUucUserBaseinfoShouldBeFound("appVersion.specified=true");

        // Get all the uucUserBaseinfoList where appVersion is null
        defaultUucUserBaseinfoShouldNotBeFound("appVersion.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByAppVersionContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where appVersion contains DEFAULT_APP_VERSION
        defaultUucUserBaseinfoShouldBeFound("appVersion.contains=" + DEFAULT_APP_VERSION);

        // Get all the uucUserBaseinfoList where appVersion contains UPDATED_APP_VERSION
        defaultUucUserBaseinfoShouldNotBeFound("appVersion.contains=" + UPDATED_APP_VERSION);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAppVersionNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where appVersion does not contain DEFAULT_APP_VERSION
        defaultUucUserBaseinfoShouldNotBeFound("appVersion.doesNotContain=" + DEFAULT_APP_VERSION);

        // Get all the uucUserBaseinfoList where appVersion does not contain UPDATED_APP_VERSION
        defaultUucUserBaseinfoShouldBeFound("appVersion.doesNotContain=" + UPDATED_APP_VERSION);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsOnlyAdminTitleIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isOnlyAdminTitle equals to DEFAULT_IS_ONLY_ADMIN_TITLE
        defaultUucUserBaseinfoShouldBeFound("isOnlyAdminTitle.equals=" + DEFAULT_IS_ONLY_ADMIN_TITLE);

        // Get all the uucUserBaseinfoList where isOnlyAdminTitle equals to UPDATED_IS_ONLY_ADMIN_TITLE
        defaultUucUserBaseinfoShouldNotBeFound("isOnlyAdminTitle.equals=" + UPDATED_IS_ONLY_ADMIN_TITLE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsOnlyAdminTitleIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isOnlyAdminTitle not equals to DEFAULT_IS_ONLY_ADMIN_TITLE
        defaultUucUserBaseinfoShouldNotBeFound("isOnlyAdminTitle.notEquals=" + DEFAULT_IS_ONLY_ADMIN_TITLE);

        // Get all the uucUserBaseinfoList where isOnlyAdminTitle not equals to UPDATED_IS_ONLY_ADMIN_TITLE
        defaultUucUserBaseinfoShouldBeFound("isOnlyAdminTitle.notEquals=" + UPDATED_IS_ONLY_ADMIN_TITLE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsOnlyAdminTitleIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isOnlyAdminTitle in DEFAULT_IS_ONLY_ADMIN_TITLE or UPDATED_IS_ONLY_ADMIN_TITLE
        defaultUucUserBaseinfoShouldBeFound("isOnlyAdminTitle.in=" + DEFAULT_IS_ONLY_ADMIN_TITLE + "," + UPDATED_IS_ONLY_ADMIN_TITLE);

        // Get all the uucUserBaseinfoList where isOnlyAdminTitle equals to UPDATED_IS_ONLY_ADMIN_TITLE
        defaultUucUserBaseinfoShouldNotBeFound("isOnlyAdminTitle.in=" + UPDATED_IS_ONLY_ADMIN_TITLE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsOnlyAdminTitleIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isOnlyAdminTitle is not null
        defaultUucUserBaseinfoShouldBeFound("isOnlyAdminTitle.specified=true");

        // Get all the uucUserBaseinfoList where isOnlyAdminTitle is null
        defaultUucUserBaseinfoShouldNotBeFound("isOnlyAdminTitle.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsOnlyAdminTitleContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isOnlyAdminTitle contains DEFAULT_IS_ONLY_ADMIN_TITLE
        defaultUucUserBaseinfoShouldBeFound("isOnlyAdminTitle.contains=" + DEFAULT_IS_ONLY_ADMIN_TITLE);

        // Get all the uucUserBaseinfoList where isOnlyAdminTitle contains UPDATED_IS_ONLY_ADMIN_TITLE
        defaultUucUserBaseinfoShouldNotBeFound("isOnlyAdminTitle.contains=" + UPDATED_IS_ONLY_ADMIN_TITLE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByIsOnlyAdminTitleNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where isOnlyAdminTitle does not contain DEFAULT_IS_ONLY_ADMIN_TITLE
        defaultUucUserBaseinfoShouldNotBeFound("isOnlyAdminTitle.doesNotContain=" + DEFAULT_IS_ONLY_ADMIN_TITLE);

        // Get all the uucUserBaseinfoList where isOnlyAdminTitle does not contain UPDATED_IS_ONLY_ADMIN_TITLE
        defaultUucUserBaseinfoShouldBeFound("isOnlyAdminTitle.doesNotContain=" + UPDATED_IS_ONLY_ADMIN_TITLE);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByJobnumberIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where jobnumber equals to DEFAULT_JOBNUMBER
        defaultUucUserBaseinfoShouldBeFound("jobnumber.equals=" + DEFAULT_JOBNUMBER);

        // Get all the uucUserBaseinfoList where jobnumber equals to UPDATED_JOBNUMBER
        defaultUucUserBaseinfoShouldNotBeFound("jobnumber.equals=" + UPDATED_JOBNUMBER);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByJobnumberIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where jobnumber not equals to DEFAULT_JOBNUMBER
        defaultUucUserBaseinfoShouldNotBeFound("jobnumber.notEquals=" + DEFAULT_JOBNUMBER);

        // Get all the uucUserBaseinfoList where jobnumber not equals to UPDATED_JOBNUMBER
        defaultUucUserBaseinfoShouldBeFound("jobnumber.notEquals=" + UPDATED_JOBNUMBER);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByJobnumberIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where jobnumber in DEFAULT_JOBNUMBER or UPDATED_JOBNUMBER
        defaultUucUserBaseinfoShouldBeFound("jobnumber.in=" + DEFAULT_JOBNUMBER + "," + UPDATED_JOBNUMBER);

        // Get all the uucUserBaseinfoList where jobnumber equals to UPDATED_JOBNUMBER
        defaultUucUserBaseinfoShouldNotBeFound("jobnumber.in=" + UPDATED_JOBNUMBER);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByJobnumberIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where jobnumber is not null
        defaultUucUserBaseinfoShouldBeFound("jobnumber.specified=true");

        // Get all the uucUserBaseinfoList where jobnumber is null
        defaultUucUserBaseinfoShouldNotBeFound("jobnumber.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByJobnumberContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where jobnumber contains DEFAULT_JOBNUMBER
        defaultUucUserBaseinfoShouldBeFound("jobnumber.contains=" + DEFAULT_JOBNUMBER);

        // Get all the uucUserBaseinfoList where jobnumber contains UPDATED_JOBNUMBER
        defaultUucUserBaseinfoShouldNotBeFound("jobnumber.contains=" + UPDATED_JOBNUMBER);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByJobnumberNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where jobnumber does not contain DEFAULT_JOBNUMBER
        defaultUucUserBaseinfoShouldNotBeFound("jobnumber.doesNotContain=" + DEFAULT_JOBNUMBER);

        // Get all the uucUserBaseinfoList where jobnumber does not contain UPDATED_JOBNUMBER
        defaultUucUserBaseinfoShouldBeFound("jobnumber.doesNotContain=" + UPDATED_JOBNUMBER);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAvatarIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where avatar equals to DEFAULT_AVATAR
        defaultUucUserBaseinfoShouldBeFound("avatar.equals=" + DEFAULT_AVATAR);

        // Get all the uucUserBaseinfoList where avatar equals to UPDATED_AVATAR
        defaultUucUserBaseinfoShouldNotBeFound("avatar.equals=" + UPDATED_AVATAR);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAvatarIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where avatar not equals to DEFAULT_AVATAR
        defaultUucUserBaseinfoShouldNotBeFound("avatar.notEquals=" + DEFAULT_AVATAR);

        // Get all the uucUserBaseinfoList where avatar not equals to UPDATED_AVATAR
        defaultUucUserBaseinfoShouldBeFound("avatar.notEquals=" + UPDATED_AVATAR);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAvatarIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where avatar in DEFAULT_AVATAR or UPDATED_AVATAR
        defaultUucUserBaseinfoShouldBeFound("avatar.in=" + DEFAULT_AVATAR + "," + UPDATED_AVATAR);

        // Get all the uucUserBaseinfoList where avatar equals to UPDATED_AVATAR
        defaultUucUserBaseinfoShouldNotBeFound("avatar.in=" + UPDATED_AVATAR);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAvatarIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where avatar is not null
        defaultUucUserBaseinfoShouldBeFound("avatar.specified=true");

        // Get all the uucUserBaseinfoList where avatar is null
        defaultUucUserBaseinfoShouldNotBeFound("avatar.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByAvatarContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where avatar contains DEFAULT_AVATAR
        defaultUucUserBaseinfoShouldBeFound("avatar.contains=" + DEFAULT_AVATAR);

        // Get all the uucUserBaseinfoList where avatar contains UPDATED_AVATAR
        defaultUucUserBaseinfoShouldNotBeFound("avatar.contains=" + UPDATED_AVATAR);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByAvatarNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where avatar does not contain DEFAULT_AVATAR
        defaultUucUserBaseinfoShouldNotBeFound("avatar.doesNotContain=" + DEFAULT_AVATAR);

        // Get all the uucUserBaseinfoList where avatar does not contain UPDATED_AVATAR
        defaultUucUserBaseinfoShouldBeFound("avatar.doesNotContain=" + UPDATED_AVATAR);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnNameIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enName equals to DEFAULT_EN_NAME
        defaultUucUserBaseinfoShouldBeFound("enName.equals=" + DEFAULT_EN_NAME);

        // Get all the uucUserBaseinfoList where enName equals to UPDATED_EN_NAME
        defaultUucUserBaseinfoShouldNotBeFound("enName.equals=" + UPDATED_EN_NAME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnNameIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enName not equals to DEFAULT_EN_NAME
        defaultUucUserBaseinfoShouldNotBeFound("enName.notEquals=" + DEFAULT_EN_NAME);

        // Get all the uucUserBaseinfoList where enName not equals to UPDATED_EN_NAME
        defaultUucUserBaseinfoShouldBeFound("enName.notEquals=" + UPDATED_EN_NAME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnNameIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enName in DEFAULT_EN_NAME or UPDATED_EN_NAME
        defaultUucUserBaseinfoShouldBeFound("enName.in=" + DEFAULT_EN_NAME + "," + UPDATED_EN_NAME);

        // Get all the uucUserBaseinfoList where enName equals to UPDATED_EN_NAME
        defaultUucUserBaseinfoShouldNotBeFound("enName.in=" + UPDATED_EN_NAME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enName is not null
        defaultUucUserBaseinfoShouldBeFound("enName.specified=true");

        // Get all the uucUserBaseinfoList where enName is null
        defaultUucUserBaseinfoShouldNotBeFound("enName.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnNameContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enName contains DEFAULT_EN_NAME
        defaultUucUserBaseinfoShouldBeFound("enName.contains=" + DEFAULT_EN_NAME);

        // Get all the uucUserBaseinfoList where enName contains UPDATED_EN_NAME
        defaultUucUserBaseinfoShouldNotBeFound("enName.contains=" + UPDATED_EN_NAME);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnNameNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enName does not contain DEFAULT_EN_NAME
        defaultUucUserBaseinfoShouldNotBeFound("enName.doesNotContain=" + DEFAULT_EN_NAME);

        // Get all the uucUserBaseinfoList where enName does not contain UPDATED_EN_NAME
        defaultUucUserBaseinfoShouldBeFound("enName.doesNotContain=" + UPDATED_EN_NAME);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnWorkplaceIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enWorkplace equals to DEFAULT_EN_WORKPLACE
        defaultUucUserBaseinfoShouldBeFound("enWorkplace.equals=" + DEFAULT_EN_WORKPLACE);

        // Get all the uucUserBaseinfoList where enWorkplace equals to UPDATED_EN_WORKPLACE
        defaultUucUserBaseinfoShouldNotBeFound("enWorkplace.equals=" + UPDATED_EN_WORKPLACE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnWorkplaceIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enWorkplace not equals to DEFAULT_EN_WORKPLACE
        defaultUucUserBaseinfoShouldNotBeFound("enWorkplace.notEquals=" + DEFAULT_EN_WORKPLACE);

        // Get all the uucUserBaseinfoList where enWorkplace not equals to UPDATED_EN_WORKPLACE
        defaultUucUserBaseinfoShouldBeFound("enWorkplace.notEquals=" + UPDATED_EN_WORKPLACE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnWorkplaceIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enWorkplace in DEFAULT_EN_WORKPLACE or UPDATED_EN_WORKPLACE
        defaultUucUserBaseinfoShouldBeFound("enWorkplace.in=" + DEFAULT_EN_WORKPLACE + "," + UPDATED_EN_WORKPLACE);

        // Get all the uucUserBaseinfoList where enWorkplace equals to UPDATED_EN_WORKPLACE
        defaultUucUserBaseinfoShouldNotBeFound("enWorkplace.in=" + UPDATED_EN_WORKPLACE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnWorkplaceIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enWorkplace is not null
        defaultUucUserBaseinfoShouldBeFound("enWorkplace.specified=true");

        // Get all the uucUserBaseinfoList where enWorkplace is null
        defaultUucUserBaseinfoShouldNotBeFound("enWorkplace.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnWorkplaceContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enWorkplace contains DEFAULT_EN_WORKPLACE
        defaultUucUserBaseinfoShouldBeFound("enWorkplace.contains=" + DEFAULT_EN_WORKPLACE);

        // Get all the uucUserBaseinfoList where enWorkplace contains UPDATED_EN_WORKPLACE
        defaultUucUserBaseinfoShouldNotBeFound("enWorkplace.contains=" + UPDATED_EN_WORKPLACE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnWorkplaceNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enWorkplace does not contain DEFAULT_EN_WORKPLACE
        defaultUucUserBaseinfoShouldNotBeFound("enWorkplace.doesNotContain=" + DEFAULT_EN_WORKPLACE);

        // Get all the uucUserBaseinfoList where enWorkplace does not contain UPDATED_EN_WORKPLACE
        defaultUucUserBaseinfoShouldBeFound("enWorkplace.doesNotContain=" + UPDATED_EN_WORKPLACE);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnTitleDescIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enTitleDesc equals to DEFAULT_EN_TITLE_DESC
        defaultUucUserBaseinfoShouldBeFound("enTitleDesc.equals=" + DEFAULT_EN_TITLE_DESC);

        // Get all the uucUserBaseinfoList where enTitleDesc equals to UPDATED_EN_TITLE_DESC
        defaultUucUserBaseinfoShouldNotBeFound("enTitleDesc.equals=" + UPDATED_EN_TITLE_DESC);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnTitleDescIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enTitleDesc not equals to DEFAULT_EN_TITLE_DESC
        defaultUucUserBaseinfoShouldNotBeFound("enTitleDesc.notEquals=" + DEFAULT_EN_TITLE_DESC);

        // Get all the uucUserBaseinfoList where enTitleDesc not equals to UPDATED_EN_TITLE_DESC
        defaultUucUserBaseinfoShouldBeFound("enTitleDesc.notEquals=" + UPDATED_EN_TITLE_DESC);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnTitleDescIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enTitleDesc in DEFAULT_EN_TITLE_DESC or UPDATED_EN_TITLE_DESC
        defaultUucUserBaseinfoShouldBeFound("enTitleDesc.in=" + DEFAULT_EN_TITLE_DESC + "," + UPDATED_EN_TITLE_DESC);

        // Get all the uucUserBaseinfoList where enTitleDesc equals to UPDATED_EN_TITLE_DESC
        defaultUucUserBaseinfoShouldNotBeFound("enTitleDesc.in=" + UPDATED_EN_TITLE_DESC);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnTitleDescIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enTitleDesc is not null
        defaultUucUserBaseinfoShouldBeFound("enTitleDesc.specified=true");

        // Get all the uucUserBaseinfoList where enTitleDesc is null
        defaultUucUserBaseinfoShouldNotBeFound("enTitleDesc.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnTitleDescContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enTitleDesc contains DEFAULT_EN_TITLE_DESC
        defaultUucUserBaseinfoShouldBeFound("enTitleDesc.contains=" + DEFAULT_EN_TITLE_DESC);

        // Get all the uucUserBaseinfoList where enTitleDesc contains UPDATED_EN_TITLE_DESC
        defaultUucUserBaseinfoShouldNotBeFound("enTitleDesc.contains=" + UPDATED_EN_TITLE_DESC);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEnTitleDescNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where enTitleDesc does not contain DEFAULT_EN_TITLE_DESC
        defaultUucUserBaseinfoShouldNotBeFound("enTitleDesc.doesNotContain=" + DEFAULT_EN_TITLE_DESC);

        // Get all the uucUserBaseinfoList where enTitleDesc does not contain UPDATED_EN_TITLE_DESC
        defaultUucUserBaseinfoShouldBeFound("enTitleDesc.doesNotContain=" + UPDATED_EN_TITLE_DESC);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByOnlyCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where onlyCode equals to DEFAULT_ONLY_CODE
        defaultUucUserBaseinfoShouldBeFound("onlyCode.equals=" + DEFAULT_ONLY_CODE);

        // Get all the uucUserBaseinfoList where onlyCode equals to UPDATED_ONLY_CODE
        defaultUucUserBaseinfoShouldNotBeFound("onlyCode.equals=" + UPDATED_ONLY_CODE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByOnlyCodeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where onlyCode not equals to DEFAULT_ONLY_CODE
        defaultUucUserBaseinfoShouldNotBeFound("onlyCode.notEquals=" + DEFAULT_ONLY_CODE);

        // Get all the uucUserBaseinfoList where onlyCode not equals to UPDATED_ONLY_CODE
        defaultUucUserBaseinfoShouldBeFound("onlyCode.notEquals=" + UPDATED_ONLY_CODE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByOnlyCodeIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where onlyCode in DEFAULT_ONLY_CODE or UPDATED_ONLY_CODE
        defaultUucUserBaseinfoShouldBeFound("onlyCode.in=" + DEFAULT_ONLY_CODE + "," + UPDATED_ONLY_CODE);

        // Get all the uucUserBaseinfoList where onlyCode equals to UPDATED_ONLY_CODE
        defaultUucUserBaseinfoShouldNotBeFound("onlyCode.in=" + UPDATED_ONLY_CODE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByOnlyCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where onlyCode is not null
        defaultUucUserBaseinfoShouldBeFound("onlyCode.specified=true");

        // Get all the uucUserBaseinfoList where onlyCode is null
        defaultUucUserBaseinfoShouldNotBeFound("onlyCode.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByOnlyCodeContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where onlyCode contains DEFAULT_ONLY_CODE
        defaultUucUserBaseinfoShouldBeFound("onlyCode.contains=" + DEFAULT_ONLY_CODE);

        // Get all the uucUserBaseinfoList where onlyCode contains UPDATED_ONLY_CODE
        defaultUucUserBaseinfoShouldNotBeFound("onlyCode.contains=" + UPDATED_ONLY_CODE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByOnlyCodeNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where onlyCode does not contain DEFAULT_ONLY_CODE
        defaultUucUserBaseinfoShouldNotBeFound("onlyCode.doesNotContain=" + DEFAULT_ONLY_CODE);

        // Get all the uucUserBaseinfoList where onlyCode does not contain UPDATED_ONLY_CODE
        defaultUucUserBaseinfoShouldBeFound("onlyCode.doesNotContain=" + UPDATED_ONLY_CODE);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByHrCardIdIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where hrCardId equals to DEFAULT_HR_CARD_ID
        defaultUucUserBaseinfoShouldBeFound("hrCardId.equals=" + DEFAULT_HR_CARD_ID);

        // Get all the uucUserBaseinfoList where hrCardId equals to UPDATED_HR_CARD_ID
        defaultUucUserBaseinfoShouldNotBeFound("hrCardId.equals=" + UPDATED_HR_CARD_ID);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByHrCardIdIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where hrCardId not equals to DEFAULT_HR_CARD_ID
        defaultUucUserBaseinfoShouldNotBeFound("hrCardId.notEquals=" + DEFAULT_HR_CARD_ID);

        // Get all the uucUserBaseinfoList where hrCardId not equals to UPDATED_HR_CARD_ID
        defaultUucUserBaseinfoShouldBeFound("hrCardId.notEquals=" + UPDATED_HR_CARD_ID);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByHrCardIdIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where hrCardId in DEFAULT_HR_CARD_ID or UPDATED_HR_CARD_ID
        defaultUucUserBaseinfoShouldBeFound("hrCardId.in=" + DEFAULT_HR_CARD_ID + "," + UPDATED_HR_CARD_ID);

        // Get all the uucUserBaseinfoList where hrCardId equals to UPDATED_HR_CARD_ID
        defaultUucUserBaseinfoShouldNotBeFound("hrCardId.in=" + UPDATED_HR_CARD_ID);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByHrCardIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where hrCardId is not null
        defaultUucUserBaseinfoShouldBeFound("hrCardId.specified=true");

        // Get all the uucUserBaseinfoList where hrCardId is null
        defaultUucUserBaseinfoShouldNotBeFound("hrCardId.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByHrCardIdContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where hrCardId contains DEFAULT_HR_CARD_ID
        defaultUucUserBaseinfoShouldBeFound("hrCardId.contains=" + DEFAULT_HR_CARD_ID);

        // Get all the uucUserBaseinfoList where hrCardId contains UPDATED_HR_CARD_ID
        defaultUucUserBaseinfoShouldNotBeFound("hrCardId.contains=" + UPDATED_HR_CARD_ID);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByHrCardIdNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where hrCardId does not contain DEFAULT_HR_CARD_ID
        defaultUucUserBaseinfoShouldNotBeFound("hrCardId.doesNotContain=" + DEFAULT_HR_CARD_ID);

        // Get all the uucUserBaseinfoList where hrCardId does not contain UPDATED_HR_CARD_ID
        defaultUucUserBaseinfoShouldBeFound("hrCardId.doesNotContain=" + UPDATED_HR_CARD_ID);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEmployeeTypeIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where employeeType equals to DEFAULT_EMPLOYEE_TYPE
        defaultUucUserBaseinfoShouldBeFound("employeeType.equals=" + DEFAULT_EMPLOYEE_TYPE);

        // Get all the uucUserBaseinfoList where employeeType equals to UPDATED_EMPLOYEE_TYPE
        defaultUucUserBaseinfoShouldNotBeFound("employeeType.equals=" + UPDATED_EMPLOYEE_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEmployeeTypeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where employeeType not equals to DEFAULT_EMPLOYEE_TYPE
        defaultUucUserBaseinfoShouldNotBeFound("employeeType.notEquals=" + DEFAULT_EMPLOYEE_TYPE);

        // Get all the uucUserBaseinfoList where employeeType not equals to UPDATED_EMPLOYEE_TYPE
        defaultUucUserBaseinfoShouldBeFound("employeeType.notEquals=" + UPDATED_EMPLOYEE_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEmployeeTypeIsInShouldWork() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where employeeType in DEFAULT_EMPLOYEE_TYPE or UPDATED_EMPLOYEE_TYPE
        defaultUucUserBaseinfoShouldBeFound("employeeType.in=" + DEFAULT_EMPLOYEE_TYPE + "," + UPDATED_EMPLOYEE_TYPE);

        // Get all the uucUserBaseinfoList where employeeType equals to UPDATED_EMPLOYEE_TYPE
        defaultUucUserBaseinfoShouldNotBeFound("employeeType.in=" + UPDATED_EMPLOYEE_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEmployeeTypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where employeeType is not null
        defaultUucUserBaseinfoShouldBeFound("employeeType.specified=true");

        // Get all the uucUserBaseinfoList where employeeType is null
        defaultUucUserBaseinfoShouldNotBeFound("employeeType.specified=false");
    }
                @Test
    @Transactional
    public void getAllUucUserBaseinfosByEmployeeTypeContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where employeeType contains DEFAULT_EMPLOYEE_TYPE
        defaultUucUserBaseinfoShouldBeFound("employeeType.contains=" + DEFAULT_EMPLOYEE_TYPE);

        // Get all the uucUserBaseinfoList where employeeType contains UPDATED_EMPLOYEE_TYPE
        defaultUucUserBaseinfoShouldNotBeFound("employeeType.contains=" + UPDATED_EMPLOYEE_TYPE);
    }

    @Test
    @Transactional
    public void getAllUucUserBaseinfosByEmployeeTypeNotContainsSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);

        // Get all the uucUserBaseinfoList where employeeType does not contain DEFAULT_EMPLOYEE_TYPE
        defaultUucUserBaseinfoShouldNotBeFound("employeeType.doesNotContain=" + DEFAULT_EMPLOYEE_TYPE);

        // Get all the uucUserBaseinfoList where employeeType does not contain UPDATED_EMPLOYEE_TYPE
        defaultUucUserBaseinfoShouldBeFound("employeeType.doesNotContain=" + UPDATED_EMPLOYEE_TYPE);
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByCollectionFmpMicroAppIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);
        FmpMicroApp collectionFmpMicroApp = FmpMicroAppResourceIT.createEntity(em);
        em.persist(collectionFmpMicroApp);
        em.flush();
        uucUserBaseinfo.addCollectionFmpMicroApp(collectionFmpMicroApp);
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);
        Long collectionFmpMicroAppId = collectionFmpMicroApp.getId();

        // Get all the uucUserBaseinfoList where collectionFmpMicroApp equals to collectionFmpMicroAppId
        defaultUucUserBaseinfoShouldBeFound("collectionFmpMicroAppId.equals=" + collectionFmpMicroAppId);

        // Get all the uucUserBaseinfoList where collectionFmpMicroApp equals to collectionFmpMicroAppId + 1
        defaultUucUserBaseinfoShouldNotBeFound("collectionFmpMicroAppId.equals=" + (collectionFmpMicroAppId + 1));
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByMicroAppGroupIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);
        MicroAppGroup microAppGroup = MicroAppGroupResourceIT.createEntity(em);
        em.persist(microAppGroup);
        em.flush();
        uucUserBaseinfo.setMicroAppGroup(microAppGroup);
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);
        Long microAppGroupId = microAppGroup.getId();

        // Get all the uucUserBaseinfoList where microAppGroup equals to microAppGroupId
        defaultUucUserBaseinfoShouldBeFound("microAppGroupId.equals=" + microAppGroupId);

        // Get all the uucUserBaseinfoList where microAppGroup equals to microAppGroupId + 1
        defaultUucUserBaseinfoShouldNotBeFound("microAppGroupId.equals=" + (microAppGroupId + 1));
    }


    @Test
    @Transactional
    public void getAllUucUserBaseinfosByUsableFmpMicroAppIsEqualToSomething() throws Exception {
        // Initialize the database
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);
        FmpMicroApp usableFmpMicroApp = FmpMicroAppResourceIT.createEntity(em);
        em.persist(usableFmpMicroApp);
        em.flush();
        uucUserBaseinfo.addUsableFmpMicroApp(usableFmpMicroApp);
        uucUserBaseinfoRepository.saveAndFlush(uucUserBaseinfo);
        Long usableFmpMicroAppId = usableFmpMicroApp.getId();

        // Get all the uucUserBaseinfoList where usableFmpMicroApp equals to usableFmpMicroAppId
        defaultUucUserBaseinfoShouldBeFound("usableFmpMicroAppId.equals=" + usableFmpMicroAppId);

        // Get all the uucUserBaseinfoList where usableFmpMicroApp equals to usableFmpMicroAppId + 1
        defaultUucUserBaseinfoShouldNotBeFound("usableFmpMicroAppId.equals=" + (usableFmpMicroAppId + 1));
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultUucUserBaseinfoShouldBeFound(String filter) throws Exception {
        restUucUserBaseinfoMockMvc.perform(get("/api/uuc-user-baseinfos?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(uucUserBaseinfo.getId().intValue())))
            .andExpect(jsonPath("$.[*].jobCode").value(hasItem(DEFAULT_JOB_CODE)))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)))
            .andExpect(jsonPath("$.[*].fullname").value(hasItem(DEFAULT_FULLNAME)))
            .andExpect(jsonPath("$.[*].namePy").value(hasItem(DEFAULT_NAME_PY)))
            .andExpect(jsonPath("$.[*].sex").value(hasItem(DEFAULT_SEX)))
            .andExpect(jsonPath("$.[*].birthday").value(hasItem(DEFAULT_BIRTHDAY)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].tel").value(hasItem(DEFAULT_TEL)))
            .andExpect(jsonPath("$.[*].telExt").value(hasItem(DEFAULT_TEL_EXT)))
            .andExpect(jsonPath("$.[*].stateCode1").value(hasItem(DEFAULT_STATE_CODE_1)))
            .andExpect(jsonPath("$.[*].mobile1").value(hasItem(DEFAULT_MOBILE_1)))
            .andExpect(jsonPath("$.[*].stateCode2").value(hasItem(DEFAULT_STATE_CODE_2)))
            .andExpect(jsonPath("$.[*].mobile2").value(hasItem(DEFAULT_MOBILE_2)))
            .andExpect(jsonPath("$.[*].stateCode3").value(hasItem(DEFAULT_STATE_CODE_3)))
            .andExpect(jsonPath("$.[*].mobile3").value(hasItem(DEFAULT_MOBILE_3)))
            .andExpect(jsonPath("$.[*].stateCode4").value(hasItem(DEFAULT_STATE_CODE_4)))
            .andExpect(jsonPath("$.[*].mobile4").value(hasItem(DEFAULT_MOBILE_4)))
            .andExpect(jsonPath("$.[*].stateCode5").value(hasItem(DEFAULT_STATE_CODE_5)))
            .andExpect(jsonPath("$.[*].mobile5").value(hasItem(DEFAULT_MOBILE_5)))
            .andExpect(jsonPath("$.[*].titleDesc").value(hasItem(DEFAULT_TITLE_DESC)))
            .andExpect(jsonPath("$.[*].titleEn").value(hasItem(DEFAULT_TITLE_EN)))
            .andExpect(jsonPath("$.[*].checkNum").value(hasItem(DEFAULT_CHECK_NUM)))
            .andExpect(jsonPath("$.[*].disporder").value(hasItem(DEFAULT_DISPORDER)))
            .andExpect(jsonPath("$.[*].workPlace").value(hasItem(DEFAULT_WORK_PLACE)))
            .andExpect(jsonPath("$.[*].userLevel").value(hasItem(DEFAULT_USER_LEVEL)))
            .andExpect(jsonPath("$.[*].hiredate").value(hasItem(DEFAULT_HIREDATE.toString())))
            .andExpect(jsonPath("$.[*].nickname").value(hasItem(DEFAULT_NICKNAME)))
            .andExpect(jsonPath("$.[*].memo").value(hasItem(DEFAULT_MEMO)))
            .andExpect(jsonPath("$.[*].isHidden").value(hasItem(DEFAULT_IS_HIDDEN)))
            .andExpect(jsonPath("$.[*].aliveFlag").value(hasItem(DEFAULT_ALIVE_FLAG)))
            .andExpect(jsonPath("$.[*].recCreateTime").value(hasItem(DEFAULT_REC_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].recCreator").value(hasItem(DEFAULT_REC_CREATOR)))
            .andExpect(jsonPath("$.[*].recReviseTime").value(hasItem(DEFAULT_REC_REVISE_TIME.toString())))
            .andExpect(jsonPath("$.[*].recRevisor").value(hasItem(DEFAULT_REC_REVISOR)))
            .andExpect(jsonPath("$.[*].isActivated").value(hasItem(DEFAULT_IS_ACTIVATED)))
            .andExpect(jsonPath("$.[*].activationTime").value(hasItem(DEFAULT_ACTIVATION_TIME.toString())))
            .andExpect(jsonPath("$.[*].appVersion").value(hasItem(DEFAULT_APP_VERSION)))
            .andExpect(jsonPath("$.[*].isOnlyAdminTitle").value(hasItem(DEFAULT_IS_ONLY_ADMIN_TITLE)))
            .andExpect(jsonPath("$.[*].jobnumber").value(hasItem(DEFAULT_JOBNUMBER)))
            .andExpect(jsonPath("$.[*].avatar").value(hasItem(DEFAULT_AVATAR)))
            .andExpect(jsonPath("$.[*].enName").value(hasItem(DEFAULT_EN_NAME)))
            .andExpect(jsonPath("$.[*].enWorkplace").value(hasItem(DEFAULT_EN_WORKPLACE)))
            .andExpect(jsonPath("$.[*].enTitleDesc").value(hasItem(DEFAULT_EN_TITLE_DESC)))
            .andExpect(jsonPath("$.[*].onlyCode").value(hasItem(DEFAULT_ONLY_CODE)))
            .andExpect(jsonPath("$.[*].hrCardId").value(hasItem(DEFAULT_HR_CARD_ID)))
            .andExpect(jsonPath("$.[*].employeeType").value(hasItem(DEFAULT_EMPLOYEE_TYPE)));

        // Check, that the count call also returns 1
        restUucUserBaseinfoMockMvc.perform(get("/api/uuc-user-baseinfos/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultUucUserBaseinfoShouldNotBeFound(String filter) throws Exception {
        restUucUserBaseinfoMockMvc.perform(get("/api/uuc-user-baseinfos?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restUucUserBaseinfoMockMvc.perform(get("/api/uuc-user-baseinfos/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    public void getNonExistingUucUserBaseinfo() throws Exception {
        // Get the uucUserBaseinfo
        restUucUserBaseinfoMockMvc.perform(get("/api/uuc-user-baseinfos/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateUucUserBaseinfo() throws Exception {
        // Initialize the database
        uucUserBaseinfoService.save(uucUserBaseinfo);

        int databaseSizeBeforeUpdate = uucUserBaseinfoRepository.findAll().size();

        // Update the uucUserBaseinfo
        UucUserBaseinfo updatedUucUserBaseinfo = uucUserBaseinfoRepository.findById(uucUserBaseinfo.getId()).get();
        // Disconnect from session so that the updates on updatedUucUserBaseinfo are not directly saved in db
        em.detach(updatedUucUserBaseinfo);
        updatedUucUserBaseinfo
            .jobCode(UPDATED_JOB_CODE)
            .type(UPDATED_TYPE)
            .fullname(UPDATED_FULLNAME)
            .namePy(UPDATED_NAME_PY)
            .sex(UPDATED_SEX)
            .birthday(UPDATED_BIRTHDAY)
            .email(UPDATED_EMAIL)
            .tel(UPDATED_TEL)
            .telExt(UPDATED_TEL_EXT)
            .stateCode1(UPDATED_STATE_CODE_1)
            .mobile1(UPDATED_MOBILE_1)
            .stateCode2(UPDATED_STATE_CODE_2)
            .mobile2(UPDATED_MOBILE_2)
            .stateCode3(UPDATED_STATE_CODE_3)
            .mobile3(UPDATED_MOBILE_3)
            .stateCode4(UPDATED_STATE_CODE_4)
            .mobile4(UPDATED_MOBILE_4)
            .stateCode5(UPDATED_STATE_CODE_5)
            .mobile5(UPDATED_MOBILE_5)
            .titleDesc(UPDATED_TITLE_DESC)
            .titleEn(UPDATED_TITLE_EN)
            .checkNum(UPDATED_CHECK_NUM)
            .disporder(UPDATED_DISPORDER)
            .workPlace(UPDATED_WORK_PLACE)
            .userLevel(UPDATED_USER_LEVEL)
            .hiredate(UPDATED_HIREDATE)
            .nickname(UPDATED_NICKNAME)
            .memo(UPDATED_MEMO)
            .isHidden(UPDATED_IS_HIDDEN)
            .aliveFlag(UPDATED_ALIVE_FLAG)
            .recCreateTime(UPDATED_REC_CREATE_TIME)
            .recCreator(UPDATED_REC_CREATOR)
            .recReviseTime(UPDATED_REC_REVISE_TIME)
            .recRevisor(UPDATED_REC_REVISOR)
            .isActivated(UPDATED_IS_ACTIVATED)
            .activationTime(UPDATED_ACTIVATION_TIME)
            .appVersion(UPDATED_APP_VERSION)
            .isOnlyAdminTitle(UPDATED_IS_ONLY_ADMIN_TITLE)
            .jobnumber(UPDATED_JOBNUMBER)
            .avatar(UPDATED_AVATAR)
            .enName(UPDATED_EN_NAME)
            .enWorkplace(UPDATED_EN_WORKPLACE)
            .enTitleDesc(UPDATED_EN_TITLE_DESC)
            .onlyCode(UPDATED_ONLY_CODE)
            .hrCardId(UPDATED_HR_CARD_ID)
            .employeeType(UPDATED_EMPLOYEE_TYPE);

        restUucUserBaseinfoMockMvc.perform(put("/api/uuc-user-baseinfos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedUucUserBaseinfo)))
            .andExpect(status().isOk());

        // Validate the UucUserBaseinfo in the database
        List<UucUserBaseinfo> uucUserBaseinfoList = uucUserBaseinfoRepository.findAll();
        assertThat(uucUserBaseinfoList).hasSize(databaseSizeBeforeUpdate);
        UucUserBaseinfo testUucUserBaseinfo = uucUserBaseinfoList.get(uucUserBaseinfoList.size() - 1);
        assertThat(testUucUserBaseinfo.getJobCode()).isEqualTo(UPDATED_JOB_CODE);
        assertThat(testUucUserBaseinfo.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testUucUserBaseinfo.getFullname()).isEqualTo(UPDATED_FULLNAME);
        assertThat(testUucUserBaseinfo.getNamePy()).isEqualTo(UPDATED_NAME_PY);
        assertThat(testUucUserBaseinfo.getSex()).isEqualTo(UPDATED_SEX);
        assertThat(testUucUserBaseinfo.getBirthday()).isEqualTo(UPDATED_BIRTHDAY);
        assertThat(testUucUserBaseinfo.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testUucUserBaseinfo.getTel()).isEqualTo(UPDATED_TEL);
        assertThat(testUucUserBaseinfo.getTelExt()).isEqualTo(UPDATED_TEL_EXT);
        assertThat(testUucUserBaseinfo.getStateCode1()).isEqualTo(UPDATED_STATE_CODE_1);
        assertThat(testUucUserBaseinfo.getMobile1()).isEqualTo(UPDATED_MOBILE_1);
        assertThat(testUucUserBaseinfo.getStateCode2()).isEqualTo(UPDATED_STATE_CODE_2);
        assertThat(testUucUserBaseinfo.getMobile2()).isEqualTo(UPDATED_MOBILE_2);
        assertThat(testUucUserBaseinfo.getStateCode3()).isEqualTo(UPDATED_STATE_CODE_3);
        assertThat(testUucUserBaseinfo.getMobile3()).isEqualTo(UPDATED_MOBILE_3);
        assertThat(testUucUserBaseinfo.getStateCode4()).isEqualTo(UPDATED_STATE_CODE_4);
        assertThat(testUucUserBaseinfo.getMobile4()).isEqualTo(UPDATED_MOBILE_4);
        assertThat(testUucUserBaseinfo.getStateCode5()).isEqualTo(UPDATED_STATE_CODE_5);
        assertThat(testUucUserBaseinfo.getMobile5()).isEqualTo(UPDATED_MOBILE_5);
        assertThat(testUucUserBaseinfo.getTitleDesc()).isEqualTo(UPDATED_TITLE_DESC);
        assertThat(testUucUserBaseinfo.getTitleEn()).isEqualTo(UPDATED_TITLE_EN);
        assertThat(testUucUserBaseinfo.getCheckNum()).isEqualTo(UPDATED_CHECK_NUM);
        assertThat(testUucUserBaseinfo.getDisporder()).isEqualTo(UPDATED_DISPORDER);
        assertThat(testUucUserBaseinfo.getWorkPlace()).isEqualTo(UPDATED_WORK_PLACE);
        assertThat(testUucUserBaseinfo.getUserLevel()).isEqualTo(UPDATED_USER_LEVEL);
        assertThat(testUucUserBaseinfo.getHiredate()).isEqualTo(UPDATED_HIREDATE);
        assertThat(testUucUserBaseinfo.getNickname()).isEqualTo(UPDATED_NICKNAME);
        assertThat(testUucUserBaseinfo.getMemo()).isEqualTo(UPDATED_MEMO);
        assertThat(testUucUserBaseinfo.getIsHidden()).isEqualTo(UPDATED_IS_HIDDEN);
        assertThat(testUucUserBaseinfo.getAliveFlag()).isEqualTo(UPDATED_ALIVE_FLAG);
        assertThat(testUucUserBaseinfo.getRecCreateTime()).isEqualTo(UPDATED_REC_CREATE_TIME);
        assertThat(testUucUserBaseinfo.getRecCreator()).isEqualTo(UPDATED_REC_CREATOR);
        assertThat(testUucUserBaseinfo.getRecReviseTime()).isEqualTo(UPDATED_REC_REVISE_TIME);
        assertThat(testUucUserBaseinfo.getRecRevisor()).isEqualTo(UPDATED_REC_REVISOR);
        assertThat(testUucUserBaseinfo.getIsActivated()).isEqualTo(UPDATED_IS_ACTIVATED);
        assertThat(testUucUserBaseinfo.getActivationTime()).isEqualTo(UPDATED_ACTIVATION_TIME);
        assertThat(testUucUserBaseinfo.getAppVersion()).isEqualTo(UPDATED_APP_VERSION);
        assertThat(testUucUserBaseinfo.getIsOnlyAdminTitle()).isEqualTo(UPDATED_IS_ONLY_ADMIN_TITLE);
        assertThat(testUucUserBaseinfo.getJobnumber()).isEqualTo(UPDATED_JOBNUMBER);
        assertThat(testUucUserBaseinfo.getAvatar()).isEqualTo(UPDATED_AVATAR);
        assertThat(testUucUserBaseinfo.getEnName()).isEqualTo(UPDATED_EN_NAME);
        assertThat(testUucUserBaseinfo.getEnWorkplace()).isEqualTo(UPDATED_EN_WORKPLACE);
        assertThat(testUucUserBaseinfo.getEnTitleDesc()).isEqualTo(UPDATED_EN_TITLE_DESC);
        assertThat(testUucUserBaseinfo.getOnlyCode()).isEqualTo(UPDATED_ONLY_CODE);
        assertThat(testUucUserBaseinfo.getHrCardId()).isEqualTo(UPDATED_HR_CARD_ID);
        assertThat(testUucUserBaseinfo.getEmployeeType()).isEqualTo(UPDATED_EMPLOYEE_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingUucUserBaseinfo() throws Exception {
        int databaseSizeBeforeUpdate = uucUserBaseinfoRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restUucUserBaseinfoMockMvc.perform(put("/api/uuc-user-baseinfos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(uucUserBaseinfo)))
            .andExpect(status().isBadRequest());

        // Validate the UucUserBaseinfo in the database
        List<UucUserBaseinfo> uucUserBaseinfoList = uucUserBaseinfoRepository.findAll();
        assertThat(uucUserBaseinfoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteUucUserBaseinfo() throws Exception {
        // Initialize the database
        uucUserBaseinfoService.save(uucUserBaseinfo);

        int databaseSizeBeforeDelete = uucUserBaseinfoRepository.findAll().size();

        // Delete the uucUserBaseinfo
        restUucUserBaseinfoMockMvc.perform(delete("/api/uuc-user-baseinfos/{id}", uucUserBaseinfo.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<UucUserBaseinfo> uucUserBaseinfoList = uucUserBaseinfoRepository.findAll();
        assertThat(uucUserBaseinfoList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
