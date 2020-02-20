CREATE TABLE users (
    id INTEGER NOT NULL AUTO_INCREMENT,

    username VARCHAR(30) NOT NULL,
    password VARCHAR(255) NOT NULL,

    email VARCHAR(255),
    activation_code VARCHAR(255),
    registration_date DATETIME(6),

    first_name VARCHAR(30),
    last_name VARCHAR(50),
    birth_date DATETIME(6),

    active BIT NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE user_role (
    user_id INTEGER NOT NULL,

    roles VARCHAR(10)
);

CREATE TABLE campaigns(
    id INTEGER NOT NULL AUTO_INCREMENT,

    user_id INTEGER NOT NULL,
    campaign_name VARCHAR(255),
    topic VARCHAR(50),

    logo VARCHAR(255),
    description VARCHAR(1024),

    amount_total DOUBLE PRECISION,
    amount_collected DOUBLE PRECISION,

    date_of_creation DATETIME(6),
    date_of_update DATETIME(6),
    date_of_expiry DATETIME(6),

    PRIMARY KEY (id)
);

CREATE TABLE topics (
    id INTEGER NOT NULL AUTO_INCREMENT,
    topic_name VARCHAR(30),

    PRIMARY KEY (id)
);

CREATE TABLE comments (
    id INTEGER NOT NULL AUTO_INCREMENT,

    path INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    text VARCHAR(1024),
    filename VARCHAR(255),
    date_of_creation DATETIME(6),

    PRIMARY KEY (id)
);

CREATE TABLE hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
ALTER TABLE user_role ADD CONSTRAINT role_user_fk FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE campaigns ADD CONSTRAINT campaigns_user_fk FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE comments ADD CONSTRAINT comments_user_fk FOREIGN KEY (user_id) REFERENCES users (id);
