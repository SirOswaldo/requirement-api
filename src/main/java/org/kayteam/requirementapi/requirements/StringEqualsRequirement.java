package org.kayteam.requirementapi.requirements;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.kayteam.requirementapi.Requirement;
import org.kayteam.requirementapi.util.PlaceholderUtil;

import java.util.LinkedHashMap;

public class StringEqualsRequirement extends Requirement {

    private final String input , output;

    public StringEqualsRequirement( String name , String input , String output , boolean positive ) {
        super( name , "string equals" , positive );
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

        realInput = PlaceholderUtil.setPlaceholders( player , realInput );

        realOutput = PlaceholderUtil.setPlaceholders( player , realOutput );

        return isPositive() == ( realInput.equals( realOutput ) );

    }

    @Override
    public LinkedHashMap<String, Object> serialize() {

        LinkedHashMap< String , Object > result = super.serialize();

        if ( ! isPositive() ) result.put( "type" , "!string equals" );

        result.put( "input" , input);

        result.put( "output" , output);

        return result;

    }

}