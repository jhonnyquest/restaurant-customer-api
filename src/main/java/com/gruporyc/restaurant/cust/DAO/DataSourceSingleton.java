/******************************************************************
 *
 * This code is for the Pappking service project.
 *
 *
 * © 2018, Pappking Management All rights reserved.
 *
 *
 ******************************************************************/
package com.gruporyc.restaurant.cust.DAO;

import com.gruporyc.restaurant.cust.utilities.TextsHelper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Optional;

@Component
public class DataSourceSingleton {

    private static DataSource instance = null;

//    @Value("${api.customer.db.url}")
//    private static String url;
//    @Value("${api.customer.db.username}")
//    private static String username;
//    @Value("${api.customer.db.password}")
//    private static String password;

    @Autowired
    private TextsHelper textsHelper;

    public DataSourceSingleton() {}

    public static synchronized DataSource getInstance() {
        if (instance == null) {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(Optional.ofNullable(System.getenv("CUSTOMER_DB_URL"))
                    .orElse("jdbc:mysql://localhost:3306/restaurant_customers"));
            config.setUsername(Optional.ofNullable(System.getenv("CUSTOMER_DB_USERNAME"))
                    .orElse("customeruser"));
            config.setPassword(Optional.ofNullable(System.getenv("CUSTOMER_DB_PASSWORD"))
                    .orElse("customerpassword"));
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            config.addDataSourceProperty("characterEncoding", "UTF-8");
            config.addDataSourceProperty("useUnicode", "true");
            config.addDataSourceProperty("serverTimezone", "UTC");

            instance = new HikariDataSource(config);

            Flyway flyway = new Flyway();
            flyway.setDataSource(instance);
            flyway.setLocations("classpath:db/migration/customer");
            flyway.migrate();
        }
        return instance;
    }
}

