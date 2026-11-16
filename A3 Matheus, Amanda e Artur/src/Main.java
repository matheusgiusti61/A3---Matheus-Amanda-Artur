public class Main {

	public static void main(String[] args) {
		
		System.out.println("simulador de processos A3");
		
		
		//1 - id
		//2- Tempo de chegada
		//3- Tempo de execução e restante (juntos no construtor)
		//4- tempo de prioridade
		
		Process processo1 = new Process (1, 0, 10, 2);
		
		System.out.println("ID: " + processo1.getId());
		System.out.println("Tempo de chegada: " + processo1.getTempoChegada());
		System.out.println("Tempo Restante: " + processo1.getTempoRestante());
		
		processo1.diminuirTempo(4);
		
		System.out.println("Depois de executar: " + processo1.getTempoRestante());


	}

}
