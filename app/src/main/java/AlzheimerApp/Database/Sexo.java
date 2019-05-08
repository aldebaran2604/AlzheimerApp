package AlzheimerApp.Database;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Luis Jose Padilla Benitez
 */
public enum Sexo {
    Ninguno(0), Masculino(1), Femenino(2);

    private int value = 0;

    private static Map map = new HashMap<>();

    private Sexo(int value){
        this.value = value;
    }

    static {
        for (Sexo sexoType : Sexo.values()) {
            map.put(sexoType.value, sexoType);
        }
    }

    public static Sexo valueOf(int sexoType) {
        return (Sexo) map.get(sexoType);
    }

    public int getValue(){
        return value;
    }
}
