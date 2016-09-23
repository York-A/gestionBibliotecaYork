-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-09-2016 a las 13:19:37
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `biblioteca_bilbao`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteBook`(IN `codBook` INT)
    NO SQL
BEGIN
delete from book where idBook=codBook;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteCopy`(IN `codCopy` INT)
    NO SQL
BEGIN

delete from copy where idCopy=codCopy;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUser`(IN `codUser` INT)
    NO SQL
BEGIN	
delete from user where idUser=codUser;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllBook`()
    NO SQL
select b.idBook, b.title, b.author, b.isbn from book b$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllCopy`()
    NO SQL
select c.idCopy, c.book, c.publisher, c.nPages,c.rent from copy c$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllUser`()
    NO SQL
select u.idUser, u.nameUser, u.surnameUser, u.bDate, u.email, u.password from user u$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getBookById`(IN `codBook` INT, OUT `out_title` VARCHAR(50), OUT `out_author` VARCHAR(75), OUT `out_isbn` VARCHAR(13), OUT `out_id` INT)
    NO SQL
BEGIN



select idBook , title, author, isbn into out_id, out_title,out_author,out_isbn from book  where idBook=codBook;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getCopiesOfBook`(IN `codBook` INT)
    NO SQL
BEGIN

select c.idCopy, c.book, c.publisher, c.nPages, c.rent from copy c where c.book=codBook;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getCopyById`(IN `codCopy` INT, OUT `out_id` INT, OUT `out_book` INT, OUT `out_publisher` VARCHAR(50), OUT `out_nPages` INT, OUT `out_rent` INT)
    NO SQL
select c.idCopy,c.book, c.publisher, c.nPages, c.rent into out_id, out_book, out_publisher, out_nPages,out_rent from copy c where c.idCopy=codCopy$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserById`(IN `codUser` INT, OUT `out_id` INT, OUT `out_nameUser` VARCHAR(25), OUT `out_surnameUser` VARCHAR(50), OUT `out_bDate` DATE, OUT `out_email` VARCHAR(25), OUT `out_password` VARCHAR(15))
    NO SQL
select u.idUser, u.nameUser, u.surnameUser, u.bDate, u.email, u.password out_id, out_nameUser, out_surnameUser, out_bDate, out_email, out_password from user u where u.idUser=codUser$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertBook`(OUT `codBook` INT, IN `title` VARCHAR(50), IN `author` VARCHAR(75), IN `isbn` VARCHAR(13))
    NO SQL
BEGIN

INSERT INTO book(`title`, `author`, `isbn`) 
VALUES(lower(title),lower(author),lower(isbn));
SET codBook=last_insert_id();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertCopy`(OUT `codCopy` INT, IN `publisher` VARCHAR(50), IN `nPages` INT(11), IN `book` INT)
    NO SQL
BEGIN

INSERT INTO copy(`book`,`publisher`, `nPages`) 
VALUES(book, lower(publisher),nPages);
SET codCopy=last_insert_id();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUser`(OUT `idUser` INT, IN `nameUser` VARCHAR(25), IN `surnameUser` VARCHAR(50), IN `bDate` DATE, IN `email` VARCHAR(25), IN `password` VARCHAR(15))
    NO SQL
BEGIN

INSERT INTO user(`nameUser`, `surnameUser`, `bDate`, `email`, `password`) 
VALUES(lower(nameUser),lower(surnameUser),bDate,lower(email),lower(password));
SET idUser=last_insert_id();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `rentCopy`(IN `codCopy` INT, IN `codUser` INT)
    NO SQL
BEGIN

UPDATE `copy` SET `rent`=codUser where `idCopy`=codCopy;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBook`(IN `codBook` INT, IN `title` VARCHAR(50), IN `author` VARCHAR(75), IN `isbn` VARCHAR(13))
    NO SQL
