package edu.iest.registrodeusuario;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.widget.TextView;


//LA FUNCIÓN ENCARGADA DE DEFINIR LOS COLORES DEL GRADIENTE DE LOS TEXTOS
public class TextoGradiente {
    public static void setGradientText(TextView textView, String text) {
        int startColor = 0xFF2692FC; // Color de inicio azul
        int midColor = 0xFF8B4EFA; // Color de medio morado
        int endColor = 0xFFF307F7; // Color de fin rosa
        Shader textShader = new LinearGradient(0, 0, textView.getPaint().measureText(text), textView.getTextSize(),
                new int[]{startColor, midColor, endColor},
                new float[]{0, 0.5f, 1}, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
        textView.setText(text);
    }
}
