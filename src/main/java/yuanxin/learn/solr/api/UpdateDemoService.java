package yuanxin.learn.solr.api;

import org.springframework.stereotype.Service;
import yuanxin.learn.solr.po.Demo;

/**
 * @author huyuanxin
 * @create 2020/12/7 16:11
 */
@Service("UpdateDemoService")
public interface UpdateDemoService {
    /**
     * 更新Solr里面的demo
     *
     * @param demo 更新的demo
     * @return 是否成功
     */
    boolean updateDemo(Demo demo);
}
