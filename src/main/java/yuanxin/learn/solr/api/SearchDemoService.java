package yuanxin.learn.solr.api;

import org.springframework.stereotype.Service;
import yuanxin.learn.solr.dto.DemoSearchResultDTO;

/**
 * @author huyuanxin
 * @create 2020/12/7 15:10
 */
@Service("SearchDemoService")
public interface SearchDemoService {
    /**
     * 查询所有demo
     *
     * @return 查询结果 {@link DemoSearchResultDTO}
     */
    DemoSearchResultDTO searchAllDemo();

    /**
     * 通过年龄范围查询Solr内的Demo
     *
     * @param start  起始
     * @param ending 结尾
     * @return 查询结果 {@link DemoSearchResultDTO}
     */
    DemoSearchResultDTO searchDemoWithAgeFitter(int start, int ending);
}
