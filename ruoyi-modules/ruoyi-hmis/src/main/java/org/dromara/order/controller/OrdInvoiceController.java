package org.dromara.order.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.dromara.order.domain.vo.OrdInvoiceVo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.order.domain.bo.OrdInvoiceBo;
import org.dromara.order.service.IOrdInvoiceService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 订单客人发票信息
 *
 * @author Lion Li
 * @date 2023-12-13
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/hmis/invoice")
public class OrdInvoiceController extends BaseController {

    private final IOrdInvoiceService ordInvoiceService;

    /**
     * 查询订单客人发票信息列表
     */
    @SaCheckPermission("hmis:invoice:list")
    @GetMapping("/list")
    public TableDataInfo<OrdInvoiceVo> list(OrdInvoiceBo bo, PageQuery pageQuery) {
        return ordInvoiceService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出订单客人发票信息列表
     */
    @SaCheckPermission("hmis:invoice:export")
    @Log(title = "订单客人发票信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(OrdInvoiceBo bo, HttpServletResponse response) {
        List<OrdInvoiceVo> list = ordInvoiceService.queryList(bo);
        ExcelUtil.exportExcel(list, "订单客人发票信息", OrdInvoiceVo.class, response);
    }

    /**
     * 获取订单客人发票信息详细信息
     *
     * @param invoiceType 主键
     */
    @SaCheckPermission("hmis:invoice:query")
    @GetMapping("/{invoiceType}")
    public R<OrdInvoiceVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable String invoiceType) {
        return R.ok(ordInvoiceService.queryById(invoiceType));
    }

    /**
     * 新增订单客人发票信息
     */
    @SaCheckPermission("hmis:invoice:add")
    @Log(title = "订单客人发票信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody OrdInvoiceBo bo) {
        return toAjax(ordInvoiceService.insertByBo(bo));
    }

    /**
     * 修改订单客人发票信息
     */
    @SaCheckPermission("hmis:invoice:edit")
    @Log(title = "订单客人发票信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody OrdInvoiceBo bo) {
        return toAjax(ordInvoiceService.updateByBo(bo));
    }

    /**
     * 删除订单客人发票信息
     *
     * @param invoiceTypes 主键串
     */
    @SaCheckPermission("hmis:invoice:remove")
    @Log(title = "订单客人发票信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{invoiceTypes}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable String[] invoiceTypes) {
        return toAjax(ordInvoiceService.deleteWithValidByIds(List.of(invoiceTypes), true));
    }
}
