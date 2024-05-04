
/**
 * Author:  SYNC
 * Created: 28 de mar. de 2024
 * Sobre: Codigo para criação do banco de dados
 */

/* Criar Banco de dados*/
CREATE SCHEMA `acauebeta` ;

/*Criar Tabela de Usuarios Administradores*/
CREATE TABLE `acauebeta`.`usuarios` (
  `idUsuarios` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(15) NOT NULL,
  `Password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idUsuarios`, `Login`));

/*Criar tabela de postagem*/
CREATE TABLE `acauebeta`.`posts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `descriptionMain` VARCHAR(244) NOT NULL,
  `imageMain` VARCHAR(400) NOT NULL,
  `image1` VARCHAR(400) NOT NULL,
  `description1` VARCHAR(244) NOT NULL,
  `image2` VARCHAR(400) NOT NULL,
  `description2` VARCHAR(244) NOT NULL,
  `image3` VARCHAR(400) NOT NULL,
  `description3` VARCHAR(244) NOT NULL,
  `image4` VARCHAR(400) NOT NULL,
  `description4` VARCHAR(244) NOT NULL,
  PRIMARY KEY (`id`, `name`));

/*Criar Conta Administrador*/
INSERT INTO `acauebeta`.`usuarios` (`idUsuarios`, `Login`, `Password`) VALUES ('1', 'SYNC', '33910114');

/*Criar tabela de Emails*/
CREATE TABLE `acauebeta`.`contato` (
  `idEmail` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `message` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`idEmail`, `name`));
/*Criar campo para o popup*/
CREATE TABLE `acauebeta`.`cadastroemail` (
  `idCadastroEmail` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idCadastroEmail`));