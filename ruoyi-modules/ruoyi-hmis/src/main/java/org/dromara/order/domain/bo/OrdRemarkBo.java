package org.dromara.order.domain.bo;

import org.dromara.order.domain.OrdRemark;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 订单备注业务对象 ord_remark
 *
 * @author hmis
 * @date 2023-12-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = OrdRemark.class, reverseConvertGenerate = false)
public class OrdRemarkBo extends BaseEntity {

    /**
     *
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long remarkId;

    /**
     *
     */
    @NotBlank(message = "不能为空", groups = { AddGroup.class, EditGroup.class })
    private String remarkType;

    /**
     *
     */
    @NotBlank(message = "不能为空", groups = { AddGroup.class, EditGroup.class })
    private String desc;

    /**
     * 订单编号
     */
    @NotNull(message = "订单编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long orderId;


}
