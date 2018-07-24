USE javadb;

CREATE TABLE userinfo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    uname VARCHAR(50),
    upassword VARCHAR(200)
);

INSERT INTO userinfo (uname, upassword) VALUES ('maozedong', '23454');
INSERT INTO userinfo (uname, upassword) VALUES ('wangbaoqiang', '33232');

SELECT * FROM userinfo WHERE uname='wangbaoqiang';

DELETE FROM userinfo WHERE id=3 OR id=5;