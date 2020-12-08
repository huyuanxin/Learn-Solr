package yuanxin.learn.solr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import yuanxin.learn.solr.po.Demo;

import java.util.List;

/**
 * @author huyuanxin
 * @create 2020/12/8 10:59
 */
public class DemoSearchResultDTO {
    @JsonProperty("Code")
    String code;

    @JsonProperty("Message")
    String message;

    @JsonProperty("rows")
    List<Demo> rows;

    @JsonProperty("total")
    Long total;

    public DemoSearchResultDTO(String code, String message, List<Demo> rows) {
        this.code = code;
        this.message = message;
        this.rows = rows;
        this.total = (long) rows.size();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Demo> getRows() {
        return rows;
    }

    public void setRows(List<Demo> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DemoSearchResultDTO{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", rows=" + rows +
                ", total=" + total +
                '}';
    }
}
