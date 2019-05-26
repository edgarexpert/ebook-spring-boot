package com.algaworks.festa.services;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.Convidados;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.mock.MockCreationSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ConvidadoServiceImplTest {

    @TestConfiguration
    static class ConvidadoServiceImplTestContextConfiguration {

        @Bean
        public ConvidadoService convidadoService() {
            return new ConvidadoServiceImpl();
        }
    }

    @Autowired
    private ConvidadoService convidadoService;

    @MockBean
    private Convidados convidadoRepository;

    // write test cases here
    @Before
    public void setUp() {
        Convidado teste = new Convidado("teste");

        Mockito.when(convidadoRepository.findByNome(teste.getNome()))
                .thenReturn(teste);
    }

    @Test
    public void quandoNomeValido_entaoConvidadoDeveSerEncontrado() {
        String name = "teste";
        Convidado found = convidadoService.getConvidadoByNome(name);

//        assertThat(found.getNome())
//                .isEqualTo(name);

        Assert.assertEquals("teste", found.getNome());

        //MockCreationSettings;
    }
}