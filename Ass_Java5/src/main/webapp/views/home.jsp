<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>

<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>--%>

    <link
            href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            rel="stylesheet" id="bootstrap-css">
    <script
            src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script
            src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
    <link
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            rel="stylesheet"
            integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
            crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet" type="text/css" />

</head>
<body>
<!--begin of menu-->
<jsp:include page="header.jsp"></jsp:include>

<!--end of menu-->
<div class="container">

<%--    <jsp:include page="danh_muc.jsp"></jsp:include>--%>
<%--    <div class="row">--%>
<%--        <div class="col">--%>
<%--            <nav aria-label="breadcrumb">--%>
<%--                <ol class="breadcrumb">--%>
<%--&lt;%&ndash;                    <li class="breadcrumb-item"><a href="home.jsp">Home</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <li class="breadcrumb-item"><a href="#">Category</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <li class="breadcrumb-item active" aria-current="#">Sub-category</li>&ndash;%&gt;--%>
<%--                </ol>--%>
<%--            </nav>--%>
<%--        </div>--%>
<%--    </div>--%>
</div>
<!--  -->
<div class="container text-center">
    <div class="row">
        <jsp:include page="body_left.jsp"></jsp:include>

        <jsp:include page="body_right.jsp"></jsp:include>
    </div>
</div>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

