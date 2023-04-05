package api.list;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class GetAPIs {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        DataSource ds = (DataSource) applicationContext.getBean("dataSource");
        JdbcTemplate jt = new JdbcTemplate(ds);

        jt.execute("CREATE TABLE API_list (user_id int NOT NULL, api_name varchar(50), api_endpoint_url varchar(150), api_docs_url varchar(150), api_tags varchar(100))");
        jt.execute("INSERT INTO API_list (user_id, api_name, api_endpoint_url, api_docs_url, api_tags) values (1, 'elephant_1')");

        Object[] parameters = new Object[] { new Integer(2) };
        String sql = "select name from elephant where id = ?"
        Object o = jt.queryForObject(sql,
                parameters, String.class);
        System.out.println((String) o);
    }
}