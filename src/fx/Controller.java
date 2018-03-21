package fx;

import entities.Category;
import entities.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<Item> items = new ArrayList<>();

    @FXML
    private Button btnFruits;

    @FXML
    private Button btnVegetables;

    @FXML
    private Label lblSelectCategory;

    @FXML
    void initialize() {
        Item item1 = new Item("банан", 10, 10, Category.FRUITS);
        items.add(item1);
        items.add(new Item("апельсин", 17, 10, Category.FRUITS));
        items.add(new Item("яблуко", 7, 16, Category.FRUITS));
        items.add(new Item("помідор", 14, 19, Category.VEGETABLES));
        items.add(new Item("огірок", 11, 14, Category.VEGETABLES));
        items.add(new Item("капуста", 20, 29, Category.VEGETABLES));
        items.add(new Item("цибуля", 9, 15, Category.VEGETABLES));


        btnFruits.setOnAction(event -> {
            btnFruits.setVisible(false);
            btnVegetables.setVisible(false);
            lblSelectCategory.setVisible(false);
        });

        btnVegetables.setOnAction(event -> {
            btnFruits.setVisible(false);
            btnVegetables.setVisible(false);
            lblSelectCategory.setVisible(false);
        });

    }

    private List<Item> selectByCategory(Category category){
        List<Item> selectedItems = new ArrayList<>();
        items.forEach(item -> {
            if (category == item.getCategory()){
                selectedItems.add(item);
            }
        });
        return selectedItems;
    }
}
