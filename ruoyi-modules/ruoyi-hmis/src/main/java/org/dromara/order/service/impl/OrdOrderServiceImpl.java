package org.dromara.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.order.domain.OrdOrder;
import org.dromara.order.domain.bo.OrdOrderBo;
import org.dromara.order.domain.vo.OrdOrderVo;
import org.dromara.order.mapper.OrdOrderMapper;
import org.dromara.order.service.IOrdOrderService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 订单Service业务层处理
 *
 * @author hmis
 * @date 2023-12-11
 */
@RequiredArgsConstructor
@Service
public class OrdOrderServiceImpl implements IOrdOrderService {

    private final OrdOrderMapper baseMapper;


    /**
     * 查询订单
     */
    @Override
    public OrdOrderVo queryById(Long orderId){
        return baseMapper.selectVoById(orderId);
    }

    /**
     * 查询订单列表
     */
    @Override
    public TableDataInfo<OrdOrderVo> queryPageList(OrdOrderBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<OrdOrder> lqw            = buildQueryWrapper(bo);
        Page<OrdOrderVo>             ordOrderVoPage = baseMapper.selectVoPage(pageQuery.build(), lqw);
        // 根据
        Page<OrdOrderVo>             result         = ordOrderVoPage;
        return TableDataInfo.build(result);
    }

    /**
     * 查询订单列表
     */
    @Override
    public TableDataInfo<OrdOrderVo> queryBasePageList(OrdOrderBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<OrdOrder> lqw            = buildQueryWrapper(bo);
        Page<OrdOrderVo>             ordOrderVoPage = baseMapper.selectVoPage(pageQuery.build(), lqw);
        Page<OrdOrderVo>             result         = ordOrderVoPage;
        return TableDataInfo.build(result);
    }


    /**
     * 查询订单列表
     */
    @Override
    public List<OrdOrderVo> queryList(OrdOrderBo bo) {
        LambdaQueryWrapper<OrdOrder> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<OrdOrder> buildQueryWrapper(OrdOrderBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<OrdOrder> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getOrderId() != null, OrdOrder::getOrderId, bo.getOrderId());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderNo()), OrdOrder::getOrderNo, bo.getOrderNo());
        lqw.eq(StringUtils.isNotBlank(bo.getChannelNo()), OrdOrder::getChannelNo, bo.getChannelNo());
        lqw.eq(StringUtils.isNotBlank(bo.getSupplyOrderNo()), OrdOrder::getSupplyOrderNo, bo.getSupplyOrderNo());
        lqw.eq(StringUtils.isNotBlank(bo.getProcessors()), OrdOrder::getProcessors, bo.getProcessors());
        lqw.eq(bo.getCheckInTime() != null, OrdOrder::getCheckInTime, bo.getCheckInTime());
        lqw.eq(bo.getCheckOutTime() != null, OrdOrder::getCheckOutTime, bo.getCheckOutTime());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSource()), OrdOrder::getOrderSource, bo.getOrderSource());
        lqw.eq(StringUtils.isNotBlank(bo.getSettlementType()), OrdOrder::getSettlementType, bo.getSettlementType());
        lqw.eq(StringUtils.isNotBlank(bo.getGuestRemark()), OrdOrder::getGuestRemark, bo.getGuestRemark());
        lqw.eq(bo.getTotalSalePrice() != null, OrdOrder::getTotalSalePrice, bo.getTotalSalePrice());
        lqw.eq(bo.getTotalBasePrice() != null, OrdOrder::getTotalBasePrice, bo.getTotalBasePrice());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderStatus()), OrdOrder::getOrderStatus, bo.getOrderStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getMerchantCode()), OrdOrder::getMerchantCode, bo.getMerchantCode());
        lqw.eq(bo.getCreateTime() != null, OrdOrder::getCreateTime, bo.getCreateTime());
        lqw.eq(bo.getUpdateBy() != null, OrdOrder::getUpdateBy, bo.getUpdateBy());
        lqw.eq(bo.getUpdateTime() != null, OrdOrder::getUpdateTime, bo.getUpdateTime());
        return lqw;
    }

    /**
     * 新增订单
     */
    @Override
    public Boolean insertByBo(OrdOrderBo bo) {
        OrdOrder add = MapstructUtils.convert(bo, OrdOrder.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setOrderId(add.getOrderId());
        }
        return flag;
    }

    /**
     * 修改订单
     */
    @Override
    public Boolean updateByBo(OrdOrderBo bo) {
        OrdOrder update = MapstructUtils.convert(bo, OrdOrder.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(OrdOrder entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除订单
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
