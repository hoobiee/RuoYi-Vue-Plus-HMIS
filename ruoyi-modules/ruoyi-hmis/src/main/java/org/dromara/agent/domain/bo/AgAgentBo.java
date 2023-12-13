package org.dromara.agent.domain.bo;

import org.dromara.agent.domain.AgAgent;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

/**
 * 分销商管理业务对象 ag_agent
 *
 * @author hmis
 * @date 2023-12-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AgAgent.class, reverseConvertGenerate = false)
public class AgAgentBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long agentId;

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String agentCode;

    /**
     * 名字
     */
    @NotBlank(message = "名字不能为空", groups = { AddGroup.class, EditGroup.class })
    private String agentName;

    /**
     * 结算币种
     */
    @NotBlank(message = "结算币种不能为空", groups = { AddGroup.class, EditGroup.class })
    private String settlementCurrency;

    /**
     * 结算方式
     */
    @NotBlank(message = "结算方式不能为空", groups = { AddGroup.class, EditGroup.class })
    private String settlementType;

    /**
     * 联系电话
     */
    @NotBlank(message = "联系电话不能为空", groups = { AddGroup.class, EditGroup.class })
    private String phone;

    /**
     * 联系人
     */
    @NotBlank(message = "联系人不能为空", groups = { AddGroup.class, EditGroup.class })
    private String contact;

    /**
     * 对账日
     */
    @NotNull(message = "对账日不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long settlementDay;

    /**
     * 信用额度
     */
    @NotNull(message = "信用额度不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal lineOfCredit;

    /**
     * 商家编码
     */
    @NotBlank(message = "商家编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String merchantCode;


}
