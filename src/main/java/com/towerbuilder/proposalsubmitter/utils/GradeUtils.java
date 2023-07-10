package com.towerbuilder.proposalsubmitter.utils;

import com.towerbuilder.proposalsubmitter.model.Grade;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GradeUtils {

    public static boolean isGradesValid(final Grade statusChangersGrade, final Grade submittersGrade) {
        return isFirstLevel(statusChangersGrade, submittersGrade) ||
                isSecondLevel(statusChangersGrade, submittersGrade) ||
                isThirdLevel(statusChangersGrade, submittersGrade);
    }

    private static boolean isFirstLevel(final Grade statusChangersGrade, final Grade submittersGrade) {
        if (submittersGrade == Grade.A || submittersGrade == Grade.B || submittersGrade == Grade.C) {
            return statusChangersGrade == Grade.D || statusChangersGrade == Grade.E || statusChangersGrade == Grade.F;
        }
        return false;
    }

    private static boolean isSecondLevel(final Grade statusChangersGrade, final Grade submittersGrade) {
        if (submittersGrade == Grade.D) {
            return statusChangersGrade == Grade.E || statusChangersGrade == Grade.F;
        }
        return false;
    }

    private static boolean isThirdLevel(final Grade statusChangersGrade, final Grade submittersGrade) {
        return submittersGrade == Grade.E && statusChangersGrade == Grade.F;
    }
}
