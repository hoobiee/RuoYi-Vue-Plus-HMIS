package org.dromara.order.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapping;
import lombok.Data;
import org.dromara.order.domain.OrdRemark;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 订单视图对象 ord_order
 *
 * @author hmis
 * @date 2023-12-11
 */
@Data
@ExcelIgnoreUnannotated
public class OrdOrderBaseVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @ExcelProperty(value = "订单ID")
    private Long orderId;

    /**
     * 订单编号
     */
    @ExcelProperty(value = "订单编号")
    private String orderNo;

    /**
     * 渠道订单号
     */
    @ExcelProperty(value = "渠道订单号")
    private String channelNo;

    /**
     * 供货单编号
     */
    @ExcelProperty(value = "供货单编号")
    private String supplyOrderNo;

    /**
     * 跟单员
     */
    @ExcelProperty(value = "跟单员")
    private String processors;

    /**
     * 入住时间
     */
    @ExcelProperty(value = "入住时间")
    private Date checkInTime;

    /**
     * 离店时间
     */
    @ExcelProperty(value = "离店时间")
    private Date checkOutTime;

    /**
     * 订单来源
     */
    @ExcelProperty(value = "订单来源")
    private String orderSource;

    /**
     * 结算方式
     */
    @ExcelProperty(value = "结算方式")
    private String settlementType;

    /**
     * 客户备注
     */
    @ExcelProperty(value = "客户备注")
    private String guestRemark;

    /**
     * 总售价
     */
    @ExcelProperty(value = "总售价")
    private BigDecimal totalSalePrice;

    /**
     * 总底价
     */
    @ExcelProperty(value = "总底价")
    private BigDecimal totalBasePrice;

    /**
     * 订单状态
     */
    @ExcelProperty(value = "订单状态")
    private String orderStatus;

    /**
     * 商家编码
     */
    @ExcelProperty(value = "商家编码")
    private String merchantCode;

    // 客户VO
    @ExcelProperty(value = "订单VO", index = 1)
    private OrdGuestVo guestVo;

    // 备注VO
    @ExcelProperty(value = "备注VO", index = 2)
    @AutoMapping
    private OrdRemark remark;

}