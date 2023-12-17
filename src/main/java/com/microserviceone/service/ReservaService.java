package com.microserviceone.service;

import com.microserviceone.model.Reserva;
import com.microserviceone.model.ReservaRequest;
import com.microserviceone.model.RestauranteRequest;
import com.microserviceone.model.RestauranteResponse;
import com.microserviceone.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;
    RestTemplate restTemplate;

    public List<Reserva> findReservas() {
        return reservaRepository.findAll();
    }

    public ResponseEntity<Object> createReserva(ReservaRequest reserva) {
        if( reserva.getNomeRestaurante() != null ) {
            RestauranteRequest restauranteRequest = new RestauranteRequest();

            restauranteRequest.setNomeRestaurante(reserva.getNomeRestaurante());

            String url = "localhost:8081/restaurante/checkar-reserva";
            ResponseEntity<RestauranteResponse> forEntity = restTemplate.postForEntity(url, restauranteRequest, RestauranteResponse.class);

            if (forEntity.getStatusCode().value() == 200) {
                Reserva reserva1 = new Reserva();
                reserva1.setRestauranteId(forEntity.getBody().getRestauranteId());
                reservaRepository.save(reserva);
                return ResponseEntity.ok(reserva);

            } else {
                ResponseEntity.badRequest();
            }

        } else {
            return ResponseEntity.badRequest().body("Faltou o nome do Restaurante");
        }
    }
}
