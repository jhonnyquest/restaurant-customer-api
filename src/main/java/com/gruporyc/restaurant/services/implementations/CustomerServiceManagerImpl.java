package com.gruporyc.restaurant.services.implementations;

import com.gruporyc.restaurant.DAO.CustomerRepository;
import com.gruporyc.restaurant.dto.CustomerDTO;
import com.gruporyc.restaurant.dto.SimpleResponse;
import com.gruporyc.restaurant.mappers.CustomerMapper;
import com.gruporyc.restaurant.model.Customer;
import com.gruporyc.restaurant.services.CustomerServiceManager;
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
