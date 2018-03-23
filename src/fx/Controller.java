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

    private int i = 0;
    private int k = 0;

    @FXML
    private Button btnFruits;

    @FXML
    private Button btnVegetables;

    @FXML
    private Label lblSelectCategory;

    @FXML
    private Label lblItemQuantity;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnPrev;

    @FXML
    private Label lblItemPrice;

    @FXML
    private Label lblItemName;

    @FXML
    private Button btnMainMenu;
    private Category category;

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
            i = 0;
            hideMainMenu();
            List<Item> fruits = selectByCategory(Category.FRUITS);
            fillLabels(fruits, i);
            btnNext.setOnAction(event1 -> {
                if (i < fruits.size() - 1) {
                    i++;
                    fillLabels(fruits, i);
                }
            });
            btnPrev.setOnAction(event1 -> {
                if (i > 0) {
                    i--;
                    fillLabels(fruits, i);
                }
            });

        });

        btnVegetables.setOnAction(event -> {
            k = 0;
            hideMainMenu();
            List<Item> vegetables = selectByCategory(Category.VEGETABLES);
            fillLabels(vegetables, k);
            btnNext.setOnAction(event1 -> {
                if (k < vegetables.size() - 1) {
                    k++;
                    fillLabels(vegetables, k);
                }
            });
            btnPrev.setOnAction(event1 -> {
                if (k > 0) {
                    k--;
                    fillLabels(vegetables, k);
                }
            });
        });
        btnMainMenu.setOnAction(event1 -> {
            showMainMenu();
        });


    }

    private List<Item> selectByCategory(Category category) {
        this.category = category;
        List<Item> selectItem = new ArrayList<>();
        items.forEach(item -> {
            if (item.getCategory() == category) {
                selectItem.add(item);
            }
        });
        return selectItem;
    }

    private void hideMainMenu() {
        btnFruits.setVisible(false);
        btnVegetables.setVisible(false);
        lblSelectCategory.setVisible(false);

        btnMainMenu.setVisible(true);
        btnPrev.setVisible(true);
        lblItemName.setVisible(true);
        lblItemQuantity.setVisible(true);
        lblItemPrice.setVisible(true);
        btnNext.setVisible(true);

    }
    private void showMainMenu() {
        btnFruits.setVisible(true);
        btnVegetables.setVisible(true);
        lblSelectCategory.setVisible(true);


        btnMainMenu.setVisible(false);
        btnPrev.setVisible(false);
        lblItemName.setVisible(false);
        lblItemQuantity.setVisible(false);
        lblItemPrice.setVisible(false);
        btnNext.setVisible(false);

    }


    private void fillLabels(List<Item> items, int currentPosition) {
        lblItemName.setText(items.get(currentPosition).getName());
        lblItemQuantity.setText(String.valueOf(items.get(currentPosition).getQuantity()) + " шт");
        lblItemPrice.setText(String.valueOf(items.get(currentPosition).getPrice()) + " грн");
    }
}
