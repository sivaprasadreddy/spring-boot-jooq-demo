INSERT INTO addresses (street, city, state,zip,country) VALUES
('KPHB', 'Hyderabad', 'TS','500072','India')
;

INSERT INTO users (email, password, name, addr_id, created_at) VALUES
('admin@gmail.com', 'admin', 'Admin', 1, CURRENT_TIMESTAMP),
('siva@gmail.com', 'siva', 'Siva', null, CURRENT_TIMESTAMP)
;

INSERT INTO tags(name) VALUES
('java'),
('spring-boot'),
('spring-cloud'),
('devops'),
('security')
;

INSERT INTO bookmarks(title, url, created_by, created_at) VALUES
('SivaLabs', 'https://sivalabs.in', 1, CURRENT_TIMESTAMP),
('Spring Initializr', 'https://start.spring.io', 2, CURRENT_TIMESTAMP)
;

insert into bookmark_tag(bookmark_id, tag_id) VALUES
(1,1),
(1,2),
(1,3),
(2,2)
;