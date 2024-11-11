package com.learn.service;

import com.learn.entity.MsgEntity;

import java.util.List;
import java.util.Map;

/**
 * 站内消息
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-13 14:31:20
 */
public interface MsgService {
    /**
    * 查询
	* @return
	*/
	MsgEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<MsgEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(MsgEntity msg);

    /**
    * 修改
    * @return
    */
	void update(MsgEntity msg);

    /**
    * 删除
    * @return
    */
	void delete(Long id);

    /**
    * 批量删除
    * @return
    */
	void deleteBatch(Long[] ids);
}
