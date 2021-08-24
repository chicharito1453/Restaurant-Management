Create database QUAN_AN
GO
USE QUAN_AN
GO
CREATE TABLE NHANVIEN
(
	idNV varchar(20) primary key,
	tenNV nvarchar(50),
	tuoi int,
	gt bit,
	sdt varchar(11),
	cmnd varchar(12),
	vaitro nvarchar(30),
	luongCa money,
	pass varchar(30),
	avatar nvarchar(50) default 'noimage.jpg'
)
GO
CREATE TABLE BAN
(
	idBan int identity(1,1) primary key,
	tenBan nvarchar(100) default N'Bàn chưa đặt tên',
	vitri nvarchar(100) default N'Tầng trệt',
	trangthai nvarchar(30) default N'Trống'
)
GO
CREATE TABLE GHIHOADON
(
	NVghi varchar(20),
	idHD int,
	ngay date
)
GO
CREATE TABLE DANHSACHMON
(
	idMon int identity(1,1) primary key,
	tenMon nvarchar(50),
	loai bit,
	hinhanh varchar(50) default 'noimage.jpg',
	dongia money
)
GO
CREATE TABLE LICHLAM
(
	stt int identity(1,1) primary key,
	idNV varchar(20),
	ca int,
	ngay date,
	luongCa money,
	vaitro nvarchar(30),
	diemDanh bit default 1
)
GO
CREATE TABLE BANSUDUNG
(
	idHD int,
	idBan int,
	ngay date
)
CREATE TABLE HOADON
(
	idHD int identity(1,1) primary key,
	trangthai nvarchar(50) default N'Chưa thanh toán',
	ngay date,
	tongtien money default 0
)
GO
CREATE TABLE HOADONCT
(
	idHD int,
	idMon int,
	soluong int,
	donGia money
)
GO

ALTER TABLE LICHLAM
ADD CONSTRAINT fk_LL
FOREIGN KEY(idNV)
REFERENCES NHANVIEN(idNV)

ALTER TABLE GHIHOADON
ADD CONSTRAINT fk_cvnv
FOREIGN KEY(NVghi)
REFERENCES NHANVIEN(idNV)

ALTER TABLE GHIHOADON
ADD CONSTRAINT fk_cvnv2
FOREIGN KEY(idHD)
REFERENCES HOADON(idHD)

ALTER TABLE BANSUDUNG
ADD CONSTRAINT fk_bsd
FOREIGN KEY(idHD)
REFERENCES HOADON(idHD)

ALTER TABLE BANSUDUNG
ADD CONSTRAINT fk_bsd2
FOREIGN KEY(idBan)
REFERENCES BAN(idBan)

ALTER TABLE HOADONCT
ADD CONSTRAINT fk_hdct1
FOREIGN KEY(idHD)
REFERENCES HOADON(idHD)

ALTER TABLE HOADONCT
ADD CONSTRAINT fk_hdct2
FOREIGN KEY(idMon)
REFERENCES DANHSACHMON(idMon)

GO
	/*THEM DU LIEU NV*/
	insert into NHANVIEN values('nv1','Dinh','22',1,'0973782549','1111111111',N'QUẢN LÍ',150000,'123','noimage.jpg')
	insert into NHANVIEN values('nv2','Hoa','22',0,'0973782549','1111111111',N'THU NGÂN',75000,'123','noimage.jpg')
	insert into NHANVIEN values('nv3','Nhi','22',0,'0973782549','1111111111',N'THU NGÂN',75000,'123','noimage.jpg')
	insert into NHANVIEN values('nv4','Dat','22',1,'0973782549','1111111111',N'NHÂN VIÊN',60000,'123','noimage.jpg')
	insert into NHANVIEN values('nv5','Khang','22',1,'0973782549','1111111111',N'NHÂN VIÊN',60000,'123','noimage.jpg')
	insert into NHANVIEN values('nv6','Dat','22',1,'0973782549','1111111111',N'NHÂN VIÊN',60000,'123','noimage.jpg')
	insert into NHANVIEN values('nv7','Hong','22',0,'0973782549','1111111111',N'NHÂN VIÊN',60000,'123','noimage.jpg')
	insert into NHANVIEN values('nv8','Nhan','22',1,'0973782549','1111111111',N'NHÂN VIÊN',60000,'123','noimage.jpg')
	insert into NHANVIEN values('nv9','Trong','22',1,'0973782549','1111111111',N'NHÂN VIÊN',60000,'123','noimage.jpg')
	insert into NHANVIEN values('nv10','Khue','22',0,'0973782549','1111111111',N'NHÂN VIÊN',60000,'123','noimage.jpg')

