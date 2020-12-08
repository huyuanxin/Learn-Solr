package yuanxin.learn.solr.api;

import org.springframework.stereotype.Service;
import yuanxin.learn.solr.po.Demo;

/**
 * @author huyuanxin
 * @create 2020/12/7 16:11
 */
@Service("DeleteDemoService")
public interface DeleteDemoService {
    /**
     * 删除Solr的单个 {@link Demo}
     *
     * @param uid {@link Demo} 的Uid
     * @return 是否成功 {@link Boolean}
     */
    boolean deleteDemo(String uid);
}
