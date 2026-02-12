public class SLL<E> {
    public static class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E data){
            this.data = data;
        }
        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;

        }

        public E getData(){
            return data;
        }

        public Node<E> getNext(){
            return next;
        }

        private Node<E> head;
        private int size;

        public SLL(){
            head = null;
            size = 0;
        }
        public void add(E item, int index){
            if( index < 0 || index >= size){
                throw new IndexOutOfBoundsException();
            }
            if(index ==0){
                head = new Node(item,head);
                size++;
            }
            else{
                Node<E> current = head;
                for(int i = 0; i < index; i++){
                    current = current.next;
                }
                Node<E> newNode= new Node<>(item, current.next);
                current.next = newNode;
                size++;
//                current.next = newNode<>(item, current;);
            }
        }

        public E get(int index){
            if(index < 0 || index >= size){
                throw new IndexOutOfBoundsException();
            }
            Node<E> current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            return current.data;
        }

        private void removeFirst(){
            if(head == null){
                throw new IllegalArgumentException();
            }
        }

        public E Remove(int index){
            if(index < 0 || index >= size){
                throw new IndexOutOfBoundsException();
            }
            if(index == 0){
                removeFirst();
            }
            if(index == 0){
                head = head.next;
                size--;
            }
            else{
                Node<E> current = head;
                for(int i = 0; i < index; i++){
                    current = current.next;
                }
                if(current.next.next != null){
                    current.next = current.next.next;
                    size--;
                }
            }


        }
    }
}

