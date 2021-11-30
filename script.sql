CREATE TABLE public.customer (
                id SERIAL NOT NULL,
                name VARCHAR NOT NULL,
                address VARCHAR NOT NULL,
                CONSTRAINT customer_id PRIMARY KEY (id)
);


CREATE TABLE public.professor (
                id SERIAL NOT NULL,
                office_number VARCHAR NOT NULL,
                research_area VARCHAR NOT NULL,
                customer_id INTEGER NOT NULL,
                CONSTRAINT professor_id PRIMARY KEY (id)
);


ALTER TABLE public.professor ADD CONSTRAINT customer_professor_fk
FOREIGN KEY (customer_id)
REFERENCES public.customer (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
