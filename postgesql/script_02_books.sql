-- Table: public.books

-- DROP TABLE public.books;

CREATE TABLE IF NOT EXISTS public.books
(
    book_id integer NOT NULL DEFAULT nextval('books_book_id_seq'::regclass),
    book_title character varying COLLATE pg_catalog."default" NOT NULL,
    book_author character varying COLLATE pg_catalog."default" NOT NULL,
    book_price integer NOT NULL,
    CONSTRAINT books_pkey PRIMARY KEY (book_id)
)

TABLESPACE pg_default;

ALTER TABLE public.books
    OWNER to postgres;

COMMENT ON TABLE public.books
    IS 'Книги';

COMMENT ON COLUMN public.books.book_id
    IS 'ПК';

COMMENT ON COLUMN public.books.book_title
    IS 'Название';

COMMENT ON COLUMN public.books.book_author
    IS 'Автор';

COMMENT ON COLUMN public.books.book_price
    IS 'Стоимость';
	
insert into books (book_title, book_author, book_price) values ('Преступление и наказание', 'Достоевский', 100)	