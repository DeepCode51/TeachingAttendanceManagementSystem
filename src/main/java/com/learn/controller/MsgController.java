package com.learn.controller;

import com.learn.entity.MsgEntity;
import com.learn.service.MsgService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 站内消息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-13 14:31:20
 */
@RestController
@RequestMapping("msg")
public class MsgController extends AbstractController {
    @Autowired
    private MsgService msgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {

        if (super.getUserId() > 1)
            params.put("user", super.getUserId());


        //查询列表数据
        Query query = new Query(params);

        List<MsgEntity> msgList = msgService.queryList(query);
        int total = msgService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(msgList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 列表
     */
    @RequestMapping("/list2")
    public R list2(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<MsgEntity> msgList = msgService.queryList(query);
        return R.ok().put("list", msgList);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        MsgEntity msg = msgService.queryObject(id);

        return R.ok().put("msg", msg);
    }

    /**
     * 信息
     */
    @RequestMapping("/info2/{id}")
    public R info2(@PathVariable("id") Long id) {
        MsgEntity msg = msgService.queryObject(id);
        msg.setState("已读");
        this.msgService.update(msg);
        return R.ok().put("msg", msg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MsgEntity msg) {

        msgService.save(msg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MsgEntity msg) {
        msgService.update(msg);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        msgService.deleteBatch(ids);
        return R.ok();
    }

}
