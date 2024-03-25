import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>{// "<Item>" Parametrizar


    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }


    // o nó é o conteúdo que ele está apontando junto com o próximo nó em seguida.
    private class Node{ // Sistema onde um nó vai apontar para outro nó
        private Item item;
        private Node next;
    }
    private class LinkedIterator implements Iterator<Item>{
        //Essa classe basicamente vai varrer a lista encadeada.
        //pra isso terá métodos que verificam se contém um próximo nó.
        //usará um atributo current para percorrer a lista pelos nós.
        private Node current;
        public LinkedIterator(){ //construtor que atribui o current ao primeiro nó p/ começar
            current = first;
        }
        @Override
        public boolean hasNext(){ // Verifica se tem um nó após o  nó atual;
            return current != null;
        }
        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException(); // se não teve, trata uma exception
            Item item = current.item; //Recebe o conteúdo que está neste nó para returnar em baixo
            current = current.next; // o ponteiro deixa de apontar pro atual para apontar p/ próximo
            return item;
        }
    }
    private Node first; // first guarda esse campo lá de cima


    public void push(Item item){ // Adicionando nó na lista
        Node newNode = new Node(); //Cria um novo nó chamado newNode;
        newNode.item = item; //o nó aponta para o parâmetro item especificado
        newNode.next = first; //depois o newNode irá apontar para o próximo, ou seja, para o first
        first = newNode; // o First será o newNode, no fim, adicionando um novo nó na lista já existente
        n++; // incrementa no n indicando mais um nó;
    }


    public Item pop() {
        Item item = null;
        if (isEmpty())
            throw new NoSuchElementException();
        else {
            item = first.item;
            first = first.next;
            n--;
        }
        return item;
    }

    public Item peek(){
        if(isEmpty())
            throw new NoSuchElementException("Empty Stack");
        return first.item;
    }

    private int n; //opcional indicar o tamanho da lista

    public int size(){ //método que retorna o tamanho da lista;
        return n;
    }
    public boolean isEmpty(){ // mÃ©todo simples para verificar se a lista estÃ¡ vazia
        return first == null;
    } //Verifica se está vazio a lista

    public Stack(){ // construtor indicando os valores na lista
        first = null;
        n = 0;
    }



}