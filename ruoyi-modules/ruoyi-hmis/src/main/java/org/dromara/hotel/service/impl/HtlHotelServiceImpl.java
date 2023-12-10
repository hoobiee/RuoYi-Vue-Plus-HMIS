package org.dromara.hotel.service.impl;

import cn.hutool.core.lang.PatternPool;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.domain.model.LoginUser;
import org.dromara.common.core.service.UserService;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.satoken.utils.LoginHelper;
import org.dromara.hotel.domain.HtlHotel;
import org.dromara.hotel.domain.bo.HtlHotelBo;
import org.dromara.hotel.domain.vo.HtlHotelVo;
import org.dromara.hotel.mapper.HtlHotelMapper;
import org.dromara.hotel.service.IHtlHotelService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 酒店详情Service业务层处理
 *
 * @author hmis
 * @date 2023-12-07
 */
@RequiredArgsConstructor
@Service
public class HtlHotelServiceImpl implements IHtlHotelService {

    private final HtlHotelMapper baseMapper;

    private final UserService userService;

    /**
     * 查询酒店详情
     */
    @Override
    public HtlHotelVo queryById(Long hotelId){
        return baseMapper.selectVoById(hotelId);
    }

    /**
     * 查询酒店详情列表
     */
    @Override
    public TableDataInfo<HtlHotelVo> queryPageList(HtlHotelBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<HtlHotel> lqw    = buildQueryWrapper(bo);
        Page<HtlHotelVo>             result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        convertUserName(result.getRecords());
        return TableDataInfo.build(result);
    }

    /**
     * 转换用户名
     * @param records
     */
    private void convertUserName(List<HtlHotelVo> records) {
        records.forEach(hotel -> {
            hotel.setCreateBy(userService.selectUserNameById(Long.valueOf(hotel.getCreateBy())));
            hotel.setUpdateBy(userService.selectUserNameById(Long.valueOf(hotel.getUpdateBy())));
        });
    }

    /**
     * 查询酒店详情列表
     */
    @Override
    public List<HtlHotelVo> queryList(HtlHotelBo bo) {
        LambdaQueryWrapper<HtlHotel> lqw = buildQueryWrapper(bo);
        List<HtlHotelVo>             htlHotelVos = baseMapper.selectVoList(lqw);
        convertUserName(htlHotelVos);
        return htlHotelVos;
    }

    private LambdaQueryWrapper<HtlHotel> buildQueryWrapper(HtlHotelBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<HtlHotel> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getHotelName()), HtlHotel::getHotelName, bo.getHotelName());
        lqw.like(StringUtils.isNotBlank(bo.getHotelNameEn()), HtlHotel::getHotelNameEn, bo.getHotelNameEn());
        lqw.like(StringUtils.isNotBlank(bo.getCityName()), HtlHotel::getCityName, bo.getCityName());
        lqw.eq(bo.getStar() != null, HtlHotel::getStar, bo.getStar());
        lqw.eq(StringUtils.isNotBlank(bo.getHotelPhone()), HtlHotel::getHotelPhone, bo.getHotelPhone());
        lqw.between(params.get("beginOpeningTime") != null && params.get("endOpeningTime") != null,
            HtlHotel::getOpeningTime ,params.get("beginOpeningTime"), params.get("endOpeningTime"));
        lqw.between(params.get("beginDecorateTime") != null && params.get("endDecorateTime") != null,
            HtlHotel::getDecorateTime ,params.get("beginDecorateTime"), params.get("endDecorateTime"));
        lqw.eq(StringUtils.isNotBlank(bo.getIntroduction()), HtlHotel::getIntroduction, bo.getIntroduction());
        lqw.eq(StringUtils.isNotBlank(bo.getCanclePolicy()), HtlHotel::getCanclePolicy, bo.getCanclePolicy());
        lqw.eq(StringUtils.isNotBlank(bo.getCreditCards()), HtlHotel::getCreditCards, bo.getCreditCards());
        lqw.eq(StringUtils.isNotBlank(bo.getFacilities()), HtlHotel::getFacilities, bo.getFacilities());
        lqw.eq(StringUtils.isNotBlank(bo.getAddress()), HtlHotel::getAddress, bo.getAddress());
        lqw.eq(StringUtils.isNotBlank(bo.getAddressEn()), HtlHotel::getAddressEn, bo.getAddressEn());
        lqw.eq(StringUtils.isNotBlank(bo.getGaodeLat()), HtlHotel::getGaodeLat, bo.getGaodeLat());
        lqw.eq(StringUtils.isNotBlank(bo.getGaodeLon()), HtlHotel::getGaodeLon, bo.getGaodeLon());
        lqw.like(bo.getCreateBy() != null, HtlHotel::getCreateBy, bo.getCreateBy());
        lqw.between(params.get("beginCreateTime") != null && params.get("endCreateTime") != null,
            HtlHotel::getCreateTime ,params.get("beginCreateTime"), params.get("endCreateTime"));
        lqw.like(bo.getUpdateBy() != null, HtlHotel::getUpdateBy, bo.getUpdateBy());
        lqw.between(params.get("beginUpdateTime") != null && params.get("endUpdateTime") != null,
            HtlHotel::getUpdateTime ,params.get("beginUpdateTime"), params.get("endUpdateTime"));
        lqw.eq(StringUtils.isNotBlank(bo.getGoogleLat()), HtlHotel::getGoogleLat, bo.getGoogleLat());
        lqw.eq(StringUtils.isNotBlank(bo.getGoogleLon()), HtlHotel::getGoogleLon, bo.getGoogleLon());
        lqw.eq(StringUtils.isNotBlank(bo.getBaiduLat()), HtlHotel::getBaiduLat, bo.getBaiduLat());
        lqw.eq(StringUtils.isNotBlank(bo.getBaiduLon()), HtlHotel::getBaiduLon, bo.getBaiduLon());
        lqw.eq(bo.getDestinationLabel() != null, HtlHotel::getDestinationLabel, bo.getDestinationLabel());
        return lqw;
    }

    /**
     * 新增酒店详情
     */
    @Override
    public Boolean insertByBo(HtlHotelBo bo) {
        HtlHotel add = MapstructUtils.convert(bo, HtlHotel.class);
        validEntityBeforeSave(add);
        LoginUser loginUser = LoginHelper.getLoginUser();
        Long             userId    = loginUser.getUserId();
        bo.setCreateBy(userId);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setHotelId(add.getHotelId());
        }
        return flag;
    }

    /**
     * 修改酒店详情
     */
    @Override
    public Boolean updateByBo(HtlHotelBo bo) {
        HtlHotel update = MapstructUtils.convert(bo, HtlHotel.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(HtlHotel entity){
        //TODO 做一些数据校验,如唯一约束
        //正则校验手机
        if (StringUtils.isBlank(entity.getHotelPhone())) {
            throw new IllegalArgumentException("手机号不能为空");
        }
        Pattern mobile = PatternPool.MOBILE;
        if(!mobile.matcher(entity.getHotelPhone()).matches()){
            throw new IllegalArgumentException("手机号格式不正确");
        }
        // 地址校验
        if (StringUtils.isBlank(entity.getAddress())) {
            throw new IllegalArgumentException("地址不能为空");
        }
        // 酒店名称
        if (StringUtils.isBlank(entity.getHotelName())) {
            throw new IllegalArgumentException("酒店名称不能为空");
        }
    }

    /**
     * 批量删除酒店详情
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
