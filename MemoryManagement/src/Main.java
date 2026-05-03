public class Main {
    public static void main(String [] args){
        IntArrayList list = new IntArrayList();// new IntArrayList object but not an actual arrayList

        list.add(5);
        list.add(10);
        list.add(15);

        for (int i=0; i< list.size(); i++){
            System.out.println(list.get(i));
        }
    }

}
