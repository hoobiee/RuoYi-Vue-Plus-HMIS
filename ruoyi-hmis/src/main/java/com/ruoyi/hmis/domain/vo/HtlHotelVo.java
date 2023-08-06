package com.ruoyi.hmis.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * 酒店详情列视图对象 htl_hotel
 *
 * @author ruoyi
 * @date 2023-08-06
 */
@Data
@ExcelIgnoreUnannotated
public class HtlHotelVo {

    private static final long serialVersionUID = 1L;

    /**
     * 酒店编号
     */
    @ExcelProperty(value = "酒店编号")
    private Long hotelId;

    /**
     * 酒店名称
     */
    @ExcelProperty(value = "酒店名称")
    private String hotelName;

    /**
     * 英文名
     */
    @ExcelProperty(value = "英文名")
    private String hotelNameEn;

    /**
     * 城市名称
     */
    @ExcelProperty(value = "城市名称")
    private String cityName;

    /**
     * 星级(1/2/3/4/5)
     */
    @ExcelProperty(value = "星级(1/2/3/4/5)")
    private Long star;

    /**
     * 电话
     */
    @ExcelProperty(value = "电话")
    private String hotelPhone;

    /**
     * 开业时间
     */
    @ExcelProperty(value = "开业时间")
    private Date openingTime;

    /**
     * 装修时间
     */
    @ExcelProperty(value = "装修时间")
    private Date decorateTime;

    /**
     * 酒店介绍
     */
    @ExcelProperty(value = "酒店介绍")
    private String introduction;

    /**
     * 取消政策
     */
    @ExcelProperty(value = "取消政策")
    private String canclePolicy;

    /**
     * 支持的信用卡
     */
    @ExcelProperty(value = "支持的信用卡")
    private String creditCards;

    /**
     * 酒店设施列表
     */
    @ExcelProperty(value = "酒店设施列表")
    private String facilities;

    /**
     * 酒店地址
     */
    @ExcelProperty(value = "酒店地址")
    private String address;

    /**
     * 酒店英文地址
     */
    @ExcelProperty(value = "酒店英文地址")
    private String addressEn;

    /**
     * 创建人
     */
    @ExcelProperty(value = "创建人")
    private String creator;

    /**
     * 修改人
     */
    @ExcelProperty(value = "修改人")
    private String modifier;

    /**
     * 修改时间
     */
    @ExcelProperty(value = "修改时间")
    private Date modifyTime;

    /**
     * 高德经度
     */
    @ExcelProperty(value = "高德经度")
    private String gaodeLat;

    /**
     * 高德维度
     */
    @ExcelProperty(value = "高德维度")
    private String gaodeLon;

    /**
     * 谷歌维度
     */
    @ExcelProperty(value = "谷歌维度")
    private String googleLat;

    /**
     * 谷歌经度
     */
    @ExcelProperty(value = "谷歌经度")
    private String googleLon;

    /**
     * 百度维度
     */
    @ExcelProperty(value = "百度维度")
    private String baiduLat;

    /**
     * 百度经度
     */
    @ExcelProperty(value = "百度经度")
    private String baiduLon;

    /**
     * 目的地标签
     */
    @ExcelProperty(value = "目的地标签")
    private Long destinationLable;


}
