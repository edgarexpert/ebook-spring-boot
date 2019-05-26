package com.algaworks.festa.services;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.Convidados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvidadoServiceImpl implements ConvidadoService {

    @Autowired
    private Convidados convidadoRepository;

    @Override
    public Convidado getConvidadoByNome(String nome) {
        return convidadoRepository.findByNome(nome);
    }
}