
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
</head>
<body>
	<div>
		<h1>Login</h1>
	</div>
	<form action="Ejercicio5" method = post>

		<div class="container">
			<div>
				<label></label>
			</div>
			<div>
				<label for="uname"><b>First name: </b></label> <input type="text"
				name="uname" required>
			</div>
			<div>
				<label for="lname"><b>Last name: </b></label> <input type="text"
				name="lname" required>
			</div>
			<div>
				<label for="lname2"><b>Second last name: </b></label> <input type="text"
				name="lname2" required>
			</div>
			<div>
				<label for="curp"><b>CURP: </b></label> <input pattern = "^[a-zA-Z]{4}\d{6}[a-zA-Z]{6}\d{2}$" type="text" name="curp" required>
			</div>
			<div>
				<label for="bd"><b>Birthday: </b></label> <input type="date" name="bd" required>
			</div>
			
			<br>
			<h2>Address</h2> <br>
			
			<div>
				<label for="street"><b>Street: </b></label> <input type="text" name="street" required>
			</div>
			<div>
				<label for="city"><b>City: </b></label> <input type="text" name="city" required>
			</div>
			<div>
				<label for="zipcode"><b>Zip Code: </b></label> <input type="number" name="zipcode" maxlength="5" required>
			</div>
			
						<br>
			<h2>User</h2> <br>
			
			<div>
				<label for="login"><b>Login: </b></label> <input type="email" name="login" required>
			</div>
			<div>
				<label for="pw"><b>Password: </b></label> <input type="password" name="pw"  required>
			</div>
			<div>
				<label for="cpw"><b>Confirm Password: </b></label> <input type="password" name="cpw" required>
			</div>
			
			<button type="reset">Cancel</button>
			<button type="submit">Save</button>
		</div>

	</form>
</body>
</html>
