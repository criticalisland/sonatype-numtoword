<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="demo" class="com.sonatype.spring.model.Numbers"
	scope="session" />
<!DOCTYPE html>
<html>
<head>
<%
	com.sonatype.spring.model.Numbers fb = new com.sonatype.spring.model.Numbers();
%>
<meta charset="ISO-8859-1">
<title>RESULT:<%
		out.print(fb.getNumberWords());
	%></title>
<meta name="SystemInformation"
	content="<%out.print(fb.getIntancesName());%>">
<script>
	/* The back() method loads the previous URL in the history list. 
	   This is the same as clicking the "Back button" in your browser.
	 */
	function goBack() {
		window.history.back()
	}
</script>
</head>
<body>
	<%
		out.print(fb.getNumberWords());
	%>
	<button onclick="goBack()">Try Another</button>

</body>
</html>