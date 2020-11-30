<%--
  Created by IntelliJ IDEA.
  User: anhnbt
  Date: 30/11/2020
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" scope="request" value="Add New User"/>
<jsp:include page="../inc/header.jsp"></jsp:include>
<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold">${pageTitle} <a href="/users?act=index" class="btn btn-primary btn-sm">All
                Users</a></h6>
        </div>
        <div class="card-body">
            <% if (session.getAttribute("msg") != null) { %>
            <div class="alert alert alert-success"><%=session.getAttribute("msg")%></div>
            <% session.removeAttribute("msg"); %>
            <% } %>
            <form action="/users" method="post">
                <input type="hidden" name="act" value="store">
                <div class="form-group row">
                    <label for="username" class="col-md-4 col-form-label text-md-right">Username <span
                            class="text-danger">*</span>:</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" name="username" id="username"
                               placeholder="Enter username">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="email" class="col-md-4 col-form-label text-md-right">Email address <span
                            class="text-danger">*</span>:</label>
                    <div class="col-md-6">
                        <input type="email" class="form-control" name="email" id="email" placeholder="Enter email" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="phone" class="col-md-4 col-form-label text-md-right">Phone number:</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" name="phone" id="phone"
                               placeholder="Enter phone number">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-md-4 col-form-label text-md-right">Gender</label>
                    <div class="col-md-6">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" name="gender" id="male" value="male" checked>
                            <label class="form-check-label" for="male">Male</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" name="gender" id="female" value="female">
                            <label class="form-check-label" for="female">Female</label>
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-md-4 col-form-label text-md-right">Password <span
                            class="text-danger">*</span></label>
                    <div class="col-md-6">
                        <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div><!-- /.card-body-->
    </div><!-- /.card -->
</div>
<!-- /.container-fluid -->
<jsp:include page="../inc/footer.jsp"></jsp:include>