package finalsprinttask.model;

import finalsprinttask.model.base.BaseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TASKS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task extends BaseModel {
    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description; // TEXT

    @Column(name = "STATUS")
    private Integer status; // 0 - todo, 1 - intest, 2 - done, 3 - failed

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOLDER_ID")
    private Folder folder; // Many To One
}
