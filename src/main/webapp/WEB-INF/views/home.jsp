<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form action="<c:url value='/second'/>" method="post">
	id:<input type="text" name="m_user_id" size"20"><br>
	name:<input type="text" name="m_user_name" size"20"><br>
	pw:<input type="password" name="m_user_pw" size"20"><br>
	<select name="m_user_role">
  		<option value="sales">sales</option>
  		<option value="engineer">engineer</option>
  		<option value="developer">developer</option>
	</select>
	<input type="submit" value="Multiple">
</form>

</body>
</html>
