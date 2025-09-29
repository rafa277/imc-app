
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcularIMCTest {

    @Test
    public void testInvalidos() {
        assertEquals("Valores inválidos", Imc.calcularCondicao(0, 1.7, "F"));
        assertEquals("Valores inválidos", Imc.calcularCondicao(50, 0, "M"));
        assertEquals("Gênero inválido", Imc.calcularCondicao(50, 1.7, "X"));
    }

    @Test
    public void testAbaixoDoPeso() {
        assertEquals("abaixo do peso", Imc.calcularCondicao(50, 1.62, "F")); 
        assertEquals("abaixo do peso", Imc.calcularCondicao(50, 1.619, "F")); 
        assertEquals("no peso normal", Imc.calcularCondicao(50, 1.618, "F")); 
        assertEquals("abaixo do peso", Imc.calcularCondicao(60, 1.703, "M")); 
        assertEquals("no peso normal", Imc.calcularCondicao(60, 1.702, "M"));
    }

    @Test
    public void testNoPesoNormal() {
        assertEquals("no peso normal", Imc.calcularCondicao(60, 1.71, "F"));
        assertEquals("no peso normal", Imc.calcularCondicao(70, 1.65, "F"));
        assertEquals("marginalmente acima do peso", Imc.calcularCondicao(70, 1.649, "F"));
        assertEquals("no peso normal", Imc.calcularCondicao(70, 1.83, "M"));
        assertEquals("no peso normal", Imc.calcularCondicao(80, 1.74, "M"));
        assertEquals("marginalmente acima do peso", Imc.calcularCondicao(80, 1.739, "M"));
    }

    @Test
    public void testMarginalmenteAcima() {
        assertEquals("marginalmente acima do peso", Imc.calcularCondicao(70, 1.649, "F"));
        assertEquals("marginalmente acima do peso", Imc.calcularCondicao(75, 1.64, "F"));
        assertEquals("acima do peso ideal", Imc.calcularCondicao(75, 1.639, "F"));
        assertEquals("marginalmente acima do peso", Imc.calcularCondicao(80, 1.739, "M"));
        assertEquals("marginalmente acima do peso", Imc.calcularCondicao(85, 1.75, "M"));
        assertEquals("acima do peso ideal", Imc.calcularCondicao(85, 1.749, "M"));
    }

    @Test
    public void testAcimaDoPesoIdeal() {
        assertEquals("acima do peso ideal", Imc.calcularCondicao(75, 1.639, "F"));
        assertEquals("acima do peso ideal", Imc.calcularCondicao(90, 1.67, "F"));
        assertEquals("obeso", Imc.calcularCondicao(90, 1.669, "F")); //
        assertEquals("acima do peso ideal", Imc.calcularCondicao(85, 1.749, "M"));
        assertEquals("acima do peso ideal", Imc.calcularCondicao(95, 1.75, "M"));
        assertEquals("obeso", Imc.calcularCondicao(95, 1.749, "M"));
    }

    @Test
    public void testObeso() {
        assertEquals("obeso", Imc.calcularCondicao(90, 1.669, "F"));
        assertEquals("obeso", Imc.calcularCondicao(100, 1.5, "F"));
        assertEquals("obeso", Imc.calcularCondicao(95, 1.749, "M"));
        assertEquals("obeso", Imc.calcularCondicao(110, 1.6, "M"));
    }
}
