package org.dromara.order.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.dromara.order.service.IOrdRemarkService;
import org.springframework.stereotype.Service;
import org.dromara.order.domain.bo.OrdRemarkBo;
import org.dromara.order.domain.vo.OrdRemarkVo;
import org.dromara.order.domain.OrdRemark;
import org.dromara.order.mapper.OrdRemarkMapper;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 订单备注Service业务层处理
 *
 * @author hmis
 * @date 2023-12-13
 */
@RequiredArgsConstructor
@Service
public class OrdRemarkServiceImpl implements IOrdRemarkService {

    private final OrdRemarkMapper baseMapper;

    /**
     * 查询订单备注
     */
    @Override
    public OrdRemarkVo queryById(Long remarkId){
        return baseMapper.selectVoById(remarkId);
    }

    /**
     * 查询订单备注列表
     */
    @Override
    public TableDataInfo<OrdRemarkVo> queryPageList(OrdRemarkBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<OrdRemark> lqw = buildQueryWrapper(bo);
        Page<OrdRemarkVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询订单备注列表
     */
    @Override
    public List<OrdRemarkVo> queryList(OrdRemarkBo bo) {
        LambdaQueryWrapper<OrdRemark> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<OrdRemark> buildQueryWrapper(OrdRemarkBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<OrdRemark> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getRemarkType()), OrdRemark::getRemarkType, bo.getRemarkType());
        lqw.eq(StringUtils.isNotBlank(bo.getDesc()), OrdRemark::getDesc, bo.getDesc());
        lqw.eq(bo.getOrderId() != null, OrdRemark::getOrderId, bo.getOrderId());
        return lqw;
    }

    /**
     * 新增订单备注
     */
    @Override
    public Boolean insertByBo(OrdRemarkBo bo) {
        OrdRemark add = MapstructUtils.convert(bo, OrdRemark.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setRemarkId(add.getRemarkId());
        }
        return flag;
    }

    /**
     * 修改订单备注
     */
    @Override
    public Boolean updateByBo(OrdRemarkBo bo) {
        OrdRemark update = MapstructUtils.convert(bo, OrdRemark.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(OrdRemark entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除订单备注
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
