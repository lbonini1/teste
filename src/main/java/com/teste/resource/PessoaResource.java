package com.teste.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.model.Pessoa;
import com.teste.service.impl.PessoaServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pessoa")
@Api(value="Pessoa", description = "API REST destinada a manipular as informações de uma Pessoa")
public class PessoaResource {
	
	@Autowired
	PessoaServiceImpl pessoaServiceImpl;
	
	@PostMapping
	@ApiOperation(value="Cadastrar uma nova Pessoa")
	public Pessoa cadastrarNovaPessoa(@RequestBody Pessoa pessoa) {
		Pessoa novaPessoa = pessoaServiceImpl.cadastrar(pessoa);
		return novaPessoa;
	}
	
	@GetMapping
	@ApiOperation(value="Obter uma lista de Pessoas cadastradas")
	public List<Pessoa> listarPessoasCadastradas(){
		List<Pessoa> listaPessoasEncontradas = pessoaServiceImpl.consultarPessoas();
		return listaPessoasEncontradas;
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Obter uma Pessoa cadastrada com base no Id fornecido")
	public ResponseEntity<Optional<Pessoa>> buscarPessoaPorId(@PathVariable Long id){
		Optional<Pessoa> pessoaEncontrada = pessoaServiceImpl.consultarPessoaPorId(id);
		if(pessoaEncontrada != null) {
			return ResponseEntity.ok(pessoaEncontrada);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping
	@ApiOperation(value="Excluir uma Pessoa cadastrada")
	public void excluirPessoaCadastrada(@RequestBody Pessoa pessoa) {
		if(pessoa != null)
			pessoaServiceImpl.excluir(pessoa);
	}
	
}
