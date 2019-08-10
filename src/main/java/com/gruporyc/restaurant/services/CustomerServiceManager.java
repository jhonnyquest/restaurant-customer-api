package com.gruporyc.restaurant.services;

import com.gruporyc.restaurant.dto.CustomerDTO;
import com.gruporyc.restaurant.dto.SimpleResponse;

public interface CustomerServiceManager {
    SimpleResponse createCustomer(CustomerDTO newCustomer);

    CustomerDTO getCustomerById(String customerId);
}
