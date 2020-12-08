package yuanxin.learn.solr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author huyuanxin
 */
@EnableOpenApi
@SpringBootApplication
public class SolrApplication {
    public static void main(String[] args) {
        SpringApplication.run(SolrApplication.class, args);
    }
}
