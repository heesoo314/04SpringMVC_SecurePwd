<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- MemberControl의 searchId 메소드를 통해	 mv에 데이터를 가지고 도착 --%>
<c:if test="${ chk }">
	<span class="success">${msg}</span>
</c:if>
	 
<c:if test ="${ !chk }">
	<span class="fail">${msg}</span>
</c:if>	 
	 