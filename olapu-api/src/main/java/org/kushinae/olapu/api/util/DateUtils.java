package org.kushinae.olapu.api.util;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.kushinae.olapu.api.exceprion.InternalServerException;
import org.kushinae.olapu.api.http.ErrorMessage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class DateUtils {

    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

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

    public static Date parse(String format, String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new InternalServerException(ErrorMessage.AUTHENTICATION_FAILED);
        }
    }

    public static Date parse(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new InternalServerException(ErrorMessage.AUTHENTICATION_FAILED);
        }
    }

    public static Date parse(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
        String formatDate = dateFormat.format(date);
        return parse(formatDate);
    }

    public static Date parse(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String formatDate = dateFormat.format(date);
        return parse(formatDate);
    }

    public static long toTimeMillis(Date date) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    public static long toSeconds(Date date) {
        return DateUtil.second(date);
    }
}
