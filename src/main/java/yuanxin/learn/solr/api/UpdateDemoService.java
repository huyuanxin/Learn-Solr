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
     * 更新Solr里面的 {@link Demo}
     *
     * @param demo 更新的 {@link Demo}
     * @return 是否成功 {@link Boolean}
     */
    boolean updateDemo(Demo demo);
}
