package com.projeto_integrador_gen.egide.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_integrador_gen.egide.model.Instituicao;
import com.projeto_integrador_gen.egide.repository.InstituicaoRepository;




@Service
public class InstituicaoServices {
	
	@Autowired
	private InstituicaoRepository repository;
	

	
	/**
	 * Registra no banco uma nova instituicao para acessar o sistema caso o e-mail não exista, retornando um Optional com a Entidade
	 * @param 	novaInstituicao uma Entidade Instituicao
	 * @return 	Optional com Instituicao se os parametos estiverem devidamente escritos, caso contrario vazio(empty)
	 * @since 	1.0
	 * @author 	Egide 
	 */
	public Optional<Instituicao> cadastrarInstituicao (Instituicao novaInstituicao)
	{
		Optional<Instituicao> instituicaoExistente = repository.findByEmail(novaInstituicao.getEmail());
		if (instituicaoExistente.isPresent()) 
		{
			return Optional.empty();
		} 
		Optional<Instituicao> instituicaoCadastrada = Optional.ofNullable(repository.save(novaInstituicao));
		if(instituicaoCadastrada.isPresent())
		{
			return instituicaoCadastrada;
		}
		else {
			return Optional.empty();

		}
		
	}
	
	/**
	 * Registra no banco uma nova instituicao para acessar o sistema caso o nome não exista, retornando um Optional com a Entidade
	 * @param 	novaInstituicao uma Entidade Instituicao
	 * @return 	Optional com Instituicao se os parametos estiverem devidamente escritos, caso contrario vazio(empty)
	 * @since 	1.0
	 * @author 	Egide 
	 */
	public Optional<Instituicao> cadastrarInstituicaoNome (Instituicao novaInstituicao)
	{
		Optional<Instituicao> instituicaoExistente = repository.findByNome(novaInstituicao.getNome());
		if(instituicaoExistente.isPresent())
		{
			return Optional.empty();
		}
		Optional<Instituicao> instituicaoCadastrada = Optional.ofNullable(repository.save(novaInstituicao));
		if(instituicaoCadastrada.isPresent())
		{
			return instituicaoCadastrada;
		}
		else
		{
			return Optional.empty();
		}
	}
	
	/**
	 * Registra no banco uma nova instituicao para acessar o sistema caso o cnpj não exista, retornando um Optional com a Entidade
	 * @param 	novaInstituicao uma Entidade Instituicao
	 * @return 	Optional com Instituicao se os parametos estiverem devidamente escritos, caso contrario vazio(empty)
	 * @since 	1.0
	 * @author 	Egide 
	 */
	public Optional<Instituicao> cadastrarInstituicaoCnpj (Instituicao novaInstituicao)
	{
		Optional<Instituicao> instituicaoExistente = repository.findByCnpj(novaInstituicao.getCnpj());
		if(instituicaoExistente.isPresent())
		{
			return Optional.empty();
		}
		Optional<Instituicao> instituicaoCadastrada = Optional.ofNullable(repository.save(novaInstituicao));
		if(instituicaoCadastrada.isEmpty())
		{
			return instituicaoCadastrada;
		}
		else
		{
			return Optional.empty();
		}
	}

	}
	
		
	
				
			
				
	

