package Challenge.forum.api.controller;

import jakarta.validation.Valid;
import Challenge.forum.api.domain.usuario.DadosAutentificacao;
import Challenge.forum.api.domain.usuario.Usuario;
import Challenge.forum.api.infra.security.DadosTokenJWT;
import Challenge.forum.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutetificacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutentificacao dados){
        var authenticaontiontoken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
       var authenticaontion = manager.authenticate(authenticaontiontoken);

       var tokenJWT = tokenService.gerarToken((Usuario) authenticaontion.getPrincipal());
       return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
