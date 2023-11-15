package com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.utility.HibernateUtilities;

public class AppMain {

    public static void main(String[] args) {
        try {
            SessionFactory factory = HibernateUtilities.getSessionFactory();

            // Add contacts to the table
            Contact contact1 = new Contact();
            contact1.setName("Moni");
            contact1.setPhoneNumber("1234567890");

            Contact contact2 = new Contact();
            contact2.setName("Loki");
            contact2.setPhoneNumber("9876543210");
            
            Contact contact3 = new Contact();
            contact3.setName("Kannu");
            contact3.setPhoneNumber("7553466754");


            // Save contacts to the database
            try (Session session = factory.openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(contact1);
                session.save(contact2);
                session.save(contact3);
                transaction.commit();
            }

            // Retrieve and display all contacts
            try (Session session = factory.openSession()) {
                Transaction transaction = session.beginTransaction();

                // Display the contacts before deleting
                System.out.println("Contacts before delete:");
                displayContacts(session);

                // Delete the third contact
                Contact contactToDelete = session.get(Contact.class, contact3.getId());
                session.delete(contactToDelete);

                transaction.commit();
            }

            // Retrieve and display all contacts after delete
            try (Session session = factory.openSession()) {
                Transaction transaction = session.beginTransaction();

                // Display the contacts after deleting
                System.out.println("Contacts after delete:");
                displayContacts(session);

                transaction.commit();
            }

            factory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayContacts(Session session) {
        Query<Contact> query = session.createQuery("FROM Contact", Contact.class);
        query.getResultList().forEach(System.out::println);
    }
}
