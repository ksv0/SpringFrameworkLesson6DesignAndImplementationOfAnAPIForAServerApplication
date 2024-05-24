CREATE TABLE IF NOT EXISTS character
(
    id      INT PRIMARY KEY,
    name    VARCHAR(255),
    status  VARCHAR(255),
    species VARCHAR(255),
    type    VARCHAR(255),
    gender  VARCHAR(255),
    image   bytea,
    url     VARCHAR(255),
    created DATE
);

-- ALTER TABLE character
--     ALTER COLUMN image TYPE bytea USING image::bytea;
-- ALTER TABLE character
--     ADD COLUMN new_image bytea;
-- UPDATE character
-- SET new_image = pg_read_binary_file(image::text);
-- ALTER TABLE character
--     DROP COLUMN image;
-- ALTER TABLE character
--     RENAME COLUMN new_image TO image;