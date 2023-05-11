package edu.iest.registrodeusuario;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.widget.TextView;


//LA FUNCIÓN ENCARGADA DE DEFINIR LOS COLORES DEL GRADIENTE DE LOS TEXTOS
public class TextoGradiente {
    public static void GradienteAMR(TextView textView, String text) {
        int startColor = 0xFF2692FC; // Color de inicio azul
        int midColor = 0xFF8B4EFA; // Color de medio morado
        int endColor = 0xFFF307F7; // Color de fin rosa
        Shader textShader = new LinearGradient(0, 0, textView.getPaint().measureText(text), textView.getTextSize(),
                new int[]{startColor, midColor, endColor},
                new float[]{0, 0.5f, 1}, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
        textView.setText(text);
    }

    public static void GradienteMorado(TextView textView, String text) {
        int startColor = 0xFF6103FF; // Color de inicio
        int endColor = 0xFF9C02FC; // Color de fin
        Shader textShader = new LinearGradient(0, 0, textView.getPaint().measureText(text), textView.getTextSize(),
                new int[]{startColor, endColor},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
        textView.setText(text);
    }

    public static void GradienteRosa(TextView textView, String text) {
        int startColor = 0xFFFF01D6; // Color de inicio
        int endColor = 0xFFFF18A7; // Color de fin
        Shader textShader = new LinearGradient(0, 0, textView.getPaint().measureText(text), textView.getTextSize(),
                new int[]{startColor, endColor},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
        textView.setText(text);
    }

}
