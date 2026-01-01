CREATE TABLE courses (
                         id BIGSERIAL PRIMARY KEY,
                         code VARCHAR(50) NOT NULL,
                         title VARCHAR(255) NOT NULL,
                         description TEXT
);

CREATE TABLE grades (
                        id BIGSERIAL PRIMARY KEY,
                        course_code VARCHAR(50) NOT NULL,
                        course_name VARCHAR(255) NOT NULL,
                        type VARCHAR(50),
                        grade DOUBLE PRECISION,
                        weight DOUBLE PRECISION,
                        feedback TEXT
);