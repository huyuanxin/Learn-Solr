package yuanxin.learn.solr.util;

import org.apache.solr.common.SolrInputDocument;
import yuanxin.learn.solr.po.Demo;

/**
 * @author huyuanxin
 * @create 2020/12/7 15:30
 */
public class ModelToSolrDocument {
    public static SolrInputDocument DemoToSolrDocument(Demo demo) {
        // Demo转为SolrInputDocument
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", demo.getUid());
        document.addField("Name", demo.getName());
        document.addField("Desc", demo.getDesc());
        document.addField("create_time", demo.getDate());
        return document;
    }
}
