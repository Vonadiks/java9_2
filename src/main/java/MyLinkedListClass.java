//task1
public class MyLinkedListClass<T> {
    Node<T> first;
    Node<T> last;
    int size = 0;

    public static void main(String[] args) {
        MyLinkedListClass linkedList = new MyLinkedListClass();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList.size);
        System.out.println(linkedList.get(0));
        linkedList.remove(1);
        System.out.println(linkedList.size);
    }

    public int size(){
        return size;
    }

    private static class Node<T> {
        T item;
        MyLinkedListClass.Node<T> next;
        MyLinkedListClass.Node<T> prev;

        Node(MyLinkedListClass.Node<T> prev, T element, MyLinkedListClass.Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    MyLinkedListClass.Node<T> node(int index) {

        if (index < (size >> 1)) {
            MyLinkedListClass.Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            MyLinkedListClass.Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private void linkFirst(T t) {
        final MyLinkedListClass.Node<T> f = first;
        final MyLinkedListClass.Node<T> newNode = new MyLinkedListClass.Node<>(null, t, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    private void linkLast(T t) {
        final MyLinkedListClass.Node<T> l = last;
        final MyLinkedListClass.Node<T> newNode = new MyLinkedListClass.Node<>(l, t, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    T unlink(MyLinkedListClass.Node<T> x) {
        final T element = x.item;
        final MyLinkedListClass.Node<T> next = x.next;
        final MyLinkedListClass.Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    public boolean add(T t) {
        linkLast(t);
        return true;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private void checkElementIndex(int id) {
        if (!isElementIndex(id))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(id));
    }

    private void checkPositionIndex(int id) {
        if (!isPositionIndex(id))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(id));
    }

    private boolean isElementIndex(int id) {
        return id >= 0 && id < size;
    }


    private boolean isPositionIndex(int id) {
        return id >= 0 && id <= size;
    }

    public T get(int id) {
        checkElementIndex(id);
        return node(id).item;
    }

    public T remove(int id) {
        checkElementIndex(id);
        return unlink(node(id));
    }
}
