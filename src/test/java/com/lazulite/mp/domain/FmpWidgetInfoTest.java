package com.lazulite.mp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.lazulite.mp.web.rest.TestUtil;

public class FmpWidgetInfoTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FmpWidgetInfo.class);
        FmpWidgetInfo fmpWidgetInfo1 = new FmpWidgetInfo();
        fmpWidgetInfo1.setId(1L);
        FmpWidgetInfo fmpWidgetInfo2 = new FmpWidgetInfo();
        fmpWidgetInfo2.setId(fmpWidgetInfo1.getId());
        assertThat(fmpWidgetInfo1).isEqualTo(fmpWidgetInfo2);
        fmpWidgetInfo2.setId(2L);
        assertThat(fmpWidgetInfo1).isNotEqualTo(fmpWidgetInfo2);
        fmpWidgetInfo1.setId(null);
        assertThat(fmpWidgetInfo1).isNotEqualTo(fmpWidgetInfo2);
    }
}
