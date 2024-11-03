CREATE TABLE contacts
(
    id         VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NULL,
    last_name  VARCHAR(255) NULL,
    phone      VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    username   VARCHAR(255) NULL,
    CONSTRAINT pk_contacts PRIMARY KEY (id)
);

ALTER TABLE contacts
    ADD CONSTRAINT FK_CONTACTS_ON_USERNAME FOREIGN KEY (username) REFERENCES users (username);