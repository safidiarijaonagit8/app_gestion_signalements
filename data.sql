create database signal;

use signal;

-- sha1 postgresql
create extension pgcrypto;

create table chefDeRegion(
	id_chef_de_region int not null,
	username varchar(150),
	mot_de_passe varchar(150),
	primary key(id_chef_de_region)
);

insert into chefDeRegion values(1, 'chefDeRegion1@gmail.com', encode(digest('Itasy','sha1'),'hex'));
insert into chefDeRegion values(2, 'chefDeRegion2@gmail.com', encode(digest('Bongolava','sha1'),'hex'));
insert into chefDeRegion values(3, 'chefDeRegion3@gmail.com', encode(digest('Analamanga','sha1'),'hex'));
insert into chefDeRegion values(4, 'chefDeRegion4@gmail.com', encode(digest('Vakinakaratra','sha1'),'hex'));
insert into chefDeRegion values(5, 'chefDeRegion5@gmail.com', encode(digest('Sofia','sha1'),'hex'));
insert into chefDeRegion values(6, 'chefDeRegion6@gmail.com', encode(digest('Sava','sha1'),'hex'));
insert into chefDeRegion values(7, 'chefDeRegion7@gmail.com', encode(digest('Diana','sha1'),'hex'));
insert into chefDeRegion values(8, 'chefDeRegion8@gmail.com', encode(digest('Antsinanana','sha1'),'hex'));
insert into chefDeRegion values(9, 'chefDeRegion9@gmail.com', encode(digest('Alaotra-Mangoro','sha1'),'hex'));
insert into chefDeRegion values(10, 'chefDeRegion10@gmail.com', encode(digest('Analanjirofo','sha1'),'hex'));
insert into chefDeRegion values(11, 'chefDeRegion11@gmail.com', encode(digest('Boeny','sha1'),'hex'));
insert into chefDeRegion values(12, 'chefDeRegion12@gmail.com', encode(digest('Betsiboka','sha1'),'hex'));
insert into chefDeRegion values(13, 'chefDeRegion13@gmail.com', encode(digest('Melaky','sha1'),'hex'));
insert into chefDeRegion values(14, 'chefDeRegion14@gmail.com', encode(digest('Anosy','sha1'),'hex'));
insert into chefDeRegion values(15, 'chefDeRegion15@gmail.com', encode(digest('Androy','sha1'),'hex'));
insert into chefDeRegion values(16, 'chefDeRegion16@gmail.com', encode(digest('Atsimo-Andrefana','sha1'),'hex'));
insert into chefDeRegion values(17, 'chefDeRegion17@gmail.com', encode(digest('Menabe','sha1'),'hex'));
insert into chefDeRegion values(18, 'chefDeRegion18@gmail.com', encode(digest('Atsimo-Atsinanana','sha1'),'hex'));
insert into chefDeRegion values(19, 'chefDeRegion19@gmail.com', encode(digest('Ihorombe','sha1'),'hex'));
insert into chefDeRegion values(20, 'chefDeRegion20@gmail.com', encode(digest('Vatovavy','sha1'),'hex'));
insert into chefDeRegion values(21, 'chefDeRegion21@gmail.com', encode(digest('Fitovinany','sha1'),'hex'));
insert into chefDeRegion values(22, 'chefDeRegion22@gmail.com', encode(digest('Amoron i mania','sha1'),'hex'));
insert into chefDeRegion values(23, 'chefDeRegion23@gmail.com', encode(digest('Haute Matsiatra','sha1'),'hex'));


create table tokenChefDeRegion(
	id_token_chef_de_region serial not null,
	id_chef_de_region int not null,
	token varchar(150) not null,
	primary key(id_token_chef_de_region),
	foreign key(id_chef_de_region) references chefDeRegion(id_chef_de_region)
);



create table Region(
	id_region int not null,
	id_chef_de_region int not null,
	nom_region varchar(50) not null,
	primary key(id_region),
	foreign key(id_chef_de_region) references chefDeRegion(id_chef_de_region)
);
/* par defaut non affecte le signal*/
insert into Region values(0, 1, 'non affecte');

