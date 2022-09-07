DROP TABLE IF EXISTS test_board;

-- TEST BOARD
CREATE TABLE IF NOT EXISTS test_board(
	bno int PRIMARY KEY auto_increment,
	title VARCHAR(50),
	content TEXT,
	writer VARCHAR(50),
	regdate TIMESTAMP default now(),
	viewcnt int default 0
);

INSERT INTO test_board 
SELECT title,content,writer FROM test_board;

DROP TABLE IF EXISTS test_sboard;
-- SEARCH BOARD
CREATE TABLE IF NOT EXISTS test_sboard(
	bno int PRIMARY KEY auto_increment,
	title VARCHAR(200) NOT NULL,
	content text NOT NULL,
	writer VARCHAR(50) NOT NULL,
	regdate TIMESTAMP default now(),
	updatedate TIMESTAMP default now(),
	viewcnt int default 0
);

INSERT INTO test_sboard(title,content,writer)
select title,content,writer FROM test_sboard;







