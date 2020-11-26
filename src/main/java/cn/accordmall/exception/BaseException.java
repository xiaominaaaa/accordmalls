package cn.accordmall.exception;

import lombok.Data;

/**
 * 自定义异常
 */
public class BaseException extends RuntimeException{
    private String errorMsg;
    private String errCode;


    public static BaseException whitErrcode(String errCode){
        return new BaseException("",errCode);
    }

    public static BaseException whitErrorMassage(String errorMsg){
        return new BaseException(errorMsg,"Fail");
    }

    public BaseException(String errorMsg, String errCode) {
        this.errorMsg = errorMsg;
        this.errCode = errCode;
    }

    public BaseException(String errCode) {
        this.errorMsg = "";
        this.errCode = errCode;
    }


    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

}
