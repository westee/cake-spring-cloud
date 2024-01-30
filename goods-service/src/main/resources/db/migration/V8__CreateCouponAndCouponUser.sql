CREATE TABLE COUPON
(
    ID                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME                VARCHAR(255)   NOT NULL,
    DISCOUNT_TYPE       ENUM('AMOUNT', 'PERCENTAGE') NOT NULL,
    DISCOUNT_AMOUNT     DECIMAL(10, 2) NOT NULL,
    MINIMUM_AMOUNT      DECIMAL(10, 2),
    START_DATE          TIMESTAMP               DEFAULT NOW() NOT NULL,
    END_DATE            TIMESTAMP               DEFAULT NOW() NOT NULL,
    DISCOUNT_PERCENTAGE DECIMAL(2, 2),
    DESCRIPTION         varchar(500),
    CREATED_AT          TIMESTAMP      NOT NULL DEFAULT NOW(),
    UPDATED_AT          TIMESTAMP      NOT NULL DEFAULT NOW()
);

CREATE TABLE USER_COUPON
(
    ID         BIGINT AUTO_INCREMENT PRIMARY KEY,
    USER_ID    BIGINT    NOT NULL,
    COUPON_ID  BIGINT    NOT NULL,
    USED       BOOLEAN   default FALSE not null, -- 0 未使用 1 已使用
    USED_TIME  TIMESTAMP,
    CREATED_AT TIMESTAMP NOT NULL DEFAULT NOW(),
    UPDATED_AT TIMESTAMP NOT NULL DEFAULT NOW()
);