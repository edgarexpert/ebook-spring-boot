package com.algaworks.festa.repository;

import com.algaworks.festa.model.Convidado;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ConvidadosTest2 {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    Convidados conv;

    @Test
    public void it_should_save_convidado() {
        Convidado teste = new Convidado();
        teste.setNome("test convidado");

        teste = entityManager.persistAndFlush(teste);

        //Assert.assertThat(conv.findByNome(teste.getNome())).isEqualTo(teste);
        Assert.assertEquals("test convidado", teste.getNome());
    }
}