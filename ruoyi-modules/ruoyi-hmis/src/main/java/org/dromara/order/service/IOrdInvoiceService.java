package org.dromara.order.service;

import org.dromara.order.domain.vo.OrdInvoiceVo;
import org.dromara.order.domain.bo.OrdInvoiceBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 订单客人发票信息Service接口
 *
 * @author Lion Li
 * @date 2023-12-13
 */
public interface IOrdInvoiceService {

    /**
     * 查询订单客人发票信息
     */
    OrdInvoiceVo queryById(String invoiceType);

    /**
     * 查询订单客人发票信息列表
     */
    TableDataInfo<OrdInvoiceVo> queryPageList(OrdInvoiceBo bo, PageQuery pageQuery);

    /**
     * 查询订单客人发票信息列表
     */
    List<OrdInvoiceVo> queryList(OrdInvoiceBo bo);

    /**
     * 新增订单客人发票信息
     */
    Boolean insertByBo(OrdInvoiceBo bo);

    /**
     * 修改订单客人发票信息
     */
    Boolean updateByBo(OrdInvoiceBo bo);

    /**
     * 校验并批量删除订单客人发票信息信息
     */
    Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid);
}
