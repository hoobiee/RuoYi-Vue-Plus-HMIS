package org.dromara.order.domain.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.order.domain.OrdOrder;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单业务对象 ord_order
 *
 * @author hmis
 * @date 2023-12-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = OrdOrder.class, reverseConvertGenerate = false)
public class OrdOrderBaseBo extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableId(value = "order_id")
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 渠道订单号
     */
    private String channelNo;

    /**
     * 供货单编号
     */
    private String supplyOrderNo;

    /**
     * 跟单员
     */
    private String processors;

    /**
     * 入住时间
     */
    private Date checkInTime;

    /**
     * 离店时间
     */
    private Date checkOutTime;

    /**
     * 订单来源
     */
    private String orderSource;

    /**
     * 结算方式
     */
    private String settlementType;

    /**
     * 客户备注
     */
    private String guestRemark;

    /**
     * 总售价
     */
    private BigDecimal totalSalePrice;

    /**
     * 总底价
     */
    private BigDecimal totalBasePrice;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 商家编码
     */
    private String merchantCode;

    private OrdRemarkBo ordRemarkBo;

    private OrdGuestBo ordGuestBo;

}
