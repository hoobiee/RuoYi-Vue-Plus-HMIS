package org.dromara.order.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.dromara.order.domain.vo.OrdRemarkVo;
import org.dromara.order.service.IOrdRemarkService;
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
import org.dromara.order.domain.bo.OrdRemarkBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 订单备注
 *
 * @author hmis
 * @date 2023-12-13
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/hmis/remark")
public class OrdRemarkController extends BaseController {

    private final IOrdRemarkService ordRemarkService;

    /**
     * 查询订单备注列表
     */
    @SaCheckPermission("hmis:remark:list")
    @GetMapping("/list")
    public TableDataInfo<OrdRemarkVo> list(OrdRemarkBo bo, PageQuery pageQuery) {
        return ordRemarkService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出订单备注列表
     */
    @SaCheckPermission("hmis:remark:export")
    @Log(title = "订单备注", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(OrdRemarkBo bo, HttpServletResponse response) {
        List<OrdRemarkVo> list = ordRemarkService.queryList(bo);
        ExcelUtil.exportExcel(list, "订单备注", OrdRemarkVo.class, response);
    }

    /**
     * 获取订单备注详细信息
     *
     * @param remarkId 主键
     */
    @SaCheckPermission("hmis:remark:query")
    @GetMapping("/{remarkId}")
    public R<OrdRemarkVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long remarkId) {
        return R.ok(ordRemarkService.queryById(remarkId));
    }

    /**
     * 新增订单备注
     */
    @SaCheckPermission("hmis:remark:add")
    @Log(title = "订单备注", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody OrdRemarkBo bo) {
        return toAjax(ordRemarkService.insertByBo(bo));
    }

    /**
     * 修改订单备注
     */
    @SaCheckPermission("hmis:remark:edit")
    @Log(title = "订单备注", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody OrdRemarkBo bo) {
        return toAjax(ordRemarkService.updateByBo(bo));
    }

    /**
     * 删除订单备注
     *
     * @param remarkIds 主键串
     */
    @SaCheckPermission("hmis:remark:remove")
    @Log(title = "订单备注", businessType = BusinessType.DELETE)
    @DeleteMapping("/{remarkIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] remarkIds) {
        return toAjax(ordRemarkService.deleteWithValidByIds(List.of(remarkIds), true));
    }
}
