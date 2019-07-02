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
    <div class="offset-4 col-4 pl-4 pt-2 my-5">
        <div class="row shadow rounded" id="carPageSellerDiv">
            <div class="col-12 mt-3 carPageSellerTitle">Your Profile</div>
            <hr id="searchByCatLine" width="100%">
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
                    <div class=" mt-2 col-7 carSellSellerDivRightSide">
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
</div>

<div style="text-align: center" class="m-5">
    <h1 id="sellCarTitle">My cars for sale</h1>
</div>

<div class="container">
    <div class="row">
        <c:forEach var="ad" items="${adList}">
            <div class="col-12 mt-3">
                <form action="/car" id="${ad.id}">
                    <input type="hidden" name="ad_id" value="${ad.id}">
                    <div class="row">
                        <a href="javascript:{}"
                           onclick="document.getElementById('${ad.id}').submit(); return false;">
                            <div  style="height: 200px; width: 350px; overflow: hidden">
                                <img src="data:image/jpg;base64,${ad.car.photo1out}" alt="" style="max-height: 100%" class="img-fluid">
                            </div>
                        </a>
                        <div class="col-lg-4">
                            <a href="javascript:{}"
                               onclick="document.getElementById('${ad.id}').submit(); return false;">
                                <span class="carSearchTitle"
                                      style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden">${ad.title}</span>
                                <br>
                            </a>
                            <span class="carSearchPrice"><b>${ad.price} $</b></span> <br>
                            <span> <i class="fa fa-map-marker" aria-hidden="true"></i> ${ad.user.city} </span> <br>
                            <br>
                            <div class="carSearchDesc">
                                <span>${ad.description}</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 mt-5">
                        <hr class="searchCarLine">
                    </div>

                </form>
            </div>
        </c:forEach>

    </div>

</div>