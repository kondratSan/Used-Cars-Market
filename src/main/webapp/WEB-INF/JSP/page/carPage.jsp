<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 6/26/2019
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <div class="row" style="margin-bottom: 150px; margin-top: 70px">
        <div class="col-md-6 blank"></div>
        <div class="col-md-6 blank"></div>

        <div class="col-12">
            <span><h2 class="carPageTitle"><b>${ad.title} <br></b></h2></span><br>
            <span><h2 class="carPagePrice"><b>${ad.price}&nbsp;$</b></h2></span>
            <hr class="carPageLine">
        </div>
        <div class="col-12 col-lg-4 pl-4 pt-2 mb-3 order-lg-2">
            <div class="row shadow rounded" id="carPageSellerDiv">
                <div class="col-12 my-3 carPageSellerTitle">Seller</div>
                <div class="col-12">
                    <div class="row">
                        <div class="col-5 pl-5">
                            <img class id="sellerIcon" src="../../../static/img/sellerIcon.png" alt=""><br><br>
                            <span>City</span><br><br>
                            <span>Phone</span><br><br>
                            <span>Email</span><br><br>
                            <span>Age</span><br><br>
                        </div>
                        <div class=" mt-2 col-7 carSellSellerDivRightSide">
                            <span> ${ad.user.firstName} ${ad.user.lastName}</span><br><br>
                            <span> ${ad.user.city}</span><br><br>
                            <span> ${ad.user.phoneNumber}</span><br><br>
                            <span> ${ad.user.email}</span><br><br>
                            <span> ${ad.user.age}</span><br><br>
                        </div>
                    </div>

                </div>

            </div>

        </div>

        <div class="col-12 col-lg-8 carPageCarSide p-2">
            <div class="carPageimgDiv">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="data:image/jpg;base64,${ad.car.photo1out}"
                                 alt="First slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="data:image/jpg;base64,${ad.car.photo2out}"
                                 alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="data:image/jpg;base64,${ad.car.photo3out}"
                                 alt="Third slide">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            <div class="row carSellCarInfo shadow mt-5 p-3">
                <div class="col-4"><b>
                    <span>Category</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                    <span>Year</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                    <span>Fuel</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                    <span>Engine</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                    <span>Transmission</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                    <span>Car Drive</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                    <span>Color</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                    <span>Kilometrage</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                </b>
                </div>
                <div class="col-8">
                    <span>${ad.car.category}</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                    <span>${ad.car.carYear}</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                    <span>${ad.car.fuel}</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                    <span>${ad.car.engineVolume}L ${ad.car.enginePower} h.p.</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                    <span>${ad.car.transmission}</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                    <span>${ad.car.carDrive}</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                    <span>${ad.car.color}</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                    <span>${ad.car.kilometrage}</span><br>
                    <hr class="carPageInfoLine">
                    <br>
                </div>
                <div class="col-12">
                    <span><b>Description</b></span> <br><br>
                    <div class="carSellDescription">
                        <span>${ad.description}</span>

                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

