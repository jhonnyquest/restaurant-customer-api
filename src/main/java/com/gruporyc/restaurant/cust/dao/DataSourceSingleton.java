package com.gruporyc.restaurant.cust.dao;

import com.gruporyc.restaurant.cust.utilities.PropertyManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Optional;
import java.util.Properties;

@Component
public class DataSourceSingleton {

    private static DataSource instance = null;

    public DataSourceSingleton() {
    }

    public static synchronized DataSource getInstance() {
        if (instance == null) {
            PropertyManager pm = new PropertyManager();
            Properties properties = pm.getInstance();
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(Optional.ofNullable(System.getenv("CUSTOMER_DB_URL"))
                    .orElse(properties.getProperty("api.customers.db.url")));
            config.setUsername(Optional.ofNullable(System.getenv("CUSTOMER_DB_USERNAME"))
                    .orElse(properties.getProperty("api.customers.db.username")));
            config.setPassword(Optional.ofNullable(System.getenv("CUSTOMER_DB_PASSWORD"))
                    .orElse(properties.getProperty("api.customers.db.password")));
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            config.addDataSourceProperty("characterEncoding", "UTF-8");
            config.addDataSourceProperty("useUnicode", "true");
            config.addDataSourceProperty("serverTimezone", "UTC");

            instance = new HikariDataSource(config);

            Flyway flyway = new Flyway();
            flyway.setDataSource(instance);
            flyway.setLocations("classpath:db/migration/customers");
            flyway.migrate();
        }
        return instance;
    }
}


