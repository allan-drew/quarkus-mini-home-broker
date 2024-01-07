
    create sequence t_escrituradores_SEQ start with 1 increment by 50;

    create sequence t_investidores_SEQ start with 1 increment by 50;

    create sequence t_investimentos_SEQ start with 1 increment by 50;

    create sequence t_ordem_compra_SEQ start with 1 increment by 50;

    create table t_escrituradores (
        id bigint not null,
        nome_escriturador varchar(100) not null,
        primary key (id)
    );

    create table t_investidores (
        anoNascimento integer,
        id bigint not null,
        email varchar(255),
        nome varchar(255),
        sobrenome varchar(255),
        primary key (id)
    );

    create table t_investimentos (
        data_de_vencimento date,
        investimento_minimo float(53),
        precoUnitario numeric(38,2) not null,
        rentabilidade_anual_do_titulo float(53),
        ticker varchar(5),
        tipo_da_acao varchar(7) check (tipo_da_acao in ('ACAO_ON','ACAO_PN')),
        escriturador_fk bigint,
        id bigint not null,
        tipo_do_tesouro varchar(10) check (tipo_do_tesouro in ('PREFIXADO','IPCA_MAIS','SELIC')),
        DTYPE varchar(31) not null,
        empresa varchar(100),
        descricao varchar(3000),
        primary key (id)
    );

    create table t_ordem_compra (
        data_ordem_de_compra date not null,
        id bigint not null,
        investidor_fk bigint,
        investimento_fk bigint,
        primary key (id)
    );

    alter table if exists t_investimentos 
       add constraint FK68x2meuwxdknrkyh6xae37yno 
       foreign key (escriturador_fk) 
       references t_escrituradores;

    alter table if exists t_ordem_compra 
       add constraint FK6jl7ykafqcb3corbew6acnpip 
       foreign key (investidor_fk) 
       references t_investidores;

    alter table if exists t_ordem_compra 
       add constraint FKfc64sl3g4swq4nav1gtlrykne 
       foreign key (investimento_fk) 
       references t_investimentos;
