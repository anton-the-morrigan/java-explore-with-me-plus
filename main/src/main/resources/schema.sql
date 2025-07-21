CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(255),
    email VARCHAR(255)
    );


CREATE TABLE IF NOT EXISTS categories (
                                          id SERIAL PRIMARY KEY,
                                          name VARCHAR(255)
    );


CREATE TABLE IF NOT EXISTS events (
                                      id SERIAL PRIMARY KEY,
                                      title VARCHAR(255),
    annotation TEXT,
    description TEXT,
    state VARCHAR(50),
    event_date TIMESTAMP,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    published_on TIMESTAMP,
    category_id INTEGER NOT NULL REFERENCES categories(id) ON DELETE CASCADE,
    initiator_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    paid BOOLEAN,
    request_moderation BOOLEAN,
    participant_limit INTEGER,
    lat DOUBLE PRECISION,
    lon DOUBLE PRECISION
    );

CREATE TABLE IF NOT EXISTS participation_request (
                                                     id SERIAL PRIMARY KEY,
                                                     requester_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    event_id INTEGER NOT NULL REFERENCES events(id) ON DELETE CASCADE,
    status VARCHAR(50),
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS compilations (
                                            id SERIAL PRIMARY KEY,
                                            title VARCHAR(255),
    pinned BOOLEAN
    );

CREATE TABLE IF NOT EXISTS event_compilation (
                                                 compilation_id INTEGER NOT NULL REFERENCES compilations(id) ON DELETE CASCADE,
    event_id INTEGER NOT NULL REFERENCES events(id) ON DELETE CASCADE,
    PRIMARY KEY (compilation_id, event_id)
    );