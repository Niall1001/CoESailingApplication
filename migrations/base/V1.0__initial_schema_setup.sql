CREATE TABLE IF NOT EXISTS public.user ( 
id serial primary key, 
name VARCHAR(255) NOT NULL, 
email_address VARCHAR(255) NOT NULL, 
dob DATE NOT NULL, 
password VARCHAR(255) NOT NULL 
); 

 

CREATE TABLE IF NOT EXISTS public.boat( 
id serial primary key, 
name VARCHAR(255) NOT NULL, 
sailno VARCHAR(100) NOT NULL,  
class VARCHAR(255) NOT NULL,  
age integer NOT NULL, 
description VARCHAR(255) NOT NULL 
); 

 

CREATE TABLE IF NOT EXISTS public.event( 
id serial primary key, 
name VARCHAR(255) NOT NULL, 
type VARCHAR(100) NOT NULL, 
date DATE NOT NULL, 
description VARCHAR(255) NOT NULL 
); 

 

CREATE TABLE IF NOT EXISTS public.boat_owner ( 
id serial primary key, 
boat_id integer REFERENCES public.boat(id), 
user_id integer REFERENCES public.user(id) 
); 

 

CREATE TABLE IF NOT EXISTS public.crewmate( 
id serial primary key, 
user_id integer REFERENCES public.user(id) 
); 

 

CREATE TABLE IF NOT EXISTS public.admin( 
id serial primary key, 
user_id integer REFERENCES public.user(id) 
); 

 

CREATE TABLE IF NOT EXISTS public.boat_crewmate( 
id serial primary key, 
boat_id integer REFERENCES public.boat(id), 
crewmate_id integer REFERENCES public.crewmate(id) 
); 

 

CREATE TABLE IF NOT EXISTS public.event_admin( 
id serial primary key, 
event_id integer REFERENCES public.event(id), 
admin_id integer REFERENCES public.admin(id) 
); 

 

CREATE TABLE IF NOT EXISTS public.event_boat( 
id serial primary key, 
boat_id integer REFERENCES public.boat (id), 
event_id integer REFERENCES public.event (id), 
position integer NULL, 
time time NULL 
); 