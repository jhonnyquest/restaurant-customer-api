package com.gruporyc.restaurant.cust.mappers;

import com.gruporyc.restaurant.cust.dto.CustomerDTO;
import com.gruporyc.restaurant.cust.model.Customer;

public class CustomerMapper {

    public static Customer customerFromCustomerDTO(CustomerDTO customerDTO) {
        return new Customer.Builder()
                .setId(customerDTO.getId())
                .setName(customerDTO.getNames())
                .setLastName(customerDTO.getLastNames())
                .setEmail(customerDTO.getEmail())
                .setPhone(customerDTO.getPhone())
                .setAddress1(customerDTO.getAddress1())
                .setAddress2(customerDTO.getAddress2())
                .setCity(customerDTO.getCity())
                .setState(customerDTO.getState())
                .setCountry(customerDTO.getCountry())
                .build();
    }

    public static CustomerDTO customerDTOFromCustomer(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setNames(customer.getName());
        customerDTO.setLastNames(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAddress1(customer.getAddress1());
        customerDTO.setAddress2(customer.getAddress2());
        customerDTO.setCity(customer.getCity());
        customerDTO.setState(customer.getState());
        customerDTO.setCountry(customer.getCountry());

        return customerDTO;
    }
}
