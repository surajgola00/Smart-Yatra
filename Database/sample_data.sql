USE smart_yatra;

INSERT INTO users (name, email) VALUES
('Test User 1', 'test1@example.com'),
('Test User 2', 'test2@example.com');

INSERT INTO locations (user_id, latitude, longitude, timestamp) VALUES
(1, 28.6139, 77.2090, '2025-01-01 10:00:00'),
(2, 19.0760, 72.8777, '2025-01-01 10:05:00');
