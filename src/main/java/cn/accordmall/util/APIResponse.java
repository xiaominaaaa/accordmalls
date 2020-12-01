package cn.accordmall.util;

import cn.accordmall.webconst.CommonsConst;
import io.swagger.annotations.ApiResponse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 响应数据封装
 *
 * {'msg':'消息',errorCode:'success',data:{数据}}
 */
public class APIResponse<T> {
    @Getter
    @Setter
    private String msg;
    @Getter
    @Setter
    private String errorCode;
    @Getter
    @Setter
    private T data;

    public static APIResponse success(){
        return new APIResponse("", CommonsConst.APICommonsConst.SUCCESS_CODE,"");
    }

    public static APIResponse successData(Object data){
        return new APIResponse("", CommonsConst.APICommonsConst.SUCCESS_CODE,data);
    }

    public static APIResponse successDataMsg(Object data,String msg){
        return new APIResponse(msg, CommonsConst.APICommonsConst.SUCCESS_CODE,data);
    }

    public static APIResponse successMsg(String msg){
        return new APIResponse(msg, CommonsConst.APICommonsConst.SUCCESS_CODE,"");
    }

    public static APIResponse fail(){
        return new APIResponse("", CommonsConst.APICommonsConst.FAIL_CODE,"");
    }

    public static APIResponse failMsg(String msg){
        return new APIResponse(msg, CommonsConst.APICommonsConst.FAIL_CODE,"");
    }


    public APIResponse(){
    }

    public APIResponse(String msg, String errorCode, T data) {
        this.msg = msg;
        this.errorCode = errorCode;
        this.data = data;
    }
}
