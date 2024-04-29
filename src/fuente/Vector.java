/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fuente;

/**
 *
 * @author Alumno-ETI
 */
public class Vector {
    // Atributos
    private float valor_x;
    private float valor_y;
    
    // Contructor sin parámetros
    public Vector() {
    }
    
    public Vector(float valor_x, float valor_y){
        this.valor_x = valor_x;
        this.valor_y = valor_y;
        
    }

    public float getValor_x() {
        return this.valor_x;
    }

    public void setValor_x(float valor_x) {
        this.valor_x = valor_x;
    }

    public float getValor_y() {
        return this.valor_y;
    }

    public void setValor_y(float valor_y) {
        this.valor_y = valor_y;
    }
    
    public String MostrarVector() {
        return this.valor_x + "i + " + this.valor_y + "j";
    }
    
    public float CalucularModulo() {
        float s = this.valor_x * this.valor_x + this.valor_y * this.valor_y;
        
        float r = (float) Math.sqrt(s);
        
        return r;
    }
    
    public float CalcularAngulo() {
        float c = this.valor_y / this.valor_x;
        float ang_r = (float)Math.atan(c);
        float ang_c = (float)Math.toDegrees(ang_r);
        
        if (ang_c < 0) ang_c = 180 - Math.abs(ang_c);
        
        return ang_c;
    }
    
    
    
}
