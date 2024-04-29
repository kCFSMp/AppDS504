create database bd_ventas_java;

use bd_ventas_java;

create table tb_persona1 (
	dni char(8) not null primary key,
    ap_paterno varchar(25) not null,
    ap_materno varchar(25) not null,
    nombre varchar(25) not null,
    genero char(1) not null,
    fecha_nacimiento date,
    sueldo float
);

insert into tb_persona1 values 
('12345678', 'Saca', 'Machaca', 'Cesar', 'M', '2004-12-30', 1592.74),
('11223344', 'Zavala', 'Lopez', 'Maria', 'F', '1990-05-15', 2500.50),
('66554422', 'Linares', 'Ramirez', 'Keyla', 'F', '1985-10-20', 3000.75);

delimiter $$
create procedure sp_ListarPersona1()
begin
	select dni as 'DNI', concat(ap_paterno, ' ', ap_materno, ' ', nombre) as 'Apellidos y Nombres',
    case genero when 'M' then 'Masculino'
					when 'F' then 'Femenino' end as 'Género'
	from tb_persona1;
end $$

call sp_ListarPersona1();

-- drop procedure sp_ListarPersona1;