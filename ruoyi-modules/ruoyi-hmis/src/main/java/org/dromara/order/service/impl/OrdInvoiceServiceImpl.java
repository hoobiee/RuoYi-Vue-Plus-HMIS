package org.dromara.order.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.dromara.order.domain.OrdInvoice;
import org.dromara.order.domain.bo.OrdInvoiceBo;
import org.dromara.order.domain.vo.OrdInvoiceVo;
import org.dromara.order.mapper.OrdInvoiceMapper;
import org.dromara.order.service.IOrdInvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 订单客人发票信息Service业务层处理
 *
 * @author Lion Li
 * @date 2023-12-13
 */
@RequiredArgsConstructor
@Service
public class OrdInvoiceServiceImpl implements IOrdInvoiceService {

    private final OrdInvoiceMapper baseMapper;

    /**
     * 查询订单客人发票信息
     */
    @Override
    public OrdInvoiceVo queryById(String invoiceType){
        return baseMapper.selectVoById(invoiceType);
    }

    /**
     * 查询订单客人发票信息列表
     */
    @Override
    public TableDataInfo<OrdInvoiceVo> queryPageList(OrdInvoiceBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<OrdInvoice> lqw    = buildQueryWrapper(bo);
        Page<OrdInvoiceVo>             result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询订单客人发票信息列表
     */
    @Override
    public List<OrdInvoiceVo> queryList(OrdInvoiceBo bo) {
        LambdaQueryWrapper<OrdInvoice> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<OrdInvoice> buildQueryWrapper(OrdInvoiceBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<OrdInvoice> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getInvoiceType()), OrdInvoice::getInvoiceType, bo.getInvoiceType());
        lqw.eq(StringUtils.isNotBlank(bo.getInvoiceTitleType()), OrdInvoice::getInvoiceTitleType, bo.getInvoiceTitleType());
        lqw.eq(StringUtils.isNotBlank(bo.getTitle()), OrdInvoice::getTitle, bo.getTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getTaxpayerNumber()), OrdInvoice::getTaxpayerNumber, bo.getTaxpayerNumber());
        lqw.eq(StringUtils.isNotBlank(bo.getBody()), OrdInvoice::getBody, bo.getBody());
        lqw.eq(StringUtils.isNotBlank(bo.getInvoiceAmount()), OrdInvoice::getInvoiceAmount, bo.getInvoiceAmount());
        lqw.eq(StringUtils.isNotBlank(bo.getEmail()), OrdInvoice::getEmail, bo.getEmail());
        lqw.eq(StringUtils.isNotBlank(bo.getAddress()), OrdInvoice::getAddress, bo.getAddress());
        lqw.eq(bo.getInvoiceStatus() != null, OrdInvoice::getInvoiceStatus, bo.getInvoiceStatus());
        return lqw;
    }

    /**
     * 新增订单客人发票信息
     */
    @Override
    public Boolean insertByBo(OrdInvoiceBo bo) {
        OrdInvoice add = MapstructUtils.convert(bo, OrdInvoice.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setInvoiceType(add.getInvoiceType());
        }
        return flag;
    }

    /**
     * 修改订单客人发票信息
     */
    @Override
    public Boolean updateByBo(OrdInvoiceBo bo) {
        OrdInvoice update = MapstructUtils.convert(bo, OrdInvoice.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(OrdInvoice entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除订单客人发票信息
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
