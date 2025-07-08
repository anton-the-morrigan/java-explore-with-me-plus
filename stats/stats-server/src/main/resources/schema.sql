CREATE TABLE IF NOT EXISTS stats (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    app VARCHAR(255), -- название сервиса, для которого записывается информация
    uri VARCHAR(255), -- URI, для которого был осуществлён запрос
    ip VARCHAR(15), -- IP адресс пользователя, осуществившего запрос
    created TIMESTAMP NOT NULL -- дата и время, когда был совершен запрос
);