public class Main {
    public static void main(String[] args) {
        Clothing[] clothes = {
                new TShirt(Size.M, 1200, "Белый"),
                new Pants(Size.L, 2300, "Черный"),
                new Skirt(Size.S, 1800, "Красный"),
                new Tie(Size.XS, 900, "Синий"),
                new TShirt(Size.XXS, 1000, "Желтый")
        };

        Atelier atelier = new Atelier();
        atelier.dressWomen(clothes);
        atelier.dressMen(clothes);
    }
}
enum Size{
    XXS(32){
        @Override public String getDescription(){
            return "Детский размер";
        }
    },
    XS(34), S(36), M(38), L(40);
    private int euroSize;
    Size(int euroSize){
        this.euroSize = euroSize;
    }
    public String getDescription(){
        return "Взрослый размер";
    }
    public int getEuroSize(){
        return euroSize;
    }
}
interface MenClothing{
    void DressMan();
}
interface WomenClothing{
    void DressWoman();
}
abstract class Clothing {
    public Size size;
    public double price;
    public String color;

    public Clothing(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Размер: " + size + " (" + size.getEuroSize() + ", " + size.getDescription() + "), " +
                "Цвет: " + color + ", Цена: " + price + " руб.";
    }
}

class TShirt extends Clothing implements MenClothing, WomenClothing {
    public TShirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void DressMan() {
        System.out.println("Мужская футболка: " + this);
    }

    @Override
    public void DressWoman() {
        System.out.println("Женская футболка: " + this);
    }
}

class Pants extends Clothing implements MenClothing, WomenClothing {
    public Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void DressMan() {
        System.out.println("Мужские штаны: " + this);
    }

    @Override
    public void DressWoman() {
        System.out.println("Женские штаны: " + this);
    }
}

class Skirt extends Clothing implements WomenClothing {
    public Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void DressWoman() {
        System.out.println("Женская юбка: " + this);
    }
}

class Tie extends Clothing implements MenClothing {
    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void DressMan() {
        System.out.println("Мужской галстук: " + this);
    }
}

// Atelier class
class Atelier {
    public void dressWomen(Clothing[] clothes) {
        System.out.println("Одежда для женщин:");
        for (Clothing c : clothes) {
            if (c instanceof WomenClothing) {
                ((WomenClothing) c).DressWoman();
            }
        }
    }

    public void dressMen(Clothing[] clothes) {
        System.out.println("Одежда для мужчин:");
        for (Clothing c : clothes) {
            if (c instanceof MenClothing) {
                ((MenClothing) c).DressMan();
            }
        }
    }
}
