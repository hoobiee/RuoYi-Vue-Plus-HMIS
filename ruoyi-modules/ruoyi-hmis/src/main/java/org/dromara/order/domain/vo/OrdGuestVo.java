package org.dromara.order.domain.vo;

import org.dromara.order.domain.OrdGuest;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 订单客人视图对象 ord_guest
 *
 * @author hmis
 * @date 2023-12-13
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = OrdGuest.class)
public class OrdGuestVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ExcelProperty(value = "")
    private Long guestId;

    /**
     * 姓
     */
    @ExcelProperty(value = "姓")
    private String lastName;

    /**
     * 名
     */
    @ExcelProperty(value = "名")
    private String firstName;

    /**
     * 名字
     */
    @ExcelProperty(value = "名字")
    private String name;

    /**
     * 订单编号
     */
    @ExcelProperty(value = "订单编号")
    private Long orderId;


}
