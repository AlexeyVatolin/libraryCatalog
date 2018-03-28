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
    <div class="container">
        <h1>Welcome in site</h1>
        <div class="row justify-content-end">
            <div class="col-4">
                <form method="POST" action="/searchBook" class="navbar-form navbar-left" role="search" enctype="multipart/form-data">
                    <div class="form-group">
                        <input name="searchText" type="text" class="form-control" placeholder="Search"/>
                    </div>
                    <button type="submit" class="btn btn-default">Поиск</button>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col"></div>
            <div class="col-6">
                <c:if test="${searchCondition != null}">
                    <p>Поиск по условию: ${searchCondition}</p>
                </c:if>
                <%--@elvariable id="books" type="java.util.List"--%>
                <c:forEach var="book" items="${books}">
                    <div>
                        <h2>${book.getTitle()}</h2>
                        <p>${book.getAuthor().getDisplayName()}</p>
                        <p>${book.getPublishing().getName()}</p>
                    </div>
                </c:forEach>

            </div>
            <div class="col"></div>
        </div>


    </div>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>