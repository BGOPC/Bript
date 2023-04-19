package src.mainClasses.utilities.Errors;

import src.mainClasses.utilities.Error;
import src.mainClasses.utilities.position;

public class IllegalCharError extends Error {
    public IllegalCharError(position pos_start, position pos_end,String det) {
        super(pos_start,pos_end,"IllegalCharError: ", det);
    }
}
