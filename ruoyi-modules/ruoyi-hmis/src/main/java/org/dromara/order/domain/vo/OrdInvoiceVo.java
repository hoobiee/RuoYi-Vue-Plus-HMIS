package org.dromara.order.domain.vo;

import org.dromara.order.domain.OrdInvoice;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 订单客人发票信息视图对象 ord_invoice
 *
 * @author Lion Li
 * @date 2023-12-13
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = OrdInvoice.class)
public class OrdInvoiceVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 发票类型（0:普通纸质 1:电子）
     */
    @ExcelProperty(value = "发票类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=:普通纸质,1=:电子")
    private String invoiceType;

    /**
     * 发票抬头类型（0:个人 1:公司 2:政府）
     */
    @ExcelProperty(value = "发票抬头类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=:个人,1=:公司,2=:政府")
    private String invoiceTitleType;

    /**
     * 发票抬头
     */
    @ExcelProperty(value = "发票抬头")
    private String title;

    /**
     * 发票税号
     */
    @ExcelProperty(value = "发票税号")
    private String taxpayerNumber;

    /**
     * 内容
     */
    @ExcelProperty(value = "内容")
    private String body;

    /**
     * 金额
     */
    @ExcelProperty(value = "金额")
    private String invoiceAmount;

    /**
     * 电子邮箱
     */
    @ExcelProperty(value = "电子邮箱")
    private String email;

    /**
     * 地址
     */
    @ExcelProperty(value = "地址")
    private String address;

    /**
     * 0 待开票  1已开票
     */
    @ExcelProperty(value = "0 待开票  1已开票")
    private Long invoiceStatus;


}
