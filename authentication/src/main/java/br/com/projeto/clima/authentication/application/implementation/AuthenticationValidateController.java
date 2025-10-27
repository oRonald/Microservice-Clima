package br.com.projeto.clima.authentication.application.implementation;

import br.com.projeto.clima.authentication.application.IAuthenticationValidateController;
import br.com.projeto.clima.authentication.config.security.jwt.JwtGeneration;
import br.com.projeto.clima.authentication.dto.ValidationResponse;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationValidateController implements IAuthenticationValidateController {

    private final JwtGeneration jwtGeneration;


    @PostMapping("/validate")
    public ResponseEntity<ValidationResponse> validate(String header) {
        try{
            String token = header.replace("Bearer ", "");
            Algorithm algorithm = Algorithm.HMAC256(jwtGeneration.getJWT_SECRET());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);

            String email = decodedJWT.getSubject();

            return ResponseEntity.ok(ValidationResponse.builder().valid(true).email(email).build());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(ValidationResponse.builder().valid(false).email(null).build());
        }
    }
}
