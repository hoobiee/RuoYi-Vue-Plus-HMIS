package org.dromara.bank.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.dromara.bank.domain.bo.AgBankBo;
import org.dromara.bank.domain.vo.AgBankVo;
import org.dromara.bank.domain.AgBank;
import org.dromara.bank.mapper.AgBankMapper;
import org.dromara.bank.service.IAgBankService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 分销商银行卡Service业务层处理
 *
 * @author HMIS
 * @date 2023-12-11
 */
@RequiredArgsConstructor
@Service
public class AgBankServiceImpl implements IAgBankService {

    private final AgBankMapper baseMapper;

    /**
     * 查询分销商银行卡
     */
    @Override
    public AgBankVo queryById(Long cardId){
        return baseMapper.selectVoById(cardId);
    }

    /**
     * 查询分销商银行卡列表
     */
    @Override
    public TableDataInfo<AgBankVo> queryPageList(AgBankBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<AgBank> lqw = buildQueryWrapper(bo);
        Page<AgBankVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询分销商银行卡列表
     */
    @Override
    public List<AgBankVo> queryList(AgBankBo bo) {
        LambdaQueryWrapper<AgBank> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<AgBank> buildQueryWrapper(AgBankBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<AgBank> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getAddress()), AgBank::getAddress, bo.getAddress());
        lqw.like(StringUtils.isNotBlank(bo.getName()), AgBank::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getCardNumber()), AgBank::getCardNumber, bo.getCardNumber());
        lqw.eq(bo.getAgentId() != null, AgBank::getAgentId, bo.getAgentId());
        return lqw;
    }

    /**
     * 新增分销商银行卡
     */
    @Override
    public Boolean insertByBo(AgBankBo bo) {
        AgBank add = MapstructUtils.convert(bo, AgBank.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setCardId(add.getCardId());
        }
        return flag;
    }

    /**
     * 修改分销商银行卡
     */
    @Override
    public Boolean updateByBo(AgBankBo bo) {
        AgBank update = MapstructUtils.convert(bo, AgBank.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(AgBank entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除分销商银行卡
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
