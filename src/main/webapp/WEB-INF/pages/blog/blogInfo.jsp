<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ page contentType="text/html; charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<rapid:override name="title">
    ${blog.title}
</rapid:override>
<rapid:override name="main">
    <main>
        <div class="infosbox">
            <div class="newsview blogs">
                <h3 class="news_title">${blog.title}</h3>
                <div class="bloginfo" id="blogInfo" data-id="${blog.id}">
                    <ul>
                        <li class="author">作者：<a href="/">${blog.userInfo.userName}</a></li>
                        <c:forEach items="${blog.categoryList}" var="category">
                            <li class="lmname"><a href="/category/${category.categoryId}">${category.categoryName}</a></li>
                        </c:forEach>
                        <li class="timer">时间：
                            <fmt:formatDate value="${blog.blogTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></li>
                        <li class="view">${blog.viewCount}Views</li>
                        <li class="like"><i class="fa fa-fw fa-thumbs-up"></i>
                                ${blog.likeCount}</li>
                    </ul>
                </div>
                <div class="tags">
                    <c:forEach items="${blog.tagList}" var="tag">
                        <a href="/tag/${tag.tagId}" target="_blank">${tag.tagName}</a> &nbsp;
                    </c:forEach>
                </div>
                <div class="news_about"><strong>简介: </strong>${blog.blogDesc}</div>
                <div class="news_con">
                        ${blog.content}
                </div>
            </div>
            <div class="share">
                <p class="diggit"><a href="JavaScript:makeRequest('/e/public/digg/?classid=3&amp;id=19&amp;dotop=1&amp;doajax=1&amp;ajaxarea=diggnum','EchoReturnedText','GET','');"> 很赞哦！ </a>(<b id="diggnum"><script type="text/javascript" src="/e/public/ViewClick/?classid=2&id=20&down=5"></script>13</b>)</p>
            </div>
                <%--上一篇下一篇 start--%>
            <nav class="nav-single">
                <c:choose>
                    <c:when test="${preBlog!=null}">
                        <a href="/blog/${preBlog.id}" rel="next">
                            <span class="meta-nav">
                                <span class="post-nav">上一篇
                                 <i class="fa fa-angle-left"></i>
                                </span>
                                <br>${preBlog.title}
                            </span>
                        </a>
                    </c:when>
                    <c:otherwise>
                              <span class="meta-nav">
                                    <span class="post-nav">
                                        没有了<br>
                                    </span>已是第一篇文章
                                </span>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${afterBlog!=null}">
                        <a href="/blog/${afterBlog.id}" rel="next">
                            <span class="meta-nav">
                                <span class="post-nav">下一篇
                                 <i class="fa fa-angle-right"></i>
                                </span>
                                <br>${afterBlog.title}
                            </span>
                        </a>
                    </c:when>
                    <c:otherwise>
                            <span class="meta-nav">
                                <span class="post-nav">
                                    没有了<br>
                                </span>已是最后文章
                             </span>
                    </c:otherwise>
                </c:choose>

                <div class="clear"></div>
            </nav>
                <%--上一篇下一篇 end--%>

                <%--评论区域 start--%>
            <div class="scroll-comments"></div>
            <div id="comments" class="comments-area">
                <div id="respond" class="comment-respond">
                    <h3 id="reply-title" class="comment-reply-title"><span id="reply-title-word">发表评论</span>
                        <a rel="nofollow" id="cancel-comment-reply-link"
                           href="/article/${article.articleId}#respond"
                           style="">取消回复</a>
                    </h3>
                    <form id="comment_form" method="post">
                        <c:if test="${sessionScope.user!=null}">
                            <div class="user_avatar">
                                <img alt="言曌"
                                     src="${sessionScope.user.userAvatar}"
                                     class="avatar avatar-64 photo" height="64" width="64">
                                登录者：${sessionScope.user.userNickname}
                                <br> <a href="javascript:void(0)" onclick="logout()">登出</a>
                                <input type="hidden" name="commentRole" value="1">
                                <input type="hidden" name="commentAuthorName"
                                       value="${sessionScope.user.getUserNickname()}">
                                <input type="hidden" name="commentAuthorEmail"
                                       value="${sessionScope.user.getUserEmail()}">
                                <input type="hidden" name="commentAuthorUrl" value="${sessionScope.user.getUserUrl()}">
                            </div>
                        </c:if>
                        <p class="comment-form-comment">
                            <textarea id="comment" name="commentContent" rows="6" tabindex="1" placeholder="既然都来了，还是说点什么在走吧。。。" required ></textarea>
                        </p>
                        <div id="comment-author-info">
                            <input type="hidden" name="commentPid" value="0">
                            <input type="hidden" name="commentPname" value="">
                            <c:if test="${sessionScope.user == null}">
                                <input type="hidden" name="commentRole" value="0">
                                <p class="comment-form-author">
                                    <label for="author_name">
                                        昵称<span class="required">*</span>
                                    </label>
                                    <input type="text" name="commentAuthorName" id="author_name" class="" value=""
                                           tabindex="2" required>
                                </p>
                                <p class="comment-form-email">
                                    <label for="author_email">
                                        邮箱<span class="required">*</span>
                                    </label>
                                    <input type="email" name="commentAuthorEmail" id="author_email" class="" value=""
                                           tabindex="3" required>
                                </p>
                                <p class="comment-form-url">
                                    <label for="author_url">网址</label>
                                    <input type="url" name="commentAuthorUrl" id="author_url" class="" value=""
                                           tabindex="4">
                                </p>
                            </c:if>
                        </div>
                        <div class="clear"></div>
                        <p class="form-submit">
                            <input id="submit" name="submit" type="submit" tabindex="5" value="提交评论">
                            <input type="hidden" name="commentArticleId"
                                   value="${article.articleId}" id="article_id">
                            <input type="hidden" name="commentPid" id="comment_pid" value="0">
                        </p>
                    </form>
                </div>

                <ol class="comment-list">
                    <c:set var="floor" value="0"/>
                    <c:forEach items="${commentList}" var="c">
                        <c:if test="${c.commentPid == 0}">
                            <c:set var="floor" value="${floor + 1}"/>
                            <li class="comments-anchor">
                                <ul id="anchor-comment-${c.commentId}"></ul>
                            </li>
                            <li class="comment">
                                <div id="div-comment-${c.commentId}" class="comment-body">
                                    <div class="comment-author vcard">
                                        <img class="avatar" src="${c.commentAuthorAvatar}" alt="avatar"
                                             style="display: block;">
                                        <strong>${c.commentAuthorName} </strong>
                                        <c:if test="${c.commentRole == 1}">
                                            <i class="fa fa-black-tie" style="color: #c40000;"></i>
                                            <span class=""
                                                  style="margin-top: 2px!important;color: #c40000;font-size: 13px;;"><b>博主</b></span>
                                        </c:if>
                                        <span class="comment-meta commentmetadata">
                                            <span class="ua-info" style="display: inline;">
                                                <br>
                                                <span class="comment-aux">
                                                    <span class="reply">
                                                        <a rel="nofollow" class="comment-reply-link" href="#respond"
                                                           onclick="replyComment()">回复
                                                        </a>
                                                    </span>
                                                    <fmt:formatDate value="${c.commentCreateTime}"
                                                                    pattern="yyyy年MM月dd日 HH:mm:ss"/>&nbsp;
                                                    <c:if test="${sessionScope.user != null}">
                                                        <a href="javascript:void(0)"
                                                           onclick="deleteComment(${c.commentId})">删除</a>
                                                        <a class="comment-edit-link"
                                                           href="/admin/comment/edit/${c.commentId}"
                                                           target="_blank">编辑</a>
                                                    </c:if>
                                                    <span class="floor"> &nbsp;${floor}楼 </span>
                                                </span>
                                            </span>
                                        </span>
                                        <p>
                                            <c:if test="${c.commentPid!=0}">
                                                <span class="at">@ ${c.commentPname}</span>
                                            </c:if>
                                                ${c.commentContent}
                                        </p>
                                    </div>
                                </div>
                                <ul class="children">
                                    <c:set var="floor2" value="0"/>
                                    <c:forEach items="${commentList}" var="c2">
                                        <c:if test="${c.commentId == c2.commentPid}">
                                            <c:set var="floor2" value="${floor2+1}"/>
                                            <li class="comments-anchor">
                                                <ul id="anchor-comment-${c2.commentId}"></ul>
                                            </li>
                                            <li class="comment">
                                                <div id="div-comment-${c.commentId}" class="comment-body">
                                                    <div class="comment-author vcard">
                                                        <img class="avatar" src="${c2.commentAuthorAvatar}" alt="avatar"
                                                             style="display: block;">
                                                        <strong>${c2.commentAuthorName} </strong>
                                                        <c:if test="${c2.commentRole==1}">
                                                            <i class="fa fa-black-tie" style="color: #c40000;"></i>
                                                            <span class=""
                                                                  style="margin-top: 2px!important;color: #c40000;font-size: 13px;;"><b>博主</b></span>
                                                        </c:if>
                                                        <span class="comment-meta">
                                                    <span class="ua-info" style="display: inline;">
                                                    <br>
                                                    <span class="comment-aux">
                                                        <span class="reply">
                                                            <a rel="nofollow" class="comment-reply-link" href="#respond"
                                                               onclick="replyComment()">回复
                                                            </a>
                                                        </span>
                                                        <fmt:formatDate value="${c2.commentCreateTime}"
                                                                        pattern="yyyy年MM月dd日 HH:mm:ss"/>&nbsp;
                                                        <c:if test="${sessionScope.user != null}">
                                                            <a href="javascript:void(0)"
                                                               onclick="deleteComment(${c2.commentId})">删除</a>
                                                            <a class="comment-edit-link"
                                                               href="/admin/comment/edit/${c2.commentId}"
                                                               target="_blank">编辑</a>
                                                        </c:if>
                                                        <span class="floor"> &nbsp;${floor2}层 </span>
                                                    </span>
                                                </span>
                                                    </span>
                                                        <p>
                                                            <c:if test="${c2.commentPid!=0}">
                                                                <c:if test="${c2.commentPid!=0}">
                                                                    <span class="at">@ ${c2.commentPname}</span>
                                                                </c:if>
                                                                ${c2.commentContent}
                                                            </c:if>
                                                        </p>
                                                    </div>
                                                </div>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:if>
                    </c:forEach>
                </ol>
            </div>
                <%--评论框 end--%>
        </div>
    </main>

</rapid:override>
<rapid:override name="script-code">
<script type="text/javascript">
    $(document).ready(function () {
        if ($('#author_name').val() == '') {
            var author = localStorage.getItem("author");
            $("#author_name").val(author == 'undefined' ? '' : author);
        }
        if ($('#author_email').val() == '') {
            var email = localStorage.getItem("email");
            $("#author_email").val(email == 'undefined' ? '' : email);
        }
        if ($('#author_url').val() == '') {
            var url = localStorage.getItem("url");
            $("#author_url").val(url == 'undefined' ? '' : url);
        }
        var blogId = $(".bloginfo").attr("data-id");
        increaseViewCount(blogId);
    });
</script>
</rapid:override>
<%@ include file="public/framework.jsp"%>

