create database TestDATA
go
 use TestDATA

 create table Account(
 STT int identity(1,1),
 TENTK nvarchar(20),
 MATKHAU varchar(10),
 primary key(TENTK)
 )

 insert into Account values
 (N'ABCXYZ','123456'),
 (N'ABCXYQ','123456'),
 (N'ABCXYY','123456')
