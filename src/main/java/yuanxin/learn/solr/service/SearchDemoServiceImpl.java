package yuanxin.learn.solr.service;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuanxin.learn.solr.api.SearchDemoService;
import yuanxin.learn.solr.po.Demo;

import java.io.IOException;
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
     * @return 查询结果 {@link List<Demo>}
     */
    @Override
    public List<Demo> searchAllDemo() {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        return queryDemosList(solrQuery);
    }

    /**
     * 通过年龄范围查询Solr内的Demo
     *
     * @param start  起始
     * @param ending 结尾
     * @return 查询结果 {@link List<Demo>}
     */
    @Override
    public List<Demo> searchDemoWithAgeFitter(int start, int ending) {
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
        return queryDemosList(solrQuery);
    }

    /**
     * 执行solrQuery,返回DemoList
     *
     * @param solrQuery solr查询语句{@link SolrQuery}
     * @return 返回查询结果
     */
    private List<Demo> queryDemosList(SolrQuery solrQuery) {
        try {
            QueryResponse queryResponse = solrClient.query(solrQuery);
            if (queryResponse != null) {
                return queryResponse.getBeans(Demo.class);
            }
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
