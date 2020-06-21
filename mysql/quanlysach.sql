-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 21, 2020 lúc 06:55 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlysach`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietnhapkho`
--

CREATE TABLE `chitietnhapkho` (
  `manhapkho` int(8) NOT NULL,
  `masach` int(8) NOT NULL,
  `soluong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Bẫy `chitietnhapkho`
--
DELIMITER $$
CREATE TRIGGER `after_insert_chitietnhapkho` AFTER INSERT ON `chitietnhapkho` FOR EACH ROW begin 
 UPDATE sach
 SET soluong = soluong + new.soluong
 where masach = new.masach;
end
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_update_chitietnhapkho` AFTER UPDATE ON `chitietnhapkho` FOR EACH ROW begin 
 UPDATE sach
 SET soluong = soluong + new.soluong
 where masach = new.masach;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cthd`
--

CREATE TABLE `cthd` (
  `mahd` int(8) NOT NULL,
  `masach` int(8) NOT NULL,
  `soluong` int(11) DEFAULT NULL,
  `thanhtien` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `cthd`
--

INSERT INTO `cthd` (`mahd`, `masach`, `soluong`, `thanhtien`) VALUES
(1, 1, 1, NULL),
(1, 2, 1, NULL),
(1, 10, 1, NULL),
(2, 1, 1, NULL),
(2, 3, 1, NULL),
(2, 13, 1, NULL),
(3, 10, 1, NULL),
(4, 2, 3, NULL),
(4, 10, 1, NULL),
(5, 10, 1, NULL),
(6, 3, 2, NULL),
(6, 10, 1, NULL),
(6, 12, 1, NULL),
(6, 13, 1, NULL),
(7, 9, 1, NULL),
(7, 10, 1, NULL),
(8, 10, 1, NULL),
(8, 13, 1, NULL),
(9, 12, 1, NULL),
(10, 1, 1, NULL),
(10, 2, 10, NULL),
(10, 11, 1, NULL),
(11, 3, 1, NULL),
(12, 2, 1, NULL),
(12, 4, 1, NULL),
(12, 5, 1, NULL),
(12, 6, 1, NULL),
(12, 7, 3, NULL),
(12, 10, 1, NULL),
(13, 4, 2, NULL),
(20, 1, 5, 250),
(21, 10, 5, 350),
(21, 13, 5, 50),
(22, 1, 9, 450),
(23, 5, 1, 150),
(23, 18, 2, 90),
(23, 19, 3, 60),
(24, 2, 2, 300),
(24, 9, 3, 150),
(24, 10, 2, 100),
(25, 1, 3, 450),
(25, 16, 2, 60),
(26, 11, 2, 100),
(26, 12, 2, 100),
(26, 19, 3, 60),
(27, 17, 2, 60),
(27, 18, 2, 90),
(27, 19, 3, 60),
(28, 13, 9, 900),
(28, 17, 10, 300),
(28, 19, 9, 180);

--
-- Bẫy `cthd`
--
DELIMITER $$
CREATE TRIGGER `after_insert_cthd` AFTER INSERT ON `cthd` FOR EACH ROW begin 
 UPDATE sach
 SET soluong = soluong - new.soluong
 where masach = new.masach;

end
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_update_cthd` AFTER UPDATE ON `cthd` FOR EACH ROW begin 
 UPDATE sach
 SET soluong = soluong - new.soluong
 where masach = new.masach;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `mahd` int(8) NOT NULL,
  `ngay` date DEFAULT NULL,
  `makh` int(8) DEFAULT NULL,
  `id` int(8) DEFAULT NULL,
  `tongtien` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`mahd`, `ngay`, `makh`, `id`, `tongtien`) VALUES
(1, '2020-01-01', NULL, 1, 30),
(2, '2020-01-01', NULL, 1, 130),
(3, '2020-01-01', 2, 2, 210),
(4, '2020-01-01', NULL, 2, 225),
(5, '2020-01-02', 2, 3, 190),
(6, '2020-02-02', NULL, 3, 185),
(7, '2020-02-02', NULL, 1, 165),
(8, '2020-02-02', NULL, 1, 225),
(9, '2020-02-05', NULL, 1, 510),
(10, '2020-03-05', 1, 1, 500),
(11, '2020-03-05', 2, 3, 305),
(12, '2020-03-05', 3, 3, 290),
(13, '2020-03-06', NULL, 1, 290),
(14, '2020-05-10', NULL, 1, 70),
(16, '2020-05-31', 2, 2, 50),
(18, '2020-05-18', 3, 4, 100),
(20, '2020-05-18', 5, 1, 250),
(21, '2020-06-19', 1, 1, 400),
(22, '2020-06-19', 1, 1, 450),
(23, '2020-06-19', 1, 4, 300),
(24, '2020-06-19', 1, 1, 550),
(25, '2020-03-19', 1, 1, 510),
(26, '2020-06-19', 13, 4, 260),
(27, '2020-06-19', 2, 4, 210),
(28, '2020-06-21', 4, 1, 1380);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` int(8) NOT NULL,
  `hoten` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `sdt` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diachi` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diem` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`makh`, `hoten`, `ngaysinh`, `sdt`, `diachi`, `diem`) VALUES
(1, NULL, NULL, NULL, NULL, NULL),
(2, 'Nguyen Thi Anh Nga', '1999-05-05', '0987654321', 'KTX B', 0),
(3, 'Do Thi Kim Ton', '2000-05-30', '0312367890', 'KTX A', 0),
(4, 'La Ngo My Linh', '1999-01-01', '0372071777', 'KTX A', 0),
(5, 'Nguyen Nghia', NULL, NULL, NULL, 0),
(6, 'Nguyen Thi Le Vy', '1998-12-31', '0123456789', 'KTX B', 0),
(7, 'Vo Thi Ngoc Huyen', '1998-07-19', '0885008850', 'Go Vap', 2),
(8, 'Do Thi Thien Huong', '1999-02-19', '0885008321', 'Thu Duc', 3),
(9, 'Truong Thi Nhi', '2003-10-13', '0784008850', 'Quan 3', 0),
(10, 'Ngo Thanh Thuy', '2001-11-01', '0812348850', 'KTX B', 1),
(11, 'Nguyen Chan', '1999-12-15', '0213908850', 'Cho Thu Duc', 0),
(12, 'Maria Miller', '1995-08-31', NULL, 'Quan 1', 5),
(13, 'Nguyen Vu Tu Anh', '2000-07-03', '0361881902', 'Binh Thanh', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhapkho`
--

