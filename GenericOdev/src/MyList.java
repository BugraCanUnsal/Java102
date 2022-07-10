public class MyList<T> {

    private T[] arrayMain;
    private int capacity = 10;

    public MyList() {
        this.arrayMain = (T[]) new Object[capacity];
    }
    public MyList(int length){
        this.arrayMain = (T[]) new Object[length];
        this.capacity = length;
    }

    public void add(T data){
        int i = 0;
        while (i != this.arrayMain.length){
            if (this.arrayMain[i] != null){
                i++;
            }else break;
        }
        if (i == this.arrayMain.length){
            T[] listHolder = (T[]) new Object[this.capacity*2];
            for (int j = 0; j < this.arrayMain.length; j++) {
                listHolder[j] = this.arrayMain[j];
            }
            listHolder[i] = data;
            this.arrayMain = (T[]) new Object[this.capacity*2];
            for (int j = 0; j < listHolder.length; j++) {
                this.arrayMain[j] = listHolder[j];
            }
            setCapacity(this.capacity*2);
        }else {
            this.arrayMain[i] = data;
        }

    }

    public int size(){
        int size = 0;
        for (T t: this.arrayMain ) {
            if (t != null){
                size++;
            }
        }
        return size;
    }

    public T[] getArrayMain() {
        return this.arrayMain;
    }

    public int getCapacity() {
        return capacity;
    }
    public String toString(){
        String value = "[";
        for (int i = 0; i < arrayMain.length; i++) {
            if (i == arrayMain.length-1){
                value += arrayMain[i] + "]";
            }else {
                value += arrayMain[i] + ",";
            }
        }
        return value;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T get(int index){
        if (index < 0 && index >= this.getCapacity()){
            return null;
        }
        return this.arrayMain[index];
    }
    public void remove(int index){
        if (index < 0 || index >= this.getCapacity()){
            System.out.println("null");
        } else if (index == this.arrayMain.length-1) {
            this.arrayMain[index] = null;
        } else {
            for (int i = index; i <this.arrayMain.length-1; i++) {
                this.arrayMain[i] = this.arrayMain[i+1];
                this.arrayMain[i+1] = null;
            }

        }
    }

    public void set(int index, T data){
        if (index < 0 || index >= this.getCapacity()){
            System.out.println("null");
        }else {
            this.arrayMain[index] = data;
        }
    }

    public int indexOf(T data){
        for (int i = 0; i < getCapacity(); i++) {
            if (data == this.arrayMain[i]){
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(T data){
        for (int i = getCapacity()-1; i >= 0 ; i--) {
            if (data == this.arrayMain[i]){
                return i;
            }
        }
        return -1;
    }
    public boolean isEmpty(){
        for (T t: this.arrayMain ) {
            if (t != null) return false;
        }return true;
    }
    public void clear(){
        for (int i = 0; i < this.getCapacity()-1; i++) {
            this.arrayMain[i] = null;
        }
    }
    public MyList<T> sublist(int start,int finish){
        MyList<T> sublist = new MyList<>();
        if (start <= finish && start >= 0 && finish <= getCapacity()-1){
            for (int i =start; i <=finish ; i++) {
                sublist.add(this.arrayMain[i]);
            }
        }else {
            System.out.println("Araligi kontrol edin...");
        }
        return sublist;
    }

    public boolean contains(T data){
        for (int i = 0; i < getCapacity()-1; i++) {
            if (this.arrayMain[i] == data){
                return true;
            }
        }return false;
    }

}


