package org.dromara.agent.domain.vo;

import java.math.BigDecimal;
import org.dromara.agent.domain.AgAgent;
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
 * 分销商管理视图对象 ag_agent
 *
 * @author hmis
 * @date 2023-12-11
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AgAgent.class)
public class AgAgentVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long agentId;

    /**
     * 编号
     */
    @ExcelProperty(value = "编号")
    private String agentCode;

    /**
     * 名字
     */
    @ExcelProperty(value = "名字")
    private String agentName;

    /**
     * 结算币种
     */
    @ExcelProperty(value = "结算币种")
    private String settlementCurrency;

    /**
     * 结算方式
     */
    @ExcelProperty(value = "结算方式")
    private String settlementType;

    /**
     * 联系电话
     */
    @ExcelProperty(value = "联系电话")
    private String phone;

    /**
     * 联系人
     */
    @ExcelProperty(value = "联系人")
    private String contact;

    /**
     * 对账日
     */
    @ExcelProperty(value = "对账日")
    private Long settlementDay;

    /**
     * 信用额度
     */
    @ExcelProperty(value = "信用额度")
    private BigDecimal lineOfCredit;

    /**
     * 商家编码
     */
    @ExcelProperty(value = "商家编码")
    private String merchantCode;


}
