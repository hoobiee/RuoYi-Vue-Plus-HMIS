package org.dromara.order.domain.bo;

import org.dromara.order.domain.OrdInvoice;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 订单客人发票信息业务对象 ord_invoice
 *
 * @author Lion Li
 * @date 2023-12-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = OrdInvoice.class, reverseConvertGenerate = false)
public class OrdInvoiceBo extends BaseEntity {

    /**
     * 发票类型（0:普通纸质 1:电子）
     */
    @NotBlank(message = "发票类型（0:普通纸质 1:电子）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String invoiceType;

    /**
     * 发票抬头类型（0:个人 1:公司 2:政府）
     */
    @NotBlank(message = "发票抬头类型（0:个人 1:公司 2:政府）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String invoiceTitleType;

    /**
     * 发票抬头
     */
    @NotBlank(message = "发票抬头不能为空", groups = { AddGroup.class, EditGroup.class })
    private String title;

    /**
     * 发票税号
     */
    @NotBlank(message = "发票税号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String taxpayerNumber;

    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空", groups = { AddGroup.class, EditGroup.class })
    private String body;

    /**
     * 金额
     */
    @NotBlank(message = "金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private String invoiceAmount;

    /**
     * 电子邮箱
     */
    @NotBlank(message = "电子邮箱不能为空", groups = { AddGroup.class, EditGroup.class })
    private String email;

    /**
     * 地址
     */
    @NotBlank(message = "地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String address;

    /**
     * 0 待开票  1已开票
     */
    @NotNull(message = "0 待开票  1已开票不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long invoiceStatus;


}
