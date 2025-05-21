CREATE TABLE IF NOT EXISTS fipe.tipos_veiculo (
    id INTEGER PRIMARY KEY,       -- 1, 2, 3
    nome TEXT NOT NULL UNIQUE     -- 'Carro', 'Moto', 'Caminhão'
);
