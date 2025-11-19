CREATE TABLE bikes (
                       id              BIGSERIAL PRIMARY KEY,
                       owner_id        BIGINT NOT NULL,
                       model           VARCHAR(120) NOT NULL,
                       type            VARCHAR(32)  NOT NULL,
                       cost_per_minute NUMERIC(10,2) NOT NULL CHECK (cost_per_minute >= 0),
                       image_url       VARCHAR(512),
                       latitude        DOUBLE PRECISION,
                       longitude       DOUBLE PRECISION,
                       status          VARCHAR(24)  NOT NULL DEFAULT 'AVAILABLE'
);

CREATE INDEX idx_bikes_owner ON bikes(owner_id);