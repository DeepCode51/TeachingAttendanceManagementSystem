package com.learn.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.RecordEntity;
import com.learn.service.RecordService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;


/**
 * 考勤信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-18 23:10:05
 */
@RestController
@RequestMapping("record")
public class RecordController extends AbstractController {
    @Autowired
    private RecordService recordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {

        if (super.getUserId() > 1)
            params.put("user", super.getUserId());


        //查询列表数据
        Query query = new Query(params);

        List<RecordEntity> recordList = recordService.queryList(query);
        int total = recordService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(recordList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 列表
     */
    @RequestMapping("/list2")
    public R list2(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<RecordEntity> recordList = recordService.queryList(query);
        return R.ok().put("list", recordList);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        RecordEntity record = recordService.queryObject(id);

        return R.ok().put("record", record);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RecordEntity record) {

        if (record.getUser() == null)
            record.setUser(super.getUserId());


        recordService.save(record);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RecordEntity record) {
        recordService.update(record);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        recordService.deleteBatch(ids);

        return R.ok();
    }

}
