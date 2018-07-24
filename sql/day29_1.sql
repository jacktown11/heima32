USE javadb;

CREATE TABLE sort (
    sid INT PRIMARY KEY AUTO_INCREMENT,
    sname VARCHAR(80)
);

insert into sort(sname) values('家电');
insert into sort(sname) values('服饰');
insert into sort(sname) values('化妆品');

SELECT * FROM sort;