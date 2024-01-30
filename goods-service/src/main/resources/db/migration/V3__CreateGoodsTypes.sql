CREATE TABLE GOODS_TYPES
(
    ID            BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME          VARCHAR(100),
    DELETED       INT                DEFAULT 0, -- 0 未删除; 1 已删除
    OWNER_SHOP_ID BIGINT,
    CREATED_AT    TIMESTAMP NOT NULL DEFAULT NOW(),
    UPDATED_AT    TIMESTAMP NOT NULL DEFAULT NOW()
);
