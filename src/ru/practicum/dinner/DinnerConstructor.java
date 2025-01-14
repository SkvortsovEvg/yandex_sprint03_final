package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DinnerConstructor {
    Map<String, ArrayList<String>> businessLunch = new HashMap<>();
    Random random = new Random();

    void addNewDish(String type, String name) {
        String addDishSuccessfully = String.format("Блюдо \"%s\" успешно добавлено в тип \"%s\"", name, type);
        String notAddDish = String.format("Блюдо \"%s\" уже есть в меню", name);

        if (isCheckDishInLunch(name)) {
            System.out.println(notAddDish);
        } else if (isCheckType(type)) {
            businessLunch.get(type).add(name);
            System.out.println(addDishSuccessfully);
        } else {
            addNewValueInLunch(type, name);
            System.out.println(addDishSuccessfully);
        }
    }

    void generateCombo(int number, ArrayList<String> types) {
        for (int i = 0; i < number; i++) {
            String combo = String.format("Комбо %d:", (i+1));
            System.out.println(combo);
            ArrayList<String> newCombo = new ArrayList<>();
            for (String type : types) {
                int dishNumber = random.nextInt(businessLunch.get(type).size());
                String dish = businessLunch.get(type).get(dishNumber);
                newCombo.add(dish);
            }
            System.out.println(String.join(", ", newCombo).concat("\n"));
        }
    }

    private boolean isCheckDishInLunch(String name) {
        for (ArrayList<String> dishes : businessLunch.values()) {
            if (dishes.contains(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCheckType(String type) {
        return businessLunch.containsKey(type);
    }

    private void addNewValueInLunch(String type, String name) {
        ArrayList<String> dishForType = new ArrayList<>();
        dishForType.add(name);
        businessLunch.put(type, dishForType);
    }
}
