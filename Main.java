public class Main {
    public static void main(String[] args) {
        // Run either GUI or CLI based on arguments
        if (args.length > 0 && args[0].equalsIgnoreCase("cli")) {
            RecipeCLI recipeCLI = new RecipeCLI();
            recipeCLI.handleMenu();
        } else {
            RecipeManagerGUI recipeManagerGUI = new RecipeManagerGUI();
        }
    }
}
