<%--
  Created by IntelliJ IDEA.
  User: resid
  Date: 11.08.2019
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        .currencyinput {
            border: 1px inset #ccc;
        }
        .currencyinput input {
            border: 0;
        }
    </style>
    <title>New Item</title>
</head>
<body>
<p>
    ${sessionScope.currentPerson.getLogin()}, Добро пожаловать, на OnlineStore!&nbsp;<a href="${pageContext.request.contextPath}/logout">Выход</a>
</p>
<section>
    <form method="POST" action="/newitem" modelAttribute="newItem">
    <c:set var="role" scope="request" value="${sessionScope.currentPerson.getRole()}"/>
    <c:if test="${role == 'admin'}">
        <table cellpadding="2">
            <tr>
                <td><strong>Название</strong><br/> (максимум 150 символов)</td>
                <td><label>
                    <input required type="text" name="title" size=30 maxlength="150">
                </label></td>
            </tr>
            <tr>
                <td><strong>Описание</strong><br/> (Максимум 1000 символов)</td>
                <td><label>
                    <textarea name="description" cols="30" rows="10" maxlength="1000"></textarea>
                </label>
                </td>
            </tr>
            <tr>
                <td><strong>Стоимость</strong></td>
                <td><span class="currencyinput"><label>
                    <input required type="number" name="price" size=30 value="price" step="0.01" min="0">
                </label></span></td>
            </tr>
            <tr>
                <td><strong>Количество</strong></td>
                <td><label>
                    <input required type="number" name="amount" size=30 value="amount" min="0">
                </label></td>
            </tr>
        </table>
        <hr/>
        <button type="submit">Сохранить</button>
        <button type="button"><a href="${pageContext.request.contextPath}/items">Вернуться к товарам</button>

        <%--@elvariable id="exception" type="exception"--%>
        <%--<c:if test="${not empty exception}">--%>
            <%--<p style="color:red;">--%>
                    <%--${exception}--%>
            <%--</p>--%>
        <%--</c:if>--%>
    </c:if>
</section>
</body>
</html>
