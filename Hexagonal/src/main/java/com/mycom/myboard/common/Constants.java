/***************************************************
 * Copyright(c) 2021-2022 Kyobo Book Centre All right reserved.
 * This software is the proprietary information of Kyobo Book.
 *
 * Revision History
 * Author                         Date          Description
 * --------------------------     ----------    ----------------------------------------
 * newstar000@kyobobook.com      2022. 3. 31.
 *
 ****************************************************/
package com.mycom.myboard.common;

//import kyobobook.commonlib.exception.BizRuntimeException;

public class Constants {

    public static final int SUCCESS = 1;
    public static final String SALE_CMDT_DVSN_CODE_KOR = "KOR";     //국내도서
    public static final String SALE_CMDT_DVSN_CODE_ENG = "ENG";     //보유외서
    public static final String SALE_CMDT_DVSN_CODE_JAP = "JAP";     //보유일서
    public static final String SALE_CMDT_DVSN_CODE_BNT = "BNT";     //해외주문외서
    public static final String SALE_CMDT_DVSN_CODE_JNT = "JNT";     //해외주문일서
    public static final String SALE_CMDT_DVSN_CODE_PBC = "PBC";     //PB상품 (교보굿즈)
    public static final String SALE_CMDT_DVSN_CODE_MUC = "MUC";     //음반
    public static final String SALE_CMDT_DVSN_CODE_DVD = "DVD";     //DVD
    public static final String SALE_CMDT_DVSN_CODE_GFT = "GFT";     //기프트
    public static final String SALE_CMDT_DVSN_CODE_GFC = "GFC";     //상품권
    public static final String SALE_CMDT_DVSN_CODE_CUL = "CUL";     //컬쳐
    public static final String SALE_CMDT_DVSN_CODE_MOV = "MOV";     //동영상
    public static final String SALE_CMDT_DVSN_CODE_OPN = "OPN";     //오픈마켓
    public static final String SALE_CMDT_DVSN_CODE_OPT = "OPT";     //판매옵션상품(신규)
    public static final String SALE_CMDT_DVSN_CODE_CMB = "CMB";     //결합상품(신규)

    /** 교보문고배송상품 */
    public static final String SALE_CMDT_GRP_DVSN_CODE_BKS = "SGK";
    /** 핫트랙스 */
    public static final String SALE_CMDT_GRP_DVSN_CODE_HTRS = "SGH";
    /** 오픈마켓 */
    public static final String SALE_CMDT_GRP_DVSN_CODE_OPN = "SGO";
    /** 상품권 */
    public static final String SALE_CMDT_GRP_DVSN_CODE_GFT = "SGG";
    /** 컬쳐 */
    public static final String SALE_CMDT_GRP_DVSN_CODE_CLTR = "SGC";
    /** 판매옵션상품 */
    public static final String SALE_CMDT_GRP_DVSN_CODE_OPT = "SGS";
    /** 결합상품 */
    public static final String SALE_CMDT_GRP_DVSN_CODE_COMB = "SGP";
    /** 디지털컨텐츠 */
    public static final String SALE_CMDT_GRP_DVSN_CODE_DGCT = "SGD";
    
    public static String getSaleCmdtDvsnGrpCode(String saleCmdtDvsnCode) throws Exception {

        if (saleCmdtDvsnCode == null || "".equals(saleCmdtDvsnCode)) {
            return null;
        }
        
        switch (saleCmdtDvsnCode) {
        
            case  SALE_CMDT_DVSN_CODE_KOR :   //국내도서
            case  SALE_CMDT_DVSN_CODE_ENG :   //보유외서
            case  SALE_CMDT_DVSN_CODE_JAP :   //보유일서
            case  SALE_CMDT_DVSN_CODE_BNT :   //해외주문외서
            case  SALE_CMDT_DVSN_CODE_JNT :   //해외주문일서
            case  SALE_CMDT_DVSN_CODE_PBC :   //PB상품 (교보굿즈)
                return SALE_CMDT_GRP_DVSN_CODE_BKS;
                
            case SALE_CMDT_DVSN_CODE_MUC :    //음반
            case SALE_CMDT_DVSN_CODE_DVD :    //DVD
                return SALE_CMDT_GRP_DVSN_CODE_HTRS;
                

            case SALE_CMDT_DVSN_CODE_GFT :    //기프트
            case SALE_CMDT_DVSN_CODE_GFC :    //상품권
                return SALE_CMDT_GRP_DVSN_CODE_GFT;
                

            case SALE_CMDT_DVSN_CODE_CUL :    //컬쳐
                return SALE_CMDT_GRP_DVSN_CODE_CLTR;
                
            case SALE_CMDT_DVSN_CODE_OPN :    //오픈마켓
                return SALE_CMDT_GRP_DVSN_CODE_OPN;
                
            case SALE_CMDT_DVSN_CODE_OPT :    //판매옵션상품(신규)
                return SALE_CMDT_GRP_DVSN_CODE_OPT;
            case SALE_CMDT_DVSN_CODE_CMB :    //결합상품(신규)
                return SALE_CMDT_GRP_DVSN_CODE_COMB;
                
            default :
                throw new Exception("error");
                //throw new BizRuntimeException("판매상품 구분 코드가 없습니다.");
                
        }
        
    }
    
