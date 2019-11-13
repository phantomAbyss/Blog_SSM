<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java"
    pageEncoding="UTF-8" %>

<rapid:override name="description">
    <meta name="description" content="${category.categoryName}"/>
</rapid:override>

<rapid:override name="keywords">
    <meta name="keywords" content="${category.categoryName}"/>
</rapid:override>

<rapid:override name="title">
    <title>${category.categoryName}</title>
</rapid:override>

<rapid:override name="main">
    <main>
        <div class="blogtab">
            <ul id="blogtab">
                <li class="current">最新文章</li>
                <li><a href="list.html">心得笔记</a></li>
                <li><a href="list.html">CSS3|Html5</a></li>
                <li><a href="list.html">网站建设</a></li>
                <li><a href="list.html">文字标签</a></li>
                <li><a href="list.html">文字广告</a></li>
            </ul>
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
        </div>
    </main>
</rapid:override>

<%@ include file="public/framework.jsp"%>
