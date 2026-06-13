package com.jedi.jedis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;

import com.jedi.jedis.DTO.SableExternoDTO;
import com.jedi.jedis.model.Jedi;

import reactor.core.publisher.Mono;

public class JediValidaciones {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Boolean validarNullVacio(Jedi jedi){
        if(jedi.getNombre() == null || jedi.getNombre().trim().length() == 0){
            return false;
        }
        if(jedi.getMidiclorianos() == null || jedi.getMidiclorianos() < 100){
            return false;
        }
        return true;
    }

    public SableExternoDTO obtenerSable(Integer id){
        SableExternoDTO sableRecuperado = new SableExternoDTO();
        try {
            sableRecuperado = webClientBuilder.build()
                .get()
                .uri("http://sables/api/v1/sables/buscar-por-jedi/" + id)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.empty()) // importante
                .bodyToMono(SableExternoDTO.class)
                .block();

            return sableRecuperado;
            
        } catch (Exception e) {
            sableRecuperado.setId(0);
            sableRecuperado.setJediId(id);
            sableRecuperado.setColor("no se pudo conectar con el sable del jedi");
            return sableRecuperado;
        }
    }
}