    public static final class SrchExlsHardVale {
        
        public static final String SRCH_EXLS_JOB_DVS_CODE = "004";
        public static final String SRCH_RPPR_REQU_CNTT = "일서MD등록";
    }

    /** 여부에 대한 컬럼값 */
    public static final String YES  = "Y";

    /** 여부에 대한 컬럼값 */
    public static final String NO   = "N";

    /**
     * @Project     : bo-product-admin-api
     * @FileName    : Constants.java
     * @Date        : 2021. 12. 8.
     * @author      : jhbang@kyobobook.com
     * @description : 메시지 리소스용 ID 문자열
     */
    public final class CommonMessages {
        /** 정상 */
        public static final String PROCESS_COMPLETE = "common.process.complete";
        /** 오류 */
        public static final String PROCESS_ERROR    = "common.process.error";
    }

    /**
     * @Project     : bo-product-admin-api
     * @FileName    : Constants.java
     * @Date        : 2022. 4. 2.
     * @author      : newstar000@kyobobook.com
     * @description : ApiResponse 메시지 정의
     */
    public static final class ApiResponse {
        /** 200 접두사 */
        public static final String MESSAGE_200_PREFIX 
                = "<pre>Request han been successfully<br/>{<br/>  \"data\": {}, <font color=\"red\">data 항목은 ";
        /** 200 접미사 */
        public static final String MESSAGE_200_POSTFIX  = " 참고</font><br/>"
                + "  \"detailMessage\": \"처리중 오류 발생시 상세 메세지 노출.\",<br/>"
                + "  \"resultMessage\": \"정상처리 되었습니다.\",<br/>  \"statusCode\": 200<br/>}</pre>";
        /** 404 */
        public static final String MESSAGE_404 = "Page Not Found";
        /** 500 */
        public static final String MESSAGE_500 = "An error occurred";
    }
    
    /**
     * @Project     : bo-product-admin-api
     * @FileName    : Constants.java
     * @Date        : 2022. 4. 8.
     * @author      : znh@kyobobook.com
     * @description : 일괄등록 에러메세지 정의
     */
    public static final class BatchErrMessage {
        public static final String DUPLICATE_CMDTCODE = "상품코드가 중복입니다.";
        public static final String DUPLICATE_SALE_CMDTID  = "판매상품ID가 중복입니다.";
        public static final String NOT_FOUND_CMDTCODE = "상품코드에 대한 상품정보를 찾을 수 없습니다.";
        public static final String NOT_FOUND_SALE_CMDTID = "판매상품ID에 대한 상품정보를 찾을 수 없습니다.";
        public static final String NOT_EXIST_CMDT = "기존 상품으로 존재하지 않습니다.";
        public static final String IS_EXIST_CMDT = "이미 기존 상품이 존재합니다.";
        public static final String DUPLICATE_DATE = "이미 해당기간에 등록된 도서입니다.";
        public static final String IS_EXIST_BRDR_EXLS_BKS = "바로드림제외로 등록된 상품은 전용등록 불가. 바로드림 제외를 먼저 삭제하세요.";
        public static final String IS_EXIST_LIMT_SALE = "판매용품절은 바로드림전용 등록불가, 판매용품절을 먼저 삭제하세요.";
        public static final String IS_EXIST_BRDR_EXUS_BKS = "바로드림전용으로 등록된 상품은 제외등록 불가. 바로드림전용을 먼저 삭제하세요.";
        public static final String ERROR_OCCURRED = "등록 중 에러가 발생했습니다.";
    }
}
