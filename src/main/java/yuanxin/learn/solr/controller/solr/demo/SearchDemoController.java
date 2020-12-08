package yuanxin.learn.solr.controller.solr.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yuanxin.learn.solr.api.SearchDemoService;
import yuanxin.learn.solr.dto.DemoSearchResultDTO;

/**
 * @author huyuanxin
 * @create 2020/12/7 15:14
 */
@RestController
public class SearchDemoController {
    final private SearchDemoService searchDemoService;

    @Autowired
    public SearchDemoController(SearchDemoService searchDemoService) {
        this.searchDemoService = searchDemoService;
    }

    @RequestMapping(value = "/searchAllDemo", method = RequestMethod.GET)
    public DemoSearchResultDTO searchAllDemo() {
        return searchDemoService.searchAllDemo();
    }

    @RequestMapping(value = "/searchDemo", method = RequestMethod.GET)
    public DemoSearchResultDTO searchDemo(
            @RequestParam(value = "currentPage", required = false, defaultValue = "-1") int currentPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "-1") int pageSize) {
        return searchDemoService.searchDemo(currentPage, pageSize);
    }

    @RequestMapping(value = "/searchAllDemoWithAge", method = RequestMethod.GET)
    public DemoSearchResultDTO searchAllDemoWithAge(
            @RequestParam(value = "start", required = false, defaultValue = "-1") int ageStart,
            @RequestParam(value = "ending", required = false, defaultValue = "-1") int ageEnding) {
        return searchDemoService.searchAllDemoWithAgeFitter(ageStart, ageEnding);
    }

    @RequestMapping(value = "/searchDemoWithAge", method = RequestMethod.GET)
    public DemoSearchResultDTO searchDemoWithAge(
            @RequestParam(value = "start", required = false, defaultValue = "-1") int start,
            @RequestParam(value = "ending", required = false, defaultValue = "-1") int ending,
            @RequestParam(value = "currentPage", required = false, defaultValue = "-1") int currentPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "-1") int pageSize) {
        return searchDemoService.searchDemoWithAgeFitter(start, ending, currentPage, pageSize);
    }
}
