CREATE TABLE addresses
(
    id          VARCHAR(255) NOT NULL,
    street      VARCHAR(255) NULL,
    city        VARCHAR(255) NULL,
    province    VARCHAR(255) NULL,
    country     VARCHAR(255) NULL,
    postal_code VARCHAR(255) NULL,
    contact_id  VARCHAR(255) NULL,
    CONSTRAINT pk_addresses PRIMARY KEY (id)
);

ALTER TABLE addresses
    ADD CONSTRAINT FK_ADDRESSES_ON_CONTACT FOREIGN KEY (contact_id) REFERENCES contacts (id);