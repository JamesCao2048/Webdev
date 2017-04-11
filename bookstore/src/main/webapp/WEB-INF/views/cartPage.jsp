<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title> Main Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.2.4.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.2.4.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

    <s:url value="/resources/my.css" var="myCss" />
    <link href="${myCss}" rel="stylesheet" />
</head>
<body>
<header>
    <ul class="nav nav-pills nav-justified">
        <li role="presentation" > <a href="<c:url value='/'/>">Home</a> </li>
        <li role="presentation" ><a href="<c:url value='/book'/>">Book</a></li>
        <li role="presentation" class="active" > <a href="<c:url value='/book/cart/viewcart'/>">Cart</a> </li>
        <li role="presentation"  > <a href="<c:url value='/book/order/vieworder'/>">Order</a> </li>
        <li role="presentation" > <a href="<c:url value='/adm'/>">Adm</a> </li>
    </ul>
</header>
<h1>Cart Page</h1>
<h3>Cart Info</h3>
<table class="table">
    <thead>
    <tr>
        <th>bookid</th>
        <th>bookname</th>
        <th>author</th>
        <th>stock</th>
        <th>price</th>
        <th>type</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="i" items="${cartBooks}">
        <tr>
            <td>${i.id }</td>
            <td>${i.name }</td>
            <td>${i.author }</td>
            <td>${i.stock }</td>
            <td>${i.price }</td>
            <td>${i.type }</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${cartBooks.size()>0}">
    <a href="<c:url value='/book/order/neworder'/>">Order Now!</a>
</c:if>
</body>
</html>