<%--
  Created by IntelliJ IDEA.
  Description: 
  User: anyanglai
  Date: 2019/9/2
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span>user的id:</span><span>${uId}</span><br/>
<span>user的username:</span><span>${username}</span><br/>
<span>user的id:</span><span>${user.id}</span><br/>
<span>user的username:</span><span>${user.userName}</span><br/>
<span>user的creationDate:</span><span><fmt:formatDate value="${user.creationDate}" pattern="yyyy-MM-dd HH:mm:ss"/></span><br/>
<span>user的gender:</span><span>${user.gender}</span><br/>
<span>user的code:</span><span>${user.userCode}</span><br/>
<span>user的phone:</span><span>${user.phone}</span><br/>
</body>
</html>
