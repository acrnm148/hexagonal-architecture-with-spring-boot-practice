/***************************************************
 * Copyright(c) 2021-2022 Kyobo Book Centre All right reserved.
 * This software is the proprietary information of Kyobo Book.
 *
 * Revision History
 * Author                         Date          Description
 * --------------------------     ----------    ----------------------------------------
 * newstar000@kyobobook.com      2022. 6. 23.
 *
 ****************************************************/
package com.mycom.myboard.common;

//import org.apache.commons.lang3.StringUtils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Project     : bo-product-admin-api
 * @FileName    : DateUtil.java
 * @Date        : 2022. 4. 8.
 * @author      : mookun3@kyobobook.com
 * @description :
 */
public class DateUtil {

    /** 년월일시분초 */
    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    
    /** 년월일 */
    public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
    
    /** 년월일 (220411) */
    public static final String FORMAT_YYMMDD = "yyMMdd";

    /**
     * @Method      : isDateByFormat
     * @Date        : 2022. 4. 8.
     * @author      : mookun3@kyobobook.com
     * @description : 날짜형식의 string 값  날짜 format 여부 체크
     * @param date
     * @param format
     * @return
     */
    public static boolean isDateByFormat(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * @Method      : compareDateByFormat
     * @Date        : 2022. 4. 8.
     * @author      : mookun3@kyobobook.com
     * @description : target, compare 날짜 비교.
     * @param target
     * @param compare
     * @param format
     * @return
     */
    public static Integer compareDateByFormat(String target, String compare, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date targetDate = sdf.parse(target);
            Date compareDate = sdf.parse(compare);
            return targetDate.compareTo(compareDate);
        } catch (ParseException e) {
            return null;
        }
    }
    
    /**
     * @Method      : getTodayByFormat
     * @Date        : 2022. 4. 8.
     * @author      : mookun3@kyobobook.com
     * @description : 오늘날짜 format 형식으로 return
     * @param format
     * @return
     */
    public static String getTodayByFormat(String format) { 
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }
    
    /**
     * @Method      : getDateStrByFormat
     * @Date        : 2022. 4. 8.
     * @author      : mookun3@kyobobook.com
     * @description : 날짜 String format 변환
     * @param dateStr : 변환할 날짜string
     * @param strFormat : target의 날짜 format
     * @param format : 변환할 날짜 format
     * @return
     */
    public static String getDateStrByFormat(String dateStr, String strFormat, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        SimpleDateFormat tgtSdf = new SimpleDateFormat(strFormat);

        try {
            return sdf.format(tgtSdf.parse(dateStr));
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @Method      : getMonthLastDateByYYYYMM
     * @Date        : 2022. 4. 21.
     * @author      : mookun3@kyobobook.com
     * @description : 해당 연월의 마지막일자 조회
     * @param yyyyMM
     * @return
     */
    public static String getMonthLastDateByYYYYMM(String yyyyMM) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime(sdf.parse(yyyyMM));
        } catch (ParseException e) {
            return null;
        }

        int lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, lastDayOfMonth);

        SimpleDateFormat rdf = new SimpleDateFormat(DateUtil.FORMAT_YYYYMMDD);
        return rdf.format(calendar.getTime());
    }

    /**
     * @Method      : addDateByFormat
     * @Date        : 2022. 5. 20.
     * @author      : mookun3@kyobobook.com
     * @description : 해당 포맷으로 날짜 계산
     * @param target
     * @param addDay
     * @param format
     * @return
     */
    public static String addDateByFormat(String target, int addDay, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date targetDate = sdf.parse(target);
            Calendar cal = Calendar.getInstance();
            cal.setTime(targetDate);
            cal.add(Calendar.DATE, addDay);

            return sdf.format(cal.getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @Method      : isBetween
     * @Date        : 2022. 8. 12.
     * @author      : ejfrm0802@kyobobook.com
     * @description : 오늘 날짜가 두 날짜 사이에 포함 여부 체크
     * @param sttgDttm
     * @param endDttm
     * @return
     */
    public static boolean isBetween(String sttgDttm, String endDttm) {
        if (StringUtils.isEmpty(sttgDttm) || StringUtils.isEmpty(endDttm)) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYYMMDDHHMMSS);

        try {
            Date today = new Date();
            if (today.after(sdf.parse(sttgDttm)) && today.before(sdf.parse(endDttm))) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
    }
}
