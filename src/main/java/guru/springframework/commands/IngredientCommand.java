package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by jt on 6/21/17.
 * This class defines the bean that stores the Ingredient POJO in readiness for the web form
 * On POST, the command is converted back to a POJO
 * See /converters for details
 */
@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
    private String id;
    private String recipeId;

    @NotBlank
    private String description;

    @Min(1)
    @NotNull
    private BigDecimal amount;

    @NotNull
    private UnitOfMeasureCommand uom;
}
