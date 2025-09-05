package co.com.pragma.r2dbc.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("states")
public class StatesEntity {

    private @Id Integer id;
    private String name;
    private String description;

}
