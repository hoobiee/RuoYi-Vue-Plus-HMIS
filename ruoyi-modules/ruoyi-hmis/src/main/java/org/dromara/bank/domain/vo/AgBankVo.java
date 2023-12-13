package org.dromara.bank.domain.vo;

import org.dromara.bank.domain.AgBank;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 分销商银行卡视图对象 ag_bank
 *
 * @author HMIS
 * @date 2023-12-11
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AgBank.class)
public class AgBankVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long cardId;

    /**
     * 开户地
     */
    @ExcelProperty(value = "开户地")
    private String address;

    /**
     * 开户人
     */
    @ExcelProperty(value = "开户人")
    private String name;

    /**
     * 银行卡号
     */
    @ExcelProperty(value = "银行卡号")
    private String cardNumber;

    /**
     * 分销商ID
     */
    @ExcelProperty(value = "分销商ID")
    private Long agentId;


}
