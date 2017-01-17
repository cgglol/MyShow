package com.cgg.administrator.myshow.utils;

/**
 * Created by Administrator on 2016/10/20.
 */

public class RobotBack {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"text":"�哥哥~667","ret_code":0,"code":100000}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    /**
     * text : �哥哥~667
     * ret_code : 0
     * code : 100000
     */

    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        private String text;
        private int ret_code;
        private int code;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
