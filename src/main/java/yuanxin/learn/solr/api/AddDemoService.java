package yuanxin.learn.solr.api;

import org.springframework.stereotype.Service;
import yuanxin.learn.solr.po.Demo;

/**
 * @author huyuanxin
 * @create 2020/12/7 16:12
 */
@Service("AddDemoService")
public interface AddDemoService {
    /**
     * 添加单个demo到Solr
     *
     * @param demo 添加的单个demo
     * @return 是否成功
     */
    boolean addDemo(Demo demo);
}
