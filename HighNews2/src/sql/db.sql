show tables;

desc newsBean
desc newstypeBean
SELECT * FROM usersBean;
SELECT * FROM newsBean;
SELECT * FROM newstypeBean;


delete from newsBean where newsid=1;
update  newsBean set newstitle ='新更改头条'  where newsid=1; 