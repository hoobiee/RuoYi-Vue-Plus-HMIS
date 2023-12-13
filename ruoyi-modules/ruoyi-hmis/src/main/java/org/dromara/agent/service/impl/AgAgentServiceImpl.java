package org.dromara.agent.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.dromara.agent.domain.bo.AgAgentBo;
import org.dromara.agent.domain.vo.AgAgentVo;
import org.dromara.agent.domain.AgAgent;
import org.dromara.agent.mapper.AgAgentMapper;
import org.dromara.agent.service.IAgAgentService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 分销商管理Service业务层处理
 *
 * @author hmis
 * @date 2023-12-11
 */
@RequiredArgsConstructor
@Service
public class AgAgentServiceImpl implements IAgAgentService {

    private final AgAgentMapper baseMapper;

    /**
     * 查询分销商管理
     */
    @Override
    public AgAgentVo queryById(Long agentId){
        return baseMapper.selectVoById(agentId);
    }

    /**
     * 查询分销商管理列表
     */
    @Override
    public TableDataInfo<AgAgentVo> queryPageList(AgAgentBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<AgAgent> lqw = buildQueryWrapper(bo);
        Page<AgAgentVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询分销商管理列表
     */
    @Override
    public List<AgAgentVo> queryList(AgAgentBo bo) {
        LambdaQueryWrapper<AgAgent> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<AgAgent> buildQueryWrapper(AgAgentBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<AgAgent> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getAgentId() != null, AgAgent::getAgentId, bo.getAgentId());
        lqw.eq(StringUtils.isNotBlank(bo.getAgentCode()), AgAgent::getAgentCode, bo.getAgentCode());
        lqw.like(StringUtils.isNotBlank(bo.getAgentName()), AgAgent::getAgentName, bo.getAgentName());
        lqw.eq(StringUtils.isNotBlank(bo.getSettlementCurrency()), AgAgent::getSettlementCurrency, bo.getSettlementCurrency());
        lqw.eq(StringUtils.isNotBlank(bo.getSettlementType()), AgAgent::getSettlementType, bo.getSettlementType());
        lqw.eq(StringUtils.isNotBlank(bo.getPhone()), AgAgent::getPhone, bo.getPhone());
        lqw.eq(StringUtils.isNotBlank(bo.getContact()), AgAgent::getContact, bo.getContact());
        lqw.eq(bo.getSettlementDay() != null, AgAgent::getSettlementDay, bo.getSettlementDay());
        lqw.eq(bo.getLineOfCredit() != null, AgAgent::getLineOfCredit, bo.getLineOfCredit());
        lqw.eq(StringUtils.isNotBlank(bo.getMerchantCode()), AgAgent::getMerchantCode, bo.getMerchantCode());
        return lqw;
    }

    /**
     * 新增分销商管理
     */
    @Override
    public Boolean insertByBo(AgAgentBo bo) {
        AgAgent add = MapstructUtils.convert(bo, AgAgent.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setAgentId(add.getAgentId());
        }
        return flag;
    }

    /**
     * 修改分销商管理
     */
    @Override
    public Boolean updateByBo(AgAgentBo bo) {
        AgAgent update = MapstructUtils.convert(bo, AgAgent.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(AgAgent entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除分销商管理
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
