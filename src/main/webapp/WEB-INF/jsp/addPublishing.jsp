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
<div class="content">
    <jsp:include page="common/menu.jsp"/>
    <div class="container">
        <div class="row" style="height: 30px"></div>
        <div class="row align-items-center">
            <div class="col"></div>
            <div class="col-6">
                <h2>Добавление нового издательства</h2>
                <%--@elvariable id="publishing" type="com.sberbank.library.domain.PublishingForm"--%>
                <form:form method="post" action="/publishing/add" modelAttribute="publishing">
                    <div class="form-group">
                        <form:label path="name">Название издательства</form:label>
                        <form:input path="name" class="form-control" placeholder="Имя"/>
                        <form:errors path="name" class="invalid-feedback" element="div" cssStyle="display: block"/>
                    </div>

                    <input type="submit" value="Сохранить" class="btn btn-primary"/>
                </form:form>
            </div>
            <div class="col"></div>
        </div>
    </div>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>