package com.lazulite.mp.web.rest;

import com.lazulite.mp.JhipsterSampleApplication20201127App;
import com.lazulite.mp.domain.ManagerUser;
import com.lazulite.mp.repository.ManagerUserRepository;
import com.lazulite.mp.service.ManagerUserService;

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

import com.lazulite.mp.domain.enumeration.ManagerUserType;
/**
 * Integration tests for the {@link ManagerUserResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplication20201127App.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
public class ManagerUserResourceIT {

    private static final Long DEFAULT_PARENT_ID = 1L;
    private static final Long UPDATED_PARENT_ID = 2L;

    private static final ManagerUserType DEFAULT_TYPE = ManagerUserType.SuperAdministrator;
    private static final ManagerUserType UPDATED_TYPE = ManagerUserType.NormalAdministrator;

    @Autowired
    private ManagerUserRepository managerUserRepository;

    @Mock
    private ManagerUserRepository managerUserRepositoryMock;

    @Mock
    private ManagerUserService managerUserServiceMock;

    @Autowired
    private ManagerUserService managerUserService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restManagerUserMockMvc;

    private ManagerUser managerUser;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ManagerUser createEntity(EntityManager em) {
        ManagerUser managerUser = new ManagerUser()
            .parentId(DEFAULT_PARENT_ID)
            .type(DEFAULT_TYPE);
        return managerUser;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ManagerUser createUpdatedEntity(EntityManager em) {
        ManagerUser managerUser = new ManagerUser()
            .parentId(UPDATED_PARENT_ID)
            .type(UPDATED_TYPE);
        return managerUser;
    }

    @BeforeEach
    public void initTest() {
        managerUser = createEntity(em);
    }

    @Test
    @Transactional
    public void createManagerUser() throws Exception {
        int databaseSizeBeforeCreate = managerUserRepository.findAll().size();
        // Create the ManagerUser
        restManagerUserMockMvc.perform(post("/api/manager-users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(managerUser)))
            .andExpect(status().isCreated());

        // Validate the ManagerUser in the database
        List<ManagerUser> managerUserList = managerUserRepository.findAll();
        assertThat(managerUserList).hasSize(databaseSizeBeforeCreate + 1);
        ManagerUser testManagerUser = managerUserList.get(managerUserList.size() - 1);
        assertThat(testManagerUser.getParentId()).isEqualTo(DEFAULT_PARENT_ID);
        assertThat(testManagerUser.getType()).isEqualTo(DEFAULT_TYPE);
    }

    @Test
    @Transactional
    public void createManagerUserWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = managerUserRepository.findAll().size();

        // Create the ManagerUser with an existing ID
        managerUser.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restManagerUserMockMvc.perform(post("/api/manager-users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(managerUser)))
            .andExpect(status().isBadRequest());

        // Validate the ManagerUser in the database
        List<ManagerUser> managerUserList = managerUserRepository.findAll();
        assertThat(managerUserList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllManagerUsers() throws Exception {
        // Initialize the database
        managerUserRepository.saveAndFlush(managerUser);

        // Get all the managerUserList
        restManagerUserMockMvc.perform(get("/api/manager-users?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(managerUser.getId().intValue())))
            .andExpect(jsonPath("$.[*].parentId").value(hasItem(DEFAULT_PARENT_ID.intValue())))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE.toString())));
    }
    
    @SuppressWarnings({"unchecked"})
    public void getAllManagerUsersWithEagerRelationshipsIsEnabled() throws Exception {
        when(managerUserServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restManagerUserMockMvc.perform(get("/api/manager-users?eagerload=true"))
            .andExpect(status().isOk());

        verify(managerUserServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    @SuppressWarnings({"unchecked"})
    public void getAllManagerUsersWithEagerRelationshipsIsNotEnabled() throws Exception {
        when(managerUserServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restManagerUserMockMvc.perform(get("/api/manager-users?eagerload=true"))
            .andExpect(status().isOk());

        verify(managerUserServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    @Test
    @Transactional
    public void getManagerUser() throws Exception {
        // Initialize the database
        managerUserRepository.saveAndFlush(managerUser);

        // Get the managerUser
        restManagerUserMockMvc.perform(get("/api/manager-users/{id}", managerUser.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(managerUser.getId().intValue()))
            .andExpect(jsonPath("$.parentId").value(DEFAULT_PARENT_ID.intValue()))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingManagerUser() throws Exception {
        // Get the managerUser
        restManagerUserMockMvc.perform(get("/api/manager-users/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateManagerUser() throws Exception {
        // Initialize the database
        managerUserService.save(managerUser);

        int databaseSizeBeforeUpdate = managerUserRepository.findAll().size();

        // Update the managerUser
        ManagerUser updatedManagerUser = managerUserRepository.findById(managerUser.getId()).get();
        // Disconnect from session so that the updates on updatedManagerUser are not directly saved in db
        em.detach(updatedManagerUser);
        updatedManagerUser
            .parentId(UPDATED_PARENT_ID)
            .type(UPDATED_TYPE);

        restManagerUserMockMvc.perform(put("/api/manager-users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedManagerUser)))
            .andExpect(status().isOk());

        // Validate the ManagerUser in the database
        List<ManagerUser> managerUserList = managerUserRepository.findAll();
        assertThat(managerUserList).hasSize(databaseSizeBeforeUpdate);
        ManagerUser testManagerUser = managerUserList.get(managerUserList.size() - 1);
        assertThat(testManagerUser.getParentId()).isEqualTo(UPDATED_PARENT_ID);
        assertThat(testManagerUser.getType()).isEqualTo(UPDATED_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingManagerUser() throws Exception {
        int databaseSizeBeforeUpdate = managerUserRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restManagerUserMockMvc.perform(put("/api/manager-users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(managerUser)))
            .andExpect(status().isBadRequest());

        // Validate the ManagerUser in the database
        List<ManagerUser> managerUserList = managerUserRepository.findAll();
        assertThat(managerUserList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteManagerUser() throws Exception {
        // Initialize the database
        managerUserService.save(managerUser);

        int databaseSizeBeforeDelete = managerUserRepository.findAll().size();

        // Delete the managerUser
        restManagerUserMockMvc.perform(delete("/api/manager-users/{id}", managerUser.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ManagerUser> managerUserList = managerUserRepository.findAll();
        assertThat(managerUserList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
