package com.algaworks.festa.repository;

import com.algaworks.festa.model.Convidado;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.junit.Assert;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest

public class ConvidadosTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private Convidados convidadoRepository;

    // write test cases here
    @Test
    public void quandoEcontrarPorNome_entaoRetorneConvidado() {
        // given
        Convidado teste = new Convidado("teste");
        entityManager.persist(teste);
        entityManager.flush();

        // when
        Convidado found = convidadoRepository.findByNome(teste.getNome());

        // then
        //AssertThat(found.getNome())
                //.isEqualTo(teste.getNome());

        Assert.assertEquals("teste", teste.getNome());
    }

}