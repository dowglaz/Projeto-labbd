-- remove tabelas
	drop table aeroporto cascade constraints; 
	drop table aviao cascade constraints; 
	drop table empregado cascade constraints; 
	drop table instancia_trecho cascade constraints; 
	drop table pessoa cascade constraints; 
	drop table piloto cascade constraints; 
	drop table pode_aterrissar cascade constraints; 
	drop table pode_trabalhar cascade constraints; 
	drop table poltrona cascade constraints; 
	drop table problemas cascade constraints; 
	drop table reserva cascade constraints; 
	drop table servico cascade constraints; 
	drop table tarifa cascade constraints; 
	drop table telefones cascade constraints; 
	drop table tipo_aviao cascade constraints; 
	drop table trecho_voo cascade constraints; 
	drop table voo cascade constraints; 
	drop table voa cascade constraints; 

	-- remove sequencias

	drop sequence seq_aviao; 
	drop sequence seq_reserva;
	drop sequence seq_servico; 




	create sequence seq_aviao
	start with 1
	increment by 1
	nocycle;

	create sequence seq_servico
	start with 1
	increment by 1
	nocycle;

	create sequence seq_reserva
	start with 1
	increment by 1
	nocycle;





	-- Tabela Aeroporto
	create table  aeroporto (
	   codigo       varchar2(3) not null,
	   nome         varchar2(65) not null,
	   cidade       varchar2(50) not null,
	   estado       varchar2(50) not null,
	   constraint pk_aeroporto primary key (codigo)
	);

	-- Tabela Voo
	create table voo (
	   numero          number(8) not null,
	   dia_semana      varchar2(8) not null,
	   companhia_aerea  varchar2(30) not null,
	   constraint pk_voo primary key (numero),
	   constraint ck_voo_dia check (dia_semana in ('DOMINGO','SEGUNDA', 'TERCA', 'QUARTA',
												   'QUINTA', 'SEXTA', 'SABADO'))
	);

	-- Tabela Tipo_Avi?o
	create table tipo_aviao (
	   nome           varchar2(60) not null,
	   max_poltronas   number(3),
	   empresa         varchar2(100) not null,
	   constraint pk_tipo_aviao primary key (nome)
	);


	-- Tabela Avi?o
	create table aviao (
	   id_aviao         number not null,
	   total_poltronas  number(3),
	   nro_registro     number(10) not null,
	   tipo_aviao       varchar2(20) not null,
	   constraint pk_aviao primary key (id_aviao),
	   constraint fk_tipoaviao_aviao foreign key (tipo_aviao) 
		  references tipo_aviao (nome) on delete cascade,
	   constraint un_aviao_registro unique (nro_registro)   
	);

	-- Tabela Pessoa
	create table pessoa (
	   cpf          number(15) not null,
	   nome         varchar2(65) not null,
	   rua          varchar2(50),
	   nro          number(5),
	   cidade       varchar2(30),
	   estado       varchar2(2),
	   cep          varchar2(10), 
	   foto         blob,
	   tipo         varchar2(10),
	   constraint pk_pessoa primary key (cpf),
	   constraint ck_tipo_pessoa check (tipo in ('PILOTO', 'EMPREGADO'))
	);


	-- Tabela Telefones
	create table telefones (
	   cpf          number(15) not null,
	   fone         varchar2(15) not null,
	   constraint pk_telefones primary key (cpf, fone),
	   constraint fk_pessoa_telefones foreign key (cpf) 
			references pessoa (cpf) on delete cascade
	);


	-- Tabela Piloto
	create table piloto (
	   cpf          number(15) not null,
	   nro_licenca  number(10) not null,
	   horas_voo    number(5),
	   constraint pk_piloto primary key (cpf),
	   constraint fk_pessoa_piloto foreign key (cpf)
		  references pessoa (cpf) on delete cascade,
	   constraint un_piloto_nro_licenca unique (nro_licenca)   
	);

	-- Tabela Empregado
	create table empregado (
	   cpf        number(15) not null,
	   salario    number(10,2),
	   turno      varchar2(11) default 'DIURNO',
	   constraint pk_empregado primary key (cpf),
	   constraint fk_pessoa_empregado foreign key (cpf)
		  references pessoa (cpf) on delete cascade,
	   constraint ck_turno check (turno in ('DIURNO', 'VESPERTINO', 'NOTURNO'))   
	);

	-- Tabela Tarifa
	create table tarifa (
	   classe      varchar2(20) not null,
	   nro_voo    number(8) not null,
	   valor      number(10,2),
	   constraint pk_tarifa primary key (classe, nro_voo),
	   constraint fk_voo_tarifa foreign key (nro_voo)
		  references voo(numero) on delete cascade, 
	   constraint ck_classe_tarifa check (classe in ('ECONOMICA', 'EXECUTIVA', 'PRIMEIRA CLASSE'))      
	);

	-- Tabela Trecho_do_Voo
	create table trecho_voo (
	   nro_trecho             number(5) not null,
	   nro_voo                number(8) not null,
	   aeroporto_partida      varchar2(3) not null,
	   hora_partida           date,
	   aeroporto_chegada      varchar2(3) not null,
	   hora_chegada           date,
	   constraint pk_trecho_voo primary key (nro_trecho, nro_voo),
	   constraint fk_voo_trecho_voo foreign key (nro_voo)
		  references voo(numero) on delete cascade,
	   constraint fk_aeroporto_trechovoo_partida foreign key (aeroporto_partida)
		  references aeroporto(codigo) on delete cascade,
	   constraint fk_aeroporto_trechovoo_chegada foreign key (aeroporto_chegada)
		  references aeroporto(codigo) on delete cascade
	);

	-- Tabela Instancia_Trecho
	create table instancia_trecho (
	   data               date not null,
	   nro_trecho         number(5) not null,
	   nro_voo            number(8) not null,
	   poltronas_disponiveis  number(3),
	   aeroporto_chegada   varchar2(3),
	   hora_chegada        date,
	   aeroporto_partida   varchar2(3),
	   hora_partida        date,
	   id_aviao            number,
	   constraint pk_instancia_trecho primary key (data, nro_trecho, nro_voo),
	   constraint fk_trechovoo_insttrecho foreign key (nro_trecho, nro_voo)
		  references trecho_voo(nro_trecho, nro_voo) on delete cascade,
	   constraint fk_aeroporto_inst_chegada foreign key (aeroporto_chegada)
		  references aeroporto(codigo) on delete cascade,
	   constraint fk_aeroporto_inst_partida foreign key (aeroporto_partida)
		  references aeroporto(codigo) on delete cascade,
	   constraint fk_aviao_insttrecho foreign key (id_aviao)
		  references aviao(id_aviao) on delete cascade   
	);

	-- Tabela Poltrona
	create table poltrona (
	   id_aviao             number not null,
	   nro_poltrona         number(4) not null,
	   classe               varchar2(20) not null,
	   constraint pk_poltrona primary key (id_aviao, nro_poltrona),
	   constraint fk_aviao_poltrona foreign key (id_aviao)
		  references aviao(id_aviao) on delete cascade,
	   constraint ck_classe_poltrona check (classe in ('ECONOMICA', 'EXECUTIVA', 'PRIMEIRA CLASSE'))      
	);


	-- Tabela Reserva
	create table reserva (
	   id_reserva           number not null, 
	   id_aviao             number not null,
	   nro_poltrona         number(4) not null,
	   data                 date not null,
	   nro_trecho           number(5) not null,
	   nro_voo             number(8) not null,
	   cliente             varchar2(65) not null,
	   cpf                 varchar2(15) not null, 
	   fone                number(15),
	   constraint pk_reserva primary key (id_reserva),
	   constraint un_reserva unique (id_aviao, nro_poltrona, data, nro_trecho, nro_voo),
	   constraint fk_insttrecho_reserva foreign key (data, nro_trecho, nro_voo)
		 references instancia_trecho (data, nro_trecho, nro_voo) on delete cascade,
	   constraint fk_poltrona_reserva foreign key (id_aviao, nro_poltrona)
		  references poltrona(id_aviao, nro_poltrona) on delete cascade 
	);

	-- Tabela Servi?o
	create table servico (
	   codigo          number not null,
	   data            date not null,
	   id_aviao         number(4) not null,
	   empregado        number(15) not null,
	   nro_horas        number(5,2),
	   constraint pk_servico primary key (codigo),
	   constraint fk_aviao_servico foreign key (id_aviao)
		  references aviao(id_aviao) on delete cascade,
	   constraint fk_empregado_servico foreign key (empregado)
		  references empregado(cpf) on delete cascade, 
	   constraint un_servico unique (id_aviao, data, empregado)   
	);

	-- Tabela Pode_Aterrissar
	create table pode_aterrissar (
	   aeroporto    varchar2(3) not null,
	   tipo_aviao   varchar2(20) not null,
	   constraint pk_pode_aterrissar primary key (aeroporto, tipo_aviao),
	   constraint fk_aeroporto_pode_aterrissar foreign key (aeroporto)
		  references aeroporto(codigo) on delete cascade,
	   constraint fk_tipo_aviao_pode_aterrissar foreign key (tipo_aviao)
		  references tipo_aviao(nome) on delete cascade   
	);

	-- Tabela Voa
	create table voa (
	   tipo_aviao varchar2(20) not null, 
	   piloto     number(15) not null,
	   constraint pk_voa primary key (piloto, tipo_aviao),
	   constraint fk_piloto_voa foreign key (piloto)
		  references piloto(cpf) on delete cascade,
	   constraint fk_tipo_aviao_voa foreign key (tipo_aviao)
		  references tipo_aviao(nome) on delete cascade   
	);


	-- Tabela Pode_Trabalhar
	create table pode_trabalhar (
	   tipo_aviao  varchar2(20) not null,
	   empregado   number(15) not null,
	   constraint pk_pode_trabalhar primary key (empregado, tipo_aviao),
	   constraint fk_empregado_pode_trabalhar foreign key (empregado)
		  references empregado(cpf) on delete cascade,
	   constraint fk_tipoaviao_pode_trabalhar foreign key (tipo_aviao)
		  references tipo_aviao(nome) on delete cascade   
	);

	-- Tabela Problemas
	create table problemas (
	  servico     number not null, 
	  problema    varchar2(100) not null, 
	  solucao     varchar2(100), 
	  constraint pk_problemas primary key (servico, problema),
	  constraint fk_servico_problemas foreign key (servico)
		  references servico (codigo) on delete cascade
	);







	-- Tabela Aeroporto
	/*create table  aeroporto (
	   codigo       varchar2(3) not null,
	   nome         varchar2(65) not null,
	   cidade       varchar2(50) not null,
	   estado       varchar2(50) not null,
	   constraint pk_aeroporto primary key (codigo)
	);*/
	INSERT INTO aeroporto VALUES ('BBE', 'Aeroporto Internacional de Bel?m', 'Bel?m', 'Par?');
	INSERT INTO aeroporto VALUES ('BCJ', 'Aeroporto de Caraj?s', 'Parauapebas', 'Par?');
	INSERT INTO aeroporto VALUES ('BHT', 'Aeroporto de Altamira', 'Altamira', 'Par?');
	INSERT INTO aeroporto VALUES ('BIZ', 'Aeroporto de Imperatiz', 'Imperatriz', 'Maranh?o');
	INSERT INTO aeroporto VALUES ('BJC', 'Aeroporto J?lio C?sar', 'Bel?m', 'Par?');
	INSERT INTO aeroporto VALUES ('BMA', 'Aeroporto de Marab?', 'Marab?', 'Par?');
	INSERT INTO aeroporto VALUES ('BMQ', 'Aeroporto Internacional de Macap?', 'Macap?', 'Amap?');
	INSERT INTO aeroporto VALUES ('BSL', 'Aeroporto Internacional de S?o Luiz', 'S?o Luiz', 'Maranh?o');
	INSERT INTO aeroporto VALUES ('BSN', 'Aeroporto de Santar?m', 'Santar?m', 'Par?');
	INSERT INTO aeroporto VALUES ('BBR', 'Aeroporto Internacional de Bras?lia', 'Bras?lia', 'Distrito Federal');
	INSERT INTO aeroporto VALUES ('BCY', 'Aeroporto Internacional de Cuiab?', 'Cuiab?', 'Mato Grosso');
	INSERT INTO aeroporto VALUES ('BGO', 'Aeroporto de Goi?nia', 'Goi?nia', 'Goi?s');
	INSERT INTO aeroporto VALUES ('BPJ', 'Aeroporto de Palmas', 'Palmas', 'Tocantins');
	INSERT INTO aeroporto VALUES ('BUL', 'Aeroporto de Uberl?ndia', 'Uberl?ndia', 'Minas Gerais');
	INSERT INTO aeroporto VALUES ('BUR', 'Aeroporto de Uberaba', 'Uberaba', 'Minas Gerais');
	INSERT INTO aeroporto VALUES ('BBV', 'Aeroporto Internacional de Boa Vista', 'Boa Vista', 'Roraima');
	INSERT INTO aeroporto VALUES ('BCZ', 'Aeroporto Internacional de Cruzeiro do Sul', 'Cruzeiro do Sul', 'Acre');
	INSERT INTO aeroporto VALUES ('BEG', 'Aeroporto Internacional de Manaus', 'Manaus', 'Amazonas');
	INSERT INTO aeroporto VALUES ('BPV', 'Aeroporto Internacional de Porto Velho', 'Porto Velho', 'Rond?nia');
	INSERT INTO aeroporto VALUES ('BRB', 'Aeroporto Internacional de Rio Branco', 'Rio Branco', 'Acre');
	INSERT INTO aeroporto VALUES ('BTF', 'Aeroporto de Tef?', 'Tef?', 'Amazonas');
	INSERT INTO aeroporto VALUES ('BTT', 'Aeroporto Internacional de Tabatinga', 'Tabatinga', 'Amazonas');
	INSERT INTO aeroporto VALUES ('BBG', 'Aeroporto Internacional de Bag?', 'Bag?', 'Rio Grande do Sul');
	INSERT INTO aeroporto VALUES ('BBI', 'Aeroporto de Bacacheri', 'Curitiba', 'Paran?');
	INSERT INTO aeroporto VALUES ('BCT', 'Aeroporto Internacional de Curitiba', 'Curitiba', 'Paran?');
	INSERT INTO aeroporto VALUES ('BFI', 'Aeroporto Internacional de Foz do Igua?u', 'Foz do Igua?u', 'Paran?');
	INSERT INTO aeroporto VALUES ('BFL', 'Aeroporto Internacional de Florian?polis', 'Florian?polis', 'Santa Catarina');
	INSERT INTO aeroporto VALUES ('BJV', 'Aeroporto de Joinville', 'Joinville', 'Santa Catarina');
	INSERT INTO aeroporto VALUES ('BLO', 'Aeroporto de Londrina', 'Londrina', 'Paran?');
	INSERT INTO aeroporto VALUES ('BNF', 'Aeroporto de Navegantes', 'Navegantes', 'Santa Catarina');
	INSERT INTO aeroporto VALUES ('BPA', 'Aeroporto Internacional de Porto Alegre', 'Porto Alegre', 'Rio Grande do Sul');
	INSERT INTO aeroporto VALUES ('BPK', 'Aeroporto Internacional de Pelotas', 'Pelotas', 'Rio Grande do Sul');
	INSERT INTO aeroporto VALUES ('BUG', 'Aeroporto Internacional de Uruguaiana', 'Uruguaiana', 'Rio Grande do Sul');
	INSERT INTO aeroporto VALUES ('BFZ', 'Aeroporto Internacional de Fortaleza', 'Fortaleza', 'Cear?');
	INSERT INTO aeroporto VALUES ('BJP', 'Aeroporto Internacional de Jo?o Pessoa', 'Jo?o Pessoa', 'Para?ba');
	INSERT INTO aeroporto VALUES ('BJU', 'Aeroporto de Juazeiro do Norte', 'Juazeiro do Norte', 'Cear?');
	INSERT INTO aeroporto VALUES ('BKG', 'Aeroporto de Campina Grande', 'Campina Grande', 'Para?ba');
	INSERT INTO aeroporto VALUES ('BMO', 'Aeroporto Internacional de Macei?', 'Macei?', 'Alagoas');
	INSERT INTO aeroporto VALUES ('BNT', 'Aeroporto Internacional de Natal', 'Parnamirim', 'Rio Grande do Norte');
	INSERT INTO aeroporto VALUES ('BPL', 'Aeroporto de Petrolina', 'Petrolina', 'Pernambuco');
	INSERT INTO aeroporto VALUES ('BRF', 'Aeroporto Internacional de Recife', 'Recife', 'Pernambuco');
	INSERT INTO aeroporto VALUES ('BTE', 'Aeroporto Teresina', 'Teresina', 'Piaui');
	INSERT INTO aeroporto VALUES ('BPB', 'Aeroporto Internacional de Parna?ba', 'Parna?ba', 'Piaui');
	INSERT INTO aeroporto VALUES ('BBH', 'Aeroporto da Pampulha', 'Belo Horizonte', 'Minas Gerais');
	INSERT INTO aeroporto VALUES ('BCF', 'Aeroporto Internacional de Confins', 'Belo Horizonte', 'Minas Gerais');
	INSERT INTO aeroporto VALUES ('BCP', 'Aeroporto de Campos', 'Campos de Goytacazes', 'Rio de Janeiro');
	INSERT INTO aeroporto VALUES ('BGL', 'Aeroporto Internacional do Gale?o', 'Rio de Janeiro', 'Rio de Janeiro');
	INSERT INTO aeroporto VALUES ('BJF', 'Aeroporto de Juiz de Fora', 'Juiz de Fora', 'Minas Gerais');
	INSERT INTO aeroporto VALUES ('BJR', 'Aeroporto de Jacarepagu?', 'Rio de Janeiro', 'Rio de Janeiro');
	INSERT INTO aeroporto VALUES ('BME', 'Aeroporto de Maca?', 'Rio de Janeiro', 'Rio de Janeiro');
	INSERT INTO aeroporto VALUES ('BMK', 'Aeroporto de Montes Claros', 'Montes Claros', 'Minas Gerais');
	INSERT INTO aeroporto VALUES ('BRJ', 'Aeroporto Santos Dumont', 'Rio de Janeiro', 'Rio de Janeiro');
	INSERT INTO aeroporto VALUES ('BVT', 'Aeroporto de Vit?ria', 'Vit?ria', 'Espirito Santo');
	INSERT INTO aeroporto VALUES ('BPR', 'Aeroporto Carlos Prates', 'Belo Horizonte', 'Minas Gerais');
	INSERT INTO aeroporto VALUES ('BCG', 'Aeroporto Internacional de Campo Grande', 'Campo Grande', 'Mato Grosso do Sul');
	INSERT INTO aeroporto VALUES ('BCR', 'Aeroporto Internacional de Corumb?', 'Corumb?', 'Mato Grosso do Sul');
	INSERT INTO aeroporto VALUES ('BGR', 'Aeroporto Internacional de Guarulhos', 'S?o Paulo', 'S?o Paulo');
	INSERT INTO aeroporto VALUES ('BKP', 'Aeroporto Internacional de Viracopos', 'Campinas', 'S?o Paulo');
	INSERT INTO aeroporto VALUES ('BMT', 'Aeroporto Campo de Marte', 'S?o Paulo', 'S?o Paulo');
	INSERT INTO aeroporto VALUES ('BPP', 'Aeroporto Internacional de Ponta Por?', 'Ponta Por?', 'Mato Grosso do Sul');
	INSERT INTO aeroporto VALUES ('BSJ', 'Aeroporto de S?o Jos? dos Campos', 'S?o Jos? dos Campos', 'S?o Paulo');
	INSERT INTO aeroporto VALUES ('BSP', 'Aeroporto Internacional de Congonhas', 'S?o Paulo', 'S?o Paulo');
	INSERT INTO aeroporto VALUES ('BAR', 'Aeroporto de Aracaju', 'Aracaju', 'Sergipe');
	INSERT INTO aeroporto VALUES ('BIL', 'Aeroporto de Ilh?us', 'Ilh?us', 'Bahia');
	INSERT INTO aeroporto VALUES ('BSV', 'Aeroporto Internacional de Salvador', 'Salvador', 'Bahia');
	INSERT INTO aeroporto VALUES ('BUF', 'Aeroporto Paulo Afonso', 'Paulo Afonso', 'Bahia');

	-- Tabela Voo
	/*create table voo (
	   numero          number(8) not null,
	   dia_semana      varchar2(8) not null,
	   companhia_aerea  varchar2(30) not null,
	   constraint pk_voo primary key (numero),
	   constraint ck_voo_dia check (dia_semana in ('DOMINGO','SEGUNDA', 'TERCA', 'QUARTA',
												   'QUINTA', 'SEXTA', 'SABADO'))
	);*/
	INSERT INTO voo VALUES (2201, 'DOMINGO', 'Varig');
	INSERT INTO voo VALUES (7464, 'DOMINGO', 'Gol');
	INSERT INTO voo VALUES (9844, 'DOMINGO', 'TAM');
	INSERT INTO voo VALUES (3497, 'DOMINGO', 'TAM');
	INSERT INTO voo VALUES (9820, 'DOMINGO', 'Varig');
	INSERT INTO voo VALUES (3365, 'DOMINGO', 'TAM');
	INSERT INTO voo VALUES (1753, 'DOMINGO', 'Gol');
	INSERT INTO voo VALUES (1800, 'DOMINGO', 'Gol');
	INSERT INTO voo VALUES (1661, 'DOMINGO', 'Gol');
	INSERT INTO voo VALUES (8640, 'SEGUNDA', 'Varig');
	INSERT INTO voo VALUES (7671, 'SEGUNDA', 'American Airlines');
	INSERT INTO voo VALUES (3150, 'SEGUNDA', 'TAM');
	INSERT INTO voo VALUES (7674, 'SEGUNDA', 'American Airlines');
	INSERT INTO voo VALUES (3342, 'SEGUNDA', 'TAM');
	INSERT INTO voo VALUES (7465, 'SEGUNDA', 'Gol');
	INSERT INTO voo VALUES (0700, 'SEGUNDA', 'Copa Airlines');
	INSERT INTO voo VALUES (3867, 'SEGUNDA', 'TAM');
	INSERT INTO voo VALUES (8461, 'SEGUNDA', 'TAM');
	INSERT INTO voo VALUES (1663, 'SEGUNDA', 'Gol');
	INSERT INTO voo VALUES (3866, 'TERCA', 'TAM');
	INSERT INTO voo VALUES (1662, 'TERCA', 'Gol');
	INSERT INTO voo VALUES (3237, 'TERCA', 'TAM');
	INSERT INTO voo VALUES (0758, 'TERCA', 'Copa Airlines');
	INSERT INTO voo VALUES (8741, 'TERCA', 'Varig');
	INSERT INTO voo VALUES (3364, 'TERCA', 'TAM');
	INSERT INTO voo VALUES (1803, 'TERCA', 'Gol');
	INSERT INTO voo VALUES (2347, 'TERCA', 'Varig');
	INSERT INTO voo VALUES (0951, 'TERCA', 'American Airlines');
	INSERT INTO voo VALUES (7665, 'TERCA', 'American Airlines');
	INSERT INTO voo VALUES (8796, 'QUARTA', 'Copa Airlines');
	INSERT INTO voo VALUES (2039, 'QUARTA', 'Varig');
	INSERT INTO voo VALUES (5610, 'QUARTA', 'TAM');
	INSERT INTO voo VALUES (5600, 'QUARTA', 'TAM');
	INSERT INTO voo VALUES (3101, 'QUARTA', 'TAM');
	INSERT INTO voo VALUES (1733, 'QUARTA', 'Gol');
	INSERT INTO voo VALUES (7455, 'QUINTA', 'Gol');
	INSERT INTO voo VALUES (0014, 'QUINTA', 'Aerom?xico');
	INSERT INTO voo VALUES (7664, 'QUINTA', 'American Airlines');
	INSERT INTO voo VALUES (8000, 'QUINTA', 'TAM');
	INSERT INTO voo VALUES (8026, 'QUINTA', 'TAM');
	INSERT INTO voo VALUES (1658, 'QUINTA', 'Gol');
	INSERT INTO voo VALUES (2373, 'SEXTA', 'Varig');
	INSERT INTO voo VALUES (1660, 'SEXTA', 'Gol');
	INSERT INTO voo VALUES (2129, 'SEXTA', 'Varig');
	INSERT INTO voo VALUES (7656, 'SEXTA', 'American Airlines');
	INSERT INTO voo VALUES (0907, 'SEXTA', 'American Airlines');
	INSERT INTO voo VALUES (3506, 'SEXTA', 'TAM');
	INSERT INTO voo VALUES (8795, 'SABADO', 'Copa Airlines');
	INSERT INTO voo VALUES (0759, 'SABADO', 'Copa Airlines');
	INSERT INTO voo VALUES (5603, 'SABADO', 'TAM');
	INSERT INTO voo VALUES (7659, 'SABADO', 'American Airlines');
	INSERT INTO voo VALUES (0015, 'SABADO', 'Aerom?xico');
	INSERT INTO voo VALUES (8740, 'SABADO', 'Varig');

	-- Tabela Tipo_Avi?o
	/*create table tipo_aviao (
	   nome           varchar2(60) not null,
	   max_poltronas   number(3),
	   empresa         varchar2(100) not null,
	   constraint pk_tipo_aviao primary key (nome)
	);*/
	INSERT INTO tipo_aviao VALUES ('Airbus 330', 421, 'Airbus Industrie');
	INSERT INTO tipo_aviao VALUES ('Airbus 320', 324, 'Airbus Industrie');
	INSERT INTO tipo_aviao VALUES ('Airbus 319', 138, 'Airbus Industrie');
	INSERT INTO tipo_aviao VALUES ('Fokker 100', 108, 'Fokker Aircraft B.V.');
	INSERT INTO tipo_aviao VALUES ('Boeing 737-300', 136, 'Boeing Commercial Airplanes');
	INSERT INTO tipo_aviao VALUES ('Boeing 737-400', 156, 'Boeing Commercial Airplanes');
	INSERT INTO tipo_aviao VALUES ('Boeing 737-500', 120, 'Boeing Commercial Airplanes');
	INSERT INTO tipo_aviao VALUES ('Boeing 737-700', 136, 'Boeing Commercial Airplanes');
	INSERT INTO tipo_aviao VALUES ('Boeing 737-800', 164, 'Boeing Commercial Airplanes');
	INSERT INTO tipo_aviao VALUES ('Boeing 757-200', 184, 'Boeing Commercial Airplanes');
	INSERT INTO tipo_aviao VALUES ('Boeing 767-300', 221, 'Boeing Commercial Airplanes');
	INSERT INTO tipo_aviao VALUES ('Boeing 777 Grupo 1', 285, 'Boeing Commercial Airplanes');
	INSERT INTO tipo_aviao VALUES ('Boeing 777 Grupo 2', 240, 'Boeing Commercial Airplanes');
	INSERT INTO tipo_aviao VALUES ('Boeing 777 Grupo 3', 276, 'Boeing Commercial Airplanes');
	INSERT INTO tipo_aviao VALUES ('MD-11 Grupo 1', 289, 'Boeing Commercial Airplanes');
	INSERT INTO tipo_aviao VALUES ('MD-11 Grupo 2', 284, 'Boeing Commercial Airplanes');
	INSERT INTO tipo_aviao VALUES ('ERJ-145', 50, 'Embraer - Empresa Brasileira de Aeron?utica S.A');
	INSERT INTO tipo_aviao VALUES ('ERJ-140', 44, 'Embraer - Empresa Brasileira de Aeron?utica S.A');
	INSERT INTO tipo_aviao VALUES ('ERJ-135', 37, 'Embraer - Empresa Brasileira de Aeron?utica S.A');
	INSERT INTO tipo_aviao VALUES ('Embraer 190', 94, 'Embraer - Empresa Brasileira de Aeron?utica S.A');


	-- Tabela Avi?o
	/*create table aviao (
	   id_aviao         number not null,
	   total_poltronas  number(3),
	   nro_registro     number(10) not null,
	   tipo_aviao       varchar2(20) not null,
	   constraint pk_aviao primary key (id_aviao),
	   constraint fk_tipoaviao_aviao foreign key (tipo_aviao) 
		  references tipo_aviao (nome) on delete cascade,
	   constraint un_aviao_registro unique (nro_registro)   
	);*/
	INSERT INTO aviao VALUES (0, 94, 123456, 'Embraer 190'); 
	INSERT INTO aviao VALUES (seq_aviao.nextval, 50, 123489, 'ERJ-145');
	INSERT INTO aviao VALUES (seq_aviao.nextval, 37, 123475, 'ERJ-135');
	INSERT INTO aviao VALUES (seq_aviao.nextval, 44, 123458, 'ERJ-140');
	INSERT INTO aviao VALUES (seq_aviao.nextval, 44, 123459, 'ERJ-140');
	INSERT INTO aviao VALUES (seq_aviao.nextval, 50, 123490, 'ERJ-145');
	INSERT INTO aviao VALUES (seq_aviao.nextval, 37, 123476, 'ERJ-135');
	INSERT INTO aviao VALUES (seq_aviao.nextval, 94, 123457, 'Embraer 190');
	INSERT INTO aviao VALUES (seq_aviao.nextval, 421, 987654, 'Airbus 330');
	INSERT INTO aviao VALUES (seq_aviao.nextval, 324, 987632, 'Airbus 320');
	INSERT INTO aviao VALUES (seq_aviao.nextval, 285, 456782, 'Boeing 777 Grupo 1');
	INSERT INTO aviao VALUES (seq_aviao.nextval, 285, 456783, 'Boeing 777 Grupo 1');
	INSERT INTO aviao VALUES (seq_aviao.nextval, 136, 456732, 'Boeing 737-300');


	-- Tabela Pessoa
	/*create table pessoa (
	   cpf          number(15) not null,
	   nome         varchar2(65) not null,
	   rua          varchar2(50),
	   nro          number(5),
	   cidade       varchar2(30),
	   estado       varchar2(2),
	   cep          varchar2(10), 
	   foto         blob,
	   tipo         varchar2(10),
	   constraint pk_pessoa primary key (cpf),
	   constraint ck_tipo_pessoa check (tipo in ('PILOTO', 'EMPREGADO'))
	);*/
	INSERT INTO pessoa VALUES (12345678910, 'Alina de Almeida', 'Rua das Flores', 129, 'Campestre do Maranh?o', 'MA', '89675256', EMPTY_BLOB(), 'EMPREGADO');
	INSERT INTO pessoa VALUES (54423523523, 'Bruno Tavares', 'Rua General Os?rio', 1230, 'S?o Jos? dos Campos', 'SP', '17892123', EMPTY_BLOB(), 'PILOTO');
	INSERT INTO pessoa VALUES (56456456456, 'Carlos dos Santos', 'Avenida Brasil', 2345, 'Campinas', 'SP', '13456098', EMPTY_BLOB(), 'PILOTO');
	INSERT INTO pessoa VALUES (65675646335, 'Daniela Braga', 'Rua Dona Esmeraldina', 37, 'Belo Horizonte', 'MG', '45623654', EMPTY_BLOB(), 'EMPREGADO');
	INSERT INTO pessoa VALUES (24525346565, 'Erasmo Caetano', 'Rua Benjamim Constant', 129, 'S?o Paulo', 'SP', '2340945', EMPTY_BLOB(), 'EMPREGADO');
	INSERT INTO pessoa VALUES (53454565466, 'Fiona Cervantes', 'Rua Sete e Setembro', 390, 'S?o Paulo', 'SP', '10998987', EMPTY_BLOB(), 'PILOTO');


	-- Tabela Telefones
	/*create table telefones (
	   cpf          number(15) not null,
	   fone         varchar2(15) not null,
	   constraint pk_telefones primary key (cpf, fone),
	   constraint fk_pessoa_telefones foreign key (cpf) 
			references pessoa (cpf) on delete cascade
	);*/

	INSERT INTO telefones VALUES (12345678910, '(99)5342-6865');
	INSERT INTO telefones VALUES (54423523523, '(11)5643-2354');
	INSERT INTO telefones VALUES (56456456456, '(19)5345-3456');
	INSERT INTO telefones VALUES (65675646335, '(31)6453-2342');
	INSERT INTO telefones VALUES (24525346565, '(11)5423-2341');
	INSERT INTO telefones VALUES (53454565466, '(11)2345-5343');


	-- Tabela Piloto
	/*create table piloto (
	   cpf          number(15) not null,
	   nro_licenca  number(10) not null,
	   horas_voo    number(5),
	   constraint pk_piloto primary key (cpf),
	   constraint fk_pessoa_piloto foreign key (cpf)
		  references pessoa (cpf) on delete cascade,
	   constraint un_piloto_nro_licenca unique (nro_licenca)   
	);*/
	--piloto(cpfpessoa, numlicenca, horasvoo)
	INSERT INTO piloto VALUES (54423523523, 58246, 36024);
	INSERT INTO piloto VALUES (56456456456, 75426, 78002);
	INSERT INTO piloto VALUES (53454565466, 92143, 10236);

	-- Tabela Empregado
	/*create table empregado (
	   cpf        number(15) not null,
	   salario    number(10,2),
	   turno      varchar2(11) default 'DIURNO',
	   constraint pk_empregado primary key (cpf),
	   constraint fk_pessoa_empregado foreign key (cpf)
		  references pessoa (cpf) on delete cascade,
	   constraint ck_turno check (turno in ('DIURNO', 'VESPERTINO', 'NOTURNO'))   
	);*/
	INSERT INTO empregado VALUES (12345678910, 400.00, 'NOTURNO');
	INSERT INTO empregado VALUES (65675646335, 1500.00, 'DIURNO');
	INSERT INTO empregado VALUES (24525346565, 2500.00, 'VESPERTINO');

	-- Tabela Tarifa
	/*create table tarifa (
	   classe      varchar2(20) not null,
	   nro_voo    number(8) not null,
	   valor      number(10,2),
	   constraint pk_tarifa primary key (classe, nro_voo),
	   constraint fk_voo_tarifa foreign key (nro_voo)
		  references voo(numero) on delete cascade, 
	   constraint ck_classe_tarifa check (classe in ('ECONOMICA', 'EXECUTIVA', 'PRIMEIRA CLASSE'))      
	);*/
	INSERT INTO tarifa VALUES ('ECONOMICA', 2201, 199.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 7464, 199.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 9844, 239.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 3497, 239.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 9820, 257.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 3365, 257.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 1753, 139.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 1800, 139.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 1661, 143.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 8640, 142.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 7671, 147.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 3150, 231.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 7674, 149.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 3342, 199.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 7465, 147.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 0700, 123.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 3867, 149.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 8461, 150.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 1663, 151.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 3866, 152.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 1662, 256.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 3237, 212.00);
	INSERT INTO tarifa VALUES ('ECONOMICA', 0758, 146.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 8741, 456.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 3364, 521.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 1803, 411.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 2347, 410.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 0951, 456.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 7665, 498.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 8796, 520.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 2039, 513.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 5610, 426.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 5600, 415.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 3101, 485.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 1733, 456.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 7455, 487.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 0014, 587.00);
	INSERT INTO tarifa VALUES ('EXECUTIVA', 7664, 595.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 8000, 740.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 8026, 785.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 1658, 741.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 2373, 845.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 1660, 854.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 2129, 759.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 7656, 774.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 0907, 810.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 3506, 822.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 8795, 863.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 0759, 745.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 5603, 736.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 7659, 714.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 0015, 856.00);
	INSERT INTO tarifa VALUES ('PRIMEIRA CLASSE', 8740, 810.00);

	-- Tabela Trecho_do_Voo
	/*create table trecho_voo (
	   nro_trecho             number(5) not null,
	   nro_voo                number(8) not null,
	   aeroporto_partida      varchar2(3) not null,
	   hora_partida           date,
	   aeroporto_chegada      varchar2(3) not null,
	   hora_chegada           date,
	   constraint pk_trecho_voo primary key (nro_trecho, nro_voo),
	   constraint fk_voo_trecho_voo foreign key (nro_voo)
		  references voo(numero) on delete cascade,
	   constraint fk_aeroporto_trechovoo_partida foreign key (aeroporto_partida)
		  references aeroporto(codigo) on delete cascade,
	   constraint fk_aeroporto_trechovoo_chegada foreign key (aeroporto_chegada)
		  references aeroporto(codigo) on delete cascade
	);*/
	INSERT INTO trecho_voo VALUES (1258, 5610, 'BGR', to_date('14:00', 'hh24:mi'), 'BGL', to_date('15:05', 'hh24:mi'));
	INSERT INTO trecho_voo VALUES (3586, 0951, 'BGR', to_date('09:20', 'hh24:mi'), 'BRF', to_date('13:30', 'hh24:mi'));
	INSERT INTO trecho_voo VALUES (6248, 0700, 'BGR', to_date('13:15', 'hh24:mi'), 'BCT', to_date('14:59', 'hh24:mi'));
	INSERT INTO trecho_voo VALUES (9324, 2039, 'BBH', to_date('06:20', 'hh24:mi'), 'BGR', to_date('10:05', 'hh24:mi'));
	INSERT INTO trecho_voo VALUES (9324, 5603, 'BBH', to_date('20:30', 'hh24:mi'), 'BUR', to_date('23:15', 'hh24:mi'));
	INSERT INTO trecho_voo VALUES (8645, 7656, 'BFL', to_date('17:00', 'hh24:mi'), 'BGR', to_date('21:02', 'hh24:mi'));
	INSERT INTO trecho_voo VALUES (5247, 0014, 'BKG', to_date('09:40', 'hh24:mi'), 'BGR', to_date('13:35', 'hh24:mi'));
	INSERT INTO trecho_voo VALUES (5274, 3365, 'BBH', to_date('19:25', 'hh24:mi'), 'BBR', to_date('23:05', 'hh24:mi'));
	INSERT INTO trecho_voo VALUES (6348, 2201, 'BBH', to_date('23:00', 'hh24:mi'), 'BUG', to_date('05:45', 'hh24:mi'));
	INSERT INTO trecho_voo VALUES (4273, 8796, 'BMT', to_date('03:29', 'hh24:mi'), 'BPL', to_date('10:43', 'hh24:mi'));


	-- Tabela Instancia_Trecho
	/*create table instancia_trecho (
	   data               date not null,
	   nro_trecho         number(5) not null,
	   nro_voo            number(8) not null,
	   poltronas_disponiveis  number(3),
	   aeroporto_chegada   varchar2(3),
	   hora_chegada        date,
	   aeroporto_partida   varchar2(3),
	   hora_partida        date,
	   id_aviao            number,
	   constraint pk_instancia_trecho primary key (data, nro_trecho, nro_voo),
	   constraint fk_trechovoo_insttrecho foreign key (nro_trecho, nro_voo)
		  references trecho_voo(nro_trecho, nro_voo) on delete cascade,
	   constraint fk_aeroporto_inst_chegada foreign key (aeroporto_chegada)
		  references aeroporto(codigo) on delete cascade,
	   constraint fk_aeroporto_inst_partida foreign key (aeroporto_partida)
		  references aeroporto(codigo) on delete cascade,
	   constraint fk_aviao_insttrecho foreign key (id_aviao)
		  references aviao(id_aviao) on delete cascade   
	);*/
	INSERT INTO instancia_trecho VALUES (to_date('05/08/2010', 'dd/mm/yyyy'), 4273, 8796, 10, 'BPL', to_date('05/08/2010 10:43', 'dd/mm/yyyy hh24:mi'), 'BMT', to_date('05/08/2010 03:29', 'dd/mm/yyyy hh24:mi'), 1);
	INSERT INTO instancia_trecho VALUES (to_date('29/08/2010', 'dd/mm/yyyy'), 6348, 2201, 15, 'BUG', to_date('30/08/2010 05:45', 'dd/mm/yyyy hh24:mi'), 'BBH', to_date('29/08/2010 23:00', 'dd/mm/yyyy hh24:mi'), 2);
	INSERT INTO instancia_trecho VALUES (to_date('22/08/2010', 'dd/mm/yyyy'), 5274, 3365, 19, 'BBR', to_date('22/08/2010 23:05', 'dd/mm/yyyy hh24:mi'), 'BBH', to_date('22/08/2010 19:25', 'dd/mm/yyyy hh24:mi'), 2);
	INSERT INTO instancia_trecho VALUES (to_date('31/08/2010', 'dd/mm/yyyy'), 5247, 0014, 05, 'BGR', to_date('31/08/2010 13:35', 'dd/mm/yyyy hh24:mi'), 'BKG', to_date('31/08/2010 09:40', 'dd/mm/yyyy hh24:mi'), 3);
	INSERT INTO instancia_trecho VALUES (to_date('18/08/2010', 'dd/mm/yyyy'), 8645, 7656, 01, 'BGR', to_date('18/08/2010 21:02', 'dd/mm/yyyy hh24:mi'), 'BFL', to_date('18/08/2010 17:00', 'dd/mm/yyyy hh24:mi'), 3);
	INSERT INTO instancia_trecho VALUES (to_date('26/08/2010', 'dd/mm/yyyy'), 9324, 5603, 20, 'BUR', to_date('26/08/2010 23:15', 'dd/mm/yyyy hh24:mi'), 'BBH', to_date('26/08/2010 20:30', 'dd/mm/yyyy hh24:mi'), 4);
	INSERT INTO instancia_trecho VALUES (to_date('30/08/2010', 'dd/mm/yyyy'), 9324, 2039, 08, 'BGR', to_date('30/08/2010 10:05', 'dd/mm/yyyy hh24:mi'), 'BBH', to_date('30/08/2010 06:20', 'dd/mm/yyyy hh24:mi'), 5);
	INSERT INTO instancia_trecho VALUES (to_date('21/08/2010', 'dd/mm/yyyy'), 6248, 0700, 03, 'BCT', to_date('21/08/2010 14:59', 'dd/mm/yyyy hh24:mi'), 'BGR', to_date('21/08/2010 13:15', 'dd/mm/yyyy hh24:mi'), 1);
	INSERT INTO instancia_trecho VALUES (to_date('22/08/2010', 'dd/mm/yyyy'), 3586, 0951, 06, 'BRF', to_date('22/08/2010 13:30', 'dd/mm/yyyy hh24:mi'), 'BGR', to_date('22/08/2010 09:20', 'dd/mm/yyyy hh24:mi'), 2);
	INSERT INTO instancia_trecho VALUES (to_date('21/08/2010', 'dd/mm/yyyy'), 1258, 5610, 16, 'BGL', to_date('21/08/2010 15:05', 'dd/mm/yyyy hh24:mi'), 'BGR', to_date('21/08/2010 14:00', 'dd/mm/yyyy hh24:mi'), 3);


	-- Tabela Poltrona
	/*create table poltrona (
	   id_aviao             number not null,
	   nro_poltrona         number(4) not null,
	   classe               varchar2(20) not null,
	   constraint pk_poltrona primary key (id_aviao, nro_poltrona),
	   constraint fk_aviao_poltrona foreign key (id_aviao)
		  references aviao(id_aviao) on delete cascade,
	   constraint ck_classe_poltrona check (classe in ('ECONOMICA', 'EXECUTIVA', 'PRIMEIRA CLASSE'))      
	);*/
	INSERT INTO poltrona VALUES (0, 10, 'ECONOMICA');
	INSERT INTO poltrona VALUES (0, 11, 'ECONOMICA');
	INSERT INTO poltrona VALUES (0, 12, 'ECONOMICA');

	-- Tabela Reserva
	/*create table reserva (
	   id_reserva           number not null, 
	   id_aviao             number not null,
	   nro_poltrona         number(4) not null,
	   data                 date not null,
	   nro_trecho           number(5) not null,
	   nro_voo             number(8) not null,
	   cliente             varchar2(65) not null,
	   cpf                 varchar2(15) not null, 
	   fone                number(15),
	   constraint pk_reserva primary key (id_reserva),
	   constraint un_reserva unique (id_aviao, nro_poltrona, data, nro_trecho, nro_voo),
	   constraint fk_insttrecho_reserva foreign key (data, nro_trecho, nro_voo)
		 references instancia_trecho (data, nro_trecho, nro_voo) on delete cascade,
	   constraint fk_poltrona_reserva foreign key (id_aviao, nro_poltrona)
		  references poltrona(id_aviao, nro_poltrona) on delete cascade 
	);*/
	INSERT INTO reserva VALUES (seq_reserva.nextval, 0, 10, to_date('05/08/2010', 'dd/mm/yyyy'), 4273, 8796, 'Maria Jos?', '15936514596', 1188451234);
	INSERT INTO reserva VALUES (seq_reserva.nextval, 0, 11, to_date('05/08/2010', 'dd/mm/yyyy'), 4273, 8796, 'Jo?o Silva', '45124856466', 1992348795);
	INSERT INTO reserva VALUES (seq_reserva.nextval, 0, 12, to_date('05/08/2010', 'dd/mm/yyyy'), 4273, 8796, 'M?rio Antunes', '54545575455', 1154545465);

	-- Tabela Servi?o
	/*create table servico (
	   codigo          number not null,
	   data            date not null,
	   id_aviao         number(4) not null,
	   empregado        number(15) not null,
	   nro_horas        number(5,2),
	   constraint pk_servico primary key (codigo),
	   constraint fk_aviao_servico foreign key (id_aviao)
		  references aviao(id_aviao) on delete cascade,
	   constraint fk_empregado_servico foreign key (empregado)
		  references empregado(cpf) on delete cascade, 
	   constraint un_servico unique (id_aviao, data, empregado)   
	);*/
	INSERT INTO servico VALUES (seq_servico.nextval, to_date('18/08/2010', 'dd/mm/yyyy'), 5, 12345678910, 15);
	INSERT INTO servico VALUES (seq_servico.nextval, to_date('30/08/2010', 'dd/mm/yyyy'), 3, 65675646335, 2);
	INSERT INTO servico VALUES (seq_servico.nextval, to_date('18/08/2010', 'dd/mm/yyyy'), 4, 24525346565, 14.5);

	-- Tabela Pode_Aterrissar
	/*create table pode_aterrissar (
	   aeroporto    varchar2(3) not null,
	   tipo_aviao   varchar2(20) not null,
	   constraint pk_pode_aterrissar primary key (aeroporto, tipo_aviao),
	   constraint fk_aeroporto_pode_aterrissar foreign key (aeroporto)
		  references aeroporto(codigo) on delete cascade,
	   constraint fk_tipo_aviao_pode_aterrissar foreign key (tipo_aviao)
		  references tipo_aviao(nome) on delete cascade   
	);*/
	INSERT INTO pode_aterrissar VALUES ('BPK', 'Airbus 330');
	INSERT INTO pode_aterrissar VALUES ('BBH', 'Boeing 777 Grupo 2');
	INSERT INTO pode_aterrissar VALUES ('BGR', 'ERJ-140');


	-- Tabela Voa
	/*create table voa (
	   tipo_aviao varchar2(20) not null, 
	   piloto     number(15) not null,
	   constraint pk_voa primary key (piloto, tipo_aviao),
	   constraint fk_piloto_voa foreign key (piloto)
		  references piloto(cpf) on delete cascade,
	   constraint fk_tipo_aviao_voa foreign key (tipo_aviao)
		  references tipo_aviao(nome) on delete cascade   
	);*/
	INSERT INTO voa VALUES ('Embraer 190', 54423523523);
	INSERT INTO voa VALUES ('ERJ-135', 53454565466);
	INSERT INTO voa VALUES ('MD-11 Grupo 1', 54423523523);


	-- Tabela Pode_Trabalhar
	/*create table pode_trabalhar (
	   tipo_aviao  varchar2(20) not null,
	   empregado   number(15) not null,
	   constraint pk_pode_trabalhar primary key (empregado, tipo_aviao),
	   constraint fk_empregado_pode_trabalhar foreign key (empregado)
		  references empregado(cpf) on delete cascade,
	   constraint fk_tipoaviao_pode_trabalhar foreign key (tipo_aviao)
		  references tipo_aviao(nome) on delete cascade   
	);*/
	INSERT INTO pode_trabalhar VALUES ('Airbus 319', 12345678910);
	INSERT INTO pode_trabalhar VALUES ('Fokker 100', 65675646335);
	INSERT INTO pode_trabalhar VALUES ('Boeing 737-300', 24525346565);

	-- Tabela Problemas
	/*create table problemas (
	  servico     number not null, 
	  problema    varchar2(100) not null, 
	  solu??o     varchar2(100), 
	  constraint pk_problemas primary key (servico, problema),
	  constraint fk_servico_problemas foreign key (servico)
		  references servico (codigo) on delete cascade
	);*/
	INSERT INTO problemas VALUES (1, 'Comida Estragada', 'Substitui??o de comida');
	INSERT INTO problemas VALUES (2, 'Acidentes com comida', 'Utilizar produtos de limpeza');
	INSERT INTO problemas VALUES (3, 'Fone de ouvido quebrado', 'Substitui??o de fone de ouvido');
commit;