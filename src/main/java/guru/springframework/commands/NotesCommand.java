package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jt on 6/21/17.
 * This class defines the bean that stores the Notes POJO in readiness for the web form
 * On POST, the command is converted back to a POJO
 * See /converters for details
 */
@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {
    private String id;
    private String recipeNotes;

}
