CREATE TABLE IF NOT EXISTS users
(
    ID               BIGINT NOT NULL AUTO_INCREMENT,
    username         VARCHAR(100) NOT NULL,
    password         VARCHAR(255) NULL,
    name             VARCHAR(255) NULL,
    token            VARCHAR(255) NULL,
    token_expired_at BIGINT NULL,
    CONSTRAINT pk_users PRIMARY KEY (ID),
    UNIQUE KEY (username)
);