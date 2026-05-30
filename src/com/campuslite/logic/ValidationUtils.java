package com.campuslite.logic;

/**
 * Utilidades de validación.
 */
public class ValidationUtils {

    /**
     * Valida texto vacío.
     */
    public static boolean isEmpty(String text) {

        return text == null || text.trim().isEmpty();
    }

    /**
     * Valida número entero.
     */
    public static boolean isInteger(String text) {

        try {

            Integer.parseInt(text);

            return true;

        } catch (NumberFormatException e) {

            return false;
        }
    }

    /**
     * Valida número decimal.
     */
    public static boolean isDouble(String text) {

        try {

            Double.parseDouble(text);

            return true;

        } catch (NumberFormatException e) {

            return false;
        }
    }
    
    /**
     * Validar nombre y apellido que solo sean letras y no contengan numeros
     */
     public static boolean isOnlyLetters(String text) {

         return text != null &&
                text.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
     }

}