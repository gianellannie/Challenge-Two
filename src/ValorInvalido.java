public class ValorInvalido extends RuntimeException{
    private final String mensaje;

    public ValorInvalido(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
