# USE traqura_db;

INSERT INTO users (email, first_name, last_name, password)
VALUES ('taradactyl@dino.com', 'Tara', 'Dactyl', '$2a$10$wEc65/etNcCBKYLzlHTvvOILPkbi9DyFnIHaLRK8HO7vMArTZJIn2'),
       ('terrancerex@dino.com', 'Terrance', 'Rex', '$2a$10$8.DVek/KxqJ9BfV2ZkNlEOjXqD7lrD5M0AhD0SXbPowSiA8YOmxK2'),
       ('tri-sara@dino.com', 'Sara', 'Triceratops', '$2a$10$U5H/HJjxrRheOH784Qw1au6Cn0ZJtuDgfyrXh27DszVsTzG1bcIfC'),
       ('v-raptor@dino.com', 'Vicente', 'Raptor', '$2a$10$U5H/HJjxrRheOH784Qw1au6Cn0ZJtuDgfyrXh27DszVsTzG1bcIfC');

INSERT INTO spaces (user_id, name,file_stack_url, keywords)
VALUES (1, 'living room', 'https://cdn.filestackcontent.com/CoL42emPS7SOaId13J4X', 'sofa, family, tv'),
       (1, 'Kitchen', 'https://cdn.filestackcontent.com/f7ImcSd4QViUi9UINJWQ', 'lighter'),
       (1, 'Garage', 'https://cdn.filestackcontent.com/Bpjxpfs7SDS7tgf6r0Lz', 'garage, christmas, tools, pool'),
       (1, 'Office', 'https://cdn.filestackcontent.com/JirYxoAJScW4ZSHnb3oi', 'office computer printer work'),
       (1, 'Master Bedroom', 'https://cdn.filestackcontent.com/5QKgEpFdR0yQE2FpS6Qr', 'bedding');

INSERT INTO totes (name, keywords, file_stack_url, space_id)
VALUES ('TV Stand', 'movies, cds, books, board games', 'https://cdn.filestackcontent.com/nNJFYmhITZCnBi7FPgfT', 1);

INSERT INTO items (name, keywords, file_stack_url, tote_id, value)
VALUES ('The Puffin in Bloom Collection Books', 'Little Women, Anne of Green Gables, A Little Prince, Heidi', 'https://cdn.filestackcontent.com/XKLPTpeSvmaVCcKNy0tg', 1, 36);