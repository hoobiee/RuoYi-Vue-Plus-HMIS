package org.dromara.order.mapper;

import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;
import org.dromara.order.domain.OrdRemark;
import org.dromara.order.domain.vo.OrdRemarkVo;

/**
 * 订单备注Mapper接口
 *
 * @author hmis
 * @date 2023-12-13
 */
public interface OrdRemarkMapper extends BaseMapperPlus<OrdRemark, OrdRemarkVo> {

    OrdRemark selectOrdRemarkVoByOrderId(Long orderId);
}
