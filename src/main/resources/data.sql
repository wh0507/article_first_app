-- article ダミーデータ
INSERT INTO article(id, title, content) VALUES(1, 'ああああ', '1111');
INSERT INTO article(id, title, content) VALUES(2, 'いいいい', '2222');
INSERT INTO article(id, title, content) VALUES(3, 'うううう', '3333');

-- article ダミーデータ
INSERT INTO article(id, title, content) VALUES(4, '映画は?', 'コメントGO！');
INSERT INTO article(id, title, content) VALUES(5, '食べ物は?', 'コメントGOGO！');
INSERT INTO article(id, title, content) VALUES(6, '趣味は?', 'コメントGOGOGO！');

INSERT INTO article(id, title, content) VALUES(7, 'JAVA?', 'コメントGO！');
INSERT INTO article(id, title, content) VALUES(8, 'SPRING?', 'コメントGOGO！');
INSERT INTO article(id, title, content) VALUES(9, 'JPA?', 'コメントGOGOGO！');
INSERT INTO article(id, title, content) VALUES(10, 'ORM?', 'コメントGOGOGO！');

-- comment ダミーデータ
---- 4番 Article -> Comment
INSERT INTO comment(id, article_id, nickname, body) VALUES(1, 4, 'Sato', 'Marvel');
INSERT INTO comment(id, article_id, nickname, body) VALUES(2, 4, 'Okahara', 'Starwars');
INSERT INTO comment(id, article_id, nickname, body) VALUES(3, 4, 'Yamato', 'Parasite');
---- 5番 Article -> Comment
INSERT INTO comment(id, article_id, nickname, body) VALUES(4, 5, 'Sato', 'チキン');
INSERT INTO comment(id, article_id, nickname, body) VALUES(5, 5, 'Okahara', 'しゃぶしゃぶ');
INSERT INTO comment(id, article_id, nickname, body) VALUES(6, 5, 'Yamato', 'お寿司');
---- 6番 Article -> Comment
INSERT INTO comment(id, article_id, nickname, body) VALUES(7, 6, 'Sato', 'ダイビング');
INSERT INTO comment(id, article_id, nickname, body) VALUES(8, 6, 'Okahara', 'YouTube');
INSERT INTO comment(id, article_id, nickname, body) VALUES(9, 6, 'Yamato', '読書');

-- aritcle_id 連番--
SELECT setval('article_id_seq',(SELECT MAX(id)FROM article));
-- comment_id 連番--
SELECT setval('comment_id_seq',(SELECT MAX(id)FROM comment));