insert into Region values(1, 1, 'Itasy');
insert into Region values(2, 2, 'Bongolava');
insert into Region values(3, 3, 'Analamanga');
insert into Region values(4, 4, 'Vakinakaratra');
insert into Region values(5, 5, 'Sofia');
insert into Region values(6, 6, 'Sava');
insert into Region values(7, 7, 'Diana');
insert into Region values(8, 8, 'Antsinanana');
insert into Region values(9, 9, 'Alaotra-Mangoro');
insert into Region values(10, 10, 'Analanjirofo');
insert into Region values(11, 11, 'Boeny');
insert into Region values(12, 12, 'Betsiboka');
insert into Region values(13, 13, 'Melaky');
insert into Region values(14, 14, 'Anosy');
insert into Region values(15, 15, 'Androy');
insert into Region values(16, 16, 'Atsimo-Andrefana');
insert into Region values(17, 17, 'Menabe');
insert into Region values(18, 18, 'Atsimo-Atsinanana');
insert into Region values(19, 19, 'Ihorombe');
insert into Region values(20, 20, 'Vatovavy');
insert into Region values(21, 21, 'Fitovinany');
insert into Region values(22, 22, 'Amoron i mania');
insert into Region values(23, 23, 'Haute Matsiatra');




create table administrateur(
	id_adiminstrateur int not null,
	username varchar(150) not null,
	mot_de_passe varchar(150) not null,
	primary key(id_adiminstrateur)
);


insert into administrateur values(2,encode(digest('admin1','sha1'),'hex'),'administrateur1@gmail.com');
insert into administrateur values(3, 'administrateur2@gmail.com', encode(digest('admin2','sha1'),'hex'));



create table utilisateur(
	id_utilisateur serial not null,
	nom varchar(150) not null,
	prenom varchar(150) not null,
	naissance date not null,
	genre varchar(50) not null,
	username varchar(150) not null,
	mot_de_passe varchar(150) not null,
	primary key(id_utilisateur)
);
insert into utilisateur(nom, prenom, naissance, genre, username, mot_de_passe) values('RAKOTOHARISON', 'Jonathan', '2000-12-16', 'Hommes', 'rakotoharison@gmail.com', encode(digest('rakotoharison', 'sha1'),'hex'));
insert into utilisateur(nom, prenom, naissance, genre, username, mot_de_passe) values('RAKOTOSON', 'Joseph', '2000-04-16', 'Hommes', 'rakotoson@gmail.com', encode(digest('rakotoson', 'sha1'),'hex'));


create table token(
	id_token serial not null,
	id_utilisateur int not null,
	token varchar(150) not null,
	primary key(id_token),
	foreign key(id_utilisateur) references utilisateur(id_utilisateur)
);



create table status_signalementement(
	id_status_signalement int not null,
	status_signalement varchar(50) not null,
	primary key(id_status_signalement)
);

insert into status_signalementement values(1, 'Nouveau');
insert into status_signalementement values(2, 'En cours de traitement');
insert into status_signalementement values(3, 'Terminé');

create table typeSignalement(
	id_type_signalement int not null,
	type_signalement varchar(50) not null,
	couleur_signalement varchar(30) not null,
	primary key(id_type_signalement)
);

insert into typeSignalement values(1, 'Route abimée', 'Jaune');
insert into typeSignalement values(2, 'Ordures', 'Vert');
insert into typeSignalement values(3, 'Accident', 'Rouge');
insert into typeSignalement values(4, 'Pont abimée', 'Blanc');
insert into typeSignalement values(5, 'Incendies', 'Orange');
insert into typeSignalement values(6, 'Inondations', 'Blue');


create table signalement (
	id_signalement serial not null,
	id_type_signalement int not null,
	id_region int default null,
	id_utilisateur int not null,
	longitude decimal(20,10) not null,
	latitude decimal(20,10) not null,
	description_signal varchar(100),
	date_signal date not null,
	heure_signal time not null,
	primary key(id_signalement),
	foreign key(id_region) references Region(id_region),
	foreign key(id_utilisateur) references utilisateur(id_utilisateur),
	foreign key(id_type_signalement) references typeSignalement(id_type_signalement)
);

insert into signalement(date_signal,description_signal,heure_signal,id_region,id_type_signalement,id_utilisateur,latitude,longitude) values('2022-01-21','signalement test','08:04:00',0,1,1,-45.1234,92.234512);
insert into signalement(date_signal,description_signal,heure_signal,id_region,id_type_signalement,id_utilisateur,latitude,longitude) values('2022-02-21','signalement test','18:04:00',0,1,1,-45.1234,32.234512);
insert into signalement(date_signal,description_signal,heure_signal,id_region,id_type_signalement,id_utilisateur,latitude,longitude) values('2022-03-21','signalement test','12:04:00',0,2,1,-45.1234,102.234512);

