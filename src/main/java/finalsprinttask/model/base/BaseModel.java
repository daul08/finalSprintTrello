package finalsprinttask.model.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.java.LocalDateJavaType;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CREATED_AT")

    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;


    @PrePersist()
    public void setCreatedAt() {
        createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void setUpdatedAt() {
        updatedAt = LocalDateTime.now();
    }
}
