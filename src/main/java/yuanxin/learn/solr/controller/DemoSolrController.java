package yuanxin.learn.solr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yuanxin.learn.solr.api.AddDemoService;
import yuanxin.learn.solr.api.DeleteDemoService;
import yuanxin.learn.solr.api.SearchDemoService;
import yuanxin.learn.solr.api.UpdateDemoService;
import yuanxin.learn.solr.po.Demo;

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

    @RequestMapping(value = "/searchDemo", method = RequestMethod.GET)
    public List<Demo> searchAllDemo() {
        return searchDemoService.searchAllDemo();
    }

    @RequestMapping(value = "/addDemo", method = RequestMethod.GET)
    public boolean addDemo(
            @RequestBody Demo demo) {
        return addDemoService.addDemo(demo);
    }

    @RequestMapping(value = "/updateDemo", method = RequestMethod.GET)
    public boolean updateDemo(
            @RequestBody Demo demo) {
        return updateDemoService.updateDemo(demo);
    }

    @RequestMapping(value = "/deleteDemo", method = RequestMethod.GET)
    public boolean deleteDemo(
            @RequestParam("uid") String uid) {
        return deleteDemoService.deleteDemo(uid);
    }

    @RequestMapping(value = "/searchDemoWithAge", method = RequestMethod.GET)
    public List<Demo> searchWithAge(
            @RequestParam(value = "start", required = false, defaultValue = "-1") int start,
            @RequestParam(value = "ending", required = false, defaultValue = "-1") int ending) {
        return searchDemoService.searchDemoWithAgeFitter(start, ending);
    }
}
