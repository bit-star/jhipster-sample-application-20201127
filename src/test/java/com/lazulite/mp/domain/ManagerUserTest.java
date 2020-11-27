package com.lazulite.mp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.lazulite.mp.web.rest.TestUtil;

public class ManagerUserTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ManagerUser.class);
        ManagerUser managerUser1 = new ManagerUser();
        managerUser1.setId(1L);
        ManagerUser managerUser2 = new ManagerUser();
        managerUser2.setId(managerUser1.getId());
        assertThat(managerUser1).isEqualTo(managerUser2);
        managerUser2.setId(2L);
        assertThat(managerUser1).isNotEqualTo(managerUser2);
        managerUser1.setId(null);
        assertThat(managerUser1).isNotEqualTo(managerUser2);
    }
}
