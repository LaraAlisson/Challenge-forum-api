package Challenge.forum.api.domain.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        String nomeCurso,
        LocalDateTime dataCriacao,
        Boolean Status,
        String usuarioLogin
) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getNomecurso(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getUsuario().getLogin()
        );
    }
}
