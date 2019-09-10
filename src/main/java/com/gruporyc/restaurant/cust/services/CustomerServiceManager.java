package com.gruporyc.restaurant.cust.services;

import com.gruporyc.restaurant.cust.dto.SimpleResponse;
import com.gruporyc.restaurant.cust.dto.CustomerDTO;

public interface CustomerServiceManager {
    SimpleResponse createCustomer(CustomerDTO newCustomer);

    CustomerDTO getCustomerById(String customerId);

    CustomerDTO getCustomerByEmail(String email);
}
