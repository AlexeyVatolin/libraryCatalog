<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="row">
            <div class="col"></div>
            <div class="col-6">
                <div class="list-group">
                <%--@elvariable id="publishings" type="java.util.List"--%>
                <c:forEach var="publishing" items="${publishings}">
                    <a href="<c:url value="/publishing/${publishing.getId()}"/>"
                       class="list-group-item list-group-item-action flex-column align-items-start">
                        <h5>${publishing.getName()}</h5>
                    </a>
                </c:forEach>
                </div>
            </div>
            <div class="col"></div>
        </div>
    </div>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>