CREATE TABLE `nhapkho` (
  `manhapkho` int(8) NOT NULL,
  `id` int(8) NOT NULL,
  `ngaynhapkho` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `masach` int(8) NOT NULL,
  `tensach` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `tacgia` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gia` double NOT NULL,
  `soluong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`masach`, `tensach`, `tacgia`, `gia`, `soluong`) VALUES
(1, 'Harry Potter 1', 'J.K.Rowling', 150, 181),
(2, 'Harry Potter 2', 'J.K.Rowling', 150, 183),
(3, 'Harry Potter 3', 'J.K.Rowling', 150, 196),
(4, 'Harry Potter 4', 'J.K.Rowling', 150, 197),
(5, 'Harry Potter 5', 'J.K.Rowling', 150, 198),
(6, 'Harry Potter 6', 'J.K.Rowling', 150, 199),
(7, 'Harry Potter last', 'J.K.Rowling', 190, 297),
(8, 'Conan tap 99', 'Aoyama Goushou', 70, 30),
(9, 'Conan tap 98', 'Aoyama Goushou', 50, 16),
(10, 'Conan tap 97', 'Aoyama Goushou', 50, 5),
(11, 'Conan tap 96', 'Aoyama Goushou', 50, 17),
(12, 'Conan tap 95', 'Aoyama Goushou', 50, 16),
(13, 'Conan special', 'Aoyama Goushou', 100, 33),
(14, 'Doraemon 1', 'Fujiko Fujio', 30, 130),
(15, 'Doraemon 2', 'Fujiko Fujio', 30, 140),
(16, 'Doraemon 3', 'Fujiko Fujio', 30, 128),
(17, 'Doraemon 4', 'Fujiko Fujio', 30, 178),
(18, 'Nhoc Quay', NULL, 45, 96),
(19, 'Trang Quynh', 'Kim Khanh', 20, 192);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(8) NOT NULL,
  `taikhoan` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `matkhau` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `hoten` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `tinhtrang` tinyint(1) DEFAULT NULL,
  `quyen` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `taikhoan`, `matkhau`, `hoten`, `tinhtrang`, `quyen`) VALUES
(1, 'lan', 'lan', 'Nguyen Thi Lan', 1, 0),
(2, 'khanh', 'khanh', 'Vo Quy Khanh', 1, 0),
(3, 'nghia', 'nghia', 'Nghia', 1, 0),
(4, 'linh', 'linh', 'La Ngo My Linh', 1, 0),
(5, 'admin', 'admin', 'admin', 1, 1),
(43, 'q', 'q', 'q', 1, 0),
(45, 'i', 'i', 'i', 1, 0),
(46, 'u', 'i', 'U', 1, 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietnhapkho`
--
ALTER TABLE `chitietnhapkho`
  ADD PRIMARY KEY (`manhapkho`,`masach`),
  ADD KEY `masach` (`masach`);

--
-- Chỉ mục cho bảng `cthd`
--
ALTER TABLE `cthd`
  ADD PRIMARY KEY (`mahd`,`masach`),
  ADD KEY `masach` (`masach`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`mahd`),
  ADD KEY `id` (`id`),
  ADD KEY `makh` (`makh`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`);

--
-- Chỉ mục cho bảng `nhapkho`
--
ALTER TABLE `nhapkho`
  ADD PRIMARY KEY (`manhapkho`),
  ADD KEY `id` (`id`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`masach`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `mahd` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `makh` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `nhapkho`
--
ALTER TABLE `nhapkho`
  MODIFY `manhapkho` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `sach`
--
ALTER TABLE `sach`
  MODIFY `masach` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietnhapkho`
--
ALTER TABLE `chitietnhapkho`
  ADD CONSTRAINT `chitietnhapkho_ibfk_1` FOREIGN KEY (`manhapkho`) REFERENCES `nhapkho` (`manhapkho`),
  ADD CONSTRAINT `chitietnhapkho_ibfk_2` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`);

--
-- Các ràng buộc cho bảng `cthd`
--
ALTER TABLE `cthd`
  ADD CONSTRAINT `cthd_ibfk_1` FOREIGN KEY (`mahd`) REFERENCES `hoadon` (`mahd`),
  ADD CONSTRAINT `cthd_ibfk_2` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`);

--
-- Các ràng buộc cho bảng `nhapkho`
--
ALTER TABLE `nhapkho`
  ADD CONSTRAINT `nhapkho_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
