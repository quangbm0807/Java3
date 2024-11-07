create database bvAsm
go
 use bvAsm
 go
 create table NhanVien(
 ID int IDENTITY(1,1) primary key,
 HoTen nvarchar(30),
 Luong int,
 GioiTinh nvarchar(15),
 TrinhDo nvarchar(20) )

 insert into NhanVien
 values
 ('Nguyễn Văn A', 1000,N'Nam',N'Đại Học'),
 ('Trần Văn B',5000,N'Nam',N'Cao Đẳng'),
 ('Nguyễn Thị C', 2000,N'Nữ',N'Trung Cấp'),
 ('Lê Thị D', 4000,N'Nữ',N'Sơ Cấp')