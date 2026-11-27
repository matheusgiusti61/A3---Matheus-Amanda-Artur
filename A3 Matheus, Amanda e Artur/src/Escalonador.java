import java.util.ArrayList;

public class Escalonador {

	public Process escolherProximo(FilaProcessos fila) {

		if (fila.FilaVazia()) {
			return null;
		}

		ArrayList<Process> lista = new ArrayList<>();

		while (!fila.FilaVazia()) {
			lista.add(fila.removerProcess());
		}

		Process melhor = lista.get(0);

		for (Process p : lista) {
			if (passaNaFrente(p, melhor)) {
				melhor = p;
			}
		}

		for (Process p : lista) {
			if (p != melhor) {
				fila.addProcesso(p);
			}
		}

		return melhor;
	}

	public void devolverNaoFinalizado(Process processo, FilaProcessos fila) {
		if (processo != null && !processo.finalProcesso()) {
			fila.addProcesso(processo);
		}
	}

	private boolean passaNaFrente(Process a, Process b) {

		if (a.getPrioridade() != b.getPrioridade()) {
			return a.getPrioridade() < b.getPrioridade();
		}

		if (a.getTempoRestante() != b.getTempoRestante()) {
			return a.getTempoRestante() < b.getTempoRestante();
		}

		return a.getTempoChegada() < b.getTempoChegada();
	}

}
