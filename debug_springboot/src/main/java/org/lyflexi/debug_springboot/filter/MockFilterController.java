package org.lyflexi.debug_springboot.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ly
 * @Date: 2024/6/11 21:43
 */
@Slf4j
@RestController
public class MockFilterController {
    @GetMapping("/mockFilterController")
    public void mockFilterController(){
    }
}
