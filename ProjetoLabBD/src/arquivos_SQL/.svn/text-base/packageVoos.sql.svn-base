create or replace
package voos as
    type ref_voo is ref cursor;
    procedure encontra_voos(
      origem aeroporto.codigo%TYPE,
      destino aeroporto.codigo%TYPE,
      data instancia_trecho.data%TYPE,
      classe tarifa.classe%TYPE,
      hora_inf instancia_trecho.hora_partida%TYPE,
      hora_sup instancia_trecho.hora_partida%TYPE,
      c_dois_trechos_1 out ref_voo,
      c_dois_trechos_2 out ref_voo,
      c_tres_trechos_1 out ref_voo,
      c_tres_trechos_2 out ref_voo,
      c_tres_trechos_3 out ref_voo,
      c_direto out ref_voo
  );
 --   procedure imprime_voo(voo in t_voo);
 --   procedure imprime_voos(voos in ref_voo);
 -- com refcursor, precisa inserir em nested table para impressao, isso ja sera feito
 -- com vector no java
    too_many exception;
    no_data exception;
    pragma EXCEPTION_init(too_many,-20000);
    pragma EXCEPTION_init(no_data,-20001);
end voos;


-- Body do package voos
create or replace
package body voos as
   procedure encontra_voos(
      origem aeroporto.codigo%TYPE,
      destino aeroporto.codigo%TYPE,
      data instancia_trecho.data%TYPE,
      classe tarifa.classe%TYPE,
      hora_inf instancia_trecho.hora_partida%TYPE,
      hora_sup instancia_trecho.hora_partida%TYPE,
      c_dois_trechos_1 out ref_voo,
      c_dois_trechos_2 out ref_voo,
      c_tres_trechos_1 out ref_voo,
      c_tres_trechos_2 out ref_voo,
      c_tres_trechos_3 out ref_voo,
      c_direto out ref_voo
  )
  IS

  begin
  -- Cursor para dois trechos
  open c_dois_trechos_2 for select
        t2.nro_trecho, a1.nome, to_char(t2.hora_partida,'hh24:mi'), a2.nome, to_char(t2.hora_chegada,'hh24:mi')
    from instancia_trecho t2, aeroporto a1, aeroporto a2 where
      a1.codigo = t2.aeroporto_partida and a2.codigo = t2.aeroporto_chegada and
      t2.aeroporto_chegada = destino and t2.aeroporto_partida in
      ( select t1.aeroporto_chegada from instancia_trecho t1 where t1.aeroporto_partida = origem and t1.nro_voo = t2.nro_voo and
      t1.data = data and (t1.hora_partida between hora_inf and hora_sup)
      );

  open c_dois_trechos_1 for select t1.nro_voo,
        t1.nro_trecho, a1.nome, to_char(t1.hora_partida,'hh24:mi'), a2.nome, to_char(t1.hora_chegada,'hh24:mi'),
    v.companhia_aerea, tr.valor
    from voo v, instancia_trecho t1, aeroporto a1, aeroporto a2, tarifa tr where v.numero = t1.nro_voo and a1.codigo = t1.aeroporto_partida
    and a2.codigo = t1.aeroporto_chegada and t1.aeroporto_partida = origem and tr.nro_voo = v.numero and
    t1.data = data and (t1.hora_partida between hora_inf and hora_sup) and tr.classe = classe
    and t1.aeroporto_chegada in
      (select t2.aeroporto_partida from instancia_trecho t2 where
      t1.nro_voo = t2.nro_voo and t2.aeroporto_chegada = destino);

  -- Cursor para tres trechos
  open c_tres_trechos_3 for select
        t3.nro_trecho, a1.nome, to_char(t3.hora_partida,'hh24:mi'), a2.nome, to_char(t3.hora_chegada,'hh24:mi')
    from instancia_trecho t3, aeroporto a1, aeroporto a2 where
    a1.codigo = t3.aeroporto_partida and a2.codigo = t3.aeroporto_chegada and t3.aeroporto_chegada = destino and t3.aeroporto_partida in
      ( select t2.aeroporto_chegada from instancia_trecho t2 where t3.nro_voo = t2.nro_voo
      and t2.aeroporto_partida in
          ( select t1.aeroporto_chegada from instancia_trecho t1 where t2.nro_voo = t1.nro_voo and
          t1.data = data and (t1.hora_partida between hora_inf and hora_sup)
          and t1.aeroporto_partida = origem ) );

  open c_tres_trechos_2 for select
      t2.nro_trecho, a1.nome, to_char(t2.hora_partida,'hh24:mi'), a2.nome, to_char(t2.hora_chegada,'hh24:mi')
    from instancia_trecho t2, aeroporto a1, aeroporto a2 where a1.codigo = t2.aeroporto_partida and a2.codigo = t2.aeroporto_chegada
    and t2.aeroporto_chegada in
      (select t3.aeroporto_partida from instancia_trecho t3 where t3.nro_voo = t2.nro_voo and t3.aeroporto_chegada = destino)
      and t2.aeroporto_partida in
        (select t1.aeroporto_chegada from instancia_trecho t1 where t1.nro_voo = t2.nro_voo and t1.aeroporto_partida = origem
        and t1.data = data and (t1.hora_partida between hora_inf and hora_sup));

  open c_tres_trechos_1 for
    select t1.nro_voo,
      t1.nro_trecho, a1.nome, to_char(t1.hora_partida,'hh24:mi'), a2.nome, to_char(t1.hora_chegada,'hh24:mi'),
      v.companhia_aerea, tr.valor
    from voo v, instancia_trecho t1, aeroporto a1, aeroporto a2, tarifa tr where tr.nro_voo = v.numero and a1.codigo = t1.aeroporto_partida and
    v.numero = t1.nro_voo and a2.codigo = t1.aeroporto_chegada and t1.aeroporto_partida = origem and tr.classe = classe
    and t1.data = data and (t1.hora_partida between hora_inf and hora_sup) and
    t1.aeroporto_chegada  in
      (select t2.aeroporto_partida from trecho_voo t2 where t1.nro_voo = t2.nro_voo and t2.aeroporto_chegada in
        (select t3.aeroporto_partida from trecho_voo t3 where t2.nro_voo = t3.nro_voo and t3.aeroporto_chegada = destino));

  -- Cursor para um trecho
  open c_direto for select t.nro_voo,
        t.nro_trecho, a1.nome, to_char(t.hora_partida,'hh24:mi'), a2.nome, to_char(t.hora_chegada,'hh24:mi'),
        v.companhia_aerea, tr.valor
        from instancia_trecho t join voo v on t.nro_voo = v.numero join tarifa tr on tr.nro_voo = v.numero join aeroporto a1 on a1.codigo = t.aeroporto_partida
          join aeroporto a2 on a2.codigo = t.aeroporto_chegada
        where t.data = data and (t.hora_partida between hora_inf and hora_sup) and tr.classe = classe and t.aeroporto_partida = origem and t.aeroporto_chegada = destino;

  exception
      when too_many_rows then
        raise_application_error(-20000,'Muitos registros');
      when no_data_found then
        raise_application_error(-20001,'Não existe vôos com origem ');-- || origem || ' e destino ' || destino );

  end encontra_voos;
end voos;