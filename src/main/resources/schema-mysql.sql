
drop table IF EXISTS scores;
create table scores (id integer not null, email varchar(255), score integer not null, primary key (id));
drop table IF EXISTS user;
drop table IF EXISTS Candidate;
create TABLE `user` (
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `id` varchar(45) DEFAULT NULL
);
create TABLE `Candidate` (
                        `firstname` varchar(45) DEFAULT NULL,
                        `lastname` varchar(45) DEFAULT NULL,
                        `username` varchar(45) DEFAULT NULL,
                        `email` varchar(100) DEFAULT NULL,
                        `phone` varchar(45) DEFAULT NULL,
                        `password` varchar(45) DEFAULT NULL,
                        `gender` varchar(45) DEFAULT NULL,
                        `city` varchar(45) DEFAULT NULL,
                        `id` INT AUTO_INCREMENT PRIMARY KEY
);
insert into `Candidate`
(`username`,
 `password`,
 `firstname`,
 `lastname`,
 `phone`,
 `email`,
 `gender`,
 `city`, `id`)
VALUES
('sravani','abcded','sravani123','unknown','878687','srav@outlook.com','female', 'knl',33);
drop table IF EXISTS product;
create TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(100) NOT NULL,
  `quantity` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `date_` varchar(100) NOT NULL,
  PRIMARY KEY (`pid`)
);
insert into `product`
(`pname`,
`quantity`,
`price`,
`date_`)
VALUES('Laptop','50','120','33-10-9891');
select * from scores;
insert into `scores`(`email`, `score`, `id`) values ('kumar@gmail.com', 20, 1001);
insert into `scores`(`email`, `score`, `id`) values ('prashanth@gmail.com', 40, 1002);
insert into `user`
(`username`,
`password`,
`firstname`,
`lastname`,
`phone`,
`email`,
`gender`,`id`)
VALUES
('ramana','rao','ramanafirst','ramanalast','123456','m.ramana@outlook.com','male','1');


insert into `user`
(`username`,
`password`,
`firstname`,
`lastname`,
`phone`,
`email`,
`gender`,`id`)
VALUES
('sudharshan','kumar','sudhar','kumar','898989','sudhar.kumar@outlook.com','male','2');
insert into `user`
(`username`,
`password`,
`firstname`,
`lastname`,
`phone`,
`email`,
`gender`,`id`)
VALUES
('vasanth','babu','vashanthababu','super','98966666','v.babua@outlook.com','male','3');

insert into `user`
(`username`,
`password`,
`firstname`,
`lastname`,
`phone`,
`email`,
`gender`,`id`)
VALUES
('appu','angel','appuangel','unknown','9898989','appu@outlook.com','female','4');

insert into `user`
(`username`,
`password`,
`firstname`,
`lastname`,
`phone`,
`email`,
`gender`,`id`)
VALUES
('sravani','abcded','sravani123','unknown','878687','srav@outlook.com','female','5');




