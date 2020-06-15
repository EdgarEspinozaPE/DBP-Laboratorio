<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar JavaBean</title>
</head>
<body>

	<jsp:useBean id="objeto" class="com.Datos"
		scope="session">
		<jsp:setProperty name="objeto" property="mensaje" param="*" />
	</jsp:useBean>

	<p>
		Mensaje:
		<jsp:getProperty name="objeto" property="mensaje" />
	</p>
	<p>
		Expresion:
		<jsp:getProperty name="objeto" property="expresion" />
	</p>
	<p>
		Fecha:
		<jsp:getProperty name="objeto" property="fecha" />
	</p>
	<p>
		Contador:
		<jsp:getProperty name="objeto" property="contador" />
	</p>
</body>
</html>