package com.ruoyi.hmis.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.hmis.domain.bo.HtlHotelBo;
import com.ruoyi.hmis.domain.vo.HtlHotelVo;
import com.ruoyi.hmis.service.IHtlHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * 酒店详情列
 *
 * @author ruoyi
 * @date 2023-08-06
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/hmis/hotel")
public class HtlHotelController extends BaseController {

    private final IHtlHotelService iHtlHotelService;

    /**
     * 查询酒店详情列列表
     */
    @SaCheckPermission("hmis:hotel:list")
    @GetMapping("/list")
    public TableDataInfo<HtlHotelVo> list(HtlHotelBo bo, PageQuery pageQuery) {
        return iHtlHotelService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出酒店详情列列表
     */
    @SaCheckPermission("hmis:hotel:export")
    @Log(title = "酒店详情列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HtlHotelBo bo, HttpServletResponse response) {
        List<HtlHotelVo> list = iHtlHotelService.queryList(bo);
        ExcelUtil.exportExcel(list, "酒店详情列", HtlHotelVo.class, response);
    }

    /**
     * 获取酒店详情列详细信息
     *
     * @param hotelId 主键
     */
    @SaCheckPermission("hmis:hotel:query")
    @GetMapping("/{hotelId}")
    public R<HtlHotelVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long hotelId) {
        return R.ok(iHtlHotelService.queryById(hotelId));
    }

    /**
     * 新增酒店详情列
     */
    @SaCheckPermission("hmis:hotel:add")
    @Log(title = "酒店详情列", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody HtlHotelBo bo) {
        return toAjax(iHtlHotelService.insertByBo(bo));
    }

    /**
     * 修改酒店详情列
     */
    @SaCheckPermission("hmis:hotel:edit")
    @Log(title = "酒店详情列", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody HtlHotelBo bo) {
        return toAjax(iHtlHotelService.updateByBo(bo));
    }

    /**
     * 删除酒店详情列
     *
     * @param hotelIds 主键串
     */
    @SaCheckPermission("hmis:hotel:remove")
    @Log(title = "酒店详情列", businessType = BusinessType.DELETE)
    @DeleteMapping("/{hotelIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] hotelIds) {
        return toAjax(iHtlHotelService.deleteWithValidByIds(Arrays.asList(hotelIds), true));
    }
}
