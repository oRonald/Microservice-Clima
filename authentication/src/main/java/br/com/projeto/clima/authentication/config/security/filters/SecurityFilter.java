package br.com.projeto.clima.authentication.config.security.filters;

import br.com.projeto.clima.authentication.config.security.jwt.JwtGeneration;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final JwtGeneration jwtGeneration;

    public SecurityFilter(JwtGeneration jwtGeneration) {
        this.jwtGeneration = jwtGeneration;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(request);
        if(token != null){
            Algorithm algorithm = Algorithm.HMAC256(jwtGeneration.getJWT_SECRET());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);

            String email = decodedJWT.getSubject();
            logger.info(email);

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    email,
                    null,
                    List.of()
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest servletRequest){
        String header = servletRequest.getHeader("Authorization");
        if(header == null || header.isBlank()){
            return null;
        }
        final String prefix = "Bearer ";
        if(header.startsWith(prefix)){
            return header.substring(prefix.length());
        }
        return null;
    }
}
