-- begin INNOVA_INVESTOR
create table INNOVA_INVESTOR (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
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
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    NAME varchar(255) not null,
    --
    -- from innova$TreasuryBond
    FACE_VALUE double precision,
    BOND_TYPE_ID varchar(32),
    --
    -- from innova$Stock
    QUANTITY double precision,
    COMPANY_ID varchar(32),
    --
    primary key (ID)
)^
-- end INNOVA_SECURITY
-- begin INNOVA_LISTED_COMPANY
create table INNOVA_LISTED_COMPANY (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
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
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    DATED date,
    DUE date,
    REDEEMABLE_DATE date,
    SCANNED_COPY_ID varchar(32),
    CURRENCY varchar(255),
    --
    primary key (ID)
)^
-- end INNOVA_TREASURY_BONDS_TYPES
-- begin INNOVA_INVESTOR_CASH_DEPOSIT
create table INNOVA_INVESTOR_CASH_DEPOSIT (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    INVESTOR_ID varchar(32) not null,
    NARRATIVE varchar(255) not null,
    CASH_AMOUNT double precision not null,
    --
    primary key (ID)
)^
-- end INNOVA_INVESTOR_CASH_DEPOSIT
-- begin INNOVA_INVESTOR_HOLDINGS
create table INNOVA_INVESTOR_HOLDINGS (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    INVESTOR_ID varchar(32) not null,
    TRADE_STATUS integer,
    SECURITY_ID varchar(32) not null,
    TRADE_TYPE integer,
    PRICE double precision,
    TRADE_VALUE double precision not null,
    --
    primary key (ID)
)^
-- end INNOVA_INVESTOR_HOLDINGS
