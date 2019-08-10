package com.gruporyc.restaurant.cust.services.implementations;

import com.gruporyc.restaurant.cust.DAO.CustomerRepository;
import com.gruporyc.restaurant.cust.mappers.CustomerMapper;
import com.gruporyc.restaurant.cust.dto.CustomerDTO;
import com.gruporyc.restaurant.cust.dto.SimpleResponse;
import com.gruporyc.restaurant.cust.model.Customer;
import com.gruporyc.restaurant.cust.services.CustomerServiceManager;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Component
public class CustomerServiceManagerImpl implements CustomerServiceManager {

    private static CustomerRepository customerRepository;

    public CustomerServiceManagerImpl() {
        customerRepository = new CustomerRepository();
    }

    @Override
    public SimpleResponse createCustomer(CustomerDTO newCustomer) {
        String customerId = customerRepository.createCustomer(CustomerMapper.customerFromCustomerDTO(newCustomer));
        return new SimpleResponse(true, customerId);
    }

    @Override
    public CustomerDTO getCustomerById(String customerId) {
        Optional<Customer> customer = customerRepository.getCustomerById(customerId);
        if (!customer.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return CustomerMapper.customerDTOFromCustomer(customer.get());
    }
}
