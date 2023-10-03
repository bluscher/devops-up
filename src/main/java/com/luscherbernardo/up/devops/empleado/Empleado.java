package com.luscherbernardo.up.devops.empleado;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "empleados")
public class Empleado{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long emp_id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "puesto", nullable = false)
    private String puesto;

    public Empleado(){
    }

    public Empleado (String nombre,String email, String puesto){
        this.nombre = nombre;
        this.email = email;
        this.puesto = puesto;
    }
    //getters and setters
    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
