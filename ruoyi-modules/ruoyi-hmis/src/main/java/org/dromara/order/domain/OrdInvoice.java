package org.dromara.order.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 订单客人发票信息对象 ord_invoice
 *
 * @author Lion Li
 * @date 2023-12-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ord_invoice")
public class OrdInvoice extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 发票类型（0:普通纸质 1:电子）
     */
    private String invoiceType;

    /**
     * 发票抬头类型（0:个人 1:公司 2:政府）
     */
    private String invoiceTitleType;

    /**
     * 发票抬头
     */
    private String title;

    /**
     * 发票税号
     */
    private String taxpayerNumber;

    /**
     * 内容
     */
    private String body;

    /**
     * 金额
     */
    private String invoiceAmount;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 0 待开票  1已开票
     */
    private Long invoiceStatus;


}
