create or replace
PACKAGE PackPessoa IS
/*Neste pacote estão contidos procedimentos e funções relacionadas a tabela
pessoa, empregado e piloto.

Nele estão alguns dos procedimentos/funções para a consulta:

Consulta 2: 
a partir de um CPF de um determinado empregado, busca seu nome, endereço, salário, turno em que trabalha,
em que tipos de aviões este empregado pode trabalhar, em também quais problemas que tal
empregado já pode participar da resolução.
Consideramos esta consulta para a implementação, já que uma das principais consultas
feitas em empresas está relacionada aos empregados.

Além desta consulta foram feitas janelas para adicionar/editar/remover pessoas,
no projeto final.
*/
	
	
	/*Este procedimento é responsável por inserir um piloto ou um empregado,
	passandopara o procedimento o parâmetro tipo_pessoa para que o mesmo
	possa escolher as tabelas corretas em que os dados serão inseridos.
	*/
	PROCEDURE insere_pessoa(
		p_cpf IN pessoa.cpf%type,
		p_nome IN pessoa.nome%type,
		p_rua IN pessoa.rua%type,
		p_nro IN pessoa.nro%type,
		p_cidade IN pessoa.cidade%type,
		p_estado IN pessoa.estado%type,
		p_cep IN pessoa.cep%type,
		p_tipo IN pessoa.tipo%type,
		p_salario IN empregado.salario%type DEFAULT 0,
		p_turno IN empregado.turno%type DEFAULT 'DIURNO',
		p_nro_licenca IN piloto.nro_licenca%type DEFAULT 0,
		p_horas_voo IN piloto.horas_voo%type DEFAULT 0,
		foto IN pessoa.foto%type DEFAULT NULL
		);
	
	/*Esta função retorna uma lista de CPFs de pessoas com o nome igual ao valor
	passado no parâmetro name. Assim, podemos saber se existe mais de uma pessoa
	com o mesmo nome e então listar os CPFs para que possamos escolher a pessoa
	certa. Passamos também um parâmetro t(tipo_pessoa) para restringir o conjunto
	de CPFs a serem pesquisados.
	Pode-se selecionar, passar o valor ao parâmetro tipo_pessoa, 'PILOTO', 
	'EMPREGADO', '<Outro tipo>' e selecionar pessoas de qualquer tipo
	(passando o parâmetro NULL)*/
	FUNCTION cpfOfName(name IN pessoa.nome%TYPE, t IN pessoa.tipo%type) RETURN SYS_REFCURSOR;
	
	/*Dado um CPF válido de um empregado, esta função extrai informações sobre o mesmo.*/
	FUNCTION consultarEmpregado(num IN pessoa.cpf%TYPE) RETURN SYS_REFCURSOR;
	
	/*Dado um CPF de um empregado, retorna uma lista com os tipo_aviao em que o mesmo
	pode trabalhar*/
	FUNCTION getTiposAviaoPodeTrabalharEmp(num IN pessoa.cpf%TYPE) RETURN SYS_REFCURSOR;	
	
	/*Dado um CPF de um empregado, retorna uma lista com os problemas nas quais o mesmo já trabalhou.*/
	FUNCTION getProblemasTrabalhadosEmp(num IN pessoa.cpf%TYPE) RETURN SYS_REFCURSOR;
	
	
	--Não implementado
	/* Faz a mesma consulta acima, porém pelo Nome(deve obrigatoriamente único no BD; não funciona
	   corretamente caso haja mais de uma pessoa com o mesmo nome.
	   Se houver, utilize a função consultaEmpregado com parâmetro CPF)*/
	--FUNCTION consultarEmpregado(num pessoa.nome%TYPE) RETURN SYS_REFCURSOR;
	
	
	/*Esta função retorna uma lista com todas as pessoas de um determinado tipo
	Serve para listarmos todos os empregados, ou todos os pilotos ou todas as pessoas
	os atributos de retorno variam, mas são ternados usando sys_refcursor*/
	FUNCTION getPessoas(t IN pessoa.tipo%TYPE) RETURN SYS_REFCURSOR;
	
	/*Função que remove uma pessoa dado o seu CPF
	Dado um cpf ele busca nas tabelas voa, pode_trabalhar e deleta, após isso, busca nas tabelas
	empregado e piloto e deleta, após isso deleta da tabela pessoa.
	A busca é simples, feita pela chave primária.*/
	PROCEDURE removePessoa(num IN pessoa.cpf%TYPE);
	
	
	/*Esta função atualiza uma determinada pessoa, sendo o cpf o parâmetro de busca.
	a idéia é poder alterar também o cpf(campo new_cpf), mas isso ainda não está implementado.
	A alteraçao também cobre a alteração do tipo de pessoa. Assim, um piloto pode se tornar empregado
	e um empregado pode se tornar piloto, ou algum outro tipo que o usuário definir.
	Porém, há apenas, além das tabelas piloto e empregado, a tabela pessoa para esses novos tipos.
	A possibilidade de novos tipos está definida no diagrama entidade-relacionamento.*/
	PROCEDURE atualizaPessoa(
		p_cpf IN pessoa.cpf%type,
		p_nome IN pessoa.nome%type,
		p_rua IN pessoa.rua%type,
		p_nro IN pessoa.nro%type,
		p_cidade IN pessoa.cidade%type,
		p_estado IN pessoa.estado%type,
		p_cep IN pessoa.cep%type,
		p_tipo IN pessoa.tipo%type,
		p_salario IN empregado.salario%type DEFAULT 0,
		p_turno IN empregado.turno%type DEFAULT 'DIURNO',
		p_nro_licenca IN piloto.nro_licenca%type DEFAULT 0,
		p_horas_voo IN piloto.horas_voo%type DEFAULT 0,
		p_foto IN pessoa.foto%type DEFAULT NULL,
		new_cpf IN pessoa.cpf%type DEFAULT 0
		);	
	
