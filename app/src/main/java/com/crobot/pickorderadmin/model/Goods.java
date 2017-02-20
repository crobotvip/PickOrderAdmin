package com.crobot.pickorderadmin.model;

/**
 * Created by Administrator on 2017/2/20 0020.
 */
public class Goods {


    /**
     * id : 57ec8204fa0bd937605dedf8
     * goodsname : 坦克
     * goodspic : https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1475117578&di=eb0731d448ff10a6fc2e540b0139269e&src=http://pic2.nipic.com/20090410/1049187_120622068_2.jpg
     * createdAt : 2016-09-29T02:52:52.549Z
     * updatedAt : 2016-09-29T02:53:10.284Z
     */

    private String id;
    private String goodsname;
    private String goodspic;
    private String createdAt;
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodspic() {
        return goodspic;
    }

    public void setGoodspic(String goodspic) {
        this.goodspic = goodspic;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
