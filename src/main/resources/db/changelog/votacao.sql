CREATE TABLE PAUTA
(
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(255)
);

CREATE TABLE ASSOCIADOS
(
  id SERIAL PRIMARY KEY,
  cpf VARCHAR(11)
);

CREATE TABLE SESSAO
(
    id SERIAL PRIMARY KEY,
    idPauta INT,
    dataInicial TIMESTAMP,
    dataFinal TIMESTAMP,
    CONSTRAINT fk_pauta
        FOREIGN KEY(idPauta)
            REFERENCES PAUTA(id)
);

CREATE TABLE PAUTA_ASSOCIADOS
(
    idPauta INT,
    idAssociado INT,
    voto BOOLEAN,
    CONSTRAINT fk_pauta
        FOREIGN KEY(idPauta)
            REFERENCES PAUTA(id),
    CONSTRAINT fk_associados
        FOREIGN KEY(idAssociado)
            REFERENCES ASSOCIADOS(id),
    CONSTRAINT pk_pauta_associados
        PRIMARY KEY(idPauta, idAssociado)
);