END PackPessoa;






create or replace
PACKAGE BODY  PackPessoa IS

	PROCEDURE insere_pessoa(
		p_cpf IN pessoa.cpf%type,
		p_nome IN pessoa.nome%type,
		p_rua IN pessoa.rua%type,
		p_nro IN pessoa.nro%type,
		p_cidade IN pessoa.cidade%type,
		p_estado IN pessoa.estado%type,
		p_cep IN pessoa.cep%type,
		p_tipo IN pessoa.tipo%type,
		p_salario IN empregado.salario%type DEFAULT 0,
		p_turno IN empregado.turno%type DEFAULT 'DIURNO',
		p_nro_licenca IN piloto.nro_licenca%type DEFAULT 0,
		p_horas_voo IN piloto.horas_voo%type DEFAULT 0,
		foto IN pessoa.foto%type DEFAULT NULL	
		) AS
		erro EXCEPTION;
		PRAGMA EXCEPTION_INIT(erro, -12899);
	
	BEGIN
		IF p_tipo = 'PILOTO' THEN
			INSERT INTO pessoa VALUES (p_cpf, p_nome, p_rua, p_nro, p_cidade, p_estado, p_cep, foto, p_tipo);
			INSERT INTO piloto VALUES (p_cpf, p_nro_licenca, p_horas_voo );		
			commit;
		ELSIF p_tipo = 'EMPREGADO' THEN
			INSERT INTO pessoa VALUES (p_cpf, p_nome, p_rua, p_nro, p_cidade, p_estado, p_cep, foto, p_tipo);
			INSERT INTO empregado VALUES  (p_cpf, p_salario, p_turno);		
			commit;
		ELSE
			raise_application_error( -20001, 'Tipo-pessoa inválido.' );
		END IF;
				
		EXCEPTION		
		WHEN DUP_VAL_ON_INDEX THEN
			ROLLBACK;
			raise_application_error( -20004, 'CPF já cadastrado.' );
		WHEN INVALID_NUMBER OR VALUE_ERROR OR erro THEN
			ROLLBACK;
			raise_application_error( -20007, 'Tipo de dado inválido');		
		WHEN OTHERS THEN
			ROLLBACK;
			raise_application_error( -20003, 'Outros problemas.' );				
	END  insere_pessoa;
	
	FUNCTION cpfOfName(name IN pessoa.nome%TYPE, t IN pessoa.tipo%type) RETURN SYS_REFCURSOR IS
		cr SYS_REFCURSOR;		
	BEGIN
		--se restringiu para o tipo Piloto ou Empregado
		IF(t = 'EMPREGADO' OR t = 'PILOTO') THEN
			OPEN cr FOR
			SELECT cpf FROM pessoa WHERE nome = name AND tipo = t;
		
		--se restringiu para algum outro tipo de pessoa
		ELSIF (t <> NULL) THEN
			OPEN cr FOR
				SELECT cpf FROM pessoa WHERE nome = name AND t <> 'PILOTO' AND t <> 'EMPREGADO';
		
		--se passou valor NULL, seleciona qualquer pessoa
		ELSIF (t = NULL) THEN
			OPEN cr FOR
				SELECT cpf FROM pessoa WHERE nome = name;
		END IF;
		
		RETURN cr;		
		
	END cpfOfName;
	
	
	-- Consulta pelo CPF
	FUNCTION consultarEmpregado(num IN pessoa.cpf%TYPE) RETURN SYS_REFCURSOR IS
		c SYS_REFCURSOR;
	BEGIN
		OPEN c FOR
				select p.nome, p.rua, p.nro, p.cidade, p.estado, p.cep, emp.salario, emp.turno
				from pessoa p, empregado emp
				where p.cpf = num AND emp.cpf = p.cpf;
		RETURN	c;
	END consultarEmpregado;
	
	
	-- Consulta pelo CPF
	FUNCTION getTiposAviaoPodeTrabalharEmp(num IN pessoa.cpf%TYPE) RETURN SYS_REFCURSOR IS
		c SYS_REFCURSOR;
	BEGIN
		OPEN c FOR
				SELECT tipo_aviao
				FROM pode_trabalhar
				WHERE empregado = num;
		RETURN	c;
	END getTiposAviaoPodeTrabalharEmp;
	
	
	FUNCTION getProblemasTrabalhadosEmp(num IN pessoa.cpf%TYPE) RETURN SYS_REFCURSOR IS
		c SYS_REFCURSOR;
	BEGIN
		OPEN c FOR
				select DISTINCT problemas.problema
				from problemas,servico
				where empregado = num AND problemas.servico = servico.codigo;
		RETURN	c;
	END getProblemasTrabalhadosEmp;
	
	
	-- Consulta pelo Nome(deve obrigatoriamente único no BD, não funciona
	-- corretamente caso haja mais de uma pessoa com o mesmo nome.
	-- se houver, utilize a função consultaEmpregado com parâmetro CPF)
	/*FUNCTION consultarEmpregado(num pessoa.cpf%TYPE) RETURN SYS_REFCURSOR IS
	
	BEGIN
		
		NULL;
	END consultaCpfEmpregado;
	*/
		
	
	FUNCTION getPessoas(t IN pessoa.tipo%TYPE) RETURN SYS_REFCURSOR IS
		cr SYS_REFCURSOR;
	BEGIN		
		IF(t = 'EMPREGADO') THEN
			OPEN cr FOR				
				SELECT pessoa.cpf, nome, rua, nro, cidade, estado, cep, salario, turno
				FROM pessoa, empregado 
				WHERE pessoa.cpf = empregado.cpf AND pessoa.tipo = 'EMPREGADO';
											
		ELSIF (t = 'PILOTO') THEN
			OPEN cr FOR
				SELECT pessoa.cpf, nome, rua, nro, cidade, estado, cep, nro_licenca, horas_voo
				FROM pessoa, piloto
				WHERE pessoa.cpf = piloto.cpf AND pessoa.tipo = 'PILOTO';

		--se nao for nem empregado, nem piloto, está apenas na tabela pessoa...
		ELSIF ( t <> NULL) THEN
			OPEN cr FOR
				SELECT cpf, nome, rua, nro, cidade, estado, cep, tipo
				FROM pessoa
				WHERE tipo = t;
		
		ELSIF (t = NULL) THEN
			raise_application_error( -20002, 'Tipo de pessoa deve ser preenchido.' );					
		END IF;
		
		RETURN cr;
	
	END getPessoas;
	
	
	
	PROCEDURE removePessoa(num IN pessoa.cpf%TYPE) IS
	BEGIN
		DELETE FROM pode_trabalhar WHERE empregado = num;
		DELETE FROM voa WHERE piloto = num;
		DELETE FROM piloto WHERE cpf = num;
		DELETE FROM empregado WHERE cpf = num;
		DELETE FROM pessoa WHERE cpf = num;
		commit;
		EXCEPTION
		WHEN OTHERS THEN
			ROLLBACK;
			raise_application_error( -20003, 'Outros problemas.' );	
			
	END removePessoa;	
	
	
	
	PROCEDURE atualizaPessoa(
		p_cpf IN pessoa.cpf%type,
		p_nome IN pessoa.nome%type,
		p_rua IN pessoa.rua%type,
		p_nro IN pessoa.nro%type,
		p_cidade IN pessoa.cidade%type,
		p_estado IN pessoa.estado%type,
		p_cep IN pessoa.cep%type,
		p_tipo IN pessoa.tipo%type,
		p_salario IN empregado.salario%type DEFAULT 0,
		p_turno IN empregado.turno%type DEFAULT 'DIURNO',
		p_nro_licenca IN piloto.nro_licenca%type DEFAULT 0,
		p_horas_voo IN piloto.horas_voo%type DEFAULT 0,
		p_foto IN pessoa.foto%type DEFAULT NULL,
		new_cpf IN pessoa.cpf%type DEFAULT 0
		) IS
		
		tp pessoa.tipo%TYPE;
		
		erro EXCEPTION;
		PRAGMA EXCEPTION_INIT(erro, -12899);
		
	BEGIN
		SELECT tipo INTO tp FROM pessoa WHERE cpf = p_cpf;
		
		--Se não houve mudança de tipo de pessoa
		IF tp = p_tipo THEN				
				
				UPDATE pessoa SET 
				nome = p_nome, rua = p_rua, nro = p_nro, cidade = p_cidade,
				estado = p_estado, cep = p_cep, foto = p_foto, tipo = p_tipo
				WHERE cpf = p_cpf;
				
			-- se além de pessoa, for PILOTO
			IF p_tipo = 'PILOTO' THEN
				UPDATE piloto SET
				nro_licenca = p_nro_licenca, horas_voo = p_horas_voo
				WHERE cpf = p_cpf;
				commit;
			
			-- se além de pessoa, for EMPREGADO
			ELSIF p_tipo = 'EMPREGADO' THEN	
				UPDATE empregado SET
				salario = p_salario, turno = p_turno
				WHERE cpf = p_cpf;											
				commit;
			END IF;
			/*IF (new_cpf <> 0) THEN
				UPDATE pessoa SET cpf = new_cpf WHERE cpf = p_cpf; //CASCADE?				
			*/
			
		-- SE p_tipo não for NULL e houve mudança de tipo de pessoa, então
		-- vamos trocar a pessoa da tabela piloto para empregado ou da tabela
		-- empregado para piloto. Note que no UPDATE o tipo já recebe o novo
		-- valor, p_tipo.
		ELSIF(tp <> p_tipo) THEN
				UPDATE pessoa SET 
				nome = p_nome, rua = p_rua, nro = p_nro, cidade = p_cidade,
				estado = p_estado, cep = p_cep, foto = p_foto, tipo = p_tipo
				WHERE cpf = p_cpf;
				
			-- se além de pessoa for PILOTO, excluimos da tabela piloto e adicionamos em empregado
			IF tp = 'PILOTO' THEN
				DELETE FROM piloto WHERE cpf = p_cpf;
				INSERT INTO empregado VALUES  (p_cpf, p_salario, p_turno);				
				commit;
				
			-- se além de pessoa for EMPREGADO, excluimos da tabela empregado e adicionamos em piloto
			ELSIF tp = 'EMPREGADO' THEN	
				DELETE FROM empregado WHERE cpf = p_cpf;
				INSERT INTO piloto VALUES (p_cpf, p_nro_licenca, p_horas_voo );
				commit;
			ELSE
				DELETE FROM empregado WHERE cpf = p_cpf;
				DELETE FROM piloto WHERE cpf = p_cpf;
				commit;
			END IF;	
		END IF;	
		EXCEPTION		
		WHEN DUP_VAL_ON_INDEX THEN
			ROLLBACK;
			raise_application_error( -20004, 'CPF já cadastrado.' );
		WHEN INVALID_NUMBER OR VALUE_ERROR OR erro THEN
			ROLLBACK;
			raise_application_error( -20007, 'Tipo de dado inválido');		
		WHEN OTHERS THEN
			ROLLBACK;
			raise_application_error( -20003, 'Outros problemas.' );	
			
	END  atualizaPessoa;
	
END PackPessoa;




-- Testes:
/*DECLARE

BEGIN
		PackPessoa.atualizaPessoa(
		p_cpf => 54423523523, 
		p_nome => 'Bruno Tavares',
		p_rua => 'Rua General Osario',
		p_nro => 1230,
		p_cidade => 'Sao José dos Campos',
		p_estado => 'SP',
		p_cep => '17892123',
		p_tipo => 'EMPREGADO',
		p_salario => 1111,
		p_turno => 'DIURNO'
		);

		
		PackPessoa.removepessoa(65675646335);	
		
		
		--FUNCIONOU CORRETAMENTE =)
		--***Outros testes(praticamente todos) foram feitos via interface gráfica junto do
		-- Oracle SQL Developer; obtivemo sucesso com as funções e procedimentos.
		--Insere pessoa já havia sido testado(durante a disciplina de lab. bd.
		

END;

*/










