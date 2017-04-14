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

    <s:url value="/WEB_INF/resources/my.css" var="myCss" />
    <link href="${myCss}" rel="stylesheet" />
</head>
<body>
<header>
    <ul class="nav nav-pills nav-justified">
        <li role="presentation" > <a href="<c:url value='/'/>">Home</a> </li>
        <li role="presentation" class="active"><a href="<c:url value='/book'/>">Book</a></li>
        <li role="presentation"  > <a href="<c:url value='/book/cart/viewcart'/>">Cart</a> </li>
        <li role="presentation"  > <a href="<c:url value='/book/order/vieworder'/>">Order</a> </li>
        <li role="presentation" > <a href="<c:url value='/adm'/>">Adm</a> </li>
    </ul>
</header>
<h1>Book Page</h1>
<h3>Book Info</h3>
<div class="modal fade" id="addBook"  role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h3>Add Book</h3>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="put" action="<c:url value='/book/cart/addbook'/>">
                    <div class="form-group">
                        <label for="unlg" class="control-label col-sm-3">BookId</label>
                        <div class="col-sm-9">
                            <input type="text" name="bookId" id="unlg" class="form-control" placeholder="bookid">
                        </div>
                    </div>
                    <input type="submit" class="form-control" value="submit" style="background-color:green;color:white">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn-warning" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>
<div style="display:block">
<table class="table col-md-3 col-lg-3" style="display: inline-block; width:30%;" id="bookTable">
    <thead>
    <tr>
        <th>bookid</th>
        <th>bookname</th>
        <th>author</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="i" items="${books}">
        <tr>
            <td>${i.id }</td>
            <td>${i.name }</td>
            <td>${i.author }</td>
            <td><button type="button"  onclick="loadBook('${i.id}')">Detail</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div style="display: none" id="curBook" class="col-md-3 col-lg-3">
<h3>Current Book</h3>
<p>Id: <span id="selId"></span></p>
<p>Name: <span id="selName"></span></p>
<p>Author: <span id="selAuthor"></span></p>
<p>Stock: <span id="selStock"></span></p>
<p>Price: <span id="selPrice"></span></p>
<p>Type: <span id="selType"></span></p>
</div>
</div>
<div class="btn-group-vertical" role="group" aria-label="..." style="display: block;width: 10%">
    <button type="button" class="btn btn-default op" data-toggle="modal" data-target="#addBook">Add Book</button>
</div>
<script>
    function loadBook(id) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                console.log(id);
                console.log(xhttp.responseText);
                var myobj = JSON.parse(xhttp.responseText);
                console.log(myobj);
                document.getElementById("selId").innerHTML=myobj.id;
                document.getElementById("selName").innerHTML=myobj.name;
                document.getElementById("selAuthor").innerHTML=myobj.author;
                document.getElementById("selStock").innerHTML=myobj.stock;
                document.getElementById("selPrice").innerHTML=myobj.price;
                document.getElementById("selType").innerHTML=myobj.type;
                document.getElementById("curBook").style.display="block";
            }
        };
        xhttp.open("GET", "book/ajax/"+id, true);
        xhttp.send();
    }
</script>
</body>
</html>