USE traqura_db;

INSERT INTO users (email, first_name, last_name, password)
VALUES
    ('TaraDactyl@dino.com', 'Tara', 'Dactyl', '$2a$10$wEc65/etNcCBKYLzlHTvvOILPkbi9DyFnIHaLRK8HO7vMArTZJIn2'),
    ('TerranceRex@dino.com', 'Terrance', 'Rex', '$2a$10$8.DVek/KxqJ9BfV2ZkNlEOjXqD7lrD5M0AhD0SXbPowSiA8YOmxK2'),
    ('tri-sara@dino.com', 'Sara', 'Triceratops', '$2a$10$U5H/HJjxrRheOH784Qw1au6Cn0ZJtuDgfyrXh27DszVsTzG1bcIfC'),
    ('v-raptor@dino.com', 'Vicente', 'Raptor', '$2a$10$U5H/HJjxrRheOH784Qw1au6Cn0ZJtuDgfyrXh27DszVsTzG1bcIfC');

INSERT INTO spaces (name, keywords, file_stack_url, color, user_id)
VALUES
    ('living room', 'living room family room', 'no image', 'pink', 4),
    ('front closet', 'closet, coats', 'no image', 'purple', 4),
    ('kitchen', 'kitchen', 'no image', 'blue', 4);

INSERT INTO components (name, keywords, color, file_stack_url, checked_out, parent_id, space_id)
VALUES
    ('sofa', 'red sofa sectional', 'red', 'wwww.fakeurl.com', 0, 0, 1),
    ('cody the duck', 'rubber, yellow, duck, bath toys, kids', 'purple', 'no image', 0, 0, 2);



