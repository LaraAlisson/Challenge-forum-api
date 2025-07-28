package Challenge.forum.api.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoTopico(
        @NotBlank
        String mensagem,

        @NotBlank
        String titulo
) {}
