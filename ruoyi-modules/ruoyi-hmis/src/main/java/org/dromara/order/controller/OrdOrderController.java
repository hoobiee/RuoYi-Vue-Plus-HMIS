package org.dromara.order.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.web.core.BaseController;
import org.dromara.order.domain.bo.OrdOrderBo;
import org.dromara.order.domain.vo.OrdOrderVo;
import org.dromara.order.service.IOrdOrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 订单
 *
 * @author hmis
 * @date 2023-12-11
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/hmis/order")
public class OrdOrderController extends BaseController {

    private final IOrdOrderService ordOrderService;

    /**
     * 查询订单列表
     */
    @SaCheckPermission("hmis:order:list")
    @GetMapping("/list")
    public TableDataInfo<OrdOrderVo> list(OrdOrderBo bo, PageQuery pageQuery) {
        return ordOrderService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出订单列表
     */
    @SaCheckPermission("hmis:order:export")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(OrdOrderBo bo, HttpServletResponse response) {
        List<OrdOrderVo> list = ordOrderService.queryList(bo);
        ExcelUtil.exportExcel(list, "订单", OrdOrderVo.class, response);
    }

    /**
     * 获取订单详细信息
     *
     * @param orderId 主键
     */
    @SaCheckPermission("hmis:order:query")
    @GetMapping("/{orderId}")
    public R<OrdOrderVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long orderId) {
        return R.ok(ordOrderService.queryById(orderId));
    }

    /**
     * 新增订单
     */
    @SaCheckPermission("hmis:order:add")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody OrdOrderBo bo) {
        return toAjax(ordOrderService.insertByBo(bo));
    }

    /**
     * 修改订单
     */
    @SaCheckPermission("hmis:order:edit")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody OrdOrderBo bo) {
        return toAjax(ordOrderService.updateByBo(bo));
    }

    /**
     * 删除订单
     *
     * @param orderIds 主键串
     */
    @SaCheckPermission("hmis:order:remove")
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{orderIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] orderIds) {
        return toAjax(ordOrderService.deleteWithValidByIds(List.of(orderIds), true));
    }
}
