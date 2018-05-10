/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com.mycompany;

import drink.drinks.Cliente;
import drink.drinks.Endereco;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Bianca
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SuppressWarnings("JPQLValidation")
public class TesteCliente{

    private static EntityManagerFactory emf;
    private static Logger logger;
    private EntityManager em;
    private EntityTransaction et;

    @BeforeClass
    public static void setUpClass() {
        logger = Logger.getGlobal();
        //logger.setLevel(Level.INFO);
        logger.setLevel(Level.SEVERE);
        emf = Persistence.createEntityManagerFactory("drinkPU");
        DbUnitUtil.inserirDados();
    }

    @AfterClass
    public static void tearDownClass() {
        emf.close();
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        beginTransaction();
    }

    @After
    public void tearDown() {
        commitTransaction();
        em.close();
    }

    private void beginTransaction() {
        et = em.getTransaction();
        et.begin();
    }

    private void commitTransaction() {
        try {
            et.commit();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            et.rollback();
            fail(ex.getMessage());
        }
    }

    @Test
    public void t01_persistirClienteValido() {
        logger.info("Executando t01: Persistir Cliente Valido");
        Cliente cliente = new Cliente();
        cliente.setTelefone("3433-7252");
        cliente.setLogin("Xuxa");
        cliente.setEmail("xuxa@gmail.com");
        cliente.setNome("Xuxa Meneghel");
        cliente.setSenha("xuxa666");
        Endereco endereco = new Endereco();
        endereco.setCep("50670-230");
        endereco.setBairro("Cidade Universitaria");
        endereco.setCidade("Recife");
        endereco.setEstado("Pernambuco");
        endereco.setNumero(20);
        endereco.setComplemento("Ap 301");
        endereco.setLogradouro("Av. Professor Moraes Rego");
        cliente.setEndereco(endereco);
        em.persist(cliente);
        em.flush();
        em.clear();
        cliente = em.find(Cliente.class, cliente.getId());
        assertNotNull(cliente.getId());
        logger.log(Level.INFO, "Cliente persistido com sucesso", cliente);
    }
}
