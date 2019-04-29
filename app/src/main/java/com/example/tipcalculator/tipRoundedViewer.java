package com.example.tipcalculator;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This class acts as a viewer for rounded tip amount for the Controller
 * 
 * @author Bobby Nguyen
 * @version April 12th 2019
 *
 */
public class tipRoundedViewer implements ModelObserver {

	private EditText outputField;

	/**
	 * Initializes outputField
	 * 
	 * @param outPutTipTextField JTextField for output of rounded tip amount
	 */
	public tipRoundedViewer(EditText outPutTipTextField) {
		if (outPutTipTextField == null) {
			System.out.println("Bad TextField passed to tipRoundedViewer constructor");
		}
		outputField = outPutTipTextField;
	}

	/**
	 * Method to update the rounded tip textfield once there are changes in the
	 * model
	 * 
	 * @param a a TipModel
	 */
	@Override
	public void update(TipModel a) {
		double b = a.getRoundedTip();
		outputField.setText("$" + a.formatNumber(b, 2));

	}

}
