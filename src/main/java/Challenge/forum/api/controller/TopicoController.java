package Challenge.forum.api.controller;

import Challenge.forum.api.domain.topico.*;
import Challenge.forum.api.domain.usuario.Usuario;
import Challenge.forum.api.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> criarTopico(@RequestBody @Valid DadosCadastroTopico dados) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (!(principal instanceof Usuario usuarioLogado)) {
            return ResponseEntity.status(401).build();
        }

        Topico topico = new Topico(
                dados.mensagem(),
                dados.nomeCurso(),
                dados.titulo(),
                usuarioLogado
        );

        topicoRepository.save(topico);
        return ResponseEntity
                .created(null)  // você pode adicionar a URI do recurso criado
                .body(new DadosDetalhamentoTopico(topico));
    }



    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(
            @PageableDefault(size = 20, sort = {"dataCriacao"}) Pageable pageable) {

        Page<DadosListagemTopico> pagina = topicoRepository.findAll(pageable)
                .map(DadosListagemTopico::new);

        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> buscarPorId(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .map(DadosDetalhamentoTopico::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizarTopico(
            @PathVariable Long id,
            @RequestBody @Valid DadosAtualizacaoTopico dados) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity
                    .status(401)
                    .body("Usuário não logado");
        }

        String loginUsuario = authentication.getName();
        Usuario usuarioLogado = (Usuario) usuarioRepository.findByLogin(loginUsuario);

        if (usuarioLogado == null) {
            return ResponseEntity
                    .status(401)
                    .body("Usuário não logado");
        }

        var topicoOpt = topicoRepository.findById(id);
        if (topicoOpt.isEmpty()) {
            return ResponseEntity
                    .status(404)
                    .body("Tópico não encontrado na base de dados deste Forúm");
        }

        var topico = topicoOpt.get();
        if (!Objects.equals(topico.getUsuario().getId(), usuarioLogado.getId())) {
            return ResponseEntity
                    .status(403)
                    .body("Usuário sem permissão para alterar este tópico");
        }

        topico.setMensagem(dados.mensagem());
        topico.setTitulo(dados.titulo());

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarTopico(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(401).body("Usuário não logado");
        }

        String loginUsuario = authentication.getName();
        Usuario usuarioLogado = (Usuario) usuarioRepository.findByLogin(loginUsuario);

        var topicoOpt = topicoRepository.findById(id);
        if (topicoOpt.isEmpty()) {
            return ResponseEntity.status(404).body("Tópico não encontrado");
        }

        var topico = topicoOpt.get();
        if (!Objects.equals(topico.getUsuario().getId(), usuarioLogado.getId())) {
            return ResponseEntity.status(403).body("Usuário sem permissão para deletar este tópico");
        }

        topicoRepository.delete(topico);
        return ResponseEntity.ok("Tópico deletado com sucesso");
    }

    @PutMapping("/status/{id}")
    @Transactional
    public ResponseEntity<?> desativaTopico(@PathVariable Long id ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(401).body("Usuário não logado");
        }

        String loginUsuario = authentication.getName();
        Usuario usuarioLogado = (Usuario) usuarioRepository.findByLogin(loginUsuario);

        var topicoOpt = topicoRepository.findById(id);
        if (topicoOpt.isEmpty()) {
            return ResponseEntity.status(404).body("Tópico não encontrado");
        }

        var topico = topicoOpt.get();
        if (!Objects.equals(topico.getUsuario().getId(), usuarioLogado.getId())) {
            return ResponseEntity.status(403).body("Usuário sem permissão para deletar este tópico");
        }

        topico.setStatus(false);
        return ResponseEntity.ok("Tópico desativado com sucesso");
    }




}
