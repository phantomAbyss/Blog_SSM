<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<rapid:override name="main">
    <main>
        <div class="timebox">
            <ul>
                <c:forEach items="${pageInfo.list}" var="blog">
                    <li><span>
                    <fmt:formatDate value="${blog.blogTime}"
                                    pattern="yyyy-MM-dd"/>&nbsp;
                </span><i><a href="/blog/${blog.id}" target="_blank">${blog.title}</a></i></li>
                </c:forEach>
                <%--<li><span>2018-06-17</span><i><a href="/" target="_blank">安静地做一个爱设计的女子</a></i></li>
                <li><span>2018-04-27</span><i><a href="/" target="_blank">个人博客，属于我的小世界！</a></i></li>
                <li><span>2018-06-18</span><i><a href="/" target="_blank">个人博客，我为什么要用帝国cms？</a></i></li>
                <li><span>2018-04-27</span><i><a href="/" target="_blank">第二届 优秀个人博客模板比赛参选活动</a></i></li>
                <li><span>2018-06-18</span><i><a href="/" target="_blank">D设计师博客-一个热爱生活的设计师</a></i></li>
                <li><span>2018-06-17</span><i><a href="/" target="_blank">个人博客用帝国cms 自定义页面 灵动标签调用网站所有信息</a></i></li>
                <li><span>2018-04-27</span><i><a href="/" target="_blank">帝国cms 栏目高级调用 高亮并且二级栏目增加样式</a></i></li>
                <li><span>2018-06-18</span><i><a href="/" target="_blank">帝国cms 列表页调用子栏目，没有则不显示栏目名称</a></i></li>
                <li><span>2018-04-27</span><i><a href="/" target="_blank">个人博客模板《绅士》后台管理</a></i></li>
                <li><span>2018-06-18</span><i><a href="/" target="_blank">帝国cms 动态留言页，搜索页支持标签调用方法</a></i></li>
                <li><span>2018-04-27</span><i><a href="/" target="_blank">用js实现手机导航-优化版</a></i></li>
                <li><span>2018-06-18</span><i><a href="/" target="_blank">帝国cms使用灵动标签实现当前栏目高亮的方法</a></i></li>
                <li><span>2018-04-27</span><i><a href="/" target="_blank">帝国cms新闻系统增加图片集，并且列表模板调用所有小图实现方法</a></i></li>
                <li><span>2018-06-18</span><i><a href="/" target="_blank"> 帝国cms 首页或者列表页 实现图文不同样式调用方法</a></i></li>
                <li><span>2018-04-27</span><i><a href="/" target="_blank">别让这些闹心的套路，毁了你的网页设计</a></i></li>
                <li><span>2018-06-18</span><i><a href="/" target="_blank">帝国cms自动设置标题图片选用文章第一张图片</a></i></li>
                <li><span>2018-04-27</span><i><a href="/" target="_blank">html5个人博客模板《simple》</a></i></li>
                <li><span>2018-06-18</span><i><a href="/" target="_blank">html5古典个人博客模板《青砖屋檐》</a></i></li>--%>
            </ul>
        </div>
        <%@ include file="public/paging.jsp"%>
    </main>
</rapid:override>
<rapid:override name="script">
    <script type="text/javascript" src="/js/time.js"></script>
</rapid:override>
<%@ include file="public/framework.jsp"%>
