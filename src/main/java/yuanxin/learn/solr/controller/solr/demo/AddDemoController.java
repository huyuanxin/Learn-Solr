package yuanxin.learn.solr.controller.solr.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yuanxin.learn.solr.api.demo.AddDemoService;
import yuanxin.learn.solr.po.Demo;

/**
 * @author huyuanxin
 * @create 2020/12/8 11:27
 */
@Api(tags = "添加Demo的api")
@RestController
@RequestMapping(value = "/demo")
public class AddDemoController {
    final private AddDemoService addDemoService;

    @Autowired
    public AddDemoController(AddDemoService addDemoService) {
        this.addDemoService = addDemoService;
    }

    @ApiOperation(value = "添加单个Demo", response = boolean.class)
    @RequestMapping(value = "/addDemo", method = RequestMethod.GET)
    public boolean addDemo(
            @RequestBody Demo demo) {
        return addDemoService.addDemo(demo);
    }
}
