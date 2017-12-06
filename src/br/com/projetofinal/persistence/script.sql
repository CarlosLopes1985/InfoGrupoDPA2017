/* CRIA��O DO BANCO */


create database TccDpaVersao3;

use TccDpaVersao3;

create table login(
	idLogin int primary key auto_increment,
	email varchar(50) unique not null,
	senha varchar(100) not null,
	perfil varchar(20) not null,
	status bit not null,
	palavraChave varchar(10) unique not null
	);

create table pessoa(
	idPessoa int primary key auto_increment,
	nomeUsuario varchar(100)unique not null,
	dataNascimento date not null,
	dataCadastro date not null, 
	foto blob,
	sexo varchar(20) not null,
	id_login int not null unique,
	foreign key(id_login)references login(idLogin)
);

create table jogos(
	idJogos int primary key auto_increment,
	jogos varchar(30) not null unique
);

create table plataformas(
	idPlataformas int primary key auto_increment,
	nomePlataforma varchar(50) unique
);

create table roles(
	idRoles int primary key auto_increment,
	nomeRoles varchar(50) not null unique
);

create table jogos_plataformas(
	jogos_idJogos int,
	plataformas_idPlataformas int,
	primary key(jogos_idJogos,plataformas_idPlataformas),
	foreign key(jogos_idJogos)references jogos(idJogos),
	foreign key(plataformas_idPlataformas)references plataformas(idPlataformas)
);

create table jogos_roles(
	jogos_idJogos int,
	Roles_idRoles int,
	primary key(jogos_idJogos,Roles_idRoles),
	foreign key(jogos_idJogos)references jogos(idJogos),
	foreign key(Roles_idRoles)references roles(idRoles)
);

CREATE TABLE IF NOT EXISTS `pessoa_jogo_plataforma_role` (
  `pjpr_codigo` INT(11) NOT NULL,
  `pjpr_pessoa_codigo` INT(11) NOT NULL,
  `pjpr_jogo_codigo` INT(11) NOT NULL,
  `pjpr_role_codigo` INT(11) NOT NULL,
  `pjpr_plataforma_codigo` INT(11) NOT NULL,
  PRIMARY KEY (`pjpr_codigo`),
  INDEX `fk1_pjpr_idx` (`pjpr_pessoa_codigo` ASC),
  INDEX `fk2_pjpr_idx` (`pjpr_jogo_codigo` ASC),
  INDEX `fk3_pjpr_idx` (`pjpr_role_codigo` ASC),
  INDEX `fk4_pjpr_idx` (`pjpr_plataforma_codigo` ASC),
  CONSTRAINT `fk1_pjpr`
    FOREIGN KEY (`pjpr_pessoa_codigo`)
    REFERENCES `tccdpaversao3`.`pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk2_pjpr`
    FOREIGN KEY (`pjpr_jogo_codigo`)
    REFERENCES `tccdpaversao3`.`jogos` (`idJogos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk3_pjpr`
    FOREIGN KEY (`pjpr_role_codigo`)
    REFERENCES `tccdpaversao3`.`roles` (`idRoles`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk4_pjpr`
    FOREIGN KEY (`pjpr_plataforma_codigo`)
    REFERENCES `tccdpaversao3`.`plataformas` (`idPlataformas`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;

create table classificacao(
	
);

create table conversasPessoas(
	idConversa int primary key auto_increment,
	idPessoa int,
	idPessoaChamada int,
	dataConversa date,
	idJogo int,
	idRole int,
	status boolean,
	
	foreign key(idPessoa)references pessoa(idPessoa),
	foreign key(idPessoaChamada)references pessoa(idPessoa),
	foreign key(idJogo)references jogos(idJogos),
	foreign key(idRole)references Roles(idRoles)
);

insert into conversasPessoas values(null, 1, 2,current_date,1,1,false);

select p.nomeUsuario, j.jogos from Pessoa p
 inner join conversasPessoas cd on cd.idPessoa = p.idPessoa
 inner join jogos j on j.idJogos = cd.idJogo
 where cd.idPessoa = 1;

Select p.idPessoa, p.nomeUsuario,l.email, p.sexo, p.dataNascimento,p.dataCadastro,l.status 
from pessoa p 
inner join login l on p.id_Login = l.idLogin;

