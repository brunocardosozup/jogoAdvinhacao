package com.br.jogo.advinhacao.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.jogo.advinhacao.models.Jogador;
import com.br.jogo.advinhacao.models.NumSorteado;
import com.br.jogo.advinhacao.repositories.JogadorRepository;
import com.br.jogo.advinhacao.repositories.NumSorteadoRepository;

@Service
public class NumSorteadoService {

	@Autowired
	private JogadorRepository jogadorRepository;

	@Autowired
	private NumSorteadoRepository numSorteadoRopository;

	public String salvarJogo(Jogador jogador) {

		NumSorteado jogoAdvinhacao = new NumSorteado();
		Random random = new Random();
		int numero = 1 + random.nextInt(10);
		String mensagen = "";

		if (jogador.getNumeroJogado() == numero) {
			jogoAdvinhacao.setNumero(numero);
			jogoAdvinhacao.setJogador(jogador);
			jogador.setNumSorteado(jogoAdvinhacao);
			jogadorRepository.save(jogador);

			mensagen = "Parabéns vc ganhou\nNumero jogado " + jogador.getNumeroJogado() + " numero sorteado" + numero;
		} else {
			mensagen = "Não foi desta vez\nNumero jogado " + jogador.getNumeroJogado() + " numero sorteado" + numero;
		}

		return mensagen;

	}

}