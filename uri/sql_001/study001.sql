CREATE TABLE livros (
id NUMERIC PRIMARY KEY,
livro VARCHAR(255) NOT NULL,
autor VARCHAR(255) NOT NULL,
sexo CHAR(1),
paginas INTEGER,
editora VARCHAR(255),
preco NUMERIC(10,2),
estado CHAR(2),
ano_publicacao INTEGER
);

INSERT INTO livros(id, livro, autor, sexo, paginas, editora, preco, estado, ano_publicacao)
VALUES (1, 'Cavaleiro Real', 'Ana Claudia', 'F', 465, 'Atlas', 49.90, 'RJ', 2009);

INSERT INTO livros(id, livro, autor, sexo, paginas, editora, preco, estado, ano_publicacao)
VALUES (2, 'SQL para leigos', 'João Nunes', 'M', 450, 'Addison', 98.00, 'SP', 2018);

INSERT INTO livros(id, livro, autor, sexo, paginas, editora, preco, estado, ano_publicacao)
VALUES (3, 'Receitas Caseiras', 'Celia Tavares', 'F', 210, 'Atlas', 45.00, 'RJ', 2008);

INSERT INTO livros(id, livro, autor, sexo, paginas, editora, preco, estado, ano_publicacao)
VALUES (4, 'Pessoas Efetivas', 'Eduardo Santos', 'M', 390, 'Beta', 78.99, 'RJ', 2018);

INSERT INTO livros(id, livro, autor, sexo, paginas, editora, preco, estado, ano_publicacao)
VALUES (5, 'Habitos Saudáveis', 'Eduardo Santos', 'M', 630, 'Beta', 150.98, 'RJ', 2019);

INSERT INTO livros(id, livro, autor, sexo, paginas, editora, preco, estado, ano_publicacao)
VALUES (6, 'A casa Marrom', 'Herms Macedo', 'M', 250, 'Bubba', 60.00, 'MG', 2016);

INSERT INTO livros(id, livro, autor, sexo, paginas, editora, preco, estado, ano_publicacao)
VALUES (7, 'Estacio Querido', 'Geraldo Francisco', 'M', 310, 'Insignia', 100.00, 'ES', 2015);

INSERT INTO livros(id, livro, autor, sexo, paginas, editora, preco, estado, ano_publicacao)
VALUES (8, 'Pra sempre amigas', 'Leda Silva', 'F', 510, 'Insignia', 78.98, 'ES', 2011);

INSERT INTO livros(id, livro, autor, sexo, paginas, editora, preco, estado, ano_publicacao)
VALUES (9, 'Copas inesqueciveis', 'Marcos Alcantara', 'M', 200, 'Larson', 130.98, 'RS', 2018);

INSERT INTO livros(id, livro, autor, sexo, paginas, editora, preco, estado, ano_publicacao)
VALUES (10, 'O poder da mente', 'Clara Mafra', 'F', 120, 'Continental', 56.58, 'SP', 2017);

-- Desafio
-- Trazer dados dos autores do sexo masculino que tiveram livros publicados por SP ou RJ.

-- RESPOSTA
SELECT autor, livro
FROM livros
WHERE sexo = 'M'
AND estado IN ('SP', 'RJ');