package yuanxin.learn.solr.api;

import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 * @create 2020/12/7 16:11
 */
@Service("DeleteDemoService")
public interface DeleteDemoService {
    /**
     * 删除Solr的单个Demo
     *
     * @param uid Demo的Uid
     * @return 是否成功
     */
    boolean deleteDemo(String uid);
}
