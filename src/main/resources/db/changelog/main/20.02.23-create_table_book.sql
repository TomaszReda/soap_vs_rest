CREATE TABLE public.book
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    author character varying(255) COLLATE pg_catalog."default",
    book_search character varying(255) COLLATE pg_catalog."default",
    book_state character varying(255) COLLATE pg_catalog."default",
    date date,
    description character varying(4096) COLLATE pg_catalog."default",
    isbn character varying(255) COLLATE pg_catalog."default",
    publisher character varying(255) COLLATE pg_catalog."default",
    quant integer NOT NULL,
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT book_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.book
    OWNER to admin;