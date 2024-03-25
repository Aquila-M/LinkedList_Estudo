import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        linkedlist2<String> list = new linkedlist2<>();
        //Essa lista como guarda qualquer coisa, pode-se definir o tipo dela.
        list.addFirst("teste testes");
        list.addFirst("string generica");
        list.addFirst("Vai ser o primeiro");

        for (var s : list) {
            System.out.println(s);
        }
        System.out.println("Size of list = " + list.size());

    }
}
