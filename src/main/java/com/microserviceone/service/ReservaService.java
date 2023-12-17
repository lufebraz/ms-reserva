package com.microserviceone.service;

import com.microserviceone.model.*;
import com.microserviceone.repository.ReservaRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    private RestTemplate restTemplate;
    private void init() {
        if (restTemplate == null) {
            this.restTemplate = new RestTemplate();
        }
    }
    private String BASE_URL = "http://localhost:8081/ms-restaurante";


    public List<Reserva> findReservas() {
        return reservaRepository.findAll();
    }

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackMethod")
    public ResponseEntity<Object> createReserva(ReservaRequest request) {

        RestauranteRequest restauranteRequest = new RestauranteRequest();
        restauranteRequest.setNomeRestaurante(request.getNomeRestaurante());
        init();
        ResponseEntity<Restaurante> forEntity = restTemplate.postForEntity(BASE_URL + "/find-by-name", restauranteRequest, Restaurante.class);

        if (forEntity.getStatusCode().value() == 200) {
            Reserva reserva = new Reserva();

            reserva.setNomeCliente(request.getNomeCliente());
            reserva.setContatoCliente(request.getContatoCliente());
            reserva.setDataHora(request.getDataHora());
            reserva.setNumeroDePessoas(request.getNumeroPessoas());
            reserva.setRestauranteId(forEntity.getBody().getId());

            Reserva savedReserva = reservaRepository.save(reserva);

            ReservaResponse reservaResponse = new ReservaResponse();
            BeanUtils.copyProperties(savedReserva, reservaResponse);
            reservaResponse.setNomeRestaurante(forEntity.getBody().getNomeRestaurante());
            reservaResponse.setDataHora(reserva.getDataHora().toString());

            return ResponseEntity.ok(reservaResponse);

        } else {
           return ResponseEntity.badRequest().body("Restaurante não localizado.");
        }
    }


    public ResponseEntity<Object> deletarReserva(Long id) {
        Optional<Reserva> reservaOpt = reservaRepository.findById(id);
        if (reservaOpt.isPresent()) {
            reservaRepository.deleteById(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<String> fallbackMethod() {
        return ResponseEntity.internalServerError().body("Servico fora do ar");
    }
}
