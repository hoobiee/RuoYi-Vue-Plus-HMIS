package org.dromara.bank.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
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
import org.dromara.bank.domain.vo.AgBankVo;
import org.dromara.bank.domain.bo.AgBankBo;
import org.dromara.bank.service.IAgBankService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 分销商银行卡
 *
 * @author HMIS
 * @date 2023-12-11
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/hmis/bank")
public class AgBankController extends BaseController {

    private final IAgBankService agBankService;

    /**
     * 查询分销商银行卡列表
     */
    @SaCheckPermission("hmis:bank:list")
    @GetMapping("/list")
    public TableDataInfo<AgBankVo> list(AgBankBo bo, PageQuery pageQuery) {
        return agBankService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出分销商银行卡列表
     */
    @SaCheckPermission("hmis:bank:export")
    @Log(title = "分销商银行卡", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(AgBankBo bo, HttpServletResponse response) {
        List<AgBankVo> list = agBankService.queryList(bo);
        ExcelUtil.exportExcel(list, "分销商银行卡", AgBankVo.class, response);
    }

    /**
     * 获取分销商银行卡详细信息
     *
     * @param cardId 主键
     */
    @SaCheckPermission("hmis:bank:query")
    @GetMapping("/{cardId}")
    public R<AgBankVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long cardId) {
        return R.ok(agBankService.queryById(cardId));
    }

    /**
     * 新增分销商银行卡
     */
    @SaCheckPermission("hmis:bank:add")
    @Log(title = "分销商银行卡", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody AgBankBo bo) {
        return toAjax(agBankService.insertByBo(bo));
    }

    /**
     * 修改分销商银行卡
     */
    @SaCheckPermission("hmis:bank:edit")
    @Log(title = "分销商银行卡", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody AgBankBo bo) {
        return toAjax(agBankService.updateByBo(bo));
    }

    /**
     * 删除分销商银行卡
     *
     * @param cardIds 主键串
     */
    @SaCheckPermission("hmis:bank:remove")
    @Log(title = "分销商银行卡", businessType = BusinessType.DELETE)
    @DeleteMapping("/{cardIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] cardIds) {
        return toAjax(agBankService.deleteWithValidByIds(List.of(cardIds), true));
    }
}
