import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RecipeManagerGUI {
    private JFrame frame;
    private RecipeManager recipeManager;

    public RecipeManagerGUI() {
        frame = new JFrame("Recipe Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        recipeManager = new RecipeManager();

        JPanel panel = new JPanel(new GridLayout(3, 1));
        JButton addButton = new JButton("Add Recipe");
        JButton viewButton = new JButton("View Recipe");
        JButton searchButton = new JButton("Search Recipe");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRecipe();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewRecipe();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchRecipe();
            }
        });

        panel.add(addButton);
        panel.add(viewButton);
        panel.add(searchButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void addRecipe() {
        String name = JOptionPane.showInputDialog(frame, "Enter recipe name:");
        String ingredients = JOptionPane.showInputDialog(frame, "Enter ingredients:");
        String instructions = JOptionPane.showInputDialog(frame, "Enter instructions:");
        String category = JOptionPane.showInputDialog(frame, "Enter category:");

        Recipe recipe = new Recipe(name, ingredients, instructions, category);
        recipeManager.addRecipe(recipe);
        JOptionPane.showMessageDialog(frame, "Recipe added successfully!");
    }

    private void viewRecipe() {
        String name = JOptionPane.showInputDialog(frame, "Enter recipe name:");
        Recipe recipe = recipeManager.findRecipeByName(name);
        if (recipe != null) {
            JOptionPane.showMessageDialog(frame, "Name: " + recipe.getName() + "\nIngredients: " + recipe.getIngredients() + "\nInstructions: " + recipe.getInstructions() + "\nCategory: " + recipe.getCategory());
        } else {
            JOptionPane.showMessageDialog(frame, "Recipe not found.");
        }
    }

    private void searchRecipe() {
        String keyword = JOptionPane.showInputDialog(frame, "Enter keyword or ingredient to search:");
        List<Recipe> matchingRecipes = recipeManager.searchRecipes(keyword);
        if (!matchingRecipes.isEmpty()) {
            StringBuilder recipesFound = new StringBuilder();
            for (Recipe recipe : matchingRecipes) {
                recipesFound.append(recipe.getName()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, "Recipes found:\n" + recipesFound.toString());
        } else {
            JOptionPane.showMessageDialog(frame, "No recipes found matching the keyword.");
        }
    }
}
