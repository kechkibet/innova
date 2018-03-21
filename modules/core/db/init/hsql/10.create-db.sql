-- begin INNOVA_INVESTOR
create table INNOVA_INVESTOR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CASH_ACCOUNT_BALANCE double precision,
    --
    primary key (ID)
)^
-- end INNOVA_INVESTOR
-- begin INNOVA_SECURITY
create table INNOVA_SECURITY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    NAME varchar(255) not null,
    --
    -- from innova$TreasuryBond
    FACE_VALUE double precision,
    BOND_TYPE_ID varchar(36),
    --
    -- from innova$Stock
    COMPANY_ID varchar(36),
    --
    primary key (ID)
)^
-- end INNOVA_SECURITY
-- begin INNOVA_LISTED_COMPANY
create table INNOVA_LISTED_COMPANY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    SYMBOL varchar(255) not null,
    --
    primary key (ID)
)^
-- end INNOVA_LISTED_COMPANY
-- begin INNOVA_TREASURY_BONDS_TYPES
create table INNOVA_TREASURY_BONDS_TYPES (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DATED date,
    DUE date,
    REDEEMABLE_DATE date,
    SCANNED_COPY_ID varchar(36),
    CURRENCY varchar(255),
    --
    primary key (ID)
)^
-- end INNOVA_TREASURY_BONDS_TYPES
-- begin INNOVA_INVESTOR_CASH_DEPOSIT
create table INNOVA_INVESTOR_CASH_DEPOSIT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    INVESTOR_ID varchar(36) not null,
    NARRATIVE varchar(255) not null,
    CASH_AMOUNT double precision not null,
    --
    primary key (ID)
)^
-- end INNOVA_INVESTOR_CASH_DEPOSIT
-- begin INNOVA_INVESTOR_HOLDINGS
create table INNOVA_INVESTOR_HOLDINGS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    INVESTOR_ID varchar(36) not null,
    TRADE_STATUS integer,
    SECURITY_ID varchar(36) not null,
    TRADE_TYPE integer,
    QUANTITY double precision,
    PRICE double precision,
    TRADE_VALUE double precision not null,
    --
    primary key (ID)
)^
-- end INNOVA_INVESTOR_HOLDINGS
