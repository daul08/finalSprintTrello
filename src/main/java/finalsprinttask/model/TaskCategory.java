package finalsprinttask.model;

import finalsprinttask.model.base.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TaskCategories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TaskCategory extends BaseModel {

    @Column(name = "NAME")
    private String name;
}
