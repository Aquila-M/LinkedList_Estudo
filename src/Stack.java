import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>{// "<Item>" Parametrizar


    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }


    // o n� � o conte�do que ele est� apontando junto com o pr�ximo n� em seguida.
    private class Node{ // Sistema onde um n� vai apontar para outro n�
        private Item item;
        private Node next;
    }
    private class LinkedIterator implements Iterator<Item>{
        //Essa classe basicamente vai varrer a lista encadeada.
        //pra isso ter� m�todos que verificam se cont�m um pr�ximo n�.
        //usar� um atributo current para percorrer a lista pelos n�s.
        private Node current;
        public LinkedIterator(){ //construtor que atribui o current ao primeiro n� p/ come�ar
            current = first;
        }
        @Override
        public boolean hasNext(){ // Verifica se tem um n� ap�s o  n� atual;
            return current != null;
        }
        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException(); // se n�o teve, trata uma exception
            Item item = current.item; //Recebe o conte�do que est� neste n� para returnar em baixo
            current = current.next; // o ponteiro deixa de apontar pro atual para apontar p/ pr�ximo
            return item;
        }
    }
    private Node first; // first guarda esse campo l� de cima


    public void push(Item item){ // Adicionando n� na lista
        Node newNode = new Node(); //Cria um novo n� chamado newNode;
        newNode.item = item; //o n� aponta para o par�metro item especificado
        newNode.next = first; //depois o newNode ir� apontar para o pr�ximo, ou seja, para o first
        first = newNode; // o First ser� o newNode, no fim, adicionando um novo n� na lista j� existente
        n++; // incrementa no n indicando mais um n�;
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

    public int size(){ //m�todo que retorna o tamanho da lista;
        return n;
    }
    public boolean isEmpty(){ // método simples para verificar se a lista está vazia
        return first == null;
    } //Verifica se est� vazio a lista

    public Stack(){ // construtor indicando os valores na lista
        first = null;
        n = 0;
    }



}