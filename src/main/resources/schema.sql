DROP TABLE IF EXISTS category CASCADE;
DROP TABLE IF EXISTS category_relation CASCADE;
DROP TABLE IF EXISTS thread CASCADE;
DROP TABLE IF EXISTS tag CASCADE;
DROP TABLE IF EXISTS thread_tag CASCADE;
DROP TABLE IF EXISTS post CASCADE;

-- Category Table
CREATE TABLE category (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- CategoryRelation Table
CREATE TABLE category_relation (
    id BIGSERIAL PRIMARY KEY,
    parent_category_id BIGINT REFERENCES category(id),
    child_category_id BIGINT REFERENCES category(id)
);

-- Tag Table
CREATE TABLE tag (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Thread Table
CREATE TABLE thread (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    category_id BIGINT REFERENCES category(id)
);

-- ThreadTags Table
CREATE TABLE thread_tag (
    id BIGSERIAL PRIMARY KEY,
    thread_id BIGINT REFERENCES thread(id),
    tag_id BIGINT REFERENCES tag(id)
);

-- Post Table
CREATE TABLE post (
    id BIGSERIAL PRIMARY KEY,
    content TEXT,
    thread_id BIGINT REFERENCES thread(id)
);