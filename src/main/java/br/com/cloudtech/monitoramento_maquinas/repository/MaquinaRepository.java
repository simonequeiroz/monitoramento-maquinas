package br.com.cloudtech.monitoramento_maquinas.repository;

import br.com.cloudtech.monitoramento_maquinas.model.Maquina;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;  

@Repository 
public class MaquinaRepository {

    private final List<Maquina> maquinas = new ArrayList<>();
    private long proximoId = 1;

    public Maquina salvar(Maquina maquina) {
        if (maquina.getId() == null) {
            maquina.setId(proximoId);
        }
        proximoId = maquina.getId() + 1;
        maquinas.add(maquina);
        return maquina;
    }   

    public List<Maquina> listarTodas() {
        return maquinas;
    }
}