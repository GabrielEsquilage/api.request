ALTER TABLE fipe.models
ADD COLUMN marca_id BIGINT NOT NULL,
ADD CONSTRAINT fk_model_marca FOREIGN KEY (marca_id)
    REFERENCES fipe.marcas (id);
