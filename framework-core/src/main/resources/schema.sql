CREATE TABLE IF NOT EXISTS account
(
    id      INT PRIMARY KEY,
    balance INT
);

INSERT INTO account (id, balance) VALUES (1, 1000);
INSERT INTO account (id, balance) VALUES (2, 500);