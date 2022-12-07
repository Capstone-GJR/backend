USE traqura_db;


INSERT INTO users (email, first_name, last_name, password)
VALUES ('TaraDactyl@dino.com', 'Tara', 'Dactyl', '$2a$10$wEc65/etNcCBKYLzlHTvvOILPkbi9DyFnIHaLRK8HO7vMArTZJIn2'),
       ('TerranceRex@dino.com', 'Terrance', 'Rex', '$2a$10$8.DVek/KxqJ9BfV2ZkNlEOjXqD7lrD5M0AhD0SXbPowSiA8YOmxK2'),
       ('tri-sara@dino.com', 'Sara', 'Triceratops', '$2a$10$U5H/HJjxrRheOH784Qw1au6Cn0ZJtuDgfyrXh27DszVsTzG1bcIfC'),
       ('v-raptor@dino.com', 'Vicente', 'Raptor', '$2a$10$U5H/HJjxrRheOH784Qw1au6Cn0ZJtuDgfyrXh27DszVsTzG1bcIfC');

INSERT INTO spaces (name, keywords, file_stack_url, color, user_id)
VALUES ('living room', 'living room family room', 'no image', 'pink', 4),
       ('front closet', 'closet, coats', 'no image', 'purple', 4),
       ('kitchen', 'kitchen', 'no image', 'blue', 4),
       ('bathroom', 'bathroom', 'fakeurl', 'purple', 4),
       ('living room', 'living room family room', 'no image', 'pink', 3),
       ('front closet', 'closet, coats', 'no image', 'purple', 3),
       ('kitchen', 'kitchen', 'no image', 'blue', 3),
       ('bathroom', 'bathroom', 'fakeurl', 'purple', 3),
       ('living room', 'living room family room', 'no image', 'pink', 2),
       ('front closet', 'closet, coats', 'no image', 'purple', 2),
       ('kitchen', 'kitchen', 'no image', 'blue', 2),
       ('bathroom', 'bathroom', 'fakeurl', 'purple', 2),
       ('living room', 'living room family room', 'no image', 'pink', 1),
       ('front closet', 'closet, coats', 'no image', 'purple', 1),
       ('kitchen', 'kitchen', 'no image', 'blue', 1),
       ('bathroom', 'bathroom', 'fakeurl', 'purple', 1);

INSERT INTO totes (name, keywords, color, file_stack_url, checked_out, parent_id, space_id)
VALUES ('tote1', 'bathroom supplies', 'purple', 'no image', 0, 0, 1),
       ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 1),
       ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 1),
       ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 1),
       ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 1),
       ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 1),
       ('tote1', 'bathroom supplies', 'purple', 'no image', 0, 0, 2),
       ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 2),
       ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 2),
       ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 2),
       ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 2),
       ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 2),
       ('tote1', 'bathroom supplies', 'purple', 'no image', 0, 0, 3),
       ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 3),
       ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 3),
       ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 3),
       ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 3),
       ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 3),
       ('tote4', 'bathroom supplies', 'purple', 'no image', 0, 0, 4),
       ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 4),
       ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 4),
       ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 4),
       ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 4),
       ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 4);
#
#        ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 5),
#        ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 5),
#        ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 5),
#        ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 5),
#        ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 5),
#        ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 5),
#        ('tote6', 'bathroom supplies', 'purple', 'no image', 0, 0, 6),
#        ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 6),
#        ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 6),
#        ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 6),
#        ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 6),
#        ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 6),
#        ('tote7', 'bathroom supplies', 'purple', 'no image', 0, 0, 7),
#        ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 7),
#        ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 7),
#        ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 7),
#        ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 7),
#        ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 7),
#        ('tote8', 'bathroom supplies', 'purple', 'no image', 0, 0, 8),
#        ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 8),
#        ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 8),
#        ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 8),
#        ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 8),
#        ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 8),
#        ('tote9', 'bathroom supplies', 'purple', 'no image', 0, 0, 9),
#        ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 9),
#        ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 9),
#        ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 9),
#        ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 9),
#        ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 9),
#        ('tote9', 'bathroom supplies', 'purple', 'no image', 0, 0, 9),
#        ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 9),
#        ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 9),
#        ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 9),
#        ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 9),
#        ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 9),
#        ('tote9', 'bathroom supplies', 'purple', 'no image', 0, 0, 10),
#        ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 10),
#        ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 10),
#        ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 10),
#        ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 10),
#        ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 10),
#        ('tote9', 'bathroom supplies', 'purple', 'no image', 0, 0, 11),
#        ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 11),
#        ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 11),
#        ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 11),
#        ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 11),
#        ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 11),
#        ('tote9', 'bathroom supplies', 'purple', 'no image', 0, 0, 12),
#        ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 12),
#        ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 12),
#        ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 12),
#        ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 12),
#        ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 12),
#        ('tote9', 'bathroom supplies', 'purple', 'no image', 0, 0, 133),
#        ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 13),
#        ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 13),
#        ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 13),
#        ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 13),
#        ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 13),
#        ('tote9', 'bathroom supplies', 'purple', 'no image', 0, 0, 14),
#        ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 14),
#        ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 14),
#        ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 14),
#        ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 14),
#        ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 14),
#        ('tote9', 'bathroom supplies', 'purple', 'no image', 0, 0, 15),
#        ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 15),
#        ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 15),
#        ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 15),
#        ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 15),
#        ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 15),
#        ('tote9', 'bathroom supplies', 'purple', 'no image', 0, 0, 16),
#        ('tote2', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 16),
#        ('tote3', 'bathroom supplies', 'purple', 'no image', 0, 0, 16),
#        ('tote4', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 16),
#        ('tote5', 'bathroom supplies', 'purple', 'no image', 0, 0, 16),
#        ('tote6', 'kitchen supplies', 'blue', 'fakeurl', 0, 0, 16);

INSERT INTO items (name, keywords, value, color, file_stack_url, checked_out, space_id)
VALUES ('sofa', 'red sofa sectional', 1000, 'red', 'wwww.fakeurl.com', 0, 1),
       ('cody the duck', 'rubber, yellow, duck, bath toys, kids', 3, 'purple', 'no image', 0, 1),
       ('monitor', 'computer, electronics, office', 150, 'purple', 'no image', 0, 1),
       ('laptop', 'computer, electronics, office', 1700, 'purple', 'no image', 0, 1),
       ('purse', 'clothes, pink', 700, 'purple', 'no image', 0, 1),
       ('sofa', 'red sofa sectional', 2000, 'red', 'wwww.fakeurl.com', 0, 2),
       ('cody the duck', 'rubber, yellow, duck, bath toys, kids', 3, 'purple', 'no image', 0, 2),
       ('monitor', 'computer, electronics, office', 250, 'purple', 'no image', 0, 2),
       ('laptop', 'computer, electronics, office', 2700, 'purple', 'no image', 0, 2),
       ('purse', 'clothes, pink', 700, 'purple', 'no image', 0, 2),
       ('sofa', 'red sofa sectional', 3000, 'red', 'wwww.fakeurl.com', 0, 3),
       ('cody the duck', 'rubber, yellow, duck, bath toys, kids', 3, 'purple', 'no image', 0, 3),
       ('monitor', 'computer, electronics, office', 350, 'purple', 'no image', 0, 3),
       ('laptop', 'computer, electronics, office', 3700, 'purple', 'no image', 0, 3),
       ('purse', 'clothes, pink', 700, 'purple', 'no image', 0, 3);



