--top categories
INSERT INTO category(id, name) VALUES
(1, 'Programming'),
(2, 'Fiction'),
(3, 'Music'),
(4, 'Movies'),
(5, 'Fitness'),
(6, 'Science');

--subcategories for the Programming category
INSERT INTO category(id, name) VALUES
(7, 'Programming Languages'),
(8, 'Questions'),
(9, 'General'),
(10, 'Algorithms & DSA'),
(11, 'Backend'),
(12, 'Frontend');

--set Programming Languages as a subcategory of Programming
INSERT INTO category_relation(id, parent_category_id, child_category_id) VALUES
(1, 1, 7);

--tags for the Programming Languages category
INSERT INTO tag(id, name) VALUES
(1, 'Java'),
(2, 'C#'),
(3, 'Scala'),
(4, 'Kotlin'),
(5, 'Python'),
(6, 'Javascript');

--threads for the Programming Languages category
INSERT INTO thread(id, title, category_id) VALUES
(1, 'What are Java Records?', 7),
(2, 'Understanding Java Records', 7),
(3, 'Scala vs Kotlin: A Comparison', 7),
(4, 'Java in Microservices Architecture', 7);
