-- article ダミーデータ
INSERT INTO article(id, title, content) VALUES(1, 'ああああ', '1111');
INSERT INTO article(id, title, content) VALUES(2, 'いいいい', '2222');
INSERT INTO article(id, title, content) VALUES(3, 'うううう', '3333');

-- article ダミーデータ
INSERT INTO article(id, title, content) VALUES(4, '映画は?', 'コメントGO！');
INSERT INTO article(id, title, content) VALUES(5, '食べ物は?', 'コメントGOGO！');
INSERT INTO article(id, title, content) VALUES(6, '趣味は?', 'コメントGOGOGO！');

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