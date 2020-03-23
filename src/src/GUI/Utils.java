package GUI;

import java.awt.GridBagConstraints;
/**
 * Utils class for any GUI specific methods
 * @author Antoine Farley
 * @author Jesse Desmarais
 *
 */

public class Utils {

	/**
	 * Macro-type function to change gridBagConstraints, only contains parameters 
	 * @param gbc
	 * @param gridx
	 * @param gridy
	 * @param weightx
	 * @param weighty
	 * @param gridwidth
	 * @param ipady
	 */	
    public static void setGridBagConstraints(GridBagConstraints gbc,
            Object gridx, Object gridy, Object weightx, Object weighty,
            Object gridwidth, Object ipady
    ) {
        if (!gridx.equals(-1)){ gbc.gridx = (int)gridx; }
        if (!gridy.equals(-1)){ gbc.gridy = (int)gridy; }
        if (!weightx.equals(-1)){ gbc.weightx = (double)weightx; }
        if (!weighty.equals(-1)){ gbc.weighty = (double)weighty; }
        if (!gridwidth.equals(-1)){ gbc.gridwidth = (int)gridwidth; }
        if (!ipady.equals(-1)){ gbc.ipady = (int)ipady; }
    }
}