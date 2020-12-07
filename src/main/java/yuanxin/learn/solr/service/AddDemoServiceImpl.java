package yuanxin.learn.solr.service;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuanxin.learn.solr.api.AddDemoService;
import yuanxin.learn.solr.po.Demo;
import yuanxin.learn.solr.util.ModelToSolrDocument;

import java.io.IOException;

/**
 * @author huyuanxin
 * @create 2020/12/7 16:14
 */
@Service("AddDemoService")
public class AddDemoServiceImpl implements AddDemoService {
    private SolrClient solrClient;

    @Autowired
    public AddDemoServiceImpl(SolrClient solrClient) {
        this.solrClient = solrClient;
    }

    /**
     * 添加单个demo到Solr
     *
     * @param demo 添加的单个demo
     * @return 是否成功
     */
    @Override
    public boolean addDemo(Demo demo) {
        SolrInputDocument document = ModelToSolrDocument.demoToSolrDocument(demo);
        try {
            solrClient.add(document);
            solrClient.commit();
            return true;
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
