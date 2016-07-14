package parrot;

public class Parrot {

    private ParrotTypeEnum type;
    private int numberOfCoconuts = 0;
    private double voltage;
    private boolean isNailed;


    private Parrot(ParrotTypeEnum _type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = _type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    protected Parrot() {

    }

    public static Parrot create(ParrotTypeEnum _type, int numberOfCoconuts, double voltage, boolean isNailed) {
        if (_type.equals(ParrotTypeEnum.EUROPEAN)) {
            return new EuropeanParrot();
        }

        if (_type.equals(ParrotTypeEnum.AFRICAN)) {
            return new AfricanParrot(numberOfCoconuts);
        }

        if(_type.equals(ParrotTypeEnum.NORWEGIAN_BLUE)) {
            return new NorwegianBlueParrot(voltage, isNailed);
        }

        return new Parrot(_type, numberOfCoconuts, voltage, isNailed);
    }

    public double getSpeed() {
        throw new RuntimeException("Should be unreachable");
    }

    protected double getBaseSpeed() {
        return 12.0;
    }
}
