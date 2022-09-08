INSERT INTO public.user (name, email_address, dob, password) 
VALUES (‘Niall Walters’, ‘niallwalters135@gmail.com’, ‘25/10/1998’, ‘Password135’); 
INSERT INTO public.user (name, email_address, dob, password) 
VALUES (‘Sarah Jennings’, ‘sarahjennings1@gmail.com’, ‘13/04/2001’, ‘Password15’); 
INSERT INTO public.user (name, email_address, dob, password) 
VALUES (‘Aoibhin Wood’, ‘awood3@gmail.com’, ‘21/07/1999’, ‘Password10’); 
INSERT INTO public.user (name, email_address, dob, password) 
VALUES (‘James Regan’, ‘jregan10@gmail.com’, ‘03/07/1968’, ‘JamesPassword13’); 
INSERT INTO public.user (name, email_address, dob, password)
VALUES (‘James Curran’, ‘jjcurran01@gmail.com’, ‘03/07/1976’, ‘JamesPassword13’);
INSERT INTO public.user (name, email_address, dob, password) 
VALUES (‘David Maxwell’, ‘dmaxwell4@gmail.com’, ‘01/02/1965’, ‘Admin101’); 
INSERT INTO public.user (name, email_address, dob, password) 
VALUES (‘Stephen Walters’, ‘walters3147@gmail.com’, ‘24/03/1967’, ‘Password14’); 

INSERT INTO public.boat(name, sailno, class, age, description) 
VALUES (‘Lizante’, ‘1967’, ‘NHC 1’, ‘2007’, ‘Jeanneau Sun Oddessey’); 
INSERT INTO public.boat(name, sailno, class, age, description) 
VALUES (‘Beeste’, ‘13842’, ‘IRC 2’, ‘2005’, ‘Hunter Impala’); 

INSERT INTO public.event(name, type, date, description)
VALUES (‘EDYC Club Race 3’, ‘Club Race’, ‘24/06/2022’, ‘Third Event of club racing’); 
INSERT INTO public.event(name, type, date, description) 
VALUES (‘SLYC Regatta’, ‘Regatta’, ‘13/05/2022’, ‘SLYC Regatta Event’); 

INSERT INTO public.boat_owner(boat_id, user_id) 
VALUES (‘1’, ‘4’); 
INSERT INTO public.boat_owner(boat_id, user_id) 
VALUES (‘2’, ‘5’); 

INSERT INTO public.crewmate(user_id) 
VALUES (‘1’); 
INSERT INTO public.crewmate(user_id) 
VALUES (‘2’); 
INSERT INTO public.crewmate(user_id) 
VALUES (‘3’); 
INSERT INTO public.crewmate(user_id) 
VALUES (‘7’); 

INSERT INTO public.admin(user_id) 
VALUES (‘6’); 

INSERT INTO public.boat_crewmate(boat_id, crewmate_id) 
VALUES (‘1’, ‘1’); 
INSERT INTO public.boat_crewmate(boat_id, crewmate_id) 
VALUES (‘1’, ‘2’); 
INSERT INTO public.boat_crewmate(boat_id, crewmate_id) 
VALUES (‘1’, ‘3’); 
INSERT INTO public.boat_crewmate(boat_id, crewmate_id) 
VALUES (‘2’, ‘7’); 

INSERT INTO public.event_boat(event_id, boat_id, position, time) 
VALUES (‘1’, ‘1’, ‘1’, ‘01:17:13’); 
INSERT INTO public.event_boat(event_id, boat_id, position, time) 
VALUES (‘1’, ‘2’, ‘2’, ‘01:21:12’); 
INSERT INTO public.event_boat(event_id, boat_id, position, time) 
VALUES (‘2’, ‘1’, ‘3’, ‘01:54:10’); 
INSERT INTO public.event_boat(event_id, boat_id, position, time) 
VALUES (‘2’, ‘2’, ’6’, ‘02:24:03’); 

INSERT INTO public.event_admin(event_id, admin_id) 
VALUES (‘1’, ‘1’); 
INSERT INTO public.event_admin(event_id, admin_id) 
VALUES (‘2’, ‘1’);