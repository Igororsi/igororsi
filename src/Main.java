import entidades.Paciente;
import estatica.FilaComPrioridade;

public class Main {

    public static void main(String[] args) {

        FilaComPrioridade fila = new FilaComPrioridade();

        Paciente p1 = new Paciente("Carlos", 2, 45, false);
        Paciente p2 = new Paciente("Maria", 5, 5, false);
        Paciente p3 = new Paciente("João", 3, 20, false);
        Paciente p4 = new Paciente("Beatriz", 3, 35, true);
        Paciente p5 = new Paciente("Pedro", 5, 2, false);
        Paciente p6 = new Paciente("Helena", 2, 45, true);

        System.out.println("===== INSERINDO PACIENTES =====\n");

        fila.enqueue(p1);
        fila.imprimirHeap();

        fila.enqueue(p2);
        fila.imprimirHeap();

        fila.enqueue(p3);
        fila.imprimirHeap();

        fila.enqueue(p4);
        fila.imprimirHeap();

        fila.enqueue(p5);
        fila.imprimirHeap();

        fila.enqueue(p6);
        fila.imprimirHeap();

        System.out.println("===== ORDEM DE ATENDIMENTO =====\n");

        while (!fila.isEmpty()) {

            System.out.println(fila.dequeue());
        }
    }
}