package org.dromara.order.domain.bo;

import org.dromara.order.domain.OrdGuest;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 订单客人业务对象 ord_guest
 *
 * @author hmis
 * @date 2023-12-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = OrdGuest.class, reverseConvertGenerate = false)
public class OrdGuestBo extends BaseEntity {

    /**
     * 客户id
     */
    @NotNull(message = "客户id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long guestId;

    /**
     * 姓
     */
    @NotBlank(message = "姓不能为空", groups = { AddGroup.class, EditGroup.class })
    private String lastName;

    /**
     * 名
     */
    @NotBlank(message = "名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String firstName;

    /**
     * 名字
     */
    @NotBlank(message = "名字不能为空", groups = { AddGroup.class, EditGroup.class })
    private String name;

    /**
     * 订单编号
     */
    @NotNull(message = "订单编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long orderId;


}
