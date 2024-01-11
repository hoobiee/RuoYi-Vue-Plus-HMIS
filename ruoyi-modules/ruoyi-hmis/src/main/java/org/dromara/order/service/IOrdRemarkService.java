package org.dromara.order.service;

import org.dromara.order.domain.vo.OrdRemarkVo;
import org.dromara.order.domain.bo.OrdRemarkBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 订单备注Service接口
 *
 * @author hmis
 * @date 2023-12-13
 */
public interface IOrdRemarkService {

    /**
     * 查询订单备注
     */
    OrdRemarkVo queryById(Long remarkId);

    /**
     * 根据订单号查询订单备注
     */
    OrdRemarkVo queryByOrderId(String orderId);

    /**
     * 查询订单备注列表
     */
    TableDataInfo<OrdRemarkVo> queryPageList(OrdRemarkBo bo, PageQuery pageQuery);

    /**
     * 查询订单备注列表
     */
    List<OrdRemarkVo> queryList(OrdRemarkBo bo);

    /**
     * 新增订单备注
     */
    Boolean insertByBo(OrdRemarkBo bo);

    /**
     * 修改订单备注
     */
    Boolean updateByBo(OrdRemarkBo bo);

    /**
     * 校验并批量删除订单备注信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
