package org.kushinae.olapu.api.util;

import org.junit.jupiter.api.Test;

class AccessTokenUtilsTest {

    @Test
    void create() {
        System.out.println(AccessTokenUtils.createFromJWT("GC4joRWDhcIVdZINm0lblpiCKzhT", "GC4joRWDhcIVdZINm0lblpiCKzhT"));
    }
}