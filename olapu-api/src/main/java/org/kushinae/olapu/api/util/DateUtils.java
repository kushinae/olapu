package org.kushinae.olapu.api.util;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class DateUtils {

    /**
     * 计算时间偏移值
     *
     * @param date 被计算时间
     * @param unit 计算单位
     * @param offset 偏移量值
     * @return 偏移之后结果值
     */
    public static Date offset(Date date, DateField unit, Integer offset) {
        DateTime offset1 = DateUtil.offset(date, unit, offset);
        return offset1.toJdkDate();
    }

}
