<%--
  Created by IntelliJ IDEA.
  User: resid
  Date: 11.08.2019
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
    <title>Товары - OnlineStore</title>
</head>
<body>
<hr/>
<p>
    <c:if test="${sessionScope.currentPerson == null}">
        Добро пожаловать на OnlineStore!&nbsp;
        <a href="${pageContext.request.contextPath}/reg">Регистрация</a>&nbsp;
        <a href="${pageContext.request.contextPath}/auth">Вход</a>&nbsp;
    </c:if>
    <c:if test="${sessionScope.currentPerson != null}">
        ${sessionScope.currentPerson.getLogin()}, Добро пожаловать на OnlineStore!&nbsp;<a href="${pageContext.request.contextPath}/logout">Выход</a>&nbsp;
    </c:if>
</p>
<hr/>
<c:if test="${sessionScope.currentPerson != null}">
    <a href="${pageContext.request.contextPath}/">На главную страницу</a>&nbsp;
</c:if>
<c:if test="${sessionScope.currentPerson == null}">
    <a href="${pageContext.request.contextPath}/">На главную страницу</a>&nbsp;
</c:if>
<hr/>

<section>
    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <th>Id</th>
            <th>Название</th>
            <th>Описание</th>
            <th>Стоимость</th>
        </tr>
        <jsp:useBean id="items" scope="request" type="java.util.List"/>
        <c:forEach items="${items}" var="item">
            <jsp:useBean id="item" type="by.tms.onlinestore.entity.Item"/>
            <tr>
                <td>${item.id}</td>
                <td>${item.title}</td>
                <td>${item.description}</td>
                <td>Br${item.price}</td>
            </tr>
        </c:forEach>
    </table>
</section>

<hr/>
<c:if test="${sessionScope.currentPerson.getRole() == 'admin'}">
    <button type="button"><a href="${pageContext.request.contextPath}/newitem">Добавить товар</a></button>
</c:if>
</body>
</html>
