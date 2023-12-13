package org.dromara.bank.domain.bo;

import org.dromara.bank.domain.AgBank;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 分销商银行卡业务对象 ag_bank
 *
 * @author HMIS
 * @date 2023-12-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AgBank.class, reverseConvertGenerate = false)
public class AgBankBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long cardId;

    /**
     * 开户地
     */
    @NotBlank(message = "开户地不能为空", groups = { AddGroup.class, EditGroup.class })
    private String address;

    /**
     * 开户人
     */
    @NotBlank(message = "开户人不能为空", groups = { AddGroup.class, EditGroup.class })
    private String name;

    /**
     * 银行卡号
     */
    @NotBlank(message = "银行卡号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String cardNumber;

    /**
     * 分销商ID
     */
    @NotNull(message = "分销商ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long agentId;


}
