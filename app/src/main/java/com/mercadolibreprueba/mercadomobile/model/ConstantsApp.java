package com.mercadolibreprueba.mercadomobile.model;

/**
 * **************************************************************************
 * NAME: ConstantesApp.java
 * DESCRIPTION:  guardar las constantes de la aplicacion.
 * UPDATES:
 * VERSION      DATE       AUTOR      REQUIREMENT              UPDATE DESCRIPTION
 * -------  ------------  ----------  ---------------  -------------------------------------------------
 * 1.0       21/08/2021   jquiroga      creation                    creation
 * ***************************************************************************
 */

public class ConstantsApp {
    private ConstantsApp(){
        throw new IllegalAccessError("ConstantsApp class");
    }

    private static final String URL = "https://api.mercadolibre.com/sites/MCO/";
    private static final String CATEGORY_LIST_LIMIT ="10";
    private static final String CATEGORY_COMPUTACION_CODE = "MCO1648";
    private static final String CATEGORY_CELULARES_CODE= "MCO1051";
    private static final String CATEGORY_DEPORTES_CODE="MCO1276";

    public static final String LOG_MERCADO_MOBILE = "LOG_MERCADO_MOBILE";
    public static final String SPACE =" ";

    public static String getURL() {
        return URL;
    }

    public static String getCategoryListLimit() {
        return CATEGORY_LIST_LIMIT;
    }

    public static String getCategoryComputacionCode() {
        return CATEGORY_COMPUTACION_CODE;
    }

    public static String getCategoryCelularesCode() {
        return CATEGORY_CELULARES_CODE;
    }

    public static String getCategoryDeportesCode() {
        return CATEGORY_DEPORTES_CODE;
    }
}
