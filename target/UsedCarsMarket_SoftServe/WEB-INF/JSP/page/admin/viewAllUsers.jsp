<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 6/26/2019
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container my-5">
    <div class="row">
        <div class="col-md-6 blank"></div>
        <div class="col-md-6 blank"></div>
    </div>
</div>


<%--<c:url var="deleteLink" value="doctor">--%>
<%--<c:param name="command" value="DELETE"/>--%>
<%--<c:param name="docId" value="${tmpDoctor.accountId}"/>--%>
<%--</c:url>--%>




<div class="container">
    <c:forEach var="user" items="${userList}">

        <div class="row">
            <div class="col-12 mt-3">
                <div class="row shadow viewUserCard p-5">
                    <div class="col-md-3 col-5 CarSearchImgDiv ">
                        <img src="../../../../static/img/humanIcon.JPG" alt="" class="viewAllUsersHumanImg img-fluid">
                    </div>
                    <div class="col-md-7 col-5">
                        <div class="row">
                            <div class="col-3 pt-3 viewAllUsersLeftText">
                                <span>Id</span><br><br>
                                <span>Name</span><br><br>
                                <span>Email</span><br><br>
                                <span>Password</span><br><br>
                                <span>Status</span><br><br>
                            </div>
                            <div class="col-9 pt-3">
                                <span>${user.id}</span><br><br>
                                <span>${user.firstName} ${user.lastName}</span><br><br>
                                <span>${user.email}</span><br><br>
                                <span>${user.password}</span><br><br>
                                <span>${user.role}</span><br><br>
                            </div>
                        </div>
                    </div>
                    <div class="col-2">
                        <button class="btn btn-danger btn-lg" type="button"
                                onclick="window.location.href = '#'">
                            Block
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-12 mt-5">
                <hr class="searchCarLine">
            </div>
        </div>
    </c:forEach>
</div>