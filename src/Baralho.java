import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Baralho {
    private List<Carta> cartas;

    public Baralho(int numCartas) {
        cartas = new ArrayList<>();
        for (int i = 1; i <= numCartas; i++) {
            cartas.add(new Carta(i));
        }
        embaralhar();
    }

    private void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta retirarCarta() {
        if (!cartas.isEmpty()) {
            return cartas.remove(0);
        }
        return null;
    }
}
