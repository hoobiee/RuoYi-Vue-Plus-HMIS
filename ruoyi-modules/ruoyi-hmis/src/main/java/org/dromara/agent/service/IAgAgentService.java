package org.dromara.agent.service;

import org.dromara.agent.domain.AgAgent;
import org.dromara.agent.domain.vo.AgAgentVo;
import org.dromara.agent.domain.bo.AgAgentBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 分销商管理Service接口
 *
 * @author hmis
 * @date 2023-12-11
 */
public interface IAgAgentService {

    /**
     * 查询分销商管理
     */
    AgAgentVo queryById(Long agentId);

    /**
     * 查询分销商管理列表
     */
    TableDataInfo<AgAgentVo> queryPageList(AgAgentBo bo, PageQuery pageQuery);

    /**
     * 查询分销商管理列表
     */
    List<AgAgentVo> queryList(AgAgentBo bo);

    /**
     * 新增分销商管理
     */
    Boolean insertByBo(AgAgentBo bo);

    /**
     * 修改分销商管理
     */
    Boolean updateByBo(AgAgentBo bo);

    /**
     * 校验并批量删除分销商管理信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
