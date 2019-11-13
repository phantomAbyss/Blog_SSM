<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ page contentType="text/html; charset=UTF-8" language="java"
    pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Cache-Control" content="max-age=72000"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<%--    上述三个meta标签必须放在前面，任何其他内容都放在后面--%>
    <meta name="applicable-device" content="pc,mobile">
    <meta name="MobileOptimized" content="width"/>
    <meta name="HandheldFriendly" content="true"/>
    <rapid:block name="description">
        <meta name="description" content="${options.optionMetaDescrption}"/>
    </rapid:block>
    <rapid:block name="keywords">
        <meta name="keywords" content="${options.optionMetaKeyword}"/>
    </rapid:block>
    <rapid:block name="title">
        <title>
                ${options.optionSiteTitle}-${options.optionSiteDescrption}
        </title>
    </rapid:block>

    <link rel="shortcut icon" href="/images/auicon.jpg">
    <link href="/css/base.css" rel="stylesheet">
    <link href="/css/m.css" rel="stylesheet">
    <link href="/css/info.css" rel="stylesheet">
    <link href="/css/index.css" rel="stylesheet">
    <link href="/css/time.css" rel="stylesheet">
    <script type="text/javascript" src="/js/scrollReveal.js"></script>
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js" ></script>
    <script type="text/javascript" src="/js/jquery.easyfader.min.js"></script>
    <script type="text/javascript" src="/js/hc-sticky.js"></script>
    <script type="text/javascript" src="/js/time.js"></script>
    <script typt="text/javascript" src="/js/comm.js"></script>
</head>
<body>
<%@ include file="header.jsp"%>
<article>
    <rapid:block name="top"></rapid:block>
    <rapid:block name="main"></rapid:block>
    <rapid:block name="aside">
        <%@ include file="aside.jsp"%>
    </rapid:block>
</article>
<%@ include file="footer.jsp"%>
<rapid:block name="script-code"></rapid:block>
</body>
<script type="text/javascript" src="/js/ajax.js"></script>
</html>
