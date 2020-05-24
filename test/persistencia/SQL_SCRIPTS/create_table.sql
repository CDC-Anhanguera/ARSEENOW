create table if not exists produto (
    id_produto int UNSIGNED not null AUTO_INCREMENT PRIMARY KEY,
    nome varchar(60),
    valor DOUBLE,
    quantidade INT
) ENGINE=MyISAM DEFAULT Charset=utf8;

create table if not exists admin (
    id_admin int UNSIGNED not null AUTO_INCREMENT PRIMARY KEY,
    login varchar(60) NOT NULL,
    nome varchar(60) NOT NULL,
    senha varchar(60) NOT NULL
) ENGINE=MyISAM DEFAULT Charset=utf8;