-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 12, 2020 lúc 09:09 AM
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
  `soluong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `cthd`
--

INSERT INTO `cthd` (`mahd`, `masach`, `soluong`) VALUES
(1, 1, 1),
(1, 2, 1),
(1, 10, 1),
(2, 1, 1),
(2, 3, 1),
(2, 13, 1),
(3, 10, 1),
(4, 2, 3),
(4, 10, 1),
(5, 10, 1),
(6, 3, 2),
(6, 10, 1),
(6, 12, 1),
(6, 13, 1),
(7, 9, 1),
(7, 10, 1),
(8, 10, 1),
(8, 13, 1),
(9, 12, 1),
(10, 1, 1),
(10, 2, 10),
(10, 11, 1),
(11, 3, 1),
(12, 2, 1),
(12, 4, 1),
(12, 5, 1),
(12, 6, 1),
(12, 7, 3),
(12, 10, 1),
(13, 4, 2);

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
  `ngay` date NOT NULL,
  `makh` int(8) DEFAULT NULL,
  `id` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`mahd`, `ngay`, `makh`, `id`) VALUES
(1, '2020-01-01', NULL, 1),
(2, '2020-01-01', NULL, 1),
(3, '2020-01-01', 2, 2),
(4, '2020-01-01', NULL, 2),
(5, '2020-01-02', 2, 3),
(6, '2020-01-02', NULL, 3),
(7, '2020-01-02', NULL, 1),
(8, '2020-01-02', NULL, 1),
(9, '2020-01-05', NULL, 1),
(10, '2020-01-05', 1, 1),
(11, '2020-01-05', 2, 3),
(12, '2020-01-05', 3, 3),
(13, '2020-01-06', NULL, 1),
(14, '2020-05-10', NULL, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` int(8) NOT NULL,
  `hoten` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `ngaysinh` date DEFAULT NULL,
  `sdt` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diachi` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diem` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`makh`, `hoten`, `ngaysinh`, `sdt`, `diachi`, `diem`) VALUES
(1, 'Nguyen Thi Le Vy', '1998-12-31', '0123456789', 'ktx b', NULL),
(2, 'Nguyen Thi Anh Nga', NULL, '0987654321', 'ktx b', NULL),
(3, 'Do Thi Kim Ton', '2000-05-30', '0312367890', 'ktx a', NULL),
(4, 'La Ngo My Linh', '1999-01-01', '0372071777', 'ktx a', NULL),
(5, 'Nguyen Nghia', NULL, NULL, NULL, NULL);

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
(1, 'Harry Potter 1', NULL, 50, 198),
(2, 'Harry Potter 2', NULL, 50, 185),
(3, 'Harry Potter 3', NULL, 50, 196),
(4, 'Harry Potter 4', NULL, 50, 197),
(5, 'Harry Potter 5', NULL, 50, 199),
(6, 'Harry Potter 6', NULL, 50, 199),
(7, 'Harry Potter last', 'J.K.Rowling', 30, 297),
(8, 'Conan 99', 'Aoyama Goushou', 0, 30),
(9, 'Conan 98', 'Aoyama Goushou', 75, 19),
(10, 'Conan 97', 'Aoyama Goushou', 70, 12),
(11, 'Conan 96', 'Aoyama Goushou', 80, 19),
(12, 'Conan 95', 'Aoyama Goushou', 90, 18),
(13, 'Conan special', NULL, 10, 47);

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
(5, 'admin', 'admin', 'null', 1, 1),
(6, 'new', 'new', 'Nhan vien moi', 0, 0);

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
  MODIFY `mahd` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `makh` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `nhapkho`
--
ALTER TABLE `nhapkho`
  MODIFY `manhapkho` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `sach`
--
ALTER TABLE `sach`
  MODIFY `masach` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

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
