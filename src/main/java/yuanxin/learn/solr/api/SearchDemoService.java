package yuanxin.learn.solr.api;

import org.springframework.stereotype.Service;
import yuanxin.learn.solr.dto.DemoSearchResultDTO;
import yuanxin.learn.solr.po.Demo;

/**
 * @author huyuanxin
 * @create 2020/12/7 15:10
 */
@Service("SearchDemoService")
public interface SearchDemoService {
    /**
     * 查询所有 {@link Demo}
     *
     * @return 查询结果 {@link DemoSearchResultDTO}
     */
    DemoSearchResultDTO searchAllDemo();

    /**
     * 通过年龄范围查询Solr内的 {@link Demo}
     *
     * @param ageStart  年龄起始
     * @param ageEnding 年龄结尾
     * @return 查询结果 {@link DemoSearchResultDTO}
     */
    DemoSearchResultDTO searchAllDemoWithAgeFitter(int ageStart, int ageEnding);

    /**
     * 带分页查询Solr内的 {@link Demo}
     *
     * @param currentPage 当前页数
     * @param pageSize    页面显示个数
     * @return 查询结果 {@link DemoSearchResultDTO}
     */
    DemoSearchResultDTO searchDemo(int currentPage, int pageSize);


    /**
     * 带分页的通过年龄范围查询Solr内的 {@link Demo}
     *
     * @param ageStart    年龄起始
     * @param ageEnding   年龄结尾
     * @param currentPage 当前页数
     * @param pageSize    页面显示个数
     * @return {@link DemoSearchResultDTO}
     */
    DemoSearchResultDTO searchDemoWithAgeFitter(int ageStart, int ageEnding, int currentPage, int pageSize);
}
