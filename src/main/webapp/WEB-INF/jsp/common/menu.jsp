<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Каталог книг</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/'/>">Главная</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/add/book'/>">Добавить книгу</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/authors'/>">Авторы</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/publishings'/>">Издательства</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/authors'/>">Авторы</a>
            </li>
        </ul>
        <form method="POST" action="/searchBook" class="form-inline my-2 my-lg-0">
            <input name="searchText" class="form-control mr-sm-2" type="search" placeholder="Поиск по книгам" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
        </form>
    </div>
</nav>