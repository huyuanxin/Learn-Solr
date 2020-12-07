package yuanxin.learn.solr.api;

import org.springframework.stereotype.Service;
import yuanxin.learn.solr.po.Demo;

import java.util.List;

/**
 * @author huyuanxin
 * @create 2020/12/7 15:10
 */
@Service("SearchDemoService")
public interface SearchDemoService {
    /**
     * 查询所以demo
     *
     * @return 查询结果
     */
    List<Demo> searchAllDemo();

}
