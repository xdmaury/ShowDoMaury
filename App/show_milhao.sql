-- MySQL dump 10.16  Distrib 10.1.34-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: show_milhao
-- ------------------------------------------------------
-- Server version	10.1.34-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alternativas`
--

DROP TABLE IF EXISTS `alternativas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alternativas` (
  `alternativas_IdPergunta` int(11) DEFAULT NULL,
  `alternativas_IdAlternativa` int(11) NOT NULL AUTO_INCREMENT,
  `alternativas_resposta1` varchar(100) DEFAULT NULL,
  `alternativas_resposta2` varchar(100) DEFAULT NULL,
  `alternativas_resposta3` varchar(100) DEFAULT NULL,
  `alternativas_resposta4` varchar(100) DEFAULT NULL,
  `alternativas_resposta_correta` int(11) DEFAULT NULL,
  PRIMARY KEY (`alternativas_IdAlternativa`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alternativas`
--

LOCK TABLES `alternativas` WRITE;
/*!40000 ALTER TABLE `alternativas` DISABLE KEYS */;
INSERT INTO `alternativas` VALUES (1,1,'Rio de janeiro','Rio grande do sul','Santa catarina','Goias',2),(2,2,'liquido','solido','gasoso','vaporoso',2),(4,3,'GAUCHINHA','PAULISTINHA','PIMENTINHA','ANDORINHA',3),(6,4,'CUCA','NEGRINHO DO PASTOREIO','BOITATÁ','SACI-PERERÊ',4),(17,5,'JAMAICA','CUBA','EL SALVADOR','MEXICO',2),(18,6,'DUQUE DE CAXIAS','MARECHAL RODON','DOM PEDRO II','MARECHAL DEODORO',4),(19,7,'MARECHAL DEODORO','BARÃO DE MAUA','DUQUE DE CAXIAS','MARQUES DE POMBAL',3),(20,8,'RAL GIL','BOLINHA','FLAVIO CAVALCANTI','CHACRINHA',4),(21,9,'MONSTRO','GORILA','PRINCIPE','SAPO',1),(22,10,'VIRGEM','AQUARIO','CAPRICORNIO','ARIES',3),(23,11,'HARRISON FORD','GERALD FORD','HENRY FORD','ANNA FORD',3),(24,12,'PRETA','VERMELHA','AZUL','VERDE',4),(25,13,'200','100','170','220',2),(26,14,'21 DE ABRIL','12 DE OUTUBRO','7 DE SETEMBRO','25 DE DEZEMBRO',3),(27,15,'VENEZA','VITORIO','VANCOUVER','VATICANO',4),(28,16,'MEDICOS','ESCOTEIROS','BOMBEIROS','POLICIAIS',2),(29,17,'ROMEU','ORFEU','HAMLET','IAGO',1),(30,18,'NOVE','DEZ','ONZE','DOZE',4),(31,19,'PARANA','SANTA CATARINA','SÃO PAULO','BAHIA',4),(32,20,'CANO','TAMBOR','AGULHA','CATILHO',2);
/*!40000 ALTER TABLE `alternativas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perguntas`
--

DROP TABLE IF EXISTS `perguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perguntas` (
  `perguntas_IdPergunta` int(11) NOT NULL AUTO_INCREMENT,
  `perguntas_pergunta` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`perguntas_IdPergunta`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perguntas`
--

LOCK TABLES `perguntas` WRITE;
/*!40000 ALTER TABLE `perguntas` DISABLE KEYS */;
INSERT INTO `perguntas` VALUES (1,'Em que estado brasileiro\r\nnasceu a apresentadora Xuxa?'),(2,'Qual é o nome dado ao estado da água em forma de gelo?'),(4,'Qual era o apelido da cantora Elis Regina?'),(6,'Qual é o personagem do folclore brasileiro que tem uma perna só?'),(17,'Fidel Castro nasceu em que país?'),(18,'Quem proclamou a república no Brasil em 1889?'),(19,'Quem é o patrono do exército brasileiro?'),(20,'Quem era o apresentador que reprovava os calouros tocando uma buzina?'),(21,'O que era Frankenstein, de Mary Shelley?'),(22,'Qual é o signo do zodíaco de quem nasce no dia do ano-novo?'),(23,'Quem fundou a fábrica de automóveis Ford?'),(24,'Qual é a cor que se associa com os grupos ecológicos?'),(25,'A água ferve a quantos graus centígrados?'),(26,'Quando é comemorado o dia da independência do Brasil?'),(27,'Qual lugar é também chamado de Santa Sé?'),(28,'Quem tem por lema a frase: “Sempre alerta”?'),(29,'Quem foi o grande amor de Julieta?'),(30,'Quantos signos formam o zodíaco?'),(31,'Vatapá é uma comida típica de qual estado?'),(32,'Como se chama o lugar onde são armazenadas as balas de um revólver?');
/*!40000 ALTER TABLE `perguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `usuario_nome` varchar(250) DEFAULT NULL,
  `usuario_senha` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-30 22:04:23
