package mx.ipn.escom.wad.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import mx.ipn.escom.wad.bs.LoginDuplicatedException;
import mx.ipn.escom.wad.bs.UserNotFoundException;
import mx.ipn.escom.wad.bs.UsersBs;
import mx.ipn.escom.wad.entidad.User;

@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "amazon" }) })
public class UserAct extends ActionSupport implements ModelDriven<User> {

	@Autowired
	private UsersBs userBs;

	private List<User> listUsers;

	private Integer idSel;

	private User model;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String index() {
		return "index";
	}

	public String show() {
		return "show";
	}

	public String edit() {
		return "edit";
	}

	public void validateUpdate() {
	}

	public String update() {
		System.out.println("--> update");
		return SUCCESS;
	}



	public String editNew() {
		return "editNew";
	}

	public void validateCreate() {
		System.out.println("--> validateCreate");
		try {
			User user = userBs.findByLogin(model.getLogin());
			if (!user.getPassword().equals(model.getPassword())) {
				throw new UserNotFoundException();
			}
		} catch (UserNotFoundException e) {
			addActionError("Wrong user or password.");
		} finally {
			System.out.println("Todo fine");
		}
	}

	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "model.login", type = ValidatorType.FIELD, key = "USER.MSG1"),
			@RequiredStringValidator(fieldName = "model.password", type = ValidatorType.FIELD, key = "USER.MSG2"),
			@RequiredStringValidator(fieldName = "model.name", type = ValidatorType.FIELD, key = "USER.MSG3"),
			@RequiredStringValidator(fieldName = "model.lastName", type = ValidatorType.FIELD, key = "USER.MSG4"),
			@RequiredStringValidator(fieldName = "model.secondLastName", type = ValidatorType.FIELD, key = "USER.MSG5"),
			@RequiredStringValidator(fieldName = "model.curp", type = ValidatorType.FIELD, key = "USER.MSG6"),
			@RequiredStringValidator(fieldName = "model.birthDay", type = ValidatorType.FIELD, key = "USER.MSG7") }, stringLengthFields = {
					@StringLengthFieldValidator(fieldName = "model.password", type = ValidatorType.FIELD, key = "MS8", minLength = "5", maxLength = "10") }, emails = {
							@EmailValidator(fieldName = "model.login", type = ValidatorType.FIELD, key = "USER.MSG9")
					})
	public String create() {
		
		return SUCCESS;
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public Integer getIdSel() {
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		this.idSel = idSel;
		if (idSel != null) {
			try {
				model = userBs.findById(idSel);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@VisitorFieldValidator
	public User getModel() {
		return model;
	}

	public void setModel(User model) {
		this.model = model;
	}
}
