package liquibaseT.liquibaseConfig;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.w3c.dom.*;

import javax.sql.DataSource;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

public class DatasourceXmlParser {

    public static List<DataSource> parse(File xmlFile) throws Exception {
        List<DataSource> dataSources = new ArrayList<>();

        // Parse XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);
        NodeList datasourceNodes = doc.getElementsByTagName("datasource");

        // Iterate over each datasource
        for (int i = 0; i < datasourceNodes.getLength(); i++) {
            Node datasourceNode = datasourceNodes.item(i);
            if (datasourceNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) datasourceNode;
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String url = element.getElementsByTagName("url").item(0).getTextContent();
                String username = element.getElementsByTagName("username").item(0).getTextContent();
                String password = element.getElementsByTagName("password").item(0).getTextContent();
                String driverClassName = element.getElementsByTagName("driver-class-name").item(0).getTextContent();

                DriverManagerDataSource dataSource = new DriverManagerDataSource();
                dataSource.setUrl(url);
                dataSource.setUsername(username);
                dataSource.setPassword(password);
                dataSource.setDriverClassName(driverClassName);

                // Add the created DataSource to the list
                dataSources.add(dataSource);
            }
        }
        return dataSources;
    }
}
