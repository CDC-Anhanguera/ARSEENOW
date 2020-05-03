create table if not exists doce (
    id_doce int UNSIGNED not null AUTO_INCREMENT PRIMARY KEY,
    nome varchar(60),
    valor DOUBLE,
    quantidade INT
) ENGINE=MyISAM DEFAULT Charset=utf8;