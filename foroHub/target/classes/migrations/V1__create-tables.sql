
create table topico(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(100) not null,
    fechaCreacion varchar(50) not null,
    status varchar(1),
    autor varchar(100) not null,

    primary key(id)
);

create table usuario(

    id bigint not null auto_increment,
    nombre varchar(100) not null,
    email varchar(100) not null unique,
    contraseña varchar(6) not null,
    perfil varchar(100) not null,

    primary key(id)
);

