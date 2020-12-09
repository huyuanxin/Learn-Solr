package yuanxin.learn.solr.controller.solr.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yuanxin.learn.solr.api.demo.SearchDemoService;
import yuanxin.learn.solr.dto.DemoSearchResultDTO;

/**
 * @author huyuanxin
 * @create 2020/12/7 15:14
 */
@Api(tags = "查询Demo的api")
@RestController
@RequestMapping(value = "/demo")
public class SearchDemoController {
    final private SearchDemoService searchDemoService;

    @Autowired
    public SearchDemoController(SearchDemoService searchDemoService) {
        this.searchDemoService = searchDemoService;
    }

    @ApiOperation(value = "查询全部Demo", response = DemoSearchResultDTO.class)
    @RequestMapping(value = "/searchAllDemo", method = RequestMethod.GET)
    public DemoSearchResultDTO searchAllDemo() {
        return searchDemoService.searchAllDemo();
    }

    @ApiOperation(value = "带分页查询Demo", response = DemoSearchResultDTO.class)
    @RequestMapping(value = "/searchDemo", method = RequestMethod.GET)
    public DemoSearchResultDTO searchDemo(
            @ApiParam(value = "当前页数", defaultValue = "-1")
            @RequestParam(value = "currentPage", required = false, defaultValue = "-1") int currentPage,

            @ApiParam(value = "单页显示的数量", defaultValue = "-1")
            @RequestParam(value = "pageSize", required = false, defaultValue = "-1") int pageSize) {
        return searchDemoService.searchDemo(currentPage, pageSize);
    }

    @ApiOperation(value = "查询符合年龄限制的全部Demo", response = DemoSearchResultDTO.class)
    @RequestMapping(value = "/searchAllDemoWithAge", method = RequestMethod.GET)
    public DemoSearchResultDTO searchAllDemoWithAge(
            @ApiParam(value = "年龄范围的起始", defaultValue = "-1")
            @RequestParam(value = "start", required = false, defaultValue = "-1") int ageStart,

            @ApiParam(value = "年龄范围的终止", defaultValue = "-1")
            @RequestParam(value = "ending", required = false, defaultValue = "-1") int ageEnding) {
        return searchDemoService.searchAllDemoWithAgeFitter(ageStart, ageEnding);
    }

    @ApiOperation(value = "带分页的查询符合年龄限制的全部Demo", response = DemoSearchResultDTO.class)
    @RequestMapping(value = "/searchDemoWithAge", method = RequestMethod.GET)
    public DemoSearchResultDTO searchDemoWithAge(
            @ApiParam(value = "年龄范围的起始", defaultValue = "-1")
            @RequestParam(value = "start", required = false, defaultValue = "-1") int start,

            @ApiParam(value = "年龄范围的终止", defaultValue = "-1")
            @RequestParam(value = "ending", required = false, defaultValue = "-1") int ending,

            @ApiParam(value = "当前页数", defaultValue = "-1")
            @RequestParam(value = "currentPage", required = false, defaultValue = "-1") int currentPage,

            @ApiParam(value = "单页显示的数量", defaultValue = "-1")
            @RequestParam(value = "pageSize", required = false, defaultValue = "-1") int pageSize) {
        return searchDemoService.searchDemoWithAgeFitter(start, ending, currentPage, pageSize);
    }
}
