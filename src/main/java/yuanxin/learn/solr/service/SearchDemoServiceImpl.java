package yuanxin.learn.solr.service;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuanxin.learn.solr.api.SearchDemoService;
import yuanxin.learn.solr.dto.DemoSearchResultDTO;
import yuanxin.learn.solr.po.Demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyuanxin
 * @create 2020/12/7 15:11
 */
@Service("SearchDemoService")
public class SearchDemoServiceImpl implements SearchDemoService {
    private final SolrClient solrClient;

    @Autowired
    public SearchDemoServiceImpl(SolrClient solrClient) {
        this.solrClient = solrClient;
    }

    /**
     * 查询所以demo
     *
     * @return 查询结果 {@link DemoSearchResultDTO}
     */
    @Override
    public DemoSearchResultDTO searchAllDemo() {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        List<Demo> demoList = queryDemosList(solrQuery);
        return new DemoSearchResultDTO("200", "查询成功", demoList);
    }

    /**
     * 通过年龄范围查询Solr内的Demo
     *
     * @param start  起始
     * @param ending 结尾
     * @return 查询结果 {@link DemoSearchResultDTO}
     */
    @Override
    public DemoSearchResultDTO searchDemoWithAgeFitter(int start, int ending) {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        String fq;
        // 添加fq过滤条件
        // 此处存在一个问题, 若Age=10,fq形如 “Age:[* TO 100]”、“Age:[* TO 1000]”时,也会被查询出来。
        if (start < 0 && ending >= 0) {
            // Age:[ * TO ending ]
            fq = "Age:[ * TO " + ending + " ]";
            solrQuery.addFilterQuery(fq);
        } else if (start >= 0 && ending < 0) {
            // // Age:[ start TO * ]
            fq = "Age:[ " + start + " TO * ]";
            solrQuery.addFilterQuery(fq);
        } else if (start < 0) {
            // start < 0 && ending < 0
            // Age:[ * TO * ]
            fq = "Age:[ * TO * ]";
            solrQuery.addFilterQuery(fq);
        } else {
            // Age:[ start TO ending ];
            fq = "Age:[" + start + " TO " + ending + "]";
        }
        solrQuery.addFilterQuery(fq);
        List<Demo> demoList = queryDemosList(solrQuery);
        return new DemoSearchResultDTO("200", "查询成功", demoList);
    }

    /**
     * 带分页查询Solr内的Demo
     *
     * @param currentPage 当前页数
     * @param pageSize    页面显示个数
     * @return 查询结果 {@link DemoSearchResultDTO}
     */
    @Override
    public DemoSearchResultDTO searchDemo(int currentPage, int pageSize) {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        int start = (currentPage - 1) * pageSize;
        solrQuery.setStart(start);
        solrQuery.setRows(pageSize);
        List<Demo> demoList = queryDemosList(solrQuery);
        return new DemoSearchResultDTO("200", "查询成功", demoList);
    }

    /**
     * 执行solrQuery,返回DemoList
     *
     * @param solrQuery solr查询语句{@link SolrQuery}
     * @return 返回查询结果
     */
    private List<Demo> queryDemosList(SolrQuery solrQuery) {
        List<Demo> demoList = new ArrayList<>();
        try {
            QueryResponse queryResponse = solrClient.query(solrQuery);
            if (queryResponse != null) {
                demoList = queryResponse.getBeans(Demo.class);
            }
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
        return demoList;
    }
}
