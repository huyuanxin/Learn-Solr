package yuanxin.learn.solr.controller.solr.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yuanxin.learn.solr.api.demo.UpdateDemoService;
import yuanxin.learn.solr.po.Demo;

/**
 * @author huyuanxin
 * @create 2020/12/8 11:26
 */
@Api(tags = "更新Demo的api")
@RestController
@RequestMapping(value = "/demo")
public class UpdateDemoController {
    final private UpdateDemoService updateDemoService;

    @Autowired
    public UpdateDemoController(UpdateDemoService updateDemoService) {
        this.updateDemoService = updateDemoService;
    }

    @ApiOperation(value = "更新Demo", response = boolean.class)
    @RequestMapping(value = "/updateDemo", method = RequestMethod.GET)
    public boolean updateDemo(
            @RequestBody Demo demo) {
        return updateDemoService.updateDemo(demo);
    }
}
