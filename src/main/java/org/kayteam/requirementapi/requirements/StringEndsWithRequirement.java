package org.kayteam.requirementapi.requirements;

import org.bukkit.entity.Player;
import org.kayteam.requirementapi.Requirement;
import org.kayteam.requirementapi.util.PlaceholderUtil;

import java.util.LinkedHashMap;

public class StringEndsWithRequirement extends Requirement {

    private final String input , output;

    public StringEndsWithRequirement(String name , String input , String output , boolean positive ) {
        super( name , "string ends with" , positive );
        this.input = input;
        this.output = output;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    @Override
    public boolean verify( Player player ) {

        String realInput = input , realOutput = output;

        realInput = PlaceholderUtil.setPlaceholders( player , realInput);

        realOutput = PlaceholderUtil.setPlaceholders( player , realOutput);

        return isPositive() == ( realInput.endsWith( realOutput ) );

    }

    @Override
    public LinkedHashMap<String, Object> serialize() {

        LinkedHashMap<String, Object> result = super.serialize();

        if ( ! isPositive() ) result.put( "type" , "!string ends with" );

        result.put( "input" , input );

        result.put( "output" , output );

        return result;

    }

}