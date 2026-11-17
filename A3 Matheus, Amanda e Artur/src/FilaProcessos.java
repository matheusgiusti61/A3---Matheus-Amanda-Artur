import java.util.ArrayList;

public class FilaProcessos {

	private ArrayList<Process> processos;

	
	//Construtor
	public FilaProcessos() {
		processos = new ArrayList<>();
	}
	
	public void addProcesso(Process processo) {
		processos.add(processo);
	}
	
	//Remove e retorna o primeiro processo da fila
	public Process removerProcess() {
		if (processos.isEmpty()) {
			return null;
		}

		return processos.remove(0);

	}

	//Consulta quem é o primeiro processo sem retirar retira-lo
	public Process consultarProcesso() {
		if (processos.isEmpty()) {
			return null;
		}

		return processos.get(0);
	}

	
	//Verifica q a fila está vazia
	public boolean FilaVazia() {
		return processos.isEmpty();

	}
	
	//Mostra a quantidade de processos
	public int tamanho() {
		return processos.size();

	}

	public void ListaProcessos() {
		for (Process processo: processos) {
			System.out.println("Processo" + processo.getId());
		}
	}


}



