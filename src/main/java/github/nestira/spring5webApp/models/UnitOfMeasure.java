package github.nestira.spring5webApp.models;

import javax.persistence.*;

@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    // Unidirectional relationship does not include this; this is for inverse mapping as bidirectional.
//    @OneToOne
//    private Ingredient ingredient;
}