insert into signalement (id_type_signalement, id_region, id_utilisateur, longitude, latitude, description_signal, date_signal, heure_signal) values(1, 0, 1, 92.234512, -45.1234, 'signalement test', '2022-01-21', '08:04:00');
insert into signalement (id_type_signalement, id_region, id_utilisateur, longitude, latitude, description_signal, date_signal, heure_signal) values(4,0, 2, 56.46578, -23.12034, 'signalement test', '2022-01-21', '10:45:50');
insert into signalement (id_type_signalement, id_region, id_utilisateur, longitude, latitude, description_signal, date_signal, heure_signal) values(5, 0, 2, 92.234512, -45.1234, 'signalement test', '2022-01-21', '07:12:11');
insert into signalement (id_type_signalement, id_region, id_utilisateur, longitude, latitude, description_signal, date_signal, heure_signal) values(6, 0, 2, 56.46578, -23.12034, 'signalement test', '2022-01-21', '08:30:45');
insert into signalement (id_type_signalement, id_region, id_utilisateur, longitude, latitude, description_signal, date_signal, heure_signal) values(3, 0, 1, 92.234512, -45.1234, 'signalement test', '2022-01-21', '08:04:00');
insert into signalement (id_type_signalement, id_region, id_utilisateur, longitude, latitude, description_signal, date_signal, heure_signal) values(3,0, 2, 56.46578, -23.12034, 'signalement test', '2022-01-21', '10:45:50');
insert into signalement (id_type_signalement, id_region, id_utilisateur, longitude, latitude, description_signal, date_signal, heure_signal) values(5, 0, 2, 92.234512, -45.1234, 'signalement test', '2022-01-21', '07:12:11');
insert into signalement (id_type_signalement, id_region, id_utilisateur, longitude, latitude, description_signal, date_signal, heure_signal) values(5, 0, 2, 56.46578, -23.12034, 'signalement test', '2022-01-21', '08:30:45');



create table photoSignalement(
	id_photo_signalement serial not null,
	id_signalement int not null REFERENCES signalement(id_signalement) ON DELETE CASCADE, /* cascade*/
	nom_photo varchar(150) not null, 
	primary key(id_photo_signalement)
	/*foreign key(id_signalement) references signalement(id_signalement)*/
);
insert into photoSignalement (id_signalement, nom_photo) values(1, 'image1.jpg');
insert into photoSignalement (id_signalement, nom_photo) values(1, 'image2.jpg');
insert into photoSignalement (id_signalement, nom_photo) values(2, 'image3.jpg');
insert into photoSignalement (id_signalement, nom_photo) values(2, 'image4.jpg');
insert into photoSignalement (id_signalement, nom_photo) values(3, 'image5.jpg');
insert into photoSignalement (id_signalement, nom_photo) values(3, 'image6.jpg');
insert into photoSignalement (id_signalement, nom_photo) values(4, 'image7.jpg');
insert into photoSignalement (id_signalement, nom_photo) values(4, 'image8.jpg');

/*tsy nampiasaiko ty table ty*/
create table affectation(
	id_affectation serial not null,
	id_signalement int not null,
	id_status_signalement int not null,
	date_affectation date not null,
	heure_affectation time not null,
	primary key(id_affectation),
	foreign key(id_status_signalement) references status_signalementement(id_status_signalement),
	foreign key(id_signalement) references signalement(id_signalement)
);
insert into affectation (id_signalement, id_status_signalement, date_affectation, heure_affectation) values (1, 1, '2022-01-21', '12:30:00');
insert into affectation (id_signalement, id_status_signalement, date_affectation, heure_affectation) values (2, 1, '2022-01-21', '12:30:05');
insert into affectation (id_signalement, id_status_signalement, date_affectation, heure_affectation) values (3, 1, '2022-01-21', '12:30:20');
insert into affectation (id_signalement, id_status_signalement, date_affectation, heure_affectation) values (4, 1, '2022-01-21', '12:30:30');
/* */

create table notification(
	id_notification serial not null,
	id_utilisateur int not null,
	message varchar(255) not null,
	date_notification date not null,
	heure_notification time not null,
	primary key(id_notification),
	foreign key(id_utilisateur) references utilisateur(id_utilisateur)
);



insert into notification (id_utilisateur, message, date_notification, heure_notification)values(1, 'signalement terminée', '2022-02-21', '06:06:50');
insert into notification (id_utilisateur, message, date_notification, heure_notification)values(2, 'signalement terminée', '2022-02-20', '07:30:50');

