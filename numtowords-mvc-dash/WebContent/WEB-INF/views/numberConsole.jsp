
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INPUT: Number</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>

<script>
function init() {
    // Clear forms here
    document.getElementById("inputNumber").value = "";
    var input = document.getElementById("inputNumber").focus();
}
window.onload = init;</script>
</head>
<body>
	<form:form action="validate" modelAttribute="numbers">
		<tr>
			<td>Enter a number from -2,147,483,647 to 2,147,483,647<br/> 
			<form:input id = "inputNumber" name="numberParam" autocomplete="off" maxlength="14" type="text" path="numberStr" />
			</td>
			<td><form:errors id="errorVal" path="numberStr" cssClass="error" /></td>
		</tr>
		<br/>
		<tr>
			<td><input id = "submitButton" type="submit" value="Convert" /></td>
		</tr>
	</form:form>
	<br/>

</body>
</html>