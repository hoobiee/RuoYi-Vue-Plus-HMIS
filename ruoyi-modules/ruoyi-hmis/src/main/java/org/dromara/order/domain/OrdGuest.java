package org.dromara.order.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 订单客人对象 ord_guest
 *
 * @author hmis
 * @date 2023-12-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ord_guest")
public class OrdGuest extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(value = "guest_id")
    private Long guestId;

    /**
     * 姓
     */
    private String lastName;

    /**
     * 名
     */
    private String firstName;

    /**
     * 名字
     */
    private String name;

    /**
     * 订单编号
     */
    private Long orderId;


}
