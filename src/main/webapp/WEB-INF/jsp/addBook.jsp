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
            <h2>Добавление новой книги</h2>
            <%--@elvariable id="book" type="AddBookForm"--%>
            <form:form method="post" action="/addBook" modelAttribute="book">
                <div class="form-group">
                    <form:label path="title">Название книги</form:label>
                    <form:input path="title" class="form-control" placeholder="Название книги"/>
                    <form:errors path="title" class="invalid-feedback" element="div" cssStyle="display: block"/>

                </div>

                <div class="form-group">
                    <form:label path="author">Автор</form:label>
                    <form:select path="author" class="form-control">
                        <%--@elvariable id="authors" type="java.util.List"--%>
                        <form:options items="${authors}" itemLabel="displayName"/>
                    </form:select>
                </div>

                <div class="form-group">
                    <form:label path="publishing">Издательство</form:label>
                    <form:select path="publishing" class="form-control">
                        <%--@elvariable id="publishings" type="java.util.List"--%>
                        <form:options items="${publishings}" itemLabel="name" itemValue="id"/>
                    </form:select>
                </div>

                <div class="form-group">
                    <form:label path="pubYear">Год издания</form:label>
                    <form:input path="pubYear" type="number" class="form-control"/>
                    <form:errors path="pubYear" class="invalid-feedback" element="div" cssStyle="display: block"/>
                </div>

                <div class="form-group">
                    <form:label path="numberOfPage">Количество страниц</form:label>
                    <form:input path="numberOfPage" type="number" class="form-control"/>
                    <form:errors path="numberOfPage" class="invalid-feedback" element="div" cssStyle="display: block"/>
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