package org.kushinae.olapu.api.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.regex.Pattern;

class UidUtilsTest {

    @Test
    void generate() {
        long start = System.currentTimeMillis();
        System.out.println(UidUtils.generate(28));
        long finishing = System.currentTimeMillis();
        System.out.println(BigDecimal.valueOf((finishing - start)).divide(BigDecimal.valueOf(1000)) + "s");
    }

    @Test
    void test() {
        System.out.println(Pattern.matches("[\\u{1F1E6}\\u{1F1F3}]", "🇨🇳"));
    }
}