
package com.amigo_oculto.api.Aplicattion.use_cases.abstration;

import java.util.List;
import java.util.Optional;

import com.amigo_oculto.api.entities.Sorteio;

public interface InterfaceGerenciarSorteio {


    public Sorteio criar(Sorteio Sorteio);

    public List<Sorteio> listar();

    public Optional<Sorteio> buscarPorId(Long id);

    public Sorteio atualizar(Long id, Sorteio SorteioAtualizado);

    public void deletar(Long id);
}
