<jsp:useBean id="a" class="com.LoginBean"></jsp:useBean>
<jsp:setProperty property="*" name="a"/>

<%
	if(a.login()){ %>
		login success
	<%}
	else{ %>
		invalid id and password
		<jsp:include page="login.html"></jsp:include>
<%	}
%>

<hsbc:login />