-- Crear la base de datos
create database bd_ventas_java;
go

-- Usar la base de datos creada
use bd_ventas_java;
go

-- Crear la tabla tb_persona1
create table tb_persona1 (
	dni char(8) not null primary key,
    ap_paterno varchar(25) not null,
    ap_materno varchar(25) not null,
    nombre varchar(25) not null,
    genero char(1) not null,
    fecha_nacimiento date,
    sueldo decimal(10, 2) not null -- Se cambió el tipo de dato a decimal
);
go

-- Insertar datos en la tabla tb_persona1
insert into tb_persona1 values 
('12345678', 'Saca', 'Machaca', 'Cesar', 'M', '2004-12-30', 1592.74),
('11223344', 'Zavala', 'Lopez', 'Maria', 'F', '1990-05-15', 2500.50),
('66554422', 'Linares', 'Ramirez', 'Keyla', 'F', '1985-10-20', 3000.75),
('99886631', 'Cardenas', 'Garcia', 'Nicole', 'F', '1985-10-20', 3000.75);
go
-- Crear sp_ListarPersona1
create procedure sp_ListarPersona1
as
begin
	select dni as 'DNI', concat(ap_paterno, ' ', ap_materno, ' ', nombre) as 'Apellidos y Nombres',
    case genero when 'M' then 'Masculino'
					when 'F' then 'Femenino' end as 'Género'
	from tb_persona1;
end
go

-- Ejecutar sp_ListarPersona1
exec sp_ListarPersona1;
go

-- drop procedure sp_ListarPersona1;

-- select * from tb_persona1;
-- go