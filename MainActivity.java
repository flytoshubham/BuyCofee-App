/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
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

import static com.example.android.justjava.R.id;
import static com.example.android.justjava.R.layout;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
    }


    int q = 1;
    int s=0;
    int c;

    public void increment(View view) {
        q++;
        display(q);

    }

    public void decrement(View view) {
        if (q != 1)
            q--;
        display(q);
    }
    public void selectup(View view) {
        if (s != 4) {
            s++;
            TextView select1TextView = (TextView) findViewById(R.id.select1_text_view);
            TextView costTextView=(TextView) findViewById(R.id.cost_text_view);
            if(s==1) {
                select1TextView.setText("COLD COFFEE");
                c=75;
                costTextView.setText(""+c);
            }
            if(s==2) {
                select1TextView.setText("HOT COFFEE");
                c=70;
                costTextView.setText(""+c);

            }
            if(s==3) {
                select1TextView.setText("HARD COFFEE");
                c = 100;
                costTextView.setText("" + c);
            }
            if(s==4) {
                select1TextView.setText("SOFT COFFEE");
                c = 30;
                costTextView.setText("" + c);
            }
        }
    }
    public void selectdown(View view){
        if(s>1)
            s--;
        TextView selectTextView=(TextView) findViewById(id.select1_text_view);
        TextView cost1TextView=(TextView) findViewById(id.cost_text_view);

        if(s==1) {
            selectTextView.setText("COLD COFFEE");
            c=75;
            cost1TextView.setText(""+c);
        }
        if(s==2) {
            selectTextView.setText("HOT COFFEE");
            c=70;
            cost1TextView.setText(""+c);

        }
        if(s==3) {
            selectTextView.setText("HARD COFFEE");
            c = 100;
            cost1TextView.setText("" + c);
        }
        if(s==4) {
            selectTextView.setText("SOFT COFFEE");
            c = 30;
            cost1TextView.setText("" + c);
        }


    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedcheckbox=(CheckBox) findViewById(id.whipped_cream);
        CheckBox chocolatecheckbox=(CheckBox) findViewById(id.chocolate_view);
        boolean choc=chocolatecheckbox.isChecked();

        boolean whip=whippedcheckbox.isChecked();


        EditText name=(EditText)findViewById(id.name_field);
        String value=name.getText().toString();
        EditText email=(EditText)findViewById(id.email_field);
        String []mail=new String[1];
         mail[0]=email.getText().toString();
int extra=0;

        if(choc==true)
        {
          extra=extra+10;
        }
        if(whip==true)
        {
            extra=extra+10;
        }
            String Message =value+"\n"+ "whipped cream "+whip + "\n" + "chocolate "+choc  +"\n" +"Order costs Rs " + (q * (c+extra)) + "\n" + "Thankyou!";


            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT,"Just Java Order for"+value);
        intent.putExtra(Intent.EXTRA_TEXT,Message);
        intent.putExtra(Intent.EXTRA_EMAIL,mail);
        if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }


    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */

    private void displayMessage(String message) {

        TextView priceTextView = (TextView) findViewById(id.price_text_view);

        priceTextView.setText(message);

    }
}
