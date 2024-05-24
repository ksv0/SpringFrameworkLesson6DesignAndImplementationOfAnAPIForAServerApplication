create table if not exists notes
(
    id          BIGINT          PRIMARY KEY,
    header      VARCHAR(255)    NOT NULL,
    content     VARCHAR(255)    NOT NULL,
    created     TIMESTAMP       NOT NULL
)