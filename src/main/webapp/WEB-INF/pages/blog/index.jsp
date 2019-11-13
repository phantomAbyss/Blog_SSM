<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<rapid:override name="top">
    <%@ include file="public/banner.jsp"%>
    <%@ include file="public/toppic.jsp"%>
</rapid:override>
<rapid:override name="main">
    <main>
        <div class="news_box">
            <ul>
                <li><i><a href="/"><img src="/images/1.jpg"></a></i>
                    <h3><a href="/">html5个人博客模板《simple》</a></h3>
                </li>
                <li><i><a href="/"><img src="/images/2.jpg"></a></i>
                    <h3><a href="/">html5古典个人博客模板《青砖屋檐》</a></h3>
                </li>
                <li><i><a href="/"><img src="/images/3.jpg"></a></i>
                    <h3><a href="/">第二届 优秀个人博客模板比赛参选活动</a></h3>
                </li>
                <li><i><a href="/"><img src="/images/4.jpg"></a></i>
                    <h3><a href="/">html5个人博客模板《More》</a></h3>
                </li>
                <li><i><a href="/"><img src="/images/5.jpg"></a></i>
                    <h3><a href="/">D设计师博客-一个热爱生活的设计师</a></h3>
                </li>
                <li><i><a href="/"><img src="/images/6.jpg"></a></i>
                    <h3><a href="/">个人博客用帝国cms 自定义页面 灵动标签调用网站所有信息</a></h3>
                </li>
            </ul>
        </div>
        <div class="pics">
            <ul>
                <li><i><a href="/news/life/2018-06-17/873.html" target="_blank"><img src="/images/p1.jpg"></a></i><span>安静地做一个爱设计的女子</span></li>
                <li><i><a href="/news/life/2018-04-27/816.html" target="_blank"><img src="/images/p2.jpg"></a></i><span>个人博客，属于我的小世界！（可以是广告）</span></li>
                <li><i><a href="/jstt/bj/2015-01-09/740.html" target="_blank"><img src="/images/p3.jpg"></a></i><span>【匆匆那些年】总结个人博客经历的这四年…</span></li>
            </ul>
        </div>
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
        <%@ include file="public/paging.jsp"%>
    </main>

</rapid:override>

<%@ include file="public/framework.jsp"%>

