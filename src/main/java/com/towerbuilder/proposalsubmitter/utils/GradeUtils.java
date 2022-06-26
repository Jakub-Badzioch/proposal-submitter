package com.towerbuilder.proposalsubmitter.utils;

import com.towerbuilder.proposalsubmitter.model.Grade;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GradeUtils {

    public static boolean isGradesValid(final Grade acceptorsGrade, final Grade submittersGrade) {
        return isFirstLevel(acceptorsGrade, submittersGrade) ||
                isSecondLevel(acceptorsGrade, submittersGrade) ||
                isThirdLevel(acceptorsGrade, submittersGrade);
    }

    private static boolean isFirstLevel(final Grade acceptorsGrade, final Grade submittersGrade) {
        if (submittersGrade == Grade.A || submittersGrade == Grade.B || submittersGrade == Grade.C) {
            return acceptorsGrade == Grade.D || acceptorsGrade == Grade.E || acceptorsGrade == Grade.F;
        }
        return false;
    }

    private static boolean isSecondLevel(final Grade acceptorsGrade, final Grade submittersGrade) {
        if (submittersGrade == Grade.D) {
            return acceptorsGrade == Grade.E || acceptorsGrade == Grade.F;
        }
        return false;
    }

    private static boolean isThirdLevel(final Grade acceptorsGrade, final Grade submittersGrade) {
        return submittersGrade == Grade.E && acceptorsGrade == Grade.F;
    }
}
