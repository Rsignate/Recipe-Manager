import java.util.ArrayList;
import java.util.List;

public class RecipeManager {
    private List<Recipe> recipes;

    public RecipeManager() {
        recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public void deleteRecipe(Recipe recipe) {
        recipes.remove(recipe);
    }

    public List<Recipe> searchRecipes(String keyword) {
        List<Recipe> results = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getName().contains(keyword) || recipe.getIngredients().contains(keyword) || recipe.getCategory().contains(keyword)) {
                results.add(recipe);
            }
        }
        return results;
    }

    public Recipe findRecipeByName(String name) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equalsIgnoreCase(name)) {
                return recipe;
            }
        }
        return null; // Recipe not found
    }

    public void editRecipe(Recipe oldRecipe, Recipe newRecipe) {
        if (recipes.contains(oldRecipe)) {
            int index = recipes.indexOf(oldRecipe);
            recipes.set(index, newRecipe);
        } else {
            System.out.println("Recipe not found.");
        }
    }

    public void viewAllRecipes() {
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
        }
    }
}
