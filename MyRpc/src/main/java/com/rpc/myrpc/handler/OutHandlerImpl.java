package com.rpc.myrpc.handler;

import com.rpc.myrpc.utils.StringUtils;


public class OutHandlerImpl implements OutHandler {

    private static Object object = null;

    @Override
    public void setArrStr(String pathName, Object... paramsStr) {
        if (paramsStr.length == 1 && paramsStr[0] instanceof String[]){
            String string = StringUtils.resolveArr2Str(paramsStr[0]);
            String substring = string.substring(1, string.length() - 1);
            object = pathName + "&&" + substring.toString();
        } else if (paramsStr instanceof String[]){
            object = pathName + "&&" + StringUtils.resolveArr2Str(paramsStr);
        } else if (paramsStr.length == 1 ){
            object = pathName + "&&&" + StringUtils.resolveArr2Str(paramsStr);
        }else {
            object = pathName + "&" + StringUtils.resolveArr2Str(paramsStr);
        }
    }

    @Override
    public void setClazz(Object obj) {
        object = obj;
    }

    public static Object getClazz() {
        return object;
    }

    public static String getArrStr() {
        return (String) object;
    }


}
