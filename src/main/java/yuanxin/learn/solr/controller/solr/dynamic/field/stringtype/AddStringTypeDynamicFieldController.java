package yuanxin.learn.solr.controller.solr.dynamic.field.stringtype;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yuanxin.learn.solr.api.dynamic.StringTypeDynamicFieldAddService;

/**
 * @author huyuanxin
 * @create 2020/12/9 9:51
 */
@Api(tags = "添加字符串类型的动态字段")
@RestController
@RequestMapping(value = "/dynamic")
public class AddStringTypeDynamicFieldController {
    private final StringTypeDynamicFieldAddService stringTypeDynamicFieldAddService;

    @Autowired
    public AddStringTypeDynamicFieldController(StringTypeDynamicFieldAddService stringTypeDynamicFieldAddService) {
        this.stringTypeDynamicFieldAddService = stringTypeDynamicFieldAddService;
    }

    @ApiOperation(value = "添加字符串类型的动态字段", response = boolean.class)
    @RequestMapping(value = "/string", method = RequestMethod.GET)
    public boolean addStringTypeDynamicField(
            @ApiParam(value = "需要添加的动态字段")
            @RequestParam(value = "field") String field) {
        return stringTypeDynamicFieldAddService.addStringTypeDynamicField(field);
    }
}
