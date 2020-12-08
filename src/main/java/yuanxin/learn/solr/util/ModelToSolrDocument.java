package yuanxin.learn.solr.util;

import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.StringUtils;
import yuanxin.learn.solr.po.Demo;

/**
 * @author huyuanxin
 * @create 2020/12/7 15:30
 */
public class ModelToSolrDocument {
    /**
     * Demo转为SolrInputDocument
     *
     * @param demo 传入的demo
     * @return 返回demo转换的document
     */
    public static SolrInputDocument demoToSolrDocument(Demo demo) {
        SolrInputDocument document = new SolrInputDocument();
        // 判断是不是空
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
            document.addField("Create_Time", demo.getDate());
        }
        return document;
    }
}
