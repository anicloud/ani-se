<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <base href="<%=basePath%>">

    <title>AniSe - Anicloud</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="css/loading.css" type="text/css"></link>
    <style type="text/css">
        .x-ex-center-info {
            height: 120px;
            padding-left: 24px;
            padding-top: 20px;
            margin-left: 20px;
            background: none;
            font-size: 13px;
        }

        .x-ex-name {
            font-weight: bold;
        }

        .x-ex-text {
            color: red
        }
    </style>
</head>

<body>
<div class="x-me-loading" id="loadingWindow">
    <div class="x-me-loading-header">Exception Info</div>
    <div class="x-ex-center-info" id="xLoadInfo">
        <div>
            <span class="x-ex-name">Exception name</span>
            <span class="x-ex-text">${exceptionName }</span>

            <div>
                <div style="padding-top:5px;">
                    <span class="x-ex-name">Message</span>
                    <span class="x-ex-text">${message }</span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
