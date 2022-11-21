package com.politecnicomalaga.sp2.managers;

public class LanguageManager {

    private String[] enUso;
    private final String[] aSPANISH = {"Seleccionar idioma", "Español", "Inglés", "Volver", "Guardar Configuración", "Empezar", "Creditos", "Ajustes"};
    private final String[] aENGLISH = {"Choose language", "Spanish", "English", "Back", "Save Changes", "Start", "Credits", "Settings"};

    private static LanguageManager singleton;
    public static final int SELECT_LANG = 0;
    public static final int SPANISH_BUTTON = 1;
    public static final int ENGLISH_BUTTON = 2;
    public static final int GO_BACK = 3;
    public static final int SAVE_CONFIG = 4;
    public static final int START = 5;
    public static final int CREDITS = 6;
    public static final int SETTINGS = 7;

    public enum lang {SPANISH, ENGLISH}
    private lang myLangs;

    public LanguageManager() {
        this.enUso = aSPANISH;
    }

    public static LanguageManager getSingleton() {
        if (singleton == null) {
            singleton = new LanguageManager();
        }
        return singleton;
    }

    public String getString(int n) {
        return enUso[n];
    }

    public void setString() {
        switch (myLangs) {
            case SPANISH:
                enUso = aSPANISH;
            break;
            case ENGLISH:
                enUso = aENGLISH;
            break;
        }
    }
}