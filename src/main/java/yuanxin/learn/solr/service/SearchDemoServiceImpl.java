package yuanxin.learn.solr.service;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuanxin.learn.solr.api.SearchDemoService;
import yuanxin.learn.solr.po.Demo;
import yuanxin.learn.solr.util.ModelToSolrDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyuanxin
 * @create 2020/12/7 15:11
 */
@Service("SearchDemoService")
public class SearchDemoServiceImpl implements SearchDemoService {
    private SolrClient solrClient;

    @Autowired
    public SearchDemoServiceImpl(SolrClient solrClient) {
        this.solrClient = solrClient;
    }

    /**
     * 查询所以demo
     *
     * @return 查询结果
     */
    @Override
    public List<Demo> searchAllDemo() {
        List<Demo> demoList = new ArrayList<>();
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        try {
            QueryResponse queryResponse = solrClient.query(solrQuery);
            if (queryResponse != null) {
                demoList = queryResponse.getBeans(Demo.class);
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return demoList;
    }
}
