package com.lazulite.mp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.lazulite.mp.web.rest.TestUtil;

public class DdUserPortalRoutingTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DdUserPortalRouting.class);
        DdUserPortalRouting ddUserPortalRouting1 = new DdUserPortalRouting();
        ddUserPortalRouting1.setId(1L);
        DdUserPortalRouting ddUserPortalRouting2 = new DdUserPortalRouting();
        ddUserPortalRouting2.setId(ddUserPortalRouting1.getId());
        assertThat(ddUserPortalRouting1).isEqualTo(ddUserPortalRouting2);
        ddUserPortalRouting2.setId(2L);
        assertThat(ddUserPortalRouting1).isNotEqualTo(ddUserPortalRouting2);
        ddUserPortalRouting1.setId(null);
        assertThat(ddUserPortalRouting1).isNotEqualTo(ddUserPortalRouting2);
    }
}
