package yuanxin.learn.solr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import yuanxin.learn.solr.po.Demo;

import java.util.List;

/**
 * @author huyuanxin
 * @create 2020/12/8 10:59
 */
@ApiModel(value = "DemoSearchResultDTO", description = "查询返回结果封装类")
public class DemoSearchResultDTO {
    @ApiModelProperty("状态码")
    @JsonProperty("Code")
    String code;

    @ApiModelProperty("具体内容")
    @JsonProperty("Message")
    String message;

    @ApiModelProperty("数据所在的地方")
    @JsonProperty("rows")
    List<Demo> rows;

    @ApiModelProperty("返回数据的大小")
    @JsonProperty("RowsSize")
    Long rowsSize;

    @ApiModelProperty("总数量，用于分页计算")
    @JsonProperty("total")
    Long total;

    public DemoSearchResultDTO(String code, String message, List<Demo> rows, Long total) {
        this.code = code;
        this.message = message;
        this.rows = rows;
        this.rowsSize = (long) rows.size();
        this.total = total;
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
                ", rowsSize=" + rowsSize +
                ", total=" + total +
                '}';
    }
}
