package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "phone_number")
	    private String phoneNumber;


    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

  
    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
