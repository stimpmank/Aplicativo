package org.profamilia.registro.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cadena.stringValidator")
public class StringValidator
        implements Validator {

    private static final String invalidChars = "/[`�~!#$%^&*()_��|+\\=?;:'\",����������<>\\{\\}\\[\\]\\\\\\/]/";

    @Override
    public void validate(FacesContext facesContext, UIComponent component, Object object)
            throws ValidatorException {

        for (int i = 0; i < invalidChars.length(); ++i) {
            char c = invalidChars.charAt(i);
            if (object.toString().indexOf(c) == -1) {
                continue;
            }
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, component.getAttributes().get("label") +": Error de validación: Ha ingresado un caracter invalido." + invalidChars, null);
            throw new ValidatorException(facesMessage);
        }
    }
}
