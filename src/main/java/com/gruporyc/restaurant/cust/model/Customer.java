package com.gruporyc.restaurant.cust.model;

public class Customer {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String status;
    private String createDate;
    private String updateDate;

    public Customer(String id, String name, String lastName, String email, String phone, String address1,
                    String address2, String city, String state, String country, String status, String createDate,
                    String updateDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getStatus() {
        return status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public static class Builder {
        private String id;
        private String name;
        private String lastName;
        private String email;
        private String phone;
        private String address1;
        private String address2;
        private String city;
        private String state;
        private String country;
        private String status;
        private String createDate;
        private String updateDate;

        public Customer.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Customer.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Customer.Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Customer.Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Customer.Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Customer.Builder setAddress1(String address1) {
            this.address1 = address1;
            return this;
        }

        public Customer.Builder setAddress2(String address2) {
            this.address2 = address2;
            return this;
        }

        public Customer.Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Customer.Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Customer.Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Customer.Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Customer.Builder setCreateDate(String createDate) {
            this.createDate = createDate;
            return this;
        }

        public Customer.Builder setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Customer build() {
            return new Customer(id, name, lastName, email, phone, address1, address2, city, state, country,
                    status, createDate, updateDate);
        }
    }
}
