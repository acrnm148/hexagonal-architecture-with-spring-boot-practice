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

import com.mycom.myboard.common.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Project     : bo-product-admin-api
 * @FileName    : PrtControllerExceptionHandler.java
 * @Date        : 2022. 5. 8.
 * @author      : newstar000@kyobobook.com
 * @description :
 */
@Slf4j
@RestControllerAdvice
public class PrtControllerExceptionHandler {

    /**
     * @Method      : handleException
     * @Date        : 2021. 8. 24.
     * @author      : smlee1@kyobobook.com
     * @description : Service 로직 처리중 발생 오류 Handler
     * @param e
     * @return
     */
    // BizException throw 시 ErrorCode 에 responseEnum 의  코드 값 삽입
/*
    @ExceptionHandler({BizRuntimeException.class})
    @ResponseBody
    public ResponseEntity<?> handleException(BizRuntimeException e) {
        
        log.error("BizRuntime Error Code : " + e.getErrorCode(), e);
        
        return new ResponseEntity<ResponseMessage>(ResponseMessage.builder()
                    .resultCode(e.getErrorCode())
                    .resultMessage(e.getErrorMessage())
                    .detailMessage(e.getMessage())
                    .build()
                , HttpStatus.NOT_ACCEPTABLE);
    }
*/
    /**
     * @Method      : handleException
     * @Date        : 2021. 9. 10.
     * @author      : smlee1@kyobobook.com
     * @description : Service 로직 처리 중 발생 오류의 공통 Handler 
     * @param e
     * @return
     */
/*
    @ExceptionHandler({kyobobook.commonlib.exception.BizRuntimeException.class})
    @ResponseBody
    public ResponseEntity<?> handleException(kyobobook.commonlib.exception.BizRuntimeException e) {
        return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }
*/
    /**
     * @Method      : handlException
     * @Date        : 2021. 8. 12.
     * @author      : smlee1@kyobobook.com
     * @description : 모든 Exception을 핸들링
     * @param e
     */
/*
    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handlException(Exception e) {
        
        log.error("Exception Error Code : " + ResponseEnum.INTERNAL_ERROR.getCode(), e);
        
        return new ResponseEntity<ResponseMessage>(ResponseMessage.builder()
                    .resultCode(ResponseEnum.INTERNAL_ERROR.getCode())
                    .resultMessage(ResponseEnum.INTERNAL_ERROR.getDesc())
                    .detailMessage(e.getMessage())
                    .build()
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }
 */

}
