package org.kayteam.requirementapi.expansions;

import org.kayteam.requirementapi.Requirement;
import org.kayteam.requirementapi.RequirementExpansion;
import org.kayteam.requirementapi.requirements.RegexMatchesRequirement;

import java.util.Map;

public class RegexMatchesExpansion extends RequirementExpansion {

    public RegexMatchesExpansion() {
        super( "regex matches" );
    }

    @Override
    public Requirement generateRequirement( String name , Map<String, Object> format ) {

        Requirement requirement = null;

        String type = ( String ) format.get( "type" );

        if ( format.containsKey( "input" ) && format.containsKey( "regex" ) ) {

            String input = ( String ) format.get( "input" ) , regex = ( String ) format.get( "regex" );

            requirement = new RegexMatchesRequirement( name , input , regex , !type.startsWith( "!" ) );

        }

        return requirement;

    }

}