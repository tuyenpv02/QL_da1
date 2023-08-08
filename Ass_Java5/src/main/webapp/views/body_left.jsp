<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${lstDongSP}" var="dsp">
                <li class="list-group-item text-white"><a href="/admin/dong-san-pham/${dsp.id}">${dsp.ten}</a></li>
            </c:forEach>

        </ul>
    </div>
</div>