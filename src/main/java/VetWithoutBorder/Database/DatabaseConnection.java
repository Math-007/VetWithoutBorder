package VetWithoutBorder.Database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.File;


public class DatabaseConnection {

    public SessionFactory connect() {
        try {
            StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure(new File("src/main/resources/hibernate.cfg.xml")).build();
            Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            System.out.println("ERROR : ********************************************");
            System.out.println(e.getMessage());
            System.out.println("ERROR : ********************************************");
        }

        return null;
    }
}
