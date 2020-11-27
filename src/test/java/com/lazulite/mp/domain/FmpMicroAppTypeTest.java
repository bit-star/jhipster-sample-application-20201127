package com.lazulite.mp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.lazulite.mp.web.rest.TestUtil;

public class FmpMicroAppTypeTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FmpMicroAppType.class);
        FmpMicroAppType fmpMicroAppType1 = new FmpMicroAppType();
        fmpMicroAppType1.setId(1L);
        FmpMicroAppType fmpMicroAppType2 = new FmpMicroAppType();
        fmpMicroAppType2.setId(fmpMicroAppType1.getId());
        assertThat(fmpMicroAppType1).isEqualTo(fmpMicroAppType2);
        fmpMicroAppType2.setId(2L);
        assertThat(fmpMicroAppType1).isNotEqualTo(fmpMicroAppType2);
        fmpMicroAppType1.setId(null);
        assertThat(fmpMicroAppType1).isNotEqualTo(fmpMicroAppType2);
    }
}
