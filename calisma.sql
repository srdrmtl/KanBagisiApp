-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Anamakine: localhost
-- Üretim Zamanı: 17 Nis 2018, 21:30:41
-- Sunucu sürümü: 5.7.21-0ubuntu0.16.04.1
-- PHP Sürümü: 7.0.28-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `calisma`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `bagisci`
--

CREATE TABLE `bagisci` (
  `id` int(11) NOT NULL,
  `ad` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `soyad` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mail` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `adres` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefon` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `kan_grubu` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sehir` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hide` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Tablo döküm verisi `bagisci`
--

INSERT INTO `bagisci` (`id`, `ad`, `soyad`, `mail`, `adres`, `telefon`, `kan_grubu`, `password`, `sehir`, `hide`) VALUES
(58, 'Serdar', 'Mutlu', 'serdarmutlu006@gmail.com', 'Muhittin mah. Tütün Sok. Sinem Apt. Çorlu/Tekirdağ', '05415576903', 'arh+', '1234', 'tekirdag', NULL);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `bagisci`
--
ALTER TABLE `bagisci`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `bagisci`
--
ALTER TABLE `bagisci`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
