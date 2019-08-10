<%--
  Created by IntelliJ IDEA.
  User: resid
  Date: 09.08.2019
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Регистрация - OnlineStore</title>
</head>
<body>
<form method="POST" action="/reg" modelAttribute="newPerson">
    <table>
        <tr>
            <td colspan="2">Регистрация в OnlineStore:</td>
        </tr>
        <tr>
            <td>Логин:</td>
            <td><label>
                <input required type="text" name="login"/>
            </label></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><label>
                <input required type="password" name="password"/>
            </label></td>
        </tr>
        <%--<tr>--%>
            <%--<td>Retype password:</td>--%>
            <%--<td><label>--%>
                <%--<input required type="password" name="retype_password"/>--%>
            <%--</label></td>--%>
        <%--</tr>--%>
        <tr>
            <td></td>
            <td><input type="submit" value="Зарегестрироваться"/>&nbsp;<a href="${pageContext.request.contextPath}/">На главную страницу</a></td>
        </tr>
    </table>
    <%--@elvariable id="exception" type="exception"--%>
    <%--<c:if test="${not empty exception}">--%>
        <%--<p style="color:red;">--%>
                <%--${exception}--%>
        <%--</p>--%>
    <%--</c:if>--%>
</form>
</body>
</html>
