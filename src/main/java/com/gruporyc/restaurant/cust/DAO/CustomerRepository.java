package com.gruporyc.restaurant.cust.DAO;

import com.gruporyc.restaurant.cust.model.Customer;
import com.gruporyc.restaurant.cust.enums.Status;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

@Component
public class CustomerRepository {
    private final DataSource ds;

    @Value("${api.customer.db.url}")
    private String url;

    public CustomerRepository() {
        this.ds = DataSourceSingleton.getInstance();
    }

    public Optional<Customer> getCustomerById(String id) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT id," +
                    "    name," +
                    "    last_name," +
                    "    email," +
                    "    phone," +
                    "    address_1," +
                    "    address_2," +
                    "    city," +
                    "    state," +
                    "    country," +
                    "    status," +
                    "    create_date," +
                    "    update_date " +
                    " FROM customers WHERE id = ?";

            Customer customer = run.query(query,
                    rs -> {
                        if(!rs.next()){
                            return null;
                        }
                        rs.last();

                        return new Customer.Builder()
                                .setId(rs.getString(1))
                                .setName(rs.getString(2))
                                .setLastName(rs.getString(3))
                                .setEmail(rs.getString(4))
                                .setPhone(rs.getString(5))
                                .setAddress1(rs.getString(6))
                                .setAddress2(rs.getString(7))
                                .setCity(rs.getString(8))
                                .setState(rs.getString(9))
                                .setCountry(rs.getString(10))
                                .setStatus(rs.getString(11))
                                .setCreateDate(rs.getString(12))
                                .setUpdateDate(rs.getString(13))
                                .build();
                    }, id);
            return Optional.ofNullable(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Customer> getCustomerByEmail(String email) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT id," +
                    "    name," +
                    "    last_name," +
                    "    email," +
                    "    phone," +
                    "    address_1," +
                    "    address_2," +
                    "    city," +
                    "    state," +
                    "    country," +
                    "    status," +
                    "    create_date," +
                    "    update_date " +
                    " FROM customers WHERE email = ?";

            Customer customer = run.query(query,
                    rs -> {
                        if(!rs.next()){
                            return null;
                        }
                        rs.last();

                        return new Customer.Builder()
                                .setId(rs.getString(1))
                                .setName(rs.getString(2))
                                .setLastName(rs.getString(3))
                                .setEmail(rs.getString(4))
                                .setPhone(rs.getString(5))
                                .setAddress1(rs.getString(6))
                                .setAddress2(rs.getString(7))
                                .setCity(rs.getString(8))
                                .setState(rs.getString(9))
                                .setCountry(rs.getString(10))
                                .setStatus(rs.getString(11))
                                .setCreateDate(rs.getString(12))
                                .setUpdateDate(rs.getString(13))
                                .build();
                    }, email);
            return Optional.ofNullable(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String createCustomer(Customer customer) {
        QueryRunner run = new QueryRunner(ds);

        String cutomerId = Objects.isNull(customer.getId()) ? UUID.randomUUID().toString() : customer.getId();
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            try {
                String insert = "INSERT INTO customers (id," +
                        "    name," +
                        "    last_name," +
                        "    email," +
                        "    phone," +
                        "    address_1," +
                        "    address_2," +
                        "    city," +
                        "    state," +
                        "    country," +
                        "    status)" +
                        "VALUES " +
                        "('" + cutomerId + "', " +
                        "'" + customer.getName() + "', " +
                        "'" + customer.getLastName() + "', " +
                        "'" + customer.getEmail() + "', " +
                        "'" + customer.getPhone() + "', " +
                        "'" + customer.getAddress1()+ "', " +
                        "'" + customer.getAddress2() + "', " +
                        "'" + customer.getCity() + "', " +
                        "'" + customer.getState() + "', " +
                        "'" + customer.getCountry() + "', " +



                        "'" + Status.ACTIVE.name() + "');";
                run.insert(conn, insert, new ScalarHandler<>());
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException(e);
            } finally {
                DbUtils.close(conn);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cutomerId;
    }
}
