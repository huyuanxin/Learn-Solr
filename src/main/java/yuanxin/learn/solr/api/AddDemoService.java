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
     * 添加单个 {@link Demo} 到Solr
     *
     * @param demo 添加的单个 {@link Demo}
     * @return 是否成功 {@link Boolean}
     */
    boolean addDemo(Demo demo);
}
