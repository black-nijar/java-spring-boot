CREATE TABLE IF NOT EXISTS Run (
    id INT NOT NULL,
    title VARCHAR(256) NOT NULL,
    started_on timestamp  NOT NULL,
    completed_on timestamp NOT NULL,
    miles INT NOT NULL,
    location VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
);