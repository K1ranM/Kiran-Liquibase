package liquibaseT.liquibaseConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.File;
import java.util.List;

@Configuration
public class DataSourceConfig {

    @Bean
    public List<DataSource> dataSources() throws Exception {
    	File file = new File(getClass().getClassLoader().getResource("datasource.xml").toURI());
        return DatasourceXmlParser.parse(file); // Your custom XML parser for DataSources
    }
}

