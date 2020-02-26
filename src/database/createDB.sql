CREATE DATABASE `pizzaposdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
Create table if not exists `pizzaposdb`.`restcheck` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `TableID` INT NOT NULL,
  `UserID` INT NOT NULL,
  `CheckStatus` INT NOT NULL,
  `DateStarted` DATETIME NOT NULL,
  `DateClosed` datetime NULL,
  PRIMARY KEY (`ID`));
Create table if not exists `pizzaposdb`.`CheckStatusLU`(
	`ID` int NOT NULL,
	`CheckStatus` nvarchar(50) NULL,
    primary key(`ID`)
 );
Create table if not exists `pizzaposdb`.`Menu`(
	`ID` int NOT NULL auto_increment,
	`StoreID` int NOT NULL,
	`MenuType` int NOT NULL,
	`MenuName` nvarchar(50) NULL,
	PRIMARY KEY (`ID`));
Create table if not exists `pizzaposdb`.`MenuItem`  (
	`ID` INT NOT NULL AUTO_INCREMENT,
	MenuID int NOT NULL,
	ItemName nvarchar(50) NOT NULL,
	Price int NOT NULL,
	PriorityScore int NULL,
	ExecutionTime int NULL,
 primary key(`ID`));
Create table if not exists `pizzaposdb`.`MenuTypeLU`  (
	ID int NOT NULL,
	MenuType nvarchar(50) NULL,
    primary key(`ID`)); 

Create table if not exists `pizzaposdb`.`PaymentStatusLU`  (
	`ID` INT NOT NULL AUTO_INCREMENT,
	PaymentStatus nvarchar(50) NOT NULL,
	primary key(`ID`)); 

Create table if not exists `pizzaposdb`.`PaymentTypeLU`  (
	`ID` INT NOT NULL AUTO_INCREMENT,
	PaymentType nvarchar(50) NULL,
primary key(`ID`)); 

Create table if not exists `pizzaposdb`.`RoleLU`  (
	ID int NOT NULL,
	RoleType nvarchar(50) NULL,
 primary key(`ID`)); 

Create table if not exists `pizzaposdb`.`Store`  (
	ID int NOT NULL,
	StoreUserName nvarchar(50) NOT NULL,
 primary key(`ID`)); 

Create table if not exists `pizzaposdb`.`RestTables`  (
	`ID` INT NOT NULL AUTO_INCREMENT,
	Name nvarchar(50) NOT NULL,
	StoreID int NOT NULL,
	TableStatus int NOT NULL,
 primary key(`ID`)); 

Create table if not exists `pizzaposdb`.`TableStatusLU`  (
	ID int NOT NULL,
	TableStatus nvarchar(50) NULL,
 primary key(`ID`)); 

Create table if not exists `pizzaposdb`.`Ticket`  (
	`ID` INT NOT NULL AUTO_INCREMENT,
	DateStarted date NOT NULL,
	UserID int NOT NULL,
	TableID int NOT NULL,
	TicketStatus int NOT NULL,
	TicketType int NOT NULL,
 primary key(`ID`)); 

Create table if not exists `pizzaposdb`.`TicketStatusLU`  (
	`ID` INT NOT NULL AUTO_INCREMENT,
	TicketStatus nvarchar(50) NULL,
 primary key(`ID`)); 

CREATE TABLE IF NOT EXISTS `pizzaposdb`.`TicketTypeLU` (
    ID INT NOT NULL,
    TicketType NVARCHAR(50) NULL,
    PRIMARY KEY (`ID`)); 

CREATE TABLE IF NOT EXISTS `pizzaposdb`.`TransactionHistory` (
    `ID` INT NOT NULL AUTO_INCREMENT,
    CheckID INT NOT NULL,
    UserID INT NOT NULL,
    PaymentType INT NOT NULL,
    PaymentDate DATE NOT NULL,
    PaymentStatus INT NOT NULL,
    PRIMARY KEY (`ID`)
); 

Create table if not exists `pizzaposdb`.`UserLU`  (
	`ID` INT NOT NULL AUTO_INCREMENT,
	UserName nvarchar(50) NOT NULL,
	FirstName nvarchar(50) NOT NULL,
	LastName nvarchar(50) NOT NULL,
	RoleID int NOT NULL,
    primary key(`ID`));

Alter table pizzaposdb.restcheck
	ADD FOREIGN KEY
    check_table (TableId)
    references pizzaposdb.RestTables (id)
    on update cascade
    on delete cascade;

Alter table pizzaposdb.restcheck
	ADD FOREIGN KEY
    check_userLU (UserID)
    references pizzaposdb.UserLU (ID)
    on update cascade
    on delete cascade;
    
Alter table pizzaposdb.restcheck
	ADD FOREIGN KEY
    check_checkstatus (CheckStatus)
    references pizzaposdb.checkstatuslu (id)
    on update cascade
    on delete cascade;

Alter table pizzaposdb.menu
	ADD FOREIGN KEY
    menu_store (StoreId)
    references pizzaposdb.store (id)
    on update cascade
    on delete cascade;


Alter table pizzaposdb.menu
	ADD FOREIGN KEY
    menu_menutype (menutype)
    references pizzaposdb.menutypelu (id)
    on update cascade
    on delete cascade;

Alter table pizzaposdb.menuitem
	ADD FOREIGN KEY
    menuitem_menu (menuid)
    references pizzaposdb.menu (id)
    on update cascade
    on delete cascade;

alter table pizzaposdb.ticket
	add foreign key
    ticket_userid (userid)
    references pizzaposdb.userlu (id)
    on update cascade
    on delete cascade;

alter table pizzaposdb.ticket
	add foreign key
    ticket_resttable (tableid)
    references pizzaposdb.resttables (id)
    on update cascade
    on delete cascade;

alter table pizzaposdb.ticket
	add foreign key
    ticket_ticketstatuslu (ticketstatus)
    references pizzaposdb.ticketstatuslu (id)
    on update cascade
    on delete cascade;
    
alter table pizzaposdb.ticket
	add foreign key
    ticket_tickettypelu (tickettype)
    references pizzaposdb.tickettypelu (id)
    on update cascade
    on delete cascade;

alter table pizzaposdb.userlu
	add foreign key
    userlu_roleid (roleid)
    references pizzaposdb.rolelu (id)
    on update cascade
    on delete cascade;

alter table pizzaposdb.TransactionHistory
	add foreign key
    transact_restcheck (checkid)
    references pizzaposdb.restcheck (id)
    on update cascade
    on delete cascade;

alter table pizzaposdb.transactionhistory
	add foreign key
    transact_userlu (userid)
    references pizzaposdb.userlu (id)
    on update cascade
    on delete cascade;
    
alter table pizzaposdb.transactionhistory
	add foreign key
    transact_paymenttype (paymenttype)
    references pizzaposdb.paymenttypelu (id)
    on update cascade
    on delete cascade;

alter table pizzaposdb.transactionhistory
	add foreign key
    transact_paymentstatus (paymentstatus)
    references pizzaposdb.paymentstatuslu (id)
    on update cascade
    on delete cascade;