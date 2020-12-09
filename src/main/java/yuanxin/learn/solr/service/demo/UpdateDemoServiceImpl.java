package yuanxin.learn.solr.service.demo;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuanxin.learn.solr.api.demo.UpdateDemoService;
import yuanxin.learn.solr.po.Demo;

import java.io.IOException;

/**
 * @author huyuanxin
 * @create 2020/12/7 16:16
 */
@Service("UpdateDemoService")
public class UpdateDemoServiceImpl implements UpdateDemoService {
    private final SolrClient solrClient;

    @Autowired
    public UpdateDemoServiceImpl(SolrClient solrClient) {
        this.solrClient = solrClient;
    }

    /**
     * 更新solr里面的 {@link Demo}
     *
     * @param demo 更新的 {@link Demo}
     * @return 是否成功 {@link Boolean}
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
