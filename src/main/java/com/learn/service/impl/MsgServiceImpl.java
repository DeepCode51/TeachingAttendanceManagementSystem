package com.learn.service.impl;

import com.learn.dao.MsgDao;
import com.learn.entity.MsgEntity;
import com.learn.entity.SysUserEntity;
import com.learn.service.MsgService;
import com.learn.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("msgService")
public class MsgServiceImpl implements MsgService {
    @Autowired
    private MsgDao msgDao;

    @Autowired
    private SysUserService sysUserService;


    @Override
    public MsgEntity queryObject(Long id) {
        MsgEntity entity = msgDao.queryObject(id);

        if (this.sysUserService.queryObject(entity.getUser()) != null)
            entity.setSysUserEntity(this.sysUserService.queryObject(entity.getUser()));

        return entity;
    }

    @Override
    public List<MsgEntity> queryList(Map<String, Object> map) {
        List<MsgEntity> list = msgDao.queryList(map);
        for (MsgEntity entity : list) {
            if (this.sysUserService.queryObject(entity.getUser()) != null)
                entity.setSysUserEntity(this.sysUserService.queryObject(entity.getUser()));
        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return msgDao.queryTotal(map);
    }

    @Override
    public void save(MsgEntity msg) {
        if (msg.getUser() == null) {
            List<SysUserEntity> userList = sysUserService.queryList(new HashMap<String, Object>());

            for (SysUserEntity entity : userList) {
                MsgEntity entity1 = new MsgEntity();
                entity1.setContent(msg.getContent());
                entity1.setUser(entity.getUserId());
                entity1.setState("未读");
                this.msgDao.save(entity1);
            }
        } else {
            msg.setState("未读");
            msgDao.save(msg);
        }

    }

    @Override
    public void update(MsgEntity msg) {
        msgDao.update(msg);
    }

    @Override
    public void delete(Long id) {
        msgDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        msgDao.deleteBatch(ids);
    }

}
