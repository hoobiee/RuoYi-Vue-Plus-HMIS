package org.dromara.order.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.dromara.order.domain.vo.OrdGuestVo;
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
import org.dromara.order.domain.bo.OrdGuestBo;
import org.dromara.order.service.IOrdGuestService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 订单客人
 *
 * @author hmis
 * @date 2023-12-13
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/hmis/guest")
public class OrdGuestController extends BaseController {

    private final IOrdGuestService ordGuestService;

    /**
     * 查询订单客人列表
     */
    @SaCheckPermission("hmis:guest:list")
    @GetMapping("/list")
    public TableDataInfo<OrdGuestVo> list(OrdGuestBo bo, PageQuery pageQuery) {
        return ordGuestService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出订单客人列表
     */
    @SaCheckPermission("hmis:guest:export")
    @Log(title = "订单客人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(OrdGuestBo bo, HttpServletResponse response) {
        List<OrdGuestVo> list = ordGuestService.queryList(bo);
        ExcelUtil.exportExcel(list, "订单客人", OrdGuestVo.class, response);
    }

    /**
     * 获取订单客人详细信息
     *
     * @param guestId 主键
     */
    @SaCheckPermission("hmis:guest:query")
    @GetMapping("/{guestId}")
    public R<OrdGuestVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long guestId) {
        return R.ok(ordGuestService.queryById(guestId));
    }

    /**
     * 新增订单客人
     */
    @SaCheckPermission("hmis:guest:add")
    @Log(title = "订单客人", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody OrdGuestBo bo) {
        return toAjax(ordGuestService.insertByBo(bo));
    }

    /**
     * 修改订单客人
     */
    @SaCheckPermission("hmis:guest:edit")
    @Log(title = "订单客人", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody OrdGuestBo bo) {
        return toAjax(ordGuestService.updateByBo(bo));
    }

    /**
     * 删除订单客人
     *
     * @param guestIds 主键串
     */
    @SaCheckPermission("hmis:guest:remove")
    @Log(title = "订单客人", businessType = BusinessType.DELETE)
    @DeleteMapping("/{guestIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] guestIds) {
        return toAjax(ordGuestService.deleteWithValidByIds(List.of(guestIds), true));
    }
}
