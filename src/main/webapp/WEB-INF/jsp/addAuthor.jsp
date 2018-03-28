<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common/head.jsp"/>
    <title>Home</title>
</head>
<body>
<div class="container">
    <div class="row" style="height: 30px"></div>
    <div class="row align-items-center">
        <div class="col"></div>
        <div class="col-6">
            <h2>Добавление нового автораin</h2>
            <%--@elvariable id="author" type="AuthorForm"--%>
            <form:form method="post" action="/addAuthor" modelAttribute="author">
                <div class="form-group">
                    <form:label path="firstName">Имя автора</form:label>
                    <form:input path="firstName" class="form-control" placeholder="Имя"/>
                    <form:errors path="firstName" class="invalid-feedback" element="div" cssStyle="display: block"/>
                </div>

                <div class="form-group">
                    <form:label path="lastName">Фамилия автора</form:label>
                    <form:input path="lastName" class="form-control" placeholder="Фамилия"/>
                    <form:errors path="lastName" class="invalid-feedback" element="div" cssStyle="display: block"/>
                </div>

                <div class="form-group">
                    <form:label path="patronymic">Отчество автора</form:label>
                    <form:input path="patronymic" class="form-control" placeholder="Отчество"/>
                    <form:errors path="patronymic" class="invalid-feedback" element="div" cssStyle="display: block"/>
                </div>

                <input type="submit" value="Сохранить" class="btn btn-primary"/>
            </form:form>
        </div>
        <div class="col"></div>
    </div>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>