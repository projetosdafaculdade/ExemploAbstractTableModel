SET SQL_SAFE_UPDATES=0;
create database EAMT;
use EAMT;
drop table categoria;
create table categoria(
id int not null primary key auto_increment,
nome varchar(45),
ativado int
);
update categoria set nome = 'TESTE', ativado = 1 where id = 21;
select * from categoria;

