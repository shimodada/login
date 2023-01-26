<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ページ</title>
</head>
<body>
ここは管理者用のページです。<br>
<c:choose>
<c:when test="${account.role == 1 }">
登録内容の確認。
<p>ログインID：<c:out value="${account.loginId }"></c:out></p>
<p>パスワード：<c:out value="${account.pass }"></c:out></p>
<p>　　　名前：<c:out value="${account.name }"></c:out></p>
<p>　　ロール：管理者</p>
<p><a href="/sample"><button type="button" >ログアウト</button></a></p>
</c:when>
</c:choose>
</body>
</html>