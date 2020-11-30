<%--
  Created by IntelliJ IDEA.
  User: anhnbt
  Date: 30/11/2020
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" scope="request" value="All Users"/>
<jsp:include page="../inc/header.jsp"></jsp:include>
<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold">${pageTitle} <a href="/users?act=add-new" class="btn btn-primary btn-sm">Add New</a></h6>
        </div>
        <div class="card-body">
        <c:choose>
            <c:when test="${users == null}">
                <div class="alert alert-info">No data.</div>
            </c:when>
            <c:otherwise>
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col" width="15%">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <th scope="row">${user.getId()}</th>
                            <td>${user.getName()}</td>
                            <td>${user.getPrice()}</td>
                            <td>
                                <a href="/users?act=show&id=${user.getId()}" class="btn btn-secondary mr-1" data-toggle="tooltip" data-placement="top" title="View"><i class="fas fa-eye"></i></a>
                                <a href="/users?act=edit&id=${user.getId()}" class="btn btn-info mr-1" data-toggle="tooltip" data-placement="top" title="Edit"><i class="fas fa-pen"></i></a>
                                <a href="/users?act=delete&id=${user.getId()}" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Delete"><i class="fas fa-trash"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div><!-- /.table-responsive -->
            </c:otherwise>
        </c:choose>
        </div><!-- /.card-body-->
    </div><!-- /.card -->
</div><!-- /.container-fluid -->
<jsp:include page="../inc/footer.jsp"></jsp:include>