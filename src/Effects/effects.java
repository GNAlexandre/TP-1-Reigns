package Effects;

import main.TypeJauge;

// DIRECTION {Gauche ou Droite} ; TypeJauge {Clergé, Peuple, Armée, Finance} ; Values { 0 => 50 }

public class effects {
    protected Direction direction;
    protected TypeJauge typeJauge;
    protected int values;

    public Direction getDirection() {
        return direction;
    }

    public TypeJauge getTypeJauge() {
        return typeJauge;
    }

    public int getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "effects{" +
                "direction=" + direction +
                ", typeJauge=" + typeJauge +
                ", values=" + values +
                '}';
    }

    public enum Direction {
        GAUCHE(),
        DROITE();

    }
}
