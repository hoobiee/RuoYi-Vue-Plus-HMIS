package org.dromara.hotel.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 酒店详情对象 htl_hotel
 *
 * @author hmis
 * @date 2023-12-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("htl_hotel")
public class HtlHotel extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 酒店编号
     */
    @TableId(value = "hotel_id")
    private Long hotelId;

    /**
     * 酒店名称
     */
    private String hotelName;

    /**
     * 英文名
     */
    private String hotelNameEn;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 星级(1/2/3/4/5)
     */
    private Integer star;

    /**
     * 电话
     */
    private String hotelPhone;

    /**
     * 开业时间
     */
    private Date openingTime;

    /**
     * 装修时间
     */
    private Date decorateTime;

    /**
     * 酒店介绍
     */
    private String introduction;

    /**
     * 取消政策
     */
    private String canclePolicy;

    /**
     * 支持的信用卡
     */
    private String creditCards;

    /**
     * 酒店设施列表
     */
    private String facilities;

    /**
     * 酒店地址
     */
    private String address;

    /**
     * 酒店英文地址
     */
    private String addressEn;

    /**
     * 高德经度
     */
    private String gaodeLat;

    /**
     * 高德维度
     */
    private String gaodeLon;

    /**
     * 谷歌经度
     */
    private String googleLat;

    /**
     * 谷歌维度
     */
    private String googleLon;

    /**
     * 百度经度
     */
    private String baiduLat;

    /**
     * 百度维度
     */
    private String baiduLon;

    /**
     * 目的地标签
     */
    private Integer destinationLabel;


}
