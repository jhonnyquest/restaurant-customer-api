CREATE TABLE customers (
  id varchar(36) PRIMARY KEY,
  name varchar(36) NOT NULL,
  last_name varchar(36) NOT NULL,
  email varchar(128) NOT NULL,
  phone varchar(15) DEFAULT NULL,
  address_1 varchar(128) DEFAULT NULL,
  address_2 varchar(128) DEFAULT NULL,
  city varchar(36) DEFAULT NULL,
  state varchar(36) DEFAULT NULL,
  country varchar(36) DEFAULT NULL,
  status varchar(50) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW()
);

CREATE INDEX customer_id ON customers(id);
CREATE INDEX customer_email ON customers(email);