package proyecto.project_restaurante.entidades;

import java.io.Serializable;

public class encuesta  implements Serializable {

    private Integer idEncuesta;
    private int ePregunta1,ePregunta2,ePregunta3,ePregunta4,ePregunta5,ePregunta6,ePregunta7,ePregunta8,ePregunta9,ePregunta10;

    public encuesta(Integer idEncuesta, int ePregunta1, int ePregunta2, int ePregunta3, int ePregunta4, int ePregunta5, int ePregunta6, int ePregunta7, int ePregunta8, int ePregunta9, int ePregunta10) {
        this.idEncuesta = idEncuesta;
        this.ePregunta1 = ePregunta1;
        this.ePregunta2 = ePregunta2;
        this.ePregunta3 = ePregunta3;
        this.ePregunta4 = ePregunta4;
        this.ePregunta5 = ePregunta5;
        this.ePregunta6 = ePregunta6;
        this.ePregunta7 = ePregunta7;
        this.ePregunta8 = ePregunta8;
        this.ePregunta9 = ePregunta9;
        this.ePregunta10 = ePregunta10;
    }
    public Integer getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public int getePregunta1() {
        return ePregunta1;
    }

    public void setePregunta1(int ePregunta1) {
        this.ePregunta1 = ePregunta1;
    }

    public int getePregunta2() {
        return ePregunta2;
    }

    public void setePregunta2(int ePregunta2) {
        this.ePregunta2 = ePregunta2;
    }

    public int getePregunta3() {
        return ePregunta3;
    }

    public void setePregunta3(int ePregunta3) {
        this.ePregunta3 = ePregunta3;
    }

    public int getePregunta4() {
        return ePregunta4;
    }

    public void setePregunta4(int ePregunta4) {
        this.ePregunta4 = ePregunta4;
    }

    public int getePregunta5() {
        return ePregunta5;
    }

    public void setePregunta5(int ePregunta5) {
        this.ePregunta5 = ePregunta5;
    }

    public int getePregunta6() {
        return ePregunta6;
    }

    public void setePregunta6(int ePregunta6) {
        this.ePregunta6 = ePregunta6;
    }

    public int getePregunta7() {
        return ePregunta7;
    }

    public void setePregunta7(int ePregunta7) {
        this.ePregunta7 = ePregunta7;
    }

    public int getePregunta8() {
        return ePregunta8;
    }

    public void setePregunta8(int ePregunta8) {
        this.ePregunta8 = ePregunta8;
    }

    public int getePregunta9() {
        return ePregunta9;
    }

    public void setePregunta9(int ePregunta9) {
        this.ePregunta9 = ePregunta9;
    }

    public int getePregunta10() {
        return ePregunta10;
    }

    public void setePregunta10(int ePregunta10) {
        this.ePregunta10 = ePregunta10;
    }
}