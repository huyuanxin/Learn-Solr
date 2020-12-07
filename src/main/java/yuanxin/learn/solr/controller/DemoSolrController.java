package yuanxin.learn.solr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yuanxin.learn.solr.api.AddDemoService;
import yuanxin.learn.solr.api.DeleteDemoService;
import yuanxin.learn.solr.api.SearchDemoService;
import yuanxin.learn.solr.api.UpdateDemoService;
import yuanxin.learn.solr.po.Demo;

import java.util.Date;
import java.util.List;

/**
 * @author huyuanxin
 * @create 2020/12/7 15:14
 */
@RestController
public class DemoSolrController {
    final private SearchDemoService searchDemoService;
    final private DeleteDemoService deleteDemoService;
    final private UpdateDemoService updateDemoService;
    final private AddDemoService addDemoService;

    @Autowired
    public DemoSolrController(SearchDemoService searchDemoService, DeleteDemoService deleteDemoService, UpdateDemoService updateDemoService, AddDemoService addDemoService) {
        this.searchDemoService = searchDemoService;
        this.deleteDemoService = deleteDemoService;
        this.updateDemoService = updateDemoService;
        this.addDemoService = addDemoService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Demo> searchAllDemo() {
        return searchDemoService.searchAllDemo();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public boolean addDemo() {
        Demo demo = new Demo();
        demo.setUid("10");
        demo.setName("addDemo");
        demo.setDesc("addDemo");
        demo.setDate(new Date());
        return addDemoService.addDemo(demo);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public boolean updateDemo(
            @RequestBody Demo demo) {
        return updateDemoService.updateDemo(demo);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public boolean deleteDemo(
            @RequestParam("uid") String uid
    ) {
        return deleteDemoService.deleteDemo(uid);
    }
}
