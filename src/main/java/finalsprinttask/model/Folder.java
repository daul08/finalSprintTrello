package finalsprinttask.model;

import finalsprinttask.model.base.BaseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "FOLDERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Folder extends BaseModel {

@Column(name = "NAME")
private String name;

@ManyToMany(fetch = FetchType.LAZY)
private List<TaskCategory> categories;
}
