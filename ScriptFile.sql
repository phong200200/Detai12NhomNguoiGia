/*
Created		22/12/2021
Modified		22/12/2021
Project		
Model			
Company		
Author		
Version		
Database		MS SQL 2005 
*/
Use DoAnLTM
go

Drop table [StudentsMarks] 
go
Drop table [UsersRoles] 
go
Drop table [UserDetails] 
go
Drop table [Role] 
go
Drop table [Subjects] 
go
Drop table [Account] 
go


Create table [Account]
(
	[UserId] Varchar(10) NOT NULL, UNIQUE ([UserId]),
	[UserName] Varchar(16) NOT NULL, UNIQUE ([UserName]),
	[Password] Varchar(64) NOT NULL,
	[IsDisable] Bit NOT NULL,
	[ClassId] Varchar(8) NULL,
Primary Key ([UserId])
) 
go

Create table [Subjects]
(
	[SubjectId] Char(5) NOT NULL,
	[SubjectName] Varchar(64) NULL,
Primary Key ([SubjectId])
) 
go

Create table [Role]
(
	[RoleId] Tinyint NOT NULL,
	[RoleName] Varchar(16) NOT NULL, UNIQUE ([RoleName]),
Primary Key ([RoleId])
) 
go

Create table [UserDetails]
(
	[UserId] Varchar(10) NOT NULL,
	[FirstName] Nvarchar(64) NULL,
	[LastName] Nvarchar(64) NULL,
	[Age] Tinyint NULL,
Primary Key ([UserId])
) 
go

Create table [UsersRoles]
(
	[RoleId] Tinyint NOT NULL,
	[UserId] Varchar(10) NOT NULL,
Primary Key ([RoleId],[UserId])
) 
go

Create table [StudentsMarks]
(
	[UserId] Varchar(10) NOT NULL,
	[SubjectId] Char(5) NOT NULL,
Primary Key ([UserId],[SubjectId])
) 
go


e


Alter table [UsersRoles] add  foreign key([UserId]) references [Account] ([UserId])  on update no action on delete no action 
go
Alter table [UserDetails] add  foreign key([UserId]) references [Account] ([UserId])  on update no action on delete no action 
go
Alter table [StudentsMarks] add  foreign key([UserId]) references [Account] ([UserId])  on update no action on delete no action 
go
Alter table [StudentsMarks] add  foreign key([SubjectId]) references [Subjects] ([SubjectId])  on update no action on delete no action 
go
Alter table [UsersRoles] add  foreign key([RoleId]) references [Role] ([RoleId])  on update no action on delete no action 
go


Set quoted_identifier on
go


Set quoted_identifier off
go


/* Roles permissions */


/* Users permissions */


