<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="xmlReader.TestXmlReader"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>XML Viewer</title>
</head>
<body>
	<% 
		String jude  =  (String)request.getAttribute("Hello");
	%>
	
	<p><%=jude %></p>
</body>
</html>