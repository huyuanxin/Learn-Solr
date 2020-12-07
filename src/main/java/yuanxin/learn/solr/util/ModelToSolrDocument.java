package yuanxin.learn.solr.util;

import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.StringUtils;
import yuanxin.learn.solr.po.Demo;

/**
 * @author huyuanxin
 * @create 2020/12/7 15:30
 */
public class ModelToSolrDocument {
    public static SolrInputDocument DemoToSolrDocument(Demo demo) {
        // Demo转为SolrInputDocument
        SolrInputDocument document = new SolrInputDocument();
        if (!StringUtils.isEmpty(demo.getUid())) {
            document.addField("id", demo.getUid());
        }
        if (!StringUtils.isEmpty(demo.getName())) {
            document.addField("Name", demo.getName());

        }
        if (!StringUtils.isEmpty(demo.getDesc())) {
            document.addField("Desc", demo.getDesc());

        }
        if (demo.getName() != null) {
            document.addField("create_time", demo.getDate());
        }
        return document;
    }
}
