package br.com.cloudtech.monitoramento_maquinas.controller;

import br.com.cloudtech.monitoramento_maquinas.model.Maquina;
import br.com.cloudtech.monitoramento_maquinas.service.MaquinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/maquinas")
public class MaquinaController {

    private final MaquinaService service;

    public MaquinaController(MaquinaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Maquina>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody Maquina maquina) {
        try {
            Maquina salva = service.cadastrar(maquina);
            return ResponseEntity.status(HttpStatus.CREATED).body(salva);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("erro", e.getMessage()));
        }
    }
}
