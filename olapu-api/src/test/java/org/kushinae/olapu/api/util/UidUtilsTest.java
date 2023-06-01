package org.kushinae.olapu.api.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class UidUtilsTest {

    @Test
    void generate() {
        long start = System.currentTimeMillis();
        System.out.println(UidUtils.generate(28));
        long finishing = System.currentTimeMillis();
        System.out.println(BigDecimal.valueOf((finishing - start)).divide(BigDecimal.valueOf(1000)) + "s");
    }
}