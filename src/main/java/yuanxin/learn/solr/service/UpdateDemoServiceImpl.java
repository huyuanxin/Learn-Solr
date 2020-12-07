package yuanxin.learn.solr.service;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuanxin.learn.solr.api.UpdateDemoService;
import yuanxin.learn.solr.po.Demo;

import java.io.IOException;

/**
 * @author huyuanxin
 * @create 2020/12/7 16:16
 */
@Service("UpdateDemoService")
public class UpdateDemoServiceImpl implements UpdateDemoService {
    private SolrClient solrClient;

    @Autowired
    public UpdateDemoServiceImpl(SolrClient solrClient) {
        this.solrClient = solrClient;
    }

    /**
     * 更新solr里面的demo
     *
     * @param demo 更新的demo
     * @return 是否成功
     */
    @Override
    public boolean updateDemo(Demo demo) {
        try {
            solrClient.addBean(demo);
            solrClient.commit();
            return true;
        } catch (IOException | SolrServerException e) {
            e.printStackTrace();
        }
        return false;
    }
}
