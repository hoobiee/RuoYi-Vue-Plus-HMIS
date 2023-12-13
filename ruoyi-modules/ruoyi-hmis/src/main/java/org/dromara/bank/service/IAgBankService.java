package org.dromara.bank.service;

import org.dromara.bank.domain.AgBank;
import org.dromara.bank.domain.vo.AgBankVo;
import org.dromara.bank.domain.bo.AgBankBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 分销商银行卡Service接口
 *
 * @author HMIS
 * @date 2023-12-11
 */
public interface IAgBankService {

    /**
     * 查询分销商银行卡
     */
    AgBankVo queryById(Long cardId);

    /**
     * 查询分销商银行卡列表
     */
    TableDataInfo<AgBankVo> queryPageList(AgBankBo bo, PageQuery pageQuery);

    /**
     * 查询分销商银行卡列表
     */
    List<AgBankVo> queryList(AgBankBo bo);

    /**
     * 新增分销商银行卡
     */
    Boolean insertByBo(AgBankBo bo);

    /**
     * 修改分销商银行卡
     */
    Boolean updateByBo(AgBankBo bo);

    /**
     * 校验并批量删除分销商银行卡信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
