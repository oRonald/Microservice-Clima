package br.com.projeto.clima.authentication.service;

import br.com.projeto.clima.authentication.config.security.jwt.JwtGeneration;
import br.com.projeto.clima.authentication.dto.TokenResponse;
import br.com.projeto.clima.authentication.dto.UsersLoginRequest;
import br.com.projeto.clima.authentication.handler.exceptions.ClientDataNotFoundException;
import br.com.projeto.clima.authentication.handler.exceptions.CommunicationErrorException;
import br.com.projeto.clima.authentication.integration.UsuarioResourceClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioResourceService {

    private final UsuarioResourceClient resourceClient;
    private final JwtGeneration jwtGeneration;

    public TokenResponse authenticateUser(UsersLoginRequest request)  {
        UsersLoginRequest loginRequest = fetchUserFromResource(request);

        String token = generateToken(loginRequest);

        return TokenResponse.builder().token(token).build();
    }

    private UsersLoginRequest fetchUserFromResource(UsersLoginRequest request){
        try{
            return resourceClient.userLoginRequest(request);
        } catch (FeignException.FeignClientException e){
            if(e.status() == HttpStatus.NO_CONTENT.value()){
                throw new ClientDataNotFoundException("User not found");
            }
            throw new CommunicationErrorException("Error in communication between services", e.status());
        }
    }

    private String generateToken(UsersLoginRequest request){
        return jwtGeneration.generateToken(request);
    }


}
