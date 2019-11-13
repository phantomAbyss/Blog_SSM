<c:if test="${pageInfo.pages > 0}">
    <div class="pagelist">
        <a title="Total record">
            &nbsp;<b>${pageInfo.total}</b>
        </a>
        <c:choose>
            <c:when test="${pageInfo.pages <= 3}">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="${pageInfo.pages}"/>
            </c:when>
            <c:otherwise>
                <c:set var="begin" value="${pageInfo.pageNum - 1}"/>
                <c:set var="end" value="${pageInfo.pageNum + 2}"/>
                <c:if test="${begin < 2}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="3"/>
                </c:if>
                <c:if test="${end > pageInfo.pages}">
                    <c:set var="begin" value="${pageInfo.pages - 2}"/>
                    <c:set var="end" value="${pageInfo.pages}"/>
                </c:if>
            </c:otherwise>
        </c:choose>
<%--        上一页--%>
        <c:choose>
            <c:when test="${pageInfo.pageNum eq 1}">
<%--                如果当前为第一页，隐藏上一页的按钮--%>
            </c:when>
            <c:otherwise>
                <a href="/blog/time?pageNum=${pageInfo.pageNum - 1}">上一页</a>&nbsp;
            </c:otherwise>
        </c:choose>
<%--        显示第一页的页码--%>
        <c:if test="${begin >= 2}">
            <a href="/blog/time?pageNum=1">1</a>&nbsp;
        </c:if>
<%--        显示点点点--%>
        <c:if test="${begin > 2}">
            <span>...</span>
        </c:if>
<%--        打印页码--%>
        <c:forEach begin="${begin}" end="${end}" var="i">
            <c:choose>
                <c:when test="${i eq pageInfo.pageNum}">
                    &nbsp;&nbsp;&nbsp;<b>${i}</b>&nbsp;
                </c:when>
                <c:otherwise>
                    <a href="/blog/time?pageNum=${i}">${i}</a>&nbsp;
                </c:otherwise>
            </c:choose>
        </c:forEach>
            <%-- 显示点点点 --%>
        <c:if test="${end < pageInfo.pages-1}">
<%--            <span class="page-numbers dots">...</span>--%>
            <span>...</span>
        </c:if>
            <%-- 显示最后一页的数字 --%>
        <c:if test="${end < pageInfo.pages }">
            <a href="/blog/time?pageNum=${pageInfo.pages}">${pageInfo.pages}</a>
        </c:if>
            <%--下一页 --%>
        <c:choose>
            <c:when test="${pageInfo.pageNum eq pageInfo.pages }">
                <%--到了尾页隐藏，下一页按钮--%>
            </c:when>
            <c:otherwise>
                <a class="page-numbers" href="/blog/time?pageNum=${pageInfo.pageNum+1}">
                    <span class="fa fa-angle-right"></span>
                </a>
            </c:otherwise>
        </c:choose>
        <%--<a title="Total record">
            &nbsp;<b>${pageInfo.total}</b>
        </a>
        &nbsp;&nbsp;&nbsp;<b>1</b>&nbsp;
        <a href="/jstt/index_2.html">2</a>&nbsp;
        <a href="/jstt/index_3.html">3</a>&nbsp;
        <a href="/jstt/index_4.html">4</a>&nbsp;
        <a href="/jstt/index_5.html">5</a>&nbsp;
        <a href="/jstt/index_6.html">6</a>&nbsp;
        <a href="/jstt/index_2.html">下一页</a>&nbsp;
        <a href="/jstt/index_14.html">尾页</a>--%>
    </div>
</c:if>
