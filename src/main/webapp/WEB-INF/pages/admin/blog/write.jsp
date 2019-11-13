<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Wy
  Date: 2019/10/27
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<rapid:override name="link-code">
    <link rel="stylesheet" href="/plugins/editormd/css/editormd.min.css">
    <!-- iCheck for checkboxes and radio inputs -->
    <link rel="stylesheet" href="/plugins/adminLTE/plugins/iCheck/all.css">
</rapid:override>
<rapid:override name="content">
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Text Editors
                <small>Advanced form element</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Forms</a></li>
                <li class="active">Editors</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <form class="form-horizontal" method="post" id="form-blog">
                    <div class="box-body">
                        <c:if test="${blog.id != null}">
                            <input id="blog-id" name="id" value="${blog.id}" hidden>
                        </c:if>
                        <div class="form-group">
                            <label for="title" class="col-sm-1 control-label">标题&nbsp;<span style="color: #FF5722; ">*</span></label>

                            <div class="col-sm-11">
                                <input type="text" class="form-control" id="title" placeholder="给自己的博客来个标题..." name="title" value="${blog.title}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="content" class="col-sm-1 control-label">内容&nbsp;<span style="color: #FF5722; ">*</span></label>
                            <div class="col-md-11">
                                <div class="box">
                                    <div class="box-header">
                                        <div class="editormd" id="blog-editormd">
                                            <textarea class="editormd-markdown-textarea" id="content" name="content">${blog.content}</textarea>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">分类&nbsp;<span style="color: #FF5722; ">*</span></label>
                            <div class="col-sm-3">
                                <select class="form-control select2" style="width: 60%;">
                                    <option selected="selected">一级分类</option>
                                    <c:forEach items="${categoryList}" var="category">
                                        <c:if test="${category.categoryPid == 0}">
                                            <option value="${category.categoryId}">${category.categoryName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                            <label class="col-sm-1 control-label">二级分类&nbsp;<span style="color: #FF5722; ">*</span></label>
                            <div class="col-sm-7">
                                <select class="form-control select2" style="width: 20%;">
                                    <option selected="selected">二级分类</option>
                                    <c:forEach items="${categoryList}" var="category">
                                        <c:if test="${category.categoryPid == 0}">
                                            <option value="${category.categoryId}">${category.categoryName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group form-inline">
                            <label class="col-sm-1 control-label">分类&nbsp;<span style="color: #FF5722; ">*</span></label>
                            <div class="col-sm-11" style="padding-top: 3px;">
                                <c:forEach items="${tagList}" var="tag">
                                    <div class="checkbox">
                                        <label><input type="checkbox" class="flat-red" value="${tag.tagId}">&nbsp;&nbsp;${tag.tagName}</label>
                                    </div>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                </c:forEach>
                            </div>
                        </div>
                        <div class="form-group form-inline">
                            <label class="col-sm-1 control-label">状态&nbsp;<span style="color: #FF5722; ">*</span></label>
                            <div class="col-sm-11">
                                <div class="radio">
                                    <label class="radio-label"><input type="radio" name="status" class="flat-red" value="1">&nbsp;&nbsp;发布 </label>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <label class="radio-label"><input type="radio" name="status" class="flat-red" value="0" checked>&nbsp;&nbsp;草稿 </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-lg" style="margin-left: 8%;" onclick="blogForm();">Submit</button>
                            &nbsp;&nbsp;
                            <button type="reset" class="btn btn-default btn-lg" style="width: 8%;">重置</button>
                        </div>
                        <div class="form-group">
                            <div class="box" style="margin-left: 7%;">
                                <blockquote>
                                    温馨提示：<br>
                                    1、文章内容的数据表字段类型为MEDIUMTEXT,每篇文章内容请不要超过500万字 <br>
                                    2、写文章之前，请确保标签和分类存在，否则可以先新建；请勿刷新页面，博客不会自动保存 <br>
                                    3、插入代码前，可以点击 <a href="http://liuyanzhao.com/code-highlight.html" target="_blank">代码高亮</a>,将代码转成HTML格式
                                </blockquote>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="row">
                <!-- /.col-->
            </div>
            <!-- ./row -->
        </section>
        <!-- /.content -->
    </div>
</rapid:override>
<rapid:override name="script-code">
    <script type="text/javascript" src="/plugins/editormd/js/editormd.min.js"></script>
    <!-- iCheck 1.0.1 -->
    <script src="/plugins/adminLTE/plugins/iCheck/icheck.min.js"></script>
    <script type="text/javascript">
        $(function () {
            editormd("blog-editormd",{
                width: "100%",
                height: 400,
                syncScrolling: "single",
                path: "/plugins/editormd/lib/",
                toolbarIcons : function () {
                    return ["undo","redo","|","bold","del","italic","quote","ucwords","uppercase","lowercase",
                        "|","h1","h2","h3","h4","h5","h6","|","list-ul","list-ol","hr","|","link","reference-link",
                        "image","code","preformatted-text","code-block","table","datetime","emoji","html-entities","pagebreak","|",
                        "goto-line","watch","preview","fullscreen","clear","search","|","help","info"]
                }
            });
            //Flat red color scheme for iCheck
            $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
                checkboxClass: 'icheckbox_flat-blue',
                radioClass   : 'iradio_flat-green'
            });
        });
    </script>
</rapid:override>
<%@ include file="../public/framework.jsp"%>
