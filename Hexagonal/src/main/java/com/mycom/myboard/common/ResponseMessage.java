package com.mycom.myboard.common;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
//@Deprecated //더 이상 사용하지 않는
public class ResponseMessage {

    protected int statusCode;

    private String resultCode;

    private Object data;
    private String resultMessage;
    private String detailMessage;

    @Deprecated
    public static ResponseMessage of(Object data, int statusCode, String resultMessage, String detailMessage) {
        return ResponseMessage.builder().data(data).statusCode(statusCode).resultMessage(resultMessage)
                .detailMessage(detailMessage).build();
    }

    public static ResponseMessage of(Object data, String resultCode, String resultMessage, String detailMessage) {
        return ResponseMessage.builder().data(data).resultCode(resultCode).resultMessage(resultMessage)
                .detailMessage(detailMessage).build();
    }

    public static ResponseMessage of(Object data, HttpStatus status, String detailMessage) {
        return of(data, ""+status.value(), status.getReasonPhrase(), detailMessage);
    }

    public static ResponseMessage of(Object data, HttpStatus status) {
        return of(data, status, null);
    }

    public static ResponseMessage ok(Object data, String detailMessage) {
        return of(data, HttpStatus.OK, detailMessage);
    }

    public static ResponseMessage of(HttpStatus status) {
        return of(null, status);
    }

    public static ResponseMessage ok() {
        return of(HttpStatus.OK);
    }

    public static ResponseMessage ok(Object data) {
        return of(data, HttpStatus.OK);
    }
}

