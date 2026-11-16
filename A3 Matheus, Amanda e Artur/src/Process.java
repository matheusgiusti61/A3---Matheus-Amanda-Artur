
public class Process {

	private int id;
	private int tempoChegada;
	private int tempoExecucao;
	private int tempoRestante;
	private int prioridade;
	
public Process (int id, int tempoChegada, int tempoExecucao,  int prioridade) {
	
	this.id = id;
	this.tempoChegada = tempoChegada;
	this.tempoExecucao = tempoExecucao;
	this.tempoRestante = tempoExecucao;
	this.prioridade = prioridade;	
}
	
public void diminuirTempo(int tempo) {
	tempoRestante -= tempo;
}

public int getPrioridade() {
	return prioridade;
}

public boolean finalProcesso() {
	return tempoRestante == 0;
}

public int getId () {
	return id;
}
public int getTempoChegada () {
	return tempoChegada;
}
public int getTempoExecucao () {
	return tempoExecucao;
}
public int getTempoRestante () {
	return tempoRestante;
}
	
}
