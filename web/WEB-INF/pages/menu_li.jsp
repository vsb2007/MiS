<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <li><a href="userslist"><i class="material-icons left">perm_identity</i>Пользователи</a></li>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_MONEY') || hasRole('ROLE_SERVICELIST') ">
    <li><a href="serviceList"><i class="material-icons left">view_list</i>Оказанные услуги</a></li>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_USER')">
    <li><a href="serviceList"><i class="material-icons left">view_list</i>Направления</a></li>
</sec:authorize>


<sec:authorize access="hasRole('ROLE_LOGIN')">
    <li><a href="login"><i class="material-icons left">settings</i>Настройки</a></li>
    <li><a href="logout"><i class="material-icons left">power_settings_new</i>Выход</a></li>
</sec:authorize>
<sec:authorize access="!hasRole('ROLE_LOGIN')">
    <li><a href="login"><i class="material-icons left">power_settings_new</i>Вход</a></li>
</sec:authorize>
