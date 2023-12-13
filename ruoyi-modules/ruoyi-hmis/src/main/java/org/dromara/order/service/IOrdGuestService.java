package org.dromara.order.service;

import org.dromara.order.domain.vo.OrdGuestVo;
import org.dromara.order.domain.bo.OrdGuestBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 订单客人Service接口
 *
 * @author hmis
 * @date 2023-12-13
 */
public interface IOrdGuestService {

    /**
     * 查询订单客人
     */
    OrdGuestVo queryById(Long guestId);

    /**
     * 查询订单客人列表
     */
    TableDataInfo<OrdGuestVo> queryPageList(OrdGuestBo bo, PageQuery pageQuery);

    /**
     * 查询订单客人列表
     */
    List<OrdGuestVo> queryList(OrdGuestBo bo);

    /**
     * 新增订单客人
     */
    Boolean insertByBo(OrdGuestBo bo);

    /**
     * 修改订单客人
     */
    Boolean updateByBo(OrdGuestBo bo);

    /**
     * 校验并批量删除订单客人信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
