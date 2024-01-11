package org.dromara.test;

import org.dromara.order.domain.OrdOrder;
import org.dromara.order.mapper.OrdOrderMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
// 此注解只能在 springboot 主包下使用 需包含 main 方法与 yml 配置文件
@SpringBootTest
// 使用dev 环境配置文件
@ActiveProfiles("dev")
@DisplayName("单元测试案例")
public class OrdOrderMapperTest {

    @Autowired
    private OrdOrderMapper ordOrderMapper;

    @Test
    @DisplayName("Should return list of OrdOrderVo when valid orderIds are provided")
    public void shouldReturnListOfOrdOrderVoWhenValidOrderIdsAreProvided() {
        List<Long> orderIds = Arrays.asList(1L, 2L, 3L);
        // when(ordOrderMapper.selectOrdOrderVoByOrderNos(orderIds)).thenReturn(Arrays.asList(ordOrderVo, ordOrderVo, ordOrderVo));

        List<OrdOrder> result = ordOrderMapper.selectOrdOrderVoByOrderNos(orderIds);

        assertEquals(3, result.size());
        verify(ordOrderMapper, times(1)).selectOrdOrderVoByOrderNos(orderIds);
    }

    @Test
    @DisplayName("Should return empty list when no orderIds are provided")
    public void shouldReturnEmptyListWhenNoOrderIdsAreProvided() {
        List<Long> orderIds = Arrays.asList();
        when(ordOrderMapper.selectOrdOrderVoByOrderNos(orderIds)).thenReturn(Arrays.asList());

        List<OrdOrder> result = ordOrderMapper.selectOrdOrderVoByOrderNos(orderIds);

        assertEquals(0, result.size());
        verify(ordOrderMapper, times(1)).selectOrdOrderVoByOrderNos(orderIds);
    }
}
