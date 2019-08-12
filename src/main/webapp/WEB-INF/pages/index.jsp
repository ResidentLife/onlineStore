<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
    <title>OnlineStore</title>
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
    ${sessionScope.currentPerson.getLogin()}, Добро пожаловать на OnlineStore!&nbsp;<a href="${pageContext.request.contextPath}/logout">Выход</a>
</c:if>
</p>
<hr/>
    <a href="${pageContext.request.contextPath}/items">Список товаров</a>
<hr/>
<c:if test="${sessionScope.currentPerson.getRole() == 'admin'}">
    <button type="button"><a href="${pageContext.request.contextPath}/newitem">Добавить товар</a></button>
</c:if>
</body>
</html>