

create table appuser (
	id number,
	firstName varchar2(50),
	lastName varchar2(50),
	userName varchar2(50),
	password varchar2(50),
	constraint appuser_pk primary key (id),
	constraint appuser_uk unique (userName)
	);
	
create table judge (
	id number,
	name varchar2(50),
	constraint judge_pk primary key (id),
	constraint judge_uk unique (name)) ;
	
	
create table tournament (
	id number,
	name varchar2(100),
	judge_id number,
	tournamentdate date,
	tournament_type number,
	constraint tournament_pk primary key (id));
	
ALTER TABLE tournament
ADD CONSTRAINT tournament_fk1
   FOREIGN KEY (judge_id)
   REFERENCES judge (id);	

	
ALTER TABLE tournament
ADD CONSTRAINT tournament_fk2
   FOREIGN KEY (tournament_type)
   REFERENCES t_tournament_type (id);	

	
create table t_tournament_type (
	id number,
	description varchar2(100),
	constraint t_tournament_type_pk primary key (id));
	
insert into t_tournament_type (id , description) values(1, 'круговая система' );
insert into t_tournament_type (id , description) values(2, 'швейцарская система' );
insert into t_tournament_type (id , description) values(3, 'олимпийская система' );

create table t_degree (
	id number,
	description varchar2(100),
	degree_tier number,
	constraint t_degree_pk primary key (id));
	
insert into t_degree (id, description, degree_tier) values(1, 'Любитель', 1);	
insert into t_degree (id, description, degree_tier) values(2, 'Первый Разряд', 1);
insert into t_degree (id, description, degree_tier) values(3, 'КМС израиля', 2);
insert into t_degree (id, description, degree_tier) values(4, 'КМС', 2);
insert into t_degree (id, description, degree_tier) values(5, 'МС Израиля', 3);
insert into t_degree (id, description, degree_tier) values(6, 'МС международный', 3);
insert into t_degree (id, description, degree_tier) values(7, 'МС ФМЖД', 3);
insert into t_degree (id, description, degree_tier) values(8, 'МС СССР', 3);
insert into t_degree (id, description, degree_tier) values(9, 'ГМС Израиля', 4);
insert into t_degree (id, description, degree_tier) values(10, 'ГМС Международный', 4);
insert into t_degree (id, description, degree_tier) values(11, 'ГМС ФМЖД', 4);
insert into t_degree (id, description, degree_tier) values(12, 'ГМС СССР', 4);


create table player (
	id number,
	player_name varchar2(100),
	player_last_name varchar2(100),
	player_rating number,
	player_degree number,
	player_photo varchar2(100),
	birth_date date,
	constraint player_pk primary key (id),
	CONSTRAINT player_fk1 FOREIGN KEY (player_degree) REFERENCES t_degree (id));	
	
insert into player
	(id,player_name,player_last_name,player_rating,player_degree,birth_date)
	values(1,'Александр','Гантман', 1650, 9, to_date('19650515', 'yyyymmdd'));

insert into player
	(id,player_name,player_last_name,player_rating,player_degree,birth_date)
	values(2,'Илья','Померанец', 1550, 5, to_date('19860819', 'yyyymmdd'));
	
	
	select to_date('19650515', 'yyyymmdd') from dual
commit




select * from t_tournament_type;	
select * from t_degree;
select * from player;
select * from tournament;