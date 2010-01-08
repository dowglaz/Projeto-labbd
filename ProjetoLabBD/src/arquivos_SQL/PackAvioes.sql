/* Este pacote armazena itens relacionados a aviões */

create or replace
PACKAGE PackAvioes IS

	/*Função criada para retornar todos os aviões 
	cadastrados no bando de dados*/
	FUNCTION selecionaAvioes RETURN SYS_REFCURSOR;

END PackAvioes;	

create or replace
PACKAGE BODY PackAvioes IS
  FUNCTION selecionaAvioes RETURN SYS_REFCURSOR IS				
       cr SYS_REFCURSOR;
	BEGIN		
		OPEN cr FOR 
          SELECT id_aviao, tipo_aviao FROM aviao;					
		
		RETURN cr;	
		
		EXCEPTION
		WHEN VALUE_ERROR OR COLLECTION_IS_NULL THEN
			raise_application_error( -20000, 'Erro numérico ou collection null.' );
			
	END selecionaAvioes;	
END PackAvioes ;	