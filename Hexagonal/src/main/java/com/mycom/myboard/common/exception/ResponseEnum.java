/***************************************************
 * Copyright(c) 2021-2022 Kyobo Book Centre All right reserved.
 * This software is the proprietary information of Kyobo Book.
 *
 * Revision History
 * Author                         Date          Description
 * --------------------------     ----------    ----------------------------------------
 * newstar000@kyobobook.com      2022. 5. 8.
 *
 ****************************************************/
package com.mycom.myboard.common.exception;

/**
 * @Project     : bo-product-admin-api
 * @FileName    : ResponseEnum.java
 * @Date        : 2022. 5. 8.
 * @author      : newstar000@kyobobook.com
 * @description :
<pre><strong>코드 네이밍 룰</strong>
ex 1) API ID : API-BIZ05-03-I251
    'PRT-' + '03' + '251' + 순번(1 ~ 9) => PRT-032511
ex 2) API ID : API-BIZ05-04-I321
    'PRT-' + '04' + '321' + 순번(1 ~ 9) => PRT-043211
</pre>
 */
public enum ResponseEnum {

    // 03
    INSERT_TDYBK_PK_DUPLICATION_ERROR(406, "PRT-032511", "동일한 키값의 데이터가 존재합니다."),
    REQUIRED_PARAMETER_INSERT_TDYBK_ERROR(406, "PRT-032512", "필수값 미입력"),
    UPDATE_TDYBK_NO_DATA_ERROR(406, "PRT-032521", "업데이트할 데이터가 없습니다.(키값에 해당하는 데이터 미존재)"),
    REQUIRED_PARAMETER_UPDATE_TDYBK_ERROR(406, "PRT-032522", "필수값 미입력"),

    // 04
    REQUIRED_PARAMETER_CLTUR_INVT_ERROR(406, "PRT-041791", "필수값 미입력 : 초대장ID"),
    UPDATE_CLTUR_INVT_NO_DATA_ERROR(406, "PRT-041792", "유효하지 않은 초대권 번호입니다."),
    UPDATE_CLTUR_INVT_BEFORE_DATE_ERROR(406, "PRT-041793", "아직 초대권 확인 기간이 아닙니다."),
    UPDATE_CLTUR_INVT_AFTER_DATE_ERROR(406, "PRT-041794", "기간이 종료된 초대권입니다."),
    UPDATE_CLTUR_INVT_SENDING_ERROR(406, "PRT-041795", "발송된 초대권이 아닙니다."),
    REQUIRED_PARAMETER_OPN_CMDT_ERROR(406, "PRT-043211", "필수값 미입력"),
    INSERT_OPN_CMDT_DUPLICATION_ENBS_CMDTID_ERROR(406, "PRT-043212", "해당 입점사상품ID로 등록된 판매상품ID가 존재합니다."),
    REQUIRED_PARAMETER_UPDATE_OPN_CMDT_ERROR(406, "PRT-043221", "필수값 미입력"),
    UPDATE_OPN_CMDT_NO_DATA_ERROR(406, "PRT-043222", "업데이트할 데이터가 없습니다.(키값에 해당하는 데이터 미존재)"),

    // 05


    // 06


    // 07


    // 08
    REQUIRED_PARAMETER_UPDATE_FRBE_LMTT(406, "PRT-081421", "필수값 미입력 : 판매상품ID"),


    API_CALL_ERROR(406, "PRT-999999", "An error occurred when calling the API."),
    INTERNAL_ERROR(500, "PRT-000000", "The Base server encountered an unexpected error.");

    private int httpStatus;
    private String code;
    private String desc;

    private ResponseEnum(int httpStatus, String code, String desc) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.desc = desc;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
