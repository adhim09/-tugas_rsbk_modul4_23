-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2018 at 03:04 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ananda_brownis_pbd1`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(4) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `fullname` varchar(20) DEFAULT NULL,
  `tgl_terdaftar` date NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`, `fullname`, `tgl_terdaftar`, `status`) VALUES
(4, 'adhim', 'c8c605999f3d8352d7bb792cf3fdb25b', 'Windi', '2018-03-14', 'customer'),
(5, '9', '1545e945d5c3e7d9fa642d0a57fc8432', 'Dania', '2018-03-01', 'admin'),
(9, 'pbd', '827ccb0eea8a706c4c34a16891f84e7b', '21120115120015', '0000-00-00', 'customer'),
(10, 'nanda', '827ccb0eea8a706c4c34a16891f84e7b', 'Amalia', '0000-00-00', 'customer'),
(11, 'koko', '827ccb0eea8a706c4c34a16891f84e7b', 'koko fajar', '0000-00-00', 'customer');

-- --------------------------------------------------------

--
-- Stand-in structure for view `info_kue`
-- (See below for the actual view)
--
CREATE TABLE `info_kue` (
`nama_jenis_kue` varchar(25)
,`nama_kue` varchar(25)
,`harga_satuan` varchar(11)
,`jangka_expired` varchar(25)
,`stock` varchar(10)
);

-- --------------------------------------------------------

--
-- Table structure for table `jenis_kue`
--

