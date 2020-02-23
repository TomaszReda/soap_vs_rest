CREATE TABLE public.book_book_category
(
    book_id bigint NOT NULL,
    category_id bigint NOT NULL,
    CONSTRAINT fkfgi5two0scucj4g4rjmmjpq1r FOREIGN KEY (category_id)
        REFERENCES public.book_category (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkh2xpw04b65kkyt90rafbia7jx FOREIGN KEY (book_id)
        REFERENCES public.book (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.book_book_category
    OWNER to admin;