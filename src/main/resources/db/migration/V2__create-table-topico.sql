CREATE TABLE topico (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensagem VARCHAR(255) NOT NULL,
    nomecurso VARCHAR(255) NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    usuario_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_topico_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);
