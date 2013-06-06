package org.athene.util;

/**
 * Utility class for string analysis and manipulation.
 * @author Matt Yackel
 *
 */
public class StringUtils {
	
	/**
	 * Checks whether a string contains only numeric values.
	 * @param s The string to check.
	 * @return <code>True</code> if the string contains only numeric values, <code>False</code> if not.
	 */
	public static boolean isNumber(String s) {
		for(char c : s.toCharArray()) {
			if(!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

}
