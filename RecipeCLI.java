//import Recipe;
//import RecipeManager;
import java.util.List;
import java.util.Scanner;

public class RecipeCLI {
    private RecipeManager recipeManager;
    private Scanner scanner;

    public RecipeCLI() {
        recipeManager = new RecipeManager();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to Recipe Manager");
        System.out.println("1. Add Recipe");
        System.out.println("2. View Recipe");
        System.out.println("3. Search Recipe");
        // Add more options as needed
        System.out.println("0. Exit");
    }

    public void handleMenu() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addRecipe();
                    break;
                case 2:
                    viewRecipe();
                    break;
                case 3:
                    searchRecipe();
                    break;
                // Add cases for other options
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void addRecipe() {
        // Prompt user to enter recipe details
        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ingredients: ");
        String ingredients = scanner.nextLine();
        System.out.print("Enter instructions: ");
        String instructions = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        // Create Recipe object
        Recipe recipe = new Recipe(name, ingredients, instructions, category);

        // Add recipe to RecipeManager
        recipeManager.addRecipe(recipe);
    }

    private void viewRecipe() {
        System.out.print("Enter recipe name to view: ");
        String name = scanner.nextLine();
        Recipe recipe = recipeManager.findRecipeByName(name);
        if (recipe != null) {
            System.out.println("Name: " + recipe.getName());
            System.out.println("Ingredients: " + recipe.getIngredients());
            System.out.println("Instructions: " + recipe.getInstructions());
            System.out.println("Category: " + recipe.getCategory());
        } else {
            System.out.println("Recipe not found.");
        }
    }

    private void searchRecipe() {
        System.out.print("Enter keyword or ingredient to search: ");
        String keyword = scanner.nextLine();
        List<Recipe> matchingRecipes = recipeManager.searchRecipes(keyword);
        if (!matchingRecipes.isEmpty()) {
            for (Recipe recipe : matchingRecipes) {
                System.out.println(recipe.getName()); // Print recipe names
            }
        } else {
            System.out.println("No recipes found matching the keyword.");
        }
    }
}
