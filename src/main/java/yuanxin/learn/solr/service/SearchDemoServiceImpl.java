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
     * 查询所有demo {@link List<Demo>}
     *
     * @return 查询结果 {@link DemoSearchResultDTO}
     */
    @Override
    public DemoSearchResultDTO searchAllDemo() {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        return queryDemosList(solrQuery);
    }

    /**
     * 通过年龄范围查询Solr内的Demo
     *
     * @param ageStart  年龄起始
     * @param ageEnding 年龄结尾
     * @return 查询结果 {@link DemoSearchResultDTO}
     */
    @Override
    public DemoSearchResultDTO searchAllDemoWithAgeFitter(int ageStart, int ageEnding) {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        String fq = returnDemoAgeFitterQuery(ageStart, ageEnding);
        solrQuery.addFilterQuery(fq);
        return queryDemosList(solrQuery);
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
        if (currentPage <= 0 || pageSize <= 0) {
            searchAllDemo();
        }
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        int start = (currentPage - 1) * pageSize;
        solrQuery.setStart(start);
        solrQuery.setRows(pageSize);
        return queryDemosList(solrQuery);
    }

    /**
     * 带分页的通过年龄范围查询Solr内的 {@link Demo}
     *
     * @param ageStart    年龄起始
     * @param ageEnding   年龄结尾
     * @param currentPage 当前页数
     * @param pageSize    页面显示个数
     * @return {@link DemoSearchResultDTO}
     */
    @Override
    public DemoSearchResultDTO searchDemoWithAgeFitter(int ageStart, int ageEnding, int currentPage, int pageSize) {
        if (currentPage <= 0 || pageSize <= 0) {
            return searchAllDemoWithAgeFitter(ageStart, ageEnding);
        }
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        // 确定fq语句
        String fq = returnDemoAgeFitterQuery(ageStart, ageEnding);
        solrQuery.addFilterQuery(fq);
        // 分页
        int start = (currentPage - 1) * pageSize;
        solrQuery.setStart(start);
        solrQuery.setRows(pageSize);
        return queryDemosList(solrQuery);
    }

    /**
     * 执行solrQuery,返回{@link DemoSearchResultDTO}
     *
     * @param solrQuery solr查询语句
     * @return 返回查询结果 {@link DemoSearchResultDTO}
     */
    private DemoSearchResultDTO queryDemosList(SolrQuery solrQuery) {
        List<Demo> demoList = new ArrayList<>();
        long row = 0L;
        try {
            QueryResponse queryResponse = solrClient.query(solrQuery);
            if (queryResponse != null) {
                demoList = queryResponse.getBeans(Demo.class);
                row = queryResponse.getResults().getNumFound();
            }
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
        return new DemoSearchResultDTO("200", "查询成功", demoList, row);
    }

    private String returnDemoAgeFitterQuery(int ageStart, int ageEnding) {
        String fq;
        // 添加fq过滤条件
        // 此处存在一个问题, 若Age=10,fq形如 “Age:[* TO 100]”、“Age:[* TO 1000]”时,也会被查询出来。
        if (ageStart < 0 && ageEnding >= 0) {
            // Age:[ * TO ending ]
            fq = "Age:[ * TO " + ageEnding + " ]";
        } else if (ageStart >= 0 && ageEnding < 0) {
            // // Age:[ start TO * ]
            fq = "Age:[ " + ageStart + " TO * ]";
        } else if (ageStart < 0) {
            // start < 0 && ending < 0
            // Age:[ * TO * ]
            fq = "Age:[ * TO * ]";
        } else {
            // Age:[ start TO ending ];
            fq = "Age:[" + ageStart + " TO " + ageEnding + "]";
        }
        return fq;
    }
}
