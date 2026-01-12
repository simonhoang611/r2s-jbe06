package inheritance.inheritance_items;

public class ItemList {

    private Item[] list;
    private int numOfItem;
    private final int MAX = 100;

    public ItemList() {
        list = new Item[MAX];
        numOfItem = 0;
    }

    public int getNumItem(){
        return numOfItem;
    }

    public boolean addItem(Item item) {
        if (item == null || numOfItem >= 100) {
            return false;
        }
        list[numOfItem] = item;
        numOfItem++;
        return true;
    }

    public void displayAll() {
        if (numOfItem == 0) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < numOfItem; i++) {
                System.out.println(list[i]);
            }
        }
    }

    public Item findItem(String creator) {
        short count = 0;
        for (int i = 0; i < numOfItem; i++) {
            if (list[i] != null && list[i].getCreator().contains(creator)) {
                System.out.println(list[i]);
                count++;
            }
        }
        if(count == 0){
            System.out.println("No item found with that creator name.");
        };
        return null;
    }

    public void displayVases(){
        boolean found = false;
        for(int i = 0; i < numOfItem; i++){
            if(list[i] instanceof Vase){
                System.out.println(list[i]);
                found = true;
            }
        }

        if(!found){
            System.out.println("There is no vase!");
        }
    }

    public void displayItemsByType(String type) {
        if (type.equalsIgnoreCase("Vase")) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Vase) {
                    System.out.println(list[i]);
                }
            }
        } else if (type.equalsIgnoreCase("Statue")) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Statue) {
                    System.out.println(list[i]);
                }
            }
        } else if (type.equalsIgnoreCase("Painting")) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Painting) {
                    System.out.println(list[i]);
                }
            }
        } else {
            System.out.println("Invalid type!");
        }
    }
}
