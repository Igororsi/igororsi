package estatica;

import entidades.Paciente;
import java.util.ArrayList;

public class FilaComPrioridade {

    private ArrayList<Paciente> heap;

    public FilaComPrioridade() {
        heap = new ArrayList<>();
    }

    // ENFILEIRAR -> SOBE HEAP
    public void enqueue(Paciente paciente) {

        heap.add(paciente);

        sobeHeap(heap.size() - 1);
    }

    private void sobeHeap(int indice) {

        while (indice > 0) {

            int pai = (indice - 1) / 2;

            if (heap.get(indice).maiorPrioridade(heap.get(pai))) {

                trocar(indice, pai);

                indice = pai;

            } else {
                break;
            }
        }
    }

    // DESENFILEIRAR -> DESCE HEAP
    public Paciente dequeue() {

        if (heap.isEmpty()) {
            return null;
        }

        Paciente raiz = heap.get(0);

        Paciente ultimo = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {

            heap.set(0, ultimo);

            desceHeap(0);
        }

        return raiz;
    }

    private void desceHeap(int indice) {

        while (true) {

            int maior = indice;

            int esquerda = 2 * indice + 1;
            int direita = 2 * indice + 2;

            if (esquerda < heap.size() &&
                    heap.get(esquerda).maiorPrioridade(heap.get(maior))) {

                maior = esquerda;
            }

            if (direita < heap.size() &&
                    heap.get(direita).maiorPrioridade(heap.get(maior))) {

                maior = direita;
            }

            if (maior != indice) {

                trocar(indice, maior);

                indice = maior;

            } else {
                break;
            }
        }
    }

    private void trocar(int i, int j) {

        Paciente temp = heap.get(i);

        heap.set(i, heap.get(j));

        heap.set(j, temp);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void imprimirHeap() {

        System.out.println("Estado atual do Heap:");

        for (Paciente p : heap) {
            System.out.println(p);
        }

        System.out.println();
    }
}