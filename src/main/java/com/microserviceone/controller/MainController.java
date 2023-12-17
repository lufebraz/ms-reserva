package com.microserviceone.controller;

import com.microserviceone.model.Reserva;
import com.microserviceone.model.ReservaRequest;
import com.microserviceone.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/microservice-one")
public class MainController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> findReservas() {
        return ResponseEntity.ok(reservaService.findReservas());
    }

    @PostMapping("/create")
    public ResponseEntity<Reserva> createReserva(@RequestBody ReservaRequest reserva) {
        return reservaService.createReserva(reserva);
    }

}