UPDATE `book` SET `title`=lower(title),`author`=lower(author),`isbn`=lower(isbn) where `idBook`=codBook$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCopy`(IN `codCopy` INT, IN `publisher` VARCHAR(50), IN `nPages` INT, IN `book` INT)
    NO SQL
UPDATE `copy` SET `book`=book,`publisher`=lower(publisher),`nPages`=nPages where `idCopy`=codCopy$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUser`(IN `codUser` INT, IN `nameUser` VARCHAR(25), IN `surnameUser` VARCHAR(50), IN `bDate` DATE, IN `email` VARCHAR(25), IN `password` VARCHAR(15))
    NO SQL
UPDATE `user` SET
`nameUser`=lower(nameUser),`surnameUser`=lower(surnameUser),`bDate`=bDate,`email`=lower(email),`password`=lower(password) where `idUser`=codUser$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `idBook` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `author` varchar(75) COLLATE utf8_spanish_ci NOT NULL,
  `isbn` varchar(13) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idBook`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=14 ;

--
-- Volcado de datos para la tabla `book`
--

INSERT INTO `book` (`idBook`, `title`, `author`, `isbn`) VALUES
(1, 'la conjura de los necios', 'john kennedy toole', '0-8071-0657-7'),
(2, 'it', 'stephen king', '0-670-81302-8'),
(3, 'la divina comedia', 'dante alighieri', '9782830201215'),
(4, 'la naranja mecanica', 'anthony burgess', '0-434-09800-0'),
(5, 'la montaña magica', 'thomas mann', '9788966803460'),
(6, 'un mundo feliz', 'aldous huxley', '1758392648'),
(8, 'un mundo feliz', 'aldous huxley', '1758392648'),
(9, 'un mundo feliz', 'aldous huxley', '1758392648'),
(11, 'un mundo feliz', 'aldous huxley', '1758392648'),
(12, 'un mundo feliz', 'aldous huxley', '1758392648'),
(13, 'un mundo feliz', 'aldous huxley', '1758392648');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `copy`
--

CREATE TABLE IF NOT EXISTS `copy` (
  `idCopy` int(11) NOT NULL AUTO_INCREMENT,
  `book` int(11) NOT NULL,
  `publisher` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `nPages` int(11) NOT NULL,
  `rent` int(11) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`idCopy`),
  KEY `book` (`book`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=14 ;

--
-- Volcado de datos para la tabla `copy`
--

INSERT INTO `copy` (`idCopy`, `book`, `publisher`, `nPages`, `rent`) VALUES
(1, 1, 'planeta', 134, 0),
(2, 1, 'alfaguara', 516, 0),
(3, 2, 'santillana', 137, 0),
(4, 2, 'planeta', 195, 0),
(5, 3, 'alfaguara', 175, 10),
(6, 3, 'santillana', 165, 0),
(7, 4, 'planeta', 163, 0),
(8, 4, 'alfaguara', 147, 0),
(9, 5, 'santillana', 258, 0),
(10, 5, 'planeta', 166, 0),
(12, 12, 'milagritos', 134, 0),
(13, 12, 'milagritos', 134, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `nameUser` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `surnameUser` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `bDate` date NOT NULL,
  `email` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`idUser`, `nameUser`, `surnameUser`, `bDate`, `email`, `password`) VALUES
(8, 'adrian', 'york', '1991-08-12', 'yorkdam@gmail.com', 'p4ssw0rd'),
(9, 'anselmo', 'dummy', '1985-09-28', 'soyundummy@gmail.com', '4nse1m0'),
(10, 'remigia', 'dummy', '1990-09-12', 'lahremy@gmail.com', 'l4r3m1'),
(11, 'ciudadano', 'anonimo', '1964-08-08', 'anonimoc@gmail.com', '4n0n1m0'),
(12, 'milton elvis', 'atahualpa gutierres', '2016-07-04', 'miltonsito@gmail.com', 'm1lt0ns1t0');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `copy`
--
ALTER TABLE `copy`
  ADD CONSTRAINT `FK_BOOK` FOREIGN KEY (`book`) REFERENCES `book` (`idBook`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
