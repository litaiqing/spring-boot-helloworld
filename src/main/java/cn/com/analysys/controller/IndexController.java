package cn.com.analysys.controller;

import cn.com.analysys.dao.BaseUserInfoRepository;
import cn.com.analysys.error.exception.PathNoFoundException;
import cn.com.analysys.pojo.BaseUserInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName IndexController
 * @Description
 * @Author litaiqing
 * @Date 2018/7/9 14:05
 * @Version 1.0
 **/
@RestController
public class IndexController {

    @Autowired
    private String test;

    private Logger logger = Logger.getLogger(IndexController.class);

    @Value("${my.secret}")
    private String mySecret;

    @Value("${my.number}")
    private String myNumber;

    @Value("${my.bignumber}")
    private String myBignumber;

    @Value("${my.uuid}")
    private String uuid;

    @Value("${my.number.less.than.ten}")
    private String myNumberLessThanTen;

    @Value("${my.number.in.range}")
    private String myNumberInRange;

    @Autowired
    private BaseUserInfoRepository baseUserInfoRepository;

    /**
     * JPA 分页
     *
     * @param pageSize
     * @param pageIndex
     * @return
     */
    @ApiOperation(value = "自定义查询分页数据", notes = "notes", httpMethod = "POST", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "页面角标", paramType = "path", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", paramType = "path", required = true, dataType = "int")
    })
    @RequestMapping("page/{pageSize}/{pageIndex}")
    @ResponseBody
    public ResponseEntity<Page<BaseUserInfo>> page(@PathVariable(name = "pageIndex") Integer pageIndex,
                                                   @PathVariable(name = "pageSize") Integer pageSize) {
        Pageable           pageable = new PageRequest(pageIndex, pageSize);
        Page<BaseUserInfo> page     = baseUserInfoRepository.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    /**
     * Index 首页
     *
     * @return
     */
    @ApiOperation(value = "首页查询", notes = "首页notes", httpMethod = "GET")
    @ApiImplicitParam(name = "model", value = "这个参数不会传递", required = false, dataType = "Model")
    @RequestMapping("index")
    @ResponseBody
    public ResponseEntity<Model> index(Model model) {
        logger.info("open index");
        model.addAttribute("test", test)
             .addAttribute("mySecret", mySecret)
             .addAttribute("myNumber", myNumber)
             .addAttribute("myBignumber", myBignumber)
             .addAttribute("uuid", uuid)
             .addAttribute("day", new Date())
             .addAttribute("myNumberLessThanTen", myNumberLessThanTen)
             .addAttribute("myNumberInRange", myNumberInRange);
        return ResponseEntity.ok(model);
    }

    /**
     * error
     */
    @ApiOperation(value = "测试自定义异常", notes = "测试异常处理 PathNoFoundException", httpMethod = "GET")
    @RequestMapping("ex")
    @ResponseBody
    public ResponseEntity<Model> ex(Model model)
            throws PathNoFoundException {
        throw new PathNoFoundException("PathNoFoundException");
        // return ResponseEntity.ok(model.addAttribute("status", "success"));
    }

    /**
     * error
     */
    @ApiOperation(value = "测试 500 异常", notes = "访问得到500状态", code = 500, httpMethod = "GET")
    @RequestMapping("rex")
    @ResponseBody
    public ResponseEntity<Model> rex(Model model)
            throws Exception {
        throw new Exception("Error 500");
        // return ResponseEntity.ok(model.addAttribute("status", "success"));
    }

}
