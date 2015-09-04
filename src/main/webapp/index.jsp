<html>
<body>
<h2>Hello World!</h2>
</body>
<%
session = request.getSession(false);
session.setAttribute("uid",1);
session.setAttribute("pid",1);
%>
<a href="instantRefill">Click Here</a>
</html>
