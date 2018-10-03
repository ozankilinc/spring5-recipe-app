package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient,IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomCoverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomCoverter) {
        this.uomCoverter = uomCoverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ıngredient) {
        if (ıngredient == null){
            return null;
        }
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ıngredient.getId());

        if (ıngredient.getRecipe() != null){
            ingredientCommand.setRecipeId(ıngredient.getRecipe().getId());
        }
        ingredientCommand.setAmount(ıngredient.getAmount());
        ingredientCommand.setDescription(ıngredient.getDescription());
        ingredientCommand.setUom(uomCoverter.convert(ıngredient.getUom()));

        return ingredientCommand;
    }
}
