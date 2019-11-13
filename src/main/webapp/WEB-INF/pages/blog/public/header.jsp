<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ page contentType="text/html; charset=UTF-8" language="java"
    pageEncoding="UTF-8" %>
<header class="header-navigation" id="header">
    <nav>
        <div class="logo"><a href="/">杨青个人博客</a></div>
        <h2 id="mnavh"><span class="navicon"></span></h2>
        <ul id="starlist">
            <li><a href="/">首页</a></li>
            <c:forEach items="${categoryList}" var="category">
                <c:if test="${category.categoryPid == 0}">
                    <li>
                        <a href="/category/${category.categoryId}">${category.categoryName}</a>
                        <c:if test="${category.childCategoryCount > 0}">
                            <ul class="sub">
                                <c:forEach items="${categoryList}" var="cate">
                                    <c:if test="${cate.categoryPid == category.categoryId}">
                                        <li><a href="/category/${cate.categoryId}">${cate.categoryName}</a> </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </c:if>
                    </li>
                </c:if>
            </c:forEach>
            <li><a href="/blog/time">时间轴</a> </li>
            <li><a href="/blog/about">关于我</a> </li>
        </ul>
        <div class="searchbox">
            <div id="search_bar" class="search_bar">
                <form  id="searchform" action="/blog/search" method="post" name="searchform">
                    <input class="input" placeholder="想搜点什么呢.." type="text" name="searchValue" id="keyboard">
                    <input type="hidden" name="show" value="title" />
                    <input type="hidden" name="tempid" value="1" />
                    <input type="hidden" name="tbname" value="news">
                    <input type="hidden" name="Submit" value="搜索" />
                    <p class="search_ico"> <span></span></p>
                </form>
            </div>
        </div>
    </nav>
</header>
<rapid:block name="breadcrumb"></rapid:block>
