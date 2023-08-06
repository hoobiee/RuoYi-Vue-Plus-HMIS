package com.ruoyi.hmis.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 酒店详情列业务对象 htl_hotel
 *
 * @author ruoyi
 * @date 2023-08-06
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class HtlHotelBo extends BaseEntity {

    /**
     * 酒店编号
     */
    @NotNull(message = "酒店编号不能为空", groups = { EditGroup.class })
    private Long hotelId;

    /**
     * 酒店名称
     */
    @NotBlank(message = "酒店名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String hotelName;

    /**
     * 英文名
     */
    @NotBlank(message = "英文名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String hotelNameEn;

    /**
     * 城市名称
     */
    @NotBlank(message = "城市名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String cityName;

    /**
     * 星级(1/2/3/4/5)
     */
    @NotNull(message = "星级(1/2/3/4/5)不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long star;

    /**
     * 电话
     */
    @NotBlank(message = "电话不能为空", groups = { AddGroup.class, EditGroup.class })
    private String hotelPhone;

    /**
     * 开业时间
     */
    @NotNull(message = "开业时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date openingTime;

    /**
     * 装修时间
     */
    @NotNull(message = "装修时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date decorateTime;

    /**
     * 酒店介绍
     */
    @NotBlank(message = "酒店介绍不能为空", groups = { AddGroup.class, EditGroup.class })
    private String introduction;

    /**
     * 取消政策
     */
    @NotBlank(message = "取消政策不能为空", groups = { AddGroup.class, EditGroup.class })
    private String canclePolicy;

    /**
     * 支持的信用卡
     */
    @NotBlank(message = "支持的信用卡不能为空", groups = { AddGroup.class, EditGroup.class })
    private String creditCards;

    /**
     * 酒店设施列表
     */
    @NotBlank(message = "酒店设施列表不能为空", groups = { AddGroup.class, EditGroup.class })
    private String facilities;

    /**
     * 酒店地址
     */
    @NotBlank(message = "酒店地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String address;

    /**
     * 酒店英文地址
     */
    @NotBlank(message = "酒店英文地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String addressEn;

    /**
     * 创建人
     */
    @NotBlank(message = "创建人不能为空", groups = { AddGroup.class, EditGroup.class })
    private String creator;

    /**
     * 修改人
     */
    @NotBlank(message = "修改人不能为空", groups = { AddGroup.class, EditGroup.class })
    private String modifier;

    /**
     * 修改时间
     */
    @NotNull(message = "修改时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date modifyTime;

    /**
     * 高德经度
     */
    @NotBlank(message = "高德经度不能为空", groups = { AddGroup.class, EditGroup.class })
    private String gaodeLat;

    /**
     * 高德维度
     */
    @NotBlank(message = "高德维度不能为空", groups = { AddGroup.class, EditGroup.class })
    private String gaodeLon;

    /**
     * 谷歌维度
     */
    @NotBlank(message = "谷歌维度不能为空", groups = { AddGroup.class, EditGroup.class })
    private String googleLat;

    /**
     * 谷歌经度
     */
    @NotBlank(message = "谷歌经度不能为空", groups = { AddGroup.class, EditGroup.class })
    private String googleLon;

    /**
     * 百度维度
     */
    @NotBlank(message = "百度维度不能为空", groups = { AddGroup.class, EditGroup.class })
    private String baiduLat;

    /**
     * 百度经度
     */
    @NotBlank(message = "百度经度不能为空", groups = { AddGroup.class, EditGroup.class })
    private String baiduLon;

    /**
     * 目的地标签
     */
    @NotNull(message = "目的地标签不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long destinationLable;


}
