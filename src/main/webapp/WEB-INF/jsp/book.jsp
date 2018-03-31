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
            <div class="col-10">
                <jsp:useBean id="book" scope="request" type="com.sberbank.library.entity.Book"/>
                <c:if test="${book.getNumberOfBooksAvailable() > 0}">
                    <a class="btn btn-primary" href="<c:url value='/book/${book.getId()}/give'/>" role="button">Выдать
                        книгу</a>
                </c:if>
                <c:if test="${book.getNumberOfBooksAvailable() < book.getNumberOfBooks()}">
                    <a class="btn btn-primary" href="<c:url value='/book/${book.getId()}/take'/>" role="button">Возвратить
                        книгу</a>
                </c:if>
            </div>
            <div class="col"></div>
        </div>
        <div class="row">
            <div class="col"></div>
            <div class="col-6">
                <h5 class="text-center">${book.getTitle()}</h5>
                <p>Автор:
                    <a href="<c:url value='/author/${book.getAuthor().getId()}'/>">
                        ${book.getAuthor().getDisplayName()}
                    </a>
                </p>
                <p>Издательство:
                    <a href="<c:url value='/publishing/${book.getPublishing().getId()}'/>">
                        ${book.getPublishing().getName()}
                    </a>
                </p>
                <p>Год публикации: ${book.getPubYear()}</p>
                <p>Количество страниц: ${book.getNumberOfPage()}</p>
                <p>Количество экземпляров: ${book.getNumberOfBooks()}</p>
                <p>Количество экземпляров в наличии: ${book.getNumberOfBooksAvailable()}</p>
                <p>Расположение: ${book.getBookLocation()}</p>
            </div>
            <div class="col"></div>
        </div>
    </div>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>