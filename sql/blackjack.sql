-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 15, 2016 at 12:25 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blackjack`
--

-- --------------------------------------------------------

--
-- Table structure for table `blackjackrounds`
--

CREATE TABLE `blackjackrounds` (
  `id` int(11) NOT NULL,
  `playedbyid` int(11) NOT NULL,
  `stake` int(11) NOT NULL,
  `won` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blackjackrounds`
--

INSERT INTO `blackjackrounds` (`id`, `playedbyid`, `stake`, `won`) VALUES
(1, 1, 50, 0),
(2, 1, 10, 0),
(3, 1, 10, 0),
(4, 1, 10, 0),
(5, 1, 10, 0),
(6, 1, 10, 0),
(7, 1, 10, 0),
(8, 1, 10, 0),
(9, 1, 10, 0),
(10, 1, 20, 0),
(11, 1, 10, 0),
(12, 1, 33, 0),
(13, 1, 30, 0),
(14, 1, 30, 0),
(15, 1, 27, 0),
(16, 1, 10, 0),
(17, 1, 10, 0),
(18, 1, 10, 0),
(19, 1, 100, 0),
(20, 1, 100, 0),
(21, 1, 20, 1),
(22, 1, 100, 0),
(23, 1, 100, 1),
(24, 1, 100, 1),
(25, 1, 110, 0),
(26, 1, 110, 0),
(27, 1, 110, 1),
(28, 1, 100, 0),
(29, 1, 100, 0),
(30, 1, 30, 0),
(31, 1, 10, 1),
(32, 1, 10, 0),
(33, 1, 10, 1),
(34, 1, 10, 0),
(35, 1, 10, 0),
(36, 1, 10, 0),
(37, 1, 10, 1),
(38, 1, 10, 0),
(39, 1, 10, 0),
(40, 1, 10, 0),
(41, 1, 10, 0),
(42, 1, 10, 0),
(43, 1, 10, 1),
(44, 1, 50, 0),
(45, 1, 50, 1),
(46, 1, 50, 1),
(47, 1, 50, 1),
(48, 1, 50, 1),
(49, 1, 200, 0),
(50, 1, 200, 1),
(51, 1, 200, 1),
(52, 1, 200, 0),
(53, 1, 200, 2),
(54, 1, 50, 0),
(55, 1, 33, 1),
(56, 1, 33, 1),
(57, 1, 33, 0),
(58, 1, 33, 0),
(59, 1, 50, 0),
(60, 1, 50, 0),
(61, 1, 50, 1),
(62, 1, 50, 1),
(63, 1, 50, 1),
(64, 1, 50, 1),
(65, 1, 100, 1),
(66, 1, 100, 1),
(67, 1, 200, 1),
(68, 1, 200, 0),
(69, 1, 200, 0),
(70, 1, 100, 0),
(71, 1, 100, 0),
(72, 1, 200, 0),
(73, 1, 200, 1),
(74, 1, 50, 0),
(75, 1, 50, 1),
(76, 1, 50, 1),
(77, 1, 50, 0);

-- --------------------------------------------------------

--
-- Table structure for table `logininfo`
--

CREATE TABLE `logininfo` (
  `id` int(11) NOT NULL,
  `username` varchar(11) NOT NULL,
  `password` varchar(11) NOT NULL,
  `datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `useraccounts`
--

CREATE TABLE `useraccounts` (
  `id` int(5) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `money` int(10) NOT NULL,
  `roundsWon` int(10) NOT NULL DEFAULT '0',
  `handsPlayed` int(10) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `useraccounts`
--

INSERT INTO `useraccounts` (`id`, `username`, `password`, `name`, `money`, `roundsWon`, `handsPlayed`) VALUES
(1, 'prome', '1234', 'ANKIT CHAURASIA', 800, 28, 85);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blackjackrounds`
--
ALTER TABLE `blackjackrounds`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `logininfo`
--
ALTER TABLE `logininfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `useraccounts`
--
ALTER TABLE `useraccounts`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blackjackrounds`
--
ALTER TABLE `blackjackrounds`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;
--
-- AUTO_INCREMENT for table `logininfo`
--
ALTER TABLE `logininfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `useraccounts`
--
ALTER TABLE `useraccounts`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
