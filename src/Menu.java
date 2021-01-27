public class Menu
{
    private static String[] TITLES =
    {
        "\n1. Ver Mano",
        "\n2. Ver Campo",
        "\n3. Invocar Carta",
        "\n4. Declarar Ataque",
        "\n5. Cambiar Posicion",
        "\n6. Ver Cementerio",
        "\n7. Terminar Turno"
    };

    private static Intervalo OPTIONS = new Intervalo(1,7);

    public void show()
    {
        GestorIO gestorIO = new GestorIO();
        for (String title : TITLES)
        {
            gestorIO.out(title);
        }
    }

    public int getOption() {
        GestorIO gestorIO = new GestorIO();
        int option;
        boolean error;
        do {
            gestorIO.out("\nOpción? [1-7]: ");
            option = gestorIO.inInt();
            error = !OPTIONS.incluye(option);
            if (error){
                gestorIO.out("\nError!!! La opción debe ser entre 1 y 7");
            }
        } while (error);
        return option;
    }
}
