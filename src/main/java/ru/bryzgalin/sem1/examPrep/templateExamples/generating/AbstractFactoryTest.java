package ru.bryzgalin.sem1.examPrep.templateExamples.generating;
/*
Abstract Factory (Абстрактная фабрика)
Позволяет выбрать конкретную реализацию фабрики из семейства возможных фабрик.
Создает семейство связанных объектов.
Легко расширять.
 */
//интерфейсы для абстрактного продукта
interface Lada {
    long getLadaPrice();
}
interface Ferrari {
    long getFerrariPrice();
}
interface Porshe {
    long getPorshePrice();
}
//интерфейс для абстрактной фабрики
interface InteAbsFactory {
    Lada getLada();
    Ferrari getFerrari();
    Porshe getPorshe();
}
//конкретные классы продуктов ua
class UaLadaImpl implements Lada {
    public long getLadaPrice() {
        return 1000;
    }
}
class UaFerrariImpl implements Ferrari {
    public long getFerrariPrice() {
        return 3000;
    }
}
class UaPorsheImpl implements Porshe {
    public long getPorshePrice() {
        return 2000;
    }
}
//конкретная фабрика для группы продуктов ua
class UaCarPriceAbsFactory implements InteAbsFactory {
    public Lada getLada() {
        return new UaLadaImpl();
    }
    public Ferrari getFerrari() {
        return new UaFerrariImpl();
    }
    public Porshe getPorshe() {
        return new UaPorsheImpl();
    }
}
//конкретные классы продуктов ru
class RuLadaImpl implements Lada {
    public long getLadaPrice() {
        return 10000;
    }
}
class RuFerrariImpl implements Ferrari {
    public long getFerrariPrice() {
        return 30000;
    }
}
class RuPorsheImpl implements Porshe {
    public long getPorshePrice() {
        return 20000;
    }
}
//конкретная фабрика для группы продуктов ru
class RuCarPriceAbsFactory implements InteAbsFactory {
    public Lada getLada() {
        return new RuLadaImpl();
    }
    public Ferrari getFerrari() {
        return new RuFerrariImpl();
    }
    public Porshe getPorshe() {
        return new RuPorsheImpl();
    }
}

public class AbstractFactoryTest {
    public static void main(String[] args) {
        String country = "UA";
        InteAbsFactory ifactory = null;
        if(country.equals("UA")) {
            ifactory = new UaCarPriceAbsFactory();
        } else if (country.equals("RU")) {
            ifactory = new RuCarPriceAbsFactory();
        }

        Lada lada = ifactory.getLada();
        System.out.println(lada.getLadaPrice());
    }
}
/*
concreteCar -> absCar
concreteFactory -> absFactory

 */