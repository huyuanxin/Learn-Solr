package yuanxin.learn.solr.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.Date;

/**
 * @author huyuanxin
 * @create 2020/12/7 14:24
 */
@ApiModel(value = "Demo", description = "数据库以及Solr中转换的实体对象")
@SolrDocument(collection = "MyCore")
public class Demo {
    /**
     * uid
     */
    @Id
    @Field("id")
    @JsonProperty("Uid")
    @ApiModelProperty("Demo的Uid")
    String uid;

    /**
     * 姓名
     */
    @Field("Name")
    @JsonProperty("Name")
    @ApiModelProperty("Demo的Name")
    String name;

    /**
     * desc
     */
    @Field("Desc")
    @JsonProperty("Desc")
    @ApiModelProperty("Demo的desc")
    String desc;

    /**
     * date
     */
    @Field("Create_Time")
    @JsonProperty("Date")
    @ApiModelProperty("Demo的date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date date;

    /**
     * 年龄
     */
    @Field("Age")
    @JsonProperty("Age")
    @ApiModelProperty("Demo的age")
    String age;

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
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
