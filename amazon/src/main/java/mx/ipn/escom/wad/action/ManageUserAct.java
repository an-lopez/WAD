package mx.ipn.escom.wad.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import mx.ipn.escom.wad.bs.LoginDuplicatedException;
import mx.ipn.escom.wad.bs.UserNotFoundException;
import mx.ipn.escom.wad.bs.UsersBs;
import mx.ipn.escom.wad.entidad.User;

@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "manage-user" }) })
public class ManageUserAct extends ActionSupport implements ModelDriven<User> {

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
		listUsers = userBs.findAllUsers();
		return "index";
	}

	public String show() {
		return "show";
	}

	public String edit() {
		return "edit";
	}

	public void validateUpdate() {
		System.out.println("--> validateUpdate");
		try {
			userBs.update(model);
		} catch (LoginDuplicatedException e) {
			addFieldError("model.login", getText("MSG1"));
		} finally {

		}
	}

	/*@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "model.name", type = ValidatorType.FIELD, message = "The name field is mandatory"),
			@RequiredStringValidator(fieldName = "model.lastName", type = ValidatorType.FIELD, message = "The lastname field is mandatory"),
			@RequiredStringValidator(fieldName = "model.login", type = ValidatorType.FIELD, message = "The login field is mandatory") }, stringLengthFields = {
					@StringLengthFieldValidator(fieldName = "model.name", type = ValidatorType.FIELD, message = "The length of name field is wrong", minLength = "5", maxLength = "10"),
					@StringLengthFieldValidator(fieldName = "model.lastName", type = ValidatorType.FIELD, message = "The length lastname field is wrong", minLength = "5", maxLength = "10") }, emails = {
							@EmailValidator(fieldName = "model.login", type = ValidatorType.FIELD, message = "The email field is wrong") })*/
	public String update() {
		System.out.println("--> update");
		return SUCCESS;
	}

	public String editNew() {
		return "editNew";
	}

	public void validateCreate() {

	}

	/*@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "model.name", type = ValidatorType.FIELD, message = "The name field is mandatory"),
			@RequiredStringValidator(fieldName = "model.lastName", type = ValidatorType.FIELD, message = "The lastname field is mandatory"),
			@RequiredStringValidator(fieldName = "model.login", type = ValidatorType.FIELD, message = "The login field is mandatory") }, stringLengthFields = {
					@StringLengthFieldValidator(fieldName = "model.name", type = ValidatorType.FIELD, message = "The length of name field is wrong", minLength = "5", maxLength = "10"),
					@StringLengthFieldValidator(fieldName = "model.lastName", type = ValidatorType.FIELD, message = "The length lastname field is wrong", minLength = "5", maxLength = "10") }, emails = {
							@EmailValidator(fieldName = "model.login", type = ValidatorType.FIELD, message = "The email field is wrong") })*/
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
