package br.com.t2_fat.techstore.repository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@SpringBootApplication
@Entity
@Table(name = "clientes")

public class clientes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public clientes(String email, Long id, String name) {
        this.email = email;
        this.id = id;
        this.name = name;
    }
}
