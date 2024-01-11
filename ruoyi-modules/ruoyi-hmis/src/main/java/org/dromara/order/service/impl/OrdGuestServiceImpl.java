package org.dromara.order.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.dromara.order.domain.OrdGuest;
import org.dromara.order.domain.vo.OrdGuestVo;
import org.dromara.order.mapper.OrdGuestMapper;
import org.springframework.stereotype.Service;
import org.dromara.order.domain.bo.OrdGuestBo;
import org.dromara.order.service.IOrdGuestService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 订单客人Service业务层处理
 *
 * @author hmis
 * @date 2023-12-13
 */
@RequiredArgsConstructor
@Service
public class OrdGuestServiceImpl implements IOrdGuestService {

    private final OrdGuestMapper baseMapper;

    /**
     * 查询订单客人
     */
    @Override
    public OrdGuestVo queryById(Long guestId){
        return baseMapper.selectVoById(guestId);
    }

    /**
     * 根据订单号查询订单客人
     */
    @Override
    public OrdGuestVo queryByOrderId(String orderId){
        LambdaQueryWrapper<OrdGuest> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(orderId), OrdGuest::getOrderId, orderId);
        return baseMapper.selectVoOne(lqw);
    }

    /**
     * 查询订单客人列表
     */
    @Override
    public TableDataInfo<OrdGuestVo> queryPageList(OrdGuestBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<OrdGuest> lqw    = buildQueryWrapper(bo);
        Page<OrdGuestVo>             result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询订单客人列表
     */
    @Override
    public List<OrdGuestVo> queryList(OrdGuestBo bo) {
        LambdaQueryWrapper<OrdGuest> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<OrdGuest> buildQueryWrapper(OrdGuestBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<OrdGuest> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getGuestId() != null, OrdGuest::getGuestId, bo.getGuestId());
        lqw.like(StringUtils.isNotBlank(bo.getLastName()), OrdGuest::getLastName, bo.getLastName());
        lqw.like(StringUtils.isNotBlank(bo.getFirstName()), OrdGuest::getFirstName, bo.getFirstName());
        lqw.like(StringUtils.isNotBlank(bo.getName()), OrdGuest::getName, bo.getName());
        lqw.eq(bo.getOrderId() != null, OrdGuest::getOrderId, bo.getOrderId());
        return lqw;
    }

    /**
     * 新增订单客人
     */
    @Override
    public Boolean insertByBo(OrdGuestBo bo) {
        OrdGuest add = MapstructUtils.convert(bo, OrdGuest.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setGuestId(add.getGuestId());
        }
        return flag;
    }

    /**
     * 修改订单客人
     */
    @Override
    public Boolean updateByBo(OrdGuestBo bo) {
        OrdGuest update = MapstructUtils.convert(bo, OrdGuest.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(OrdGuest entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除订单客人
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
