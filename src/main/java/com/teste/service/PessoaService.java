package com.teste.service;

import java.util.List;
import java.util.Optional;

import com.teste.model.Pessoa;

public interface PessoaService {
	
	public Pessoa cadastrar(Pessoa pessoa);
	
	public List<Pessoa> consultarPessoas();
	
	public Optional<Pessoa> consultarPessoaPorId(Long id);
	
	public void excluir(Pessoa pessoa);
	
}
