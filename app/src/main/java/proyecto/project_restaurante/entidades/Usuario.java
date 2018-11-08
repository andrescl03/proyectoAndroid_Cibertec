package proyecto.project_restaurante.entidades;

public class Usuario {

        private Integer idUsuario;
        private String nombres;
        private String apellidos;
        private String correo;
        private String clave;
        private int Dni;
        private int edad;
        private Boolean sexo;
        private String tokenUsuario;

    public Usuario(Integer idUsuario, String nombres, String apellidos, String correo, String clave, int dni, int edad, Boolean sexo, String tokenUsuario) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.clave = clave;
        Dni = dni;
        this.edad = edad;
        this.sexo = sexo;
        this.tokenUsuario = tokenUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    public String getTokenUsuario() {
        return tokenUsuario;
    }

    public void setTokenUsuario(String tokenUsuario) {
        this.tokenUsuario = tokenUsuario;
    }

    public int getDni() { return Dni; }

    public void setDni(int dni) {  Dni = dni; }


}
