package support.Tecnologia.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatasourceConfig {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    public String getDatasourceUrl() {
        return datasourceUrl;
    }
}
