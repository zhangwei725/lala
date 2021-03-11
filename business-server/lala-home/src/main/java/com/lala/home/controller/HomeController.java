package com.lala.home.controller;

import com.lala.common.vo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class HomeController {
    //    Logger log = LoggerFactory.getLogger(HomeController.class);
    @GetMapping("/")
    public ResponseResult<String> index() {
        log.info("首页信息");
        log.error("错误日志");
        return ResponseResult.success("hello world");
    }

}
