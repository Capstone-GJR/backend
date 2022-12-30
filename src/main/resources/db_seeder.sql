USE traqura_db;


INSERT INTO users (email, first_name, last_name, password)
VALUES ('TaraDactyl@dino.com', 'Tara', 'Dactyl', '$2a$10$wEc65/etNcCBKYLzlHTvvOILPkbi9DyFnIHaLRK8HO7vMArTZJIn2'),
       ('TerranceRex@dino.com', 'Terrance', 'Rex', '$2a$10$8.DVek/KxqJ9BfV2ZkNlEOjXqD7lrD5M0AhD0SXbPowSiA8YOmxK2'),
       ('tri-sara@dino.com', 'Sara', 'Triceratops', '$2a$10$U5H/HJjxrRheOH784Qw1au6Cn0ZJtuDgfyrXh27DszVsTzG1bcIfC'),
       ('v-raptor@dino.com', 'Vicente', 'Raptor', '$2a$10$U5H/HJjxrRheOH784Qw1au6Cn0ZJtuDgfyrXh27DszVsTzG1bcIfC');

INSERT INTO spaces (name, keywords, file_stack_url, color, user_id)
VALUES ('living room', 'living room family room', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'pink', 4),
       ('front closet', 'closet, coats', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'purple', 4),
       ('kitchen', 'kitchen', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'blue', 4),
       ('bathroom', 'bathroom', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'purple', 4),
       ('living room', 'living room family room', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'pink', 3),
       ('front closet', 'closet, coats', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'purple', 3),
       ('kitchen', 'kitchen', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'blue', 3),
       ('bathroom', 'bathroom', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'purple', 3),
       ('living room', 'living room family room', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'pink', 2),
       ('front closet', 'closet, coats', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'purple', 2),
       ('kitchen', 'kitchen', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'blue', 2),
       ('bathroom', 'bathroom', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'purple', 2),
       ('living room', 'living room family room', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'pink', 1),
       ('front closet', 'closet, coats', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'purple', 1),
       ('kitchen', 'kitchen', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'blue', 1),
       ('bathroom', 'bathroom', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 'purple', 1);

INSERT INTO totes (name, keywords, color, file_stack_url, space_id)
VALUES ('tote1', 'bathroom supplies', 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 1),
       ('tote2', 'kitchen supplies', 'blue', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 1),
       ('tote3', 'bathroom supplies', 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve',  1),
       ('tote4', 'kitchen supplies', 'blue', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 1),
       ('tote5', 'bathroom supplies', 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 1),
       ('tote6', 'kitchen supplies', 'blue', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve',1),
       ('tote1', 'bathroom supplies', 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 2),
       ('tote2', 'kitchen supplies', 'blue', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 2),
       ('tote3', 'bathroom supplies', 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve',  2),
       ('tote4', 'kitchen supplies', 'blue', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve',  2),
       ('tote5', 'bathroom supplies', 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve',  2),
       ('tote6', 'kitchen supplies', 'blue', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve',  2),
       ('tote1', 'bathroom supplies', 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve',  3),
       ('tote2', 'kitchen supplies', 'blue', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve',  3),
       ('tote3', 'bathroom supplies', 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve',  3),
       ('tote4', 'kitchen supplies', 'blue', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve',  3),
       ('tote5', 'bathroom supplies', 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve',  3),
       ('tote6', 'kitchen supplies', 'blue', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 3),
       ('tote4', 'bathroom supplies', 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 4),
       ('tote2', 'kitchen supplies', 'blue', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve',  4),
       ('tote3', 'bathroom supplies', 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve',  4),
       ('tote4', 'kitchen supplies', 'blue', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 4),
       ('tote5', 'bathroom supplies', 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 4),
       ('tote6', 'kitchen supplies', 'blue', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 4);


INSERT INTO items (name, keywords, value, color, file_stack_url, tote_id)
VALUES ('sofa', 'red sofa sectional', 1000, 'red', 'https://cdn.filestackcontent.com/zL4Rlp1uR5ONHSJXoNkB', 1),
       ('cody the duck', 'rubber, yellow, duck, bath toys, kids', 3, 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 1),
       ('monitor', 'computer, electronics, office', 150, 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 1),
       ('laptop', 'computer, electronics, office', 1700, 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve',1),
       ('purse', 'clothes, pink', 700, 'purple', 'https://cdn.filestackcontent.com/uVRSOH2uRQS9lb246Nve', 1),
       ('sofa', 'red sofa sectional', 2000, 'red', 'https://cdn.filestackcontent.com/zL4Rlp1uR5ONHSJXoNkB', 2),
       ('cody the duck', 'rubber, yellow, duck, bath toys, kids', 3, 'purple', 'https://cdn.filestackcontent.com/zL4Rlp1uR5ONHSJXoNkB',  2),
       ('monitor', 'computer, electronics, office', 250, 'purple', 'https://cdn.filestackcontent.com/zL4Rlp1uR5ONHSJXoNkB', 2),
       ('laptop', 'computer, electronics, office', 2700, 'purple', 'https://cdn.filestackcontent.com/zL4Rlp1uR5ONHSJXoNkB', 2),
       ('purse', 'clothes, pink', 700, 'purple', 'https://cdn.filestackcontent.com/zL4Rlp1uR5ONHSJXoNkB', 2),
       ('sofa', 'red sofa sectional', 3000, 'red', 'https://cdn.filestackcontent.com/zL4Rlp1uR5ONHSJXoNkB',  3),
       ('cody the duck', 'rubber, yellow, duck, bath toys, kids', 3, 'purple', 'https://cdn.filestackcontent.com/zL4Rlp1uR5ONHSJXoNkB', 3),
       ('monitor', 'computer, electronics, office', 350, 'purple', 'https://cdn.filestackcontent.com/zL4Rlp1uR5ONHSJXoNkB', 3),
       ('laptop', 'computer, electronics, office', 3700, 'purple', 'https://cdn.filestackcontent.com/zL4Rlp1uR5ONHSJXoNkB', 3),
       ('purse', 'clothes, pink', 700, 'purple', 'https://cdn.filestackcontent.com/zL4Rlp1uR5ONHSJXoNkB', 3);



