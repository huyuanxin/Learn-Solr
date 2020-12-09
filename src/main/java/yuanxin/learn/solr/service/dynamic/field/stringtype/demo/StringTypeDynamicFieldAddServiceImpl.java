package yuanxin.learn.solr.service.dynamic.field.stringtype.demo;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuanxin.learn.solr.api.dynamic.stingtype.demo.StringTypeDynamicFieldAddService;
import yuanxin.learn.solr.po.Demo;
import yuanxin.learn.solr.util.ModelToSolrDocument;

import java.io.IOException;
import java.util.Date;

/**
 * @author huyuanxin
 * @create 2020/12/9 9:41
 */
@Service("StringTypeDynamicFieldAddService")
public class StringTypeDynamicFieldAddServiceImpl implements StringTypeDynamicFieldAddService {
    private final SolrClient solrClient;

    @Autowired
    public StringTypeDynamicFieldAddServiceImpl(SolrClient solrClient) {
        this.solrClient = solrClient;
    }

    /**
     * 添加字符串类型的动态域
     *
     * @param field 添加的field
     * @return 是否添加成功 {@link String}
     */
    @Override
    public boolean addStringTypeDynamicField(String field) {
        Demo demo = new Demo();
        demo.setUid("10");
        demo.setName("TestDynamicField");
        demo.setAge("200");
        demo.setDesc("TestDynamicField");
        demo.setDate(new Date());
        SolrInputDocument demoToSolrDocument = ModelToSolrDocument.demoToSolrDocument(demo);
        demoToSolrDocument.addField("yuanxin_string_TestDynamicField", field);
        try {
            solrClient.add(demoToSolrDocument);
            solrClient.commit();
            return true;
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
