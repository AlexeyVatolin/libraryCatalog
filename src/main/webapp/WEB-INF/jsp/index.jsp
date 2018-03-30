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
                <c:if test="${searchCondition != null}">
                    <p>Поиск по условию: ${searchCondition}</p>
                </c:if>
                <%--@elvariable id="books" type="java.util.List"--%>
                <c:forEach var="book" items="${books}">
                    <div>
                        <h2>${book.getTitle()}</h2>
                        <p>
                            <a href="<c:url value="/author/${book.getAuthor().getId()}"/>">
                                    ${book.getAuthor().getDisplayName()}
                            </a>
                        </p>
                        <p>
                            <a href="<c:url value="/publishing/${book.getPublishing().getId()}"/>">
                                ${book.getPublishing().getName()}
                            </a>
                        </p>
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