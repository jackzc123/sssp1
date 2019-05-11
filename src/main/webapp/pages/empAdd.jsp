<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/12
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>EmpAdd</title>
</head>
<body>
<%
    String path = request.getContextPath();
    request.setAttribute("APP_PATH", path);
%>

    <form:form action="${APP_PATH}/emp" modelAttribute="employee" method="post">

        <c:if test="${employee.id == null}">
            lastName:<form:input path="lastName"></form:input><br>
        </c:if>
        <c:if test="${employee.id != null}">
            <form:hidden path="id"></form:hidden>
            <input type="hidden" name="_method" value="PUT"/>
        </c:if>
        age:<form:input path="age"></form:input><br>
        email:<form:input path="email"></form:input><br>
        birth:<form:input path="birth"></form:input><br>
        createTime:<form:input path="createTime"></form:input><br>
        departmentName:<form:select path="department.id" items="${depts}" itemValue="id" itemLabel="name"></form:select><br>
        <input type="submit" value="提交"/>
    </form:form>

</body>
</html>
