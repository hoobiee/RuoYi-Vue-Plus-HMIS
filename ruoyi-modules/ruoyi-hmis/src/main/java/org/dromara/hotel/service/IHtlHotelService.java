package org.dromara.hotel.service;

import org.dromara.hotel.domain.vo.HtlHotelVo;
import org.dromara.hotel.domain.bo.HtlHotelBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 酒店详情Service接口
 *
 * @author hmis
 * @date 2023-12-07
 */
public interface IHtlHotelService {

    /**
     * 查询酒店详情
     */
    HtlHotelVo queryById(Long hotelId);

    /**
     * 查询酒店详情列表
     */
    TableDataInfo<HtlHotelVo> queryPageList(HtlHotelBo bo, PageQuery pageQuery);

    /**
     * 查询酒店详情列表
     */
    List<HtlHotelVo> queryList(HtlHotelBo bo);

    /**
     * 新增酒店详情
     */
    Boolean insertByBo(HtlHotelBo bo);

    /**
     * 修改酒店详情
     */
    Boolean updateByBo(HtlHotelBo bo);

    /**
     * 校验并批量删除酒店详情信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
