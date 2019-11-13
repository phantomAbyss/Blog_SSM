<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Wy
  Date: 2019/11/2
  Time: 10:15
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
                            <h3 class="box-title">添加标签</h3>
                        </div>
                        <!-- /.box-header -->
                        <form class="form-horizontal">
                            <input type="text" name="tagId" value="${tag.tagId}" hidden>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="tagName" class="col-sm-2 control-label">名称&nbsp;<span style="color: #FF5722; ">*</span></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="tagName" name="tagName" placeholder="请输入标签名称" value="${tag.tagName}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">父节点&nbsp;<span style="color: #FF5722; ">*</span></label>
                                    <div class="col-sm-10">
                                        <select class="form-control select2" style="font-size: 20px;height: 40px;">
                                            <option selected="selected">Alabama</option>
                                            <option>Alaska</option>
                                            <option>California</option>
                                            <option>Delaware</option>
                                            <option>Tennessee</option>
                                            <option>Texas</option>
                                            <option>Washington</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="tagDesc" class="col-sm-2 control-label">标签描述&nbsp;<span style="color: #FF5722; ">*</span></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="tagDesc" name="tagDesc" value="${category.categoryDesc}" placeholder="请输入标签描述">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="tagIcon" class="col-sm-2 control-label">图标样式&nbsp;</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="tagIcon" name="tagIcon" placeholder="请输入图标样式，如fa fa-coffee，未输入将会为您默认默认添加一个图标哟">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-lg" style="margin-left: 20%;">添加</button>
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
                            <h3 class="box-title">标签信息</h3>
                            <div class="box-tools">
                                <ul class="pagination pagination-sm no-margin pull-right">
                                    <li><a href="#">&laquo;</a></li>
                                    <c:forEach begin="1" end="${pageInfo.list.size()}" var="i">
                                        <li><a href="/tag">${i}</a></li>
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
                                    <th class="text-center">PID</th>
                                    <th class="text-center">标签名称</th>
                                    <th class="text-center">文章数量</th>
                                    <th class="text-center">操作</th>
                                </tr>
                                <c:forEach items="${pageInfo.list}" var="tag">
                                    <tr>
                                        <td>${tag.tagId}</td>
                                        <td class="text-center">${tag.tagId}</td>
                                        <td class="text-center">${tag.tagName}</td>
                                        <td class="text-center">12</td>
                                        <td class="text-center">
                                            <button type="button" class="btn bg-olive btn-xs" onclick='location.href="/admin/tag/edit/${tag.tagId}"'>编辑</button>
                                            <button type="button" class="btn bg-olive btn-xs" onclick='location.href="/admin/tag/delete/${tag.tagId}"'>删除</button>
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