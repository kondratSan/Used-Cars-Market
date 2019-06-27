<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 6/27/2019
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container ">
    <div class="row" style="margin-bottom: 150px; margin-top: 70px">
        <div class="col-md-6 blank"></div>
        <div class="col-md-6 blank"></div>
        <div class="row sellCarBody shadow-lg">
            <div class="col-12 d-flex justify-content-center mt-3" >
                <h1 id="sellCarTitle">Add&nbsp;information about&nbsp;the&nbsp;car</h1>
            </div>
            <div class="col-md-6 sellCarLeftSide p-5">
                <div class="row">
                    <div class="col-12 sellCarBigText">
                        <span>General Information</span>
                    </div>
                    <div class="col-6">
                        <div class="row">
                            <div class="col-12 sellCarLeftSideTitle">
                                <span>Category</span>
                            </div>
                            <div class="col-12 sellCarLeftSideTitle">
                                <span>Brand</span>
                            </div>
                            <div class="col-12 sellCarLeftSideTitle">
                                <span>Model</span>
                            </div>
                            <div class="col-12 sellCarLeftSideTitle">
                                <span>Year</span>
                            </div>
                            <div class="col-12 sellCarLeftSideTitle">
                                <span>Fuel</span>
                            </div>
                            <div class="col-12 sellCarLeftSideTitle">
                                <span>Engine Volume</span>
                            </div>
                            <div class="col-12 sellCarLeftSideTitle">
                                <span>Engine Power</span>
                            </div>
                            <div class="col-12 sellCarLeftSideTitle">
                                <span>Transmission</span>
                            </div>
                            <div class="col-12 sellCarLeftSideTitle">
                                <span>Car Drive</span>
                            </div>
                            <div class="col-12 sellCarLeftSideTitle">
                                <span>Kilometrage</span>
                            </div>
                            <div class="col-12 sellCarLeftSideTitle">
                                <span>Color</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="row">
                            <div class="col-12 sellCarLeftSideSelect">
                                <div class="input-group form-group">
                                    <select class="browser-default custom-select">
                                        <option selected>Category</option>
                                        <option value="1">Category1</option>
                                        <option value="2">Category2</option>
                                        <option value="3">Category3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-12 sellCarLeftSideSelect">
                                <div class="input-group form-group">
                                    <select class="browser-default custom-select">
                                        <option selected>Brand</option>
                                        <option value="1">Brand1</option>
                                        <option value="2">Brand2</option>
                                        <option value="3">Brand3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-12 sellCarLeftSideSelect">
                                <div class="input-group form-group">
                                    <select class="browser-default custom-select">
                                        <option selected>Model</option>
                                        <option value="1">Model1</option>
                                        <option value="2">Model2</option>
                                        <option value="3">Model3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-12 sellCarLeftSideSelect">
                                <div class="input-group form-group">
                                    <input type="number" class="form-control" placeholder="Year">
                                </div>
                            </div>
                            <div class="col-12 sellCarLeftSideSelect">
                                <div class="input-group form-group">
                                    <select class="browser-default custom-select">
                                        <option selected>Fuel</option>
                                        <option value="1">Category1</option>
                                        <option value="2">Category2</option>
                                        <option value="3">Category3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-12 sellCarLeftSideSelect">
                                <div class="input-group form-group">
                                    <input type="number" class="form-control" placeholder="Volume">
                                </div>
                            </div>
                            <div class="col-12 sellCarLeftSideSelect">
                                <div class="input-group form-group">
                                    <input type="number" class="form-control" placeholder="Horse Power">
                                </div>
                            </div>
                            <div class="col-12 sellCarLeftSideSelect">
                                <div class="input-group form-group">
                                    <select class="browser-default custom-select">
                                        <option selected>Transmission</option>
                                        <option value="1">Category1</option>
                                        <option value="2">Category2</option>
                                        <option value="3">Category3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-12 sellCarLeftSideSelect">
                                <div class="input-group form-group">
                                    <select class="browser-default custom-select">
                                        <option selected>Car Drive</option>
                                        <option value="1">Category1</option>
                                        <option value="2">Category2</option>
                                        <option value="3">Category3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-12 sellCarLeftSideSelect">
                                <div class="input-group form-group">
                                    <input type="number" class="form-control" placeholder="Km">
                                </div>
                            </div>
                            <div class="col-12 sellCarLeftSideSelect">
                                <div class="input-group form-group">
                                    <select class="browser-default custom-select">
                                        <option selected>Color</option>
                                        <option value="1">Category1</option>
                                        <option value="2">Category2</option>
                                        <option value="3">Category3</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-6 sellCarRightSide p-5">
                <div class="sellCarBigText">
                    <span>Add Photos</span>
                </div>
                <div class="input-group img-input">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="inputGroupFile01"
                               aria-describedby="inputGroupFileAddon01">
                        <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                    </div>
                </div>
                <div class="input-group img-input">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupFileAddon02">Upload</span>
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="inputGroupFile02"
                               aria-describedby="inputGroupFileAddon01">
                        <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                    </div>
                </div>
                <div class="input-group img-input">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupFileAddon03">Upload</span>
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="inputGroupFile03"
                               aria-describedby="inputGroupFileAddon01">
                        <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                    </div>
                </div>
                <div class="input-group img-input">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupFileAddon04">Upload</span>
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="inputGroupFile04"
                               aria-describedby="inputGroupFileAddon01">
                        <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                    </div>
                </div>
                <div class="sellCarBigText">
                    <span>Description</span>
                </div>
                <!--                <input class="form-control input-lg" id="description" type="text">-->
                <textarea class="form-control rounded-0" id="description" rows="12"></textarea>
            </div>
            <div class="col-12 d-flex justify-content-center mb-4">
                <input type="submit" value="Submit"
                       class="btn float-center carSellSubmitBtn">
            </div>
        </div>
    </div>
</div>
