<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Wy
  Date: 2019/11/11
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<rapid:override name="content">
    <div class="content-wrapper">
        <section class="content">
            <div class="row">
                <div class="col-md-5">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">
                                <c:choose>
                                    <c:when test="${statusMsg == 1}">
                                        添加用户
                                    </c:when>
                                    <c:otherwise>
                                        修改用户信息
                                    </c:otherwise>
                                </c:choose>
                            </h3>
                        </div>
                        <!-- /.box-header -->
                        <form class="form-horizontal" method="post" id="form-user">
                            <div class="box-body">
                                <c:if test="${userInfo.id != null}">
                                    <input id="user-id" name="id" value="${userInfo.id}" hidden>
                                </c:if>

                                <div class="form-group">
                                    <label for="userName" class="col-sm-2 control-label">用户名&nbsp;<span style="color: #FF5722; ">*</span></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入用户名" value="${userInfo.userName}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="nickName" class="col-sm-2 control-label">用户名&nbsp;<span style="color: #FF5722; ">*</span></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入昵称(默认为用户名)" value="${userInfo.nickName}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-sm-2 control-label">密码&nbsp;<span style="color: #FF5722; ">*</span></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码" value="${userInfo.password}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="email" class="col-sm-2 control-label">邮箱&nbsp;<span style="color: #FF5722; ">*</span></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱" value="${userInfo.email}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="url" class="col-sm-2 control-label">URL&nbsp;<span style="color: #FF5722; ">*</span></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="url" name="url" placeholder="请输入链接" value="${userInfo.url}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-lg" style="margin-left: 20%;" onclick="userForm();">
                                        <c:choose>
                                            <c:when test="${statusMsg == 1}">
                                                添加
                                            </c:when>
                                            <c:otherwise>
                                                修改
                                            </c:otherwise>
                                        </c:choose>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
                <div class="col-md-7">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户信息</h3>
                            <div class="box-tools">
                                <ul class="pagination pagination-sm no-margin pull-right">
                                    <li><a href="#">&laquo;</a></li>
                                    <c:forEach begin="1" end="${pageInfo.list.size()}" var="i">
                                        <li><a href="/category">${i}</a></li>
                                    </c:forEach>
                                    <li><a href="#">&raquo;</a></li>
                                </ul>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body no-padding">
                            <table class="table">
                                <tr class="text-center">
                                    <th style="width: 10px">ID</th>
                                    <th class="text-center">用户名</th>
                                    <th class="text-center">注册时间</th>
                                    <th class="text-center">身份</th>
                                    <th class="text-center">操作</th>
                                </tr>
                                <c:forEach items="${pageInfo.list}" var="user">
                                    <tr>
                                        <td>${user.id}</td>
                                        <td class="text-center">${user.userName}</td>
                                        <td class="text-center">
                                            <fmt:formatDate value="${user.registerTime}"
                                                            pattern="yyyy年MM月dd日 HH:mm"/>
                                        </td>
                                        <td class="text-center">
                                            <c:choose>
                                                <c:when test="${user.status == 1}">管理员</c:when>
                                                <c:otherwise>普通用户</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="text-center">
                                            <button type="button" class="btn bg-olive btn-xs" onclick='location.href="/user/edit/${user.id}"'>编辑</button>
                                            <button type="button" class="btn bg-olive btn-xs" onclick='location.href="/user/delete/${user.id}"'>删除</button>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->

                </div>
                <!-- /.col -->
            </div>
        </section>
    </div>
</rapid:override>
<%@ include file="../public/framework.jsp"%>