CREATE TABLE `jenis_kue` (
  `kode_jenis_kue` varchar(4) NOT NULL DEFAULT '',
  `nama_jenis_kue` varchar(25) DEFAULT NULL,
  `jangka_expired` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenis_kue`
--

INSERT INTO `jenis_kue` (`kode_jenis_kue`, `nama_jenis_kue`, `jangka_expired`) VALUES
('123', 'brownies special', '10'),
('1234', 'birthday brownies', '3 hari'),
('9876', 'bmnvfmb', '18'),
('gdfg', 'amam2', '10 hari');

-- --------------------------------------------------------

--
-- Table structure for table `kue`
--

CREATE TABLE `kue` (
  `kode_kue` varchar(4) NOT NULL DEFAULT '',
  `nama_kue` varchar(25) DEFAULT NULL,
  `harga_satuan` varchar(11) DEFAULT NULL,
  `kode_jenis_kue` varchar(4) DEFAULT NULL,
  `stock` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kue`
--

INSERT INTO `kue` (`kode_kue`, `nama_kue`, `harga_satuan`, `kode_jenis_kue`, `stock`) VALUES
('1', 'Brownies Unyu Unyu', '15k', '123', '15'),
('10', 'Full Cream brownies', '31k', '123', '23'),
('11', 'White Brownies', '26,5k', '123', '4'),
('12', 'Milk Brownies', '17,5k', '123', '23'),
('14', 'Strowberry Brownies', '24k', '123', '21'),
('15', 'Rainbow Brownies', '32,5k', '123', '17'),
('16', 'Summer Brownies', '29k', '123', '14'),
('17', 'Winter Brownies', '29k', '123', '13'),
('2', 'Brownies Marble Cherry', '25k', '123', '25'),
('3', 'Red Brownies', '20k', '123', '19'),
('4', 'Green tea Brownies', '18,5k', '123', '16'),
('5', 'Brownies With Cream', '34k', '123', '6'),
('6', 'Original Brownies', '13k', '123', '24'),
('7', 'chocochip Brownies', '24k', '123', '21'),
('8', 'Purple Melt Brownies', '25k', '123', '16'),
('9', 'Peanut Brownies', '22k', '123', '22'),
('a', 'Rose Birthday Brownies', '150k', '1234', '1'),
('b', 'Garden Birthday Brownies', '250k', '1234', '1'),
('bb', 'cgxc', 'cggf', '123', '22225'),
('c', 'Choco Melt Birthday Brown', '275k', '1234', '1'),
('d', 'Strowberry Birthday Brown', '175k', '1234', '1'),
('e', 'Dream Birthday Brownies', '240k', '1234', '1'),
('f', 'Barbie Birthday Brownies', '320k', '1234', '1'),
('g', 'Star Birthday Brownies', '180k', '1234', '1'),
('h', 'Meses Birthday Brownies', '155k', '1234', '1'),
('i', 'Fruit Birthday Brownies', '145k', '1234', '1'),
('j', 'Hero Birthday Brownies', '260k', '1234', '1'),
('k', 'Current Birthday Brownies', '158k', '1234', '1'),
('l', 'Bouqet Birthday Brownies', '225k', '1234', '1'),
('m', 'Snake', '230k', '123', '1'),
('n', 'Butterfly Birthday Browni', '220k', '1234', '1'),
('o', 'Marsmallow Birthday Brown', '300k', '1234', '1'),
('p', 'Doll', '245k', '1234', '1');

-- --------------------------------------------------------

--
-- Table structure for table `outlet`
--

CREATE TABLE `outlet` (
  `kode_outlet` varchar(4) NOT NULL DEFAULT '',
  `nama_outlet` varchar(25) DEFAULT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `telp` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `outlet`
--

INSERT INTO `outlet` (`kode_outlet`, `nama_outlet`, `nama`, `alamat`, `telp`) VALUES
('ABC', 'AB Cikawao', 'Adhim FA', 'Jl. Cikawao No.II Bandung', '02241924192'),
('ABR', 'AB Rancabolang', 'Arief', 'Jl. Rancabolang No.XX Bandung', '02270777077'),
('BBB', 'AB Bali', 'Fadly', 'Waturenggong', '087766652000'),
('SMG', 'AB Semarang', 'Koko', 'Tembalang', '09876543211');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `no_nota` varchar(4) NOT NULL DEFAULT '',
  `tgl_jual` date DEFAULT NULL,
  `total_jual` int(11) DEFAULT NULL,
  `total_bayar` int(11) DEFAULT NULL,
  `kode_outlet` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`no_nota`, `tgl_jual`, `total_jual`, `total_bayar`, `kode_outlet`) VALUES
('', NULL, NULL, NULL, NULL),
('1', '2018-03-22', 55, 55, 'SMG'),
('1998', '2018-03-22', 55, 55, 'SMG'),
('2000', '2018-03-22', 2000, 2000, 'BBB'),
('J008', '2017-11-24', 676000, 608400, 'ABR'),
('J009', '2013-01-01', 352000, 316800, 'ABR'),
('J010', '2013-01-01', 131000, 131000, 'ABR'),
('R002', '2013-01-01', 104000, 104000, 'ABC');

-- --------------------------------------------------------

--
-- Table structure for table `tb_upload`
--

CREATE TABLE `tb_upload` (
  `nama` varchar(100) NOT NULL,
  `gambar` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_upload`
--

INSERT INTO `tb_upload` (`nama`, `gambar`) VALUES
('infokue', 'infokue.xlsx'),
('', 'infokue1.xlsx'),
('undip', 'find_user.png'),
('1', '1.png'),
('', '2.png'),
('amanda', 'amanda.jpg'),
('koko', 'find_user1.png');

-- --------------------------------------------------------

--
-- Structure for view `info_kue`
--
DROP TABLE IF EXISTS `info_kue`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `info_kue`  AS  select `jenis_kue`.`nama_jenis_kue` AS `nama_jenis_kue`,`kue`.`nama_kue` AS `nama_kue`,`kue`.`harga_satuan` AS `harga_satuan`,`jenis_kue`.`jangka_expired` AS `jangka_expired`,`kue`.`stock` AS `stock` from (`jenis_kue` join `kue` on((`jenis_kue`.`kode_jenis_kue` = `kue`.`kode_jenis_kue`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `jenis_kue`
--
ALTER TABLE `jenis_kue`
  ADD PRIMARY KEY (`kode_jenis_kue`);

--
-- Indexes for table `kue`
--
ALTER TABLE `kue`
  ADD PRIMARY KEY (`kode_kue`),
  ADD KEY `fk_kue_jenis` (`kode_jenis_kue`);

--
-- Indexes for table `outlet`
--
ALTER TABLE `outlet`
  ADD PRIMARY KEY (`kode_outlet`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`no_nota`),
  ADD KEY `fk_penjualan_outlet` (`kode_outlet`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `fk_penjualan_outlet` FOREIGN KEY (`kode_outlet`) REFERENCES `outlet` (`kode_outlet`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
