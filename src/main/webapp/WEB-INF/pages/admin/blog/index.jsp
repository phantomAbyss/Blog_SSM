<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Wy
  Date: 2019/10/27
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<rapid:override name="link-code">
    <link rel="stylesheet" href="/plugins/editormd/css/editormd.min.css">
    <!-- iCheck for checkboxes and radio inputs -->
    <link rel="stylesheet" href="/plugins/adminLTE/plugins/iCheck/all.css">
</rapid:override>
<rapid:override name="content">
    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                <a href="/admin/blog" style="color: #0a0a0a;">文章管理</a>
                <small>全部文章</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/admin"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="/admin/blog">文章管理</a></li>
                <li class="active">全部文章</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">文章列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm" placeholder="搜索">
                                <span class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </div>
                        <!--工具栏/-->

                        <!--数据列表-->
                        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="" style="padding-right:0px;">
                                    <input id="selall" type="checkbox" class="icheckbox_square-blue">
                                </th>
                                <th class="sorting_asc">文章标题</th>
                                <th class="sorting">分类</th>
                                <th class="sorting">标签</th>
                                <th class="sorting">状态</th>
                                <th class="sorting">发布时间</th>
                                <th class="sorting">作者</th>
                                <th class="text-center">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageInfo.list}" var="blog">
                                <tr>
                                    <td><input name="ids" type="checkbox" class="flat-red"></td>
                                    <td>
                                        <a href="/blog/${blog.id}?status=${blog.status}"> ${blog.title}</a>
                                    </td>
                                    <td>
                                        <c:forEach items="${blog.categoryList}" var="category">
                                            <small class="label pull-right bg-blue-active">${category.categoryName}</small>
                                        </c:forEach>
                                    </td>
                                    <td>
                                        <c:forEach items="${blog.tagList}" var="tag">
                                            <small class="label pull-right bg-blue-active">${tag.tagName}</small>
                                        </c:forEach>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${blog.status == 0}">
                                                <small class="label pull-right bg-blue-active">草稿</small>
                                            </c:when>
                                            <c:otherwise>
                                                <small class="label pull-right bg-blue-active">发布</small>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <fmt:formatDate value="${blog.blogTime}"
                                                        pattern="yyyy年MM月dd日 HH:mm:ss"/>&nbsp;
                                    </td>
                                    <td>${blog.userInfo.userName}</td>
                                    <td class="text-center">
                                        <button type="button" class="btn bg-olive btn-xs" onclick='location.href="/admin/edit/${blog.id}"'>编辑</button>
                                        <button type="button" class="btn bg-olive btn-xs" onclick='location.href="/admin/delete/${blog.id}"'>删除</button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <!--数据列表/-->

                    </div>
                    <!-- 数据表格 /-->


                </div>
                <!-- /.box-body -->

                <!-- .box-footer-->
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            总共2 页，共14 条数据。 每页
                            <select class="form-control">
                                <option>10</option>
                                <option>15</option>
                                <option>20</option>
                                <option>50</option>
                                <option>80</option>
                            </select> 条
                        </div>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <li>
                                <a href="#" aria-label="Previous">首页</a>
                            </li>
                            <li><a href="#">上一页</a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">下一页</a></li>
                            <li>
                                <a href="#" aria-label="Next">尾页</a>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /.box-footer-->


            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- 内容区域 /-->
</rapid:override>
<rapid:override name="script-code">
    <script type="text/javascript" src="/plugins/editormd/js/editormd.min.js"></script>
    <!-- iCheck 1.0.1 -->
    <script src="/plugins/adminLTE/plugins/iCheck/icheck.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //Flat red color scheme for iCheck
            $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
                checkboxClass: 'icheckbox_flat-blue',
                radioClass   : 'iradio_flat-green'
            });
            // 全选操作
            $("#selall").click(function() {
                var clicks = $(this).is(':checked');
                if (!clicks) {
                    $("td input[type='checkbox']").iCheck("uncheck");
                } else {
                    $("td input[type='checkbox']").iCheck("check");
                }
                $(this).data("clicks", !clicks);
            });
        });
    </script>
</rapid:override>
<%@ include file="../public/framework.jsp"%>
