<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<a class="btn btn-primary" href="/admin">Home</a>

<div class="shopping-cart">
    <div class="px-4 px-lg-0">

        <div class="pb-5">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                        <h2>${sessionScope.valid}</h2>
                        <!-- Shopping cart table -->
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Đơn Giá</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Số Lượng</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Xóa</div>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listHDCT}" var="o">
                                    <tr>
                                        <th scope="row">
                                            <div class="p-2">
                                                ảnh ${o.chiTietSP.sanPham.ten}
                                                <img src="" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                <div class="ml-3 d-inline-block align-middle">
                                                    <h5 class="mb-0"><a href="#" class="text-dark d-inline-block"></a>
                                                    </h5><span class="text-muted font-weight-normal font-italic"></span>
                                                </div>
                                            </div>
                                        </th>
                                        <td class="align-middle"><strong>${o.donGia * o.soLuong}</strong></td>
                                        <td class="align-middle">
<%--                                            <a href="/admin/hoa-don-chi-tiet/update-cart/truSoLuong/${o.chiTietSP.id}&&${o.hoaDon.id}"">--%>
<%--                                            <button class="btnSub">-</button>--%>
<%--                                            </a>--%>
                                            <strong>${o.soLuong}</strong>
<%--                                            <a href="/admin/hoa-don-chi-tiet/update-cart/themSoLuong/${o.chiTietSP.id}&&${o.hoaDon.id}"">--%>
<%--                                            <button class="btnAdd">+</button>--%>
<%--                                            </a>--%>
                                        </td>
                                        <td class="align-middle"><a href="#" class="text-dark">
                                            <a href="/admin/hoa-don-chi-tiet/delete-cart/${o.chiTietSP.id}"
                                               class="btn btn-danger">Delete</a>
                                        </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- End -->
                    </div>
                </div>

                <div class="row py-5 p-4 bg-white rounded shadow-sm">
                    <div class="col-lg-6">
                        <c:if test="${ empty sessionScope.kh }">
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Hóa đơn</div>

                        <div class="p-4">
                            <div class="input-group mb-4 border rounded-pill p-2">
                                <%--                                <input type="text" placeholder="Nhập Voucher" aria-describedby="button-addon3" class="form-control border-0">--%>
                                <%--                                <div class="input-group-append border-0">--%>
                                <%--                                    <button id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill"><i class="fa fa-gift mr-2"></i>Sử dụng</button>--%>
                                <%--                                </div>--%>


                                <form action="/gio-hang/loc" method="get">
                                    <label>Trạng thái</label>
                                    <%--                                    <div class="col-12">--%>
                                    <%--                                        <select class="" name="sapXep">--%>
                                    <%--                                            <option selected value="tatCa">tất cả</option>--%>
                                    <%--                                            <option value="chua">Chưa thanh toán</option>--%>
                                    <%--                                            <option value="da">Đã thanh toán</option>--%>
                                    <%--                                            <option value="huy">Huỷe</option>--%>
                                    <%--                                        </select>--%>
                                    <%--                                        <button class="">lọc</button>--%>
                                    <%--                                    </div>--%>
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                        <label class="btn btn-secondary active">
                                            <input type="radio" name="trangThai" value="3"  autocomplete="off" checked>
                                            tất cả
                                        </label>
                                        <label class="btn btn-secondary">
                                            <input type="radio" name="trangThai" value="0" autocomplete="off"> chưa thanh toán
                                        </label>
                                        <label class="btn btn-secondary">
                                            <input type="radio" name="trangThai" value="1" autocomplete="off"> đã thanh toán
                                        </label>
                                        <label class="btn btn-secondary">
                                            <input type="radio" name="trangThai" value="2" autocomplete="off"> hủy
                                        </label>
                                    </div>
                                    <button class="btn btn-primary btn-sm">lọc</button>

                                </form>

                                        <a class="btn btn-primary btn-sm m-1 " href="admin/hoa-don/add-ma-moi">tạo hóa đơn</a>

                                <br>

                                <table class="table ">
                                    <thead class="table-primary">
                                    <tr>
                                        <th>stt</th>
                                        <th>mã</th>
                                        <th>tên khách hàng</th>
                                        <th>ngày tạo</th>
                                        <th>tình trạng</th>
                                        <th>action</th>
                                    </tr>


                                    </thead>
                                    <%int i = 0;%>
                                    <tbody>
                                    <c:forEach items="${lstHoaDon}" var="hd">
                                        <tr>
                                            <td><%= ++i%>
                                            </td>
                                            <td>${hd.ma}</td>
                                            <td>${hd.khachHang.ten}</td>
                                            <td>${hd.ngayTao}</td>
                                            <td>${hd.tinhTrang}</td>
                                            <td>
                                                <a href="/gio-hang/chonHD/${hd.id}" class="btn btn-primary">chọn</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    </c:if>
                    <div class="col-lg-6">
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
                        <div class="p-4">
                            <ul class="list-unstyled mb-4">
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong
                                        class="text-muted">Mã Hóa Đơn </strong>
                                    <strong>

                                        <input type="text" readonly
                                               value="${maHoaDon}"
                                        >
                                    </strong>
                                </li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong
                                        class="text-muted">ngày tạo</strong><strong> 1111 $</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong
                                        class="text-muted">Tổng tiền hàng</strong><strong> ${tongTien} $</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong
                                        class="text-muted">Tiền khách đưa</strong><strong> 00 $</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong
                                        class="text-muted">Tiền thừa</strong><strong> 00 $</strong></li>

                                <%--                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>--%>
                                <%--                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>10 $</strong></li>--%>
                                <%--                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>--%>
                                <h5 class="font-weight-bold">

                                    <%--                                        <c:if test="${tongTienHang >500}">--%>
                                    <%--                                            ${tongTienHang - (tongTienHang* 0.2)}--%>
                                    <%--                                        </c:if>--%>

                                    <%--                                        <c:if test="${tongTienHang <500}">--%>
                                    <%--                                            ${tongTienHang - (tongTienHang* 0.1)}--%>
                                    <%--                                        </c:if>--%>

                                    $</h5>
                                </li>
                            </ul>
                            <a href="/admin/hoa-don/thanh-toan-ma/${maHoaDon}"
                               class="btn btn-dark rounded-pill py-2 btn-block">Mua hàng</a>
                           <c:if test="${ not empty sessionScope.acc  }">
                               <a href="/admin/hoa-don/huy-ma/${maHoaDon}"
                                  class="btn btn-dark rounded-pill py-2 btn-block">Hủy</a>
                           </c:if>

                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<script>
    function loadHoaDon(trangThai) {
        var op = confirm("thay doi");
        if (op === true) {
            window.location.href = "/show-hd/" + trangThai;
        }
    }
</script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>

</html>
</html>