import java.util.ArrayList;
import java.util.List;

public class Historial {
    private final List<Conversor> historial = new ArrayList<>();

    public void getHistorial() {
        if (!historial.isEmpty()) {
            System.out.println(">> Historial");
            for (Conversor registro : historial){
                System.out.println(registro);
            }
            System.out.println(">> Fin del historial");
        } else {
            System.out.println(">> El historial está vacío.");
        }
    }
    public void agregar(Conversor conversor){
        historial.add(conversor);
    }
}
