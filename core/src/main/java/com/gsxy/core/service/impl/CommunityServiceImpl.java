package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.CommunityMapper;
import com.gsxy.core.pojo.Community;
import com.gsxy.core.pojo.bo.CommunityAddBo;
import com.gsxy.core.pojo.bo.CommunityDeleteByIdBo;
import com.gsxy.core.pojo.bo.CommunitySelectByIdBo;
import com.gsxy.core.pojo.bo.CommunityUpdateByIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.CommunityService;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhuxinyu 2023-10-24
 *    社团业务实体类接口
 */
@Service
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    private CommunityMapper communityMapper;

    /**
     * @author zhuxinyu 2023-10-24
     *      添加社团
     * @param communityAddByIdBo
     * @return
     */
    @Override
    public ResponseVo addCommunity(CommunityAddBo communityAddByIdBo) {
        String orgIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long orgId = Long.valueOf(orgIdOfStr);
        Long aLong = communityMapper.addcommunity(communityAddByIdBo.getCommunity());
        if (aLong.longValue() == 0L) {
            return new ResponseVo("增加失败",  null, "0x500");
        }

        return new ResponseVo("增加成功", null, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-24
     *      通过id删除社团数据
     * @param communityDeleteByIdBo
     * @return
     */
    @Override
    public ResponseVo deleteByIdCommunity(CommunityDeleteByIdBo communityDeleteByIdBo) {
        Long id = communityDeleteByIdBo.getId();
        Long aLong = communityMapper.deleteByIdcommunity(id);

        if (aLong.longValue() != 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",id, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-24
     *      通过id查找社团数据
     * @param communitySelectByIdBo
     * @return
     */
    @Override
    public ResponseVo selectByIdCommunity(CommunitySelectByIdBo communitySelectByIdBo) {
        Community community = communityMapper.selectByIdcommunity(communitySelectByIdBo.getId());

        if (community == null) {
            return new ResponseVo("查询的数据不存在,", null, "0x500");
        }

        return new ResponseVo("查询成功",community,"0x200");
    }

    /**
     * @author zhuxinyu 2023-10-24
     *      通过id更新社团数据
     * @param communityUpdateByIdBo
     * @return
     */
    @Override
    public ResponseVo updateByIdCommunity(CommunityUpdateByIdBo communityUpdateByIdBo) {
        String orgIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long orgId = Long.valueOf(orgIdOfStr);
        Community community = communityUpdateByIdBo.getCommunity();
        Long aLong = communityMapper.updateByIdcommunity(community);
        if (aLong.longValue() == 0L) {
            return new ResponseVo("更新失败", null, "0x500");
        }
        return new ResponseVo("更新成功", community.getId(), "0x200");
    }

}
