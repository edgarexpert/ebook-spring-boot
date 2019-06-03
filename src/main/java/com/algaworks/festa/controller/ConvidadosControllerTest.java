package com.algaworks.festa.controller;

import com.algaworks.festa.model.Convidado;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)

//@SpringBootTest
@WebMvcTest(ConvidadosController.class)
public class ConvidadosControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private ConvidadosController service;

    // write test cases here
    @Test
    public void dadoConvidados_quandoPegarConvidados_entaoRetorneJsonArray()
            throws Exception {

        Convidado teste = new Convidado("teste");

        List<Convidado> allConvidados = Arrays.asList(teste);

        //BDDMockito.given(service.listar()).willReturn(allConvidados);

        mvc.perform(get("/convidados")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nome", is(teste.getNome())))
        ;
    }
}