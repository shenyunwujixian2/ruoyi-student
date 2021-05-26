package com.ruoyi.utilswx;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 企业微信token信息
 *
 * @author yujianyou
 * @email 597907730@qq.com
 * @date 2020-06-22 09:12:39
 */
@Service
@AllArgsConstructor
public class EntWxTokenBizImpl implements EntWxTokenBiz {

//    private final EntWxTokenDao entWxTokenDao;
//
//    /**
//     * 条件查询分页
//     *
//     * @param entWxTokenQueryCriteria 查询、分页条件
//     * @return 信息列表
//     */
//    @Override
//    public List<EntWxTokenEntity> queryList(EntWxTokenQueryCriteria entWxTokenQueryCriteria) {
//        entWxTokenQueryCriteria.setOffset((entWxTokenQueryCriteria.getCurrentPage() - 1) * entWxTokenQueryCriteria.getSize());
//        entWxTokenQueryCriteria.setLimit(entWxTokenQueryCriteria.getSize());
//        return entWxTokenDao.queryList(entWxTokenQueryCriteria);
//    }
//
//    /**
//     * 条件查询总记录数
//     *
//     * @param entWxTokenQueryCriteria 查询、分页条件
//     * @return 总记录数
//     */
//    @Override
//    public int count(EntWxTokenQueryCriteria entWxTokenQueryCriteria) {
//        return entWxTokenDao.queryListCount(entWxTokenQueryCriteria);
//    }
//
//    /**
//     * 根据主键获取实体信息
//     *
//     * @param id 主键
//     * @return 详细信息
//     */
//    @Override
//    public EntWxTokenEntity queryInfo(Long id) {
//        return entWxTokenDao.queryInfo(id);
//    }
//
//    /**
//     * 新增
//     *
//     * @param entWxTokenEntity 入参
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void save(EntWxTokenEntity entWxTokenEntity) {
//        entWxTokenDao.saveEntity(entWxTokenEntity);
//    }
//
//    /**
//     * 编辑
//     *
//     * @param entWxTokenEntity 入参
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void update(EntWxTokenEntity entWxTokenEntity) {
//        entWxTokenDao.updateEntity(entWxTokenEntity);
//    }
//
//    /**
//     * 逻辑删除
//     *
//     * @param ids 业务主键数组
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void deleteBath(Long[] ids) {
//        entWxTokenDao.deleteBatch(ids);
//    }
//
//    /**
//     * 获取token
//     *
//     * @return
//     */
//    @Override
//    public EntWxTokenEntity getToken() {
//        return entWxTokenDao.getToken();
//    }

}
