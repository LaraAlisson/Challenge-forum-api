package Challenge.forum.api.domain.topico;

import Challenge.forum.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Setter
        private String mensagem;

        private String nomecurso;

        @Setter
        private String titulo;

        private LocalDateTime dataCriacao;

        @Setter
        private Boolean status;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "usuario_id")
        private Usuario usuario;

        public Topico(String mensagem, String nomecurso, String titulo, Usuario usuario) {
                this.mensagem = mensagem;
                this.nomecurso = nomecurso;
                this.titulo = titulo;
                this.usuario = usuario;
                this.dataCriacao = LocalDateTime.now();
                this.status = true;
        }
}
