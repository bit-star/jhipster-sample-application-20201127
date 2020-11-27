package com.lazulite.mp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.lazulite.mp.web.rest.TestUtil;

public class PortalRoutingTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PortalRouting.class);
        PortalRouting portalRouting1 = new PortalRouting();
        portalRouting1.setId(1L);
        PortalRouting portalRouting2 = new PortalRouting();
        portalRouting2.setId(portalRouting1.getId());
        assertThat(portalRouting1).isEqualTo(portalRouting2);
        portalRouting2.setId(2L);
        assertThat(portalRouting1).isNotEqualTo(portalRouting2);
        portalRouting1.setId(null);
        assertThat(portalRouting1).isNotEqualTo(portalRouting2);
    }
}
