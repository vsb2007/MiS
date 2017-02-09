<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<main>
    <div class="container">
        <div class="row">
            <div class="col s12">
                <%@ include file="menu_cols.jsp" %>
                <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                    <div class="row">
                        <span class="col s12 center-align">Карточка пользователя</span>
                    </div>
                    <form:form method="POST" modelAttribute="user">
                        <form:input type="hidden" path="id" id="id"/>
                        <div class="row">
                            <div class="col s12">
                                <div class="input-field col s12">
                                    <form:input type="text" class="validate" path="lastName" id="lastName"/>
                                    <label for="lastName">Фамилия</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s12">
                                <div class="input-field col s12">
                                    <form:input type="text" class="validate" path="firstName" id="firstName"/>
                                    <label for="firstName">Имя</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s12">
                                <div class="input-field col s12">
                                    <form:input type="text" class="validate" path="patronymicName" id="patronymicName"/>
                                    <label for="patronymicName">Отчество</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s12">
                                <div class="input-field col s12">
                                    <form:input type="text" class="validate" path="phone" id="phone"/>
                                    <label for="phone">Телефон</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s12">
                                <div class="input-field col s12">
                                    <c:choose>
                                        <c:when test="${edit}">
                                            <form:input type="text" class="validate" path="ssoId" id="ssoId"
                                                        disabled="true"/>
                                            <label for="patronymicName">Логин</label>
                                        </c:when>
                                        <c:otherwise>
                                            <form:input type="text" class="validate" path="ssoId" id="ssoId"/>
                                            <label for="patronymicName">Логин</label>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col s12">
                                <div class="input-field col s12">
                                    <form:input type="password" class="validate" path="password" id="password"/>
                                    <label for="password">Пароль</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s12">
                                <div class="input-field col s12">
                                    <form:input type="email" class="validate" path="email" id="email"/>
                                    <label for="email">Электронный адрес</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col s12">
                                <div class="input-field col s12">
                                    <div class="select-wrapper">
                                        <form:select path="userProfiles" items="${roles}" itemValue="id"
                                                     itemLabel="type" class="initialized" multiple="true"/>
                                    </div>
                                    <label>Роли</label>
                                </div>
                            </div>
                        </div>
                        <c:if test="${edit}">
                            <div class="row">
                                <div class="col s12">
                                    <label class="col s12" for="blocked">Блокировка</label>
                                    <div class="switch col s12">
                                        <label>
                                            Off
                                            <c:if test="${user.getBlocked()}">
                                                <input type="checkbox" path="blocked" checked id="blocked"
                                                       name="blocked" class="validate"/>
                                            </c:if>
                                            <c:if test="${!user.getBlocked()}">
                                                <input type="checkbox" path="blocked" id="blocked" name="blocked"
                                                       class="validate"/>
                                            </c:if>
                                            <span class="lever"></span>
                                            On
                                        </label>
                                    </div>

                                </div>
                            </div>
                        </c:if>
                        <div class="row">
                            <div class="form-actions floatRight">
                                <c:choose>
                                    <c:when test="${edit}">
                                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
                                            href="<c:url value='/userslist' />">Cancel</a>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
                                            href="<c:url value='/userslist' />">Cancel</a>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </form:form>
                    <div class="row">
                        <div class="col s12">
                            <div class="alert alert-success lead">
                                    ${success}
                            </div>
                        </div>
                    </div>
                </sec:authorize>
            </div>
        </div>
    </div>
</main>
<script>
    $(document).ready(function () {
        $('select').material_select();
    });
</script>
<%@include file="footer.jsp" %>