CREATE TABLE `ORDER_TABLE`
(
    ID              BIGINT PRIMARY KEY AUTO_INCREMENT,
    USER_ID         BIGINT,
    TOTAL_PRICE     DECIMAL(12, 2),       -- 价格，单位分
    ADDRESS_ID      BIGINT,
    EXPRESS_COMPANY VARCHAR(16),
    EXPRESS_ID      VARCHAR(128),
    WX_ORDER_NO     VARCHAR(100),
    PAY_TYPE        VARCHAR(100), -- 微信支付 余额支付
    PICKUP_TYPE     TINYINT,
    PICKUP_CODE     VARCHAR(10),
    SHOP_ID         BIGINT,
    STATUS          VARCHAR(16),  -- PENDING 待付款 PAID 已付款 DELIVERED 物流中 RECEIVED 已收货
    CREATED_AT      TIMESTAMP NOT NULL DEFAULT NOW(),
    UPDATED_AT      TIMESTAMP NOT NULL DEFAULT NOW()

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `ORDER_GOODS`
(
    ID       BIGINT PRIMARY KEY AUTO_INCREMENT,
    GOODS_ID BIGINT,
    ORDER_ID BIGINT,
    NUMBER   BIGINT -- 单位 分
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
