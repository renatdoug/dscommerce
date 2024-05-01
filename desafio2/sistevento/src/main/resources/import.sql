--Inserridos dados na tabela participante --
INSERT INTO tb_participante(nome, email) VALUES ('Jose Silva', 'jose@gmail.com');
INSERT INTO tb_participante(nome, email) VALUES ('Tiago Faria', 'tiago@gmail.com');
INSERT INTO tb_participante(nome, email) VALUES ('JMaria do Rosario', 'maria@gmail.com');
INSERT INTO tb_participante(nome, email) VALUES ('Teresa Silva', 'teresa@gmail.com');

--Inserridos dados na tabela Categoria --
INSERT INTO tb_categoria(descricao) VALUES ('Curso');
INSERT INTO tb_categoria(descricao) VALUES ('Oficina');

--Inserridos dados na tabela Atividade --
INSERT INTO tb_atividade(categoria_id, nome, descricao, preco) VALUES (1, 'Curso de HTML', 'Aprenda HTML de forma pratica', 80.00);
INSERT INTO tb_atividade(categoria_id, nome, descricao, preco) VALUES (2, 'Oficina de Github', 'Controle versoes de seus projetos', 50.00);

--Inserridos dados na tabela Bloco --
INSERT INTO tb_bloco(inicio, fim) VALUES (TIMESTAMP WITH TIME ZONE '2017-09-25T08:00Z', TIMESTAMP WITH TIME ZONE '2017-09-25T11:00Z');
INSERT INTO tb_bloco(inicio, fim) VALUES (TIMESTAMP WITH TIME ZONE '2017-09-25T14:00Z', TIMESTAMP WITH TIME ZONE '2017-09-25T18:00Z');
INSERT INTO tb_bloco(inicio, fim) VALUES (TIMESTAMP WITH TIME ZONE '2017-09-26T08:00Z', TIMESTAMP WITH TIME ZONE '2017-09-26T11:00Z');

--Inserridos dados na tabela atividade_participante --
INSERT INTO tb_atividade_participante (atividade_id, participante_id) VALUES (1,1);
INSERT INTO tb_atividade_participante (atividade_id, participante_id) VALUES (1,2);
INSERT INTO tb_atividade_participante (atividade_id, participante_id) VALUES (1,3);

INSERT INTO tb_atividade_participante (atividade_id, participante_id) VALUES (2,3);
INSERT INTO tb_atividade_participante (atividade_id, participante_id) VALUES (2,4);

--Inserridos dados na tabela atividade_bloco --
INSERT INTO tb_atividade_bloco (atividade_id, bloco_id) VALUES (1,1);
INSERT INTO tb_atividade_bloco (atividade_id, bloco_id) VALUES (2,2);
INSERT INTO tb_atividade_bloco (atividade_id, bloco_id) VALUES (2,3);






