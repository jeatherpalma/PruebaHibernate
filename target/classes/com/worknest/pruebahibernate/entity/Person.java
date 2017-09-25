
package com.worknest.pruebahibernate.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


/*@NamedStoredProcedureQuery(
	name = "insert_jeather", 
	procedureName = "insert_jeather", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "fname"), 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "lname") 
		//@StoredProcedureParameter(mode = ParameterMode.OUT, type = Double.class, name = "sum")
	}
)*/

@NamedStoredProcedureQuery(
	name = "todos_jeather", 
	procedureName = "todos_jeather", 
	parameters = { 
		/*@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "id"), */
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "retorno")
	}
)
@Entity
@Table(name = "person")
public class Person implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "fname")
    private String fname;
    
    @Column(name = "lname")
    private String lname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Person() {
    }

    
    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

   
    
    
}
