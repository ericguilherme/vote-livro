package br.com.vote.livro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Votacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="votacao_key")
	private int votacaoKey;
	@OneToOne
	@JoinColumn(name = "livro_key")
	private Livro livroKey;
	private int voto;
	
	public Votacao(int votacaoKey) {
		this.votacaoKey = votacaoKey;
	}
	
	public Votacao(){
		
	}
	
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public int getVotacaoKey() {
		return votacaoKey;
	}
	public void setVotacaoKey(int votacaoKey) {
		this.votacaoKey = votacaoKey;
	}

	public Livro getLivroKey() {
		return livroKey;
	}

	public void setLivroKey(Livro livroKey) {
		this.livroKey = livroKey;
	}
	
}
