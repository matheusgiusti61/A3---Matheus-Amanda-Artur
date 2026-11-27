
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
	// Evita tempo restante negativo (ex.: restava 3 e executou o quantum de 4)
	if (tempoRestante < 0) {
		tempoRestante = 0;
	}
}

public int getPrioridade() {
	return prioridade;
}

public boolean finalProcesso() {
	return tempoRestante <= 0;
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

// Converte o processo criado pelo gerador do professor (id "P12")
// para o Process do projeto (id 12)
public static Process doGerador(ProcessGenerator.Process g) {
	int id = Integer.parseInt(g.id.replaceAll("\\D", ""));
	return new Process(id, g.arrivalTime, g.executionTime, g.priority);
}
	
}
