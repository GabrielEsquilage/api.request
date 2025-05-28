INSERT INTO fipe.tipos_veiculo (id, nome) VALUES
(1, 'Carro'),
(2, 'Moto'),
(3, 'Caminhão')
ON CONFLICT (id) DO NOTHING;
