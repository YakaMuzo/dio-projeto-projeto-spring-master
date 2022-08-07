package com.ecsdev.service.impl;

import com.ecsdev.model.Cliente;
import com.ecsdev.model.ClienteRepository;
import com.ecsdev.model.Endereco;
import com.ecsdev.model.EnderecoRepository;
import com.ecsdev.service.ClienteService;
import com.ecsdev.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author ericcleptonsilva
 */
public class ClienteServiceImpl implements ClienteService {
    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.


    @Override
    public Iterable<Cliente> buscarTodos() {
        // BUscar todos os Clientes.
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // Buscar Cliente por Id.
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {


    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // Buscar Cliente por ID, caso exista:

    }

    @Override
    public void deletar(Long id) {
        // Deletar Cliente por ID.

    }

    private void salvarClienteComCep(Cliente cliente) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        clienteRepository.save(cliente);
    }

}
