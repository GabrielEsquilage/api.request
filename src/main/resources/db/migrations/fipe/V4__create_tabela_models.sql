CREATE TABLE IF NOT EXISTS fipe.models (
    id INTEGER PRIMARY KEY,
    fipe_code TEXT NOT NULL,
    model TEXT NOT NULL,
    years TEXT,
    brand_id INTEGER NOT NULL,
    FOREIGN KEY (brand_id) REFERENCES fipe.marcas(id) ON DELETE CASCADE
);
