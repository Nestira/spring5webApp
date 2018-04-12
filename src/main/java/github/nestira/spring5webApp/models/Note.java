package github.nestira.spring5webApp.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob // Large object blob
    private String recipeNote;



}
