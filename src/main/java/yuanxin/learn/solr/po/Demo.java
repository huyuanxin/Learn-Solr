package yuanxin.learn.solr.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.Date;

/**
 * @author huyuanxin
 * @create 2020/12/7 14:24
 */
@SolrDocument(collection = "MyCore")
public class Demo {
    /**
     * uid
     */
    @Id
    @JsonProperty("Uid")
    @Field("id")
    String uid;

    /**
     * 姓名
     */
    @JsonProperty("Name")
    @Field("Name")
    String name;

    /**
     * desc
     */
    @JsonProperty("Desc")
    @Field("Desc")
    String desc;

    /**
     * date
     */
    @JsonProperty("Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Field("Create_Time")
    Date date;

    /**
     * 年龄
     */
    @JsonProperty("Age")
    @Field("Age")
    String Age;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }
}
