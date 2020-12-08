package yuanxin.learn.solr.controller.solr.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yuanxin.learn.solr.api.DeleteDemoService;

/**
 * @author huyuanxin
 * @create 2020/12/8 11:25
 */
@RestController
public class DeleteDemoController {
    final private DeleteDemoService deleteDemoService;

    @Autowired
    public DeleteDemoController(DeleteDemoService deleteDemoService) {
        this.deleteDemoService = deleteDemoService;
    }

    @RequestMapping(value = "/deleteDemo", method = RequestMethod.GET)
    public boolean deleteDemo(
            @RequestParam("uid") String uid) {
        return deleteDemoService.deleteDemo(uid);
    }
}
