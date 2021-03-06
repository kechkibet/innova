-- begin INNOVA_SECURITY
alter table INNOVA_SECURITY add constraint FK_INNOVA_SECURITY_COMPANY foreign key (COMPANY_ID) references INNOVA_LISTED_COMPANY(ID)^
alter table INNOVA_SECURITY add constraint FK_INNOVA_SECURITY_BOND_TYPE foreign key (BOND_TYPE_ID) references INNOVA_TREASURY_BONDS_TYPES(ID)^
create index IDX_INNOVA_SECURITY_COMPANY on INNOVA_SECURITY (COMPANY_ID)^
create index IDX_INNOVA_SECURITY_BOND_TYPE on INNOVA_SECURITY (BOND_TYPE_ID)^
-- end INNOVA_SECURITY
-- begin INNOVA_TREASURY_BONDS_TYPES
alter table INNOVA_TREASURY_BONDS_TYPES add constraint FK_INNOVA_TREASURY_BONDS_TYPES_SCANNED_COPY foreign key (SCANNED_COPY_ID) references SYS_FILE(ID)^
create index IDX_INNOVA_TREASURY_BONDS_TYPES_SCANNED_COPY on INNOVA_TREASURY_BONDS_TYPES (SCANNED_COPY_ID)^
-- end INNOVA_TREASURY_BONDS_TYPES
-- begin INNOVA_INVESTOR_CASH_DEPOSIT
alter table INNOVA_INVESTOR_CASH_DEPOSIT add constraint FK_INNOVA_INVESTOR_CASH_DEPOSIT_INVESTOR foreign key (INVESTOR_ID) references INNOVA_INVESTOR(ID)^
create index IDX_INNOVA_INVESTOR_CASH_DEPOSIT_INVESTOR on INNOVA_INVESTOR_CASH_DEPOSIT (INVESTOR_ID)^
-- end INNOVA_INVESTOR_CASH_DEPOSIT
-- begin INNOVA_INVESTOR_HOLDINGS
alter table INNOVA_INVESTOR_HOLDINGS add constraint FK_INNOVA_INVESTOR_HOLDINGS_INVESTOR foreign key (INVESTOR_ID) references INNOVA_INVESTOR(ID)^
alter table INNOVA_INVESTOR_HOLDINGS add constraint FK_INNOVA_INVESTOR_HOLDINGS_SECURITY foreign key (SECURITY_ID) references INNOVA_SECURITY(ID)^
create index IDX_INNOVA_INVESTOR_HOLDINGS_INVESTOR on INNOVA_INVESTOR_HOLDINGS (INVESTOR_ID)^
create index IDX_INNOVA_INVESTOR_HOLDINGS_SECURITY on INNOVA_INVESTOR_HOLDINGS (SECURITY_ID)^
-- end INNOVA_INVESTOR_HOLDINGS
