package org.dromara.order.mapper;


import org.apache.ibatis.annotations.Param;
import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;
import org.dromara.order.domain.OrdOrder;
import org.dromara.order.domain.vo.OrdOrderVo;

import java.util.List;

/**
 * 订单Mapper接口
 *
 * @author hmis
 * @date 2023-12-11
 */
public interface OrdOrderMapper extends BaseMapperPlus<OrdOrder, OrdOrderVo> {

    OrdOrder selectOrdOrderVoByOrderId(Long orderId);

    List<OrdOrder> selectOrdOrderVoByOrderNos(@Param("orderNos")List<Long> orderNos);
}
