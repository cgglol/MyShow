package com.cgg.administrator.myshow.utils;

import java.util.List;

/**
 * Created by Administrator on 2016/11/2.
 */

public class TodayBack {


    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"ret_code":0,"list":[{"title":"首架国产大飞机C919亮相","month":11,"img":"http://img.lssdjt.com/201511/02212841910.jpg","year":"2015","day":2},{"title":"美科学家发现双头白化蛇","month":11,"img":"http://img.lssdjt.com/201211/2/48124956108.jpg","year":"2011","day":2},{"title":"世界车王争霸赛在鸟巢举行","month":11,"img":"http://img.lssdjt.com/201510/27123952541.jpg","year":"2009","day":2},{"title":"首届中国上海国际艺术节开幕","month":11,"img":"http://img.lssdjt.com/200910/27/2C221146999.jpg","year":"1999","day":2},{"title":"美国发生\u201c蠕虫计算机病毒\u201d事件","month":11,"img":"http://img.lssdjt.com/201211/2/0412174229.jpg","year":"1998","day":2},{"title":"我国与汤加王国建立大使级外交关系","month":11,"img":"http://img.lssdjt.com/200910/27/9B215429704.jpg","year":"1998","day":2},{"title":"为正义捐躯  受后人景仰  巴黎竖起华工纪念碑","month":11,"img":"http://img.lssdjt.com/200910/27/BB215744211.jpg","year":"1998","day":2},{"title":"美国伊朗门事件被披露","month":11,"year":"1986","day":2},{"title":"斯大林女儿重返苏联","month":11,"img":"http://img.lssdjt.com/200905/17/5823850408.jpg","year":"1984","day":2},{"title":"联大决议要求外国军队立即撤出格林纳达","month":11,"img":"http://img.lssdjt.com/201311/2/D41606613.jpg","year":"1983","day":2},{"title":"中国专利文献馆正式开放","month":11,"year":"1981","day":2},{"title":"我国与秘鲁建交","month":11,"img":"http://img.lssdjt.com/201511/09134611550.jpg","year":"1971","day":2},{"title":"美国一公民自焚以抗议侵越战争","month":11,"year":"1965","day":2},{"title":"毛主席率领中国代表团访问苏联","month":11,"img":"http://img.lssdjt.com/200411/2/E6182343574.jpg","year":"1957","day":2},{"title":"中国民航成立","month":11,"img":"http://img.lssdjt.com/201311/2/4716132734.jpg","year":"1949","day":2},{"title":"印尼-荷兰圆桌会议协定签订","month":11,"year":"1949","day":2},{"title":"世界第一家电视公司在英国伦敦开播","month":11,"img":"http://img.lssdjt.com/201211/2/AC124116629.jpg","year":"1948","day":2},{"title":"辽沈战役大获全胜","month":11,"img":"http://img.lssdjt.com/200905/17/00231411189.jpg","year":"1948","day":2},{"title":"杜鲁门连任美国总统","month":11,"img":"http://img.lssdjt.com/200905/17/8223148285.jpg","year":"1948","day":2},{"title":"沈阳解放","month":11,"img":"http://img.lssdjt.com/200411/2/6E182329276.jpg","year":"1948","day":2},{"title":"日军对晋察冀边区开始大\u201c扫荡\u201d","month":11,"img":"http://img.lssdjt.com/200905/17/44231513188.jpg","year":"1939","day":2},{"title":"忻口战役结束","month":11,"year":"1937","day":2},{"title":"孙传芳打败奉军","month":11,"img":"http://img.lssdjt.com/200905/17/3D231656763.jpg","year":"1925","day":2},{"title":"美日订立\u201c兰辛\u2014石井协定\u201d　损害中国利益","month":11,"year":"1917","day":2},{"title":"《贝尔福宣言》和犹太复国主义","month":11,"year":"1917","day":2},{"title":"日本颁布取缔中国留学生规则","month":11,"img":"http://img.lssdjt.com/200411/2/2A182255941.jpg","year":"1905","day":2}]}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    /**
     * ret_code : 0
     * list : [{"title":"首架国产大飞机C919亮相","month":11,"img":"http://img.lssdjt.com/201511/02212841910.jpg","year":"2015","day":2},{"title":"美科学家发现双头白化蛇","month":11,"img":"http://img.lssdjt.com/201211/2/48124956108.jpg","year":"2011","day":2},{"title":"世界车王争霸赛在鸟巢举行","month":11,"img":"http://img.lssdjt.com/201510/27123952541.jpg","year":"2009","day":2},{"title":"首届中国上海国际艺术节开幕","month":11,"img":"http://img.lssdjt.com/200910/27/2C221146999.jpg","year":"1999","day":2},{"title":"美国发生\u201c蠕虫计算机病毒\u201d事件","month":11,"img":"http://img.lssdjt.com/201211/2/0412174229.jpg","year":"1998","day":2},{"title":"我国与汤加王国建立大使级外交关系","month":11,"img":"http://img.lssdjt.com/200910/27/9B215429704.jpg","year":"1998","day":2},{"title":"为正义捐躯  受后人景仰  巴黎竖起华工纪念碑","month":11,"img":"http://img.lssdjt.com/200910/27/BB215744211.jpg","year":"1998","day":2},{"title":"美国伊朗门事件被披露","month":11,"year":"1986","day":2},{"title":"斯大林女儿重返苏联","month":11,"img":"http://img.lssdjt.com/200905/17/5823850408.jpg","year":"1984","day":2},{"title":"联大决议要求外国军队立即撤出格林纳达","month":11,"img":"http://img.lssdjt.com/201311/2/D41606613.jpg","year":"1983","day":2},{"title":"中国专利文献馆正式开放","month":11,"year":"1981","day":2},{"title":"我国与秘鲁建交","month":11,"img":"http://img.lssdjt.com/201511/09134611550.jpg","year":"1971","day":2},{"title":"美国一公民自焚以抗议侵越战争","month":11,"year":"1965","day":2},{"title":"毛主席率领中国代表团访问苏联","month":11,"img":"http://img.lssdjt.com/200411/2/E6182343574.jpg","year":"1957","day":2},{"title":"中国民航成立","month":11,"img":"http://img.lssdjt.com/201311/2/4716132734.jpg","year":"1949","day":2},{"title":"印尼-荷兰圆桌会议协定签订","month":11,"year":"1949","day":2},{"title":"世界第一家电视公司在英国伦敦开播","month":11,"img":"http://img.lssdjt.com/201211/2/AC124116629.jpg","year":"1948","day":2},{"title":"辽沈战役大获全胜","month":11,"img":"http://img.lssdjt.com/200905/17/00231411189.jpg","year":"1948","day":2},{"title":"杜鲁门连任美国总统","month":11,"img":"http://img.lssdjt.com/200905/17/8223148285.jpg","year":"1948","day":2},{"title":"沈阳解放","month":11,"img":"http://img.lssdjt.com/200411/2/6E182329276.jpg","year":"1948","day":2},{"title":"日军对晋察冀边区开始大\u201c扫荡\u201d","month":11,"img":"http://img.lssdjt.com/200905/17/44231513188.jpg","year":"1939","day":2},{"title":"忻口战役结束","month":11,"year":"1937","day":2},{"title":"孙传芳打败奉军","month":11,"img":"http://img.lssdjt.com/200905/17/3D231656763.jpg","year":"1925","day":2},{"title":"美日订立\u201c兰辛\u2014石井协定\u201d　损害中国利益","month":11,"year":"1917","day":2},{"title":"《贝尔福宣言》和犹太复国主义","month":11,"year":"1917","day":2},{"title":"日本颁布取缔中国留学生规则","month":11,"img":"http://img.lssdjt.com/200411/2/2A182255941.jpg","year":"1905","day":2}]
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
        private int ret_code;
        /**
         * title : 首架国产大飞机C919亮相
         * month : 11
         * img : http://img.lssdjt.com/201511/02212841910.jpg
         * year : 2015
         * day : 2
         */

        private List<ListBean> list;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String title;
            private int month;
            private String img;
            private String year;
            private int day;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getYear() {
                return year;
            }

            public void setYear(String year) {
                this.year = year;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }
        }
    }
}
