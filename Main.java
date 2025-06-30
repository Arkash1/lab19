package com.company;
public class Main {
    public static void main(String[] args) {
        Clothing[] clothes = {
                new TShirt(Size.M, 1500, "голубой"),
                new Pants(Size.L, 2500, "черный"),
                new Skirt(Size.S, 2000, "красный"),
                new Tie(Size.XS, 1000, "зеленый")
        };

        Atelier atelier = new Atelier();
        atelier.dressMan(clothes);
        atelier.dressWoman(clothes);
    }
}

enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Детский размер";
        }
    },
    XS(34), S(36), M(38), L(40);

    private int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public int getEuroSize() {
        return euroSize;
    }

    public String getDescription() {
        return "Взрослый размер";
    }
}

interface MenClothing {
    void dressMan();
}

interface WomenClothing {
    void dressWoman();
}

abstract class Clothing {
    protected Size size;
    protected double price;
    protected String color;

    public Clothing(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Размер: " + size + " (" + size.getEuroSize() + "), " +
                "Описание: " + size.getDescription() + ", " +
                "Цена: " + price + ", Цвет: " + color;
    }
}

class TShirt extends Clothing implements MenClothing, WomenClothing {
    public TShirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужская футболка: " + this);
    }

    @Override
    public void dressWoman() {
        System.out.println("Женская футболка: " + this);
    }
}

class Pants extends Clothing implements MenClothing, WomenClothing {
    public Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужские штаны: " + this);
    }

    @Override
    public void dressWoman() {
        System.out.println("Женские штаны: " + this);
    }
}

class Skirt extends Clothing implements WomenClothing {
    public Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWoman() {
        System.out.println("Юбка: " + this);
    }
}

class Tie extends Clothing implements MenClothing {
    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Галстук: " + this);
    }
}

class Atelier {
    public void dressMan(Clothing[] clothes) {
        System.out.println("=== Мужская одежда ===");
        for (Clothing c : clothes) {
            if (c instanceof MenClothing) {
                ((MenClothing) c).dressMan();
            }
        }
    }

    public void dressWoman(Clothing[] clothes) {
        System.out.println("=== Женская одежда ===");
        for (Clothing c : clothes) {
            if (c instanceof WomenClothing) {
                ((WomenClothing) c).dressWoman();
            }
        }
    }
}
