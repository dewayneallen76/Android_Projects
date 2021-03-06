/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */
package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Gets the name entered in the edit text view
        EditText nameField = (EditText)findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        //Figures out if the user wants whipped cream topping
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

        //Figures out if the user wants chocolate topping
        CheckBox chocolateToppingCheckbox = (CheckBox) findViewById(R.id.chocolate_topping_checkbox);
        boolean hasChocolateTopping = chocolateToppingCheckbox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolateTopping);
        String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolateTopping);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Calculates the price of the order.
     *
     * @param hasWhippedCream is whether the user has selected whipped cream checkbox
     * @param hasChocolateTopping is whether the user has selected chocolate topping checkbox
     * @return total price
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolateTopping) {
        int basePrice = 5;
        // Add $1 if the user wants whipped cream
        if(hasWhippedCream == true) {
            basePrice = basePrice + 1;
        }
        // Add $2 if the user wants chocolate topping
        if (hasChocolateTopping == true ) {
            basePrice = basePrice + 2;
        }
        //Calculate the total price by multiplying the basePrice with quantity
        return quantity * basePrice;
    }

    /**
     * Create summary of the order
     *
     * @param name of the customer
     * @param price of the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolateTopping is whether or not the user wants chocolate topping
     * @return text summary
     */

    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolateTopping) {
        String priceMessage = "Name: " + name;
        //Will display message if whipped cream has been added
        if(addWhippedCream == true) {
            priceMessage += "\nAdd whipped cream $1.00";
        }
        //Will display message if chocolate topping has been added
        if(addChocolateTopping == true) {
            priceMessage += "\nAdd chocolate topping $2.00";
        }
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal $" + price;
        priceMessage += "\nThank You!";
        return priceMessage;
    }

    /**
     * This method is called when the + button is clicked.
     */

    public void increment(View view) {
        if (quantity == 100) {
            //Show an error message as a toast
            Toast.makeText(this, "You cannot order more than 100 coffees", Toast.LENGTH_SHORT).show();
            //Exit method early because there is nothing left to do
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            //Show an error message as a toast
            Toast.makeText(this, "You cannot order less than 1 coffee", Toast.LENGTH_SHORT).show();
            //Exit method early because there is nothing left to do
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


}