GO
	/*THEM DU LIEU BAN*/
	insert into BAN(tenBan) values(N'Bàn thường'),(N'Bàn thường'),(N'Bàn thường'),(N'Bàn tiệc')
	,(N'Bàn thường'),(N'Bàn thường'),(N'Bàn thường'),(N'Bàn thường'),(N'Bàn thường'),(N'Bàn tiệc')

GO
	/*THEM DU LIEU MON AN*/
	insert into DANHSACHMON(tenMon,loai,hinhanh,dongia) 
	values(N'Bò bít tết',1,'thit.jpg',30000),
		  (N'Tôm hùm chấm sốt',1,'haisan.jpg',25000),
		  (N'Mì ngũ vị',1,'mi.jpg',20000),
		  (N'Gỏi ngũ sắc',1,'kobiet.jpg',15000),
		  (N'Đá dâu',0,'dau.jpg',15000),
		  (N'Nước ép cam',0,'cam.jpg',15000),
		  (N'Sting đỏ',0,'sting.jpg',10000),
		  (N'Bò bía',1,'bobia.jpg',25000)

GO
	/*THEM DU LIEU LICHLAM*/
	insert into LICHLAM(idNV,ca,ngay,luongCa,vaitro)
	values('nv3',1,'12/22/2020',75000,N'THU NGÂN'),
		  ('nv4',1,'12/22/2020',60000,N'NHÂN VIÊN'),
		  ('nv5',1,'12/22/2020',60000,N'NHÂN VIÊN'),
		  ('nv6',1,'12/22/2020',60000,N'NHÂN VIÊN'),
		  ('nv7',1,'12/22/2020',60000,N'NHÂN VIÊN'),
		  ('nv8',1,'12/22/2020',60000,N'NHÂN VIÊN')
GO

/*TẠO PROC THỐNG KÊ*/

/*DOANH THU*/
CREATE PROC sp_Doanhthu(@Year INT)
AS BEGIN
	SELECT 
		
              COUNT(DISTINCT hd.idHD) Soluotban,
				COUNT(DISTINCT hdct.idMon) Somonban,
				MIN(hd.tongtien) HoaDonThapNhat,
              MAX(hd.tongtien) HoaDonCaoNhat,
              SUM(hd.tongtien) TongDoanhThu   
		FROM HOADON hd
		JOIN HOADONCT hdct ON hd.idHD = hdct.idHD
              
	WHERE YEAR(Ngay) = @Year
       
END

GO
exec sp_Doanhthu 2020

/*MÓN ĂN*/
CREATE PROC sp_Monan(@Year INT)
AS BEGIN
	SELECT 
		
              top 3( H.soluong) Soluotban,
			  h.idMon mamon , 
			  d.tenMon tenmon
			  
		FROM DANHSACHMON D
		JOIN HOADONCT H ON d.idMon = h.idMon
		join HOADON hd on hd.idHD = h.idHD
              
	WHERE YEAR(Ngay) = @Year
       ORDER BY (soluong) desc	
END
go
exec sp_Monan 2020

/*LUONG*/
CREATE PROC sp_Luong(@MONTH INT, @YEAR INT)
AS BEGIN
SELECT
 L.idNV MaNV,
 NV.tenNV TenNV,
 NV.vaitro ChucVu,
 NV.luongCa*COUNT(L.idNV)  TongLuong
FROM NHANVIEN NV JOIN LICHLAM L ON NV.idNV = L.idNV
WHERE MONTH(L.ngay) = @MONTH AND YEAR(L.ngay) = @YEAR AND NV.vaitro != N'QUẢN LÍ' AND L.diemDanh = 1
GROUP BY L.idNV, NV.tenNV, NV.vaitro, NV.luongCa
ORDER BY (TongLuong) DESC
END
go
exec sp_Luong 12,2020
drop proc sp_Luong
use QUAN_AN
go