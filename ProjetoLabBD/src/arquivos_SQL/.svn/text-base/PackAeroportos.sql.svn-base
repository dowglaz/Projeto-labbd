/* Pacote criado para armazenar funções, procedimentos e tipo relacionados
aos aeroportos do banco de dados.
Nele está a função criada para que possamos fazer a seguinte consulta.

Consulta 3:
Considere a seguinte situação:
Um avião está voando e é informado de que o aeroporto destino, em que aterrissaria,
está bloqueado por algum motivo. Este avião precisa escolher um outro aeroporto para
pousar, de preferência próximo a ele. Então faz-se uma busca por quais aeroportos
suportam aquele tipo de avião, e também a localização de tais aeroportos.
Esta consulta é definida exatamente para isso, ela exibe os aeroportos em que um determinado
avião pode pousar bem como os nomes e localizações, além dos códigos. 
*/

create or replace
PACKAGE PackAeroportos IS

	/* Esta função tem o objetivo de retornar todos os aeroportos em que um determinado
	avião cujo número de identificação é setado no parâmetro idaviao. A partir dele,
	busca-se o tipo do avião e então em quais aeroportos do país este avião, ou este tipo
	de avião pode aterrissar*/
	FUNCTION aeroportosParaAterrissar(idaviao IN aviao.id_aviao%TYPE) RETURN SYS_REFCURSOR;

END PackAeroportos;	

create or replace
PACKAGE BODY PackAeroportos IS
  FUNCTION aeroportosParaAterrissar(idaviao IN aviao.id_aviao%TYPE) RETURN SYS_REFCURSOR IS				
       cr SYS_REFCURSOR;
	BEGIN		
		OPEN cr FOR 
          SELECT aero.codigo, aero.nome, aero.cidade, aero.estado
					FROM aeroporto aero, aviao, pode_aterrissar pode
					WHERE idaviao = aviao.id_aviao AND
						  aviao.tipo_aviao = pode.tipo_aviao AND
						  pode.aeroporto = aero.codigo;	
		RETURN cr;	
		EXCEPTION
		WHEN VALUE_ERROR OR COLLECTION_IS_NULL THEN
			raise_application_error( -20000, 'Erro numérico ou collection null.' );
	END aeroportosParaAterrissar;
END PackAeroportos;	