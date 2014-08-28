package validators;

import beans.UserBeanLocal;
import model.User;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.List;

/**
 * Created by Valerie on 26.08.2014.
 */
@FacesValidator("loginValidator")
public class LoginValidator implements Validator {
    @EJB
    private UserBeanLocal userBeanLocal;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        List<User> userList;
        String login = o.toString();
        if (login.length()>20)
        {
            throw new ValidatorException(new FacesMessage(
                    "Длина логина должна быть не более 20 символов"));
        }

        userList = userBeanLocal.findUserByUsername(login);

        if (userList.size()!=0) {
            throw new ValidatorException(new FacesMessage(
                    "Имя уже занято"));
        }
    }
}
