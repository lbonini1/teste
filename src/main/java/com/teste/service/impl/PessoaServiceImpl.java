package com.teste.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.model.Pessoa;
import com.teste.repository.PessoaRepository;
import com.teste.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService{

	@Autowired
	PessoaRepository pessoaRepository;
	
	@Override
	public Pessoa cadastrar(Pessoa pessoa) {
		Pessoa novaPessoa = pessoaRepository.save(pessoa);
		return novaPessoa;
	}

	@Override
	public List<Pessoa> consultarPessoas() {
		List<Pessoa> listaPessoas = pessoaRepository.findAll();
		return listaPessoas;
	}

	@Override
	public Optional<Pessoa> consultarPessoaPorId(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if(pessoa != null) {
			return pessoa;
		}
		return null;
	}

	@Override
	public void excluir(Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}
	

}
