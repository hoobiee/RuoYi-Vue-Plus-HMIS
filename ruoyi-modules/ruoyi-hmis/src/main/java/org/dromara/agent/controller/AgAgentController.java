package org.dromara.agent.controller;

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
import org.dromara.agent.domain.vo.AgAgentVo;
import org.dromara.agent.domain.bo.AgAgentBo;
import org.dromara.agent.service.IAgAgentService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 分销商管理
 *
 * @author hmis
 * @date 2023-12-11
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/hmis/agent")
public class AgAgentController extends BaseController {

    private final IAgAgentService agAgentService;

    /**
     * 查询分销商管理列表
     */
    @SaCheckPermission("hmis:agent:list")
    @GetMapping("/list")
    public TableDataInfo<AgAgentVo> list(AgAgentBo bo, PageQuery pageQuery) {
        return agAgentService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出分销商管理列表
     */
    @SaCheckPermission("hmis:agent:export")
    @Log(title = "分销商管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(AgAgentBo bo, HttpServletResponse response) {
        List<AgAgentVo> list = agAgentService.queryList(bo);
        ExcelUtil.exportExcel(list, "分销商管理", AgAgentVo.class, response);
    }

    /**
     * 获取分销商管理详细信息
     *
     * @param agentId 主键
     */
    @SaCheckPermission("hmis:agent:query")
    @GetMapping("/{agentId}")
    public R<AgAgentVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long agentId) {
        return R.ok(agAgentService.queryById(agentId));
    }

    /**
     * 新增分销商管理
     */
    @SaCheckPermission("hmis:agent:add")
    @Log(title = "分销商管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody AgAgentBo bo) {
        return toAjax(agAgentService.insertByBo(bo));
    }

    /**
     * 修改分销商管理
     */
    @SaCheckPermission("hmis:agent:edit")
    @Log(title = "分销商管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody AgAgentBo bo) {
        return toAjax(agAgentService.updateByBo(bo));
    }

    /**
     * 删除分销商管理
     *
     * @param agentIds 主键串
     */
    @SaCheckPermission("hmis:agent:remove")
    @Log(title = "分销商管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{agentIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] agentIds) {
        return toAjax(agAgentService.deleteWithValidByIds(List.of(agentIds), true));
    }
}
