package org.dromara.order.mapper;

import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;
import org.dromara.order.domain.OrdGuest;
import org.dromara.order.domain.vo.OrdGuestVo;

/**
 * 订单客人Mapper接口
 *
 * @author hmis
 * @date 2023-12-13
 */
public interface OrdGuestMapper extends BaseMapperPlus<OrdGuest, OrdGuestVo> {

    OrdGuest selectOrdGuestVoByOrderId(Long orderId);

}
