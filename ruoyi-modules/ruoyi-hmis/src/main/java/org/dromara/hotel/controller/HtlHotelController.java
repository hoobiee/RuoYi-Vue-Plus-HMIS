package org.dromara.hotel.controller;

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
import org.dromara.common.satoken.utils.LoginHelper;
import org.dromara.common.web.core.BaseController;
import org.dromara.hotel.domain.bo.HtlHotelBo;
import org.dromara.hotel.domain.vo.HtlHotelVo;
import org.dromara.hotel.service.IHtlHotelService;
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
 * 酒店详情
 *
 * @author hmis
 * @date 2023-12-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/hmis/hotel")
public class HtlHotelController extends BaseController {

    private final IHtlHotelService htlHotelService;

    /**
     * 查询酒店详情列表
     */
    @SaCheckPermission("hmis:hotel:list")
    @GetMapping("/list")
    public TableDataInfo<HtlHotelVo> list(HtlHotelBo bo, PageQuery pageQuery) {
        return htlHotelService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出酒店详情列表
     */
    @SaCheckPermission("hmis:hotel:export")
    @Log(title = "酒店详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HtlHotelBo bo, HttpServletResponse response) {
        List<HtlHotelVo> list = htlHotelService.queryList(bo);
        ExcelUtil.exportExcel(list, "酒店详情", HtlHotelVo.class, response);
    }

    /**
     * 获取酒店详情详细信息
     *
     * @param hotelId 主键
     */
    @SaCheckPermission("hmis:hotel:query")
    @GetMapping("/{hotelId}")
    public R<HtlHotelVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long hotelId) {
        return R.ok(htlHotelService.queryById(hotelId));
    }

    /**
     * 新增酒店详情
     */
    @SaCheckPermission("hmis:hotel:add")
    @Log(title = "酒店详情", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody HtlHotelBo bo) {
        return toAjax(htlHotelService.insertByBo(bo));
    }

    /**
     * 修改酒店详情
     */
    @SaCheckPermission("hmis:hotel:edit")
    @Log(title = "酒店详情", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody HtlHotelBo bo) {
        Long userId = LoginHelper.getUserId();
        bo.setUpdateBy(userId);
        return toAjax(htlHotelService.updateByBo(bo));
    }

    /**
     * 删除酒店详情
     *
     * @param hotelIds 主键串
     */
    @SaCheckPermission("hmis:hotel:remove")
    @Log(title = "酒店详情", businessType = BusinessType.DELETE)
    @DeleteMapping("/{hotelIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] hotelIds) {
        return toAjax(htlHotelService.deleteWithValidByIds(List.of(hotelIds), true));
    }
}
