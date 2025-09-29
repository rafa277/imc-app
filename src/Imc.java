public class Imc {
    public static String calcularCondicao(double peso, double altura, String genero) {
        if (peso <= 0 || altura <= 0) {
            return "Valores inválidos";
        }
        genero = genero.toUpperCase();
        double imc = peso / (altura * altura);
        String condicao = "";

        if (genero.equals("F")) {
            if (imc < 19.1) {
                condicao = "abaixo do peso";
            } else if (imc < 25.8) {
                condicao = "no peso normal";
            } else if (imc < 27.3) {
                condicao = "marginalmente acima do peso";
            } else if (imc < 32.3) {
                condicao = "acima do peso ideal";
            } else {
                condicao = "obeso";
            }
        } else if (genero.equals("M")) {
            if (imc < 20.7) {
                condicao = "abaixo do peso";
            } else if (imc < 26.4) {
                condicao = "no peso normal";
            } else if (imc < 27.8) {
                condicao = "marginalmente acima do peso";
            } else if (imc < 31.1) {
                condicao = "acima do peso ideal";
            } else {
                condicao = "obeso";
            }
        } else {
            return "Gênero inválido";
        }
        return condicao;
    }
}
