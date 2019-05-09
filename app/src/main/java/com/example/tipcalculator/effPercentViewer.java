package com.example.tipcalculator;

import android.widget.EditText;
import android.widget.TextView;
/**
 * This class acts as a viewer for Effective Percentage Amount for the
 * Controller
 * 
 * @author Bobby Nguyen
 * @version April 28th 2019
 */
public class effPercentViewer implements ModelObserver {
	private EditText effPercentOutField;

	/**
	 * Initializes effPercentOutField
	 * 
	 * @param effPercentTextField JTextField for output of effective percentage
	 *                            amount
	 */
	public effPercentViewer(EditText effPercentTextField) {
		effPercentOutField = effPercentTextField;
	}

	/**
	 * Method to update the textfield once there are changes in the model
	 * 
	 * @param h a tipmodel
	 */
	@Override
	public void update(TipModel h) {
		double c = h.getEffectiveTipPercentage();
		effPercentOutField.setText(h.formatNumber(c, 1) + "%"
				+ "");

	}

}
