package com.amigo_oculto.api.interface_adapters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigo_oculto.api.Aplicattion.use_cases.implementation.GerenciarSorteios;
import com.amigo_oculto.api.entities.Sorteio;


@RestController
@RequestMapping("/api/sorteios")
public class SorteioController {

    @Autowired
    private SorteioRepositoryJPA sorteioRepository;

    @Autowired
    private GerenciarSorteios gerenciarSorteios;

    @PostMapping("/realizar")
    public ResponseEntity<String> realizarSorteio(@RequestBody List<String> participantes) {
        // Verifica se existem participantes suficientes
        if (participantes == null || participantes.size() < 2) {
            return ResponseEntity.badRequest().body("O número de participantes deve ser pelo menos 2.");
        }

        // Embaralha os participantes
        Collections.shuffle(participantes);

        // Realiza o sorteio
        for (int i = 0; i < participantes.size(); i++) {
            String amigoSecreto = participantes.get((i + 1) % participantes.size());
            SorteioEntity sorteio = new SorteioEntity();
            sorteio.setParticipante(participantes.get(i));
            sorteio.setAmigoSecreto(amigoSecreto);

            // Salva no banco de dados
            sorteioRepository.save(sorteio);
        }

        return ResponseEntity.ok("Sorteio realizado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<SorteioEntity>> listarSorteios() {
        // Retorna todos os sorteios registrados no banco
        List<SorteioEntity> sorteios = sorteioRepository.findAll();
        return ResponseEntity.ok(sorteios);
    }
}
