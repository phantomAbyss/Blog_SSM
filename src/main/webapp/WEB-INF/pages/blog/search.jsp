<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<rapid:override name="breadcrumb">
    <nav class="breadcrumb">
        <div class="bull"><i class="fa fa-volume-up"></i></div>
        <div id="scrolldiv">
            <div class="scrolltext">
                <ul style="margin-top: 0px;">
                    <li class="scrolltext-title">
                        <a href="/notice/${id}" rel="bookmark">本站公告：测试</a>
                    </li>
                    <%--<c:forEach items="${noticeList}" var="n">
                        <li class="scrolltext-title">
                            <a href="/notice/${n.noticeId}" rel="bookmark">${n.noticeTitle}</a>
                        </li>
                    </c:forEach>--%>
                </ul>
            </div>
        </div>
    </nav>
</rapid:override>
<rapid:override name="blogtab">
    <c:forEach items="${pageInfo.list}" var="blog">
        <div class="blogs" data-scroll-reveal="enter bottom over 1s" >
            <h3 class="blogtitle"><a href="/blog/${blog.id}">${blog.title}</a></h3>
            <span class="blogpic"><a href="/" title=""><img src="/images/1.jpg" alt=""></a></span>
            <p class="blogtext">${blog.blogDesc}</p>
            <div class="bloginfo">
                <ul>
                    <li class="author"><a href="/">${blog.userInfo.userName}</a></li>
                    <c:forEach items="${blog.categoryList}" var="category">
                        <li class="lmname"><a href="/category/${category.categoryId}">${category.categoryName}</a></li>
                    </c:forEach>
                    <li class="timer">
                        <fmt:formatDate value="${blog.blogTime}"
                                        pattern="yyyy-MM-dd HH:mm:ss"/>
                    </li>
                    <li class="view"><span>${blog.viewCount}</span>已阅读</li>
                    <li class="like">${blog.likeCount}</li>
                </ul>
            </div>
        </div>
    </c:forEach>
</rapid:override>

<%@ include file="public/framework.jsp"%>