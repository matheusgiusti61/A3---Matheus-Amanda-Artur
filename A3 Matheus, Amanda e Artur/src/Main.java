
public class Main {

    public static void main(String[] args) {

        FilaProcessos fila = new FilaProcessos();

        Process p1 = new Process(1, 0, 5, 2);
        Process p2 = new Process(2, 1, 3, 1);
        Process p3 = new Process(3, 2, 7, 3);

        fila.addProcesso(p1);
        fila.addProcesso(p2);
        fila.addProcesso(p3);

        System.out.println("Processos na fila:");
        fila.ListaProcessos();

        System.out.println("Quantidade: " + fila.tamanho());

        System.out.println("Removendo primeiro processo...");
        Process removido = fila.removerProcess();

        System.out.println("Processo removido: " + removido.getId());

        System.out.println("Fila atualizada:");
        fila.ListaProcessos();

        System.out.println("Quantidade: " + fila.tamanho());
    }
}
