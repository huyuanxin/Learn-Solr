package yuanxin.learn.solr.controller.solr.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yuanxin.learn.solr.api.UpdateDemoService;
import yuanxin.learn.solr.po.Demo;

/**
 * @author huyuanxin
 * @create 2020/12/8 11:26
 */
@RestController
public class UpdateDemoController {
    final private UpdateDemoService updateDemoService;

    @Autowired
    public UpdateDemoController(UpdateDemoService updateDemoService) {
        this.updateDemoService = updateDemoService;
    }

    @RequestMapping(value = "/updateDemo", method = RequestMethod.GET)
    public boolean updateDemo(
            @RequestBody Demo demo) {
        return updateDemoService.updateDemo(demo);
    }
}
