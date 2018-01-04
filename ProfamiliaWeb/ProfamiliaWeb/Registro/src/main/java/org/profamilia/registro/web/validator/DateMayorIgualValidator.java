package org.profamilia.registro.web.validator;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dateMayorIgualValidator")
public class DateMayorIgualValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent component, 
                         Object object) throws ValidatorException {

        if (object instanceof java.util.Date) {

            Calendar fechaActual = GregorianCalendar.getInstance();
            fechaActual.set(Calendar.HOUR_OF_DAY, 0);
            fechaActual.set(Calendar.MINUTE, 0);
            fechaActual.set(Calendar.SECOND, 0);
            fechaActual.set(Calendar.MILLISECOND, 0);
            
            Date fechaMinima = null; 
                   Calendar fechaMenor = Calendar.getInstance(); 
                   fechaMenor.set(Calendar.YEAR,1900);
                   fechaMenor.set(Calendar.MONTH,01);
                   fechaMenor.set(Calendar.DAY_OF_MONTH,01);
                   fechaMinima = fechaMenor.getTime();

            if (((Date)object).compareTo(fechaActual.getTime()) < 0) {
                FacesMessage facesMessage = 
                    new FacesMessage("La fecha debe ser mayor o igual que la fecha actual");
                throw new ValidatorException(facesMessage);
            }else if(fechaMinima.after((Date)object)){
                FacesMessage facesMessage = 
                    new FacesMessage("La fecha debe ser mayor que el a�o 1900");
                throw new ValidatorException(facesMessage);
            }

        }

    }
}
