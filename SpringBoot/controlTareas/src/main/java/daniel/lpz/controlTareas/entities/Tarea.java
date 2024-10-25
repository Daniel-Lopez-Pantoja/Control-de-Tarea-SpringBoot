package daniel.lpz.controlTareas.entities;

import lombok.*;

import java.util.Objects;

//@Getter @Setter @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode @ToString
@Data //Con Data traés todos los Getters y Setters, Equals, Constructor y el ToString.

public class Tarea {

    private Long id;
    private String nombre;
    private String materia;
    private String fecha;
    private Boolean isCompleted;

}
