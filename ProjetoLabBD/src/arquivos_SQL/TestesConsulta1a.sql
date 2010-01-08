insert into trecho_voo values(
    1000,
    3342,
    'BCT',
    to_date('28.09.09-08:00','dd.mm.yy-hh24:mi'),
    'BBH',
    to_date('28.09.09-09:30','dd.mm.yy-hh24:mi')
);

insert into trecho_voo values(
    1001,
    3342,
    'BBH',
    to_date('28.09.09-08:00','dd.mm.yy-hh24:mi'),
    'BSV',
    to_date('28.09.09-09:30','dd.mm.yy-hh24:mi')
);

-- Agora fazemos um voo de Porto Alegre (RS) a Belém(PA), com escalas em Uberlandia(MG) e em Palmas (TO)

insert into trecho_voo values(
    1010,
    3867,
    'BPA',
    to_date('05.10.09-06:00','dd.mm.yy-hh24:mi'),
    'BUL',
    to_date('05.10.09-08:00','dd.mm.yy-hh24:mi')
);

insert into trecho_voo values(
    1011,
    3867,
    'BUL',
    to_date('05.10.09-08:00','dd.mm.yy-hh24:mi'),
    'BPJ',
    to_date('05.10.09-08:50','dd.mm.yy-hh24:mi')
);

insert into trecho_voo values(
    1012,
    3867,
    'BPJ',
    to_date('05.10.09-08:50','dd.mm.yy-hh24:mi'),
    'BBE',
    to_date('05.10.09-09:40','dd.mm.yy-hh24:mi')
);

-- Mesmos voos com escalas diferentes

insert into trecho_voo values(
    1020,
    8000,
    'BPA',
    to_date('05.11.09-12:00','dd.mm.yy-hh24:mi'),
    'BPJ',
    to_date('05.11.09-12:50','dd.mm.yy-hh24:mi')
);

insert into trecho_voo values(
    1021,
    8000,
    'BPJ',
    to_date('05.11.09-12:50','dd.mm.yy-hh24:mi'),
    'BBE',
    to_date('05.11.09-14:00','dd.mm.yy-hh24:mi')
);


insert into instancia_trecho values(
    to_date('28.09.09','dd.mm.yy'),
    1000,
    3342,
    0,
    'BBH',
    to_date('28.09.09-09:30','dd.mm.yy-hh24:mi'),
    'BCT',
    to_date('28.09.09-08:00','dd.mm.yy-hh24:mi'),
    0
);

insert into instancia_trecho values(
    to_date('28.09.09','dd.mm.yy'),
    1001,
    3342,
    0,
    'BSV',
    to_date('28.09.09-09:30','dd.mm.yy-hh24:mi'),
    'BBH',
    to_date('28.09.09-08:00','dd.mm.yy-hh24:mi'),
    1
);

-- Agora fazemos um voo de Porto Alegre (RS) a Belém(PA), com escalas em Uberlandia(MG) e em Palmas (TO)

insert into instancia_trecho values(
    to_date('05.10.09','dd.mm.yy'),
    1010,
    3867,
    0,
    'BUL',
    to_date('05.10.09-08:00','dd.mm.yy-hh24:mi'),
    'BPA',
    to_date('05.10.09-06:00','dd.mm.yy-hh24:mi'),
    10
);

insert into instancia_trecho values(
    to_date('05.10.09','dd.mm.yy'),
    1011,
    3867,
    0,
    'BPJ',
    to_date('05.10.09-08:50','dd.mm.yy-hh24:mi'),
     'BUL',
    to_date('05.10.09-08:00','dd.mm.yy-hh24:mi'),
    5
);

insert into instancia_trecho values(
    to_date('05.10.09','dd.mm.yy'),
    1012,
    3867,
    0,
    'BBE',
    to_date('05.10.09-09:40','dd.mm.yy-hh24:mi'),
    'BPJ',
    to_date('05.10.09-08:50','dd.mm.yy-hh24:mi'),
    3
);

-- Mesmos voos com escalas diferentes

insert into instancia_trecho values(
    to_date('05.11.09','dd.mm.yy'),
    1020,
    8000,
    0,
    'BPJ',
    to_date('05.11.09-12:50','dd.mm.yy-hh24:mi'),
    'BPA',
    to_date('05.11.09-12:00','dd.mm.yy-hh24:mi'),
    4
);

insert into instancia_trecho values(
    to_date('05.11.09','dd.mm.yy'),
    1021,
    8000,
    0,
    'BBE',
    to_date('05.11.09-14:00','dd.mm.yy-hh24:mi'),
    'BPJ',
    to_date('05.11.09-12:50','dd.mm.yy-hh24:mi'),
    6
);