/*table vaovao*/
create table statusParSignal(
	id serial not null primary key,
	id_signalement int not null REFERENCES signalement(id_signalement) ON DELETE CASCADE,
	id_status_signalement int not null REFERENCES status_signalementement(id_status_signalement) ON DELETE CASCADE
);

insert into statusParSignal(id_signalement,id_status_signalement) values(1,1);
insert into statusParSignal(id_signalement,id_status_signalement) values(2,1);
insert into statusParSignal(id_signalement,id_status_signalement) values(3,2);
insert into statusParSignal(id_signalement,id_status_signalement) values(8,1);
insert into statusParSignal(id_signalement,id_status_signalement) values(9,3);
insert into statusParSignal(id_signalement,id_status_signalement) values(10,3);
insert into statusParSignal(id_signalement,id_status_signalement) values(11,3);
insert into statusParSignal(id_signalement,id_status_signalement) values(12,2);
/*vues nampiasaiko*/ 
create view v_statGlobalStatut as select count(id_signalement) as nbr,ss.status_signalement from statusParSignal s join status_signalementement ss on s.id_status_signalement=ss.id_status_signalement group by status_signalement; 
create view v_stattyperegion as select count(id_signalement) as nbr,type_signalement from signalement s join typeSignalement ts on s.id_type_signalement = ts.id_type_signalement group by type_signalement;


create view v_detailsignal as select id_signalement,type_signalement,r.nom_region,nom,prenom,longitude,latitude,description_signal,date_signal,heure_signal
from signalement s 
join typeSignalement ts 
on s.id_type_signalement = ts.id_type_signalement
join Region r 
on s.id_region=r.id_region 
join utilisateur u 
on s.id_utilisateur=u.id_utilisateur;

/**/


create view v_affectation as select
	status_signalementement.id_status_signalement,
	status_signalementement.status_signalement,
	affectation.id_affectation,
	affectation.id_signalement,
	affectation.date_affectation,
	affectation.heure_affectation
from status_signalementement join affectation on status_signalementement.id_status_signalement = affectation.id_status_signalement;


create view v_utilisateur as select
	utilisateur.id_utilisateur,
	utilisateur.nom,
	utilisateur.prenom,
	utilisateur.naissance,
	utilisateur.genre,
	utilisateur.adresse,
	utilisateur.username,
	utilisateur.mot_de_passe,
	token.token
from utilisateur join token on utilisateur.id_utilisateur = token.id_utilisateur;

create view v_signalement as select
	signalement.id_signalement,
	signalement.id_type_signalement,
	signalement.id_region,
	signalement.id_utilisateur,
	signalement.longitude,
	signalement.latitude,
	signalement.description_signal,
	signalement.date_signal,
	signalement.heure_signal,
	photoSignalement.id_photo_signalement,
	photoSignalement.nom_photo
from signalement join photoSignalement on signalement.id_signalement = photoSignalement.id_signalement;


create view v_region as select
	chefDeRegion.id_chef_de_region,
	chefDeRegion.username,
	chefDeRegion.mot_de_passe,
	Region.id_region,
	Region.nom_region
from chefDeRegion join Region on chefDeRegion.id_chef_de_region = Region.id_chef_de_region;


create view v_signalementEffectue as select
	v_region.username,
	v_region.mot_de_passe,
	v_region.nom_region,
	v_signalement.id_signalement,
	v_signalement.id_type_signalement,
	v_signalement.id_region,
	v_signalement.id_utilisateur,
	v_signalement.longitude,
	v_signalement.latitude,
	v_signalement.description_signal,
	v_signalement.date_signal,
	v_signalement.heure_signal,
	v_signalement.nom_photo,
	v_affectation.status_signalement,
	v_affectation.date_affectation,
	v_affectation.heure_affectation
from v_region join v_signalement on v_region.id_region = v_signalement.id_region
join v_affectation on v_signalement.id_signalement = v_affectation.id_signalement;



-- create view v_detailSignalement as select id_signalement,type_signalement,nom_region,nom,prenom,nom_photo,longitude,latitude 
-- from signalement s join typeSignalement ts on s.id_type_signalement=ts.id_type_signalement 
-- join Region r on s.id_region=r.id_region join utilisateur u on s.id_utilisateur=u.id_utilisateur
-- join photoSignalement ps on s.id_signalement=ps.id_signalement;
