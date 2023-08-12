create table if not exists pedido(
    id bigserial primary key,
    numero varchar,
    emissao date
);

create table if not exists pedido_item(
    id bigserial primary key,
    cod_produto varchar,
    quantidade int,
    valor_unitario numeric(18, 6),
    total numeric(18, 2),
    pedido_id int,
    constraint fk_pedido foreign key (pedido_id) references pedido(id)
);