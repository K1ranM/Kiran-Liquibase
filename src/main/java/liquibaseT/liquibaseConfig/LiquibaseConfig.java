package liquibaseT.liquibaseConfig;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LiquibaseConfig {

    @Bean
    public List<SpringLiquibase> liquibase(List<DataSource> dataSources) {
        List<SpringLiquibase> liquibaseList = new ArrayList<>();
        
        for (DataSource dataSource : dataSources) {
            SpringLiquibase liquibase = new SpringLiquibase();
            liquibase.setDataSource(dataSource);
            liquibase.setChangeLog("classpath:db/changelog/master-changelog.yaml");
            try {
                liquibase.afterPropertiesSet();
            } catch (Exception e) {
                throw new RuntimeException("Failed to execute Liquibase for one of the databases", e);
            }
            liquibaseList.add(liquibase);
        }
        
        return liquibaseList;
    }
}