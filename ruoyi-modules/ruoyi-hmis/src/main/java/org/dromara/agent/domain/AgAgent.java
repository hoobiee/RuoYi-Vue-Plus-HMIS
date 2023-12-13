package org.dromara.agent.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

import java.io.Serial;

/**
 * 分销商管理对象 ag_agent
 *
 * @author hmis
 * @date 2023-12-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ag_agent")
public class AgAgent extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "agent_id")
    private Long agentId;

    /**
     * 编号
     */
    private String agentCode;

    /**
     * 名字
     */
    private String agentName;

    /**
     * 结算币种
     */
    private String settlementCurrency;

    /**
     * 结算方式
     */
    private String settlementType;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 对账日
     */
    private Long settlementDay;

    /**
     * 信用额度
     */
    private BigDecimal lineOfCredit;

    /**
     * 商家编码
     */
    private String merchantCode;


}
