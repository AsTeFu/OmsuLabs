package omsu.astefu.labs.tasks;

import javax.xml.bind.ValidationException;

@FunctionalInterface
public interface ValidatorLine {
    void validation(String s1, String s2) throws ValidationException;
}
