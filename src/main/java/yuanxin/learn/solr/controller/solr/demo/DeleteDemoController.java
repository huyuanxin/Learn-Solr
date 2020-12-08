package yuanxin.learn.solr.controller.solr.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = "删除Demo的api")
@RestController
public class DeleteDemoController {
    final private DeleteDemoService deleteDemoService;

    @Autowired
    public DeleteDemoController(DeleteDemoService deleteDemoService) {
        this.deleteDemoService = deleteDemoService;
    }

    @ApiOperation(value = "通过Uid删除Demo", response = boolean.class)
    @RequestMapping(value = "/deleteDemo", method = RequestMethod.GET)
    public boolean deleteDemo(
            @ApiParam(value = "Demo的Uid", defaultValue = "0", required = true)
            @RequestParam("uid") String uid) {
        return deleteDemoService.deleteDemo(uid);
    }
}
