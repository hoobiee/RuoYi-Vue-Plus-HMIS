package org.dromara.bank.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 分销商银行卡对象 ag_bank
 *
 * @author HMIS
 * @date 2023-12-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ag_bank")
public class AgBank extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "card_id")
    private Long cardId;

    /**
     * 开户地
     */
    private String address;

    /**
     * 开户人
     */
    private String name;

    /**
     * 银行卡号
     */
    private String cardNumber;

    /**
     * 分销商ID
     */
    private Long agentId;


}
