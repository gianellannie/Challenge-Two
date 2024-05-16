public class OpcionesLimitadas {
    private String monedaBase;
    private String monedaDestino;
    private Conversor conversor = new Conversor();

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public Conversor getConversor() {
        return conversor;
    }

    public double valorFinal(int opcion, double valorInicial){
        switch (opcion) {
            case 1:
                this.monedaBase = "USD";
                this.monedaDestino = "COP";
                break;
            case 2:
                this.monedaBase = "USD";
                this.monedaDestino = "ARS";
                break;
            case 3:
                this.monedaBase = "USD";
                this.monedaDestino = "CLP";
                break;
            case 4:
                this.monedaBase = "USD";
                this.monedaDestino = "BRL";
                break;
            case 5:
                this.monedaBase = "USD";
                this.monedaDestino = "BOB";
                break;
            case 6:
                this.monedaBase = "BRL";
                this.monedaDestino = "COP";
                break;
            case 7:
                this.monedaBase = "BRL";
                this.monedaDestino = "ARS";
                break;
            case 8:
                this.monedaBase = "BRL";
                this.monedaDestino = "CLP";
                break;
            case 9:
                this.monedaBase = "BRL";
                this.monedaDestino = "USD";
                break;
            case 10:
                this.monedaBase = "BRL";
                this.monedaDestino = "BOB";
                break;
            case 11:
                this.monedaBase = "BOB";
                this.monedaDestino = "COP";
                break;
            case 12:
                this.monedaBase = "BOB";
                this.monedaDestino = "ARS";
                break;
            case 13:
                this.monedaBase = "BOB";
                this.monedaDestino = "CLP";
                break;
            case 14:
                this.monedaBase = "BOB";
                this.monedaDestino = "BRL";
                break;
            case 15:
                this.monedaBase = "BOB";
                this.monedaDestino = "USD";
                break;
        }
        return this.conversor.valorFinal(monedaBase,monedaDestino,valorInicial);
    }
}
