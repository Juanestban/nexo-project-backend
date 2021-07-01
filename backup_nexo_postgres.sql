--
-- PostgreSQL database cluster dump
--

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Drop databases
--

DROP DATABASE nexo_postgres;




--
-- Drop roles
--

DROP ROLE postgres;


--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'md53175bce1d3201d16594cebf9d7eb3f9d';






--
-- Database creation
--

CREATE DATABASE nexo_postgres WITH TEMPLATE = template0 OWNER = postgres;
REVOKE CONNECT,TEMPORARY ON DATABASE template1 FROM PUBLIC;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;


\connect nexo_postgres

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.22
-- Dumped by pg_dump version 9.6.22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: charges; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.charges (
    id integer NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.charges OWNER TO postgres;

--
-- Name: charges_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.charges_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.charges_id_seq OWNER TO postgres;

--
-- Name: charges_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.charges_id_seq OWNED BY public.charges.id;


--
-- Name: control_merchandise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.control_merchandise (
    id integer NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.control_merchandise OWNER TO postgres;

--
-- Name: control_merchandise_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.control_merchandise_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.control_merchandise_id_seq OWNER TO postgres;

--
-- Name: control_merchandise_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.control_merchandise_id_seq OWNED BY public.control_merchandise.id;


--
-- Name: merchandise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.merchandise (
    id integer NOT NULL,
    name_product character varying(50) NOT NULL,
    quantity integer NOT NULL,
    admission_date character varying NOT NULL,
    user_register integer NOT NULL,
    id_control_merchandise integer NOT NULL
);


ALTER TABLE public.merchandise OWNER TO postgres;

--
-- Name: merchandise_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.merchandise_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.merchandise_id_seq OWNER TO postgres;

--
-- Name: merchandise_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.merchandise_id_seq OWNED BY public.merchandise.id;


--
-- Name: merchandise_users_edit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.merchandise_users_edit (
    id integer NOT NULL,
    id_merchandise integer NOT NULL,
    id_user_edited integer NOT NULL
);


ALTER TABLE public.merchandise_users_edit OWNER TO postgres;

--
-- Name: merchandise_users_edit_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.merchandise_users_edit_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.merchandise_users_edit_id_seq OWNER TO postgres;

--
-- Name: merchandise_users_edit_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.merchandise_users_edit_id_seq OWNED BY public.merchandise_users_edit.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    age integer NOT NULL,
    id_charge integer NOT NULL,
    date_entry_company character varying NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: charges id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.charges ALTER COLUMN id SET DEFAULT nextval('public.charges_id_seq'::regclass);


--
-- Name: control_merchandise id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.control_merchandise ALTER COLUMN id SET DEFAULT nextval('public.control_merchandise_id_seq'::regclass);


--
-- Name: merchandise id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.merchandise ALTER COLUMN id SET DEFAULT nextval('public.merchandise_id_seq'::regclass);


--
-- Name: merchandise_users_edit id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.merchandise_users_edit ALTER COLUMN id SET DEFAULT nextval('public.merchandise_users_edit_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: charges; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.charges (id, name) FROM stdin;
1	Administrador
2	Asesor de ventas
3	Soporte
4	another charge
5	another charge
\.


--
-- Name: charges_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.charges_id_seq', 5, true);


--
-- Data for Name: control_merchandise; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.control_merchandise (id, name) FROM stdin;
1	Entrada
2	Salida
\.


--
-- Name: control_merchandise_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.control_merchandise_id_seq', 2, true);


--
-- Data for Name: merchandise; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.merchandise (id, name_product, quantity, admission_date, user_register, id_control_merchandise) FROM stdin;
7	Lacteos	200	2000/12/04	1	1
\.


--
-- Name: merchandise_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.merchandise_id_seq', 8, true);


--
-- Data for Name: merchandise_users_edit; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.merchandise_users_edit (id, id_merchandise, id_user_edited) FROM stdin;
3	7	1
\.


--
-- Name: merchandise_users_edit_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.merchandise_users_edit_id_seq', 3, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, name, age, id_charge, date_entry_company) FROM stdin;
1	test user-1	20	1	2020-12-20 00:00:00
2	Juan	21	2	2021/10/12 00:00
3	Juan	21	2	2021/10/12 00:00
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 3, true);


--
-- Name: charges charges_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.charges
    ADD CONSTRAINT charges_pkey PRIMARY KEY (id);


--
-- Name: control_merchandise control_merchandise_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.control_merchandise
    ADD CONSTRAINT control_merchandise_pkey PRIMARY KEY (id);


--
-- Name: merchandise merchandise_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.merchandise
    ADD CONSTRAINT merchandise_pkey PRIMARY KEY (id);


--
-- Name: merchandise_users_edit merchandise_users_edit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.merchandise_users_edit
    ADD CONSTRAINT merchandise_users_edit_pkey PRIMARY KEY (id);


--
-- Name: merchandise name_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.merchandise
    ADD CONSTRAINT name_unique UNIQUE (name_product);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: users fk_id_charge; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk_id_charge FOREIGN KEY (id_charge) REFERENCES public.charges(id) ON DELETE CASCADE;


--
-- Name: merchandise fk_id_control_merchandise; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.merchandise
    ADD CONSTRAINT fk_id_control_merchandise FOREIGN KEY (id_control_merchandise) REFERENCES public.control_merchandise(id) ON DELETE CASCADE;


--
-- Name: merchandise_users_edit fk_id_merchandise; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.merchandise_users_edit
    ADD CONSTRAINT fk_id_merchandise FOREIGN KEY (id_merchandise) REFERENCES public.merchandise(id) ON DELETE CASCADE;


--
-- Name: merchandise_users_edit fk_id_user_edited; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.merchandise_users_edit
    ADD CONSTRAINT fk_id_user_edited FOREIGN KEY (id_user_edited) REFERENCES public.users(id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

\connect postgres

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.22
-- Dumped by pg_dump version 9.6.22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- PostgreSQL database dump complete
--

\connect template1

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.22
-- Dumped by pg_dump version 9.6.22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE template1; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE template1 IS 'default template for new databases';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- PostgreSQL database dump complete
--

--
-- PostgreSQL database cluster dump complete
--

