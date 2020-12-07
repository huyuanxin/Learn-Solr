package yuanxin.learn.solr.service;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuanxin.learn.solr.api.DeleteDemoService;

import java.io.IOException;

/**
 * @author huyuanxin
 * @create 2020/12/7 16:15
 */
@Service("DeleteDemoService")
public class DeleteDemoServiceImpl implements DeleteDemoService {
    private final SolrClient solrClient;

    @Autowired
    public DeleteDemoServiceImpl(SolrClient solrClient) {
        this.solrClient = solrClient;
    }

    /**
     * 删除Solr的单个Demo
     *
     * @param uid Demo的Uid
     * @return 是否成功
     */
    @Override
    public boolean deleteDemo(String uid) {
        try {
            solrClient.deleteById(uid);
            solrClient.commit();
            return true;
        } catch (IOException | SolrServerException e) {
            e.printStackTrace();
        }
        return false;
    }
}
