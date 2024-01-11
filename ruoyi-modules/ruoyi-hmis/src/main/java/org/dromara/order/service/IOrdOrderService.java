package org.dromara.order.service;


import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.order.domain.bo.OrdOrderBo;
import org.dromara.order.domain.vo.OrdOrderVo;

import java.util.Collection;
import java.util.List;

/**
 * 订单Service接口
 *
 * @author hmis
 * @date 2023-12-11
 */
public interface IOrdOrderService {

    /**
     * 查询订单
     */
    OrdOrderVo queryById(Long orderId);

    /**
     * 查询订单列表
     */
    TableDataInfo<OrdOrderVo> queryPageList(OrdOrderBo bo, PageQuery pageQuery);

    TableDataInfo<OrdOrderVo> queryBasePageList(OrdOrderBo bo, PageQuery pageQuery);

    /**
     * 查询订单列表
     */
    List<OrdOrderVo> queryList(OrdOrderBo bo);

    /**
     * 新增订单
     */
    Boolean insertByBo(OrdOrderBo bo);

    /**
     * 修改订单
     */
    Boolean updateByBo(OrdOrderBo bo);

    /**
     * 校验并批量删除订单信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
