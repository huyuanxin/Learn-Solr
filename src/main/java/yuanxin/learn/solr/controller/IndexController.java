package yuanxin.learn.solr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huyuanxin
 * @create 2020/12/8 11:33
 */
@RestController
public class IndexController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage() {
        return "Welcome to solr search system!";
    }
}
