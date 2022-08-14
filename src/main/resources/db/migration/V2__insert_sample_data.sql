INSERT INTO users (email, password, name , created_at) VALUES
('admin@gmail.com', 'admin', 'Admin', CURRENT_TIMESTAMP),
('siva@gmail.com', 'siva', 'Siva', CURRENT_TIMESTAMP)
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