package yuanxin.learn.solr.api.dynamic;

import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 * @create 2020/12/9 9:37
 */
@Service("StringTypeDynamicFieldAddService")
public interface StringTypeDynamicFieldAddService {
    /**
     * 添加字符串类型的动态域
     *
     * @param field 添加的field
     * @return 是否添加成功 {@link String}
     */
    boolean addStringTypeDynamicField(String field);

}
