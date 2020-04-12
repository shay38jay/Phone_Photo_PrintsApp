package net.androidbootcamp.phonephotoprintsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //Variables
    double nineTeenCents = 0.19;
    double fortyNineCents = 0.49;
    double seventyNineCents = 0.79;
    double printsEntered;
    double costNumberOfPrints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //To instantiate and reference the EditText class with the id name of txtPrints
        final EditText number = (EditText)findViewById(R.id.txtPrints);

        //To instantiate and reference the RadioButton class with the id name of radNineteen,
        //radFortynine and radSeventynine
        final RadioButton radNineteen = (RadioButton)findViewById(R.id.radNineteen);
        final RadioButton radFortynine = (RadioButton)findViewById(R.id.radFortynine);
        final RadioButton radSeventynine = (RadioButton)findViewById(R.id.radSeventynine);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button costPrints = (Button) findViewById(R.id.btnOrder);

        costPrints.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                printsEntered = Double.parseDouble(number.getText().toString());
                DecimalFormat penny = new DecimalFormat("0.00");
                if (radNineteen.isChecked()) {
                    if (printsEntered <= 50){
                        costNumberOfPrints = nineTeenCents * printsEntered;
                        result.setText("The order cost is $ " + (penny.format(costNumberOfPrints)));
                    } else {
                        Toast.makeText(MainActivity.this, "Do not enter more than 50 prints", Toast.LENGTH_LONG).show();
                    }
                }

                if (radFortynine.isChecked()) {
                    if (printsEntered <= 50) {
                        costNumberOfPrints = fortyNineCents * printsEntered;
                        result.setText("The order cost is $ " + (penny.format(costNumberOfPrints)));
                    } else {
                        Toast.makeText(MainActivity.this, "Do not enter more than 50 prints", Toast.LENGTH_LONG).show();
                    }
                }

                if (radSeventynine.isChecked()) {
                    if (printsEntered <= 50) {
                        costNumberOfPrints = seventyNineCents * printsEntered;
                        result.setText("The order cost is $ " + (penny.format(costNumberOfPrints)));

                    } else {
                        Toast.makeText(MainActivity.this, "Do not enter more than 50 prints", Toast.LENGTH_LONG).show();
                    }
                }
            }

        });
    }
}


