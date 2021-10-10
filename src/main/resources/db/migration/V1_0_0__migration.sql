CREATE TABLE PRICES (
    PRICE_LIST bigint auto_increment,
    BRAND_ID int,
    START_DATE timestamp,
    END_DATE timestamp,
    PRODUCT_ID int,
    PRIORITY int,
    PRICE double,
    CURR varchar(5), PRIMARY KEY (PRICE_LIST)
);