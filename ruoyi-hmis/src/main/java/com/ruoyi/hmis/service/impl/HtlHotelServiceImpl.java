package com.ruoyi.hmis.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ruoyi.hmis.domain.bo.HtlHotelBo;
import com.ruoyi.hmis.domain.vo.HtlHotelVo;
import com.ruoyi.hmis.domain.HtlHotel;
import com.ruoyi.hmis.mapper.HtlHotelMapper;
import com.ruoyi.hmis.service.IHtlHotelService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 酒店详情列Service业务层处理
 *
 * @author ruoyi
 * @date 2023-08-06
 */
@RequiredArgsConstructor
@Service
public class HtlHotelServiceImpl implements IHtlHotelService {

    private final HtlHotelMapper baseMapper;

    /**
     * 查询酒店详情列
     */
    @Override
    public HtlHotelVo queryById(Long hotelId){
        return baseMapper.selectVoById(hotelId);
    }

    /**
     * 查询酒店详情列列表
     */
    @Override
    public TableDataInfo<HtlHotelVo> queryPageList(HtlHotelBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<HtlHotel> lqw = buildQueryWrapper(bo);
        Page<HtlHotelVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询酒店详情列列表
     */
    @Override
    public List<HtlHotelVo> queryList(HtlHotelBo bo) {
        LambdaQueryWrapper<HtlHotel> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<HtlHotel> buildQueryWrapper(HtlHotelBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<HtlHotel> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getHotelName()), HtlHotel::getHotelName, bo.getHotelName());
        lqw.eq(StringUtils.isNotBlank(bo.getHotelNameEn()), HtlHotel::getHotelNameEn, bo.getHotelNameEn());
        lqw.like(StringUtils.isNotBlank(bo.getCityName()), HtlHotel::getCityName, bo.getCityName());
        lqw.eq(bo.getStar() != null, HtlHotel::getStar, bo.getStar());
        lqw.eq(StringUtils.isNotBlank(bo.getHotelPhone()), HtlHotel::getHotelPhone, bo.getHotelPhone());
        lqw.eq(bo.getOpeningTime() != null, HtlHotel::getOpeningTime, bo.getOpeningTime());
        lqw.eq(bo.getDecorateTime() != null, HtlHotel::getDecorateTime, bo.getDecorateTime());
        lqw.eq(StringUtils.isNotBlank(bo.getIntroduction()), HtlHotel::getIntroduction, bo.getIntroduction());
        lqw.eq(StringUtils.isNotBlank(bo.getCanclePolicy()), HtlHotel::getCanclePolicy, bo.getCanclePolicy());
        lqw.eq(StringUtils.isNotBlank(bo.getCreditCards()), HtlHotel::getCreditCards, bo.getCreditCards());
        lqw.eq(StringUtils.isNotBlank(bo.getFacilities()), HtlHotel::getFacilities, bo.getFacilities());
        lqw.eq(StringUtils.isNotBlank(bo.getAddress()), HtlHotel::getAddress, bo.getAddress());
        lqw.eq(StringUtils.isNotBlank(bo.getAddressEn()), HtlHotel::getAddressEn, bo.getAddressEn());
        lqw.eq(StringUtils.isNotBlank(bo.getCreator()), HtlHotel::getCreator, bo.getCreator());
        lqw.eq(StringUtils.isNotBlank(bo.getModifier()), HtlHotel::getModifier, bo.getModifier());
        lqw.eq(bo.getModifyTime() != null, HtlHotel::getModifyTime, bo.getModifyTime());
        lqw.eq(StringUtils.isNotBlank(bo.getGaodeLat()), HtlHotel::getGaodeLat, bo.getGaodeLat());
        lqw.eq(StringUtils.isNotBlank(bo.getGaodeLon()), HtlHotel::getGaodeLon, bo.getGaodeLon());
        lqw.eq(StringUtils.isNotBlank(bo.getGoogleLat()), HtlHotel::getGoogleLat, bo.getGoogleLat());
        lqw.eq(StringUtils.isNotBlank(bo.getGoogleLon()), HtlHotel::getGoogleLon, bo.getGoogleLon());
        lqw.eq(StringUtils.isNotBlank(bo.getBaiduLat()), HtlHotel::getBaiduLat, bo.getBaiduLat());
        lqw.eq(StringUtils.isNotBlank(bo.getBaiduLon()), HtlHotel::getBaiduLon, bo.getBaiduLon());
        lqw.eq(bo.getDestinationLable() != null, HtlHotel::getDestinationLable, bo.getDestinationLable());
        return lqw;
    }

    /**
     * 新增酒店详情列
     */
    @Override
    public Boolean insertByBo(HtlHotelBo bo) {
        HtlHotel add = BeanUtil.toBean(bo, HtlHotel.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setHotelId(add.getHotelId());
        }
        return flag;
    }

    /**
     * 修改酒店详情列
     */
    @Override
    public Boolean updateByBo(HtlHotelBo bo) {
        HtlHotel update = BeanUtil.toBean(bo, HtlHotel.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(HtlHotel entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除酒店详情列
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
