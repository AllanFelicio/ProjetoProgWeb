-- Database: bdprojetoweb
-- DROP DATABASE bdprojetoweb;
CREATE DATABASE bdprojetoweb
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;


-- Table: tbcliente
-- DROP TABLE tbcliente;

CREATE TABLE  IF NOT EXISTS tbaluno(
  matricula bigint NOT NULL,  
  nome character varying(255),
  cpf character varying(255),
  ende character varying(255),
  pai character varying(255),
  mae character varying(255),
  telefone character varying(255),  
  email character varying(255),
  dataNasc date,
  rg character varying(255),
  --status enum('Ativo','Inativo') NOT NULL,
  CONSTRAINT tbaluno_pkey PRIMARY KEY (matricula)
);
