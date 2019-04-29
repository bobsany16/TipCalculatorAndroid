package com.example.tipcalculator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
/**
 * To run tip calculator
 * @Author: Bobby Nguyen
 * @Version: 4/28/2019
 */
public class MainActivity extends AppCompatActivity {
    private EditText percentEdit, roundToEdit, billAmountEdit, actualPercentEdit, tipOutEdit;
    private Button calButton;

    private TipModel calModel;
    private List<ModelObserver> observers = new ArrayList<>();

    /**
     * To initialize the tipModel, viewers
     */
    public void initialize() {
        calModel = new TipModel();

        tipRoundedViewer tipOutView = new tipRoundedViewer(tipOutEdit);
        effPercentViewer actualTipView = new effPercentViewer(actualPercentEdit);

        calModel.addObserver(tipOutView);
        calModel.addObserver(actualTipView);

    }

    /**
     * This method is run when the display is displayed and to initialize the UI Components
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmountEdit = findViewById(R.id.billAmountTxt);
        percentEdit = findViewById(R.id.percentTxt);
        roundToEdit = findViewById(R.id.roundToText);
        actualPercentEdit = findViewById(R.id.actualPercentTxt);
        tipOutEdit = findViewById(R.id.tipOutText);
        calButton = findViewById(R.id.calButton);
        initialize();
        /**
         * Decides what happens when the user click the calculate button
         */
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();

            }
        });

    }
    /**
     * When calculate button is clicked, it displays out to the text fields the tip
     * amount
     */
    public void calculate() {
        calModel.setTotalBill(Double.parseDouble(String.valueOf(billAmountEdit.getText())));
        calModel.setTipPercent(Double.parseDouble(String.valueOf(percentEdit.getText())));
        calModel.setTipQuantum(Double.parseDouble(String.valueOf(roundToEdit.getText())));

    }
}
