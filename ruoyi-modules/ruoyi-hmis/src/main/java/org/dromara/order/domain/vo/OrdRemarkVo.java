package org.dromara.order.domain.vo;

import org.dromara.order.domain.OrdRemark;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 订单备注视图对象 ord_remark
 *
 * @author hmis
 * @date 2023-12-13
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = OrdRemark.class)
public class OrdRemarkVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 备注ID
     */
    @ExcelProperty(value = "备注ID")
    private Long remarkId;

    /**
     * 备注类型
     */
    @ExcelProperty(value = "备注类型")
    private String remarkType;

    /**
     * 描述
     */
    @ExcelProperty(value = "描述")
    private String ordDesc;

    /**
     * 订单编号
     */
    @ExcelProperty(value = "订单编号")
    private Long orderId;


}
