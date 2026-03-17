CREATE TABLE IF NOT EXISTS exercises(
    id BIGINT not null auto_increment,
    name VARCHAR(90) not null,
    muscle_group VARCHAR(30) not null,
    description VARCHAR(255),

    primary key (id)
)