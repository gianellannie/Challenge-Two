import com.google.gson.Gson;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Conversor implements IConvertirDatos {
    private String monedaBase;
    private String monedaDestino;
    private double tipoDeCambio;
    private double valorInicial;
    private double valorFinal;
    private String fecha;
    private DatosConversionDePares conversion;
    private ConsumirApi consumir = new ConsumirApi();
    private Gson deserializar = new Gson();
    private final String URL_BASE = "https://v6.exchangerate-api.com/v6/";
    private final String API_KEY = "YOUR-API-KEY";
    private DatosCodigosAdmitidos codigos = convertir(URL_BASE + API_KEY + "/codes",DatosCodigosAdmitidos.class);
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public <T> T convertir(String url_str, Class<T> clase){
        String json = consumir.consumirApi(url_str);
        T conversion = deserializar.fromJson(json,clase);
        return conversion;
    }
    public double valorFinal(
            String monedaBase,String monedaDestino,double valorIncial
    ){
        String url_str = URL_BASE + API_KEY + "/pair/"+monedaBase+"/"+monedaDestino+"/"+valorIncial;
        conversion = convertir(url_str,DatosConversionDePares.class);
        this.valorInicial = valorIncial;
        this.monedaBase = conversion.base_code();
        this.monedaDestino = conversion.target_code();
        this.tipoDeCambio = conversion.conversion_rate();
        this.valorFinal = conversion.conversion_result();
        this.fecha = LocalDateTime.now().format(formato);
        return this.valorFinal;
    }
    public void codigosAdmitidos(){
        System.out.println("Código de moneda >> Nombre de la moneda");
        for (List<String> codigo : codigos.supported_codes()){
            System.out.println(codigo.get(0)+" >> "+codigo.get(1));
        }
    }
    public boolean codigoValido(String codigoMoneda){
        boolean valido = true;
        for (List<String> codigo : codigos.supported_codes()){
            if (codigo.get(0).equalsIgnoreCase(codigoMoneda)){
                valido = false;
                break;
            }
        }
        return valido;
    }

    @Override
    public String toString() {
        return String.format("""
                        ---------------------------------------
                        Moneda Base: %s,
                        Moneda de Destino: %s,
                        Tipo de Cambio: %.2f,
                        Valor Inicial: %.2f,
                        Valor Final: %.2f
                        Fecha: %s""",
                monedaBase,monedaDestino,
                tipoDeCambio,valorInicial,valorFinal,
                fecha);
    }
}
