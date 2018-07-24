use javadb;

CREATE TABLE student (
    sid INT primary key AUTO_INCREMENT,
    sname VARCHAR(50),
    sgender VARCHAR(10),
    sscore INT
);

insert into student(sname, sgender, sscore) values('李少荣','女', 80);
insert into student(sname, sgender, sscore) values('邵凯', '女', 80);
insert into student(sname, sgender, sscore) values('周强', '男', 95);
insert into student(sname, sgender, sscore) values('王晓婷', '女', 55);
insert into student(sname, sgender, sscore) values('张秀花', '女', 68);
insert into student(sname, sgender, sscore) values('顾会', '女', 50);
insert into student(sname, sgender, sscore) values('赵天一', '男', 32);
insert into student(sname, sgender, sscore) values('张天二', '男', 32);

SELECT * FROM student;

SELECT COUNT(*) FROM student WHERE sgender='女' && sscore>=80;

SELECT sid,sname FROM student WHERE sgender='男';
SELECT * FROM student WHERE sgender='女' && sscore>60;
SELECT AVG(sscore) as avescore FROM student WHERE sgender='男';
SELECT AVG(sscore) as avescore FROM student WHERE sgender='女';
SELECT AVG(sscore) as avescore FROM student;

DELETE FROM student WHERE sid=11;

SELECT AVG(sscore) FROM student WHERE sgender='女';

UPDATE student SET sid=13,sname='s',sgender='b',sscore=23;

