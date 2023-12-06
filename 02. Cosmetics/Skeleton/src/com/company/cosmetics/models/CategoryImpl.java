package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;


import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 15;
    private static final String ERROR_NAME_MESSAGE =
            String.format("The length of the name needs to be between %d and %d characters", MIN_NAME_LENGTH, MAX_NAME_LENGTH);
    
    private String name;
    private List<Product> products;
    
    public CategoryImpl(String name) {
        setName(name);
        products=new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length()< MIN_NAME_LENGTH ||name.length()> MAX_NAME_LENGTH){
            throw new IllegalArgumentException(ERROR_NAME_MESSAGE);
        }
        this.name = name;
    }

    public List<Product> getProducts() {
        //todo why are we returning a copy? Replace this comment with explanation!
        return new ArrayList<>(products);
//        for variable reasons we want to return an instance of a collection(in this case ArrayList products):
//        for one if you return the actual object, you can modify the actual object(and you won't want that),
//        because of how the reference is stored in the memory.
//        If you return a reference of the object, the
//        outside code can obtain this reference and makes change to the internal object.
//        Workaround for this case is that, instead of returning the reference directly in the getter, we should return a copy of the object,
//        so the outside code can obtain only a copy, not the internal object.
//        So the rule of thumb is: do not return reference of the original object in getter method.
//        Instead, it should return a copy of the original object.
//        More detailed information can be found for instance in this article:
//        https://www.codejava.net/coding/java-getter-and-setter-tutorial-from-basics-to-best-practices
//        particularly "Mistake #3" in it.


    }
    
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        products.add(product);
    }
    public void removeProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        products.remove(product);
    }
    public String print() {
        StringBuilder result = new StringBuilder();
        if (products.size() == 0) {
            return String.format("#Category: %s\n" +
                    " #No product in this category", name);
        }
        else {
            for (Product product :products) {
                result.append(product.print());
            }
     }
        return result.toString();
    }
}
