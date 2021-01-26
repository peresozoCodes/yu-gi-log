public class Menu
{
    private static String[] TITLES =
    {
        "\n1. Ver Mano",
        "\n2. Ver Campo",
        "\n3. Invocar Carta (modo ATK)",
        "\n4. Colocar Carta (modo DEF)",
        "\n5. Declarar Ataque",
        "\n6. Cambiar Posicion",
        "\n7. Ver Cementerio",
        "\n8. Terminar Turno"
    };

    private static Intervalo OPTIONS = new Intervalo(1,8);

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
            gestorIO.out("\nOpción? [1-8]: ");
            option = gestorIO.inInt();
            error = !OPTIONS.incluye(option);
            if (error){
                gestorIO.out("\nError!!! La opción debe ser entre 1 y 8");
            }
        } while (error);
        return option;
    }
}
