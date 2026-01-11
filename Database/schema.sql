CREATE DATABASE IF NOT EXISTS smart_yatra;
USE smart_yatra;

-- =========================
-- USERS TABLE
-- =========================
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT,
    gender VARCHAR(20),
    b_group VARCHAR(10),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20) UNIQUE,
    language VARCHAR(50),
    e_contact VARCHAR(20),
    e_relation VARCHAR(50),
    location VARCHAR(255),
    nationality VARCHAR(50),
    timestamp BIGINT,
    user_id VARCHAR(100)
);

-- =========================
-- USER LOCATIONS TABLE
-- =========================
CREATE TABLE user_locations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(100) NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    timestamp BIGINT NOT NULL
);