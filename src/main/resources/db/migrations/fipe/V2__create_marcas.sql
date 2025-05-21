CREATE TABLE IF NOT EXISTS fipe.marcas (
    id SERIAL PRIMARY KEY,
    codigo TEXT NOT NULL,                 -- código retornado pela API
    nome TEXT NOT NULL,                   -- nome da marca
    tipo_id INTEGER NOT NULL,             -- referência ao tipo de veículo (1, 2, 3)
    CONSTRAINT fk_tipo
        FOREIGN KEY (tipo_id)
        REFERENCES fipe.tipos_veiculo (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT unique_codigo_tipo
        UNIQUE (codigo, tipo_id)          -- evita duplicidade da mesma marca para o mesmo tipo
);
