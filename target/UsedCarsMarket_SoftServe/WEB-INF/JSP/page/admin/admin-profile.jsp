<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 6/29/2019
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="row">
    <div class="col-md-6 blank"></div>
    <div class="col-md-6 blank"></div>
    <div class="offset-md-4 offset-1 col-10 col-md-4 pl-4 pt-2 my-5">
        <div class="row shadow rounded" id="carPageSellerDiv">
            <div class="col-12 my-3 carPageSellerTitle">Your Profile</div>
            <div class="col-12">
                <div class="row">
                    <div class="col-5 pl-5">
                        <img class id="sellerIcon" src="../../../static/img/sellerIcon.png" alt=""><br><br>
                        <span>Your user id</span><br><br>
                        <span>City</span><br><br>
                        <span>Phone</span><br><br>
                        <span>Email</span><br><br>
                        <span>Password</span><br><br>
                        <span>Age</span><br><br>
                    </div>
                    <div class="mt-2 col-7 carSellSellerDivRightSide">
                        <span> <c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></span><br><br>
                        <span> <c:out value="${user.id}"/></span><br><br>
                        <span> <c:out value="${user.city}"/></span><br><br>
                        <span> <c:out value="${user.phoneNumber}"/></span><br><br>
                        <span> <c:out value="${user.email}"/></span><br><br>
                        <span> <c:out value="${user.password}"/></span><br><br>
                        <span> <c:out value="${user.age}"/></span><br><br>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="offset-1 col-12 col-md-2 my-5 d-flex justify-content-center">
        <div class="row">
            <div class="col-12" ></div>
            <button class="btn btn-danger" type="button" onclick="window.location.href = '/user-list'" style="height: 50px;">
                View all users
            </button>
        </div>

    </div>
</div>