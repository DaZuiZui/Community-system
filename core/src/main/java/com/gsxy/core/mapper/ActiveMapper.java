package com.gsxy.core.mapper;

import com.gsxy.core.pojo.Active;
import com.gsxy.core.pojo.bo.ActivePagingQueryByTitleBo;
import com.gsxy.core.pojo.bo.ActiveSelectByIdBo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActiveMapper {

    /**
     * @auhtor hln 2023-10-24
     *      添加活动功能
     * @param active
     * @return
     */
    Long addActive(Active active);

    /**
     * @author hln 2023-10-25
     *      查询所有活动功能
     * @return
     */
    List<Active> findAll();

    /**
     * @author hln 2023-10-26
     *      根据id删除活动
     * @param id
     * @return
     */
    Long deleteActiveById(Long id);

    /**
     * @author hln 2023-10-26
     *      根据id查询活动
     * @param activeSelectByIdBo
     * @return
     */
    Long selectActiveById(ActiveSelectByIdBo activeSelectByIdBo);

    /**
     * @author hln 2023-10-26
     *      根据id修改活动
     * @param active
     * @return
     */
    Long updateActiveById(Active active);

    /**
     * @author hln 2023-10-27
     *      根据title进行模糊查询
     * @param title
     * @return
     */
    List<Active> pagingQueryByTitleBo(String title);
}
