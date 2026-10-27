package br.com.cloudtech.monitoramento_maquinas.service;

import br.com.cloudtech.monitoramento_maquinas.model.Maquina;
import br.com.cloudtech.monitoramento_maquinas.repository.MaquinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class MaquinaService {

    private final MaquinaRepository repository;

    public MaquinaService(MaquinaRepository repository) {
        this.repository = repository;
    }


    public Maquina cadastrar(Maquina maquina) {
        if (maquina.getNome() == null || maquina.getNome().isBlank()) {
            throw new IllegalArgumentException("O campo 'nome' é obrigatório");
        }
        return repository.salvar(maquina);
    }

    public List<Maquina> listar() {
        return repository.listarTodas();
    }
}