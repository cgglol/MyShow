package com.cgg.administrator.myshow.utils;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */

public class PureBack {
    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"ret_code":0,"pagebean":{"allPages":"91","contentlist":[{"id":"225100","title":"私藏美图1223","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=225100&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201611/23/232957kw65nxceo63vao6w.jpg"},{"id":"225024","title":"韩国美眉","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=225024&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201611/23/103438x7q1dfq5sc4f5oy1.jpg"},{"id":"224228","title":"为什么不给金币呢！","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=224228&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201611/01/202601w7wyyrbiiz7rywib.jpeg"},{"id":"220612","title":"有一种美好叫做平淡中厮守\u2026","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=220612&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/24/220744x21izbimjnis1ejo.jpg"},{"id":"220609","title":"有一种美叫做清新淡雅\u2026\u2026","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=220609&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/24/173515nt4qbtx8quhqtzxw.jpg"},{"id":"220175","title":"草莓睡衣萌妹子可爱私房","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=220175&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/13/113632uyjclm2lblcjddly.jpg"},{"id":"219883","title":"粉嫩萌妹子可爱迷人写真","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=219883&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/06/115712rm8v2m7vf6k2npv6.jpg"},{"id":"219882","title":"短裙萌妹子闺房迷人","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=219882&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/06/115610vzsusnyd1mu0z4q1.jpg"},{"id":"219881","title":"萌妹子扮演兔女郎私房","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=219881&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/06/115455rh4wtulmzhvxe7tp.jpg"},{"id":"219875","title":"清纯室内写真","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=219875&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/06/112312i0lzzqz395l3zjle.jpg"}],"currentPage":"1","allNum":"910","maxResult":"10"}}
     */

    private int showapi_res_code;
    private String showapi_res_error;
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
        /**
         * ret_code : 0
         * pagebean : {"allPages":"91","contentlist":[{"id":"225100","title":"私藏美图1223","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=225100&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201611/23/232957kw65nxceo63vao6w.jpg"},{"id":"225024","title":"韩国美眉","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=225024&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201611/23/103438x7q1dfq5sc4f5oy1.jpg"},{"id":"224228","title":"为什么不给金币呢！","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=224228&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201611/01/202601w7wyyrbiiz7rywib.jpeg"},{"id":"220612","title":"有一种美好叫做平淡中厮守\u2026","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=220612&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/24/220744x21izbimjnis1ejo.jpg"},{"id":"220609","title":"有一种美叫做清新淡雅\u2026\u2026","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=220609&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/24/173515nt4qbtx8quhqtzxw.jpg"},{"id":"220175","title":"草莓睡衣萌妹子可爱私房","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=220175&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/13/113632uyjclm2lblcjddly.jpg"},{"id":"219883","title":"粉嫩萌妹子可爱迷人写真","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=219883&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/06/115712rm8v2m7vf6k2npv6.jpg"},{"id":"219882","title":"短裙萌妹子闺房迷人","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=219882&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/06/115610vzsusnyd1mu0z4q1.jpg"},{"id":"219881","title":"萌妹子扮演兔女郎私房","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=219881&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/06/115455rh4wtulmzhvxe7tp.jpg"},{"id":"219875","title":"清纯室内写真","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=219875&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/06/112312i0lzzqz395l3zjle.jpg"}],"currentPage":"1","allNum":"910","maxResult":"10"}
         */

        private int ret_code;
        private PagebeanBean pagebean;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public PagebeanBean getPagebean() {
            return pagebean;
        }

        public void setPagebean(PagebeanBean pagebean) {
            this.pagebean = pagebean;
        }

        public static class PagebeanBean {
            /**
             * allPages : 91
             * contentlist : [{"id":"225100","title":"私藏美图1223","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=225100&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201611/23/232957kw65nxceo63vao6w.jpg"},{"id":"225024","title":"韩国美眉","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=225024&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201611/23/103438x7q1dfq5sc4f5oy1.jpg"},{"id":"224228","title":"为什么不给金币呢！","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=224228&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201611/01/202601w7wyyrbiiz7rywib.jpeg"},{"id":"220612","title":"有一种美好叫做平淡中厮守\u2026","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=220612&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/24/220744x21izbimjnis1ejo.jpg"},{"id":"220609","title":"有一种美叫做清新淡雅\u2026\u2026","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=220609&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/24/173515nt4qbtx8quhqtzxw.jpg"},{"id":"220175","title":"草莓睡衣萌妹子可爱私房","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=220175&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/13/113632uyjclm2lblcjddly.jpg"},{"id":"219883","title":"粉嫩萌妹子可爱迷人写真","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=219883&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/06/115712rm8v2m7vf6k2npv6.jpg"},{"id":"219882","title":"短裙萌妹子闺房迷人","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=219882&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/06/115610vzsusnyd1mu0z4q1.jpg"},{"id":"219881","title":"萌妹子扮演兔女郎私房","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=219881&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/06/115455rh4wtulmzhvxe7tp.jpg"},{"id":"219875","title":"清纯室内写真","link":"http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=219875&==api","img":"http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201607/06/112312i0lzzqz395l3zjle.jpg"}]
             * currentPage : 1
             * allNum : 910
             * maxResult : 10
             */

            private String allPages;
            private String currentPage;
            private String allNum;
            private String maxResult;
            private List<ContentlistBean> contentlist;

            public String getAllPages() {
                return allPages;
            }

            public void setAllPages(String allPages) {
                this.allPages = allPages;
            }

            public String getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(String currentPage) {
                this.currentPage = currentPage;
            }

            public String getAllNum() {
                return allNum;
            }

            public void setAllNum(String allNum) {
                this.allNum = allNum;
            }

            public String getMaxResult() {
                return maxResult;
            }

            public void setMaxResult(String maxResult) {
                this.maxResult = maxResult;
            }

            public List<ContentlistBean> getContentlist() {
                return contentlist;
            }

            public void setContentlist(List<ContentlistBean> contentlist) {
                this.contentlist = contentlist;
            }

            public static class ContentlistBean {
                /**
                 * id : 225100
                 * title : 私藏美图1223
                 * link : http://sq.xoxow.cn/forum8.php?mod=viewthread&tid=225100&==api
                 * img : http://pic.yiyayan.cn/bbsyiyayan/data/attachment/forum/201611/23/232957kw65nxceo63vao6w.jpg
                 */

                private String id;
                private String title;
                private String link;
                private String img;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }
            }
        }
    }
}
