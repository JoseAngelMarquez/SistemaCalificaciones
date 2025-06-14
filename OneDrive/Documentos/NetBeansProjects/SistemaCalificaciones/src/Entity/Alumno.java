package Entity;

public class Alumno {
   private int matricula_alumno;
   private String nombre;
   private String apellido;
   private int id_materia;
   private Double parcial1;
   private Double parcial2;
   private Double parcial3;

    public Alumno() {
        
    }

    public int getMatricula_alumno() {
        return matricula_alumno;
    }

    public void setMatricula_alumno(int matricula_alumno) {
        this.matricula_alumno = matricula_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public Double getParcial1() {
        return parcial1;
    }

    public void setParcial1(Double parcial1) {
        this.parcial1 = parcial1;
    }

    public Double getParcial2() {
        return parcial2;
    }

    public void setParcial2(Double parcial2) {
        this.parcial2 = parcial2;
    }

    public Double getParcial3() {
        return parcial3;
    }

    public void setParcial3(Double parcial3) {
        this.parcial3 = parcial3;
    }
   
   
   
}
