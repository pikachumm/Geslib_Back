package com.geslib.back.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/** 
 *Modelo de Rol guarda la informacion sobre los roles
 *que puede tomar cada usuario consta de constructores
 *por defecto sin paramentros con todos los parametros y con
 *todos los parametros excepto el id
 *getters y setters hascode e equals
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@Entity
@Table(name="Roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_rol;
    private String nombre;

    public Rol() {
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id_rol;
    }

    public void setId(int id) {
        this.id_rol = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }
    }
