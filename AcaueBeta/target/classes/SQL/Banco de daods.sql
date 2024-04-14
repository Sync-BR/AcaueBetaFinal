
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
/*Criar Conta Administrador*/
INSERT INTO `acauebeta`.`usuarios` (`idUsuarios`, `Login`, `Password`) VALUES ('1', 'SYNC', '33910114');

/*Criar tabela de Emails*/
CREATE TABLE `acauebeta`.`email` (
  `idEmail` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(100) NOT NULL,
  `Mensagem` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`idEmail`, `Nome`));
/*Criar tabela de Postagem*/
CREATE TABLE `acauebeta`.`postagem` (
  `idPostagem` INT NOT NULL AUTO_INCREMENT,
  `Imagem` VARCHAR(100) NOT NULL,
  `Titulo` VARCHAR(50) NOT NULL,
  `Descrição` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`idPostagem`));
/*Criar campo para o popup*/
CREATE TABLE `acauebeta`.`cadastroemail` (
  `idCadastroEmail` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `SobreNome` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idCadastroEmail`));