package org.dromara.hotel.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import org.dromara.hotel.domain.HtlHotel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * 酒店详情视图对象 htl_hotel
 *
 * @author hmis
 * @date 2023-12-07
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = HtlHotel.class)
public class HtlHotelVo implements Serializable {

    @Serial
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
    @ExcelProperty(value = "星级(1/2/3/4/5)", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "star_type")
    private Integer star;

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
    @ExcelProperty(value = "支持的信用卡", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "credit_card_type")
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
     * 创建人
     */
    @ExcelProperty(value = "创建人")
    private String createBy;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @ExcelProperty(value = "修改人")
    private String updateBy;

    /**
     * 修改时间
     */
    @ExcelProperty(value = "修改时间")
    private Date updateTime;

    /**
     * 谷歌经度
     */
    @ExcelProperty(value = "谷歌经度")
    private String googleLat;

    /**
     * 谷歌维度
     */
    @ExcelProperty(value = "谷歌维度")
    private String googleLon;

    /**
     * 百度经度
     */
    @ExcelProperty(value = "百度经度")
    private String baiduLat;

    /**
     * 百度维度
     */
    @ExcelProperty(value = "百度维度")
    private String baiduLon;

    /**
     * 目的地标签
     */
    @ExcelProperty(value = "目的地标签")
    private Integer destinationLabel;


}
