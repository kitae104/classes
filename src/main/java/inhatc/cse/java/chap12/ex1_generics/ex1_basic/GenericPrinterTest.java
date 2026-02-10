package inhatc.cse.java.chap12.ex1_generics.ex1_basic;

public class GenericPrinterTest {
    public static void main(String[] args) {
        GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();
        Powder powder = new Powder();
        powderPrinter.setMaterial(powder);
        Powder returnedPowder = powderPrinter.getMaterial();
        returnedPowder.doPrinting();
        System.out.println(powderPrinter);

        GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
        Plastic plastic = new Plastic();
        plasticPrinter.setMaterial(plastic);
        Plastic returnedPlastic = plasticPrinter.getMaterial();
        returnedPlastic.doPrinting();
        System.out.println(plasticPrinter);
    }
}
