<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Авторизация - OnlineStore</title>
</head>
<body>

<s:form action="/auth" method="post" modelAttribute="authUser">
    <table>
        <tr>
            <td colspan="2">Авторизация в OnlineStore:</td>
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
        <tr>
            <td></td>
            <td><input type="submit" value="Войти"/>&nbsp;<a href="${pageContext.request.contextPath}/">На главную страницу</a></td>
        </tr>
    </table>

</s:form>
    <%--@elvariable id="exception" type="exception"--%>
    <%--<c: if test="${not empty exception}">--%>

        <%--<p style="color:red;">--%>
                <%--${exception}--%>
        <%--</p>--%>
    <%--</c:if>--%>
</body>
</html>
