package com.ruoyi.hmis.service;

import com.ruoyi.hmis.domain.HtlHotel;
import com.ruoyi.hmis.domain.vo.HtlHotelVo;
import com.ruoyi.hmis.domain.bo.HtlHotelBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 酒店详情列Service接口
 *
 * @author ruoyi
 * @date 2023-08-06
 */
public interface IHtlHotelService {

    /**
     * 查询酒店详情列
     */
    HtlHotelVo queryById(Long hotelId);

    /**
     * 查询酒店详情列列表
     */
    TableDataInfo<HtlHotelVo> queryPageList(HtlHotelBo bo, PageQuery pageQuery);

    /**
     * 查询酒店详情列列表
     */
    List<HtlHotelVo> queryList(HtlHotelBo bo);

    /**
     * 新增酒店详情列
     */
    Boolean insertByBo(HtlHotelBo bo);

    /**
     * 修改酒店详情列
     */
    Boolean updateByBo(HtlHotelBo bo);

    /**
     * 校验并批量删除酒店详情列信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
