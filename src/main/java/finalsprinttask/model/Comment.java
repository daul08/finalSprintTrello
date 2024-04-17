package finalsprinttask.model;

import finalsprinttask.model.base.BaseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COMMENTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseModel {

    @Column(name = "COMMENT")
    private String commnet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TASK_ID")
    private Task task;
}
