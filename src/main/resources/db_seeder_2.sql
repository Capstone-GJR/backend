USE traqura_db;

INSERT INTO users (email, first_name, last_name, password)
VALUES ('TaraDactyl@dino.com', 'Tara', 'Dactyl', '$2a$10$wEc65/etNcCBKYLzlHTvvOILPkbi9DyFnIHaLRK8HO7vMArTZJIn2'),
       ('TerranceRex@dino.com', 'Terrance', 'Rex', '$2a$10$8.DVek/KxqJ9BfV2ZkNlEOjXqD7lrD5M0AhD0SXbPowSiA8YOmxK2'),
       ('tri-sara@dino.com', 'Sara', 'Triceratops', '$2a$10$U5H/HJjxrRheOH784Qw1au6Cn0ZJtuDgfyrXh27DszVsTzG1bcIfC'),
       ('v-raptor@dino.com', 'Vicente', 'Raptor', '$2a$10$U5H/HJjxrRheOH784Qw1au6Cn0ZJtuDgfyrXh27DszVsTzG1bcIfC');

INSERT INTO spaces (name, keywords, file_stack_url, color, user_id)
VALUES ('living room', 'living room sofa family', 'https://cdn.filestackcontent.com/P21lCTrPQmK8sLbcIRmL', 'pink', 1),
       ('Kitchen', 'kitchen', 'https://cdn.filestackcontent.com/gJPmLlkRRTRI4LF5lDSw', 'green', 1),
       ('Garage', 'garage christmas tools pool', '"https://cdn.filestackcontent.com/Y1CH6J8vRnqYsKw0fAng"', 'blue', 1),
       ('Office', 'office computer printer work', 'https://cdn.filestackcontent.com/lInb1BjLTe2uGgSsMtUZ', 'purple', 1),
       ('Master Bedroom', 'bedding', 'https://cdn.filestackcontent.com/lInb1BjLTe2uGgSsMtUZ', 'purple', 1);

INSERT INTO totes (name, keywords, file_stack_url, color, space_id)
VALUES ('TV Stand', 'movies, cds, books, board games', 'https://cdn.filestackcontent.com/e6kW3zccRlu1ZliKtF4F', '#8321a6', 1);

INSERT INTO items (name, keywords, file_stack_url, color, tote_id, value)
VALUES ('The Puffin in Bloom Collection Books', 'Little Women, Anne of Green Gables, A Little Prince, Heidi', 'https://cdn.filestackcontent.com/e6kW3zccRlu1ZliKtF4F', '#ee1bd2', 1, 36);