CREATE DATABASE project_management_db;

DROP TABLE IF EXISTS jobs;
DROP TABLE IF EXISTS messages;

CREATE TABLE IF NOT EXISTS messages (
    id NUMERIC,
    message TEXT,
    PRIMARY KEY (id)
);

    CREATE TABLE IF NOT EXISTS jobs (
    id NUMERIC,
    status TEXT,
    message_id NUMERIC,
    PRIMARY KEY (id),
    FOREIGN KEY (message_id)
                                REFERENCES messages (id)
);