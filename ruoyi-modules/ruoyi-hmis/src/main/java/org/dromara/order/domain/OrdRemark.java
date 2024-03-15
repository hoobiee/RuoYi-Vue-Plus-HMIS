package org.dromara.order.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 订单备注对象 ord_remark
 *
 * @author hmis
 * @date 2023-12-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ord_remark")
public class OrdRemark extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 备注ID
     */
    @TableId(value = "remark_id")
    private Long remarkId;

    /**
     * 备注类型
     */
    private String remarkType;

    /**
     * 描述
     */
    private String ordDesc;

    /**
     * 订单编号
     */
    private Long orderId;


}